package alerts;

import base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FileUploadTests extends BaseTest {
    @Test
    public void testFileUpload(){
        //declare variable to find element and click on it
        // (using method referenced in object returned from HomePage)
        var uploadPage = homePage.clickFileUpload();
        //use method in FileUploadPage to upload file and clicks the upload button
        uploadPage.uploadFile("/home/bettaglio_g/Documentos/SeleniumLearningProject/resources/worst_client.jpeg");
        assertEquals(uploadPage.getResults(), "worst_client.jpeg", "Incorrect file uploaded");
    }
}
