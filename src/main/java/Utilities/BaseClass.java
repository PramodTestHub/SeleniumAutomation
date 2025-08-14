package Utilities;

import java.time.Duration;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class BaseClass {
	
	protected WebDriver driver;
	protected Logger log = LogManager.getLogger(this.getClass());
    public BaseClass(WebDriver driver) {
        this.driver = driver;
    }

    /** Wait for element to be visible */
    public WebElement waitForVisibility(By locator, int timeoutSeconds) {
    	log.info("Waiting for visibility of element: " + locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /** Wait for element to be clickable */
    public WebElement waitForClickability(By locator, int timeoutSeconds) {
    	log.info("Waiting for element to be clickable: " + locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /** Wait for page title to contain text */
    public boolean waitForTitleContains(String titlePart, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.titleContains(titlePart));
    }

    /** Fluent wait for element */
    public WebElement fluentWait(By locator, int timeoutSeconds, int pollingMillis) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(pollingMillis))
                .ignoring(NoSuchElementException.class);
        return wait.until(driver -> driver.findElement(locator));
    }
    
}
