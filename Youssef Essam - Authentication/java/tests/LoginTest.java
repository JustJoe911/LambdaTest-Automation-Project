package tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void openLoginPage() {

        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");

        homePage = new HomePage(driver);
        loginPage = homePage.goToLoginPage();
    }

    @Test(priority = 1)
    public void validLogin() {

        Assert.assertEquals(
                loginPage.getActualHeading(),
                loginPage.getExpectedHeading()
        );

        loginPage.login(
                loginPage.getExpectedEmail(),
                loginPage.getExpectedPassword()
        );

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://ecommerce-playground.lambdatest.io/index.php?route=account/account",
                "Login failed."
        );

        loginPage.logout();
    }

    @Test(priority = 2)
    public void invalidPassword() {

        loginPage.login(
                loginPage.getExpectedEmail(),
                "wrong123"
        );

        Assert.assertEquals(
                loginPage.getActualError(),
                loginPage.getExpectedError()
        );
    }

    @Test(priority = 3)
    public void unregisteredEmail() {

        loginPage.login(
                "unregistered@qa.team",
                loginPage.getExpectedPassword()
        );

        Assert.assertEquals(
                loginPage.getActualError(),
                loginPage.getExpectedError()
        );
    }

    @Test(priority = 4)
    public void emptyFields() {

        loginPage.login("", "");

        Assert.assertEquals(
                loginPage.getActualError(),
                loginPage.getExpectedEmptyFieldsError()
        );
    }

    @Test(priority = 5)
    public void logoutSuccessfully() {

        loginPage.login(
                loginPage.getExpectedEmail(),
                loginPage.getExpectedPassword()
        );

        loginPage.logout();

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://ecommerce-playground.lambdatest.io/index.php?route=account/logout"
        );
    }
}