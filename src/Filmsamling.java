import java.util.Scanner;
import java.util.InputMismatchException;

public class Filmsamling {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.startProgram();
    }

    public static void addMovie(MovieCollection collection, Scanner scanner) {
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
        boolean isInColor;
        while (true) {
            System.out.println("Is the movie in color? (yes/no): ");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("yes")) {
                isInColor = true;
                break;
            } else if (input.equals("no")) {
                isInColor = false;
                break;
            } else {
                System.out.println();
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                System.out.println();
            }
        }

        System.out.println();
        double lengthInMinutes;
        while (true) {
            try {
                System.out.println("How long is the movie in minutes?: ");
                lengthInMinutes = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid length in minutes.");
                scanner.nextLine();
            }
        }

        System.out.println();
        System.out.println("What genre is it?: ");
        String genre = scanner.nextLine();

        collection.addMovie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
        System.out.println("Movie added successfully!");
        System.out.println();
    }

    static void deleteMovie(MovieCollection collection, Scanner scanner) {
        System.out.println();
        scanner.nextLine();
        System.out.println("Enter the title of the movie to delete: ");
        String title = scanner.nextLine();
        collection.deleteMovie(title);
        System.out.println();
    }

    static void searchMovie(MovieCollection collection, Scanner scanner) {
        System.out.println();
        scanner.nextLine();
        System.out.println("Enter the title (or part of) of the movie: ");
        String title = scanner.nextLine();
        collection.searchMovies(title);
        System.out.println();
    }

    static void editMovie(MovieCollection collection, Scanner scanner) {
        System.out.println();
        scanner.nextLine();
        System.out.println("Enter movie title: ");
        String title = scanner.nextLine();
        System.out.println();

        Movie movie = collection.getMovieByTitle(title);
        if (movie != null) {
            System.out.println("Enter new title: ");
            String newTitle = scanner.nextLine();
            movie.setTitle(newTitle);
            System.out.println();

            System.out.println("Enter new director name: ");
            String newDirector = scanner.nextLine();
            movie.setDirector(newDirector);
            System.out.println();

            System.out.println("Enter new release year: ");
            int newYearCreated = scanner.nextInt();
            movie.setYearCreated(newYearCreated);
            System.out.println();

            System.out.println("Is the movie in color? (Yes/No): ");
            boolean newIsInColor;
            while (true) {
                String colorInput = scanner.next().toLowerCase();
                if (colorInput.equals("yes") || colorInput.equals("no")) {
                    newIsInColor = colorInput.equals("yes");
                    break;
                } else {
                    System.out.println("Invalid input. Please enter 'Yes' or 'No'.");
                }
            }
            movie.setIsInColor(newIsInColor);
            System.out.println();

            System.out.println("Enter new movie length in minutes: ");
            double newLengthInMinutes;
            while (true) {
                try {
                    newLengthInMinutes = scanner.nextDouble();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid length in minutes.");
                    scanner.nextLine();
                }
            }
            movie.setLengthInMinutes(newLengthInMinutes);
            System.out.println();

            System.out.println("Enter new genre: ");
            String newGenre = scanner.nextLine();
            movie.setGenre(newGenre);

            System.out.println("Movie '" + title + "' has been successfully edited.");
        } else {
            System.out.println("Movie '" + title + "' not found.");
        }
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