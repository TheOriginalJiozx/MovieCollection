package org.example.filmsamling;

import java.util.Comparator;

public class MovieComparator implements Comparator<Movie> {
    private String primaryAttribute;
    private String secondaryAttribute;

    public MovieComparator(String primaryAttribute, String secondaryAttribute) {
        this.primaryAttribute = primaryAttribute;
        this.secondaryAttribute = secondaryAttribute;
    }

    @Override
    public int compare(Movie m1, Movie m2) {
        int result = compareAttribute(m1, m2, primaryAttribute);
        if (result == 0) {
            return compareAttribute(m1, m2, secondaryAttribute);
        }
        return result;
    }

    private int compareAttribute(Movie m1, Movie m2, String attribute) {
        switch (attribute.toLowerCase()) {
            case "title":
                return m1.getTitle().compareToIgnoreCase(m2.getTitle());
            case "director":
                return m1.getDirector().compareToIgnoreCase(m2.getDirector());
            case "genre":
                return m1.getGenre().compareToIgnoreCase(m2.getGenre());
            case "length":
                return Double.compare(m1.getLengthInMinutes(), m2.getLengthInMinutes());
            case "year created":
                return Integer.compare(m1.getYearCreated(), m2.getYearCreated());
            case "colour":
                return Boolean.compare(m1.getIsInColor(), m2.getIsInColor());
            default:
                return 0;
        }
    }
}