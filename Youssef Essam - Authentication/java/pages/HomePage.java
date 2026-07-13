package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    private By myAccount = By.linkText("My account");
    private By login = By.linkText("Login");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage goToLoginPage() {

        driver.findElement(myAccount).click();
        driver.findElement(login).click();

        return new LoginPage(driver);
    }
}