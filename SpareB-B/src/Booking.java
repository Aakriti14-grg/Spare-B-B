import java.time.LocalDate;
//ChronoUnit is an enumeration (enum) inside the java.time package.
//It works together with LocalDate, LocalDateTime, etc.
import java.time.temporal.ChronoUnit;

public class Booking
{
    private String bookingId;
    private Guest guest;
    private Accommodation accommodation;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfGuests;
    private String status;

    public Booking(String bookingId, Guest guest, Accommodation accommodation,
                   LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests) {
        this.bookingId = bookingId;
        this.guest = guest;
        this.accommodation = accommodation;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfGuests = numberOfGuests;
        this.status = "CONFIRMED";

        // Mark accommodation as unavailable
        accommodation.setIsAvailable(false);
    }

    // Getters
    public String getBookingId() { return bookingId; }
    public Guest getGuest() { return guest; }
    public Accommodation getAccommodation() { return accommodation; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public LocalDate getCheckOutDate() { return checkOutDate; }
    public int getNumberOfGuests() { return numberOfGuests; }
    public String getStatus() { return status; }

    //Setters
    public void setStatus(String status) { this.status = status; }

    // Business methods
    public long getNumberOfNights()
    {
        return ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }

    public double calculateTotalPrice()
    {
        long nights = getNumberOfNights();
        return accommodation.getBasePricePerNight() * nights;
    }

    public void printBookingDetails()
    {
        System.out.println("=== Booking Details ===");
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Guest: " + guest.getName());
        System.out.println("Accommodation: " + accommodation.getRoomNumber() + " - " + accommodation.getRoomName());
        System.out.println("Check-in: " + checkInDate);
        System.out.println("Check-out: " + checkOutDate);
        System.out.println("Nights: " + getNumberOfNights());
        System.out.println("Total Price: £" + calculateTotalPrice());
        System.out.println("Status: " + status);
    }
}