package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


//по аналогии с commenhelpers
public class PageBase {
    public WebDriver driver;

    /*    Wait wait;*/  // убрать, в том числе и в click, потому что это
    // нарушение принципа о единственной наследственности методов

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);   //for find By
    }

    public void click(WebElement element) {
  /*      wait = new Wait(driver);
        wait.forInVisibility(element);*/
        element.click();
    }

    //for select выпадающее меню
    public void selectOption(String optionName, WebElement selectElement) {
        Select select = new Select(selectElement);
        select.selectByVisibleText(optionName);

    }

    //сравнить
   /* public void fillField(String userData, By WebElement) {
        driver.findElement(WebElement).click();
        driver.findElement(WebElement).clear();
        driver.findElement(WebElement).sendKeys(userData);
    }*/

    public void fillField(WebElement field, String text) {
        // field.click();
        click(field);
        field.clear();
        field.sendKeys(text);
    }

}
