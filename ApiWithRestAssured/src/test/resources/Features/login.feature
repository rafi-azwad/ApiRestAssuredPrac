Feature: Login

  @smoke
  Scenario Outline: Check login with valid credentials
    Given user in the login page
    When user enter '<password>' and '<username>'
    And Click Button
    Then user will navigate to teh dashboard button

    Examples:
      | password | username |
      | tasnim   | tasnim   |