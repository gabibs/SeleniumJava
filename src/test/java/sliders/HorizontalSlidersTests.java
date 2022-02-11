package sliders;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HorizontalSlidersTests extends BaseTest {
    @Test
    public void horizontalSlider(){
        var horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.setValue("4");
        assertEquals(horizontalSliderPage.getResultText(), "4", "Result text is incorrect");
    }
}
