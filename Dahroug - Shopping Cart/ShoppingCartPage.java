package projectDEPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ShoppingCartPage {
    WebDriver driver;
    WebDriverWait wait;
    By spinnerUp = By.cssSelector("#entry_216841 .input-group-append button");
    By spinnerDown = By.xpath("//div[@id='entry_216841']//button[@data-spinner='down']");
    By buttonContShop = By.xpath("//a[text()=\"Continue Shopping\"]");
    By quantityInput = By.xpath("//div[@id='entry_216841']//input[@name='quantity']");
    By subTotal = By.xpath("//tr[1]/td[2]/strong");
    By total = By.xpath("//tr[4]/td[2]/strong");
    By removeAll = By.xpath("//div[@class=\"input-group-append\"]/button[@class=\"btn btn-danger\"]");
    By removeProductOne = By.xpath("(//table//button[contains(@class, 'btn-danger')])[2]");
    By removeProductTwo = By.xpath("(//table//button[contains(@class, 'btn-danger')])[1]");
    By productAddToCart = By.xpath("//button[text()=\"Add to Cart\"]");
    By afterRemoveAllButton = By.xpath("//a[text()=\"Continue\"]");
    By updateButton = By.xpath("//button[@type='submit' and @data-toggle='tooltip']");
    By actualRemoveAll = By.xpath("//div[@id='content']/p");
    By actualTitleEmptyCart = By.xpath("//h1[contains(text(),'Shopping Cart')]");
    String expectedRemoveAll = "Your shopping cart is empty!";
    String expectedTitleEmptyCart = "Shopping Cart";
    String expectButtonAfterRemoveAll = "Continue";

    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver , Duration.ofSeconds(10));
    }

    public String getExpectButtonAfterRemoveAll() {
        return expectButtonAfterRemoveAll;
    }

    public void clickContinueAfterRemoveAll() {
        wait.until(ExpectedConditions.elementToBeClickable(afterRemoveAllButton)).click();
        new HomePage(driver);
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

    public String getActualContinueButton(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(afterRemoveAllButton)).getText();
    }

    public String getActualTitleEmptyCart() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(actualTitleEmptyCart)).getText();
    }

    public void clickRemoveAll(){
        List<WebElement> removeButtons = driver.findElements(removeAll);
        for (WebElement button : removeButtons) {
            wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        }
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
        return wait.until(ExpectedConditions.presenceOfElementLocated(subTotal)).getAttribute("textContent").trim();
    }

    String expectedTotalPrice = "$268.00";
    public String getExpectedTotalPrice(){
        return expectedTotalPrice;
    }
    public String getTotalPrice(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(total)).getAttribute("textContent").trim();
    }

    public void removeFirstProduct(){
//        driver.findElement(removeProductOne).click();
        wait.until(ExpectedConditions.elementToBeClickable(removeProductOne)).click();
    }

    public void removeSecondProduct(){
        driver.findElement(removeProductTwo).click();
    }

    public void clickContinueShopping(){
        driver.findElement(buttonContShop).click();
        new HomePage(driver);
    }

    String expectedNumberQuantity = "3";
    public String getExpectedNumberQuantity() {
        return expectedNumberQuantity;
    }
    public String numberQuantity(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(quantityInput)).getAttribute("value").trim();
    }

    public void clickIncreaseQuantity() {
        wait.until(ExpectedConditions.elementToBeClickable(spinnerUp)).click();
    }

    String expectedNumberQuantityDE = "4";
    public String getExpectedNumberQuantityDE() {
        return expectedNumberQuantityDE;
    }
    public String numberQuantityDE(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(quantityInput)).getAttribute("value").trim();
    }
    public void changeManualNumQuantity(int num){
        wait.until(ExpectedConditions.elementToBeClickable(quantityInput)).sendKeys();
    }
    public void clickDecreaseQuantity() {
        wait.until(ExpectedConditions.elementToBeClickable(spinnerDown)).click();
    }

    By inputQuantityShopCart = By.xpath("//input[@size='1']");
    public String getInputQuantityShopCart(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(inputQuantityShopCart)).getAttribute("value").trim();
    }

    String expectedNewQuantity = "2";
    public String getExpectedNewQuantity() {
        return expectedNewQuantity;
    }
    String expectedMessageUpdate= "Success: You have modified your shopping cart!";
    By messageUpdate = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    public String getExpectedMessageUpdate(){
        return expectedMessageUpdate;
    }
    public String  getMessageUpdate(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(messageUpdate)).getText();
    }
    public void updateQuantityInput(String num){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputQuantityShopCart)).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(inputQuantityShopCart)).sendKeys(num);
        wait.until(ExpectedConditions.elementToBeClickable(updateButton)).click();
    }

}
