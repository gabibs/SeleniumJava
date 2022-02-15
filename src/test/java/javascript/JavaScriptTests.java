package javascript;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JavaScriptTests extends BaseTest {
    @Test
    public void testScrollToTable() {
        var largeAndDeepDomPage = homePage.clickLargeDOM();
        largeAndDeepDomPage.scrollToTable();
    }

    @Test
    public void testScrollToFifthParagraph(){
        var infiniteScrollPage = homePage.clickInfiniteScroll();
        infiniteScrollPage.scrollToParagraph(5);
    }

    @Test
    public void testMultipleSelection(){
        var dropdownPage = homePage.clickDropDown();
        dropdownPage.setMultipleAttribute();
        dropdownPage.selectFromDropDown("Option 1");
        dropdownPage.selectFromDropDown("Option 2");
        assert dropdownPage.getSelectedOptions().size()>0;

    }
}
