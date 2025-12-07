package util;

/**
 * @author Gabriel
 */

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public abstract class GerarRelatorios {

    protected abstract ArrayList<String[]> buscarDados(String filtro);

    public void gerarRelatorio(String titulo, String[] colunas, String filtro) {
        
        ArrayList<String[]> dados = buscarDados(filtro);

        if (dados == null || dados.isEmpty() || (dados.size() == 1 && dados.get(0).length > 0 && dados.get(0)[0].equals("---"))) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado com o filtro: " + filtro, "Relatório Vazio", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Object[] opcoes = {"Arquivo Texto (.txt)", "Planilha Excel (.xlsx)"};
        int escolha = JOptionPane.showOptionDialog(null,
                "Como deseja salvar o relatório: '" + titulo + "'?",
                "Exportar Relatório",
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, opcoes, opcoes[0] 
        );

        if (escolha == 0) {
            gerarTxt(titulo, colunas, dados);
        } 
        else{ 
            if (escolha == 1) {
            gerarExcel(titulo, colunas, dados);
            }
        }
    }

    private void gerarTxt(String titulo, String[] colunas, ArrayList<String[]> dados) {
        String nomeArquivo = "Relatorio_" + titulo.replace(" ", "_").replace("/", "-") + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("=== SISTEMA GYNLOG - " + titulo.toUpperCase() + " ===");
            writer.newLine();
            writer.write("Data de geração: " + java.time.LocalDate.now());
            writer.newLine();
            writer.write("--------------------------------------------------------------------------------");
            writer.newLine();
            
            for (String col : colunas) {
                writer.write(String.format("%-25s", col));
            }
            writer.newLine();
            writer.write("--------------------------------------------------------------------------------");
            writer.newLine();
            
            for (String[] linha : dados) {
                for (String valor : linha) {
                    writer.write(String.format("%-25s", valor));
                }
                writer.newLine();
            }
            
            JOptionPane.showMessageDialog(null, "Relatório TXT salvo com sucesso:\n" + nomeArquivo, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
        } 
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gravar TXT: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void gerarExcel(String titulo, String[] colunas, ArrayList<String[]> dados) {
        String nomeArquivo = "Relatorio_" + titulo.replace(" ", "_").replace("/", "-") + ".xlsx";
        try (Workbook wb = new XSSFWorkbook()) {
            Sheet sheet = wb.createSheet("Dados");
            
            Row header = sheet.createRow(0);
            for (int i = 0; i < colunas.length; i++) {
                header.createCell(i).setCellValue(colunas[i]);
            }
            
            int numLinha = 1;
            for (String[] registro : dados) {
                Row row = sheet.createRow(numLinha++);
                for (int i = 0; i < registro.length; i++) {
                    String valor = registro[i];
                    try {
                        if (valor.contains("R$")) {
                            double v = Double.parseDouble(valor.replace("R$", "").replace(",", ".").trim());
                            row.createCell(i).setCellValue(v);
                        } 
                        else{
                            if (i == 0 && valor.matches("\\d+")) { 
                                row.createCell(i).setCellValue(Integer.parseInt(valor));
                                } 
                                else {
                                    row.createCell(i).setCellValue(valor);
                                }
                        }
                    } 
                    catch (Exception e) {
                        row.createCell(i).setCellValue(valor);
                    }
                }
            }
            
            for (int i = 0; i < colunas.length; i++) {
                sheet.autoSizeColumn(i);
            }
            
            try (FileOutputStream fos = new FileOutputStream(nomeArquivo)) {
                wb.write(fos);
            }
            
            JOptionPane.showMessageDialog(null, "Planilha Excel gerada com sucesso:\n" + nomeArquivo, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar Excel: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}


