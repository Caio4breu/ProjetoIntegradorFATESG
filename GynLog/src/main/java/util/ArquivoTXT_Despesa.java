package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.TipoDespesa;

public class ArquivoTXT_Despesa {
    private static final String arquivamento = "Despesas.txt";
    private static final String separador = " | ";

    public static void salvarLinha(TipoDespesa despesa) {
        try {
            File arquivo = new File(arquivamento);
            boolean arquivoVazio = !arquivo.exists() || arquivo.length() == 0;
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivamento, true))) {
                
                // Adiciona cabeçalho se arquivo vazio
                if (arquivoVazio) {
                    writer.write("ID Tipo Despesa | Descrição");
                    writer.newLine();
                }
                
                // Monta a linha da despesa
                StringBuilder Linha = new StringBuilder();
                Linha.append(despesa.getIdTipoDespesa()).append(separador);
                Linha.append(despesa.getDescricao());
                
                writer.write(Linha.toString());
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Erro ao salvar no arquivo Despesas.txt: " + e.getMessage(),
                "Erro de Gravação",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public static ArrayList<TipoDespesa> lerArquivo() {
        ArrayList<TipoDespesa> Lista = new ArrayList<>();
        File arquivo = new File(arquivamento);
        
        if (!arquivo.exists()) {
            return Lista;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(arquivamento))) {
            String Linha;
            boolean primeiraLinha = true;
            int numeroLinha = 0;
            
            while((Linha = br.readLine()) != null) {
                numeroLinha++;
                Linha = Linha.trim();
                
                // Pula linhas vazias
                if (Linha.isEmpty()) {
                    continue;
                }
                
                // Pula cabeçalho
                if (primeiraLinha) {
                    primeiraLinha = false;
                    if (Linha.startsWith("ID") || Linha.contains("Tipo")) {
                        continue;
                    }
                }
                
                String[] Partes = Linha.split("\\s*\\|\\s*");
                
                // Validação de formato
                if (Partes.length < 2) {
                    System.err.println("⚠ Linha " + numeroLinha + " inválida no Despesas.txt: " + Linha);
                    continue;
                }
                
                try {
                    int TpDesp = Integer.parseInt(Partes[0]);
                    String Desc = Partes[1];
                    TipoDespesa despesa = new TipoDespesa(TpDesp, Desc);
                    Lista.add(despesa);
                } catch (NumberFormatException e) {
                    System.err.println("Erro ao processar linha " + numeroLinha + ": " + Linha);
                    System.err.println("  Detalhes: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Erro na leitura do arquivo Despesas.txt: " + e.getMessage(),
                "Erro de Leitura",
                JOptionPane.ERROR_MESSAGE
            );
        }
        return Lista;
    }
}
