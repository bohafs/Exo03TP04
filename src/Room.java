package CinemaManagementSystem.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room {

    private final int roomNumber;
    private final int seatCapacity;
    private final List<Screening> screenings;

    public Room(int roomNumber, int seatCapacity) {

        this.roomNumber = roomNumber;
        this.seatCapacity = seatCapacity;
        this.screenings = new ArrayList<>();
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public List<Screening> getScreenings() {

        return screenings;
    }

    public void addScreening(Screening screening) {

        if (screening != null && screening.getRoomNumber() == this.roomNumber) {
            screenings.add(screening);
        }
    }

    public void showRoom() {

        System.out.printf("─── Room #%d (Capacity: %d seats) ──────────────────────────\n", roomNumber, seatCapacity);

        if (screenings.isEmpty()) {

            System.out.println("│  No screenings scheduled for this room.");

        } else {

            for (int i = 0; i < screenings.size(); i++) {
                System.out.println(screenings.get(i));
                if (i < screenings.size() - 1) {
                    System.out.println("  ----------------------------------------------------------");
                }
            }
        }
        System.out.println("────────────────────────────────────────────────────────────");
    }
}