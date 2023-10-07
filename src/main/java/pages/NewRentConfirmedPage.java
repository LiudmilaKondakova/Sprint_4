package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewRentConfirmedPage extends BasePage {
    //заголовок
    private final By pageHeader = By.xpath(".//div[text()='Заказ оформлен']");
    //кнопка Посмотреть статус
    private final By buttonShowStatus = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //кнопка Да
    private final By buttonYes = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM') and " +
            "(text()='Да')]");

    public NewRentConfirmedPage(WebDriver driver) {

        super(driver);
    }

    //Окно Заказ Оформлен появилось
    public boolean isPageRentConfirmed() {

        return driver.findElement(pageHeader).isDisplayed();
    }


    public BasePage buttonShowStatusClick() {
        driver.findElement(buttonShowStatus).click();
        return this;
    }

    public NewRentConfirmedPage buttonConfirmNewRentClick() {
        driver.findElement(buttonYes).click();
        return new NewRentConfirmedPage(driver);


    }
}