package org.example.filmsamling;
import java.util.Comparator;

public class LengthComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie d1, Movie d2) {
        return Double.compare(d1.getLengthInMinutes(), d2.getLengthInMinutes());
    }
}