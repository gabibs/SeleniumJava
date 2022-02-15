package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;

import java.time.Duration;

public class BaseTest {
    //Declare "driver" object
    private WebDriver driver;
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

    //Close the browser and end session
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
}
