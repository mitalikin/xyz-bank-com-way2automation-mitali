package com.way2automation.testsuite;

import com.way2automation.pages.*;
import com.way2automation.testbase.BaseTest;
import javafx.scene.control.Tab;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankTest extends BaseTest {
    AccountPage accountPage = new AccountPage();
    AddCustomerPage addCustomerPage = new AddCustomerPage();
    BankManagerLoginPage bankManagerLoginPage = new BankManagerLoginPage();
    CustomerLoginPage customerLoginPage = new CustomerLoginPage();
    CustomerPage customerPage = new CustomerPage();

    HomePage homePage = new HomePage();
    OpenAccountPage openAccountPage = new OpenAccountPage();

    @Test
    public void homePage() {
        homePage.clickOnHomePage();

    }

    @Test
    public void bankManagerShouldAddCustomerSuccessfully() {
        //click On "Bank Manager Login" Tab
        bankManagerLoginPage.clickOnBankManagerLoginTab();
        //click On "Add Customer" Tab
        addCustomerPage.addCustomer();
        //enter FirstName
        customerPage.enterFirstName("Harry");
        //enter LastName
        customerPage.enterLastName("Potter");
        //enter PostCode
        customerPage.enterPostCode("wd12 2tr");
        //click On "Add Customer" Button
        customerPage.clickOnAddCustomer();
        //popup display
        //verify message "Customer added successfully"
        String expectedMessage = "Customer added successfully with customer id :6";

        Assert.assertEquals(customerPage.verifyGetText(), expectedMessage, "Message is not displayed");

        //click on "ok" button on popup.

        customerPage.alertAccept1();
    }

    @Test
    public void bankManagerShouldOpenAccountSuccessfully() {

        //click On "Bank Manager Login" Tab
        bankManagerLoginPage.clickOnBankManagerLoginTab();
        //click On "Open Account" Tab
        openAccountPage.setOpenAccount();
        //Search customer that created in first test
        openAccountPage.setSearchCustomer("Harry Potter");
        // openAccountPage.setSearchCustomer("John Clark");
        //Select currency "Pound"
        openAccountPage.setSearchCurrency("Pound");
        // click on "process" button
        openAccountPage.clickOnProcess();
        // popup displayed
        // verify message "Account created successfully"
        String expectedMessage2 = "Account created successfully with account Number :1016";
        Assert.assertEquals(openAccountPage.verifyGetText1(), expectedMessage2, "Message is not displayed");
        openAccountPage.alertAccept1();
        // click on "ok" button on popup.
        openAccountPage.alertAccept1();

    }

    @Test
    public void customerShouldLoginAndLogoutSuccessfully() {
        // click on "Customer Login" Tab
        customerLoginPage.customerLogin1();
        //search customer that you created.
        customerLoginPage.setSearchCustomer1("Harry Potter");
        //click on "Login" Button
        customerLoginPage.setCustomerLogin();
        //verify "Logout" Tab displayed.
        String expectedMessage3 = "Logout";
        Assert.assertEquals(customerLoginPage.verifyLogout(), expectedMessage3, "Message is not displayed");
        //click on "Logout"
        customerLoginPage.logout1();
        //verify "Your Name" text displayed.
        String expectedMessage4 = "Your Name :";
        Assert.assertEquals(customerLoginPage.verifyYourName(), expectedMessage4, "Message is not displayed");
    }

    @Test
    public void customerShouldDepositMoneySuccessfully() {
        //click on "Customer Login" Tab
        customerLoginPage.customerLogin1();
        //search customer that you created.
        customerLoginPage.setSearchCustomer1("Harry Potter");
        //      click on "Login" Button
        customerLoginPage.setCustomerLogin();
        //click on "Deposit" Tab
        accountPage.setClickOnDeposit();
        // Enter amount 100
        accountPage.enterAmount("100");
        // click on "Deposit" Button
        accountPage.setDeposit();

    }

    @Test
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {

        // click on "Customer Login" Tab
        customerLoginPage.customerLogin1();
        //search customer that you created.
        customerLoginPage.setSearchCustomer1("Harry Potter");
        //      click on "Login" Button
        customerLoginPage.setCustomerLogin();
        //click on "Withdrawl" Tab
        accountPage.setWithdraw();
        //Enter amount 50
        accountPage.enterAmount1("50");
        //click on "Withdraw" Button
        accountPage.setWithdraw1();
        //verify message "Transaction Successful"
        Thread.sleep(1000);
        String expectedMessage5 = "Transaction successful";
        Assert.assertEquals(accountPage.verifyTransaction(), expectedMessage5, "Message is not displayed");

    }


}
