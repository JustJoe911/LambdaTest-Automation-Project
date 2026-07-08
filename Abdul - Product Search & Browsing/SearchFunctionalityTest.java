package tests;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import pages.SearchResultPage;

public class SearchFunctionalityTest extends BaseTest {

    @Test
    public void verifySearchForExistingProduct() {

        SearchResultPage searchResultPage = homePage.searchFor("MacBook Air");
        Assert.assertTrue(searchResultPage.hasResults(),
                "There are no products for this search criteria.");
    }

    @Test
    public void verifySearchForNonExistingProductShowsNoResultMessage() {

        SearchResultPage searchResultPage = homePage.searchFor("esrkdlfkgn123");
        Assert.assertTrue(searchResultPage.hasNoResult(),
                "Products were found for a non-existing search criteria.");
    }

    @Test
    public void verifySearchUsingPartialKeywordReturnsMatchingProducts() {

        SearchResultPage searchResultPage = homePage.searchFor("mac");

        Assert.assertTrue(searchResultPage.hasResults(),
                "Expected search results, but no products were found.");

        Assert.assertTrue(searchResultPage.allProductsContain("mac"),
                "Some search results do not match the search keyword.");
    }
    @Test
    public void verifySearchWithSpecialCharacterShowsNoResult() {

        SearchResultPage searchResultPage = homePage.searchFor("!@#$%!^");
        Assert.assertTrue(searchResultPage.hasNoResult(),
                "Products were found when searching with special characters.");
    }

@Test
public void verifySearchFromCategoryPageReturnsMatchingProducts() {
    CategoryPage categoryPage = homePage.openCategory("Components");
    SearchResultPage searchResultPage = categoryPage.searchFor("Mac");
    Assert.assertTrue(
            searchResultPage.hasResults(), "Expected search results, but no products were found.");
    Assert.assertTrue(
            searchResultPage.allProductsContain("Mac"), "Some search results do not match the search keyword.");
}
    @Test
    public void verifySearchResultsMatchTheQuary() {

        SearchResultPage searchResultPage = homePage.searchFor("Iphone");

        Assert.assertTrue(searchResultPage.hasResults(),
                "Expected search results, but no products were found.");

        Assert.assertTrue(searchResultPage.allProductsContain("mac"),
                "Some search results do not match the search keyword.");
    }
    }
