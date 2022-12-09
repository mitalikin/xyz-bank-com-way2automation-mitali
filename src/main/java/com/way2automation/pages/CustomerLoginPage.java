package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.openqa.selenium.By;

public class CustomerLoginPage extends Utility {
By customerLogin=By.xpath("//button[contains(text(),'Customer Login')]");

public void customerLogin1(){
  clickOnElement(customerLogin);

}
    //search customer that you created.

    By searchCustomer1 = By.xpath("//select[@id='userSelect']");//---//select[@id='userSelect']//option[10]----//select[@id='userSelect']//option[11]---//userSelect

    public void setSearchCustomer1(String text) {
        //  clickOnElement(clickOnDropDown);
        selectByVisibleTextFromDropDown(searchCustomer1, text);
    }
By getCustomerLogin=By.xpath("//button[contains(text(),'Login')]");
public void setCustomerLogin(){
    clickOnElement(getCustomerLogin);
}
//verify "Logout" Tab displayed.
By logout=By.xpath("//button[@class='btn logout']");//---------
    public String verifyLogout(){
    return getTextFromElement(logout);

}
    //click on "Logout"
    By logout1=By.xpath("//button[contains(text(),'Logout')]");
    public void logout1(){
        clickOnElement(logout1);
}


    //verify "Your Name" text displayed.
By verifyYourName=By.xpath("//label[text()='Your Name :']");
    public String verifyYourName(){
        return getTextFromElement(verifyYourName);
    }

}
