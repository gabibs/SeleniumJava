package login;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.SecureAreaPage;
import pages.SuccessMailSentPage;

import static org.testng.Assert.*;

public class LoginTests extends BaseTest {
    @Test
    public void testSuccessfulLogin(){
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickSubmitBtn();
        assertTrue(secureAreaPage.getAlertText().contains(
                "You logged into a secure area!")
        ,"Alert text is incorrect");
    }
    @Test
    public void testEmailSent() {
        String mailAddress = "SeleniumLearning@yopmail.com";
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.setEmail(mailAddress);
        SuccessMailSentPage successMailSentPage = forgotPasswordPage.clickSubmitBtn();
        assertTrue(successMailSentPage.getSuccessText().contains("Your e-mail's been sent!"));
    }
}
