@wip
Feature: Checking the data from the Wikipedia search section
  Background:
    Given User is on "WikipediaURL"

  Scenario: Checked element should be unchecked after clicking
    Given user clicks Search In
    When Default is already checked
    And user clicks element Default
    Then verify that element Default is unchecked
    When user clicks element General Help
    Then verify that element General Help is checked
    And verify that element labels Wikipedia, Help are appeared
    When user clicks element General Help
    Then verify that element General Help is unchecked
    And verify all elements are unchecked
    When user clicks element All
    Then verify all elements are checked
    And verify that element labels Article, Gadget definition talk are appeared