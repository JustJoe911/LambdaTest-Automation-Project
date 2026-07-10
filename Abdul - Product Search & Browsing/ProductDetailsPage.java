package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {

    WebDriver driver;
    private By productName = By.cssSelector("h1.h3");
    private By productPrice = By.cssSelector("h3[data-update='price']");
    private By productImage = By.cssSelector("img.img-fluid");
    private By productAvailability = By.xpath("//span[text()='Availability:']/following-sibling::span");

    public ProductDetailsPage(WebDriver driver) {this.driver = driver;}
    public String getProductName() {
        return driver.findElement(productName).getText();
    }
    public String getProductPrice() {
        return driver.findElement(productPrice).getText();
    }
    public boolean hasProductImage() {
        return driver.findElement(productImage).isDisplayed();
    }
    public String getAvailability() {
        return driver.findElement(productAvailability).getText();
    }
}
