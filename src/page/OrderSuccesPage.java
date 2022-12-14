package page;

import org.openqa.selenium.WebDriver;

public class OrderSuccesPage {
    private WebDriver driver;

    public OrderSuccesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void getUrl() {
        driver.getCurrentUrl();
    }
}
