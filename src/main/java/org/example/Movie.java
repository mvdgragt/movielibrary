package org.example;

public class Movie {
    private final String title;
    private final String director;
    private final int year;

    public Movie(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }


    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        //  return super.toString();
        return "Movie{" +
                "title= '" + title + '\'' +
                ", year=" + year +
                '}';
    }
}

