package pages.customerLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import pages.wait.Wait;

public class CustomerLoginPage extends PageBase {
    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    Wait wait;

    public void waitForLoading() {                //метод будет ждать загрузку элемента, кнопки логина нет
        wait = new Wait(driver);
        wait.forVisibility(userSelect);
    }

    @FindBy(id = "userSelect")
    protected WebElement userSelect;

    @FindBy(xpath = "//*[@type='submit']")
    protected WebElement loginButton;       //не отображается, поэтому его ожидание не нужно

    public void selectExistingUser(String userName) {
        selectOption(userName, userSelect);
    }

    public void clickOnLoginButton() {
        click(loginButton);
    }

    //проверка на видимость LoginButton
    public void checkForVisibilityLoginButton() {
        wait.forVisibility(loginButton);
    }
}



