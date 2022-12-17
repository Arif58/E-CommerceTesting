package test;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
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
        HomePage home = new HomePage(driver);
        RegisterPage account = home.moveToRegisterPage();
        account.setFirstName("Kanti");
        account.setLastName("Saiful");
        account.setEmail("arif321@mail.com");
        account.setPassword("Password123");
        account.setConfirmPass("Password123");
        MyAccountPage accountPage = account.submitForm();
//        System.out.println(accountPage.succesRegister());
        String message = accountPage.getSuccesMsg();
        Assert.assertTrue(message.contains("Thank you for registering"));
    }

    @Test
    public void b_menuProductTest() {
        HomePage home = new HomePage(driver);
        BagsPage bagsPage = home.clickBags();
        String title = bagsPage.getPageTitle();
        Assert.assertTrue(title.contains("Bags"));
    }

    @Test
    public void c_storeToChart() {
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
    public void d_checkoutOrderTest() {
        HomePage home = new HomePage(driver);
        LoginPage lgn = home.moveToLoginPage();
        lgn.login();
        CartPage order = home.clickCart();
        ShippingPage shippingPage = order.checkout();
        String url = shippingPage.getUrl();
        Assert.assertTrue(url.contains("shipping"));
    }

    @Test
    public void e_orderSummaryTest() {
        HomePage home = new HomePage(driver);
        LoginPage lgn = home.moveToLoginPage();
        lgn.login();
        CartPage order = home.clickCart();
        ShippingPage shippingPage = order.checkout();
        shippingPage.showSummaryOrder();
        String summary = shippingPage.showBarang1() + ", " + shippingPage.showBarang2();
        Assert.assertTrue(summary.contains("Hero Hoodie Qty 1"));
        Assert.assertTrue(summary.contains("Radiant Tee Qty 1"));
        System.out.println(summary);
    }

    @Test
    public void f_inputShippingAddressTest() {
        HomePage home = new HomePage(driver);
        LoginPage lgn = home.moveToLoginPage();
        lgn.login();
        CartPage order = home.clickCart();
        ShippingPage shippingPage = order.checkout();
        shippingPage.inputData();
        shippingPage.chooseShippingMethod();
        PaymentPage paymentPage = shippingPage.submitForm();
        String url = paymentPage.getUrl();
        Assert.assertTrue(url.contains("payment"));

    }

    @Test
    public void g_shippingAddressConfirmTest() {
        HomePage home = new HomePage(driver);
        LoginPage lgn = home.moveToLoginPage();
        lgn.login();
        CartPage order = home.clickCart();
        ShippingPage shippingPage = order.checkout();
        shippingPage.inputData();
        String nama = shippingPage.getFirstName() + " " + shippingPage.getLastName();
        String street = shippingPage.getStreet();
        String city = shippingPage.getCity();
        String state = shippingPage.getState();
        String posCode = shippingPage.getPosCode();
        String country = shippingPage.getCountry();
        String phone = shippingPage.getPhone();
        shippingPage.chooseShippingMethod();
        PaymentPage paymentPage = shippingPage.submitForm();
        String shippingAddress = paymentPage.shippingInfo();
        Assert.assertTrue(shippingAddress.contains(nama));
        Assert.assertTrue(shippingAddress.contains(street));
        Assert.assertTrue(shippingAddress.contains(city));
        Assert.assertTrue(shippingAddress.contains(state));
        Assert.assertTrue(shippingAddress.contains(posCode));
        Assert.assertTrue(shippingAddress.contains(country));
        Assert.assertTrue(shippingAddress.contains(phone));
    }
    @Test
    public void h_clickPlaceOrder() {
        HomePage home = new HomePage(driver);
        LoginPage lgn = home.moveToLoginPage();
        lgn.login();
        CartPage order = home.clickCart();
        ShippingPage shippingPage = order.checkout();
//        shippingPage.inputData();
        shippingPage.chooseShippingMethod();
        PaymentPage paymentPage = shippingPage.submitForm();
        OrderSuccesPage orderSuccesPage = paymentPage.placeOrderBtn();
        String title = orderSuccesPage.getPageTitle();
        MyOrderPage myOrderPage = orderSuccesPage.clickOrderNumber();

        Assert.assertTrue(title.contains("Thank you for your purchase!"));
    }

//    @After
//    public void CloseWindows() {
//        driver.quit();
//    }
}