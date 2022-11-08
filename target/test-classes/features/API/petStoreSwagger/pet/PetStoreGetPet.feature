@wip

Feature: Get Pet with API

  Background:
    Given Connected to URL

  Scenario: Get pet
    When user gets pet "blue"
    Then verify that pet "blue" has been gotten