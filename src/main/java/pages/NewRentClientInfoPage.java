package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.WebTestUtils;

public class NewRentClientInfoPage extends MainHeader{
    //заголовок
    private final By pageHeader = By.xpath(".//div[@class='Order_Header__BZXOb']");
    //кнопка далее
    private final By btnNext = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
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
    private String subwayStation;


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
        this.subwayStation = subwayStation;
        driver.findElement(inputSubwayStation).click();
        return this;
    }

    //ввод телефона
    public NewRentClientInfoPage inputPhoneNumber(String phoneNumber) {
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
        return this;
    }

    //клик по кнопке далее
    public NewRentParamPage buttonNextClick() {
        driver.findElement(btnNext).click();
        return new NewRentParamPage(driver);
    }

    //метод заполняет все поля
    public NewRentParamPage addCustomerInfo(String name, String surname, String address, String subwayStation, String phoneNumber) {

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

}
