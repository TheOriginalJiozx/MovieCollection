package org.example.filmsamling;
import java.util.Comparator;

public class ColorComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie d1, Movie d2) {
        return Boolean.compare(d1.getIsInColor(), d2.getIsInColor());
    }
}