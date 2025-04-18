Feature: Removing a movie to the library

  Scenario: Removing a movie from the library
    Given the library contains the movie "mr Nobody"
    When the user selects "Remove Movie" for the movie "mr Nobody"
    Then the movie "title1 " should be removed from the library