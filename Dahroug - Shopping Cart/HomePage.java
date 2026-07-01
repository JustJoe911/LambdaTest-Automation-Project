package projectDEPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;
    By productOne = By.id("mz-product-listing-image-37218399-0-5");
    By productTwo = By.id("mz-product-listing-image-39218404-0-3");
    By badgeCartClick = By.cssSelector("a.cart");
    By cartPage = By.xpath("//div[@id=\"entry_217850\"]/a");
    By countOfCart = By.xpath("//div[@class=\"cart-icon\"]/span");
    By clickLogin = By.xpath("/html/body/div[1]/div[5]/header/div[3]/div[1]/div/div[3]/nav/div/ul/li[6]/a");
    By homeLink = By.xpath("//a[@href=\"https://ecommerce-playground.lambdatest.io/index.php?route=common/home\"]");
    By addToCartButton = By.xpath("//div[@id=\"entry_216842\"]/button");
    //    By addToCartButton = By.cssSelector("button[title=\"Add to Cart\"]");

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickHomeLink(){
        driver.findElement(homeLink).click();
    }

    public LoginPageProject enterClickForLogin(){
//        wait.until(ExpectedConditions.elementToBeClickable(clickLogin)).click();
        driver.findElement(clickLogin).click();
        return new LoginPageProject(driver);
    }

    public void addProductOneToCart(){
        driver.findElement(productOne).click();
        driver.findElement(addToCartButton).click();
    }

    public void addProductTwoToCart(){
        driver.findElement(productTwo).click();
        driver.findElement(addToCartButton).click();
    }

    public String getCartBadgeCount(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(countOfCart)).getText();
    }

    public ShoppingCartPage clickOfCartIcon(){
        driver.findElement(badgeCartClick).click();
        driver.findElement(cartPage).click();
        return new ShoppingCartPage(driver);
    }
}