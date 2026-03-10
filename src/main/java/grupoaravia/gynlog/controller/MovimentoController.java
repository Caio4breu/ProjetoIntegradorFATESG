package grupoaravia.gynlog.controller;

import grupoaravia.gynlog.model.Movimento;
import grupoaravia.gynlog.repository.ArquivoExcel_Despesa;
import grupoaravia.gynlog.repository.ArquivoExcel_Movimento;
import grupoaravia.gynlog.repository.ArquivoTXT_Despesa;
import grupoaravia.gynlog.repository.ArquivoTXT_Movimento;
import java.util.ArrayList;

/**
 * Grupo Aravia
 *
 * @author <a href="https://github.com/Alexsanei">Alexsanei</a>
 * @author <a href="https://github.com/Caio4breu">Caio4breu</a>
 * @author <a href="https://github.com/Nomscodes">Nomscodes</a>
 * @author <a href="https://github.com/GabrielNaokiUT">GabrielNaokiUT</a>
 * @author <a href="https://github.com/wyllianmn">wyllianmn</a>
 */

public class MovimentoController {

    public void registrar(int idVeiculo, int idTipoDespesa, double valor, String descricao, String data) {

        // Validações básicas de campo
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("A descrição do movimento é obrigatória.");
        }
        if (data == null || data.isBlank()) {
            throw new IllegalArgumentException("A data do movimento é obrigatória.");
        }

        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do movimento deve ser maior que zero.");
        }

        if (idVeiculo <= 0) {
            throw new IllegalArgumentException("Selecione um veículo válido para o movimento.");
        }

        // Gera o ID do movimento com base na lista atual
        int proximoId = gerarProximoId();
        Movimento novoMovimento = new Movimento(proximoId, idVeiculo, idTipoDespesa, valor, descricao, data);

        // Persiste no TXT
        ArquivoTXT_Movimento.salvarLinha(novoMovimento);

        // Sincroniza Despesas.txt com os movimentos atualizados
        ArquivoTXT_Despesa.sincronizarComMovimento();

        // Sincroniza ambos os Excels
        ArrayList<Movimento> listaMovimentos = ArquivoTXT_Movimento.lerArquivo();
        ArquivoExcel_Movimento.Transf_Excel(listaMovimentos, "Movimento.xlsx");
        ArquivoExcel_Despesa.Transf_Excel(null, "Despesas.xlsx");
    }

    public ArrayList<Movimento> listarTodos() {
        return ArquivoTXT_Movimento.lerArquivo();
    }

    public ArrayList<Movimento> listarPorVeiculo(int idVeiculo) {
        ArrayList<Movimento> todos = ArquivoTXT_Movimento.lerArquivo();
        ArrayList<Movimento> filtrados = new ArrayList<>();

        for (Movimento m : todos) {
            if (m.getIdVeiculo() == idVeiculo) {
                filtrados.add(m);
            }
        }
        return filtrados;
    }

    private int gerarProximoId() {
        ArrayList<Movimento> lista = ArquivoTXT_Movimento.lerArquivo();
        if (lista.isEmpty()) return 1;

        int maiorId = 0;
        for (Movimento m : lista) {
            if (m.getIdMovimento() > maiorId) {
                maiorId = m.getIdMovimento();
            }
        }
        return maiorId + 1;
    }
}