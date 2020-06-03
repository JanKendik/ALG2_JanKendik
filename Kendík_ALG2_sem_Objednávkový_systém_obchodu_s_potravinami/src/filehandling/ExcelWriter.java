package filehandling;

import app.Calculator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author HP
 */
public class ExcelWriter extends Writer {

    @Override
    public void saveOrder(String nameFile, List<Calculator> calculators) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        createHeaderRow(sheet);
        int rowCount = 0;
        for (Calculator calculator : calculators) {
            Row row = sheet.createRow(++rowCount);
            write(calculator, row);
        }
        File resultF = new File(dataPath, nameFile);
        try (FileOutputStream fileOut = new FileOutputStream(resultF)) {
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
        }
    }
/**
 * Vytváření hlavičky tabulky
 * @param sheet 
 */
    private void createHeaderRow(XSSFSheet sheet) {
        Row r = sheet.createRow(0);
        Cell cID = r.createCell(0);
        cID.setCellValue("ID");
        Cell cNazev = r.createCell(1);
        cNazev.setCellValue("Název");
        Cell cCena = r.createCell(2);
        cCena.setCellValue("Cena");
        Cell cPocet = r.createCell(3);
        cPocet.setCellValue("Počet");
        Cell cSuma = r.createCell(4);
        cSuma.setCellValue("Suma");

    }
/**
 * Metoda píšící tebulku
 * @param cal - seznam rozšířený o vypočtené ceny
 * @param row 
 */
    private void write(Calculator cal, Row row) {
        Cell c = row.createCell(0);
        c.setCellValue(cal.getItem().getProduct().getId());
        c = row.createCell(1);
        c.setCellValue(cal.getItem().getProduct().getName());
        c = row.createCell(2);
        c.setCellValue(cal.getItem().getProduct().getPrice());
        c = row.createCell(3);
        c.setCellValue(cal.getItem().getnItems());
        c = row.createCell(4);
        c.setCellValue(cal.getSumPrice());

    }

}
