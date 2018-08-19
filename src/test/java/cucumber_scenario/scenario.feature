Feature: Withdraw Cash
  I want to withdraw cash from atm
  I have valid card
  I am account holder

  Scenario:scenario1

    Given I have 200 PLN in my account
    When  I want to withdraw 500 PLN from ATM
     And  I enter valid PIN number
    Then  The atm should not dispense any money
     And  I check error message
     And  I check the account balance
     And  The card should be returned

  Scenario:scenario2

    Given I have 200 PLN in my account
    When  I want to withdraw 0 PLN from ATM
    And   I enter valid PIN number
    Then  The atm should not dispense any money
    And   I check error message
    Given I have 200 PLN in my account
    When  I want to withdraw 50 PLN from ATM
    Then  ATM dispensens money
    And   I have check the account balance
    Given I have 150 PLN in my account
    When  I want to withdraw 100 PLN from ATM
    Then  ATM dispensens money
    Given I have 50 PLN in my account
    When  I want to withdraw 150 PLN from ATM
    Then  The atm should not dispense any money
    And   I check error message
  // kolejny krok sprawdza to samo więc jest nadmiarowy
    And   I change the amount to 200 PLN
    Then  The atm should not dispense any money
    And   I check error message
    And   I check the account balance
    And   The card should be returned


Scenario:scenario_proposal

  Given I have 200 PLN in my account
  When  I want to withdraw 0 PLN from ATM
  And   I enter valid PIN number
  Then  The atm should not dispense any money
  And   I check error message
  Given I have 200 PLN in my account
  When  I want to withdraw 50 PLN from ATM
  And   I enter valid PIN number
  Then  ATM dispensens money
  And   I have check the account balance
  Given I have 150 PLN in my account
  When  I want to withdraw 150 PLN from ATM
  And   I enter valid PIN number
  Then  ATM dispensens money
  And   I have check the account balance
  Given I have 0 PLN in my account
  When  I want to withdraw 100 PLN from ATM
  And   I enter valid PIN number
  Then  The atm should not dispense any money
  And   I check error message
  And   The card should be returned







