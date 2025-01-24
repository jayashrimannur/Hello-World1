
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file
  
  Background:
  Given I landed on Ecommerce page

  @SubmitOrder
  Scenario Outline: Positive Test for submitting the order
    Given Logged in with username <username> and password <password>
    When I add the Product  <productname> to cart
    And Checkout <productname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on the confirmation page

    Examples: 
      | username  								 | password 				|productname	|
      | testselenium@gmailtest.com | Test@1405 				|BANARSI SAREE|
      | samplet@test.com 					 | Sample@1405 			|IPHONE 13 PRO|

   