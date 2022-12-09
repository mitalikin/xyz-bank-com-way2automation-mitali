package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BankManagerLoginPage extends Utility {
    By clickOnBankManagerLoginTab=By.xpath("//div[@class='borderM box padT20']/child::div[2]/button");
public void clickOnBankManagerLoginTab(){
    clickOnElement(clickOnBankManagerLoginTab);
}

By clickOnAddCustomer=By.xpath("//div[@class='center']/button[1]");
public void clickOnAddCustomer(){
    clickOnElement(clickOnAddCustomer);
}
    public void contextRightClickAction(By by){
        WebElement button =driver.findElement(by);
        Actions act = new Actions(driver);
        // act.contextClick(button).build().perform();
        act.contextClick(button).perform();
    }


}
