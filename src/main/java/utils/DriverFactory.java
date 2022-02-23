package utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URI;
import java.net.URISyntaxException;

public class DriverFactory {
    private WebDriver driver;

    public DriverFactory(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver buildDriver(String type, String browser) {
        if (type == "local"){
            switch(browser){
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
                    ChromeOptions options = new ChromeOptions();
                    ChromeDriver chromedriver = new ChromeDriver(options);
                    DesiredCapabilities chromeCapabilities = new DesiredCapabilities();
                    chromeCapabilities.setCapability("pupeteer", true);
                    return chromedriver;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
                    FirefoxDriver firefoxDriver = new FirefoxDriver();
                    DesiredCapabilities firefoxCapabilities = new DesiredCapabilities();
                    firefoxCapabilities.setCapability("marionette", true);
                    return firefoxDriver;
                default: throw new RuntimeException("Browser is not supported locally");
            }
        } else if (type == "remote"){

        }
        return driver;
    }
    private WebDriver buildRemoteDriver(String browser) throws URISyntaxException {
        var DOCKER_GRID_HUB_URI = new URI("http://localhost:4444/wd/hub");
        WebDriver remoteWebDriver;
        switch (browser){
            case "chrome":
                var chromeOptions = new ChromeOptions();
            {
                "Browser Version": "",
                    Platform.extractFromSysProperty("LINUX","")
            }
            chromeOptions.addArguments("--start-maximized");
        }
    }
}
