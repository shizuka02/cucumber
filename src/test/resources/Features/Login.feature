Feature: User Login
  Registered User should be able to login

 Scenario: Launch the browser
    Given open chrome and launch the application


  Scenario: Login with valid credentials
    Given User navigates to Login page
    When User enters valid email address "standard_user"
    And Enters valid password "secret_sauce"
    And Click on Login button
    Then User should login successfully

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
#
#