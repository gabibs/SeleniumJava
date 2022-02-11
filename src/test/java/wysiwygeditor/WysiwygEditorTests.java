package wysiwygeditor;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WysiwygEditorTests extends BaseTest {
    @Test
    public void testIFrame(){
        var wysiwygEditorPage = homePage.clickWysiwygEditor();
        wysiwygEditorPage.clearTextArea();
        String text1 = "Hello";
        String text2 = "world";
        wysiwygEditorPage.setTextArea(text1);
        wysiwygEditorPage.decreaseIndention();
        wysiwygEditorPage.setTextArea(text2);
        assertEquals(wysiwygEditorPage.getTextFromEditor(),
                text1 + text2,
                "Text in iframe is incorrect");

    }

}
