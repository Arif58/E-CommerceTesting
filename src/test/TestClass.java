package test;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.*;

import java.time.Duration;

//@FixMethodOrder(MethodSorters.DEFAULT)
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
        account.setEmail("arif9@mail.com");
        account.setPassword("Password123");
        account.setConfirmPass("Password123");
        MyAccountPage accountPage = account.submitForm();
//        System.out.println(accountPage.succesRegister());
        String message = accountPage.getSuccesMsg();
        Assert.assertTrue(message.contains("Thank you for registering"));
    }

    @Test
    public void menuProductTest(){
        HomePage home = new HomePage(driver);
        BagsPage bagsPage = home.clickBags();
        String title = bagsPage.getPageTitle();
        Assert.assertTrue(title.contains("Bags"));
    }

    @Test
    public void storeToChart() {
        HomePage home = new HomePage(driver);
        LoginPage lgn = home.moveToLoginPage();
        lgn.login();
        home.addToChartOutfit1();
        home.addToChartOutfit2();
        WebElement cart = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]")));
        String banyakPesanan = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]")).getText();
        Assert.assertEquals("2", banyakPesanan);
    }

    @Test
    public void checkoutOrderTest() {
        HomePage home = new HomePage(driver);
        LoginPage lgn = home.moveToLoginPage();
        lgn.login();
        CartPage order = home.clickCart();
        ShippingPage shippingPage = order.checkout();
        shippingPage.showSummaryOrder();
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("checkout"));
    }

    @Test
    public void inputShippingDataTest() {
        HomePage home = new HomePage(driver);
        LoginPage lgn = home.moveToLoginPage();
        lgn.login();
        CartPage order = home.clickCart();
        ShippingPage shippingPage = order.checkout();
//        shippingPage.setCompany("FAcebook");
        shippingPage.inputData();
        PaymentPage paymentPage = shippingPage.submitForm();
        paymentPage.shippingInfo();
        OrderSuccesPage orderSuccesPage = paymentPage.placeOrderBtn();
        orderSuccesPage.getUrl();


    }

//    @After
//    public void CloseWindows() {
//        driver.quit();
//    }
}