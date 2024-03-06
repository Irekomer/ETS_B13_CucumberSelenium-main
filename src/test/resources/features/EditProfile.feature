Feature: The user should be able to edit profile

  @edit_profile
  Scenario: edit profile
    Given The user is on the login page
    And The user logs in using "bonucci1@eurotech.com" and "Test1234"
    When The user navigates to "Edit Profile" menu
    And The user selects status "Senior Developer"
    And The user slides the slider 10
    And The user adds "company" "Eurotech Study"
    And The user adds "website" "eurotech@eurotech.study"
    And The user adds "location" "Hamburg"
    And The user adds "skills" "Java,Selenium,Cucumber,TestNG"
    And The user adds "githubusername" "github_bonucci1"
    And The user adds "bio" "SDET bootcamp"
    And The user clicks on the submit button
    Then The user verifies that profile info has been successfully updated

  @edit_profile_with_so
  Scenario Outline: edit profile
    Given The user is on the login page
    And The user logs in using "<email>" and "<password>"
    When The user navigates to "<addInfoMenu>" menu
    And The user selects status "<statusInfo>"
    And The user slides the slider <yearNum>
    And The user adds "company" "<companyInfo>"
    And The user adds "website" "<websiteInfo>"
    And The user adds "location" "<locationInfo>"
    And The user adds "skills" "<skillsInfo>"
    And The user adds "githubusername" "<githubNameInfo>"
    And The user adds "bio" "<bioInfo>"
    And The user clicks on the submit button
    Then The user verifies that profile info has been successfully updated
    Examples:
      | email                 | password | addInfoMenu  | statusInfo       | yearNum | companyInfo | websiteInfo             | locationInfo | skillsInfo             | githubNameInfo  | bioInfo   |
      | bonucci1@eurotech.com | Test1234 | Edit Profile | Senior Developer | 10      | Eurotech    | eurotech@eurotech.study | Berlin       | Java,Selenium,Cucumber | github_bonucci1 | Developer |

    # HW edit profile with dataTable and ScenarioOutline