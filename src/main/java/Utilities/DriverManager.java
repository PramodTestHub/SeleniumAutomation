/**
 * This class handles the browser management to launch and close the instance of browser.
 *
 * @author Pramod Hingole
 * @date August 6, 2025
 */

package Utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager  {
	
	
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final String CONFIG_PATH = "src/test/resources/config.properties";
    private static final String DEFAULT_BROWSER = "chrome";

    
    private static String getBrowserFromConfig() {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(CONFIG_PATH)) {
            props.load(fis);
            return props.getProperty("browser", DEFAULT_BROWSER).toLowerCase();
        } catch (IOException e) {
            System.out.println("[WARN] Could not read config.properties. Using default browser: " + DEFAULT_BROWSER);
            return DEFAULT_BROWSER;
        }
    }



    // Singleton getter
    public static WebDriver getDriver() {
        if (driver.get() == null) {
        	
        	String browser = System.getProperty("browser", getBrowserFromConfig());
            //String browser = System.getProperty("browser", DEFAULT_BROWSER).toLowerCase();

            switch (browser) {
                case "chrome":
                	ChromeOptions options = new ChromeOptions();
                	Map<String, Object> prefs = new HashMap<>();
                    prefs.put("credentials_enable_service", false);
                    prefs.put("profile.password_manager_enabled", false);

                    options.setExperimentalOption("prefs", prefs);
                    driver.set(new ChromeDriver(options));
                    break;
                case "firefox":
                	driver.set(new FirefoxDriver());
                    break;
                case "edge":
                	driver.set(new EdgeDriver());
                    break;
                default:
                    throw new RuntimeException("Unsupported browser: " + browser);
            }

            driver.get().manage().window().maximize();
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            //driver.manage().deleteAllCookies();
        }

        return driver.get();
    }
    
    public static void quitDriver() {
    	if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // remove from ThreadLocal storage
        }
    }


}
