Feature: Data Driven Test in Cucumber

  @ddf
  Scenario Outline: DDF Login Test
    Given The user is on the login page
    When The user enters "<SheetName>" and row number <rowNumber>
    Then The warning message should contains "<SheetName>" <rowNumber>
    And The user verifies that "<infoTitle>" info in excel "<SheetName>" <rowNumber>
    Examples:
      | SheetName | rowNumber | infoTitle |
      | Test Data | 1         | Company   |
      | Test Data | 1         | Title     |
      | Test Data | 2         | Company   |
      | Test Data | 2         | Title     |
      | Test Data | 3         | Company   |
      | Test Data | 3         | Title     |
      | Test Data | 4         | Company   |
      | Test Data | 4         | Title     |
