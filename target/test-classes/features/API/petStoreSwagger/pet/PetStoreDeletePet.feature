@wip

Feature: Delete Pet with API

  Background:
    Given Connected to URL

  Scenario: Delete pet
    When user deletes pet "blue"
    Then verify that pet "blue" has been deleted