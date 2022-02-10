import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class TestRunner {

    public void runner() throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        ExcelUtils excelUtils = new ExcelUtils();


        excelUtils.getCellValues();
    }
}
