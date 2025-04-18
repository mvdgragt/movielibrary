package org.example.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.FilmBibliotek;
import org.junit.jupiter.api.Assertions;

public class FilmbibliotekSteps {

    private final FilmBibliotek filmBibliotek = new FilmBibliotek();

    /*
      Add movie step definitions
       */
    @Given("the movie library is open")
    public void the_movie_library_is_open() {
    }

    @When("the used adds a movie with the title {string} and director {string} and year {int}")
    public void the_used_adds_a_movie_with_the_title_and_director_and_year(String title, String director, Integer year) {
        filmBibliotek.addFilm(title, director, year);
    }

    @Then("the movie {string} is added to the library")
    public void the_movie_is_added_to_the_library(String title) {
        boolean filmAdded = filmBibliotek.contains(title);
        Assertions.assertTrue(filmAdded, "Film should be added to the library.");
    }

    /*
    Remove movie step definitions
     */

    @Given("the library contains the movie {string}")
    public void the_library_contains_the_movie(String title) {
        filmBibliotek.addFilm(title, "", 0);
    }

    @When("the user selects {string} for the movie {string}")
    public void the_user_selects_for_the_movie(String action, String title) {
        if (action.equalsIgnoreCase("Remove movie")) {
            filmBibliotek.removeFilm(title);
        }
    }

    @Then("the movie {string} should be removed from the library")
    public void the_movie_should_be_removed_from_the_library(String title) {
        boolean filmRemoved = filmBibliotek.contains(title);
        Assertions.assertFalse(filmRemoved, "Film should be removed to the library.");
    }

    /*
    Searching for movie in library
     */

    @When("the user searches for the movie {string}")
    public void the_user_searches_for_the_movie(String string) {
        filmBibliotek.searchFilm("title1");
    }

    @Then("the movie {string} should be found in the library")
    public void the_movie_should_be_found_in_the_library(String string) {
        boolean SearchedFilm = filmBibliotek.contains("title1");
        Assertions.assertTrue(SearchedFilm, "Film found in library.");
    }
}

