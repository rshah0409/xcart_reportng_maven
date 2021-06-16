package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class HotDealsPage extends Utility {
    By hoverToHotDeals = By.xpath( "//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span" );
    By clickOnsales = By.xpath( "//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[1]/a/span" );
    By salespageText = By.xpath( "//h1[@id='page-title']" );
    By hoverToSortBy = By.xpath( "//span[@class='sort-by-label']" );
    By selectAToZ = By.xpath( "//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[5]/a" );
    By aToZText = By.xpath( "//ul[@class='products-grid grid-list']/li/div/div/a/following::h5/child::a[@class='fn url next-previous-assigned']" );
    By selectPriceLowToHigh = By.xpath( "//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[3]/a" );
    By priceLowToHighText = By.xpath( "//span[text()='Price Low - High']" );
    By selectRates = By.xpath( "//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[7]/a" );
    By ratesText = By.xpath( "//span[text()='Rates ']" );
    By clickOnBestSellers = By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span");
    By bestSellersPageText = By.xpath( "//h1[@id='page-title']" );
    By hoverToSortByOnBs = By.cssSelector( "body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-bestsellers.one-sidebar.sidebar-first.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.clearfix div.flex-container div.column:nth-child(3) div.section div.list-container:nth-child(2) div.block.block-block.block-bestsellers:nth-child(4) div.content div.items-list.items-list-products div.list-header:nth-child(3) div.sort-box div:nth-child(1) > span.sort-by-value" );
    By selectZToA = By.xpath( "//*[@id=\"XLite-Module-CDev-Bestsellers-View-BestsellersPage-sortby-1\"]/li[5]/a" );
    By selectPriceHighToLow = By.xpath( "//*[@id=\"XLite-Module-CDev-Bestsellers-View-BestsellersPage-sortby-1\"]/li[3]/a" );
    By selectByRates = By.xpath( "//*[@id=\"XLite-Module-CDev-Bestsellers-View-BestsellersPage-sortby-1\"]/li[6]/a" );



    public void mouseHoverToHotDealsAndClickOnSales() {
        Reporter.log( "mouse Hover To hotdeals and click on sales" + hoverToHotDeals.toString() + clickOnsales.toString() );
        mouseHoverToElement( hoverToHotDeals );
        clickOnElement( clickOnsales );

    }

    public String verifySalesPageText() {
        Reporter.log( "text on sales page" + salespageText.toString() );
        return getTextFromElement( salespageText );
    }

    public void mouseHoverToSortByAndSelectAToZ() {
        Reporter.log( "hover to sort by and select a to z" + hoverToSortBy.toString() + selectAToZ.toString() );
        mouseHoverToElement( hoverToSortBy );
        clickOnElement( selectAToZ );
    }

    public String verifyAToZTproductList() {
          Reporter.log( "A To Z text"  +aToZText.toString() );
        return getTextFromElement( aToZText );
    }

    public void mouseHoverToSortByAndSelectPriceLowToHigh() {
        Reporter.log( "hover to sort by and select price low to high  " + hoverToSortBy.toString() + selectPriceLowToHigh.toString() );
        mouseHoverToElement( hoverToSortBy );
        clickOnElement( selectPriceLowToHigh );
    }

    public String verifyTextForLowToHigh() {
        Reporter.log( "text for price low to high" + priceLowToHighText.toString() );
        return getTextFromElement( priceLowToHighText );
    }

    public void mousehoverToSortByAndCickOnRates() {
        Reporter.log( "hover to sort by and select rates  " + hoverToSortBy.toString() + selectRates.toString() );
        mouseHoverToElement( hoverToSortBy );
        clickOnElement( selectRates );
    }

    public String verifyTextForRates() {
        Reporter.log( "text for rates" + ratesText.toString() );
        return getTextFromElement( ratesText );
    }

    public void mouseHoverToHotdealsAndClickOnBestSellers() {
        Reporter.log( "clicking on bestsellers" + hoverToHotDeals + clickOnBestSellers );
        mouseHoverToElement( hoverToHotDeals );
        mouseHoverToElement( clickOnBestSellers );
        clickOnElement( clickOnBestSellers );
    }

    public String verifyBestsellersPageText() {
        Reporter.log( "Bestseller page text" + bestSellersPageText.toString() );
        return getTextFromElement( bestSellersPageText );
    }

    public void mouseHoverToSortByAndClickOnZToA() {
        Reporter.log( "hover to sort by and clicking on Z to A" + hoverToSortByOnBs + selectZToA );
        mouseHoverToElement( hoverToSortByOnBs );
        clickOnElement( selectZToA );
    }

    public void mouseHoverToSortByAndClickOnPriceHighToLow() {
        Reporter.log( "hover to sort by and clicking on Price high to low" + hoverToSortByOnBs + selectPriceHighToLow );
        mouseHoverToElement( hoverToSortByOnBs );
        clickOnElement( selectPriceHighToLow );
    }

    public void mouseHoverToSortByAndClickOnToRates() {
        Reporter.log( "hover to sort by and clicking on Rates" + hoverToSortByOnBs + selectByRates );
        mouseHoverToElement( hoverToSortByOnBs );
        clickOnElement( selectByRates );
    }

}