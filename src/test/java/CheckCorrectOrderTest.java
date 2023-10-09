import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import service.TestConfigurations;
import tests.BaseTest;

public class CheckCorrectOrderTest extends BaseTest {
    // При вводе неверного номера заказа, переход на страницу "Такого заказа нет"
    @Test
    public void checkIncorrectOrder() {
        Assert.assertTrue(new HomePage(driver)
                .buttonCheckRentStatusClick()
                .buttonShowStatusClick()
                .setOrderNum(TestConfigurations.INCORRECT_ORDER_NUMBER.toString())
                .buttonGoCheckRentStatusClick()
                .isTrackNoFound());
    }
}
