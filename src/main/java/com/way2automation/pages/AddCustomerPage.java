package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.openqa.selenium.By;

public class AddCustomerPage extends Utility {
By addCustomer=By.xpath("//button[@ng-class='btnClass1']");
public  void addCustomer(){
    clickOnElement(addCustomer);
}


}
