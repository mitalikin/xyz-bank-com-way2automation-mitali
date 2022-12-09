package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.openqa.selenium.By;

public class CustomerPage extends Utility {
    By enterFirstName=By.xpath("//input[@placeholder='First Name']");
    public void enterFirstName(String firstname){
        sendTextToElement(enterFirstName,firstname);
    }
    By enterLastName=By.xpath("//input[@placeholder='Last Name']");
    public void enterLastName(String lastname){
        sendTextToElement(enterLastName,lastname);
    }

    By enterPostCode=By.xpath("//input[@placeholder='Post Code']");
    public void enterPostCode(String postcode){
        sendTextToElement(enterPostCode,postcode);
    }
    By clickOnAddCustomer=By.xpath("//button[@class='btn btn-default']");
    public void clickOnAddCustomer(){
        clickOnElement(clickOnAddCustomer);
    }

    public String verifyGetText(){
     return getTextFromAlert();

    }
public  void alertAccept1(){
driver.switchTo().alert().accept();

    }
}
