
Feature: Navigation Menu

  Scenario: Navigation to Developer Menu
    Given The user is on the login page
    When The user enters teacher credentials
    Then The user should be able to see welcome message
    When The user navigates to Developers menu
    Then The user able to see Developers text


  Scenario: Navigation to Posts Menu
    Given The user is on the login page
    When The user enters student credentials
    Then The user should be able to see welcome message
    When The user navigates to All Post menu
    Then The user able to see All Post text


  Scenario: Navigation to My Account Menu
    Given The user is on the login page
    When The user enters teacher credentials
    Then The user should be able to see welcome message
    When The user navigates to My Account menu
    Then The user able to see Dashboard text