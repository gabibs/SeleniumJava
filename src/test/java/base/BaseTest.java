package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.SecureAreaPage;

public class BaseTest {
    //Declare "driver" object
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        //Instantiate chromedriver
        driver = new ChromeDriver();

        //Get browser url
        driver.get("https://the-internet.herokuapp.com/");

        //In order to set size as mobile device
        //navigate to browser and verify desired device size using devTool
        //then use this values as parameters
        //driver.manage().window().setSize(new Dimension(360, 740));

        //maximize window
        driver.manage().window().maximize();

        //navigate to HomePage
        homePage = new HomePage(driver);
    }

    //Close the browser and end session
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
