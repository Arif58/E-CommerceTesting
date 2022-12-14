package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage {
    private WebDriver driver;
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccesMsg() {
        WebElement msg = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div")));
        String msgText = msg.getText();
//        System.out.println(succes);
        return msgText;
    }

}
