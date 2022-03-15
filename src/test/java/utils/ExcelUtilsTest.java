package utils;

public class ExcelUtilsTest {

    public static void main(String[] args) {
        String excelPath = "src/main/resources/data.xlsx";
        String sheetName = "Sheet1";

        ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
        excel.getFirstNameFromCell();
        excel.getPositionFromCell();
        excel.getRowCount();
    }

}
