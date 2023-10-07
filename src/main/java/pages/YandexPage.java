package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YandexPage extends BasePage{
    //страница Дзена
    private final By yandexPageLocator = By.cssSelector("dzen.ru");
    public YandexPage(WebDriver driver) {

        super(driver);
    }

    //проверка, что окно яндекса открылось
    public boolean isYandexPageOpen() {

        return driver.findElement(yandexPageLocator).isDisplayed();
    }

}
