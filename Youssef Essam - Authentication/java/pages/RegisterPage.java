package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    // Locators
    private By firstNameTextField = By.id("input-firstname");
    private By lastNameTextField = By.id("input-lastname");
    private By emailTextField = By.id("input-email");
    private By telephoneTextField = By.id("input-telephone");
    private By passwordTextField = By.id("input-password");
    private By confirmPasswordTextField = By.id("input-confirm");

    private By privacyPolicyCheckBox = By.id("input-agree");
    private By continueButton = By.cssSelector("input.btn.btn-primary");

    private By successHeading = By.cssSelector("h1.page-title.my-3");

    private By existingEmailWarning =
            By.cssSelector("div.alert.alert-danger.alert-dismissible");

    private By privacyPolicyWarning =
            By.cssSelector("div.alert.alert-danger.alert-dismissible");

    private By firstNameError =
            By.xpath("//input[@id='input-firstname']/following-sibling::div");

    private By lastNameError =
            By.xpath("//input[@id='input-lastname']/following-sibling::div");

    private By emailError =
            By.xpath("//input[@id='input-email']/following-sibling::div");

    private By telephoneError =
            By.xpath("//input[@id='input-telephone']/following-sibling::div");

    private By passwordError =
            By.xpath("//input[@id='input-password']/following-sibling::div");

    private By confirmPasswordError =
            By.xpath("//input[@id='input-confirm']/following-sibling::div");

    // Expected Values
    private String expectedSuccessHeading = "Your Account Has Been Created!";

    private String expectedExistingEmailWarning =
            "Warning: E-Mail Address is already registered!";

    private String expectedPrivacyPolicyWarning =
            "Warning: You must agree to the Privacy Policy!";

    private String expectedFirstNameError =
            "First Name must be between 1 and 32 characters!";

    private String expectedLastNameError =
            "Last Name must be between 1 and 32 characters!";

    private String expectedEmailError =
            "E-Mail Address does not appear to be valid!";

    private String expectedTelephoneError =
            "Telephone must be between 3 and 32 characters!";

    private String expectedPasswordError =
            "Password must be between 4 and 20 characters!";

    private String expectedConfirmPasswordError =
            "Password confirmation does not match password!";

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameTextField).clear();
        driver.findElement(firstNameTextField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameTextField).clear();
        driver.findElement(lastNameTextField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailTextField).clear();
        driver.findElement(emailTextField).sendKeys(email);
    }

    public void enterTelephone(String telephone) {
        driver.findElement(telephoneTextField).clear();
        driver.findElement(telephoneTextField).sendKeys(telephone);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordTextField).clear();
        driver.findElement(passwordTextField).sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        driver.findElement(confirmPasswordTextField).clear();
        driver.findElement(confirmPasswordTextField).sendKeys(password);
    }

    public void clickPrivacyPolicy() {
        driver.findElement(By.cssSelector("label[for='input-agree']")).click();
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void register(String firstName,
                         String lastName,
                         String email,
                         String telephone,
                         String password,
                         boolean acceptPolicy) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterTelephone(telephone);
        enterPassword(password);
        enterConfirmPassword(password);

        if (acceptPolicy) {
            clickPrivacyPolicy();
        }

        clickContinue();
    }

    public String getSuccessHeading() {
        return driver.findElement(successHeading).getText();
    }

    public String getExistingEmailWarning() {
        return driver.findElement(existingEmailWarning).getText();
    }

    public String getPrivacyPolicyWarning() {
        return driver.findElement(privacyPolicyWarning).getText();
    }

    public String getFirstNameError() {
        return driver.findElement(firstNameError).getText();
    }

    public String getLastNameError() {
        return driver.findElement(lastNameError).getText();
    }

    public String getEmailError() {
        return driver.findElement(emailError).getText();
    }

    public String getTelephoneError() {
        return driver.findElement(telephoneError).getText();
    }

    public String getPasswordError() {
        return driver.findElement(passwordError).getText();
    }

    public String getConfirmPasswordError() {
        return driver.findElement(confirmPasswordError).getText();
    }

    public String getExpectedSuccessHeading() {
        return expectedSuccessHeading;
    }

    public String getExpectedExistingEmailWarning() {
        return expectedExistingEmailWarning;
    }

    public String getExpectedPrivacyPolicyWarning() {
        return expectedPrivacyPolicyWarning;
    }

    public String getExpectedFirstNameError() {
        return expectedFirstNameError;
    }

    public String getExpectedLastNameError() {
        return expectedLastNameError;
    }

    public String getExpectedEmailError() {
        return expectedEmailError;
    }

    public String getExpectedTelephoneError() {
        return expectedTelephoneError;
    }

    public String getExpectedPasswordError() {
        return expectedPasswordError;
    }

    public String getExpectedConfirmPasswordError() {
        return expectedConfirmPasswordError;
    }

    public String generateEmail() {
        return "john" + System.currentTimeMillis() + "@qa.team";
    }
}