Feature: home page Functionality

  Background: 
    Given user navigate to site url

  @smoke
  Scenario: verify homePage elements
    Then verify register link displyed
    Then verify login link displayed

  @smoke
  Scenario: verify Register link
    When user click on register link
    Then verify the register page title "Register"

  @smoke
  Scenario: verify Login link
    When user click on Login link
    Then verify the login page title "Login"

