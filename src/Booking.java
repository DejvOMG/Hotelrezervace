import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private List<Guest> guestsList;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;
    private String typeOfVacation;

    public Booking(Room room, LocalDate startDate, LocalDate endDate, String typeOfVacation) {
        this.guestsList = new ArrayList<>();
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.typeOfVacation = typeOfVacation;
    }

    public void addGuest(Guest guest) {
        guestsList.add(guest);
    }

    public int getGuestsCount() {
        return guestsList.size();
    }

    public String getTypeOfVacation() {
        return typeOfVacation;
    }

    public boolean isWorkTrip() {
        return typeOfVacation.equalsIgnoreCase("work");
    }

    public double getTotalPrice() {
        return room.getPricePerNight() * (startDate.until(endDate).getDays());
    }

    public String getFormattedSummary() {
        String seaView = room.hasSeaView() ? "ano" : "ne";
        return startDate + " až " + endDate + ": " + guestsList.get(0).getInfo() + "[" + getGuestsCount() + ", " + seaView + "] za " + (int) getTotalPrice() + " Kč";
    }

    public String getShortInfo() {
        return "Rezervace pro: " + guestsList.get(0).getInfo() + " na: " + getGuestsCount() + " termín: " + startDate + " - " + endDate + " pracovní pobyt: " + (isWorkTrip() ? "ano" : "ne");
    }
}
