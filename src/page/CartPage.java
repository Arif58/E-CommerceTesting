package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
//    private By checkoutBtn = new By.ByXPath("//*[@id=\"top-cart-btn-checkout\"]");
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public ShippingPage checkout() {
//        driver.findElement(checkoutBtn).click();
        WebElement checkoutBtn = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"top-cart-btn-checkout\"]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(checkoutBtn).click().perform();
        return new ShippingPage(driver);
    }
}
