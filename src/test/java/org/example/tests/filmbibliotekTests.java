package org.example.tests;

import org.example.FilmBibliotek;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class filmbibliotekTests {

    private FilmBibliotek bibliotek;

    //Denna metod körs innan varje testfall
    @BeforeEach
    public void setUp() {
        bibliotek = new FilmBibliotek();
        bibliotek.addFilm("title1", "director1", 2001);
        bibliotek.addFilm("title2", "director2", 2002);
    }

    @Test
    public void testAddMovie() {
        // Arrange
        FilmBibliotek bibliotek = new FilmBibliotek();
        // Act
        bibliotek.addFilm("mr Nobody", "Jaco Van Dormael", 2009);
        boolean filmAdded = bibliotek.contains("mr Nobody");

        // Assert
        Assertions.assertTrue(filmAdded, "Film should be added to the library.");
    }

    @Test
    public void testRemoveMovie() {
        // Arrange done in setup

        // Act
        bibliotek.removeFilm("title1");
        boolean filmRemoved = bibliotek.contains("title1");

        // Assert
        Assertions.assertFalse(filmRemoved, "Film should not exist in library.");
    }

    @Test
    public void testSearchMovie() {
        // Arrange done in setup

        // Act
        bibliotek.searchFilm("title1");
        boolean filmSearchResult = bibliotek.contains("title1");

        // Assert
        Assertions.assertTrue(filmSearchResult, "Film found in library");
    }

}
