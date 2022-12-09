package com.way2automation.utility;

import com.way2automation.browserfactory.ManageBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Utility extends ManageBrowser {
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        WebElement loginLink = driver.findElement(by);
        loginLink.click();

    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
        // WebElement emailField = driver.findElement(by);
        //Type email to email field
        // emailField.sendKeys(text);
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
        //WebElement actualTextMessageElement = driver.findElement(by);
        //   return actualTextMessageElement.getText();
    }


    //====================AlertMethods================================================================
    /*Homework 4 methods--- acceptAlert,dismissAlert,  String getTextFromAlert, sendTextToAlert(String text)
     */
    /**
     * This method will switch to alert
     */
    public void switchToAlert() {
        driver.switchTo().alert();
    }

    /**
     * This method will accept alert
     */
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    /**
     * This method will dismiss alert
     */
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    /**
     * This method will get text from alert
     */
    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    /**
     * This method will send text from alert
     */
    public void sendTextToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //********************Select class Method***************


    /**
     * This method will select the option by visible text
     */
    public void selectByVisibleTextFromDropDown(By by, String text) {

        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        //select by visible text
        select.selectByVisibleText(text);
    }


    /**
     * This method will select the option by value
     */
    public void selectByValueFromDropDown(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
      /*  WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(value);*/
    }

    /**
     * This method will select the option by index(int)
     */

    public void selectByIndexFromDropDown(By by, int index) {
        new Select(driver.findElement(by)).selectByIndex(index);
        /*  WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByIndex(index);*/
    }

    /**
     * This method will select the option by contains text
     */
    public void selectByContainsTextFromDropDown(By by, String text) {
        List<WebElement> allOptions = new Select(driver.findElement(by)).getOptions();
        for (WebElement options : allOptions) {
            if (options.getText().contains(text)) {
                options.click();
            }
        }
    }
    //****************************************************************
    public void selectMyAccountOptions(By myAccountOptions, String option) {
        List<WebElement> myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }


    }






    //***************************** Window Handle ************************************

    /**
     * This method will close all windows
     */
    public void closeAllWindows(List<String> hList, String parentWindow) {
        for (String str : hList) {
            if (!str.equals(parentWindow)) {
                driver.switchTo().window(str).close();
            }
        }
    }

    /**
     * This method will switch to parent window
     */
    public void switchToParentWindow(String parentWindowId) {
        driver.switchTo().window(parentWindowId);
    }

    /**
     * This method will find that we switch to right window
     */
    public boolean switchToRightWindow(String windowTitle, List<String> hList) {
        for (String str : hList) {
            String title = driver.switchTo().window(str).getTitle();
            if (title.contains(windowTitle)) {
                System.out.println("Found the right window....");
                return true;
            }
        }
        return false;
    }
    //***************************** Action Class *************************************
    // mouseHoverToElement(By by)
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoverElement = driver.findElement(by);
        //mouseHoverToElement(by);
        actions.moveToElement(mouseHoverElement).build().perform();

    }

    //mouseHoverToElementAndClick(By by)
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoverClick = driver.findElement(by);
        // actions.moveToElement(mouseHoverClick).click().build().perform();
        actions.moveToElement(mouseHoverClick).click().build().perform();
    }
//****************************Action Method**************************************//

    public void mouseHoverOnElementAndClickk(By by , By by2) {
        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(by);
        WebElement hoverAgain = driver.findElement(by2);
        actions.moveToElement(hover).moveToElement(hoverAgain).click().perform();
    }
    //******clear and update quantity
    public void clearAndEnterQuantity(By by,String text) {
        Actions action = new Actions(driver);
        WebElement qty = driver.findElement(by);
        qty.click();
        qty.clear();
        qty.sendKeys(text);
    }
    //*************dragAndDrop(By by, By by2)
    public void dragAndDrop(By by, By by2){
        WebElement drag = driver.findElement(by);
        WebElement drop = driver.findElement(by2);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
    }
    //***************contextRightClickAction(By by)
    public void contextRightClickAction(By by){
        WebElement button =driver.findElement(by);
        Actions act = new Actions(driver);
        // act.contextClick(button).build().perform();
        act.contextClick(button).perform();
    }
    //*****************doubleCLick(By by)
    public void doubleCLick(By by){
        WebElement button =driver.findElement(by);
        Actions act = new Actions(driver);
        act.doubleClick(button).perform();

    }


//************************** Waits Methods *********************************************//

    /**
     * This method will use to wait until  VisibilityOfElementLocated
     */
    public WebElement waitUntilVisibilityOfElementLocated(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForElementWithFluentWait(By by, int time, int pollingTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(pollingTime))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
        return element;
    }
}







