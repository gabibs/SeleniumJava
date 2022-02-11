package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By eMailField = By.id("email");
    private By submitBtn = By.className("icon-2x icon-signin");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String mailAddress){
        driver.findElement(eMailField).sendKeys(mailAddress);
    }

    public SuccessMailSentPage clickSubmitBtn(){
        driver.findElement(submitBtn).click();
        return new SuccessMailSentPage(driver);
    }
}
