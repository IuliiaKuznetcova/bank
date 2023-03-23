package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.wait.Wait;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    Wait wait;

    @FindBy(xpath = "//*[@ng-click='home()']")  //локатор будет внутри     css = "ng - click"
    protected WebElement homeButton;
    @FindBy(xpath = "//*[@ng-click='customer()']")  //локатор будет внутри
    protected WebElement customerLoginButton;
    @FindBy(xpath = "//*[@ng-click='manager()']")
    //локатор будет внутри
    protected WebElement bankManagerLoginButton;

    public void waitForLoading() {                //метод будет ждать загрузку элемента
        wait = new Wait(driver);
        wait.forVisibility(homeButton);
        wait.forVisibility(customerLoginButton);
        wait.forVisibility(bankManagerLoginButton);
    }

    public void clickOnHomeButton() {
        click(homeButton);
    }

    public void clickOnCustomerLoginButton() {
        click(customerLoginButton);
    }

    public void clickOnBankManagerLoginButton() {
        click(bankManagerLoginButton);
    }
}
