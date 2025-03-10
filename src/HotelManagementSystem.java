import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelManagementSystem {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public HotelManagementSystem() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        // Add some rooms to the hotel
        rooms.add(new Room(101, 150.00));
        rooms.add(new Room(102, 200.00));
        rooms.add(new Room(103, 250.00));
        rooms.add(new Room(104, 300.00));
        rooms.add(new Room(105, 350.00));
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Hotel Management System");
            System.out.println("1. Show Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. Show Reservations");
            System.out.println("4. Release Room");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    showAvailableRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    showReservations();
                    break;
                case 4:
                    releaseRoom(scanner);
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void showAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
            }
        }
    }

    private void makeReservation(Scanner scanner) {
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter guest contact: ");
        String guestContact = scanner.nextLine();
        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        String checkInDate = scanner.nextLine();
        System.out.print("Enter check-out date (YYYY-MM-DD): ");
        String checkOutDate = scanner.nextLine();

        System.out.print("Enter room number to book: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Room room = findRoomByNumber(roomNumber);
        if (room != null && room.isAvailable()) {
            Guest guest = new Guest(guestName, guestContact);
            Reservation reservation = new Reservation(room, guest, checkInDate, checkOutDate);
            reservations.add(reservation);
            room.bookRoom();
            System.out.println("Reservation successful!");
        } else {
            System.out.println("Room not available or invalid room number.");
        }
    }

    private void showReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
                System.out.println("----------");
            }
        }
    }

    private void releaseRoom(Scanner scanner) {
        System.out.print("Enter room number to release: ");
        int roomNumber = scanner.nextInt();
        Room room = findRoomByNumber(roomNumber);
        if (room != null && !room.isAvailable()) {
            room.releaseRoom();
            System.out.println("Room released successfully.");
        } else {
            System.out.println("Room is already available or invalid room number.");
        }
    }

    private Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}
