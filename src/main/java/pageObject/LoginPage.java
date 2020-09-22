package pageObject;

import helper.browserConfiguration.config.PropertyReader;
import helper.wait.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class LoginPage {

    private WebDriver driver;
    PropertyReader pr;
    WaitHelper waitHelper;

    @FindBy(css = "input[name=\"username\"]")
    WebElement username;

    @FindBy(css = "div#reactLoginComponentRoot button[type=\"button\"]")
    WebElement submit_username;

    @FindBy(css = "input[name=\"password\"]")
    WebElement password;

    @FindBy(css = "div#reactLoginComponentRoot button[type=\"submit\"]")
    WebElement submit_password;

    public LoginPage(WebDriver driver) {
        pr = new PropertyReader();
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }


    public void enterEmailAddress(String emailAddress){
        this.username.sendKeys(emailAddress);
    }

    public void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public void clickOnSubmitUsername(){
        this.submit_username.click();
    }

    public void clickOnSubmitPassword(){
        this.submit_password.click();
    }


    public void waitUntilElementIsVisible(WebElement element){
        waitHelper.WaitForElementVisibleWithPollingTime(element, pr.getTimeOutInSeconds(), pr.getPollingEveryInMilliSec());
    }

    public void implicitWait(){
        waitHelper.setImplicitWait(pr.getImpliciteWait(), TimeUnit.SECONDS);
    }


    public void login(String user_n, String pass_w){

        //wait until username is visible and enter username
        waitUntilElementIsVisible(this.username);
        enterEmailAddress(user_n);

        //click on submit username
        clickOnSubmitUsername();

        implicitWait();

        //wait until password is visible and enter password
        waitUntilElementIsVisible(this.password);
        enterPassword(pass_w);

        //click on submit password
        clickOnSubmitPassword();

    }

    public void login_Into_Platform(){
        login(pr.getUserName(), pr.getPassword());
    }

}
