import java.util.Scanner;
import java.util.InputMismatchException;

public class Filmsamling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieCollection collection = new MovieCollection();

        char choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add a movie");
            System.out.println("2. Delete a movie");
            System.out.println("3. Display all movies");
            System.out.println("4. Search for a movie");
            System.out.println("5. Exit");
            System.out.println();
            System.out.println("Enter your choice: ");
            choice = scanner.next().charAt(0);

            switch (choice) {
                case '1':
                    addMovie(collection, scanner);
                    break;
                case '2':
                    deleteMovie(collection, scanner);
                    break;
                case '3':
                    collection.displayMovies();
                    break;
                case '4':
                    searchMovie(collection, scanner);
                    break;
                case '5':
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != '5');

        scanner.close();
    }

    private static void addMovie(MovieCollection collection, Scanner scanner) {
        System.out.println();
        scanner.nextLine();
        System.out.println("Enter the title of the movie: ");
        String title = scanner.nextLine();

        System.out.println();
        String director;
        while (true) {
            try {
                System.out.println("Enter the name of the director: ");
                director = scanner.nextLine();
                if (containsNumbers(director)) {
                    throw new InputMismatchException("Director's name cannot contain numbers.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(e.getMessage());
            }
        }

        System.out.println();
        int yearCreated;
        while (true) {
            try {
                System.out.println("Enter the year the movie was released: ");
                yearCreated = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println("Invalid input. Please enter a valid year.");
                scanner.nextLine();
            }
        }

        System.out.println();
        boolean isInColor = false;
        while (true) {
                System.out.println("Is the movie in color? (yes/no): ");
                String input = scanner.nextLine().toLowerCase();
                if (input.equals("yes")) {
                    isInColor = true;
                    break;
                } else if (input.equals("no")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            }

        System.out.println();
        int lengthInMinutes;
        while (true) {
            try {
                System.out.println("How long is the movie in minutes?: ");
                lengthInMinutes = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid length in minutes.");
                scanner.nextLine();
            }
        }

        System.out.println();
        String genre;
        while (true) {
            try {
                System.out.println("What genre is it?: ");
                genre = scanner.nextLine();
                if (containsNumbers(genre)) {
                    throw new InputMismatchException("Invalid input. Please enter a valid genre.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println();
                System.out.println(e.getMessage());
            }
        }

        System.out.println();
        collection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
        System.out.println("Movie added successfully!");
        System.out.println();
    }

    private static void deleteMovie(MovieCollection collection, Scanner scanner) {
        System.out.println();
        scanner.nextLine();
        System.out.println("Enter the title of the movie to delete: ");
        String title = scanner.nextLine();
        collection.deleteMovie(title);
        System.out.println();
    }

    private static void searchMovie(MovieCollection collection, Scanner scanner) {
        System.out.println();
        scanner.nextLine();
        System.out.println("Enter the title (or part of) of the movie: ");
        String title = scanner.nextLine();
        collection.searchMovies(title);
        System.out.println();
    }

    private static boolean parseYesNo(String input) {
        input = input.toLowerCase();
        return input.equals("yes") || input.equals("y");
    }

    private static boolean containsNumbers(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}