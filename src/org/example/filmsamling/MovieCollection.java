package org.example.filmsamling;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Collections;
import java.util.InputMismatchException;
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

    public static void displayMoviesSortedByTitle() {
        ArrayList<Movie> movies = loadMoviesFromFile("movies.csv");
        if (movies.isEmpty()) {
            System.out.println("No movies in the collection.");
        } else {
            Collections.sort(movies, new NameComparator());
            System.out.println("Movies in the collection (sorted by name):");
            for (Movie movie : movies) {
                System.out.println(movie.toString());
            }
        }
    }

    public static void displayMoviesSortedByAttributes(String primaryAttribute, String secondaryAttribute) {
        ArrayList<Movie> movies = loadMoviesFromFile("movies.csv");
        if (movies.isEmpty()) {
            System.out.println("No movies in the collection.");
        } else {
            Comparator<Movie> primaryComparator = new MovieComparator(primaryAttribute, secondaryAttribute);

            Collections.sort(movies, primaryComparator);

            System.out.println("Movies in the collection (sorted by " + primaryAttribute + " then by " + secondaryAttribute + "):");
            for (Movie movie : movies) {
                System.out.println(movie.toString());
            }
        }
    }

    private static Comparator<Movie> getComparatorForAttribute(String attribute) {
        switch (attribute.toLowerCase()) {
            case "title":
                return new NameComparator();
            case "director":
                return new DirectorComparator();
            case "genre":
                return new GenreComparator();
            case "year":
                return new YearComparator();
            case "color":
                return new ColorComparator();
            case "length":
                return new LengthComparator();
            default:
                return new NameComparator();
        }
    }

    public static void displayMoviesSortedByChoice(String choice) {
        List<Movie> movies = loadMoviesFromFile("movies.csv");
        if (movies.isEmpty()) {
            System.out.println("No movies in the collection.");
        } else {
            Collections.sort(movies, new Comporator(choice));
            System.out.println("Movies in the collection (sorted by " + choice + "):");
            for (Movie movie : movies) {
                System.out.println(movie.toString());
            }
        }
    }

    public static void displayMovies() {
        ArrayList<Movie> movies = loadMoviesFromFile("movies.csv");
        if (movies.isEmpty()) {
            System.out.println("No movies in the collection.");
        } else {
            System.out.println("Movies in the collection:");
            for (Movie movie : movies) {
                System.out.println(movie.toString());
            }
        }
    }

    public static ArrayList<Movie> loadMoviesFromFile(String fileName) {
        ArrayList<Movie> movies = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File does not exist.");
            return movies;
        }
        try (Scanner scanner = new Scanner(file, StandardCharsets.UTF_8)) {
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split(";");
                if (parts.length >= 6) {
                    String title = parts[0];
                    String director = parts[1];
                    int yearCreated = Integer.parseInt(parts[2]);
                    boolean isInColor = Boolean.parseBoolean(parts[3]);
                    double lengthInMinutes = Double.parseDouble(parts[4]);
                    String genre = parts[5];

                    Movie movie = new Movie(title, director, yearCreated, isInColor, lengthInMinutes, genre);
                    movies.add(movie);
                } else {
                    System.out.println("Invalid data format: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    public static void addMovie(MovieCollection collection, Scanner scanner) {
        System.out.println();
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
        saveMoviesToFile();
    }

    public static void saveMoviesToFile() {
        try (PrintWriter output = new PrintWriter(new FileWriter("movies.csv", true))) {
            for (Movie movie : movies) {
                output.print(movie.getTitle() + ";");
                output.print(movie.getDirector() + ";");
                output.print(movie.getYearCreated() + ";");
                output.print((movie.isInColor() ? "yes" : "no") + ";");
                output.print(movie.getLengthInMinutes() + ";");
                output.println(movie.getGenre());
                System.out.println(movie.getTitle() + " has been saved to movies.csv");
            }
        } catch (IOException e) {
            System.err.println("Error: Failed to save movies to file.");
            e.printStackTrace();
        }
    }

    static void deleteMovie(MovieCollection collection, Scanner scanner) {
        System.out.println();
        System.out.println("Enter the title of the movie to delete: ");
        String title = scanner.nextLine();
        collection.deleteMovie(title);
        System.out.println();
    }

    static void searchMovie(MovieCollection collection, Scanner scanner) {
        System.out.println();
        System.out.println("Do you want to search by title or genre? Enter 'title' or 'genre': ");
        String searchType = scanner.nextLine().toLowerCase();

        if (searchType.equals("title")) {
            System.out.println("Enter the title (or part of) of the movie: ");
            String title = scanner.nextLine();
            String searchResult = collection.searchMovies(title).toString();
            System.out.println(searchResult);
        } else if (searchType.equals("genre")) {
            System.out.println("Enter the genre of the movies you want to search for: ");
            String genre = scanner.nextLine();
            String searchResult = collection.searchMoviesByGenre(genre).toString();
            System.out.println(searchResult);
        } else {
            System.out.println("Invalid search type. Please enter 'title' or 'genre'.");
        }
        System.out.println();
    }

    static void editMovie(MovieCollection collection, Scanner scanner) {
        System.out.println();
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