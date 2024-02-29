import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MovieCollection {
    static List<Movie> movies;

    public MovieCollection() {
        movies = new ArrayList<>();
    }

    public static void addMovie(String title, String director, int yearCreated, boolean isInColor, double lengthInMinutes, String genre) {
        Movie movie = new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
        movies.add(movie);
    }

    public void deleteMovie(String title) {
        Iterator<Movie> iterator = movies.iterator();
        while (iterator.hasNext()) {
            Movie movie = iterator.next();
            if (movie.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                System.out.println("Movie '" + title + "' deleted successfully.");
                return;
            }
        }
        System.out.println("Movie '" + title + "' not found.");
    }

    public static List<Movie> searchMovies(String title) {
        List<Movie> searchResult = new ArrayList<>();

        if (movies.isEmpty()) {
            return null;
        } else {
            boolean found = false;
            for (Movie movie : movies) {
                if (movie.getTitle().toLowerCase().contains(title.toLowerCase()) || title.equalsIgnoreCase("all")) {
                    searchResult.add(movie);
                    found = true;
                }
            }
            if (!found) {
                return new ArrayList<>();
            }
        }

        return searchResult;
    }

    public static List<Movie> searchMoviesByGenre(String genre) {
        List<Movie> searchResult = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getGenre().equalsIgnoreCase(genre)) {
                searchResult.add(movie);
            }
        }
        return searchResult;
    }

    public static Movie getMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }

    public static void displayMovies() {
        System.out.println();
        if (movies.isEmpty()) {
            System.out.println("No movies in the collection.");
        } else {
            System.out.println("Movies in the collection:");
            for (Movie movie : movies) {
                System.out.println(movie.toString());
            }
        }
    }
}