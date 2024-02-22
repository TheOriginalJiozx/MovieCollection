public class Movie {
    String title;
    String director;
    int yearCreated;
    boolean isInColor;
    double lengthInMinutes;
    String genre;

    public Movie(String title, String director, int yearCreated, boolean isInColor, double lengthInMinutes, String genre) {
        this.title = title;
        this.director = director;
        this.yearCreated = yearCreated;
        this.isInColor = isInColor;
        this.lengthInMinutes = lengthInMinutes;
        this.genre = genre;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDirector() {
        return this.director;
    }

    public int getYearCreated() {
        return this.yearCreated;
    }

    public boolean isInColor() {
        return isInColor;
    }

    public double getLengthInMinutes() {
        return lengthInMinutes;
    }

    public String getGenre() {
        return genre;
    }
}