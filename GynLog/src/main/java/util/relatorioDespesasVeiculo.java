package util;

/**
 *
 * @author Gabriel
 */

import java.util.ArrayList;
import model.Movimento;
import model.TipoDespesa;
import util.ArquivoTXT_Movimento; // Importa sua classe de leitura de arquivo!
import util.GerarRelatorios; // Importa a classe base


public class relatorioDespesasVeiculo extends GerarRelatorios {
    

    private String buscarDescricaoDespesa(int idTipoDespesa, ArrayList<TipoDespesa> listaDespesas) {
        for (TipoDespesa td : listaDespesas) {
            if (td.getIdTipoDespesa() == idTipoDespesa) {
                return td.getDescricao();
            }
        }
        return "Desconhecido"; 
    }
    
    
    @Override
    protected ArrayList<String[]> buscarDados(String filtro) {
        
        ArrayList<String[]> dadosFiltrados = new ArrayList<>();
        int idVeiculoDesejado;
        
        try {
            idVeiculoDesejado = Integer.parseInt(filtro);
        } 
        catch (NumberFormatException e) {
            System.err.println("Erro: O filtro não é um ID de veículo válido (deve ser um número).");
            return dadosFiltrados; 
        }
        
        ArrayList<Movimento> listaMovimentos = ArquivoTXT_Movimento.lerArquivo();
        ArrayList<TipoDespesa> listaDespesas = ArquivoTXT_Despesa.lerArquivo();
        
        
        for (Movimento mov : listaMovimentos) {
            
            if (mov.getIdMovimento() == idVeiculoDesejado) {
               
                String tipoDespesaDesc = buscarDescricaoDespesa(mov.getIdTipoDespesa(), listaDespesas);
                
                String valorFormatado = String.format("%.2f", mov.getValor()).replace('.', ',');
                
                String[] linha = new String[]{
                    mov.getData(),              
                    mov.getDescricao(),         
                    tipoDespesaDesc,            
                    valorFormatado              
                };
                
                dadosFiltrados.add(linha);
            }
        }
        
        return dadosFiltrados;
    }
}