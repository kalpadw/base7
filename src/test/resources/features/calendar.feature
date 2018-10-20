Feature: Calendar
  Verification of the features of calendar

  Scenario Outline:
    Given I am on the login page
    And I enter valid user name
    And I enter valid password
    And I click on Sign In
    When I click on a <startDate> and select a day from calendar
    And I click on an <endDate> and select an end day from calendar
    Then the reservations should be displayed for the selected <startDate> and <endDate>

    Examples:
      | startDate | endDate |
      | Oct 14    | Nov 13  |