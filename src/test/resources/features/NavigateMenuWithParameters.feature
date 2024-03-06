Feature: Navigate to menu with parameters

  Background:
    Given The user is on the login page

  Scenario: Teacher navigates to Developers menu
   # Given The user is on the login page
    When The user logs in using "eurotech@gmail.com" and "Test12345!"
    Then The welcome message contains "Teacher"
    When The user navigates to "Developers" menu
    Then The user should be able to see header as "Filter Profiles by Skill or by Location"

  Scenario: Student navigates to All Posts menu
   # Given The user is on the login page
    When The user logs in using "sparrowjack@gmail.com" and "sparrow1"
    Then The welcome message contains "Jack"
    When The user navigates to "All Posts" menu
    Then The user should be able to see header as "Posts"

  Scenario: Developer navigates to Developers then Dashboard  menu
   # Given The user is on the login page
    When The user logs in using "jackbauer@gmail.com" and "Admin123"
    Then The welcome message contains "Jack Bauer"
    When The user navigates to "Developers" menu
    And The user navigates to "My Account" menu
    Then The user should be able to see header as "Dashboard"

    # CLASS TASK--> Create navigate to menu with parameters feature test with scenario outline

  Scenario Outline: Different users navigate to different menus
    When The user logs in using "<userType>" and "<password>"
    Then The welcome message contains "<name>"
    When The user navigates to "<menu>" menu
    Then The user should be able to see header as "<header>"
    Examples:
      | userType              | password   | name       | menu       | header                                  |
      | eurotech@gmail.com    | Test12345! | Teacher    | Developers | Filter Profiles by Skill or by Location |
      | sparrowjack@gmail.com | sparrow1   | Jack       | All Posts  | Posts                                   |
      | jackbauer@gmail.com   | Admin123   | Jack Bauer | Developers | Filter Profiles by Skill or by Location |