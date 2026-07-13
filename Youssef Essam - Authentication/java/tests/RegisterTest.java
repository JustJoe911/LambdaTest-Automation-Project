package tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest {

    private RegisterPage registerPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUpPage() {

        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");

        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void registerWithValidDetails() {

        registerPage.register(
                "John",
                "Doe",
                registerPage.generateEmail(),
                "0123456789",
                "lambdatest",
                true
        );

        Assert.assertEquals(
                registerPage.getSuccessHeading(),
                registerPage.getExpectedSuccessHeading()
        );

        loginPage.logout();
    }

    @Test(priority = 2)
    public void registerWithExistingEmail() {

        registerPage.register(
                "John",
                "Doe",
                "test1234@qa.team",
                "0123456789",
                "lambdatest",
                true
        );

        Assert.assertTrue(
                registerPage.getExistingEmailWarning()
                        .contains(registerPage.getExpectedExistingEmailWarning())
        );
    }

    @Test(priority = 3)
    public void registerWithMissingRequiredFields() {

        registerPage.clickContinue();

        Assert.assertEquals(
                registerPage.getFirstNameError(),
                registerPage.getExpectedFirstNameError()
        );

        Assert.assertEquals(
                registerPage.getLastNameError(),
                registerPage.getExpectedLastNameError()
        );

        Assert.assertEquals(
                registerPage.getEmailError(),
                registerPage.getExpectedEmailError()
        );

        Assert.assertEquals(
                registerPage.getTelephoneError(),
                registerPage.getExpectedTelephoneError()
        );

        Assert.assertEquals(
                registerPage.getPasswordError(),
                registerPage.getExpectedPasswordError()
        );
    }

    @Test(priority = 4)
    public void registerWithoutAcceptingPrivacyPolicy() {

        registerPage.register(
                "John",
                "Doe",
                registerPage.generateEmail(),
                "0123456789",
                "lambdatest",
                false
        );

        Assert.assertTrue(
                registerPage.getPrivacyPolicyWarning()
                        .contains(registerPage.getExpectedPrivacyPolicyWarning())
        );
    }

    @Test(priority = 5)
    public void verifySuccessfulAccountCreation() {

        registerPage.register(
                "John",
                "Doe",
                registerPage.generateEmail(),
                "0123456789",
                "lambdatest",
                true
        );

        Assert.assertEquals(
                registerPage.getSuccessHeading(),
                registerPage.getExpectedSuccessHeading()
        );

        loginPage.logout();
    }
}