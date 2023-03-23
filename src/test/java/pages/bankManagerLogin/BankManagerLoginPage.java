package pages.bankManagerLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class BankManagerLoginPage extends PageBase {
    public BankManagerLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@ng-click='addCust()']")
    private WebElement addCastomerTab;

    @FindBy(xpath = "//*[@ng-click='openAccount()']")
    private WebElement openAccountTab;

    @FindBy(xpath = "//*[@ng-click='showCust()']")
    private WebElement customersTab;

    public void openAddCustomerTab() {
        click(addCastomerTab);
    }

    public void openAccountTab() {
        click(addCastomerTab);
    }

    public void opencustomersTab() {
        click(addCastomerTab);
    }
}
