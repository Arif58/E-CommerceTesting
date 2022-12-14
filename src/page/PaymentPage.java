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
    private By placeOrder = new By.ByXPath("/html/body/div[3]/main/div[2]/div/div[2]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[2]/div[2]/div[4]/div/button");
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void shippingInfo() {
        Boolean wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[1]/div/img")));
        if (wait) {
            List<WebElement> qty = driver.findElements(By.className("billing-address-details"));
            ArrayList<String> barang = new ArrayList<>();
            Integer i = 0;
            for (WebElement webElement : qty) {
                String name = webElement.getText();
//                barang.add(name);
//                System.out.println("Data User : " + name.split("\n").length);
//                i++;
                System.out.println(name);
            }

//            System.out.println(name);
        }

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
