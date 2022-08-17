Feature: Login with valid credentials

  As customer
  I want to to be able to login to application providing valid credentials

  @Start @Smoke
  Scenario Outline: Login to app
    Given the app login page is open
    When the user enters correct <username> and <password>
    Then the user is logged in

    @regression
    Examples:
      | username      | password     |
      | problem_user  | secret_sauce |

    @smoke @regression
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  @Stop
  Scenario: Logout from app
    Given the user is logged in
    When the user logs out
    Then the app login page is open