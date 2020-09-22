package testScripts;


import helper.assertion.AssertionHelper;
import helper.browserConfiguration.config.PropertyReader;
import org.junit.jupiter.api.*;
import pageObject.FilesPage;
import pageObject.LoginPage;
import testBase.TestBase;


public class FileUploadTest extends TestBase {

    PropertyReader ppr = new PropertyReader();

    @Test
    @DisplayName("Uploading A New File")
    public void fileLoad(){

        //load URL
        getApplicationUrl(ppr.getUrl());

        //Login into the Rescale Platform
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login_Into_Platform();

        //Upload file to the platform
        FilesPage filesPage = new FilesPage(driver);
        filesPage.UploadFileToPlatform();

        //Assert filenames
        String uploadedFilename = filesPage.returnUploadedFIleName();
        String inputFilename = filesPage.readInputfile();

        AssertionHelper.verifyText(uploadedFilename, inputFilename);
    }

}
