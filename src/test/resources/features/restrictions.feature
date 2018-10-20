Feature: Restrictions
  Verification of the restrictions feature

  Scenario: Verify that the restrictions are properly displayed
    Given I am on the login page
    And I enter valid user name
    And I enter valid password
    And I click on Sign In
    When I click on Settings
    And I click on Accomodations
    And I click on Restrictions
    Then I should see the price table