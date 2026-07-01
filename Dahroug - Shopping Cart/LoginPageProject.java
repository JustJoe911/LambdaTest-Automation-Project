package projectDEPI;

import com.google.common.eventbus.SubscriberExceptionContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageProject {
    WebDriver driver;
    WebDriverWait wait;
    By email = By.id("input-email");
    By pass = By.id("input-password");
    By submitButton = By.xpath("//input[@type=\"submit\"]");


    public LoginPageProject(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver , Duration.ofSeconds(10));
    }

    public void login(String user , String password){
        driver.findElement(email).sendKeys(user);
        driver.findElement(pass).sendKeys(password);
        driver.findElement(submitButton).click();
//        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }
}
