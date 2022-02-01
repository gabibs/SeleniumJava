package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By submitBtn = By.xpath("//*[@id='login']/button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }
    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    //the return type of this method is the handler for a new page
    //since the click() action opens new one
    public SecureAreaPage clickSubmitBtn(){
        driver.findElement(submitBtn).click();
        return new SecureAreaPage(driver);
    }
}
