import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class MovieCollection {
    private List<Movie> movies;

    public MovieCollection() {
        movies = new ArrayList<>();
    }

    public void addMovie(String title, String director, int yearCreated, boolean isInColor, double lengthInMinutes, String genre) {
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
                break;
            }
        }
        System.out.println("Movie '" + title + "' not found.");
        System.out.println();
    }

    public void searchMovies(String title) {
        System.out.println();
        boolean found = false;

        if (movies.isEmpty()) {
            System.out.println("Movie title cannot be blank.");
        } else {
            System.out.println("Movie(s) found: ");
            for (Movie movie : movies) {
                if (movie.getTitle().toLowerCase().contains(title.toLowerCase()) || title.equalsIgnoreCase("all")) {
                    System.out.println("Movie Title: " + movie.getTitle() + " - " + "Name of director: " + movie.getDirector() + " - " + "Year created: " + movie.getYearCreated() + " - " + "The movies length in minutes: " + movie.getLengthInMinutes() + " - " + "Genre: " + movie.getGenre());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No movie with the title '" + title + "' found in the collection.");
            }
        }
    }

    public Movie getMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }

    public void editMovie(String oldTitle, String newTitle, String director, int yearCreated, boolean isInColor, double lengthInMinutes, String genre) {
        Iterator<Movie> iterator = movies.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Movie movie = iterator.next();
            if (movie.getTitle().equalsIgnoreCase(oldTitle)) {
                movie.setTitle(newTitle);
                movie.setDirector(director);
                movie.setYearCreated(yearCreated);
                movie.setIsInColor(isInColor);
                movie.setLengthInMinutes(lengthInMinutes);
                movie.setGenre(genre);
                System.out.println("Movie '" + oldTitle + "' edited successfully.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Movie '" + oldTitle + "' not found.");
        }
        System.out.println();
    }

    public void displayMovies() {
        System.out.println();
        if (movies.isEmpty()) {
            System.out.println("No movies in the collection.");
            System.out.println();
        } else {
            System.out.println("Movies in the collection:");
            System.out.println();
            for (Movie movie : movies) {
                System.out.println("Movie Title: " + movie.getTitle() + " - " + "Name of director: " + movie.getDirector() + " - " + "Year created: " + movie.getYearCreated() + " - " + "The movies length in minutes: " + movie.getLengthInMinutes() + " - " + "Genre: " + movie.getGenre());
                System.out.println();
            }
        }
    }
}