@wip
Feature: Checking the data from the Istanbul Search
  Background:
    Given User is on "WikipediaURL"

  Scenario: Search Istanbul and check that the content and the title are the same
    Given user search the "Istanbul"
    When verify the title is Istanbul - Search results - Wikipedia
    Then user clicks on the first title about "Istanbul"
    When verify the title is Istanbul - Wikipedia
    And verify that the first heading is "Istanbul"
    Then verify that all content names and all header names are same
