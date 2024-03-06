Feature: Account Type

  Background:
    Given The user is on the login page

  Scenario: Teacher user
    When The user logs in using "eurotech@gmail.com" and "Test12345!"
    Then The welcome message contains "Teacher"


  Scenario: Student user
    When The user logs in using "sparrowjack@gmail.com" and "sparrow1"
    Then The welcome message contains "Jack"


  Scenario: Developer user
    When The user logs in using "jackbauer@gmail.com" and "Admin123"
    Then The welcome message contains "Jack Bauer"


  Scenario Outline: Different User Type
    When The user logs in using "<userType>" and "<password>"
    Then The welcome message contains "<name>"
    Examples:
      | userType               | password   | name       |
      | eurotech@gmail.com     | Test12345! | Teacher    |
      | sparrowjack@gmail.com  | sparrow1   | Jack       |
      | jackbauer@gmail.com    | Admin123   | Jack Bauer |
      | sdetkosovali@gmail.com | Bosnali123 | kosovali   |
      | betltestabc1@gmail.com | btl.10     | Betül      |

