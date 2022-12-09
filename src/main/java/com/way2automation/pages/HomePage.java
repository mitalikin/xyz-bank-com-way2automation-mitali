package com.way2automation.pages;

import com.way2automation.utility.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {
    By clickOnHomePage = By.xpath("//button[contains(text(),'Home')]");

    public void clickOnHomePage() {
        clickOnElement(clickOnHomePage);


    }
}