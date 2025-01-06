@DatadrivenCucumber
Feature: Youtube Search Validation
  Scenario Outline: Youtube Search Positive Scenario
    Given Open chrome browser and enter URL
    When Search selenium tutorial "<SearchString>"
    And Click on Search button
    Then Validate search results "<resultString>"
  Examples:
    | SearchString      | resultString      |
    | Selenium Tutorial | Selenium Tutorial |