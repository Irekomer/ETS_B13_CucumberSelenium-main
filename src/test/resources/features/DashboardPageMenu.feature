Feature: Dashboard Page Menu

  Background:
    Given The user is on the login page

  Scenario: User should be able to see Dashboard Menu after log in
    #Given The user is on the login page
    When The user logs in using "eurotech@gmail.com" and "Test12345!"
    Then The welcome message contains "Teacher"
    And The user should be able to see following menu
      | Developers |
      | All Posts  |
      | My Account |


  Scenario: Log in as specific user and then see Dashboard Menu
   # Given The user is on the login page
    When The user logs in using following credentials
      | userEmail | eurotech@gmail.com |
      | password  | Test12345!         |
      | message   | Teacher            |
    Then The user should be able to login
    And The user should be able to see following menu
      | Developers |
      | All Posts  |
      | My Account |

  @rerun
  Scenario: User should be able to see Dashboard Menu after log in
    #Given The user is on the login page
    When The user logs in using "eurotech@gmail.com" and "Test12345!"
    Then The welcome message contains "Teacher"
    And The user should be able to see following edit add menu
      | Edit Profile   |
      | Add Experience |
      | Add Education  |


