@onetoonedemo @regression

Feature: OneToOneDemo
  As user, I should be able submit one to one demo

  Background: launch demo page
    Given user is on the demo page

  Scenario: Open one to one demo form and submit
    When user clicks on schedule now
    Then one to one demo form will render
    And user enters required fields on the from
      | test | user | Abc123 | tesuser@abc.com | 0123123123 | Tester | Carrier | Ocean Freight |
    When user clicks on get one to one demo
    Then one to one demo should scheduled

  Scenario: Verify all error messages are displayed when user submit the one demo form without filling
    When user clicks on schedule now
    Then one to one demo form will render
    When user clicks on get one to one demo
    Then all error messages should displayed