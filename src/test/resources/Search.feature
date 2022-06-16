Feature: Search

  Scenario: Search for a celebrity
    Given That I'm on the Google homepage
    When type "George W. Bush"
      And click search
    Then a summary about the president is displayed