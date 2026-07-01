package projectDEPI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    protected ShoppingCartPage shoppingCartPage;
    protected LoginPageProject loginPageProject;

    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void goToLoginPage(){
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        homePage = new HomePage(driver);
        loginPageProject = new LoginPageProject(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}