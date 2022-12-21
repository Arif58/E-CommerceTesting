package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ProgramFlowTest {

    WebDriver driver;
    TestClass testClass = new TestClass();
    @Before
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void test() {
        testClass.driver = driver;
//        testClass.link();
        testClass.a_createAccountTest();
        testClass.b_menuProductTest();
        testClass.storeToChartTest();
        testClass.d_checkoutOrderTest();
        testClass.e_orderSummaryTest();
        testClass.f_inputShippingAddressTest();
        testClass.g_shippingAddressConfirmTest();
        testClass.h_clickPlaceOrder();
        testClass.i_confirmOrderTest();
    }
}
