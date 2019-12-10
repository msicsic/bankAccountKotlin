Feature: statement printing
  In order to check my operations
  As a bank client
  I want to see the history (operation, date, amount, balance) of my operations

  Background: I have an empty account
    Given I have an empty account

  Scenario: make one deposit on my account and print statement
    Given make the following operations
      | operation | date       | amount |
      | DEPOSIT   | 2010-10-01 | 50     |
    When I ask for the statement
    Then I should see
      | operation | date       | amount | balance |
      | DEPOSIT   | 2010-10-01 | 50     | 50      |

  Scenario: make multiple operations on my account and print statement
    Given make the following operations
      | operation  | date       | amount |
      | DEPOSIT    | 2010-10-01 | 50     |
      | DEPOSIT    | 2010-10-02 | 30     |
      | WITHDRAWAL | 2010-10-03 | 20     |
    When I ask for the statement
    Then I should see
      | operation  | date       | amount | balance |
      | WITHDRAWAL | 2010-10-03 | -20    | 60      |
      | DEPOSIT    | 2010-10-02 | 30     | 80      |
      | DEPOSIT    | 2010-10-01 | 50     | 50      |
