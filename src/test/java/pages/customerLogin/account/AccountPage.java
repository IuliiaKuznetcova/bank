package pages.customerLogin.account;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;
import pages.wait.Wait;

public class AccountPage extends PageBase {

    Wait wait;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@ng-click='byebye()']") //проверка страницы на уникальность (наличие кнопки logoutn)
    protected WebElement logoutButton;

    public void waitForLoading() {                //метод будет ждать загрузку элемента
        wait = new Wait(driver);
        wait.forVisibility(logoutButton);
    }
}
