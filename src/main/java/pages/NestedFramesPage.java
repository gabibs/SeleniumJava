package pages;

import org.openqa.selenium.*;

public class NestedFramesPage {
    private WebDriver driver;
    private By frameTop = By.name("frame-top");
    private By frameLeft = By.name("frame-left");
    private By frameBottom = By.name("frame-bottom");
    private By body = By.tagName("body");

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    private String getFrameText(){
        String text = driver.findElement(body).getText();
        text.trim();
        return text;
    }

    public String getTextFromFrameLeft(){
        driver.switchTo().frame(driver.findElement(frameTop));
        driver.switchTo().frame(driver.findElement(frameLeft));
        String text = getFrameText();
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        return text;
    }

    public String getTextFromFrameBottom(){
        driver.switchTo().frame(driver.findElement(frameBottom));
        String text = getFrameText();
        driver.switchTo().parentFrame();
        return text;
    }


}
