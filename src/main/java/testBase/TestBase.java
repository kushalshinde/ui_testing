package testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    public WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void teardown() throws Exception{

        if (driver != null) {
            driver.close();
        }

        if(System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
        }
    }

    public void getApplicationUrl(String url){
        System.out.println("URL: -" + url);
        driver.get(url);
    }


}
