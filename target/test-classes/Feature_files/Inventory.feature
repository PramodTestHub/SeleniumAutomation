Feature: Inventory Page
Scenario: Add a product to the cart
  Given I am on the Swag Labs login pages
  When I entering username "standard_user" and password "secret_sauce"
  And I click on the login button
  Then I should see the product "Sauce Labs Backpack" on the products page
  When I add the product "Sauce Labs Backpack" to the cart