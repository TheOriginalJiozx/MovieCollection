package org.example.filmsamling;
import java.util.Comparator;

public class NameComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie d1, Movie d2) {
        return d1.getTitle().compareToIgnoreCase(d2.getTitle());
    }
}