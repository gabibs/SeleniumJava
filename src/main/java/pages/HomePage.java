package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    //declare driver
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //set a constructor for driver
    public void HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickFormAuthentication(){
        //Find element using "clickLink()" generic method for web element
        //and take an action over it.
        clickLink("Form Authentication");
        return new LoginPage(driver); //"driver" is required parameter for page constructor
    }

    public DropdownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    //generates a generic element found by link text passed as parameter "linkText"
    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
}
