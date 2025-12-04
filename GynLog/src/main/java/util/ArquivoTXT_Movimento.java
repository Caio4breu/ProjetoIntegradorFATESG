package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Movimento;

public class ArquivoTXT_Movimento {
    private static final String arquivamento = "Financeiro.txt";
    private static final String separador = " | ";
    
    public static void salvarLinha(Movimento movimento) {
        try {
            File arquivo = new File(arquivamento);
            boolean arquivoVazio = !arquivo.exists() || arquivo.length() == 0;
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivamento, true))) {
                
                // Adiciona cabeçalho se arquivo estiver vazio
                if (arquivoVazio) {
                    writer.write("ID Movimento | ID Veículo | ID Tipo Despesa | Valor | Descrição | Data");
                    writer.newLine();
                }
                
                // Monta a linha no registro
                StringBuilder Linha = new StringBuilder();
                Linha.append(movimento.getIdMovimento()).append(separador);
                Linha.append(movimento.GetIdVeiculo()).append(separador);
                Linha.append(movimento.getIdTipoDespesa()).append(separador);
                Linha.append(String.format("%.2f", movimento.GetValor())).append(separador);
                Linha.append(movimento.getDescricao()).append(separador);
                Linha.append(movimento.GetData());
                
                writer.write(Linha.toString());
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Erro ao salvar no arquivo Financeiro.txt: " + e.getMessage(),
                "Erro de Gravação",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public static ArrayList<Movimento> lerArquivo() {
        ArrayList<Movimento> Lista = new ArrayList<>();
        File arquivo = new File(arquivamento);
        
        if (!arquivo.exists()) {
            return Lista;
        }
        
        try(BufferedReader br = new BufferedReader(new FileReader(arquivamento))){
            String Linha;
            boolean primeiraLinha = true;
            int numeroLinha = 0;
            
            while((Linha = br.readLine()) != null) {
                numeroLinha++;
                Linha = Linha.trim();
                
                if (Linha.isEmpty()) {
                    continue;
                }
                
                if (primeiraLinha) {
                    continue;
                }
                
                if (primeiraLinha) {
                    primeiraLinha = false;
                    if (Linha.startsWith("ID") || Linha.contains("Movimento")) {
                        continue;
                    }
                }
                
                String[] Partes = Linha.split("\\s*\\|\\s*");
                
                // Validação de formato
                if (Partes.length < 6) {
                    System.err.println("Linha " + numeroLinha + " inválida no Financeiro.txt: " + Linha);
                    continue;
                }
                
                try {
                    int idMovi = Integer.parseInt(Partes[0]);
                    int idVEIC = Integer.parseInt(Partes[1]);
                    int idTipoDES = Integer.parseInt(Partes[2]);
                    double custo = Double.parseDouble(Partes[3].replace(",","."));
                    String Desc = Partes[4];
                    String dataRegist = Partes[5];
                    Movimento movimento = new Movimento(idMovi, idVEIC, idTipoDES, custo, Desc, dataRegist);
                    Lista.add(movimento);
                } catch (NumberFormatException e) {
                    System.err.println("⚠ Erro ao processar linha " + numeroLinha + ": " + Linha);
                    System.err.println("  Detalhes: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Erro na leitura do arquivo Financeiro.txt: " + e.getMessage(),
                "Erro de Leitura",
                JOptionPane.ERROR_MESSAGE
            );
        }
        
        return Lista;
    }
}
