Feature: deposit money to account
  In order to save money
  As a bank client
  I want to make a deposit in my account

  Scenario: I make one deposit to my account
    Given I have an empty account
    When I deposit 100 Euros
    Then My balance should be 100 Euros

  Scenario: I make two deposits to my account
    Given I have an empty account
    When I deposit 100 Euros
    And I deposit 200 Euros
    Then My balance should be 300 Euros