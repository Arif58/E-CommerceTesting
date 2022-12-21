package page;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BagsPage {
    private WebDriver driver;
    public BagsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void addPushItBag() {
        WebElement bag = driver.findElement(new By.ByXPath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(bag).perform();

        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[3]/div/div[1]/form/button")));
        actions.moveToElement(wait).click().perform();
    }

    public void addImpulseDuffleBag() {
        WebElement bag = driver.findElement(new By.ByXPath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[8]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(bag).perform();

        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[8]/div/div/div[3]/div/div[1]/form/button")));
        actions.moveToElement(wait).click().perform();
    }

    public String countChart() {
        WebElement msg = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]/div[2]/div")));
        WebElement cart = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(cart).perform();

        String banyakPesanan = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]")).getText();
        return banyakPesanan;
    }

    public CartPage clickCart() {
        WebElement cart = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(cart).click().perform();
        return new CartPage(driver);
    }
}
