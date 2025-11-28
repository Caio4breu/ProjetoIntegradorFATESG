package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author wylli
 */
public class Arquivo {
    private static final  String ArquivoDespesa = "movimentaçao.txt";
    

    public static void salvarLinha(String texto){
        try(FileWriter writer = new FileWriter(ArquivoDespesa , true)){
            String dataHora = "===================================================================================================";
               writer.write("[" + dataHora + "]" + texto + "\n");
        }
        catch(IOException e){
            System.out.println("Erro ao salvar no arquivo" + e.getMessage());
        }
    }
    
    
    public static String lerArquivo(){
        StringBuilder conteudo = new StringBuilder();
        try(BufferedReader br = new BufferedReader (new FileReader(ArquivoDespesa))){
            String linha;
            while((linha = br.readLine()) != null){
                conteudo.append(linha).append("\n");
            }
        }
        catch(IOException e){
            conteudo.append("nenhum historico encontrado.\n");        
        }
        return conteudo.toString();
    }
}
