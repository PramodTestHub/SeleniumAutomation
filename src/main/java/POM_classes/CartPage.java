package POM_classes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	
	 WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    
    //private By cartIcons = By.className("shopping_cart_link");
    private By productTobuy=By.xpath("//div[text()='Sauce Labs Backpack']");
    private By ContinueShopping=By.id("continue-shopping");
    private By removeProduct=By.xpath("//button[text()='Remove']");
    private By checkoutProduct=By.xpath("//button[text()='Checkout']");

    public String getProductName() {
        return driver.findElement(productTobuy).getText();
    }

    // Check if a product is present in the cart
    public boolean isProductInCart(String product) {
        return getProductName().equalsIgnoreCase(product);
    }

    // Click Continue Shopping
    public void clickContinueShopping() {
        driver.findElement(ContinueShopping).click();
    }

    // Click Checkout
    public void clickCheckout() {
        driver.findElement(checkoutProduct).click();
    }

}
