import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login {

    WebDriver driver;

    String Expected_Email = "test911@qa.team";
    String Expected_Password = "lambdatest";


    @BeforeClass
    public void setup() {

        driver = new FirefoxDriver();
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.linkText("My account"))).perform();
        driver.findElement(By.linkText("Login")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='breadcrumb-item active']")).getText(), "Login", "Login page did not load successfully");
        Assert.assertEquals(driver.getCurrentUrl(), "https://ecommerce-playground.lambdatest.io/index.php?route=account/login", "Login page did not load successfully");

    }

    @BeforeMethod
    public void LoginPage() {

        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");

    }


    @Test(priority = 1)
    public void validLogin() {

        driver.findElement(By.id("input-email")).sendKeys(Expected_Email);
        driver.findElement(By.id("input-password")).sendKeys(Expected_Password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://ecommerce-playground.lambdatest.io/index.php?route=account/account", "did not login successfully");


    }

    @Test(priority = 3)
    public void invalidPassword () {

        driver.findElement(By.id("input-email")).sendKeys(Expected_Email);
        driver.findElement(By.id("input-password")).sendKeys("wrong123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), "Warning: No match for E-Mail Address and/or Password.", "something went wrong (invalid password case)");
    }

    @Test(priority = 4)
    public void unregistered () {

        driver.findElement(By.id("input-email")).sendKeys("unregistered@qa.team");
        driver.findElement(By.id("input-password")).sendKeys(Expected_Password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), "Warning: No match for E-Mail Address and/or Password.", "something went wrong (not registered case)");
    }


    @Test(priority = 5)
    public void emptyFields () {

        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), "Warning: You must enter E-mail and password!", "something went wrong (empty fields case)");

    }

    @Test(priority = 2)
    public void logout() {

        driver.findElement(By.linkText("Logout")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://ecommerce-playground.lambdatest.io/index.php?route=account/logout", "did not logout successfully");
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Account Logout", "did not logout successfully");

        driver.findElement(By.linkText("Continue")).click();
    }


    @AfterClass
    public void end() {

        driver.quit();
    }
}
