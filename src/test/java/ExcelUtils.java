import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ExcelUtils {

    static By element;
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFRow row;
    static int rowCount;
    static int colCount;
    static String[] rowValues;
    static String actionValue;
    static String locatorValue;
    static String dataValue;
    static String[] locatorArr;

    public void readExcel() throws IOException {
        fis = new FileInputStream(new File(System.getProperty("user.dir") + "/src/test/resources/testdata.xlsx"));
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet("Sheet1");
        rowCount = sheet.getLastRowNum();
        colCount = sheet.getRow(0).getLastCellNum();
    }

    public void splitLocator() {
       locatorArr= !locatorValue.trim().equalsIgnoreCase("NA") ? locatorValue.split("=") : new String[]{"NA", "NA"};
    }

    public void byElement() {
        switch (locatorArr[0].trim()) {
            case "id":
                element = By.id(locatorArr[1]);
                break;
        }
    }

    @Test
    public void getCellValues() throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        ActionUtils actionUtils = new ActionUtils();
        readExcel();
        rowValues = new String[colCount];
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                rowValues[j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
            actionValue=rowValues[2];
            locatorValue=rowValues[3];
            dataValue=rowValues[4];
            splitLocator();
            byElement();
            actionUtils.actionInvoker();
        }
    }
}
