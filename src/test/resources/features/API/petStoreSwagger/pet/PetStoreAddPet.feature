@wip

  Feature: Add Pet with API

    Background:
      Given Connected to URL

    Scenario: Add pet
      When user posts pet "blue"
      Then verify that pet "blue" has been created