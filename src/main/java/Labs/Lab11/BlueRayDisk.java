package Labs.Lab11;

public class BlueRayDisk {
    public String title;
    public String director;
    int releaseYear;
    double cost;

    @Override
    public String toString() {
        return "$" + cost + " " + releaseYear + " " + title + ", " + director;
    }

    public BlueRayDisk(String title, String director, int releaseYear, double cost) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.cost = cost;
    }
}
