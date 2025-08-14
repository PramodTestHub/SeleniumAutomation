Feature: Cart Page
Scenario: Validating Cart page
  Given I on the Swag Labs login page
  When I enters the username "standard_user" and password "secret_sauce"
  And I click onto the login button
  And I should see the products "Sauce Labs Backpack" on the products page
  And I adding the product "Sauce Labs Backpack" to the cart
  And Click on the cart
  Then I should seeing the products "Sauce Labs Backpack" on the products page
  Then valiadting product "Sauce Labs Backpack" is present on cart
  Then click on continue shoppin button