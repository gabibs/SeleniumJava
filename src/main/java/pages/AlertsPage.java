package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {
    private WebDriver driver;
    private By triggerAlertButton = By.xpath("//*[@id='content']/div/ul/li[1]/button");
    private By results = By.id("result");
    private By triggerConfirmButton = By.xpath(".//button[text()='Click for JS Confirm']");
    private By triggerPromptButton = By.xpath("//*[@id='content']/div/ul/li[3]/button");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void triggerAlert(){
        driver.findElement(triggerAlertButton).click();
    }

    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }

    public String getResult(){
        return driver.findElement(results).getText();
    }

    public void triggerConfirm(){
        driver.findElement(triggerConfirmButton).click();
    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    public void alert_clickToDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public String getConfirmResult(){
        return driver.findElement(results).getText();
    }

    public void triggerPrompt() {
        driver.findElement(triggerPromptButton).click();
    }

    public void alert_setInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public void alerts_clickToAcceptPrompt(){
        driver.switchTo().alert().accept();
    }

    public String getPromptResult(){
        return driver.findElement(results).getText();
    }
}
