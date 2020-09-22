package pageObject;

import helper.assertion.VerificationHelper;
import helper.browserConfiguration.config.PropertyReader;
import helper.resource.ResourceHelper;
import helper.wait.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class FilesPage {

    private WebDriver driver;
    ResourceHelper rs;
    PropertyReader prr;
    WaitHelper waitHelper;

    public FilesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        rs = new ResourceHelper();
        prr = new PropertyReader();
        waitHelper = new WaitHelper(driver);
    }

    @FindBy(css = "li#menuFiles span.ml2.only-large.nowrap")
    WebElement files;

    @FindBy(css = "div#file-list-container label")
    WebElement dropZone;

    @FindBy(css = "div#file-list-container td.pv4.name-col.w-30.mw7 > div > a")
    WebElement firstuploadedfile;



    public void clickOnFiles(){
        this.files.click();
    }


    public void clickOnDropZone(){
        this.dropZone.click();
    }


    public String selectFile(){
        String full_path = rs.getResourcePath(prr.getFilePath());
        System.out.println("Full path: - "+ full_path);
        return full_path;
    }


    public void switchToActiveElement(){
        String path = selectFile();
        driver.switchTo().activeElement().sendKeys(path);
    }


    public void selectFiles(WebElement element){
        waitHelper.WaitForElementClickable(element, prr.getTimeOutInSeconds());
    }


    public void implicitWait(){
        waitHelper.setImplicitWait(prr.getImpliciteWait(), TimeUnit.SECONDS);
    }


    public void waitUntilElementIsVisible(WebElement element){
        waitHelper.WaitForElementVisibleWithPollingTime(element, prr.getTimeOutInSeconds(), prr.getPollingEveryInMilliSec());
    }


    public String returnUploadedFIleName(){
        return new VerificationHelper(driver).readValueFromElement(this.firstuploadedfile);
    }

    public String readInputfile(){
        return prr.getFilePath().substring(prr.getFilePath().lastIndexOf("/") + 1);
    }

    public String UploadFileToPlatform(){
        driver.manage().window().maximize();
        implicitWait();
        //select file to upload
        selectFiles(this.files);
        clickOnFiles();

        //Compulsory wait
        implicitWait();

        //wait until file selection button is visible
        waitUntilElementIsVisible(this.dropZone);
        implicitWait();

        clickOnDropZone();

        //select file from the dropdown
        switchToActiveElement();
        implicitWait();

        //wait until the uploaded file is updated from the server
        waitUntilElementIsVisible(this.firstuploadedfile);
        implicitWait();

        //read uploaded file name
        return returnUploadedFIleName();
    }

}
