
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.sql.*;
import javax.swing.JOptionPane;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class ExportToExcel {
    private KoneksiMySql koneksi;

    public ExportToExcel(JTable table, File file) {
        try {
            koneksi = new KoneksiMySql();
            Connection connection = koneksi.getConnection();
            if (connection != null) {
                TableModel tableModel = table.getModel();
                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Sheet1");

                // Create header row
                Row headerRow = sheet.createRow(0);
                for (int i = 0; i < tableModel.getColumnCount(); i++) {
                    String columnName = tableModel.getColumnName(i);
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(columnName);
                }

                // Create data rows
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < tableModel.getColumnCount(); j++) {
                        Object value = tableModel.getValueAt(i, j);
                        Cell cell = row.createCell(j);
                        if (value != null) {
                            if (value instanceof String) {
                                cell.setCellValue((String) value);
                            } else if (value instanceof Integer) {
                                cell.setCellValue((Integer) value);
                            } else if (value instanceof Double) {
                                cell.setCellValue((Double) value);
                            } else {
                                cell.setCellValue(value.toString());
                            }
                        } else {
                            cell.setCellValue("");
                        }
                    }
                }

                // Auto-size columns
                for (int i = 0; i < tableModel.getColumnCount(); i++) {
                    sheet.autoSizeColumn(i);
                }

                // Write to file
                FileOutputStream fos = new FileOutputStream(file);
                workbook.write(fos);
                fos.close();
                workbook.close();
            } else {
                JOptionPane.showMessageDialog(null, "Failed to establish database connection");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
    }
}
