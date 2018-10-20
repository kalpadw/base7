Feature: Reservation
  Verification of the reservations feature

  Scenario: Verify the reservation details
    Given I am on the login page
    And I enter valid user name
    And I enter valid password
    And I click on Sign In
    When I click on reservations tab
    And I select the first reservation details
    Then I should see the reservation name "Roger Federer"