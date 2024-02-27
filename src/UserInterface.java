import java.util.Scanner;
public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private MovieCollection collection = new MovieCollection();

    public void startProgram() {
        char choice;
        do {
            displayMenu();
            choice = getUserChoice();
            handleChoice(choice);
        } while (choice != '6');

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add a movie");
        System.out.println("2. Delete a movie");
        System.out.println("3. Display all movies");
        System.out.println("4. Search for a movie");
        System.out.println("5. Edit movie");
        System.out.println("6. Exit");
        System.out.println();
        System.out.println("Enter your choice: ");
    }

    private char getUserChoice() {
        return scanner.next().charAt(0);
    }

    private void handleChoice(char choice) {
        switch (choice) {
            case '1':
                addMovie();
                break;
            case '2':
                deleteMovie();
                break;
            case '3':
                displayAllMovies();
                break;
            case '4':
                searchMovie();
                break;
            case '5':
                editMovie();
                break;
            case '6':
                System.out.println();
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void addMovie() {
        Filmsamling.addMovie(collection, scanner);
    }

    private void deleteMovie() {
        Filmsamling.deleteMovie(collection, scanner);
    }

    private void displayAllMovies() {
        collection.displayMovies();
    }

    private void searchMovie() {
        Filmsamling.searchMovie(collection, scanner);
    }

    private void editMovie() {
        Filmsamling.editMovie(collection, scanner);
    }
}