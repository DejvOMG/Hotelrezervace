public class Room {
    private int roomNumber;
    private double pricePerNight;
    private boolean hasSeaView;

    public Room(int roomNumber, double pricePerNight, boolean hasSeaView) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.hasSeaView = hasSeaView;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean hasSeaView() {
        return hasSeaView;
    }
}
