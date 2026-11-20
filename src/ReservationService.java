package CinemaManagementSystem.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReservationService {

    private final Cinema cinema;
    private final List<Reservation> reservations;
    private int nextReservationId;

    public ReservationService(Cinema cinema) {

        this.cinema = cinema;
        this.reservations = new ArrayList<>();
        this.nextReservationId = 1;
    }

    public Reservation makeReservation(int customerId, int screeningId, int seatsCount) {

        Customer customer = CustomerRepository.getCustomerById(customerId);

        if (customer == null) {
            System.out.println("Customer not found with ID: " + customerId);
            return null;
        }

        Screening screening = ScreeningRepository.getScreeningById(screeningId);
        if (screening == null) {
            System.out.println("Screening not found with ID: " + screeningId);
            return null;
        }

        Room room = findRoomByNumber(screening.getRoomNumber());
        if (room == null) {
            System.out.println("Room #" + screening.getRoomNumber() + " not found in this cinema.");
            return null;
        }

        int availableSeats = room.getSeatCapacity() - screening.getNumberOfReservedSeats();
        if (seatsCount > availableSeats) {
            System.out.println(
                    "No available seats ! Requested: " + seatsCount + ", Available: " + availableSeats);

            return null;
        }

        screening.UpdateNumberOfReservedeserveSeats(seatsCount);
        customer.incrementReservedScreenings();

        Reservation reservation = new Reservation(nextReservationId++, customer, screening, seatsCount);
        reservations.add(reservation);
        return reservation;
    }

    private Room findRoomByNumber(int roomNumber) {

        for (Room room : cinema.getRooms()) {

            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }

    public List<Reservation> getReservationsByCustomer(int customerId) {

        List<Reservation> result = new ArrayList<>();

        for (Reservation r : reservations) {

            if (r.getCustomer().getCustomerId() == customerId) {
                result.add(r);
            }
        }
        return result;
    }

    public void printAllReservations() {

        System.out.println("==================== ALL RESERVATIONS ======================");

        if (reservations.isEmpty()) {
            System.out.println("  \nNo reservations found.");

        } else {

            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }
}
