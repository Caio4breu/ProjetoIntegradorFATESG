package grupoaravia.gynlog.controller;

import grupoaravia.gynlog.service.relatorioDespesaTotalFrota;
import grupoaravia.gynlog.service.relatorioDespesasVeiculo;
import grupoaravia.gynlog.service.relatorioGastoMensalCombustivelTotalFrota;
import grupoaravia.gynlog.service.relatorioIPVATotalAnualFrota;
import grupoaravia.gynlog.service.relatorioTotalMultasVeiculo;
import grupoaravia.gynlog.service.relatorioVeiculosInativos;

/**
 *
 * @author Caio 4breu
 */

public class RelatorioController {

    public void gerarDespesasVeiculo(String idVeiculo) {
        if (idVeiculo == null || !idVeiculo.matches("^\\d{6}$")) {
            throw new IllegalArgumentException(
                "Digite apenas o ID do veículo com 6 dígitos para gerar o relatório (ex: 100001)."
            );
        }

        new relatorioDespesasVeiculo().gerarRelatorio(
            "Movimentações Gerais do Veículo ID " + idVeiculo,
            new String[]{"Data", "Descrição", "Tipo Despesa", "Valor (R$)"},
            idVeiculo
        );
    }

    public void gerarDespesaMensalFrota(String mesAno) {
        validarFormatoMesAno(mesAno);

        new relatorioDespesaTotalFrota().gerarRelatorio(
            "Despesa Mensal da Frota (" + mesAno + ")",
            new String[]{"ID Veículo", "Placa", "Total Custo (R$)"},
            mesAno
        );
    }

    public void gerarGastoCombustivelMensal(String mesAno) {
        validarFormatoMesAno(mesAno);

        new relatorioGastoMensalCombustivelTotalFrota().gerarRelatorio(
            "Custo Mensal de Combustível da Frota (" + mesAno + ")",
            new String[]{"ID Veículo", "Data", "Custo (R$)"},
            mesAno
        );
    }

    public void gerarTotalMultasVeiculo(String idVeiculoAno) {
        if (idVeiculoAno == null || !idVeiculoAno.matches("^\\d{6}/\\d{4}$")) {
            throw new IllegalArgumentException(
                "Digite o ID do veículo e o ano no formato correto (ex: 100001/2024)."
            );
        }

        String[] partes = idVeiculoAno.split("/");
        String idVeiculo = partes[0].trim();
        String ano = partes[1].trim();

        new relatorioTotalMultasVeiculo().gerarRelatorio(
            "Multas Anuais do Veículo " + idVeiculo + " (" + ano + ")",
            new String[]{"Data", "Valor (R$)", "Descrição"},
            idVeiculoAno
        );
    }

    public void gerarIPVATotalAnual(String ano) {
        if (ano == null || !ano.matches("\\d{4}")) {
            throw new IllegalArgumentException(
                "Digite o ano com 4 dígitos para gerar o relatório de IPVA (ex: 2024)."
            );
        }

        int anoInt = Integer.parseInt(ano);
        if (anoInt > 2024) {
            throw new IllegalArgumentException(
                "O ano máximo permitido para relatórios de IPVA é 2024."
            );
        }

        new relatorioIPVATotalAnualFrota().gerarRelatorio(
            "IPVA Detalhado da Frota no Ano (" + ano + ")",
            new String[]{"ID Veículo", "Valor (R$)"},
            ano
        );
    }

    public void gerarVeiculosInativos() {
        new relatorioVeiculosInativos().gerarRelatorio(
            "Lista de Veículos Inativos da Frota",
            new String[]{"ID Veículo", "Placa", "Marca", "Modelo", "Ano", "Status"},
            ""
        );
    }

    private void validarFormatoMesAno(String mesAno) {
        if (mesAno == null || !mesAno.matches("\\d{1,2}/\\d{4}")) {
            throw new IllegalArgumentException(
                "Digite o Mês/Ano no formato correto (ex: 11/2025)."
            );
        }

        String[] partes = mesAno.split("/");
        int mes = Integer.parseInt(partes[0]);
        int ano = Integer.parseInt(partes[1]);

        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("O mês deve ser um valor entre 01 e 12.");
        }

        if (ano > 2025 || (ano == 2025 && mes > 11)) {
            throw new IllegalArgumentException(
                "A data máxima permitida é Novembro de 2025 (11/2025)."
            );
        }
    }
}