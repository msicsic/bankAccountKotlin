Feature: withdrawal from account
  In order to retrieve some or all of my savings
  As a bank client
  I want to make a withdrawal from my account

  Background: I have a provisionned account
    Given I have an empty account
    And I deposit 100 Euros

  Scenario: I make one withdrawal from my account
    When I withdraw 30 Euros
    Then My balance should be 70 Euros

  Scenario: I make two withdrawals from my account
    When I withdraw 30 Euros
    And I withdraw 10 Euros
    Then My balance should be 60 Euros
