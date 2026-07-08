package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class BaseTest {

    WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void goToHomePage() {
        driver.get("https://ecommerce-playground.lambdatest.io/");
        homePage = new HomePage(driver);
    }
/*
    @AfterClass
    public void down() {
        driver.quit();
    }*/
}
