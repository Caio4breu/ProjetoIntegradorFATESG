package util;

import java.io.FileInputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.TipoDespesa;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ArquivoExcel_Despesa {
    public static void Transf_Excel(ArrayList<TipoDespesa> Lista, String Caminho) {
        try (Workbook wb = new XSSFWorkbook()) {
            Sheet sheet = wb.createSheet("Despesa");
            Caminho = ("Despesas.xlsx");
            
            Row header = sheet.createRow(0);
            
            header.createCell(0).setCellValue("ID da Movimentação");
            header.createCell(1).setCellValue("Descrição");
            
            int NumLinha = 1;
            
            for (TipoDespesa despesa : Lista) {
                Row row = sheet.createRow(NumLinha++);
                
                row.createCell(0).setCellValue(despesa.getIdTipoDespesa());
                row.createCell(1).setCellValue(despesa.getDescricao());
            }
            
            for (int i = 0; i < 3; i++) {
                sheet.autoSizeColumn(i);
            }
            
            JOptionPane.showMessageDialog(null, "Exportação em Excel realizada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na exportação em Excel: " + e.getMessage());
        }
    }
    
    public static ArrayList<TipoDespesa> lerExcel(String Caminho) {
        ArrayList<TipoDespesa> Lista = new ArrayList();
        
        try(FileInputStream fis = new FileInputStream(Caminho)) {
            Workbook wb = new XSSFWorkbook(fis);
            
            Sheet sheet = wb.getSheetAt(0);
            int Linhas = sheet.getPhysicalNumberOfRows();
            
            for (int i = 1; i < Linhas; i++) {
                Row row = sheet.getRow(i);
                
                int idMovimento = (int) row.getCell(0).getNumericCellValue();
                String descricao = row.getCell(1).getStringCellValue();
                
                TipoDespesa despesa = new TipoDespesa(idMovimento, descricao);
                Lista.add(despesa);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
        
        return Lista;
    }
}
