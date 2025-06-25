Feature: User Registration

  Scenario: Successful account registration
    Given I am on the Magento homepage
    When I click on the "Create an Account" link
    And I enter valid details and submit the form
    Then I should see the welcome message
