package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PaymentPage {
    private WebDriver driver;
    String shippingAddress;

    private By placeOrder = new By.ByXPath("/html/body/div[3]/main/div[2]/div/div[2]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[2]/div[2]/div[4]/div/button");
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getUrl() {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/main/div[2]/div/div[2]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[2]/div[2]")));
        return driver.getCurrentUrl();
    }

    public String shippingInfo() {
//        Boolean wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/div/img")));
//        System.out.println(wait);
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/main/div[2]/div/div[2]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[2]/div[2]")));
//        if (wait) {
//            shippingAddress = driver.findElement(By.className("shipping-information-content")).getText();
//            System.out.println(info);
//        }
        shippingAddress = driver.findElement(By.className("shipping-information-content")).getText();
        return shippingAddress;

    }

    public OrderSuccesPage placeOrderBtn() {
        Boolean wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/div/img")));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(placeOrder).click().perform();
        if (wait) {
            driver.findElement(placeOrder).click();
        }
        return new OrderSuccesPage(driver);
    }
}
