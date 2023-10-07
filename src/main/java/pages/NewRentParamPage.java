package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NewRentParamPage extends MainHeader {
    private final By pageHeader = By.xpath(".//div[@class='Order_Header__BZXOb']");
    // поле ввода времени доставки
    private final By inputDeliveryTime = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // срок аренды
    private final By inputRentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");
    // передается в теле метода
    private final By inputRentalPeriodMenu = By.xpath(".//div[(@class='Dropdown-option') and (text()='%s')]");

    //Цвет самоката
    private final By inputScooterColor = By.xpath(".//label[(text()='%s')]");

    //Комментарий для курьера
    private final By inputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка назад
//    private final By buttonBack = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM.Button_Inverted__3IF-i");
    //Кнопка заказать
    private final By buttonCreateOrder = By.xpath("//button[(@class='Button_Button__ra12g Button_Middle__1CSJM')" +
            " and (text()='Заказать')]");

    public NewRentParamPage(WebDriver driver) {
        super(driver);
    }
    // Проверяем заголовок страницы
    public boolean isPageHeader() {

        return driver.findElement(pageHeader).isDisplayed();
    }

    // Ввод даты
    public void inputDeliveryTime(String deliveryTime) {
        driver.findElement(inputDeliveryTime).sendKeys(deliveryTime);
        // Закрыть календарь
        driver.findElement(pageHeader).click();
    }

    // Выбор срока аренды
    public void inputRentalPeriod(String rentalPeriod) {
        driver.findElement(inputRentalPeriod).click();
        By targetElement = tests.WebTestUtils.xPathFormatter(inputRentalPeriodMenu, rentalPeriod);
        tests.WebTestUtils.waitElement(driver, targetElement);
        driver.findElement(targetElement).click();
    }

    // Выбор цвета
    public void selectColor(String color) {
        driver.findElement(tests.WebTestUtils.xPathFormatter(inputScooterColor, color)).click();
    }

    // Комментарий курьеру
    public void inputComment(String comment) {
        driver.findElement(inputComment).sendKeys(comment);
    }

    //Клик по кнопке Заказать
    public NewRentConfirmedPage buttonCreateOrderClick() {
        driver.findElement(buttonCreateOrder).click();
        return new NewRentConfirmedPage(driver);
    }

    //Заполнение всех полей формы
    public NewRentConfirmedPage addRentInfo(String timeDelivery, String rentPeriod, String scooterColor, String comment) {
        inputDeliveryTime(timeDelivery);
        inputRentalPeriod(rentPeriod);
        selectColor(scooterColor);
        inputComment(comment);
        return buttonCreateOrderClick();
    }

}