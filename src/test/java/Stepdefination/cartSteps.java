package Stepdefination;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import POM_classes.CartPage;
import POM_classes.LoginPage;
import POM_classes.ProductsPage;
import Utilities.Constants;
import Utilities.DriverManager;
import io.cucumber.java.en.*;

public class cartSteps {
	
	//WebDriver driver;
	LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @Given("I on the Swag Labs login page")
    public void i_on_the_swag_labs_login_page() {
    	DriverManager.getDriver().get(Constants.URL);
        loginPage = new LoginPage(DriverManager.getDriver());
       
    }

    @When("I enters the username {string} and password {string}")
    public void i_enters_the_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click onto the login button")
    public void i_click_login() throws AWTException, InterruptedException {
        loginPage.clickLogin();

    }
    
    @When("I should see the products {string} on the products page")
    public void i_should_see_the_products_on_the_products_page(String productName) {
        
        productsPage = new ProductsPage(DriverManager.getDriver());
 
    	//assertTrue("Product not found: " + productName, productsPage.isProductVisible(productName));
    	
    }

    @When("I adding the product {string} to the cart")
    public void i_adding_the_product_to_the_cart(String productName) {
        
    	productsPage.clickAddToCartByProductName(productName);	
    	
    }
    @When("Click on the cart")
    public void click_on_the_cart() {
        productsPage.clickCartIcon();
    }

    @Then("I should seeing the products {string} on the products page")
    public void i_should_seeing_the_products_on_the_cart_page(String productName) {
    	cartPage = new CartPage(DriverManager.getDriver());
       // assertTrue(cartPage.isProductInCart(productName),
       //         "Product not found in the cart: " + productName);
    }

    @Then("valiadting product {string} is present on cart")
    public void validating_product_is_present_on_cart(String productName) {
        assertTrue(cartPage.isProductInCart(productName),
                "Validation failed: Product not found in the cart: " + productName);
    }

    @Then("click on continue shoppin button")
    public void click_on_continue_shopping_button() {
       // cartPage.clickContinueShopping();
    }

}
