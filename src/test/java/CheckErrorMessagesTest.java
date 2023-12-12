import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.NewRentClientInfoPage;
import service.TestData;
import tests.BaseTest;

// При вводе неправильной станции мтро, браузер переходит на пустую страницу, баг
public class CheckErrorMessagesTest extends BaseTest {
    @Test
    public void testErrorName() {
        // заполнение полей неверныйми данными
        NewRentClientInfoPage clientInfoPage = new HomePage(driver)
                .buttonRentScooterClick()
                .inputName(TestData.INCORRECT_NAME)
                .inputSurname(TestData.INCORRECT_SURNAME);

        // Смотрим вывод ошибок
        Assert.assertTrue(clientInfoPage.isInputNameErrorMessage());
    }

    @Test
    public void testErrorSurname() {
        // заполнение полей неверныйми данными
        NewRentClientInfoPage clientInfoPage = new HomePage(driver)
                .buttonRentScooterClick()
                .inputName(TestData.INCORRECT_NAME)
                .inputSurname(TestData.INCORRECT_SURNAME)
                .inputAddress(TestData.INCORRECT_ADDRESS);

        // Смотрим вывод ошибок
        Assert.assertTrue(clientInfoPage.isInputSurnameErrorMessage());
    }

    @Test
    public void testErrorAddress() {
        // заполнение полей неверныйми данными
        NewRentClientInfoPage clientInfoPage = new HomePage(driver)
                .buttonRentScooterClick()
                .inputName(TestData.INCORRECT_NAME)
                .inputSurname(TestData.INCORRECT_SURNAME)
                .inputAddress(TestData.INCORRECT_ADDRESS)
                .inputPhoneNumber(TestData.INCORRECT_PHONE_NUMBER);

        // Смотрим вывод ошибок
        Assert.assertTrue(clientInfoPage.isInputAddressErrorMessage());
    }

    @Test
    public void testErrorPhoneNumber() {
        // заполнение полей неверныйми данными
        NewRentClientInfoPage clientInfoPage = new HomePage(driver)
                .buttonRentScooterClick()
                .inputName(TestData.INCORRECT_NAME)
                .inputSurname(TestData.INCORRECT_SURNAME)
                .inputAddress(TestData.INCORRECT_ADDRESS)
                .inputPhoneNumber(TestData.INCORRECT_PHONE_NUMBER)
                .inputSubwayStationClick("ой")
                .inputSubwayStationClick("aй");
        // Смотрим вывод ошибок
        Assert.assertTrue(clientInfoPage.isInputPhoneNumberError());
    }
}
