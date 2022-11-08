@wip

Feature: Create User with API

  Background:
    Given Connected to URL

  Scenario: Create User
    When user creates a user named "Nihat"
    Then verify that user "Nihat" has been created