package CinemaManagementSystem.src;

public class Customer {

    private int customerId;
    private String name;
    private int numberOfReservedScreenings;

    public Customer(int customerId, String name, int numberOfReservedScreenings) {
        this.customerId = customerId;
        this.name = name;
        this.numberOfReservedScreenings = numberOfReservedScreenings;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfReservedScreenings() {
        return numberOfReservedScreenings;
    }

    public void incrementReservedScreenings() {
        this.numberOfReservedScreenings++;
    }

    @Override
    public String toString() {
        return String.format("[Customer #%d] Name: %-15s | Reserved Screenings: %d",
                customerId, name, numberOfReservedScreenings);
    }
}
