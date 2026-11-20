package CinemaManagementSystem.src;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CinemaInitializer initializer = new CinemaInitializer();
        Cinema cinema = initializer.getCinema();

        ReservationService reservationService = new ReservationService(cinema);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt(scanner, "Choose an option: ");

            switch (choice) {
                case 1 -> cinema.printCinema();

                case 2 -> showCustomers();

                case 3 -> registerNewCustomer(scanner);

                case 4 -> handleBooking(scanner, reservationService);

                case 5 -> reservationService.printAllReservations();

                case 6 -> showCustomerReservations(scanner, reservationService);

                case 0 -> {
                    running = false;
                    System.out.println("Exiting Cinema Management System.");
                }

                default -> System.out.println("Invalid option! Please choose from the menu.\n");
            }
        }

        scanner.close();
    }

    private static void printMenu() {

        System.out.println("\n================ CINEMA SYSTEM MENU ================");
        System.out.println("  1. Show Cinema, Rooms & Screenings");
        System.out.println("  2. Show All Customers");
        System.out.println("  3. Register New Customer");
        System.out.println("  4. Book a Ticket (Make Reservation)");
        System.out.println("  5. Show All Reservations");
        System.out.println("  6. Show Reservations by Customer ID");
        System.out.println("  0. Exit");
        System.out.println("====================================================");
    }

    private static void showCustomers() {

        System.out.println("\n==================== CUSTOMERS =====================");
        for (Customer customer : CustomerRepository.getCustomers()) {
            System.out.println("  " + customer);
        }
        System.out.println("====================================================");
    }

    private static void registerNewCustomer(Scanner scanner) {

        int id = readInt(scanner, "Enter new Customer ID: ");
        if (CustomerRepository.getCustomerById(id) != null) {
            System.out.println("Error: Customer ID #" + id + " already exists!");
            return;
        }

        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty!");
            return;
        }

        CustomerRepository.addCustomer(new Customer(id, name, 0));
        System.out.println("Customer '" + name + "' registered successfully!");
    }

    private static void handleBooking(Scanner scanner, ReservationService reservationService) {

        int customerId = readInt(scanner, "Enter Customer ID: ");
        int screeningId = readInt(scanner, "Enter Screening ID: ");
        int seatsCount = readInt(scanner, "Enter number of seats: ");

        Reservation reservation = reservationService.makeReservation(customerId, screeningId, seatsCount);

        if (reservation != null) {
            System.out.println("\nBooking confirmed!");
            System.out.println(reservation);
        } else
            System.out.println("\nBooking failed: ");

    }

    private static void showCustomerReservations(Scanner scanner, ReservationService reservationService) {

        int customerId = readInt(scanner, "Enter Customer ID: ");
        List<Reservation> customerReservations = reservationService.getReservationsByCustomer(customerId);

        if (customerReservations.isEmpty()) {
            System.out.println("No reservations found for Customer ID #" + customerId);
        } else {
            for (Reservation reservation : customerReservations) {
                System.out.println(reservation);
            }
        }
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }
}
