package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import page.*;

//@FixMethodOrder(MethodSorters.)
public class TestClass {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

    }

    @Test
    public void createAccountTest(){
        HomePage home = new HomePage(driver);
        RegisterPage account = home.moveToRegisterPage();
        account.setFirstName("Kanti");
        account.setLastName("Saiful");
        account.setEmail("arif@mail.com");
        account.setPassword("Password123");
        account.setConfirmPass("Password123");
        account.submitForm();
        driver.quit();
    }


    @Test
    public void testScenario2(){
        HomePage home = new HomePage(driver);
        home.clickBags();
        driver.quit();
    }

    @Test
    public void storeToChart() {
        HomePage home = new HomePage(driver);
        LoginPage lgn = home.moveToLoginPage();
        lgn.login();
        home.addToChartOutfit1();
        home.addToChartOutfit2();

    }

    @Test
    public void checkoutOrderTest() {
        HomePage home = new HomePage(driver);
        LoginPage lgn = home.moveToLoginPage();
        lgn.login();
        CartPage order = home.clickCart();
        ShippingPage shippingPage = order.checkout();
        shippingPage.showSummaryOrder();


    }
}