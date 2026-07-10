package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {

    WebDriver driver;
    By productNames = By.className("text-ellipsis-2");
    By noResultMessage = By.xpath("//p[text()='There is no product that matches the search criteria.']");

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
    public ProductDetailsPage openProduct(int index){
        driver.findElements(productNames).get(index).click();
        return new ProductDetailsPage(driver);
    }
}