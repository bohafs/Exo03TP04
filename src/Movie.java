package CinemaManagementSystem.src;

import java.util.Objects;

public class Movie {

    private final String title;
    private final int productionYear;
    private final String director;
    private final String description;

    public Movie(String title, int productionYear, String director, String description) {

        this.title = title;
        this.productionYear = productionYear;
        this.director = director;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public String getDirector() {
        return director;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, productionYear, director);
    }

    @Override

    public String toString() {
        return String.format("%s (%d) | Dir: %s\n      About: %s",
                title, productionYear, director, description);
    }
}