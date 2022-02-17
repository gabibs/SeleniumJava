package base;

import com.google.common.io.Files;
import listeners.EventReporter;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    //Declare "driver" object and set capabilities
    WebDriver original = new ChromeDriver(getChromeOptions());
    WebDriverListener listener = new EventReporter();
    WebDriver driver = new EventFiringDecorator(listener).decorate(original);

    protected HomePage homePage;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        //this will avoid each method tries to click on links at the same time
        goHome();

        //set desired cookies
        setCookie();

        //navigate to HomePage
        homePage = new HomePage(driver);

        //Implicitly wait for slow load web applications
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        Duration scriptTimeout = driver.manage().timeouts().getScriptTimeout();
        driver.manage().timeouts().scriptTimeout(scriptTimeout);
    }

    @BeforeMethod
    public void goHome(){
        //Get browser url
        driver.get("https://the-internet.herokuapp.com/");

        //In order to set size as mobile device
        //navigate to browser and verify desired device size using devTool
        //then use this values as parameters
        //driver.manage().window().setSize(new Dimension(int, int));

        //maximize window
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()) {
            //cast driver to TakeScreenshot Class of Selenium
            var camera = (TakesScreenshot) driver;
            //Use Java.io File class
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            //Print path of file
            System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("gbettaglio", "1234")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }

    //Close the browser and end session
    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
