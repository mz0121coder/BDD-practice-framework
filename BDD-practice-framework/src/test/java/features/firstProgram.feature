Feature: Application Login

#  Background keyword for common scenarios to be executed before every other scenario in this feature file
  Background:
    Given entries are set up in the database
    And the browser is launched from config variables
    And hit the home page url of the banking site

  @RegressionTest
  Scenario: Admin Page default login
    Given the user is on the NetBanking landing page
    When the user logs in to the application with username "admin" and password "1234"
    Then NetBanking's home page is displayed
    And cards are displayed

  @RegressionTest   @SmokeTest
  Scenario: User Page default login
    Given the user is on the NetBanking landing page
    When the user logs in to the application with username "user" and password "0953"
    Then NetBanking's home page is displayed
    And cards are displayed

  @SmokeTest
# repeating a parameterised test
  Scenario Outline: Landing Page login
    Given the user is on the NetBanking landing page
    When the user logs in to the application with username "<username>" and password "<password>"
    Then NetBanking's home page is displayed
    And cards are displayed

    Examples:
      | username   | password |
      | debituser  | hello123 |
      | user       | 0953     |
      | credituser | lpo213   |

#    sending data as a list
  Scenario: User Page default Sign up
    Given the user is on practice landing page
    When the user signs up
      | rahul             |
      | shetty            |
      | contact@email.com |
      | 54346732568       |
    Then NetBanking's home page is displayed
    And cards are displayed