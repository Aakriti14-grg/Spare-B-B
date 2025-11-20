import java.time.LocalDate;
//CronoUnit is an enumeration (enum) inside the java.time package.
//It works together with LocalDate, LocalDateTime,etc.
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Booking implements Pricable
{
    private String bookingId;
    private Guest guest;
    private Accommodation accommodation;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfGuests;
    private int numberOfRooms;
    private String status;

    //Creates an empty list to hold SpecialRequest
    //Adds a real SpecialRequest to the list
    //Creates a SpecialRequest object
    private List<SpecialRequest> specialRequests = new ArrayList<>(); // NEW

    public Booking(String bookingId, Guest guest, Accommodation accommodation,
                   LocalDate checkInDate, LocalDate checkOutDate,
                   int numberOfGuests)
    {
        this.bookingId = bookingId;
        this.guest = guest;
        this.accommodation = accommodation;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfGuests = numberOfGuests;

        this.numberOfRooms = 1;
        this.status = "CONFIRMED";
    }


   //Allows user to set number of rooms
    public void setNumberOfRooms(int rooms)
    {
        this.numberOfRooms = rooms;
    }

    public void addSpecialRequest(SpecialRequest request)
    {
        specialRequests.add(request);
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

    public long getNumberOfNights()
    {
        return ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }

    //Total Price
    public double calculateTotalPrice()
    {
        long nights = getNumberOfNights();
        double basePrice = accommodation.getBasePricePerNight();

        //Room base cost
        double roomCost = nights * basePrice * numberOfRooms;

        // Facility cost
        double facilityCost = 0;
        for (Facility f : accommodation.getFacilities()) {
            if (f.isAvailableNow())
                facilityCost += f.getAdditionalCost();
        }

        // Special request cost
        double specialCost = 0;
        for (SpecialRequest req : specialRequests) {
            specialCost += req.getAdditionalCost();
        }

        return roomCost + facilityCost + specialCost;
    }

    public boolean isCurrentlyActive() {
        LocalDate today = LocalDate.now();

        return (today.equals(checkInDate) ||
                today.equals(checkOutDate) ||
                (today.isAfter(checkInDate) && today.isBefore(checkOutDate)));
    }


    public void printBookingDetails()
    {
        System.out.println("=== Booking Details ===");
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Guest: " + guest.getName());
        System.out.println("Accommodation: " + accommodation.getRoomNumber()
                + " - " + accommodation.getRoomName());
        System.out.println("Check-in: " + checkInDate);
        System.out.println("Check-out: " + checkOutDate);
        System.out.println("Nights: " + getNumberOfNights());
        System.out.println("Total Price: £" + calculateTotalPrice());
        System.out.println("Currently Active: " + isCurrentlyActive());
        System.out.println("Status: " + status);
    }

    @Override
    public double calculateCost() {
        return calculateTotalPrice();
    }
}
