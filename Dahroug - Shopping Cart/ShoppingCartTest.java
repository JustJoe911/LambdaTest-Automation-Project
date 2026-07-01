package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import projectDEPI.BaseTest;
import projectDEPI.HomePage;
import projectDEPI.LoginPageProject;

public class ShoppingCartTest extends BaseTest {


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
//        Assert.assertEquals(shoppingCartPage.getActualTitleEmptyCart(),shoppingCartPage.getExpectedTitleEmptyCart());
//        Assert.assertEquals(shoppingCartPage.getActualRemoveAll(),shoppingCartPage.getExpectedRemoveAll());
//        Assert.assertEquals(shoppingCartPage.clickContinueAfterRemoveAll(), shoppingCartPage.getExpectButtonAfterRemoveAll());
    }

    @Test
    public void validAddOneProductToTheCart(){
        homePage.enterClickForLogin();
        loginPageProject.login("mail1@gmail.com","12345");
        homePage.clickHomeLink();
        homePage.addProductOneToCart();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
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
    }



    @Test
    public void removeProduct(){
        homePage.enterClickForLogin();
        loginPageProject.login("mail1@gmail.com","12345");
        homePage.clickHomeLink();
        homePage.addProductOneToCart();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        shoppingCartPage.removeFirstProduct();
    }

    @Test
    public void continueShoppingFromTheCartAfterAddProduct(){
        homePage.enterClickForLogin();
        loginPageProject.login("mail1@gmail.com","12345");
        homePage.clickHomeLink();
        homePage.addProductOneToCart();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
        shoppingCartPage.clickContinueShopping();
    }

    @Test
    public void continueShoppingFromTheCartEmpty() {
        homePage.enterClickForLogin();
        loginPageProject.login("mail1@gmail.com", "12345");
        homePage.clickHomeLink();
        homePage.getCartBadgeCount();
        shoppingCartPage = homePage.clickOfCartIcon();
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
        // I can't make Assertion, Help me Please !!
//        Assert.assertEquals(shoppingCartPage.getSubTotal() , shoppingCartPage.getExpectSubTotal());
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
        //  I can't make Assertion, Help me Please !!
//        Assert.assertEquals(shoppingCartPage.getTotalPrice(), shoppingCartPage.getExpectedTotalPrice());
    }

        // I can't test this method (increase and decrease)
//    @Test
//    public void increaseProductQuantity(){
//        homePage.enterClickForLogin();
//        loginPageProject.login("mail1@gmail.com","12345");
//        homePage.clickHomeLink();
//        homePage.addProductOneToCart();
//        shoppingCartPage.clickIncreaseQuantity();
//        homePage.addProductOneToCart();
//        shoppingCartPage = homePage.clickOfCartIcon();
//        shoppingCartPage.clickIncreaseQuantity();
//        shoppingCartPage.clickIncreaseQuantity();
//
//    }

}
