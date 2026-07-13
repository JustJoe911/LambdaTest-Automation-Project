package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By emailTextField = By.id("input-email");
    private By passwordTextField = By.id("input-password");
    private By loginButton = By.xpath("//input[@value='Login']");
    private By returningCustomerHeading = By.xpath("//h2[normalize-space()='Returning Customer']");
    private By errorMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
    private By logoutLink = By.linkText("Logout");

    // Expected values
    private String expectedHeading = "Returning Customer";
    private String expectedError = "Warning: No match for E-Mail Address and/or Password.";
    private String expectedEmptyFieldsError = "Warning: You must enter E-mail and password!";
    private String expectedEmail = "test911@qa.team";
    private String expectedPassword = "lambdatest";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void login(String email, String password) {

        driver.findElement(emailTextField).clear();
        driver.findElement(emailTextField).sendKeys(email);

        driver.findElement(passwordTextField).clear();
        driver.findElement(passwordTextField).sendKeys(password);

        driver.findElement(loginButton).click();
    }

    public void logout() {
        driver.findElement(logoutLink).click();
    }

    // Actual values
    public String getActualHeading() {
        return driver.findElement(returningCustomerHeading).getText();
    }

    public String getActualError() {
        return driver.findElement(errorMessage).getText();
    }

    // Expected values
    public String getExpectedHeading() {
        return expectedHeading;
    }

    public String getExpectedError() {
        return expectedError;
    }

    public String getExpectedEmptyFieldsError() {
        return expectedEmptyFieldsError;
    }

    public String getExpectedEmail() {
        return expectedEmail;
    }

    public String getExpectedPassword() {
        return expectedPassword;
    }
}