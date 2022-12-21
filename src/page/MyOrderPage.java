package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MyOrderPage {
    private WebDriver driver;
    public MyOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public String myOrder() {
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[2]")));
        String product1 = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[2]/div[2]/table/tbody[1]/tr")).getText();
        String product2 = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[2]/div[2]/table/tbody[2]/tr")).getText();
        String product = product1 +"\n" +
                product2;
        return product;
    }

}
