import java.util.Comparator;

public class NameComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie d1, Movie d2) {
        String region1 = d1.getTitle();
        String region2 = d2.getTitle();
        return region1.compareTo(region2);
    }
}