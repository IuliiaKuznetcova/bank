package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.bankManagerLogin.BankManagerLoginPage;
import pages.bankManagerLogin.addCastomer.AddCustomerPage;
import pages.bankManagerLogin.openAccount.OpenAccountPage;
import pages.customerLogin.CustomerLoginPage;
import pages.customerLogin.account.AccountPage;

import java.io.IOException;

public class RegisterNewCustomerTest extends TestBase {
    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastname = faker.name().lastName();
    String firstNameAndLastNameLastName = firstName + " " + lastname;
    String postCode = "12364";

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
        addCustomerPage.fillAddCustomerForm(firstName, lastname, postCode);     //filling in the fields
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
        openAccountPage.selectExistingUser(firstNameAndLastNameLastName);
        openAccountPage.selectCurrency("Dollar");
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
        customerLoginPage.selectExistingUser(firstNameAndLastNameLastName);
        customerLoginPage.clickOnLoginButton();

        //on the page "Account Page"
        accountPage = new AccountPage(app.driver);
        accountPage.waitForLoading();
    }
}

