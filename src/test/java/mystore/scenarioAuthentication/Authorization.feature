Feature:Authorization


  Scenario: Login to existing account

    Given I am on authentication page
    When  I will enter correct email address
    And   I will enter correct password
    And   I will click on Sign button
    Then  I should be on my account


   Scenario: Login incorrect email

     Given I am on authentication page
     When  I will enter invalid email address
     And   I will enter correct password
     And   I will click on Sign button
     Then  I should not be login
     And   I receive error message


    Scenario:  Login null password

      Given I am on authentication page
      When  I will enter correct email address
      And   I will enter null password
      And   I will click on Sign button
      Then  I should not be login
      And   I receive error message_password