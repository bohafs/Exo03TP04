package CinemaManagementSystem.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerRepository {

    private static final List<Customer> customers = new ArrayList<>(List.of(
            new Customer(1, "Ahmed Benali", 2),
            new Customer(2, "Sara Mansouri", 0),
            new Customer(3, "Yacine Khelifi", 5),
            new Customer(4, "Lina Bouzid", 1)));

    public static List<Customer> getCustomers() {

        return customers;
    }

    public static Customer getCustomerById(int customerId) {

        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    public static void addCustomer(Customer customer) {

        if (customer != null && getCustomerById(customer.getCustomerId()) == null) {
            customers.add(customer);
        }
    }

    public static boolean removeCustomer(int customerId) {

        Customer customer = getCustomerById(customerId);

        if (customer != null) {
            return customers.remove(customer);
        }
        return false;
    }
}
