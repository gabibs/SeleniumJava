package contextmenu;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ContextMenuTests extends BaseTest {
    @Test
    public void testRight_click(){
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.right_clickOnHotSpot();
        String alertText = contextMenuPage.getAlertText();
        contextMenuPage.acceptAlert();
        assertEquals(alertText, "You selected a context menu", "Incorrect action executed");
    }
}
