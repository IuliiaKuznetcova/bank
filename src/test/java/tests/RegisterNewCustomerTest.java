package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.bankManagerLogin.BankManagerLoginPage;
import pages.bankManagerLogin.addCastomer.AddCustomerPage;
import pages.bankManagerLogin.customers.CustomersPage;
import pages.bankManagerLogin.openAccount.OpenAccountPage;
import pages.customerLogin.CustomerLoginPage;
import pages.customerLogin.account.AccountPage;

import java.io.IOException;

public class RegisterNewCustomerTest extends TestBase {
    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;

    CustomersPage customersPage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;

    Faker faker = new Faker();
    String firstName = faker.internet().uuid();
    String lastName = faker.internet().uuid();

    //String postCode = "12364";
    String postCode = faker.address().zipCode();
    String firstNameAndLastName = firstName + " " + lastName;
    String currencyValue = "Dollar";

    @Test
    public void registerNewCustomerOpenAccountAndCustomerLogin() throws IOException {

        // on the home page click on the button "Bank Manager Login"
        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        homePage.takeAndCompareScreenshot("homePage", null);
        homePage.clickOnBankManagerLoginButton();

        // on the page "Bank Manager Login" click on the button "Add Customer"
        bankManagerLoginPage = new BankManagerLoginPage(app.driver);
        bankManagerLoginPage.waitForLoading();
        bankManagerLoginPage.openAddCustomerTab();

        // on the page "Add Customer" fill in all fields and click on the button at the bottom left "Add Customer"
        addCustomerPage = new AddCustomerPage(app.driver);                      //initialization
        addCustomerPage.waitForLoading();                                       //page display check
        addCustomerPage.fillAddCustomerForm(firstName, lastName, postCode);     //filling in the fields
        addCustomerPage.clickOnAddCustomerButton();                             //click on the button

        String expectedResult = "Customer added successfully with customer id :";
        String actualResult = addCustomerPage.getAlertText();
        Assert.assertTrue(actualResult.contains(expectedResult));
        addCustomerPage.clickAlertOkButton();

        //on the page "__________" click on the button "Open Account"
        bankManagerLoginPage.openAccountTab();

        // on the page "Open Account" select test data from drop-down menus and click on the button "Process"
        openAccountPage = new OpenAccountPage(app.driver);
        openAccountPage.waitForLoading();
        openAccountPage.selectExistingUser(firstNameAndLastName);
        openAccountPage.selectCurrency(currencyValue);
        openAccountPage.clickOnProcessButton();

        String expectedRes = "Account created successfully with account Number :";
        String actualRes = openAccountPage.getAlertText();
        Assert.assertTrue(actualRes.contains(expectedRes));
        openAccountPage.clickAlertOkButton();

        //click on the button "Home page" and on the home page click on the button "Customer Login"
        homePage.clickOnHomeButton();
        homePage.waitForLoading();
        homePage.clickOnCustomerLoginButton();

        // on the page "Customer Login" select test data from drop-down menus and click on the button "Login"
        customerLoginPage = new CustomerLoginPage(app.driver);
        customerLoginPage.waitForLoading();
        customerLoginPage.selectExistingUser(firstNameAndLastName);
        customerLoginPage.checkForVisibilityLoginButton();
        customerLoginPage.clickOnLoginButton();


        //on the page "Account Page"
        accountPage = new AccountPage(app.driver);
        accountPage.waitForLoading();

        homePage.clickOnHomeButton();
        homePage.waitForLoading();
        homePage.clickOnBankManagerLoginButton();

        bankManagerLoginPage.waitForLoading();
        bankManagerLoginPage.openCustomersTab();

        customersPage = new CustomersPage(app.driver);
        customersPage.waitForLoading();
        customersPage.fillSearchCustomerInput(firstName);
        customersPage.checkExistingCustomer(1);
        customersPage.deleteTableRow(firstName);

    }

    //
    @Test
    public void registrNewUserWithInvalidData() throws IOException {
        //for a screenshot on static data
        String firstName = "invalid firstname";
        String lastName = "invalid lastName";

        homePage = new HomePage(app.driver);
        homePage.waitForLoading();
        homePage.clickOnBankManagerLoginButton();

        bankManagerLoginPage = new BankManagerLoginPage(app.driver);
        bankManagerLoginPage.waitForLoading();
        bankManagerLoginPage.openAddCustomerTab();

        addCustomerPage = new AddCustomerPage(app.driver);
        addCustomerPage.waitForLoading();
        addCustomerPage.fillAddCustomerForm(firstName, lastName, "");
        addCustomerPage.clickOnAddCustomerButton();
        addCustomerPage.takeAndCompareScreenshot("addCustomerPage", null); // 15.25 30.03.23
        //  addCustomerPage.cherckFilledCustomerForm(firstName, lastName, "");   //non-working test

        bankManagerLoginPage.openAccountTab();

        openAccountPage = new OpenAccountPage(app.driver);
        openAccountPage.waitForLoading();
        openAccountPage.checkNotExistingCustomer(firstNameAndLastName);

        homePage.clickOnHomeButton();
        homePage.waitForLoading();
        homePage.clickOnCustomerLoginButton();

        customerLoginPage = new CustomerLoginPage(app.driver);
        customerLoginPage.waitForLoading();
        customerLoginPage.checkNotExistingCustomer(firstNameAndLastName);
    }

}

