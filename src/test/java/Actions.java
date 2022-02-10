import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Actions {

    WebDriver driver;
    ExcelUtils excelUtils = new ExcelUtils();

    @Test
    public void openBrowser(){
        WebDriverManager.edgedriver().setup();
        driver= new EdgeDriver();
    }

    public void getUrl(String url){
        driver.get(url.trim());
    }

    public void enterText(String value){
      driver.findElement(excelUtils.element).sendKeys(value.trim());
    }

    public void clickButton(){
        driver.findElement(excelUtils.element).click();
    }

    public void verifyText(){
        driver.findElement(excelUtils.element).isDisplayed();
    }
}
