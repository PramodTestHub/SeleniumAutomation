/**
 * This class performs login functionality testing.
 *
 * @author Pramod Hingole
 * @date August 6, 2025
 */

package POM_classes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.BaseClass;

public class LoginPage extends BaseClass {
	

    // Constructor
    public LoginPage(WebDriver driver) {
    	super(driver);
    }

    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errormsg = By.xpath("//h3[contains(text(),'Epic sadface')]");

    // Actions
    public void enterUsername(String username) {
    	 log.info("Entering username");
    	waitForVisibility(usernameField,10).sendKeys(username);
    }

    public void enterPassword(String password) {
    	 log.info("Entering Password");
    	waitForVisibility(passwordField, 10).sendKeys(password);
    }

    public void clickLogin() {
    	 log.info("Click on login button");
    	waitForClickability(loginButton, 10).click();
    }

    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
    public String getErrorText() {
        log.info("Fetching error message");
        return driver.findElement(errormsg).getText();
    }
}
