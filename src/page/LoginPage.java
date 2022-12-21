package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public final String login_url = "https://magento.softwaretestingboard.com/customer/account/login/";
    private By email = new By.ById("email");
    private By password = new By.ById("pass");
    private By btnLogin = new By.ById("send2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login(){
        driver.get(login_url);
        driver.findElement(email).sendKeys("arif404@mail.com");
        driver.findElement(password).sendKeys("Password123");
        driver.findElement(btnLogin).click();
        return new HomePage(driver);
    }


}
