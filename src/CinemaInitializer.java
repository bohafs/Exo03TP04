package CinemaManagementSystem.src;

import java.util.List;

public class CinemaInitializer {

    private final Cinema cinema;

    public CinemaInitializer() {

        cinema = new Cinema("Cinema1", "123 Main St",
                List.of(
                        new Room(1, 100),
                        new Room(2, 150),
                        new Room(3, 200)));

        for (Room room : cinema.getRooms()) {
            for (Screening screening : ScreeningRepository.getScreenings()) {
                if (room.getRoomNumber() == screening.getRoomNumber()) {
                    room.addScreening(screening);
                }
            }
        }
    }

    public Cinema getCinema() {
        return cinema;
    }
}