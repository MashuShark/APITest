package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.Objects;

public class ExcelUtils {

    static String excelPath = "src/main/resources/data.xlsx";

    public static XSSFSheet getSheet() {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(excelPath);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            return sheet;

        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
         return null;
    }

    public static void main(String[] args) throws IOException {
        getRowCount();
        getFirstNameFromCell();
        getPositionFromCell();
    }

    public static void getFirstNameFromCell(){
        String value = getSheet().getRow(1).getCell(0).getStringCellValue();
        System.out.println("Value from (1,0) Cell -> " + value);
    }

    public static void getPositionFromCell(){
        DataFormatter formatter = new DataFormatter();
        XSSFCell dataCell = getSheet().getRow(1).getCell(4);
        Object value = formatter.formatCellValue(dataCell);

        System.out.println("Position from (1,4) Cell is -> " + value);
    }

    public static void getRowCount() {
        int rowCount = Objects.requireNonNull(getSheet()).getPhysicalNumberOfRows();
        System.out.println("Number of rows is -> " + rowCount);
    }
}