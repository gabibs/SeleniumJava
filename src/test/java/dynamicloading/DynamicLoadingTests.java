package dynamicloading;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DynamicLoadingTests extends BaseTest {
    @Test
    public void testExample1(){
        var dynamicLoadingPage = homePage.clickDynamicLoad();
        var dynamicLoadingExample1Page = dynamicLoadingPage.clickExample1();
        dynamicLoadingExample1Page.clickStart();
        assertEquals(dynamicLoadingExample1Page.getTextResult(), "Hello World!", "Incorrect clicked button");
    }

    @Test
    public void testExample2(){
        var dynamicLoadingPage = homePage.clickDynamicLoad();
        var dynamicLoadingExample2Page = dynamicLoadingPage.clickExample2();
        boolean isStartBtnDisplayed = dynamicLoadingExample2Page.isStartButtonDisplayed();
        if(isStartBtnDisplayed){
            dynamicLoadingExample2Page.clickStart();
        }
        assertEquals(dynamicLoadingExample2Page.getTextResult(), "Hello World!", "Incorrect clicked button");
    }
}
