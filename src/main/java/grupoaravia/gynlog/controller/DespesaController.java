package grupoaravia.gynlog.controller;

import grupoaravia.gynlog.model.TipoDespesa;
import grupoaravia.gynlog.repository.ArquivoExcel_Despesa;
import grupoaravia.gynlog.repository.ArquivoTXT_Despesa;
import java.util.ArrayList;

/**
 *
 * @author Caio 4breu
 */

public class DespesaController {
    public ArrayList<TipoDespesa> listarTodos() {
        return ArquivoTXT_Despesa.lerArquivo();
    }

    public void sincronizar() {
        ArquivoTXT_Despesa.sincronizarComMovimento();
    }

    public void exportarExcel() {
        ArrayList<TipoDespesa> lista = ArquivoTXT_Despesa.lerArquivo();
        ArquivoExcel_Despesa.Transf_Excel(lista, "Despesas.xlsx");
    }
}