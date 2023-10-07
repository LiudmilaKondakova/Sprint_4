package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import service.TestConfigurations;

import java.util.concurrent.TimeUnit;

import static service.TestConfigurations.IMPLICIT_WAIT_SECONDS;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        switch (TestConfigurations.TARGET_BROWSER) {
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_SECONDS, TimeUnit.SECONDS);
        driver.get(service.WebPage.HOME_PAGE_URL);
    }

    @After
    public void teardown() {

        driver.quit();
    }
}
