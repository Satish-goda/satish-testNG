
@tag
Feature: Purchasing an order from Ecommerce website

Background:
Given I landed on Ecommerce Page

  @tag2
  Scenario Outline: positive test of submittting the order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmPage
    Examples: 
      | name  										| password   | productName   |
      | satishpractice8@gmail.com | Satish@123 | IPHONE 13 PRO |
      
 