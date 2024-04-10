package org.example.filmsamling;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;

import java.util.Scanner;
public class Controller {
    private Scanner scanner = new Scanner(System.in);
    private MovieCollection collection = new MovieCollection();
    public void addMovie() {
        MovieCollection.addMovie(collection, scanner);
    }

    public void deleteMovie() {
        MovieCollection.deleteMovie(collection, scanner);
    }

    public void displayAllMovies() {
        collection.displayMovies();
    }

    public void displayMoviesSortedByTitle() {
        collection.displayMoviesSortedByTitle();
    }

    public void displayMoviesSortedByAttributes(String primaryAttribute, String secondaryAttribute) {
        collection.displayMoviesSortedByAttributes(primaryAttribute, secondaryAttribute);
    }

    public void displayMoviesSortedByChoice(String choice) {
        collection.displayMoviesSortedByChoice(choice);
    }

    public void searchMovie() {
        MovieCollection.searchMovie(collection, scanner);
    }

    public void editMovie() {
        MovieCollection.editMovie(collection, scanner);
    }
}
