public class Reservation {
    private Room room;
    private Guest guest;
    private String checkInDate;
    private String checkOutDate;

    public Reservation(Room room, Guest guest, String checkInDate, String checkOutDate) {
        this.room = room;
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    @Override
    public String toString() {
        return room.toString() + "\n" + guest.toString() + "\nCheck-In: " + checkInDate + " | Check-Out: " + checkOutDate;
    }
}
