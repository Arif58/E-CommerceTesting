package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private By first_name = new By.ById("firstname");
    private By last_name = new By.ById("lastname");
    private By email = new By.ById("email_address");
    private By password = new By.ById("password");
    private By confirmPass = new By.ById("password-confirmation");
    private By btnRegister = new By.ByXPath("//*[@id=\"form-validate\"]/div/div[1]/button");
    private WebDriver driver;
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public String randomString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }
    public void setFirstName(String query) {
        driver.findElement(first_name).sendKeys(query);
    }

    public void setLastName(String query) {
        driver.findElement(last_name).sendKeys(query);
    }

    public void setEmail(String query) {
        driver.findElement(email).sendKeys(query);
    }

    public void setPassword(String query) {
        driver.findElement(password).sendKeys(query);
    }

    public void setConfirmPass(String query) {
        driver.findElement(confirmPass).sendKeys(query);
    }

    public MyAccountPage submitForm(){
        driver.findElement(btnRegister).click();
        return new MyAccountPage(driver);
    }

}
