package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ShippingPage {
    private WebDriver driver;

    private By firstName = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[1]/div/input");
    private By lastName = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[2]/div/input");
    private By company = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[3]/div/input");
    private By street = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/fieldset/div/div[1]/div/input");
    private By city = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[4]/div/input");
    private By state = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[5]/div/select");
    private By posCode = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[7]/div/input");
    private By phone = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[9]/div/input");
    private By fixedShipping = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[1]/table/tbody/tr[2]/td[1]/input");
    private By nextBtn = new By.ByXPath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button");
    public ShippingPage(WebDriver driver) {
        this.driver = driver;
    }

//    public void setCompany(String query) {
//        WebElement company = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("T3WAN51")));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(company).sendKeys(query).perform();
//    }

//    public void setStreet(String query) {
//        company = query;
//    }

//    public void setCity(String query) {
//        driver.findElement(city).sendKeys(query);
//    }
    public void inputData() {
        Boolean wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"checkout-loader\"]/div/img")));
        if(wait){
//            WebElement inputCompany = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[3]/div/input")));
////            WebElement inputStreet = new We
//            Actions actions = new Actions(driver);
//            actions.sendKeys(inputCompany, "google").perform();
            driver.findElement(company).sendKeys("IG");
            driver.findElement(street).sendKeys("Jalan Kebanggan");
            driver.findElement(city).sendKeys("kota mati");
            Select chooseState = new Select(driver.findElement(state));
            chooseState.selectByIndex(2);
            driver.findElement(posCode).sendKeys("42423");
            driver.findElement(phone).sendKeys("0862827309825");
            driver.findElement(fixedShipping).click();

        }
    }

    public PaymentPage submitForm() {
        driver.findElement(nextBtn).click();
        return new PaymentPage(driver);
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

//    public boolean loadingDone() {
//        Boolean wait = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"checkout-loader\"]/div/img")));
//        return wait;
//    }

    public void ourOrder() {
        List<WebElement> productName = driver.findElements(By.className("product-item-name"));
        List<WebElement> qty = driver.findElements(By.className("details-qty"));
        ArrayList<String> barang = new ArrayList<>();

        for (WebElement webElement : productName) {
            String name = webElement.getText();
            barang.add(name);
//            System.out.println(name);
        }

        for (WebElement webElement : qty) {
            String name = webElement.getText();
            barang.add(name);
//            System.out.println(name);
        }
        System.out.println(barang);

    }
}
