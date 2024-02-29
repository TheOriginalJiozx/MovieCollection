import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class MovieCollectionTest {

    private MovieCollection movieCollection;

    @BeforeEach
    public void setUp() {
        movieCollection = new MovieCollection();
    }

    @Test
    public void AddMovie() {
        MovieCollection.addMovie("Inception", "Christopher Nolan", 2010, true, 148, "Science Fiction");
        assertNotNull(MovieCollection.getMovieByTitle("Inception"));
    }

    @Test
    public void AddMultipleMovies() {
        MovieCollection.addMovie("The Dark Knight", "Christopher Nolan", 2008, true, 152, "Action");
        MovieCollection.addMovie("Interstellar", "Christopher Nolan", 2014, true, 169, "Science Fiction");

        List<Movie> movies = MovieCollection.movies;
        assertEquals(2, movies.size());
    }

    @Test
    public void SearchNoResult() {
        MovieCollection.addMovie("The Dark Knight", "Christopher Nolan", 2008, true, 152, "Action");
        List<Movie> searchResult = MovieCollection.searchMovies("Nonexistent Movie");
        assert searchResult != null;
        assertTrue(searchResult.isEmpty());
    }

    @Test
    public void SearchSingleResult() {
        MovieCollection.addMovie("Inception", "Christopher Nolan", 2010, true, 148, "Science Fiction");
        List<Movie> searchResult = MovieCollection.searchMovies("Inception");
        assertEquals(1, searchResult.size());
    }

    @Test
    public void SearchMultipleResults() {
        MovieCollection.addMovie("Inception", "Christopher Nolan", 2010, true, 148, "Science Fiction");
        MovieCollection.addMovie("Interstellar", "Christopher Nolan", 2014, true, 169, "Science Fiction");
        List<Movie> searchResult = MovieCollection.searchMoviesByGenre("Science Fiction");
        assertTrue(searchResult.size() > 1);
    }
}