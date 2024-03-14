
@tag
Feature: 
 Login : Negative test cases



  @incorrectusernamevalidation
  Scenario Outline:  Login with incorrect username and password
    Given User is on eCommerce page.
    When user logged in using username <username> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | username  | password | 
      | afsala1231111@gmail.com| Aa123456| 

    @incorrectpasswordvalidation
    Scenario Outline:  Login with correct username and incorrect password
    Given User is on eCommerce page.
    When user logged in using username <username> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | username  | password | 
      | afsala123@gmail.com| Aa123456789| 
    