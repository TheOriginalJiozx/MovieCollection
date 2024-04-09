import java.util.Comparator;

public class NameComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie d1, Movie d2) {
        String title1 = d1.getTitle();
        String title2 = d2.getTitle();
        return title1.compareTo(title2);
    }
}