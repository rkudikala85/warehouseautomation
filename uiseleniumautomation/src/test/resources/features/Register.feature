Feature: register functionality

  Background: 
    Given user navigate to site url

  @functional
  Scenario Outline: verify register functionality with valid data
    When user click on register link
    Then verify the register page title "Register"
    When user enter the FirstName "<firstname>"
    And user enter the last name "<lastName>"
    And user enter the email address "<email>"
    And user enter the password "<password>"
    When user enter the confirm password "<password>"
    When user select the role as employee "<role>"
    And user click on Register button
    Then verify the Logoutlink
    When user click on logout link

    Examples: 
      | firstname | lastName | email               | password    | role     |
      | KUDIKALA  | RAMESH   | supertesting2309@YAHOO.COM | TESTING@123 | Employee |
