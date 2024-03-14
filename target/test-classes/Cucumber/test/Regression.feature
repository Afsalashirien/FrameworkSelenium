
@tag
Feature: Purchase the product

Background: 
Given User is on eCommerce page.
  
 
 
  @tag2
  
 Scenario Outline: Positive sceanario for purchasing the product.
  
    Given user logged in using username <username> and password <password>
    When I add the product <productname> into cart 
    And click checkout <productname> and complete the order
    Then I receive a success message as "THANKYOU FOR THE ORDER."

    Examples: 
      | username  | password | productname |
      | afsala123@gmail.com| Aa123456| ZARA COAT 3 |
      
