package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import projectDEPI.BaseTest;

public class ShoppingCartTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(ShoppingCartTest.class);
    WebDriverWait wait;


    @Test
    public void validAddOneProductToTheCart() throws InterruptedException {
        homePage.enterClickForLogin();
        loginPageProject.login("mail1@gmail.com","12345");
        homePage.clickHomeLink();
        homePage.addProductOneToCart();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.getCartBadgeCount().contains("1"));
        shoppingCartPage.clickRemoveAll();
    }

    @Test
    public void validMultipleAddProduct() throws InterruptedException {
        homePage.enterClickForLogin();
        loginPageProject.login("mail1@gmail.com","12345");
        homePage.clickHomeLink();
        homePage.addProductOneToCart();
        homePage.clickHomeLink();
        homePage.addProductTwoToCart();
        homePage.clickHomeLink();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.getCartBadgeCount().contains("2"));
        shoppingCartPage.clickRemoveAll();
    }

    @Test
    public void removeProduct() throws InterruptedException {
        homePage.enterClickForLogin();
        loginPageProject.login("mail1@gmail.com","12345");
        homePage.clickHomeLink();
        homePage.addProductOneToCart();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        shoppingCartPage.removeFirstProduct();
        Thread.sleep(2000);
        Assert.assertTrue(shoppingCartPage.getActualTitleEmptyCart().contains("Shopping Cart  (1.00kg)"));
    }

    @Test
    public void emptyTheCart(){
        homePage.enterClickForLogin();
        loginPageProject.login("mail1@gmail.com","12345");
        homePage.clickHomeLink();
        homePage.addProductOneToCart();
        homePage.clickHomeLink();
        homePage.addProductTwoToCart();
        homePage.clickHomeLink();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        shoppingCartPage.clickRemoveAll();
        driver.navigate().refresh();
        Assert.assertEquals(shoppingCartPage.getActualTitleEmptyCart(),shoppingCartPage.getExpectedTitleEmptyCart());
        Assert.assertEquals(shoppingCartPage.getActualRemoveAll(),shoppingCartPage.getExpectedRemoveAll());
        Assert.assertEquals(shoppingCartPage.getActualContinueButton(), shoppingCartPage.getExpectButtonAfterRemoveAll());
    }

    @Test
    public void continueShoppingFromTheCartAfterAddProduct() throws InterruptedException {
        homePage.enterClickForLogin();
        loginPageProject.login("mail1@gmail.com","12345");
        homePage.clickHomeLink();
        homePage.addProductOneToCart();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        shoppingCartPage.clickRemoveAll();
        shoppingCartPage.clickContinueShopping();
    }

    @Test
    public void continueShoppingFromTheCartEmpty() {
        homePage.enterClickForLogin();
        loginPageProject.login("mail1@gmail.com", "12345");
        homePage.clickHomeLink();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        Assert.assertEquals(shoppingCartPage.getActualContinueButton(), shoppingCartPage.getExpectButtonAfterRemoveAll());
        shoppingCartPage.clickContinueAfterRemoveAll();

    }

    @Test
    public void verifySubTotal(){
        homePage.enterClickForLogin();
        loginPageProject.login("mail1@gmail.com","12345");
        homePage.clickHomeLink();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        shoppingCartPage.clickRemoveAll();
        homePage.clickHomeLink();
        homePage.addProductOneToCart();
        homePage.clickHomeLink();
        homePage.addProductTwoToCart();
        homePage.clickHomeLink();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        shoppingCartPage.getSubTotal();
        Assert.assertEquals(shoppingCartPage.getSubTotal(),shoppingCartPage.getExpectSubTotal());
    }

    @Test
    public void verifyTotalUpdate() {
        homePage.enterClickForLogin();
        loginPageProject.login("mail1@gmail.com", "12345");
        homePage.clickHomeLink();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        shoppingCartPage.clickRemoveAll();
        homePage.clickHomeLink();
        homePage.addProductOneToCart();
        homePage.clickHomeLink();
        homePage.addProductTwoToCart();
        homePage.clickHomeLink();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        shoppingCartPage.getTotalPrice();
        Assert.assertEquals(shoppingCartPage.getTotalPrice(), shoppingCartPage.getExpectedTotalPrice());
    }

    @Test
    public void increaseProductQuantity() throws InterruptedException {
        homePage.enterClickForLogin();
        loginPageProject.login("mail1@gmail.com","12345");
        homePage.clickHomeLink();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        shoppingCartPage.clickRemoveAll();
        homePage.clickHomeLink();
        shoppingCartPage = homePage.viewProductOne();
        shoppingCartPage.clickIncreaseQuantity();
        shoppingCartPage.clickIncreaseQuantity();
        Assert.assertEquals(shoppingCartPage.numberQuantity(),shoppingCartPage.getExpectedNumberQuantity());
        homePage.clickCartButton();
        shoppingCartPage = homePage.clickOfCartIcon();
        Thread.sleep(2000);
    }

    @Test
    public void decreaseProductQuantity(){
        homePage.enterClickForLogin();
        loginPageProject.login("mail1@gmail.com","12345");
        homePage.clickHomeLink();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        shoppingCartPage.clickRemoveAll();
        homePage.clickHomeLink();
        shoppingCartPage = homePage.viewProductOne();
        shoppingCartPage.clickIncreaseQuantity();
        shoppingCartPage.clickIncreaseQuantity();
        shoppingCartPage.clickIncreaseQuantity();
        shoppingCartPage.clickIncreaseQuantity();
        shoppingCartPage.clickDecreaseQuantity();
        Assert.assertEquals(shoppingCartPage.numberQuantityDE(),shoppingCartPage.getExpectedNumberQuantityDE());
        homePage.clickCartButton();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        shoppingCartPage.updateQuantityInput("2");
        Assert.assertEquals(shoppingCartPage.getInputQuantityShopCart(), shoppingCartPage.getExpectedNewQuantity());
        Assert.assertTrue(shoppingCartPage.getMessageUpdate().contains(shoppingCartPage.getExpectedMessageUpdate()));
    }

    @Test
    public void invalidDecreaseProductQuantityMinus(){
        homePage.enterClickForLogin();
        loginPageProject.login("mail1@gmail.com","12345");
        homePage.clickHomeLink();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        shoppingCartPage.clickRemoveAll();
        homePage.clickHomeLink();
        shoppingCartPage = homePage.viewProductTwo();
        shoppingCartPage.clickIncreaseQuantity();
        shoppingCartPage.clickIncreaseQuantity();
        shoppingCartPage.clickIncreaseQuantity();
        shoppingCartPage.clickIncreaseQuantity();
        shoppingCartPage.clickDecreaseQuantity();
        Assert.assertEquals(shoppingCartPage.numberQuantityDE(),shoppingCartPage.getExpectedNumberQuantityDE());
        homePage.clickCartButton();
        homePage.clickHomeLink();
        homePage.addProductOneToCart();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        shoppingCartPage.updateQuantityInput("-5");
        Assert.assertTrue(homePage.getCartBadgeCount().contains("1"));
        Assert.assertTrue(shoppingCartPage.getActualTitleEmptyCart().contains("Shopping Cart  (0.15kg)"));
    }

    @Test
    public void invalidDecreaseProductQuantityZero(){
        homePage.enterClickForLogin();
        loginPageProject.login("mail1@gmail.com","12345");
        homePage.clickHomeLink();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        shoppingCartPage.clickRemoveAll();
        homePage.clickHomeLink();
        shoppingCartPage = homePage.viewProductTwo();
        shoppingCartPage.clickIncreaseQuantity();
        shoppingCartPage.clickIncreaseQuantity();
        shoppingCartPage.clickIncreaseQuantity();
        shoppingCartPage.clickIncreaseQuantity();
        shoppingCartPage.clickDecreaseQuantity();
        Assert.assertEquals(shoppingCartPage.numberQuantityDE(),shoppingCartPage.getExpectedNumberQuantityDE());
        homePage.clickCartButton();
        homePage.clickHomeLink();
        homePage.addProductOneToCart();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        shoppingCartPage.updateQuantityInput("0");
        Assert.assertTrue(homePage.getCartBadgeCount().contains("1"));
        Assert.assertTrue(shoppingCartPage.getActualTitleEmptyCart().contains("Shopping Cart  (0.15kg)"));
    }
}
