Feature: Registration


  Scenario: Create new account

    Given I am on registration page
    When  I will enter correct email
    And   I will click on create account button
    Then  I should be on your personal information page
    Given I am on personal information page
    When  I will enter correct data
    And   I will click on Register button
    Then  I should be on my account page
    And   I should avaliable SignOut button


  Scenario: Create account with existing email
    Given I am on registration page
    When  I will enter correct email
    And   I will click on create account button
    Then  I should be on your personal information page
    Given I am on personal information page
    When  I will enter correct data
    And   I will click on Register button
    Then  I should be on my account page
    And   I should LogOut
    Given I am on CREATE AN ACCOUNT page
    When  I will enter existing email
    And   I will click on create account button
    Then  I should receive error message





