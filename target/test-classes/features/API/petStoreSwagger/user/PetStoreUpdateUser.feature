@wip

Feature: Update User with API

  Background:
    Given Connected to URL

  Scenario: updates User
    When user updates his user name "WORLD" and his id "20202"
    And verify that the response message is "20202"
