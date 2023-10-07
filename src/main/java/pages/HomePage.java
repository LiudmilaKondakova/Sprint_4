package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.WebTestUtils;

public class HomePage extends MainHeader{
    //кнопка согласия хранения куков
    private final By buttonCookie = By.id("rcc-confirm-button");
    // кнопка заказать вверху страницы
    private final By buttonRentHeader = By.className("Button_Button__ra12g");
    // кнопка заказать внизу страницы
    private final By buttonRentScooter = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM')]");
    //кнопка статус заказа
    private final By buttonCheckRentStatus = By.className("Header_Link__1TAG7");
    //нопка Go для проверки статуса заказа
    private final By buttonGoCheckRentStatus = By.cssSelector(".Button_Button__ra12g.Header_Button__28dPO");
    //поле ввода номера заказа
    private final By inputOrderNum = By.cssSelector(".Input_Input__1iN_Z.Header_Input__xIoUq");
    // Вопросы
    private final By faqQuestion = By.xpath(".//div[(@class='accordion__button') and (text()='%s')]");
    //ответы
    private final By faqAnswer = By.xpath(".//p[text()='%s']");

    //Текст на главной странице
    private final By scooterHomePageWelcomeText = By.xpath(".//div[@class='Home_Header__iJKdX']");

    public HomePage(WebDriver driver) {

        super(driver);
    }

    public HomePage buttonCookieClick() {
        driver.findElement(buttonCookie).click();
        return this;
    }

    //клик по кнопке Заказать вверху страницы
    public NewRentClientInfoPage buttonRentHeaderClick() {
        WebTestUtils.scrollTo(driver, buttonRentHeader);
        driver.findElement(buttonRentHeader).click();
        return new NewRentClientInfoPage(driver);
    }

    //клик по кнопке Заказать внизу страницы
    public NewRentClientInfoPage buttonRentScooterClick() {
        WebTestUtils.scrollTo(driver, buttonRentScooter);
        driver.findElement(buttonRentScooter).click();
        return new NewRentClientInfoPage(driver);
    }

    //клик по кнопке Статус заказа
    public HomePage buttonCheckRentStatusClick() {
        driver.findElement(buttonCheckRentStatus).click();
        return this;
    }

    //ввод номера заказа
    public HomePage setOrderNum(String orderNum) {
        driver.findElement(inputOrderNum).sendKeys(orderNum);
        return this;
    }

    //клик по кнопке GO
    public CheckRentStatusPage buttonGoCheckRentStatusClick() {
        WebTestUtils.waitElement(driver, buttonGoCheckRentStatus);
        driver.findElement(buttonGoCheckRentStatus).click();
        return new CheckRentStatusPage(driver);
    }

    //поиск вопросов и ответов на них
    public void faqQuestionAnswerCheck(String questionText, String answerText) {
        //вопрос
        By questionLocator = WebTestUtils.xPathFormatter(faqQuestion, questionText);
        WebTestUtils.scrollTo(driver, questionLocator);
        driver.findElement(questionLocator).click();

        //ответ
        By answerLocator = WebTestUtils.xPathFormatter(faqAnswer, answerText);
        WebTestUtils.scrollTo(driver, answerLocator);
        driver.findElement(answerLocator);
    }

    public boolean getScooterHomePageWelcomeText() {
        WebTestUtils.scrollTo(driver, scooterHomePageWelcomeText);
        return driver.findElement(scooterHomePageWelcomeText).isDisplayed();
    }
}