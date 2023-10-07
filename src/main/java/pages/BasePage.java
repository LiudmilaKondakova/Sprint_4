package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected final WebDriver driver;
    private String orderNum;

    public BasePage(WebDriver driver) {

        this.driver = driver;
    }

    public boolean isPageRentConfirmed() {
        return false;
    }

    public BasePage buttonConfirmNewRentClick() {

        return this;
    }
    public BasePage buttonShowStatusClick() {

        return this;
    }

    public HomePage setOrderNum(String orderNum) {
        this.orderNum = orderNum;
        return null;
    }

    public String getOrderNum() {
        return orderNum;
    }
}
