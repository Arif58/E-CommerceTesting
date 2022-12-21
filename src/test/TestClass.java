package test;

import com.beust.ah.A;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jshell.execution.Util;
import org.junit.*;
import org.junit.runner.OrderWith;
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
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestClass {

    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");

    }

    @Test
    public void a_createAccountTest() {
        HomePage homePage = new HomePage(driver);
        RegisterPage account = homePage.moveToRegisterPage();
        account.setFirstName("Kanti");
        account.setLastName("Saiful");
        account.setEmail(account.randomString(5)+"@mail.com");
        account.setPassword("Password123");
        account.setConfirmPass("Password123");
        MyAccountPage accountPage = account.submitForm();
        String message = accountPage.getSuccesMsg();
        Assert.assertTrue(message.contains("Thank you for registering"));
    }

    @Test
    public void b_menuProductTest() {
        HomePage homePage = new HomePage(driver);
        BagsPage bagsPage = homePage.clickBags();
        String title = bagsPage.getPageTitle();
        Assert.assertTrue(title.contains("Bags"));
    }

    @Test
    public void storeToChartTest() {
        BagsPage bagsPage = new BagsPage(driver);
        bagsPage.addPushItBag();
        bagsPage.addImpulseDuffleBag();
//        String countProduct = bagsPage.countChart();
        WebElement msg = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]/div[2]/div")));
        String countProduct = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]")).getText();
        Assert.assertEquals("2", countProduct);
    }

    @Test
    public void d_checkoutOrderTest() {
        BagsPage bagsPage = new BagsPage(driver);
        CartPage order = bagsPage.clickCart();
        ShippingPage shippingPage = order.checkout();
        String url = shippingPage.getUrl();
        Assert.assertTrue(url.contains("shipping"));
    }

    @Test
    public void e_orderSummaryTest() {
        ShippingPage shippingPage = new ShippingPage(driver);
        shippingPage.showSummaryOrder();
        String expectedOrder = "Push It Messenger Bag\n" +
                "Qty 1\n" +
                "$45.00\n" +
                "Impulse Duffle\n" +
                "Qty 1\n" +
                "$74.00";
//        System.out.println(shippingPage.ourOrder());
        Assert.assertEquals(expectedOrder, shippingPage.ourOrder());
    }

    @Test
    public void f_inputShippingAddressTest() {
        ShippingPage shippingPage = new ShippingPage(driver);
        shippingPage.inputData();
        shippingPage.chooseShippingMethod();
        PaymentPage paymentPage = shippingPage.submitForm();
        String url = paymentPage.getUrl();
        Assert.assertEquals("https://magento.softwaretestingboard.com/checkout/#payment", url);
    }

    @Test
    public void g_shippingAddressConfirmTest() {
        PaymentPage paymentPage = new PaymentPage(driver);
        String shippingAddress = paymentPage.shippingInfo();
        String expectedShippingAddress = "Kanti Saiful\n" +
                "Jalan Kebanggan\n" +
                "kota mati, Alaska 42423\n" +
                "United States\n" +
                "0862827309825";
        Assert.assertEquals(expectedShippingAddress, shippingAddress);
    }
    @Test
    public void h_clickPlaceOrder() {
        PaymentPage paymentPage = new PaymentPage(driver);
        OrderSuccesPage orderSuccesPage = paymentPage.placeOrderBtn();
        String title = orderSuccesPage.getPageTitle();
        Assert.assertTrue(title.contains("Thank you for your purchase!"));
    }

    @Test
    public void i_confirmOrderTest() {
        OrderSuccesPage orderSuccesPage = new OrderSuccesPage(driver);
        MyOrderPage myOrderPage = orderSuccesPage.clickOrderNumber();
        myOrderPage.myOrder();
        String expectedResult = "Push It Messenger Bag\n" +
                "24-WB04\n" +
                "$45.00\n" +
                "Ordered 1\n" +
                "$45.00\n" +
                "Impulse Duffle\n" +
                "24-UB02\n" +
                "$74.00\n" +
                "Ordered 1\n" +
                "$74.00";
//        System.out.println(myOrderPage.myOrder());
        Assert.assertEquals(expectedResult, myOrderPage.myOrder());

    }

}