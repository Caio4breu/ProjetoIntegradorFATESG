package grupoaravia.gynlog.controller;

import grupoaravia.gynlog.model.TipoDespesa;
import grupoaravia.gynlog.repository.ArquivoExcel_Despesa;
import grupoaravia.gynlog.repository.ArquivoTXT_Despesa;
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