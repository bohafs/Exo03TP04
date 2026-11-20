package CinemaManagementSystem.src;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Screening {

    private int numberOfReservedSeats;

    private final int screeningId;
    private final LocalDate date;
    private final LocalTime startTime;
    private final Movie movie;
    private final double ticketPrice;
    private final int roomNumber;

    public Screening(int screeningId, LocalDate date, LocalTime startTime, Movie movie, double ticketPrice,
            int roomNumber) {

        this.screeningId = screeningId;
        this.date = Objects.requireNonNull(date, "Date cannot be null");
        this.startTime = Objects.requireNonNull(startTime, "Start time cannot be null");
        this.movie = Objects.requireNonNull(movie, "Movie cannot be null");
        this.ticketPrice = ticketPrice;
        this.roomNumber = roomNumber;
        this.numberOfReservedSeats = 0;
    }

    public void UpdateNumberOfReservedeserveSeats(int count) {
        if (count > 0) {
            this.numberOfReservedSeats += count;
        }
    }

    public int getScreeningId() {
        return screeningId;
    }

    public int getNumberOfReservedSeats() {
        return numberOfReservedSeats;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "  [Screening #%d] Date: %s | Time: %s | Price: $%.2f | Reserved: %d\n" +
                        "    Movie: %s",
                screeningId,
                date,
                startTime.withSecond(0).withNano(0),
                ticketPrice,
                numberOfReservedSeats,
                movie);
    }
}