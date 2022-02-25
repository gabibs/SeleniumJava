package utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private WebDriver driver;

    public DriverFactory(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver buildDriver(String type, String browser) throws MalformedURLException {

        if (type == "local"){
            switch(browser){
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
                    ChromeOptions options = new ChromeOptions();
                    driver  = new ChromeDriver(options);
                    DesiredCapabilities chromeCapabilities = new DesiredCapabilities();
                    chromeCapabilities.setCapability("pupeteer", true);
                    return driver;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
                    driver = new FirefoxDriver();
                    DesiredCapabilities firefoxCapabilities = new DesiredCapabilities();
                    firefoxCapabilities.setCapability("marionette", true);
                    return driver;
                default: throw new RuntimeException("Browser is not supported locally");
            }
        } else if (type == "remote"){
            driver = buildRemoteDriver(browser);
            return driver;
        }
        return driver;
    }
    private WebDriver buildRemoteDriver(String browser) throws MalformedURLException {
        var remoteUrl = "http://localhost:4444/wd/hub";

        switch (browser) {
            case "chrome":
                var chromeOptions = new ChromeOptions();
                chromeOptions.setCapability("browserVersion", "98");
                chromeOptions.setCapability("platformName", "Ubuntu 20.4");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new RemoteWebDriver(new URL(remoteUrl), chromeOptions);
                ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
                return driver;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability("browserVersion", "firefox");
                firefoxOptions.setCapability("platformName", "Ubuntu 20.4");
                firefoxOptions.addPreference("network.proxy.type", 0);
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new RemoteWebDriver(new URL(remoteUrl), firefoxOptions);
                ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
                return driver;
            default:
                MalformedURLException exception = new MalformedURLException();
                exception.getCause();
                break;
        }
        return driver;
    }
}
