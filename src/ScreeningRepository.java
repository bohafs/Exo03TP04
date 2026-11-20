package CinemaManagementSystem.src;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScreeningRepository {

        private static final List<Screening> screenings = new ArrayList<>(List.of(
                        new Screening(1,
                                        LocalDate.of(2023, 4, 1),
                                        LocalTime.of(19, 0),
                                        new Movie("Movie1", 2023, "Director1", "Description1"),
                                        10.0,
                                        1),

                        new Screening(2,
                                        LocalDate.now(),
                                        LocalTime.now(),
                                        new Movie("Movie2", 2023, "Director2", "Description2"),
                                        15.0,
                                        1),

                        new Screening(3,
                                        LocalDate.now(),
                                        LocalTime.now(),
                                        new Movie("Movie3", 2023, "Director3", "Description3"),
                                        20.0,
                                        2),

                        new Screening(4,
                                        LocalDate.now(),
                                        LocalTime.now(),
                                        new Movie("Movie4", 2023, "Director4", "Description4"),
                                        25.0,
                                        2),

                        new Screening(5,
                                        LocalDate.now(),
                                        LocalTime.now(),
                                        new Movie("Movie5", 2023, "Director5", "Description5"),
                                        30.0,
                                        3),

                        new Screening(6,
                                        LocalDate.now(),
                                        LocalTime.now(),
                                        new Movie("Movie6", 2023, "Director6", "Description6"),
                                        35.0,
                                        3)));

        public static List<Screening> getScreenings() {
                return screenings;
        }

        public static Screening getScreeningById(int screeningId) {

                for (Screening screening : screenings) {

                        if (screening.getScreeningId() == screeningId) {
                                return screening;
                        }
                }
                return null;
        }

}