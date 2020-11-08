@careers @regression
Feature: Careers Page
  As user, I should be able see the company locations and open job application

  Background: launch demo page
    Given user is on the careers page

  Scenario: Verify company locations links are presented
    Then user look for company locations

  Scenario: Verify user is able to open job application
    When user opens a open application
    Then user should see apply here link