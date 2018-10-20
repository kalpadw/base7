Feature: Login
  Validation of the login feature

  Scenario: login with valid credentials
    Given I am on the login page
    When I enter valid user name
    And I enter valid password
    And I click on Sign In
    Then I should be able to see my reservations page