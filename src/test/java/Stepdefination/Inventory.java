/**
 * This class Implement steps for inventory.feature file.
 *
 * @author Pramod Hingole
 * @date August 6, 2025
 */

package Stepdefination;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM_classes.LoginPage;
import POM_classes.ProductsPage;
import Utilities.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Inventory {
	
	//WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    
    
    
    @Given("I am on the Swag Labs login pages")
    public void i_am_on_the_login_pages() {
    	DriverManager.getDriver().get("https://www.saucedemo.com/");
        loginPage = new LoginPage(DriverManager.getDriver());
       
    }

    @When("I entering username {string} and password {string}")
    public void i_entering_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I click on the login button")
    public void i_click_login() throws AWTException, InterruptedException {
        loginPage.clickLogin();

    }
    
    @Then("I should see the product {string} on the products page")
    public void i_should_see_the_product_on_the_products_page(String productName) {
    	
        

        productsPage = new ProductsPage(DriverManager.getDriver());
 
    	//assertTrue("Product not found: " + productName, productsPage.isProductVisible(productName));
    	
    }

    @When("I add the product {string} to the cart")
    public void i_add_the_product_to_the_cart(String productName) {
        
    	productsPage.clickAddToCartByProductName(productName);	
    	
    }
}
