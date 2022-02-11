import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

public class Actions {

    static WebDriver driver;

    public void openBrowser() {
        switch (ExcelUtils.dataValue.trim().toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                if (Objects.isNull(driver)) {
                    driver = new ChromeDriver();
                }
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                if (Objects.isNull(driver)) {
                    driver = new EdgeDriver();
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + ExcelUtils.dataValue.trim().toLowerCase());
        }
    }

    public void getUrl() {
        driver.get(ExcelUtils.dataValue.trim());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void enterText() {
        driver.findElement(ExcelUtils.element).sendKeys(ExcelUtils.dataValue.trim());
    }

    public void clickButton() {
        driver.findElement(ExcelUtils.element).click();
    }

    public void verifyText() {
        Assertions.assertThat(driver.findElement(ExcelUtils.element).isDisplayed()).isTrue();
    }

    public void closeBrowser() throws IOException {
        if (Objects.nonNull(driver)) {
            driver.quit();
            driver = null;
        }
        ExcelUtils.fis.close();
    }
}
