package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingExample2Page {
    private WebDriver driver;
    private By startButton = By.xpath("//*[@id='start']/button");
    private By loadingIndicator = By.id("loading");
    private By loadedText = By.id("finish");

    public DynamicLoadingExample2Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStart() {
        driver.findElement(startButton).click();
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(100))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions
                .textToBe(loadedText, "Hello World!"));
    }

    public boolean isStartButtonDisplayed(){
        boolean isDisplayed = driver.findElement(startButton).isDisplayed();
        return isDisplayed;
    }

    public String getTextResult(){
        return driver.findElement(loadedText).getText();
    }
}
