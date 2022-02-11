package nestedframes;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NestedFramesTests extends BaseTest {
    @Test
    public void testFrameLeft(){
        var nestedFramesPage = homePage.clickNestedFrames();
        String actualText = nestedFramesPage.getTextFromFrameLeft();
        assertEquals(actualText, "LEFT", "Incorrect frame selected");
    }

    @Test
    public void testFrameBottom(){
        var nestedFramesPage = homePage.clickNestedFrames();
        String actualText = nestedFramesPage.getTextFromFrameBottom();
        assertEquals(actualText, "BOTTOM", "Incorrect frame selected");
    }
}
