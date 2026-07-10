package tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchResultPage;

public class ProductBrowsingTests extends BaseTest {

    @Test
    public void verifyUserCanOpenProductDetails() {
        SearchResultPage searchResultPage = homePage.searchFor("Mac");
        ProductDetailsPage productDetailsPage = searchResultPage.openProduct(0);
        Assert.assertFalse(productDetailsPage.getProductName().isEmpty(), "Failed to open product details page.");
    }
    @Test
    public void verifyProductNameIsDisplayed() {
        SearchResultPage searchResultPage = homePage.searchFor("Mac");
        ProductDetailsPage productDetailsPage = searchResultPage.openProduct(0);
        Assert.assertTrue(productDetailsPage.getProductName().toLowerCase().contains("mac"), "The opened product does not match the searched keyword.");
    }
    @Test
    public void verifyProductImageIsDisplayed() {
        SearchResultPage searchResultPage = homePage.searchFor("Mac");
        ProductDetailsPage productDetailsPage = searchResultPage.openProduct(0);
        Assert.assertTrue(productDetailsPage.hasProductImage(), "Product image is not displayed.");
    }
    @Test
    public void verifyProductPriceIsDisplayed() {

        SearchResultPage searchResultPage = homePage.searchFor("Mac");
        ProductDetailsPage productDetailsPage = searchResultPage.openProduct(0);
        Assert.assertFalse(productDetailsPage.getProductPrice().isEmpty(), "Product price is not displayed.");
        Assert.assertTrue(productDetailsPage.getProductPrice().startsWith("$"), "Invalid price format.");
    }
    @Test
    public void verifyProductAvailabilityIsDisplayed() {
        SearchResultPage searchResultPage = homePage.searchFor("Mac");
        ProductDetailsPage productDetailsPage = searchResultPage.openProduct(5);
        Assert.assertTrue(productDetailsPage.getAvailability().equals("In Stock") || productDetailsPage.getAvailability().equals("Out Of Stock"), "Invalid product availability.");
    }

}
