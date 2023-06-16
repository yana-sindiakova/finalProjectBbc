Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check the title of the main news
    Given User opens '<homepage>' page
    When User goes to News Page
    Then User checks main news '<title>' title
    Examples:
      | homepage             | title                                            |
      | https://www.bbc.com/ | Russia\'s deadline for Mariupol surrender passes |

  Scenario Outline: Check titles of the secondary news
    Given User opens '<homepage>' page
    When User goes to News Page
    Then User checks secondary news titles
      | Mariupol fighters' relatives tell of bitter pride              |
      | In maps: Russia builds up troops in new offensive              |
      | Why Russia wants to seize Ukraine's eastern Donbas             |
      | Ukraine round-up: Allies pledge weapons as Russia targets east |
      | Images appear to show sinking Russian warship                  |
    Examples:
      | homepage             |
      | https://www.bbc.com/ |


  Scenario Outline: Check search by category value
    Given User opens '<homepage>' page
    And User goes to News Page
    And User get Category name
    And  User goes to Search page
    Then User search by category name
    Then User checks that search results contains category value
    Examples:
      | homepage             |
      | https://www.bbc.com/ |

  Scenario Outline: Check failed question sending without required email data
    Given User opens '<homepage>' page
    And User goes to News Page
    And User goes to Coronavirus page
    And User goes to Coronavirus Story page
    And User goes to Coronavirus Question page
    And User goes to Question Form
    When User fills question field
      | Hello from Ukraine |
    And User fills coronavirus question form
      | Name | Yana |
    And User selects Accepted checkbox
    And User submit coronavirus question form
    Then User checks empty email error message '<message>'
    Examples:
      | homepage             | message                       |
      | https://www.bbc.com/ | Email address can\'t be blank |

  Scenario Outline: Check failed question sending without required name data
    Given User opens '<homepage>' page
    And User goes to News Page
    And User goes to Coronavirus page
    And User goes to Coronavirus Story page
    And User goes to Coronavirus Question page
    And User goes to Question Form
    When User fills question field
      | Hello from Ukraine |
    And User fills coronavirus question form
      | Email address | email@gmail.com |
    And User selects Accepted checkbox
    And User submit coronavirus question form
    Then User checks empty name error message '<message>'
    Examples:
      | homepage             | message              |
      | https://www.bbc.com/ | Name can\'t be blank |

  Scenario Outline: Check failed question sending without required selected accepted checkbox
    Given User opens '<homepage>' page
    And User goes to News Page
    And User goes to Coronavirus page
    And User goes to Coronavirus Story page
    And User goes to Coronavirus Question page
    And User goes to Question Form
    When User fills question field
      | Hello from Ukraine |
    And User fills coronavirus question form
      | Email address | email@gmail.com |
      | Name          | Yana            |
    And User submit coronavirus question form
    Then User checks unselected checkbox error message '<message>'
    Examples:
      | homepage             | message          |
      | https://www.bbc.com/ | must be accepted |

  Scenario Outline: Check that team scores display correctly
    Given User opens '<homepage>' page
    And User goes to Sport Page
    And User goes to Football Page
    And User goes to Scores & Fixtures Page
    When User search by championship '<championship>'
    And User selects month '<month>'
    Then User checks that two specific teams '<homeTeamName>', '<awayTeamName>' played with a specific score '<homeTeamScore>', '<awayTeamScore>'
    And User goes to Score details page
    And User checks that teams '<homeTeamName>', '<awayTeamName>' played with a specific score '<homeTeamScore>', '<awayTeamScore>'
    Examples:
      | homepage             | championship          | month | homeTeamName        | awayTeamName       | homeTeamScore | awayTeamScore |
      | https://www.bbc.com/ | Scottish Championship | MAR   | Arbroath            | Raith Rovers       | 3             | 3             |
      | https://www.bbc.com/ | Scottish Championship | FEB   | Ayr United          | Queen of the South | 0             | 1             |
      | https://www.bbc.com/ | Scottish Championship | JAN   | Hamilton Academical | Ayr United         | 1             | 1             |

