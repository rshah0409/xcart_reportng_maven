package com.xcart.mobile.utility;

import com.xcart.mobile.basepage.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Jay
 */
public class Utility extends BasePage {

    /**
     * This method will click on element
     * @param by
     */
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }

    public void clickOnElement(WebElement element){
        element.click();
    }

    /**
     * This method will get text from element
     * @param by
     * @return
     */
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }

    /**
     * This method will send text on element
     * @param by
     * @param text
     */
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will select by value from dropdown
     * @param by
     * @param value
     */
    public void selectByValueFromDropDown(By by, String value){
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    /**
     * This method will used to hover mouse on element
     */
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /**
     * This method will used to select drop down menu by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String str) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(str);
    }

    /**
     * This method will used to wait until element located
     */
    public WebElement waitUntilVisibilityOfElementLocated(By by, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }

    public  static String currentTimeStamp(){
        Date d = new Date();
        return d.toString().replace(":", "_").replace(" ", "_");


    }
    /*
     *Screenshot methods
     */
    public static String takeScreenShot(String fileName) {
        String filePath = System.getProperty("user.dir") + "/test-output/html/";
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File scr1 = screenshot.getScreenshotAs( OutputType.FILE);
        String imageName = fileName + currentTimeStamp() + ".jpg";
        String destination = filePath + imageName;
        try {
            FileUtils.copyFile(scr1, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destination;
    }



}
