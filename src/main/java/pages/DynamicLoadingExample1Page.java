package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class DynamicLoadingExample1Page {
    private WebDriver driver;
    private By startButton = By.xpath("//*[@id='start']/button");
    private By loadingIndicator = By.id("loading");
    private By loadedText = By.id("finish");

    public DynamicLoadingExample1Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStart() {
        driver.findElement(startButton).click();
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
         wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));
    }

    public String getTextResult(){
        return driver.findElement(loadedText).getText();
    }
}
