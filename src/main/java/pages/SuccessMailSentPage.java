package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessMailSentPage {
    private WebDriver driver;
    private By contentArea = By.id("content");

    public SuccessMailSentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessText(){
        String successText = driver.findElement(contentArea).getText();
        return successText;
    }

}
