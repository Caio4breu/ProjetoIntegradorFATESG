package grupoaravia.gynlog.service;

import java.util.ArrayList;
import grupoaravia.gynlog.model.Movimento;
import grupoaravia.gynlog.service.GerarRelatorios;
import grupoaravia.gynlog.repository.ArquivoTXT_Movimento;

/**
 * Grupo Aravia
 *
 * @author <a href="https://github.com/Alexsanei">Alexsanei</a>
 * @author <a href="https://github.com/Caio4breu">Caio4breu</a>
 * @author <a href="https://github.com/Nomscodes">Nomscodes</a>
 * @author <a href="https://github.com/GabrielNaokiUT">GabrielNaokiUT</a>
 * @author <a href="https://github.com/wyllianmn">wyllianmn</a>
 */

public class relatorioIPVATotalAnualFrota extends GerarRelatorios { //classe filha que atraves do polimorfismo filtram os dados e formatam os dados//
    
    @Override
    protected ArrayList<String[]> buscarDados(String filtro) { //filtra por ano e formata os dados//
        ArrayList<String[]> resultado = new ArrayList<>();
        double totalGeralIPVA = 0.0;
        
        for (Movimento m : ArquivoTXT_Movimento.lerArquivo()) {
            String desc = m.getDescricao().toLowerCase();
            String data = m.getData();
            
            if (data.endsWith(filtro) && desc.contains("ipva")) { //condição para ano e ipva
                
                double valor = m.getValor();
                
                resultado.add(new String[]{
                    String.valueOf(m.getIdVeiculo()), 
                    "R$ " + String.format("%.2f", valor) 
                });
                
                totalGeralIPVA += valor;
            }
        }
        
        if (!resultado.isEmpty()) {
            
            resultado.add(new String[]{"---", "---"});
          
            resultado.add(new String[]{"TOTAL GERAL DE IPVA DA FROTA NO ANO:", "R$ " + String.format("%.2f", totalGeralIPVA)});
        }
        
        return resultado;
    }
}