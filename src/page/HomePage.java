package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class HomePage {
    private By createAccount = new By.ByLinkText("Create an Account");
//    private By cart = new By.ByXPath("/html/body/div[2]/header/div[2]/div[1]/a");

    private By loginPage = new By.ByLinkText("Sign In");
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public RegisterPage moveToRegisterPage() {
        driver.findElement(createAccount).click();

        return new RegisterPage(driver);
    }

    public LoginPage moveToLoginPage() {
        driver.findElement(loginPage).click();

        return new LoginPage(driver);
    }

    public CartPage clickCart() {
        WebElement cart = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(cart).click().perform();
        return new CartPage(driver);
    }

    public BagsPage clickBags() {
        WebElement gear = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ui-id-6\"]")));
        Actions actions = new Actions(driver);
        actions.moveToElement(gear).perform();

        WebElement bags = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bags")));
        actions.moveToElement(bags).click().perform();

        return new BagsPage(driver);
    }

    public void addToChartOutfit1() {
        WebElement outfit1 = driver.findElement(new By.ByXPath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/a/span/span/img"));
        Actions actions = new Actions(driver);
        actions.moveToElement(outfit1).perform();

        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"option-label-size-143-item-168\"]")));
        actions.moveToElement(wait).click().perform();

        WebElement color = driver.findElement(new By.ByXPath("//*[@id=\"option-label-color-93-item-50\"]"));
        actions.moveToElement(color).click().perform();

        WebElement btn = driver.findElement(new By.ByXPath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/div/div[4]/div/div[1]/form/button"));
        actions.moveToElement(btn).click().perform();

    }

    public void addToChartOutfit2() {
        WebElement outfit2 = driver.findElement(new By.ByXPath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[4]/div/a/span/span/img"));
        Actions actions = new Actions(driver);
        actions.moveToElement(outfit2).perform();

        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/div[3]/div/div/ol/li[4]/div/div/div[2]/div[1]/div/div[5]")));
        actions.moveToElement(wait).click().perform();

        WebElement color = driver.findElement(new By.ByXPath("//*[@id=\"option-label-color-93-item-53\"]"));
        actions.moveToElement(color).click().perform();

        WebElement btn = driver.findElement(new By.ByXPath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[4]/div/div/div[3]/div/div[1]/form/button"));
        actions.moveToElement(btn).click().perform();
    }

}
