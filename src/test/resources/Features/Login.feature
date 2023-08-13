Feature: User Login
  Registered User should be able to login

 Scenario: Launch the browser
    Given open chrome and launch the application
#
  Scenario: Login with valid credentials
    Given User navigates to Login page
    When User enters valid email address "standard_user"
    And Enters valid password "secret_sauce"
    And Click on Login button
    Then User should login successfully

#    Scenario: Title on the Product Screen
#      Then Swag labs Title is visible on the product screen
##
#  Scenario: Verify Product information
#  #Given I am on the Product Page
#  Then Verify Name, Price and Description of the product
#
#  Scenario: Add to Cart
#  When User click on Add to Cart button
#  Then Product is added in cart successfully
#
#  Scenario: Cart count
#  Then the cart icon displays the correct number of items added to the cart
#
##  Scenario: Checkout functionality
##  When User click on Checkout Button
##  Then User will be redirected to Checkout Page
##

  Scenario: Verify products and quantities in the cart
    Given User has added products to the cart
    When User clicks on the cart
    Then Cart should display the correct products and quantities

#  Scenario: Logout
#  When User click on Logout Button
#  Then User will be logged out successfully

#  Scenario: Login with Invalid credentials
#    Given User navigates to Login page
#    When User enters invalid email address "jhsdhs@gmail.com"
#    And Enters invalid password "123787845"
#    And Click on Login button
#    Then User should get a proper warning message
#
#  Scenario: Login with valid email and invalid password
#    Given User navigates to Login page
#    When User enters valid email address "sv02896@gmail.com"
#    And Enters invalid password "123787845"
#    And Click on Login button
#    Then User should get a proper warning message
#
#  Scenario: Login with Invalid email and valid password
#    Given User navigates to Login page
#    When User enters invalid email address "jhsdhs@gmail.com"
#    And Enters valid password "12345"
#    And Click on Login button
#    Then User should get a proper warning message
#
#  Scenario: Login without providing any credentials
#    Given User navigates to Login page
#    When User dont enter any credentials
#    And Click on Login button
#    Then User should get a proper warning message

