Feature: Swag Labs Login

  Scenario: Successful login with valid credentials
    Given I am on the Swag Labs login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click the login button
    Then I should be redirected to the products page
    
  Scenario: get The Title
    Given I am on the Swag Labs login page
    Then I am getting the title of the page
    
   Scenario: Login with Invalid Credentials
    Given I am on the Swag Labs login page
    When I enter username "standard_user" and password "secret_user"
    And I click the login button
    Then I should getting "Epic sadface: Username and password do not match any user in this service"