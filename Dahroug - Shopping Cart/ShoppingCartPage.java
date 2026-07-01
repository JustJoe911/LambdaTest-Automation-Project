package projectDEPI;

import com.google.common.eventbus.SubscriberExceptionContext;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.WatchEvent;
import java.time.Duration;
import java.util.List;

public class ShoppingCartPage {
    WebDriver driver;
    WebDriverWait wait;
    By spinnerUp = By.xpath("//button[@data-spinner=\"up\"]");
    By spinnerDown = By.xpath("//button[@data-spinner=\"down\"]");
    By buttonContShop = By.xpath("//a[text()=\"Continue Shopping\"]");
    By subTotal = By.xpath("//tr[1]/td[2]/strong");
    By total = By.xpath("//tr[4]/td[2]/strong");
    By removeAll = By.xpath("//div[@class=\"input-group-append\"]/button[@class=\"btn btn-danger\"]");
    By removeProductOne = By.xpath("//tr[1]/td[4]/div/div/button[2]");
    By removeProductTwo = By.xpath("//tr[2]/td[4]/div/div/button[2]");
    By actualTitleEmptyCart = By.xpath("//h1[contains(text(),'Shopping Cart')]");
    By productAddToCart = By.xpath("//button[text()=\"Add to Cart\"]");
    By afterRemoveAllButton = By.xpath("//a[text()=\"Continue\"]");
    By actualRemoveAll = By.xpath("//p[text()=\"Your shopping cart is empty!\"]");
    String expectedRemoveAll = "Your shopping cart is empty!";
    String expectedTitleEmptyCart = "Shopping Cart";
    String expectButtonAfterRemoveAll = "Continue";
    //    By actualTitleEmptyCart = By.xpath("//h1[text()=\"Shopping Cart\"]");
    //    By cartPage = By.partialLinkText("checkout/cart");

    public String getExpectButtonAfterRemoveAll() {
        return expectButtonAfterRemoveAll;
    }

    public HomePage clickContinueAfterRemoveAll() {
        wait.until(ExpectedConditions.elementToBeClickable(afterRemoveAllButton)).click();
        return new HomePage(driver);
    }

    public String getExpectedTitleEmptyCart() {
        return expectedTitleEmptyCart;
    }

    public String getExpectedRemoveAll() {
        return expectedRemoveAll;
    }

    public String getActualRemoveAll() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(actualRemoveAll)).getText();
    }

    public String getActualTitleEmptyCart() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(actualTitleEmptyCart)).getText();
    }

    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver , Duration.ofSeconds(10));
    }

    public void clickRemoveAll(){
        List<WebElement> removeButtons = driver.findElements(removeAll);
        for (WebElement button : removeButtons) {
            wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        }
    }

//    public void updateQuantityDirectly(String newQuantity) {
//        WebElement input = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityInput));
//        input.clear();
//        input.sendKeys(newQuantity);
//        input.sendKeys(Keys.ENTER);
//    }

    public void clickIncreaseQuantity() {
        driver.findElement(spinnerUp).click();
    }

    public void decreaseQuantity(){
        wait.until(ExpectedConditions.elementToBeClickable(spinnerDown)).click();
    }

    public void setProductAddToCart(){
        wait.until(ExpectedConditions.elementToBeClickable(productAddToCart)).click();
    }

    String expectSubTotal = "$220.00";
    public String getExpectSubTotal(){
        return expectSubTotal;
    }
    public String getSubTotal(){
        return driver.findElement(subTotal).getText();
    }

    String expectedTotalPrice = "$268.00";
    public String getExpectedTotalPrice(){
        return expectedTotalPrice;
    }
    public String getTotalPrice(){
        return driver.findElement(total).getText();
    }

    public void removeFirstProduct(){
        driver.findElement(removeProductOne).click();
    }

    public void removeSecondProduct(){
        driver.findElement(removeProductTwo).click();
    }

    public HomePage clickContinueShopping(){
        driver.findElement(buttonContShop).click();
        return new HomePage(driver);
    }
}
