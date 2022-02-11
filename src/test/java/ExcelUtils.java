import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class ExcelUtils {
    static FileInputStream fis;
    static XSSFWorkbook wb;
    static XSSFSheet sheet;
    static XSSFRow row;
    static int rowCount, colCount;
    static String[] rowValues;
    static String testcaseValue, descriptionValue, actionValue, locatorValue, attributeValue, dataValue;
    static By element;

    ExcelUtils() throws IOException {
        fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/testdata.xlsx");
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheet("Sheet1");
        rowCount = sheet.getLastRowNum();
        colCount = sheet.getRow(0).getLastCellNum();
    }

    public void byElement() {
        switch (locatorValue.trim()) {
            case "id":
                element = By.id(attributeValue);
                break;
            case "xpath":
                element = By.xpath(attributeValue);
                break;
            case "linkText":
                element = By.linkText(attributeValue);
                break;
            case "partialLinkText":
                element = By.partialLinkText(attributeValue);
                break;
            case "class":
                element = By.className(attributeValue);
                break;
            case "name":
                element = By.name(attributeValue);
                break;
            case "cssSelector":
                element = By.cssSelector(attributeValue);
                break;
            case "tagName":
                element = By.tagName(attributeValue);
                break;
            default:
                element = null;
                break;
        }
    }

    public void getCellValues() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        ActionUtils actionUtils = new ActionUtils();

        rowValues = new String[colCount];
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                rowValues[j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
            testcaseValue = rowValues[0];
            descriptionValue = rowValues[1];
            actionValue = rowValues[2];
            locatorValue = rowValues[3];
            attributeValue = rowValues[4];
            dataValue = rowValues[5];
            System.out.println(testcaseValue + " : " + descriptionValue);
            byElement();
            actionUtils.actionInvoker();
        }
    }
}
