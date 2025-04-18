package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final FilmBibliotek filmbibliotek = new FilmBibliotek();

    public static void main(String[] args) {
        addInitialFilms();
        runMainMenu();
    }

    private static void addInitialFilms() {
        filmbibliotek.addFilm("title1", "director1", 2001);
        filmbibliotek.addFilm("title2", "director2", 2002);
    }

    private static void runMainMenu() {
        int choice;

        do {
            System.out.println("\n--- Main menu ---");
            System.out.println("1. View all movies");
            System.out.println("2. Add a movie");
            System.out.println("3. Remove a movie");
            System.out.println("4. Search for a movie");
            System.out.println("0. Exit");
            System.out.print("Select menu option: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                showMenuChoices(choice);
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // clear invalid input
                choice = -1;
            }

        } while (choice != 0);
    }

    private static void showMenuChoices(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Exiting program");
                break;
            case 1:
                System.out.println("View all movies");
                showAllMovies();
                break;
            case 2:
                System.out.println("Add a movie");
                addMovie();
                break;
            case 3:
                System.out.println("Remove a movie");
                removeMovie();
                break;
            case 4:
                System.out.println("Search for a movie");
                searchMovie();
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    private static void addMovie() {
        System.out.print("Enter movie title: ");
        String title = scanner.nextLine();
        System.out.print("Enter director name: ");
        String director = scanner.nextLine();
        System.out.print("Enter release year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // consume newline

        filmbibliotek.addFilm(title, director, year);
        System.out.println("Movie added successfully!");
    }

    private static void removeMovie() {
        System.out.print("Enter movie title to remove: ");
        String title = scanner.nextLine();
        filmbibliotek.removeFilm(title);
        System.out.println("Movie removed successfully!");
    }

    private static void searchMovie() {
        System.out.print("Enter movie title to search: ");
        String title = scanner.nextLine();
        Movie movie = filmbibliotek.searchFilm(title);
        if (movie != null) {
            System.out.println("Movie found: " + movie);
        } else {
            System.out.println("Movie not found!");
        }
    }

    private static void showAllMovies() {
        List<Movie> movies = filmbibliotek.getAllMovies();
        if (movies.isEmpty()) {
            System.out.println("No movies in the library!");
        } else {
            System.out.println("All movies:");
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }
}