package utils.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.Utils;

import java.util.concurrent.TimeUnit;

public class Driver extends Utils {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        Driver.driver = driver;
    }

    protected static void startDriver() {
        ChromeOptions optionsChrome = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/main/java/utils/driver/chromedriver");
        optionsChrome.setHeadless(true);
        driver = new ChromeDriver(optionsChrome);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        setDriver(driver);
        initializeDate();

    }
    protected static void quitDriver(){
        getDriver().quit();
    }


}



