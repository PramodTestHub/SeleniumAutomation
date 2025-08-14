/**
 * This class performs Inventory functionality testing.
 *
 * @author Pramod Hingole
 * @date August 6, 2025
 */

package POM_classes;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
	WebDriver driver;

    // Constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By productTitles = By.className("inventory_item_name");
    private By addToCartButtons = By.xpath("//button[text()='Add to cart' or text()='ADD TO CART']");
    private By sortDropdown = By.className("product_sort_container");
    private By cartIcon = By.className("shopping_cart_link");

    // Actions

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isProductVisible(String productName) {
        List<WebElement> products = driver.findElements(productTitles);
        return products.stream().anyMatch(p -> p.getText().equalsIgnoreCase(productName));
    }

    public void clickAddToCartByProductName(String productName) {
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        for (WebElement product : products) {
            String name = product.findElement(By.className("inventory_item_name")).getText();
            if (name.equalsIgnoreCase(productName)) {
                product.findElement(By.tagName("button")).click();
                break;
            }
        }
    }

    public void selectSortOption(String optionText) {
        driver.findElement(sortDropdown).sendKeys(optionText);
    }

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
    }

}
