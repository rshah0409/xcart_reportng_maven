package com.xcart.mobile.pages;

import com.xcart.mobile.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class TopMenuPage extends Utility {
    By shippingTab = By.xpath( "//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[3]/a/span" );
    By shippingTabText = By.xpath("//h1[text()='Shipping']");
    By newTab = By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[4]/a/span");
    By newtabtext = By.xpath("//h1[text()='New arrivals']");
    By comingSoonTab = By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[5]/a");
    By comingSoonTabText = By.xpath("//h1[text()='Coming soon']");
    By contactUsTab = By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[6]/a");
    By contactusTabText = By.id("page-title");

   public  void clickOnShippingTab() {
       Reporter.log( "clicking on shipping tab" + shippingTab.toString() );
       clickOnElement( shippingTab );
   }
   public String verifyShippingTabtext(){
       Reporter.log( "verify shipping tab text" + shippingTabText.toString() );
        return getTextFromElement( shippingTabText );
    }


   public  void  clickOnNewTab(){
       Reporter.log( "clicking on new tab"  +newTab.toString() );
       clickOnElement( newTab );
   }
   public  String verifyNewTabText(){
       Reporter.log( "verify new tab text" +newtabtext.toString());
       return  getTextFromElement( newtabtext );
   }

   public  void   clickOnComingSoonTab(){
        Reporter.log( "clicking on comingSoon tab"  +comingSoonTab.toString() );
        clickOnElement( comingSoonTab );

    }
    public String verifyComingSoonTabtext(){
        Reporter.log( "verufy comingsoon tab text" +comingSoonTabText.toString());
        return  getTextFromElement( comingSoonTabText );


    }
    public  void   clickOnContactUsTab(){
        Reporter.log( "clicking on Contactus tab"  +contactUsTab.toString() );
        clickOnElement( contactUsTab);

    }
    public  String verifyContactUsTabText(){
        Reporter.log( "verufy contactus tab text" +contactusTabText.toString());
        return  getTextFromElement( contactusTabText);
    }
}
