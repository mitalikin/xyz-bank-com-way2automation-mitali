package com.way2automation.pages;

import com.way2automation.utility.Utility;
import javafx.scene.control.Tab;
import org.openqa.selenium.By;

public class AccountPage extends Utility {
   // click on "Deposit" Tab
    By clickOnDeposit=By.xpath("//button[@ng-class='btnClass2']");
public void setClickOnDeposit(){
    clickOnElement(clickOnDeposit);
}
// Enter amount 100
    By enterAmount=By.xpath("//input[@ng-model='amount']");
public void enterAmount(String text){
    sendTextToElement(enterAmount,text);
}
    // click on "Deposit" Button
    By deposit=By.xpath("//button[@type='submit']");
public void setDeposit(){
    clickOnElement(deposit);
}
    //click on "Withdrawl" Tab
    By withdraw=By.xpath("//button[@ng-class='btnClass3']");
    public void setWithdraw(){
        clickOnElement(withdraw);
    }
    //Enter amount 50

    By enterAmount1=By.xpath("//input[@ng-model='amount']");
    public void enterAmount1(String text){
        sendTextToElement(enterAmount1,text);
    }
    //click on "Withdraw" Button
    By getWithdraw=By.xpath("//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]");//--//input[@ng-model='amount']
    public void setWithdraw1(){
        clickOnElement(getWithdraw);
    }
    //--//div//span[@class='error ng-binding'and@ng-show='message']
    By verifyTransactionSuccessful=By.xpath("//body[1]/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/span[contains(text(),'Transaction successful')]");
    public String verifyTransaction(){
        return getTextFromElement(verifyTransactionSuccessful);
    }




}
