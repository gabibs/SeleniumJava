package alerts;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AlertTests extends BaseTest {
    @Test
    public void testAcceptAlert(){
        var alertsPage = homePage.clickAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You successfully clicked an alert", "Results text is incorrect");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertsPage = homePage.clickAlerts();
        alertsPage.triggerConfirm();
        String alertTxt = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(alertTxt, "I am a JS Confirm", "Alert text is incorrect");
        assertEquals(alertsPage.getConfirmResult(), "You clicked: Cancel", "Result text is incorrect");
    }

    @Test
    public void testSetInputInAlert(){
        var alertsPage = homePage.clickAlerts();
        alertsPage.triggerPrompt();
        String text = "TAU Rocks!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You entered: " + text, "Results text incorrect");
    }
}
