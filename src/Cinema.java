package CinemaManagementSystem.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cinema {

    private final String name;
    private final String address;
    private final List<Room> rooms;

    public Cinema(String name, String address, List<Room> rooms) {
        this.name = name;
        this.address = address;
        this.rooms = new ArrayList<>(rooms);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Room> getRooms() {
        return Collections.unmodifiableList(rooms);
    }

    public void printCinema() {

        System.out.println("============================================================");
        System.out.println("                 CINEMA MANAGEMENT SYSTEM                   ");
        System.out.println("============================================================");
        System.out.printf("  Cinema  : %s\n", name);
        System.out.printf("  Address : %s\n", address);
        System.out.println("============================================================\n");

        for (Room room : rooms) {
            room.showRoom();
            System.out.println();
        }
    }
}