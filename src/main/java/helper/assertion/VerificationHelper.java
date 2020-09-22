package helper.assertion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificationHelper {

    private WebDriver driver;

    public VerificationHelper(WebDriver driver){
        this.driver = driver;
    }


    /**
     * Verify if the WebElement is displayed or not
     * @param element
     * @return
     */
    public boolean isDisplayed(WebElement element){
        try{
            element.isDisplayed();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }


    /**
     * Return a String value of a WebElement
     * @param element
     * @return
     */
    public String readValueFromElement(WebElement element){
        if(null == element){
            return null;
        }
        boolean status = isDisplayed(element);
        if(status){
            return element.getText();
        }
        else{
            return null;
        }
    }


    /**
     * Returns A Text of a WebElement
     * @param element
     * @return
     */
    public String getText(WebElement element){
        if(null == element){
            return null;
        }
        boolean status = isDisplayed(element);
        if(status){
            return element.getText();
        }
        else{
            return null;
        }
    }

}
