import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingManager {
    private List<Booking> bookings = new ArrayList<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public long getNumberOfWorkingBookings() {
        return bookings.stream().filter(Booking::isWorkTrip).count();
    }

    public double getAverageGuests() {
        return bookings.stream().mapToInt(Booking::getGuestsCount).average().orElse(0);
    }

    public List<Booking> getTopNHolidayBookings(int n) {
        return bookings.stream()
                .filter(b -> !b.isWorkTrip())
                .limit(n)
                .collect(Collectors.toList());
    }

    public void printGuestStatistics() {
        long oneGuest = bookings.stream().filter(b -> b.getGuestsCount() == 1).count();
        long twoGuests = bookings.stream().filter(b -> b.getGuestsCount() == 2).count();
        long moreGuests = bookings.stream().filter(b -> b.getGuestsCount() > 2).count();

        System.out.println("Počet rezervací s jedním hostem: " + oneGuest);
        System.out.println("Počet rezervací se dvěma hosty: " + twoGuests);
        System.out.println("Počet rezervací s více hosty: " + moreGuests);
    }

    public void printAllBookings() {
        bookings.forEach(b -> System.out.println(b.getFormattedSummary()));
    }
}
