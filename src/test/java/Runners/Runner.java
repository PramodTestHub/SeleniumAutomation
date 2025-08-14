/**
 * Runner file for Running the test cases
 *
 * @author Pramod Hingole
 * @date August 6, 2025
 */

package Runners;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/Feature_files/cart.feature",
    glue = {"Stepdefination","hooks"},
    dryRun = false,
    plugin = {
            "pretty",
            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",  // Allure plugin
            "html:target/cucumber-report.html",                 // Optional HTML report
            "json:target/cucumber-report.json"                  // Optional JSON report
        }
)

public class Runner extends AbstractTestNGCucumberTests  {
	
	 @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }
	

}
