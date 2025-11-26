package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Registro {
    private static final String nomeArquivo = "historicoUser.txt";
    private static final String arquivoVeiculo = "historicoVeiculo.txt";
    
    public static String lerArquivo() {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))){
            String linha;
            while((linha = br.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        } catch (IOException e) {
            conteudo.append("Nenhum histórico encontrado.\n");
        }
        return conteudo.toString();
    }
    
    public static void salvarLinha(String texto) {
        try  (FileWriter writer = new FileWriter(nomeArquivo, true)) { 
            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                writer.write("[" + dataHora + "]" + texto + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }
}
