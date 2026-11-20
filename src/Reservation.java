package CinemaManagementSystem.src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Reservation {

    private final int reservationId;
    private final Customer customer;
    private final Screening screening;
    private final int seatsCount;
    private final double totalPrice;
    private final LocalDateTime reservationTime;

    public Reservation(int reservationId, Customer customer, Screening screening, int seatsCount) {

        this.reservationId = reservationId;
        this.customer = Objects.requireNonNull(customer, "Customer cannot be null");
        this.screening = Objects.requireNonNull(screening, "Screening cannot be null");
        this.seatsCount = seatsCount;
        this.totalPrice = screening.getTicketPrice() * seatsCount;
        this.reservationTime = LocalDateTime.now();
    }

    public int getReservationId() {
        return reservationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Screening getScreening() {
        return screening;
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return String.format(
                "┌─ Reservation #%d ─────────────────────────────────────────\n" +
                        "│  Customer : %s (ID: #%d)\n" +
                        "│  Movie    : %s | Room #%d\n" +
                        "│  Showtime : %s at %s\n" +
                        "│  Seats    : %d | Total Paid: $%.2f\n" +
                        "│  Booked At: %s\n" +
                        "└───────────────────────────────────────────────────────────",
                reservationId,
                customer.getName(), customer.getCustomerId(),
                screening.getMovie().getTitle(), screening.getRoomNumber(),
                screening.getDate(), screening.getStartTime().withSecond(0).withNano(0),
                seatsCount, totalPrice,
                reservationTime.format(formatter));
    }
}