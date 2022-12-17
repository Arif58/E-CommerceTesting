package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderSuccesPage {
    private WebDriver driver;

    private By orderNumber = new By.ByClassName("order-number");
    public OrderSuccesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        WebElement pageTitle = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/h1")));
        return pageTitle.getText();
    }

    public MyOrderPage clickOrderNumber() {
        driver.findElement(orderNumber).click();
        return new MyOrderPage(driver);
    }
}
