package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample1Page {
    private WebDriver driver;
    private By startButton = By.xpath("//*[@id='start']/button");
    private By loadingIndicator = By.id("loading");
    private By loadedText = By.id("finish");

    public DynamicLoadingExample1Page(WebDriver driver) {
        this.driver = driver;
    }

    private void waitForElementNotDisplayed(int seconds){
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(driver -> driver.findElement(loadingIndicator));
    }

    public void clickStart(int seconds) {
        driver.findElement(startButton).click();
        waitForElementNotDisplayed(seconds);
    }
    

}
