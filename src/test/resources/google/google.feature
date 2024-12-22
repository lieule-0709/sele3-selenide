@google
Feature: Google

  @smoke
  Scenario: Search for selenide
    When I open duckduck page
    And I search for selenide
    Then check the results page
