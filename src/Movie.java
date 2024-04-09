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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYearCreated() {
        return this.yearCreated;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public boolean isInColor() {
        return isInColor;
    }

    public void setIsInColor(boolean isInColor) {
        this.isInColor = isInColor;
    }

    public double getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(double lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", yearCreated=" + yearCreated +
                ", isInColor=" + isInColor +
                ", lengthInMinutes=" + lengthInMinutes +
                ", genre='" + genre + '\'' +
                '}';
    }
}