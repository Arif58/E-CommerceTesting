package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShippingPage {
    private WebDriver driver;

    public ShippingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void showSummaryOrder() {
        Boolean wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"checkout-loader\"]/div/img")));
        if(wait){
            WebElement summary = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/div/div[1]")));
            Actions actions = new Actions(driver);
            actions.moveToElement(summary).click().perform();
            ourOrder();
        }

    }

    public void ourOrder() {
        List<WebElement> heading = driver.findElements(By.className("product-item"));

        for (WebElement webElement : heading) {
            String name = webElement.getText();
            System.out.println(name);
        }
    }
}
