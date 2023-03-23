package pages.wait;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {
    WebDriver driver;
    public WebDriverWait wait;
    Duration TIMEOUT = Duration.ofSeconds(10);

    public Wait(WebDriver driver) {
        this.driver = driver;
    }


    public WebDriverWait setWait() {
        wait = new WebDriverWait(driver, TIMEOUT);
        return wait;
    }

    // элемент виден
    public void forVisibility(WebElement element) {
        try {
            setWait().until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    // элемент не виден
    public void forInVisibility(WebElement element) {
        try {
            setWait().until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

/*    //отображается в доме
    public void forPresence(WebElement element) {
        try {
            setWait().until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }*/


}