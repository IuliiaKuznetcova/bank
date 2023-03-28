package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class AplicationManager {
    public WebDriver driver;

    //для работы в докере
    public WebDriver remoteDriverSelenoid() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("browserName", "firefox");
        options.setCapability("browserVersion", "109.0");
        options.setCapability("enableVNC", true);
        options.setCapability("enableLog", true);

        return new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), options);
    }

    protected void init(boolean useRemoteDriver) throws MalformedURLException {
        if (useRemoteDriver == true) {
            driver = remoteDriverSelenoid();
            System.out.println("Using remote driver (Selenoid)");
        } else {
            WebDriverManager.firefoxdriver().setup();   //ChromeDriver
            driver = new FirefoxDriver();
            System.out.println("Using local FirefoxDriver");
        }

        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/");
        driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    /*protected void stop() {
        if (driver != null) {
            driver.quit();
        }
    }*/

    protected void stop() {
        driver.quit();
    }
}
