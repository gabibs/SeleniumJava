package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private  WebDriver driver;
    private By link_Example1 = By.xpath("//*[@id='content']/div/a[1]");
    private By example2 = By.xpath("//*[@id='content']/div/a[2]");
    private By StartBtn1 = By.xpath("//*[@id='start']/button");


    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicLoadingExample1Page clickExample1(){
        driver.findElement(link_Example1).click();
        return new DynamicLoadingExample1Page(driver);
    }
}
