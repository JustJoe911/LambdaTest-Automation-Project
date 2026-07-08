package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryPage {

    private WebDriver driver;

    private By searchInput = By.name("search");
    private By searchButton = By.className("type-text");

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
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
}
