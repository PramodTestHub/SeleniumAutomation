/**
 * This class helps running the flow of scenarios.
 *
 * @author Pramod Hingole
 * @date August 6, 2025
 */

package hooks;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utilities.DriverManager;
import Utilities.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	//private WebDriver driver;

    @Before
    public void setUp() {
         DriverManager.getDriver(); // Initialize driver
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
    	if (scenario.isFailed()) {
           ScreenshotUtils.captureScreenshot();
           // scenario.attach(screenshot, "image/png", scenario.getName());
        }

        // Quit driver
        DriverManager.quitDriver();
    }

   
    }


