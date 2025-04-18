Feature: Adding a movie to the library

    Scenario: A movie is added to the library
        Given the movie library is open
        When the used adds a movie with the title "mr Nobody" and director "Jaco Van Dormael" and year 2009
        Then the movie "mr Nobody" is added to the library