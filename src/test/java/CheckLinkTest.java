import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import tests.BaseTest;

public class CheckLinkTest extends BaseTest {
    // переход на Дзен
    @Test
    public void testGoToYandex() {
        Assert.assertTrue(new HomePage(driver)
                .goToYandexHomePageClick()
                .isYandexPageOpen());
    }

    //Переход на главную страницу Самоката
    @Test
    public void testGoToScooterServiceHomePage() {
        Assert.assertTrue(new HomePage(driver)
                .buttonCookieClick()
                .buttonRentHeaderClick()  //переход на страницу заказа
                .goToScooterHomePage()
                .getScooterHomePageWelcomeText());
    }
}
