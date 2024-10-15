import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BookingManager bookingManager = new BookingManager();


        Guest guest1 = new Guest("Karel Dvořák", "1990-05-15");
        Guest guest2 = new Guest("Karel Dvořák", "1979-01-03");
        Guest guest3 = new Guest("Karolína Tmavá", "2000-11-23");


        Room room1 = new Room(2, 1000, false);
        Room room2 = new Room(3, 2400, true);


        Booking booking1 = new Booking(room2, LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 7), "work");
        booking1.addGuest(guest1);
        bookingManager.addBooking(booking1);

        Booking booking2 = new Booking(room1, LocalDate.of(2023, 7, 18), LocalDate.of(2023, 7, 21), "holiday");
        booking2.addGuest(guest2);
        bookingManager.addBooking(booking2);

        Booking booking3 = new Booking(room2, LocalDate.of(2023, 8, 1), LocalDate.of(2023, 8, 31), "work");
        booking3.addGuest(guest3);
        booking3.addGuest(guest1); // Pár
        bookingManager.addBooking(booking3);


        LocalDate startDate = LocalDate.of(2023, 8, 1);
        for (int i = 0; i < 10; i++) {
            LocalDate endDate = startDate.plusDays(1);
            Booking booking = new Booking(room1, startDate, endDate, "holiday");
            booking.addGuest(guest3);
            bookingManager.addBooking(booking);
            startDate = startDate.plusDays(2);
        }

        System.out.println("Počet pracovních pobytů: " + bookingManager.getNumberOfWorkingBookings());
        System.out.println("Průměrný počet hostů na rezervaci: " + bookingManager.getAverageGuests());

        System.out.println("\nPrvních osm rekreačních rezervací:");
        bookingManager.getTopNHolidayBookings(8).forEach(b -> System.out.println(b.getShortInfo()));

        System.out.println("\nStatistiky hostů:");
        bookingManager.printGuestStatistics();

        System.out.println("\nFormátovaný výpis všech rezervací v systému:");
        bookingManager.printAllBookings();
    }
}
