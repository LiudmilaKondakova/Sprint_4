package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import service.TestConfigurations;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class MainHeader extends BasePage{
    // ссылка перехода на страницу Дзен
    private final By linkToYandex = By.className("Header_LogoYandex__3TSOI");
    //ссылка перехода на главную страницу Самоката
    private final By linkToScooterHomePage = By.cssSelector(".Header_LogoScooter__3lsAR");

    public MainHeader(WebDriver driver) {

        super(driver);
    }

    //Клик по ссылке Яндекса
    public YandexPage goToYandexHomePageClick() {
        //Окно самокаты
        String originalScooterWindow = driver.getWindowHandle();
        driver.findElement(linkToYandex).click();
        new WebDriverWait(driver, TestConfigurations.IMPLICIT_WAIT_SECONDS).until(numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalScooterWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        return new YandexPage(driver);
    }

    //клик по ссылке на главной страницу Самоката
    public HomePage goToScooterHomePage() {
        driver.findElement(linkToScooterHomePage).click();
        return new HomePage(driver);
    }
}
