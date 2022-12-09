package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.openqa.selenium.By;

public class OpenAccountPage extends Utility {

    By openAccount = By.xpath("//button[@ng-click='openAccount()']");

    public void setOpenAccount() {
        clickOnElement(openAccount);
    }

    //Search customer that created in first test
    //By clickOnDropDown=By.xpath("//select[@id='userSelect']");
    By searchCustomer = By.xpath("//select[@id='userSelect']");//---//select[@id='userSelect']//option[10]----//select[@id='userSelect']//option[11]---//userSelect

    public void setSearchCustomer(String text) {
        //  clickOnElement(clickOnDropDown);
        selectByVisibleTextFromDropDown(searchCustomer, text);
    }

    //Select currency "Pound"
    By searchCurrency = By.id("currency");//---//select[@id='userSelect']//option[10]----//select[@id='userSelect']//option[11]

    public void setSearchCurrency(String text) {
        //  clickOnElement(clickOnDropDown);
        selectByVisibleTextFromDropDown(searchCurrency, text);
    }

    // click on "process" button
    By clickOnProcessButton = By.xpath("//button[contains(text(),'Process')]");

    public void clickOnProcess() {
          clickOnElement(clickOnProcessButton);

    }
// popup displayed
// verify message "Account created successfully"
    public String verifyGetText1(){
        return getTextFromAlert();

    }
    public  void alertAccept1(){
        driver.switchTo().alert().getText();
        // click on "ok" button on popup.

}}