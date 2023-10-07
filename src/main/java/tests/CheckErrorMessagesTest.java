package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.NewRentClientInfoPage;
import service.TestData;

// При вводе неправильной станции мтро, браузер переходит на пустую страницу, баг
public class CheckErrorMessagesTest extends BaseTest{
    @Test
    public void testErrorInFields() {
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
        Assert.assertTrue(clientInfoPage.isInputNameErrorMessage());
        Assert.assertTrue(clientInfoPage.isInputSurnameErrorMessage());
        Assert.assertTrue(clientInfoPage.isInputAddressErrorMessage());
        Assert.assertTrue(clientInfoPage.isInputPhoneNumberError());
    }
}
