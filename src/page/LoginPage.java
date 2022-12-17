package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By email = new By.ById("email");
    private By password = new By.ById("pass");
    private By btnLogin = new By.ById("send2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage login(){
        driver.findElement(email).sendKeys("arif321@mail.com");
        driver.findElement(password).sendKeys("Password123");
        driver.findElement(btnLogin).click();
        return new HomePage(driver);
    }


}
