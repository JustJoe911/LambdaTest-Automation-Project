package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By searchInput = By.name("search");
    private By searchButton = By.className("type-text");
    private By categoryListButton = By.xpath("//a[text()=' Shop by Category']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAt() {
        return driver.getCurrentUrl().contains("https://ecommerce-playground.lambdatest.io/");
    }

    public void enterSearchKeyword(String keyword) {
        driver.findElement(searchInput).sendKeys(keyword);
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public SearchResultPage searchFor(String keyword) {
        enterSearchKeyword(keyword);
        clickSearch();
        return new SearchResultPage(driver);
    }

    public CategoryPage openCategory(String categoryName) {
        driver.findElement(categoryListButton).click();
        By category = By.xpath("//span[normalize-space()='" + categoryName + "']");
        driver.findElement(category).click();
        return new CategoryPage(driver);
    }


}