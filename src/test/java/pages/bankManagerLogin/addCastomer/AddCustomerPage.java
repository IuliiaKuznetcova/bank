package pages.bankManagerLogin.addCastomer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import pages.wait.Wait;

public class AddCustomerPage extends PageBase {

    public AddCustomerPage(WebDriver driver) {
        super(driver);
    }

    Wait wait;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    protected WebElement firstNameField;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    protected WebElement lastNameField;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    protected WebElement postCodeField;
    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement addCustomerButton;

    public void waitForLoading() {                //метод будет ждать загрузку элемента
        wait = new Wait(driver);
        wait.forVisibility(firstNameField);
        wait.forVisibility(lastNameField);
        wait.forVisibility(postCodeField);
        wait.forVisibility(addCustomerButton);
    }

    public void fillAddCustomerForm(String firstName, String lastName, String postCode) {
        fillField(firstNameField, firstName);
        fillField(lastNameField, lastName);
        fillField(postCodeField, postCode);
    }

    //non-working test
/*    public void cherckFilledCustomerForm(String firstName, String lastName, String postCode) {
        String err = "unvalif text in add customer form";
        checkItemText(firstNameField, firstName, err);
        checkItemText(lastNameField, lastName, err);
        checkItemText(postCodeField, postCode, err);
    }*/

    public void clickOnAddCustomerButton() {
        click(addCustomerButton);
    }
}
