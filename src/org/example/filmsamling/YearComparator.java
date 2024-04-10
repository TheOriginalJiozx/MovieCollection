package org.example.filmsamling;
import java.util.Comparator;

public class YearComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie d1, Movie d2) {
        return Integer.compare(d1.getYearCreated(), d2.getYearCreated());
    }
}