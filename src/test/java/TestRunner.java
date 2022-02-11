import org.testng.annotations.Test;

public class TestRunner {

    @Test
    public void runner() throws Exception {
        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.getCellValues();
    }
}
