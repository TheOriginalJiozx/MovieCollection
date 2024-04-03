import java.util.Scanner;
public class Controller {
    private Scanner scanner = new Scanner(System.in);
    private MovieCollection collection = new MovieCollection();
    public void addMovie() {
        MovieCollection.addMovie(collection, scanner);
    }

    public void deleteMovie() {
        MovieCollection.deleteMovie(collection, scanner);
    }

    public void displayAllMovies() {
        collection.displayMovies();
    }

    public void searchMovie() {
        MovieCollection.searchMovie(collection, scanner);
    }

    public void editMovie() {
        MovieCollection.editMovie(collection, scanner);
    }
}
