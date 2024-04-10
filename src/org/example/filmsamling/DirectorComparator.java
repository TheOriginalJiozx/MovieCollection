package org.example.filmsamling;
import java.util.Comparator;

public class DirectorComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie d1, Movie d2) {
        return d1.getDirector().compareToIgnoreCase(d2.getDirector());
    }
}