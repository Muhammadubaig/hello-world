Feature: GITHUB
  I search for terms

  Scenario: Search  github
    Given I have link  "github.com"
    When I enter valid "hygieia"
    And click search
    Then is should display the Result
