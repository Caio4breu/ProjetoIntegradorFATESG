package grupoaravia.gynlog.service;

import java.util.ArrayList;
import grupoaravia.gynlog.model.Veiculo;
import grupoaravia.gynlog.service.GerarRelatorios;
import grupoaravia.gynlog.repository.ArquivoTXT_Veiculo;

/**
 * Grupo Aravia
 *
 * @author <a href="https://github.com/Alexsanei">Alexsanei</a>
 * @author <a href="https://github.com/Caio4breu">Caio4breu</a>
 * @author <a href="https://github.com/Nomscodes">Nomscodes</a>
 * @author <a href="https://github.com/GabrielNaokiUT">GabrielNaokiUT</a>
 * @author <a href="https://github.com/wyllianmn">wyllianmn</a>
 */

public class relatorioVeiculosInativos extends GerarRelatorios { //classe filha que atraves do polimorfismo filtram os dados e formatam os dados//
    
    @Override
    protected ArrayList<String[]> buscarDados(String filtro) { //filtra os veiculos por inativos e formata os dados//
        ArrayList<String[]> resultado = new ArrayList<>();
        
        for (Veiculo v : ArquivoTXT_Veiculo.LerArquivo()) {
            
            if (!v.isStatus()) {
                
                resultado.add(new String[]{
                    String.valueOf(v.getIdVeiculo()), 
                    v.getPlaca(),
                    v.getMarca(),
                    v.getModelo(),
                    String.valueOf(v.getanoFabricacao()),
                    v.getStatusTextual() 
                });
            }
        }
        
        return resultado;
    }
}