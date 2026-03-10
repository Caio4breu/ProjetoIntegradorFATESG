package grupoaravia.gynlog.controller;

import grupoaravia.gynlog.model.Veiculo;
import grupoaravia.gynlog.repository.ArquivoExcel_Veiculo;
import grupoaravia.gynlog.repository.ArquivoTXT_Veiculo;
import java.util.ArrayList;

/**
 *
 * @author Caio 4breu
 */
public class VeiculoController {

    
    public void cadastrar(String placa, String marca, String modelo, int anoFabricacao, boolean disponivel) {

        // Validações básicas de campo
        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException("A placa do veículo é obrigatória.");
        }
        if (marca == null || marca.isBlank()) {
            throw new IllegalArgumentException("A marca do veículo é obrigatória.");
        }
        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("O modelo do veículo é obrigatório.");
        }

        // Validação de formato da placa (Mercosul ou placa cinza)
        String placaNormalizada = placa.replaceAll("[^A-Za-z0-9]", "").toUpperCase();
        if (!isPlacaValida(placaNormalizada)) {
            throw new IllegalArgumentException(
                "Placa inválida. Padrão esperado: Mercosul (ABC1D23) ou placa cinza (ABC1234)."
            );
        }

        // Regra de negócio: placa duplicada
        if (ArquivoTXT_Veiculo.placaJaExiste(placaNormalizada)) {
            throw new IllegalArgumentException(
                "Já existe um veículo com a placa: " + placaNormalizada
            );
        }

        // Regra de negócio: ano de fabricação inválido
        int anoAtual = java.time.Year.now().getValue();
        if (anoFabricacao < 1886 || anoFabricacao > anoAtual + 1) {
            throw new IllegalArgumentException(
                "Ano de fabricação inválido. Aceito entre 1886 e " + (anoAtual + 1) + "."
            );
        }

        // Gera ID automático e cria o objeto
        int idGerado = ArquivoTXT_Veiculo.gerarProximoId();
        Veiculo novoVeiculo = new Veiculo(idGerado, placaNormalizada, marca, modelo, anoFabricacao, disponivel);

        // Persiste no TXT e sincroniza o Excel
        ArquivoTXT_Veiculo.salvarLinha(novoVeiculo);
        ArrayList<Veiculo> listaAtualizada = ArquivoTXT_Veiculo.LerArquivo();
        ArquivoExcel_Veiculo.Transf_Excel(listaAtualizada, "Veiculo.xlsx");
    }

    public ArrayList<Veiculo> listarTodos() {
        return ArquivoTXT_Veiculo.LerArquivo();
    }

    public void atualizarLista(ArrayList<Veiculo> lista) {
        if (lista == null) {
            throw new IllegalArgumentException("Lista de veículos não pode ser nula.");
        }
        ArquivoTXT_Veiculo.AtualizarTxtExcel(lista);
        ArquivoExcel_Veiculo.Transf_Excel(lista, "Veiculo.xlsx");
    }

    public boolean placaJaExiste(String placa) {
        if (placa == null || placa.isBlank()) return false;
        return ArquivoTXT_Veiculo.placaJaExiste(placa.toUpperCase());
    }

    /**
     * Retorna o próximo ID disponível para um novo veículo.
     */
    public int gerarProximoId() {
        return ArquivoTXT_Veiculo.gerarProximoId();
    }

    private boolean isPlacaValida(String placa) {
        // Mercosul: ABC1D23 | Placa cinza: ABC1234
        String regex = "^[A-Z]{3}[0-9][A-Z0-9][0-9]{2}$";
        return placa.matches(regex);
    }
}