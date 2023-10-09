import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import tests.BaseTest;

public class ClickNewRentalTest extends BaseTest {
    // вывод на форму ввода данных, вынесла в отдельный тест по ревью
    @Test
    public void clickNewRental() {
        Assert.assertTrue(new HomePage(driver)
                .buttonRentScooterClick()
                .isPageHeader());
    }
}
