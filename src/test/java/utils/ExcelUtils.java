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

    public void getFirstNameFromCell() {
        String value = sheet.getRow(1).getCell(0).getStringCellValue();
        System.out.println("Value from (1,0) Cell -> " + value);
    }

    public void getPositionFromCell() {
        DataFormatter formatter = new DataFormatter();
        XSSFCell dataCell = sheet.getRow(1).getCell(4);
        Object value = formatter.formatCellValue(dataCell);

        System.out.println("Position from (1,4) Cell is -> " + value);
    }

    public void getRowCount() {
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("Number of rows is -> " + rowCount);
    }
}