package navigation;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NavigationTests extends BaseTest {
    @Test
    public void testNavigator(){
        homePage.clickDynamicLoad().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }

    @Test
    public void testSwitchTab(){
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }

    @Test
    public void testDynamicLoad(){
        var exampleDL2Page = homePage.clickDynamicLoad().rightClickExample2();
        getWindowManager().switchToTab("The Internet");
        assertTrue(exampleDL2Page.isStartButtonDisplayed(), "Start button is not displayed");
    }
}
