package utils;

public class ExcelUtilsTest {

    public static void main(String[] args) {
        String excelPath = "src/main/resources/data.xlsx";
        String sheetName = "Sheet1";

        ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
        excel.getFirstNameFromCell(2, 0);
        excel.getPositionFromCell(2, 4);
        excel.getRowCount();
    }

}
