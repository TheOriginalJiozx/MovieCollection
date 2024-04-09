import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Controller controller = new Controller();
    private ArrayList<Movie> movies = new ArrayList<>();

    public void startProgram() throws FileNotFoundException {
        char choice;
        do {
            displayMenu();
            choice = getUserChoice();
            handleChoice(choice);
        } while (choice != '7');

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add a movie");
        System.out.println("2. Delete a movie");
        System.out.println("3. Display all movies");
        System.out.println("4. Search for a movie");
        System.out.println("5. Edit movie");
        System.out.println("6. Save movie");
        System.out.println("7. Exit");
        System.out.println();
        System.out.println("Enter your choice: ");
    }

    private char getUserChoice() {
        return scanner.next().charAt(0);
    }

    private String getUserChoiceDisplay() {
        return scanner.next();
    }

    private void handleChoice(char choice) throws FileNotFoundException {
        switch (choice) {
            case '1':
                controller.addMovie();
                break;
            case '2':
                controller.deleteMovie();
                break;
            case '3':
                System.out.println("Would you like to list movies sorted by movie names? (yes/no)");
                String userChoice = getUserChoiceDisplay();
                while (!(userChoice.equalsIgnoreCase("no") || userChoice.equalsIgnoreCase("yes"))) {
                    System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
                    userChoice = getUserChoiceDisplay();
                }
                if (userChoice.equalsIgnoreCase("yes")) {
                    Collections.sort(movies, new NameComparator());
                    controller.displayMoviesSortedByTitle();
                } else {
                    controller.displayAllMovies();
                }
                break;
            case '4':
                controller.searchMovie();
                break;
            case '5':
                controller.editMovie();
                break;
            case '6':
                controller.saveMovie();
                break;
            case '7':
                System.out.println();
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}