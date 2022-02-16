package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    //Declare "driver" object
    protected WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        //Instantiate chromedriver
        driver = new ChromeDriver();

        //this will avoid each method tries to click on links at the same time
        goHome();

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

    //Close the browser and end session
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
}
