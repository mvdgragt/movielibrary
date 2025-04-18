Feature: Searching for a movie in the library

  Scenario: Searching for a movie in the library
    Given the library containes the movie "title1"
    When the user searches for the movie "title1"
    Then the movie "title1" should be found in the library