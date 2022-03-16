package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtils(String excelPath, String sheetName) {
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);

        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    }

    public void getFirstNameFromCell(int rowNumber, int cellNumber) {
        String value = sheet.getRow(rowNumber).getCell(cellNumber).getStringCellValue();
        System.out.println("Value from (" + rowNumber + "," + cellNumber + ") Cell -> " + value);
    }

    public void getPositionFromCell(int rowNumber, int cellNumber) {
        DataFormatter formatter = new DataFormatter();
        XSSFCell dataCell = sheet.getRow(rowNumber).getCell(cellNumber);
        Object value = formatter.formatCellValue(dataCell);

        System.out.println("Position from (" + rowNumber + "," + cellNumber + ") Cell is -> " + value);
    }

    public void getRowCount() {
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("Number of rows is -> " + rowCount);
    }
}