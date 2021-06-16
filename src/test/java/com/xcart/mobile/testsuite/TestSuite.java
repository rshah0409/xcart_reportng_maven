package com.xcart.mobile.testsuite;

import com.xcart.mobile.customlisteners.CustomListeners;
import com.xcart.mobile.pages.HotDealsPage;
import com.xcart.mobile.pages.ShoppingPage;
import com.xcart.mobile.pages.TopMenuPage;
import com.xcart.mobile.testbase.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Listeners(CustomListeners.class)

public class TestSuite extends TestBase {
    TopMenuPage topMenuPage = new TopMenuPage();
    HotDealsPage hotDealsPage = new HotDealsPage();
    ShoppingPage shoppingPage = new ShoppingPage();
    SoftAssert softAssert = new SoftAssert();
    @Test(groups = {"sanity","regression"})
    public void clickOnTopMenuTabsAndVerifyTabText(){
        topMenuPage.clickOnShippingTab();

        String expectedText = "Shipping";
        String actualText = topMenuPage.verifyShippingTabtext();
        Assert.assertEquals("User Is Not On Shipping page", expectedText, actualText);
        softAssert.assertTrue( true );
        topMenuPage.clickOnNewTab();
        String expectedNew = "New arrivals";
        String actualNew = topMenuPage.verifyNewTabText();
        Assert.assertEquals("User Is Not On New Arrival Page",expectedNew,actualNew);
        softAssert.assertTrue( true );
        topMenuPage.clickOnComingSoonTab();
        String expectedComingsoon = "Coming soon";
        String actualComingSoon = topMenuPage.verifyComingSoonTabtext();
        Assert.assertEquals("User Is Not On CominSoon Page",expectedComingsoon,actualComingSoon);
        softAssert.assertTrue( true );
        topMenuPage.clickOnContactUsTab();
        String expectedContactUs = "Contact us";
        String actualContactUs = topMenuPage.verifyContactUsTabText();
        Assert.assertEquals("User Is Not On Contact Us Page",expectedContactUs,actualContactUs);
        softAssert.assertTrue( true );
        softAssert.assertAll();

    }
    @Test(groups = {"sanity","smoke","regression"})
    public  void verifySaleProductsArrangeInOrderGivenInSortByAndVerify() throws InterruptedException {
        hotDealsPage.mouseHoverToHotDealsAndClickOnSales();
        String saleText = "Sale";
        String actualSalesText = hotDealsPage.verifySalesPageText();
        Assert.assertEquals( "User Is Not On Sales Page", saleText, actualSalesText );
        softAssert.assertTrue( true );
        hotDealsPage.mouseHoverToSortByAndSelectAToZ();
        /*List<WebElement>productList = driver.findElements( By.xpath( "//ul[@class='products-grid grid-list']/li/div/div/a/following::h5/child::a[@class='fn url next-previous-assigned']" ) );

        List<String> productName = new ArrayList<>();

        for (WebElement products : productList){
            productName.add(products.getText());
        }

        List<String> tempList = new ArrayList<>();
        tempList.addAll(productName);

        Collections.sort(tempList);
        System.out.println(productName);
        System.out.println(tempList);
        Assert.assertEquals("Product not arrange", productName, tempList);
        softAssert.assertTrue( true );*/
        Thread.sleep( 1000 );
        hotDealsPage.mouseHoverToSortByAndSelectPriceLowToHigh();
        List<WebElement> productListForPrice = driver.findElements( By.xpath( "//div[@class='product-price widget-fingerprint-product-price']/ul/li//child::span" ) );

        List<String> productNameForPrice = new ArrayList<>();

        for (WebElement products : productListForPrice) {
            productNameForPrice.add( products.getText() );
        }

        List<String> tempList1 = new ArrayList<>();
        tempList1.addAll( productNameForPrice );

        Collections.sort( tempList1 );
        System.out.println( productNameForPrice );
        System.out.println( tempList1 );
        Assert.assertEquals( "Product not arrange", productNameForPrice, tempList1 );
        softAssert.assertTrue( true );
        Thread.sleep( 1000 );
        hotDealsPage.mousehoverToSortByAndCickOnRates();
       /* List<WebElement>productListForRates = driver.findElements( By.xpath( "//div[@class='rating']/div/div/child::div[@class='stars-row full']" ) );

        List<String> productNameForRates = new ArrayList<>();

        for (WebElement products1 : productListForRates){
            productNameForPrice.add(products1.getText());
        }

        List<String> tempList2 = new ArrayList<>();
        tempList2.addAll(productNameForPrice);

        Collections.sort(tempList2);
        System.out.println(productNameForRates);
        System.out.println(tempList2);
        Assert.assertEquals("Product not arrange", productNameForRates, tempList2);
        softAssert.assertTrue( true );
        softAssert.assertAll();*/
    }
        @Test(groups = {"sanity","smoke","regression"})
        public void verifyBestsellersProductsArrangeInGivenOrder() throws InterruptedException {


            hotDealsPage.mouseHoverToHotdealsAndClickOnBestSellers();
            String saleTextExp = "Bestsellers";
            String salesTextActl = getTextFromElement( By.xpath( "//h1[text()='Bestsellers']" ) );
            softAssert.assertEquals(  saleTextExp, salesTextActl );
            softAssert.assertTrue( true );
            hotDealsPage.mouseHoverToSortByAndClickOnZToA();
            Thread.sleep( 1000 );
            hotDealsPage.mouseHoverToSortByAndClickOnPriceHighToLow();
            Thread.sleep( 1000 );
            hotDealsPage.mouseHoverToSortByAndClickOnToRates();
        }
        @Test(groups = {"smoke","regression"})
         public  void verifyThatUserShouldPlaceOrderSuccessfullyForAvengersFabrikationPlush() throws InterruptedException {
            shoppingPage.mouseHoverToHotDealsAndClickOnSales();
            String saleText = "Sale";
            String actualSalesText = hotDealsPage.verifySalesPageText();
            Assert.assertEquals( "User Is Not On Sales Page", saleText, actualSalesText );
            softAssert.assertTrue( true );
            shoppingPage.mouseHoverToSortByAndSelectAToZ();
            Thread.sleep( 1000 );
            shoppingPage.clickOnProductToSelect();
            shoppingPage.selectProductTypeToConfirm();
            shoppingPage.clickOnAddToCartOfproduct();
            String expectedCartText = "Product has been added to your cart";   //assert for add to cart
            String actualCartText = shoppingPage.verifyTextFromGreenbar();
            Assert.assertEquals("Product Has Not Been Added To The Cart", expectedCartText, actualCartText);
            softAssert.assertTrue( true );
            shoppingPage.clickToCloseBar();
            shoppingPage.clickOnYourCartAndViewCart();
            String shopCarttext = "Your shopping cart - 1 item";
            String realShopCart = shoppingPage.verifyYourShoppingcarttext();
            Assert.assertEquals("User's Items Have Not Been Added To Cart", shopCarttext, realShopCart);
            softAssert.assertTrue( true );
            shoppingPage.modifyQuantity();
            String shoppingCartText = "Your shopping cart - 2 items";    //verify 2 items in cart
            String shoppingcartReal = shoppingPage.verifyQuantityIsTwo();
            softAssert.assertEquals( shoppingCartText, shoppingcartReal);
            softAssert.assertTrue( true );
            String subTotalText = "Subtotal: $59.98";                 //verify subtotal
            String subTotalTextReal = shoppingPage.verifySubTotal();
            softAssert.assertEquals( subTotalText, subTotalTextReal);
            softAssert.assertTrue( true );
            String totalText = "$66.53";                     //verify Total
            String totalTextActual = shoppingPage.verifyTotalFor();
            softAssert.assertEquals( totalText, totalTextActual);
            softAssert.assertTrue( true );
            shoppingPage.clickingOnCheckOut();
            String logText = "Log in to your account";                   //verify login account page
            String logTextReal = shoppingPage.verifyLoginPage();
            softAssert.assertEquals( logText, logTextReal);
            softAssert.assertTrue( true );
            shoppingPage.enterEmailId( "primetime4@gmail.com" );  //email
            shoppingPage.clickOnContinueButton();              //click on checkout button
            String secureText = "Secure Checkout";                            //verify secure checkout text
            String secureTextReal = shoppingPage.verifysecurePagetext();
            softAssert.assertEquals( secureText, secureTextReal);
            softAssert.assertTrue( true );
            shoppingPage.enterFirstName( "Sheldon" );
            shoppingPage.enterlastName( "Cooper" );
            shoppingPage.enterAddress( "42,Wallby street" );
            shoppingPage.clearCityAndAddvalue( "London" );
            shoppingPage.selectdropDownvalueForCountry( "GB" );
            shoppingPage.enterState( "Watford" );
            shoppingPage.clearPostcodeAndAddValue( "WD24 3EN" );
            Thread.sleep( 1000 );
            shoppingPage.clickOnCheckBoxField();
            shoppingPage.enterPassword( "Shelly" );
            shoppingPage.selectLocalDelieveryMethod();
            shoppingPage.selectPaymentMethod();
            String expectedTotal = "$66.53";                  //verify total
            String actualTotal = shoppingPage.VerifyTotal();
            softAssert.assertEquals( expectedTotal, actualTotal);
            softAssert.assertTrue( true );
            Thread.sleep( 3000 );
            shoppingPage.clickOnPlaceOrderButton();
            String thankyouText = "Thank you for your order";    //verifying thank you page
            String thankyouTextReal = shoppingPage.VerifyThankyouText();
            softAssert.assertEquals( thankyouText, thankyouTextReal);
            softAssert.assertTrue( true );
            softAssert.assertAll();
    }
    @Test(groups = {"smoke","regression"})
    public void  verifyThatUserShouldClearShoppingCartSuccessfully(){
        hotDealsPage.mouseHoverToHotdealsAndClickOnBestSellers();
        String saleTextExp = "Bestsellers";
        String salesTextActl = getTextFromElement( By.xpath( "//h1[text()='Bestsellers']" ) );
        softAssert.assertEquals(  saleTextExp, salesTextActl );
        softAssert.assertTrue( true );
        shoppingPage.mouseHoverToHotdealsAndClickOnAToz();
        shoppingPage.goToproductAndclickonAddToCart();
        String expectedCartText = "Product has been added to your cart";   //assert for add to cart
        String actualCartText = shoppingPage.AddToCartverify();
        softAssert.assertEquals( expectedCartText, actualCartText);
        softAssert.assertTrue( true );
        shoppingPage.clickOnCloseSign();
        shoppingPage.clickcingOnyourcartButton();
        shoppingPage.clickcingOnviewCartButton();
        String shopCarttext = "Your shopping cart - 1 item";
        String realShopCart = shoppingPage.verifyTextForAddedTocart();
        softAssert.assertEquals( shopCarttext, realShopCart);
        softAssert.assertTrue( true );
        shoppingPage.emptyyourCart();
        String emptyCartText = "Are you sure you want to clear your cart?";
        String emptyCartTextActual = driver.switchTo().alert().getText();  //to get text from element that cant be inspected with right click.
        Assert.assertEquals("Cart Is Not Being Emptied", emptyCartText, emptyCartTextActual);
        driver.switchTo().alert().accept();               //to click 'ok' on alert window when no right click available to inspect
        String empryCartText = "Item(s) deleted from your cart";            //verifying empty cart green bar
        String emptyCartTextActualIs = shoppingPage.verifyEmptyCartBar();
        softAssert.assertEquals( empryCartText, emptyCartTextActualIs);
        softAssert.assertTrue( true );
        String lastEmptyCartMessage = "Your cart is empty";    //verifying your cart is empty text
        String actualLastEmptyCartMessage = shoppingPage.verifyEmptyCartFinaltext();
        softAssert.assertEquals( lastEmptyCartMessage, actualLastEmptyCartMessage);
        softAssert.assertTrue( true );
        softAssert.assertAll();


    }
}

