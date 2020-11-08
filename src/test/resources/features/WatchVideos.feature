@watchvideo @regression
Feature: Watch Videos
  As user, I should be able submit watch videos form

  Background: launch demo page
    Given user is on the demo page

  Scenario: Open watch videos form and submit
    When user clicks on watch now
    Then watch videos form will render
    And user enters required fields on the watch videos from
      | test | user | Abc123 | tesuser@abc.com |
    Then user submits the watch videos form


  Scenario: Verify all error messages are displayed when user submit the one demo form without filling
    When user clicks on watch now
    Then watch videos form will render
    When user submits the watch videos form
    Then all error messages should displayed on watch videos from