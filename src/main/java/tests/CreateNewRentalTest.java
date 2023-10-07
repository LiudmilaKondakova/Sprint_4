package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.HomePage;

@RunWith(Parameterized.class)
public class CreateNewRentalTest extends BaseTest{
    private final String name;
    private final String surname;
    private final String address;
    private final String subwayStation;
    private final String phoneNumber;
    private final String dateStartRent;
    private final String rentPeriod;
    private final String colorScooter;
    private final String comment;

    public CreateNewRentalTest(String name, String surname, String address, String subwayStation, String phoneNumber,
                               String dateStartRent, String rentPeriod, String colorScooter, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phoneNumber = phoneNumber;
        this.dateStartRent = dateStartRent;
        this.rentPeriod = rentPeriod;
        this.colorScooter = colorScooter;
        this.comment = comment;
    }

    @Parameterized.Parameters()
    public static Object[][] getTestDate() {
        return new Object[][]{
                {"Людмила", "Кондакова", "ул Консмомольская", "Черкизовская", "+79817322110", WebTestUtils.getDateForTest(10), "трое суток", "чёерный жемчуг", "Проверка связи"},
                {"Коля", "Колькин", "ул Арбатская, д 1", "Выставочная", "+79998887766", WebTestUtils.getDateForTest(10), "пятеро суток", "серая безысходность", "Прием, прием"}
        };
    }

    //Позитивная проверка
    // при тестировании в Chrome баг, не появдяется окно с подтверждением заказа
    @Test
    public void createNewRental() {
        Assert.assertTrue(new HomePage(driver)
                .buttonRentScooterClick()
                .isPageHeader());

        // возврат на главную страницу и делаем заказа через верхнюю кнопку заказать
        Assert.assertTrue(new HomePage(driver)
                .goToScooterHomePage()
                .buttonRentHeaderClick()  //переход на страницу заказа
                .addCustomerInfo(name, surname, address, subwayStation, phoneNumber)
                .addRentInfo(dateStartRent, rentPeriod, colorScooter, comment)
                .buttonConfirmNewRentClick()
                .isPageRentConfirmed());
    }
}
