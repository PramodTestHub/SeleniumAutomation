/**
 * This class Implement steps for login.feature file.
 *
 * @author Pramod Hingole
 * @date August 6, 2025
 */

package Stepdefination;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import POM_classes.LoginPage;
import Utilities.DriverManager;
import io.cucumber.java.en.*;

public class loginstep{
	
    //WebDriver driver;
	
	LoginPage loginPage;

    @Given("I am on the Swag Labs login page")
    public void i_am_on_the_login_page() {
        //driver = new ChromeDriver(); // Or your browser of choice
    	loginPage = new LoginPage(DriverManager.getDriver());
        DriverManager.getDriver().get("https://www.saucedemo.com/");
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void i_click_login() {
        loginPage.clickLogin();
       
    }

    @Then("I should be redirected to the products page")
    public void i_should_be_redirected_to_products() {
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        assertTrue(currentUrl.contains("inventory.html"));
    }
    @Then("I am getting the title of the page")
    public void i_am_getting_the_title_of_the_page() {
        String actualTitle = DriverManager.getDriver().getTitle();
        System.out.println("Page Title: " + actualTitle);

        // Optional assertion to validate title
        String expectedTitle = "Swag Labs";
        assertEquals(expectedTitle, actualTitle);
        
       //Assert.assertE("Title does not match!", expectedTitle, actualTitle);
    }
    @Then("I should getting {string}")
    public void i_should_getting(String expectedMessage) {
    	String actualError = loginPage.getErrorText();
    	System.out.print(actualError);
        assertEquals(actualError, expectedMessage,
                "Error message did not match!");
    }

}
