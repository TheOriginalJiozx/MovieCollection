import java.util.Scanner;
public class Controller {
    private Scanner scanner = new Scanner(System.in);
    private MovieCollection collection = new MovieCollection();
    public void addMovie() {
        Filmsamling.addMovie(collection, scanner);
    }

    public void deleteMovie() {
        Filmsamling.deleteMovie(collection, scanner);
    }

    public void displayAllMovies() {
        collection.displayMovies();
    }

    public void searchMovie() {
        Filmsamling.searchMovie(collection, scanner);
    }

    public void editMovie() {
        Filmsamling.editMovie(collection, scanner);
    }
}
