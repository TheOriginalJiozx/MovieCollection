package org.example.filmsamling;
import java.util.Comparator;

public class Comporator implements Comparator<Movie> {
    private String choice;
    private String primaryAttribute;
    private String secondaryAttribute;

    public Comporator(String choice) {
        this.choice = choice;
    }

    @Override
    public int compare(Movie m1, Movie m2) {
        switch (choice.toLowerCase()) {
            case "title":
                String title1 = m1.getTitle();
                String title2 = m2.getTitle();
                return title1.compareToIgnoreCase(title2);
            case "director":
                String director1 = m1.getDirector();
                String director2 = m2.getDirector();
                return director1.compareToIgnoreCase(director2);
            case "genre":
                String genre1 = m1.getGenre();
                String genre2 = m2.getGenre();
                return genre1.compareToIgnoreCase(genre2);
            case "length":
                double length1 = m1.getLengthInMinutes();
                double length2 = m2.getLengthInMinutes();
                return Double.compare(length1, length2);
            case "year created":
                int year1 = m1.getYearCreated();
                int year2 = m2.getYearCreated();
                return Integer.compare(year1, year2);
            case "colour":
                boolean color1 = m1.getIsInColor();
                boolean color2 = m2.getIsInColor();
                return Boolean.compare(color1, color2);
            default:
                return 0;
        }
    }
}