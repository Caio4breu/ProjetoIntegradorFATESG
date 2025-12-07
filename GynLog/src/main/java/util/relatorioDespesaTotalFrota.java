package util;

/**
 * @author Gabriel
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Movimento;
import model.Veiculo; 
import util.ArquivoTXT_Movimento;
import util.ArquivoTXT_Veiculo; 
import util.GerarRelatorios;

public class relatorioDespesaTotalFrota extends GerarRelatorios {
    
    @Override
    protected ArrayList<String[]> buscarDados(String filtro) {
        
        Map<Integer, Double> totaisPorVeiculo = new HashMap<>();
       
        Map<Integer, Veiculo> veiculosMap = new HashMap<>();
        double totalGeralFrota = 0;
        
        for (Veiculo v : ArquivoTXT_Veiculo.LerArquivo()) {
            veiculosMap.put(v.getIdVeiculo(), v);
        }
        
        for (Movimento m : ArquivoTXT_Movimento.lerArquivo()) {
            int idVeiculo = m.getIdVeiculo();
            double valor = m.getValor();
                
            totaisPorVeiculo.put(idVeiculo, totaisPorVeiculo.getOrDefault(idVeiculo, 0.0) + valor);
            totalGeralFrota += valor;
        }
        
        ArrayList<String[]> resultado = new ArrayList<>();
        
        if (!totaisPorVeiculo.isEmpty()) {
            
            for (Map.Entry<Integer, Double> entry : totaisPorVeiculo.entrySet()) {
                int idVeiculo = entry.getKey();
                double totalVeiculo = entry.getValue();
                
                Veiculo v = veiculosMap.get(idVeiculo);
       
                String placa = (v != null) ? v.getPlaca() : "ID Não Encontrado";
                
                resultado.add(new String[]{
                    String.valueOf(idVeiculo), 
                    placa, 
                    "R$ " + String.format("%.2f", totalVeiculo)
                });
            }
            
            resultado.add(new String[]{"---", "---", "---"});
            resultado.add(new String[]{"", "TOTAL GERAL DA FROTA:", "R$ " + String.format("%.2f", totalGeralFrota)});
        }
        
        return resultado;
    }
}