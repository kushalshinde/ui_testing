package helper.wait;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitHelper {
    private WebDriver driver;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }


    /**
     * This is ImplicitWait method
     *
     * @param timeout
     * @param unit
     */
    public void setImplicitWait(long timeout, TimeUnit unit) {
        driver.manage().timeouts().implicitlyWait(timeout, unit);
    }


    /**
     * This method will make sure elementToBeClickable
     *
     * @param element
     * @param timeOutInSeconds
     */
    public void WaitForElementClickable(WebElement element, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * This method will make sure element is visible
     *
     * @param element
     * @param timeOutInSeconds
     * @param pollingEveryInMiliSec
     */
    public void WaitForElementVisibleWithPollingTime(WebElement element, int timeOutInSeconds,
                                                     int pollingEveryInMiliSec) {
        WebDriverWait wait = getWait(timeOutInSeconds, pollingEveryInMiliSec);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * This will help us to get WebDriverWait object
     *
     * @param timeOutInSeconds
     * @param pollingEveryInMiliSec
     * @return
     */
    private WebDriverWait getWait(int timeOutInSeconds, int pollingEveryInMiliSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds,pollingEveryInMiliSec);
        //wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;
    }

}
