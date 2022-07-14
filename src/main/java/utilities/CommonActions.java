package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Reporter;
import java.time.Duration;
import java.time.LocalDateTime;

public class CommonActions {
    /**
     * Wait for Element to be visible on page for maximum of maxWait seconds
     * @param driver
     * @param locator
     * @param maxWait
     */
    public static void waitForElementToBeVisible(WebDriver driver, By locator, int maxWait){
        Reporter.log(LocalDateTime.now() +"Waiting for element: "+locator.toString());
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(maxWait))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class);

        wait.until((ExpectedCondition<Boolean>) driver1 -> {
            driver.findElement(locator);
            return true;
        });
    }
    /**
     * Wait for Element to be visible on page for maximum of maxWait seconds
     * @param driver
     * @param findBy
     * @param maxTimeInSeconds
     *
     */
    public static void waitForElementClickable(WebDriver driver, By findBy, int maxTimeInSeconds) {
        Reporter.log(LocalDateTime.now() +" Wait for Web Element to be Clickable, max : "+ maxTimeInSeconds+" s");
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(maxTimeInSeconds))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class);
        wait.until((ExpectedCondition<Boolean>) driver1 -> {
            driver.findElement(findBy);
            return true;
        });
    }
    /**
     * Click at elemenet and wait for WAIT_AFTER_CLICK ms
     * @param driver
     * @param locator
     */
    public static void clickElement(WebDriver driver, By locator){
        Reporter.log(LocalDateTime.now() +"Clicking at element: "+locator.toString());
        driver.findElement(locator).click();
    }
    /**
     * Waits until a page is fully loaded or maxTimeInSeconds is reached.
     * Creates a record in logger.
     * @param driver - [WebDriver] - current WebDriver.
     * @param maxTimeInSeconds - [int] - max. waiting time in seconds.
     *
     */
    public static void waitForFullPageLoad(WebDriver driver, int maxTimeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(maxTimeInSeconds));
        wait.until((ExpectedCondition<Boolean>) driver1 -> {
            boolean result = ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            if (!result) {
                Reporter.log("Wait for Webpage to Load... Maximum Waiting Time: " + String.valueOf(maxTimeInSeconds) +  " seconds.");
            }
            return result;
        });
    }
}
