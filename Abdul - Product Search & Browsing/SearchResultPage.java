package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class SearchResultPage {

    WebDriver driver;
    By productNames = By.className("text-ellipsis-2");
    By noResultMessage = By.xpath("//p[text()='There is no product that matches the search criteria.']");
    private By productCards = By.className("product-thumb");
    private By quickViewButtons = By.cssSelector("button[title='Quick view']");
    private By productBrand = By.xpath("//*[@id='entry_212953']/ul/li[1]/a");
    private By closeQuickViewButton = By.xpath("//button[contains(@class,'mz-modal-close')]");

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean hasResults() {
        List<WebElement> products = driver.findElements(productNames);
        return products.size() > 0;
    }

    public boolean hasNoResult() {
        List<WebElement> actualNoResultMessage = driver.findElements(noResultMessage);
        return !actualNoResultMessage.isEmpty();
    }

    public boolean allProductsContain(String keyword) {
        List<WebElement> products = driver.findElements(productNames);
        for (WebElement product : products) {
            String productName = product.getText().toLowerCase();
            if (!productName.contains(keyword.toLowerCase())) {
                return false;
            }
        }
        return true;
    }
    public void hoverOnProduct(int index) {
        List<WebElement> products = driver.findElements(productCards);
        Actions actions = new Actions(driver);
        actions.moveToElement(products.get(index)).perform();
    }
    public void openQuickView(int index) throws InterruptedException {
        hoverOnProduct(index);
        Thread.sleep(5000);
        List<WebElement> quickView = driver.findElements(quickViewButtons);
        quickView.get(index).click();
    }
    public int getProductsCount() {
        return driver.findElements(productCards).size();
    }
    public String getBrandName() {

        return driver.findElement(productBrand).getText();
    }
    public void closeQuickView() throws InterruptedException {
        driver.findElement(closeQuickViewButton).click();
        Thread.sleep(500);
    }

}
