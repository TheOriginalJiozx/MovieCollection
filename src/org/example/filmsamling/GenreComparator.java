package org.example.filmsamling;
import java.util.Comparator;

public class GenreComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie d1, Movie d2) {
        return d1.getGenre().compareToIgnoreCase(d2.getGenre());
    }
}