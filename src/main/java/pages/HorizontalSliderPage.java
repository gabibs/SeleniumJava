package pages;

import io.ous.jtoml.impl.Parser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By slider = By.xpath("//*[@id='content']/div/div/input");
    private By result = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setValue(String value){
        while(!getResult().equals(value)) {
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getResult(){
        return driver.findElement(result).getText();
    }

    public String getResultText() {
        return driver.findElement(result).getText();
    }

}
