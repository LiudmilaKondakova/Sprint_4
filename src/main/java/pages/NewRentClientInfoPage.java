package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.WebTestUtils;

public class NewRentClientInfoPage extends MainHeader{
    //заголовок
    private final By pageHeader = By.xpath(".//div[@class='Order_Header__BZXOb']");
    //кнопка далее
    private final By btnNext = By.className(".Button_Button__ra12g Button_Middle__1CSJM");
    //имя
    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");
    //Фамилия
    private final By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    //Адрес
    private final By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Станция метро
    private final By inputSubwayStation = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By listSubwayStation = By.xpath(".//div[text()='%s']/parent::button");
    //телефон
    private final By inputPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    //сообщения о некорректном заполнении
    private final By inputNameErrorMessage = By.xpath(".//div[text()='Введите корректное имя']");
    private final By inputSurnameErrorMessage = By.xpath(".//div[text()='Введите корректную фамилию']");
    private final By inputAddressErrorMessage = By.xpath(".//div[text()='Введите корректный адрес']");
    private final By inputPhoneNumberError = By.xpath(".//div[text()='Введите корректный номер']");
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


    public NewRentClientInfoPage(WebDriver driver) {

        super(driver);
    }

    //заголовок на страницу
    public boolean isPageHeader() {

        return driver.findElement(pageHeader).isDisplayed();
    }

    //ввод имени
    public NewRentClientInfoPage inputName(String name) {
        driver.findElement(inputName).sendKeys(name);
        return this;
    }

    //ввод фамилии
    public NewRentClientInfoPage inputSurname(String surname) {
        driver.findElement(inputSurname).sendKeys(surname);
        return this;
    }

    //ввод адреса
    public NewRentClientInfoPage inputAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
        return this;
    }

    //ввод станции метро
    public NewRentClientInfoPage inputSubwayStation(String subwayStation) {
        driver.findElement(inputSubwayStation).click();
        WebTestUtils.scrollTo(driver, WebTestUtils.xPathFormatter(listSubwayStation, subwayStation));
        driver.findElement(WebTestUtils.xPathFormatter(listSubwayStation, subwayStation)).click();
        return this;
    }

    //клик по полю ввода станции метро
    public NewRentClientInfoPage inputSubwayStationClick(String subwayStation) {
        WebTestUtils.scrollTo(driver, WebTestUtils.xPathFormatter(listSubwayStation, subwayStation));
        driver.findElement(inputSubwayStation).click();
        return this;
    }

    //ввод телефона
    public NewRentClientInfoPage inputPhoneNumber(String phoneNumber) {
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
        return this;
    }

    //клик по кнопке далее
    public NewRentClientInfoPage buttonNextClick() {
        driver.findElement(btnNext).click();
        return new NewRentClientInfoPage(driver);
    }

    //метод заполняет все поля
    public NewRentClientInfoPage addCustomerInfo(String name, String surname, String address, String subwayStation, String phoneNumber) {

        return this.inputName(name)
                .inputSurname(surname)
                .inputAddress(address)
                .inputSubwayStation(subwayStation)
                .inputPhoneNumber(phoneNumber)
                .buttonNextClick();
    }

    //проверка сообщений о неверном вводе
    public boolean isInputNameErrorMessage() {

        return driver.findElement(inputNameErrorMessage).isDisplayed();
    }

    public boolean isInputSurnameErrorMessage() {

        return driver.findElement(inputSurnameErrorMessage).isDisplayed();
    }

    public boolean isInputAddressErrorMessage() {

        return driver.findElement(inputAddressErrorMessage).isDisplayed();
    }

    public boolean isInputPhoneNumberError() {

        return driver.findElement(inputPhoneNumberError).isDisplayed();
    }

/*    public NewRentClientInfoPage inputDeliveryTimeClick() {
        driver.findElement(inputDeliveryTime).click();
        return this;
    } */

    public NewRentClientInfoPage inputDeliveryTime(String timeDelivery) {
        driver.findElement(inputDeliveryTime).sendKeys(timeDelivery);
        driver.findElement(pageHeader).click();
        return this;
    }

    public NewRentClientInfoPage inputRentalPeriod(String rentPeriod) {
        driver.findElement(inputRentalPeriod).click();
        By targetElement = WebTestUtils.xPathFormatter(inputRentalPeriodMenu, rentPeriod);
        WebTestUtils.waitElement(driver, targetElement);
        driver.findElement(targetElement).click();
        return this;
    }

    public NewRentClientInfoPage selectColor(String colorScooter) {
        driver.findElement(WebTestUtils.xPathFormatter(inputScooterColor, colorScooter)).click();
        return this;
    }

    public NewRentClientInfoPage inputComment(String comment) {
        driver.findElement(inputComment).sendKeys(comment);
        return this;
    }

    public NewRentClientInfoPage buttonConfirmNewRentClick() {
        driver.findElement(buttonCreateOrder).click();
        return new NewRentClientInfoPage(driver);
    }

    public BasePage addRentInfo(String timeDelivery, String rentPeriod, String colorScooter, String comment) {
        inputDeliveryTime(timeDelivery);
        inputRentalPeriod(rentPeriod);
        selectColor(colorScooter);
        inputComment(comment);
        return buttonConfirmNewRentClick();
    }
}
