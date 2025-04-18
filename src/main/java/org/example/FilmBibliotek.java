package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilmBibliotek {

    private static final Scanner scanner = new Scanner(System.in);
    List<Movie> movies = new ArrayList<>();

    public void addFilm(String title, String director, int year) {
        if (contains(title)) {
            return;
        }

        Movie movie = new Movie(title, director, year);
        movies.add(movie);
    }

    private Movie getFilmByTitle(String title) {
        for (Movie movie : movies) {
            if (title.equalsIgnoreCase(movie.getTitle())) {
                System.out.println(title);
                return movie;
            }
        }
        return null;
    }

    public boolean contains(String title) {
        Movie movie = getFilmByTitle(title);
        return movie != null;

//        for (Movie movie : movies) {
//            if (title.equalsIgnoreCase(movie.getTitle())) {
//                return true;
//            }
//
//        }
    }

    public void removeFilm(String title) {
        movies.removeIf(movie -> movie.getTitle().equalsIgnoreCase(title));
    }

    public Movie searchFilm(String title) {
        return getFilmByTitle(title);
    }

    public List<Movie> getAllMovies() {
        return new ArrayList<>(movies);
    }

}
