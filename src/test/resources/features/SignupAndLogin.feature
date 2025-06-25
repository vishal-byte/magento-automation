Feature: User Registration and Login

  Scenario: User signs up for an account
    Given I am on the Magento homepage
    When I click on the Create an Account link
    And I enter valid signup details
    And I submit the signup form
    Then I should see the welcome message
    And I close the browser

  Scenario: User logs in with the same credentials
    Given I am on the login page
    When I login using the credentials from signup
    Then I should be logged in successfully
    And I close the browser after login
