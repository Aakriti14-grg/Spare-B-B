import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Main class for the Hotel Management System

public class HotelManagementSystem
{

    public static void main(String[] args)
    {
        System.out.println("=== Welcome to Hotel Management System ===");
        System.out.println();

        // 1. Create some facilities
        System.out.println("1. Creating Facilities...");
        Facility wifi = new Facility("WiFi", "High-speed internet access", true, 20.0, "24/7");
        Facility breakfast = new Facility("Breakfast", "Continental breakfast", true, 50.0, "6:00-10:00");
        Facility parking = new Facility("Parking", "Secure parking space", true, 20.0, "24/7");
        Facility gym = new Facility("Gym", "Fully equipped fitness center", true, 25.0, "5:00-23:00");
        Facility pool = new Facility("Pool", "Heated outdoor swimming pool", true, 30.0, "7:00-21:00");
        Facility spa = new Facility("Spa", "Luxury spa and wellness center", true, 50.0, "9:00-20:00");
        Facility businessCenter = new Facility("Business Center", "Computers, printers, and meeting spaces", true, 15.0, "24/7");
        Facility laundry = new Facility("Laundry", "Laundry and dry cleaning services", true, 12.0, "8:00-20:00");

        // 2. Create accommodations
        System.out.println("2. Creating Accommodations...");

        // Standard Rooms
        Room room101 = new Room("101", "Standard Room", "First Floor", true, 100.0,
                "Double", true, false, 1, "Double", false, true);
        Room room102 = new Room("102", "Deluxe Room", "First Floor", true, 150.0,
                "Queen", true, true, 1, "Queen", true, true);
        Room room103 = new Room("103", "Superior Room", "Third Floor", false, 200.0,
                "Single", true, false, 1, "Single", true, true);
        Room room108 = new Room("108", "City View Room", "Fourth Floor", true, 220.0,
                "King", true, true, 1, "King", true, true);

        // Suites
        Suite suite201 = new Suite("201", "Executive Suite", "Second Floor", true, 300.0,
                1, 1, true, true, true, "Executive");
        Suite suite202 = new Suite("202", "Presidential Suite", "Penthouse Floor", true, 800.0,
                2, 2, true, true, true, "Presidential");
        Suite suite206 = new Suite("206", "Royal Suite", "Penthouse Floor", true, 1200.0,
                3, 2, true, true, true, "Royal");
        Suite suite203 = new Suite("203", "Honeymoon Suite", "Third Floor", false, 450.0,
                1, 1, true, true, true, "Luxury");

        // Event Spaces
        EventSpace eventSpace01 = new EventSpace("01", "The Prospect Hall", "Ground Floor", false, 2000.0,
                80, 40, "Marriage", true, true, true, true, 2, true);
        EventSpace eventSpace02 = new EventSpace("02", "Grand Ballroom", "Ground Floor", true, 3500.0,
                200, 100, "Corporate", true, true, true, true, 3, true);
        EventSpace eventSpace05 = new EventSpace("05", "Garden Pavilion", "Outdoor", true, 1500.0,
                60, 30, "Wedding", true, false, true, true, 2, false);
        EventSpace eventSpace07 = new EventSpace("07", "The Terrace", "Rooftop", false, 1800.0,
                50, 25, "Reception", true, false, true, true, 1, false);

        // 3. Add facilities to accommodations
        System.out.println("3. Adding Facilities to Rooms...");
        room101.addFacility(wifi);
        room101.addFacility(breakfast);

        room102.addFacility(wifi);
        room102.addFacility(breakfast);
        room102.addFacility(parking);

        suite201.addFacility(wifi);
        suite201.addFacility(breakfast);
        suite201.addFacility(parking);
        suite201.addFacility(spa);

        suite202.addFacility(wifi);
        suite202.addFacility(breakfast);
        suite202.addFacility(parking);
        suite202.addFacility(spa);
        suite202.addFacility(gym);
        suite202.addFacility(pool);

        eventSpace01.addFacility(wifi);
        eventSpace01.addFacility(businessCenter);
        eventSpace01.addFacility(parking);

        eventSpace02.addFacility(wifi);
        eventSpace02.addFacility(businessCenter);
        eventSpace02.addFacility(parking);
        eventSpace02.addFacility(laundry);

        // 4. Create guests
        System.out.println("4. Creating Guests...");
        Address address1 = new Address("123 Main St", "London", "England", "SW1A 1AA", "UK");
        Address address2 = new Address("456 Oak Ave", "Manchester", "England", "M1 1AB", "UK");
        Address address3 = new Address("789 Pine Rd", "Birmingham", "England", "B1 1TT", "UK");
        Address address4 = new Address("321 Elm St", "Liverpool", "England", "L1 0RN", "UK");
        Address address5 = new Address("654 Maple Dr", "Glasgow", "Scotland", "G1 1AA", "UK");

        Guest guest1 = new Guest("GUEST1", "Sujita Gurung", "gurungsuj99@email.com", "7743222837",
                address1, LocalDate.now());
        Guest guest2 = new Guest("GUEST2", "Sohan Giri", "sohan14@email.com", "7918064106",
                address2, LocalDate.now().minusDays(30));
        Guest guest3 = new Guest("GUEST3", "Pawan Shrestha", "pawansth2055@email.com", "7570734773",
                address3, LocalDate.now().minusDays(15));
        Guest guest4 = new Guest("GUEST4", "Rupak Raut", "rupakraut99@email.com", "7756866528",
                address4, LocalDate.now().minusDays(7));
        Guest guest5 = new Guest("GUEST5", "Salina Gurung", "salinagrg77@email.com", "7570734817",
                address5, LocalDate.now().minusDays(45));

        // 5. Create Bookings
        System.out.println("5. Creating Bookings...");
        // Declare variables FIRST
        Booking booking1 = null;
        Booking booking2 = null;
        Booking booking3 = null;

        // Create list AFTER bookings exist
        List<Booking> allBookings = new ArrayList<>();

        LocalDate checkIn1 = LocalDate.now().plusDays(7);
        LocalDate checkOut1 = LocalDate.now().plusDays(10);
        booking1 = new Booking("B00K1", guest1, room101, checkIn1, checkOut1, 2);
        allBookings.add(booking1);

        LocalDate checkIn2 = LocalDate.now().plusDays(3);
        LocalDate checkOut2 = LocalDate.now().plusDays(5);
        booking2 = new Booking("B00K2", guest2, suite201, checkIn2, checkOut2, 2);
        allBookings.add(booking2);

        LocalDate checkIn3 = LocalDate.now().plusDays(14);
        LocalDate checkOut3 = LocalDate.now().plusDays(15);
        booking3 = new Booking("B00K3", guest3, eventSpace02, checkIn3, checkOut3, 100);
        allBookings.add(booking3);


        // 6. Create Special Requests
        System.out.println("6. Creating Special Requests...");
        SpecialRequest request1 = new SpecialRequest("SR001", "Food", "Vegetarian meals required");
        request1.setAdditionalCost(15.0);
        request1.approveRequest();

        SpecialRequest request2 = new SpecialRequest("SR002", "Service", "Late checkout at 2 PM");
        request2.setAdditionalCost(25.0);
        request2.approveRequest();

        SpecialRequest request3 = new SpecialRequest("SR003", "Event", "Additional microphone and speakers");
        request3.setAdditionalCost(50.0);
        request3.approveRequest();

        //Attach requests to bookings
        booking1.addSpecialRequest(request1);
        booking2.addSpecialRequest(request2);
        booking3.addSpecialRequest(request3);

        // 7. Create Payments
        System.out.println("7. Creating Payments...");
        Payment payment1 = new Payment("P001", booking1, "CREDIT_CARD");
        Payment payment2 = new Payment("P002", booking2, "DEBIT_CARD");
        Payment payment3 = new Payment("P003", booking3, "CREDIT_CARD");

        // 8. Create Reviews
        System.out.println("8. Creating Reviews...");
        Review review1 = new Review("Excellent Stay!", "The room was clean and staff was very helpful.",
                LocalDate.now().minusDays(5), true);
        Review review2 = new Review("Perfect Wedding Venue", "The event space was beautiful and the staff made our day special.",
                LocalDate.now().minusDays(10), true);
        Review review3 = new Review("Good but could be better", "The suite was nice but the WiFi was slow.",
                LocalDate.now().minusDays(2), true);

        // 9. Display all information
        System.out.println();
        System.out.println("=== SYSTEM OVERVIEW ===");

        System.out.println("\n--- ACCOMMODATIONS ---");
        System.out.println("=== ROOMS ===");
        room101.printDetails();
        System.out.println();
        room102.printDetails();
        System.out.println();
        room108.printDetails();
        System.out.println();

        System.out.println("=== SUITES ===");
        suite201.printDetails();
        System.out.println();
        suite202.printDetails();
        System.out.println();
        suite206.printDetails();
        System.out.println();

        System.out.println("=== EVENT SPACES ===");
        eventSpace01.printDetails();
        System.out.println();
        eventSpace02.printDetails();
        System.out.println();
        eventSpace05.printDetails();

        System.out.println("\n--- GUESTS ---");
        guest1.printDetails();
        System.out.println();
        guest2.printDetails();
        System.out.println();
        guest5.printDetails();

        System.out.println("\n--- BOOKINGS ---");
        booking1.printBookingDetails();
        System.out.println();
        booking2.printBookingDetails();
        System.out.println();
        booking3.printBookingDetails();

        System.out.println("\n--- SPECIAL REQUESTS ---");
        System.out.println("Request 1: " + request1.getDescription() + " | Status: " + request1.getStatus() + " | Cost: £" + request1.getAdditionalCost());
        System.out.println("Request 2: " + request2.getDescription() + " | Status: " + request2.getStatus() + " | Cost: £" + request2.getAdditionalCost());
        System.out.println("Request 3: " + request3.getDescription() + " | Status: " + request3.getStatus() + " | Cost: £" + request3.getAdditionalCost());

        System.out.println("\n--- PAYMENTS ---");
        System.out.println("Payment 1: " + payment1.getPaymentDetails());
        System.out.println("Payment 2: " + payment2.getPaymentDetails());
        System.out.println("Payment 3: " + payment3.getPaymentDetails());

        System.out.println("\n--- REVIEWS ---");
        review1.printDetails();
        System.out.println();
        review2.printDetails();
        System.out.println();
        review3.printDetails();

        System.out.println("\n--- FACILITIES ---");
        System.out.println("WiFi: £" + wifi.getAdditionalCost() + " - " + wifi.getDescription());
        System.out.println("Breakfast: £" + breakfast.getAdditionalCost() + " - " + breakfast.getDescription());
        System.out.println("Parking: £" + parking.getAdditionalCost() + " - " + parking.getDescription());
        System.out.println("Gym: £" + gym.getAdditionalCost() + " - " + gym.getDescription());
        System.out.println("Pool: £" + pool.getAdditionalCost() + " - " + pool.getDescription());
        System.out.println("Spa: £" + spa.getAdditionalCost() + " - " + spa.getDescription());
        System.out.println("Business Center: £" + businessCenter.getAdditionalCost() + " - " + businessCenter.getDescription());
        System.out.println("Laundry: £" + laundry.getAdditionalCost() + " - " + laundry.getDescription());


        // Test room availability
        System.out.println("\n=== AVAILABILITY STATUS ===");
        LocalDate today = LocalDate.now();

        System.out.println("Room 101 Available (Date Logic): " + room101.isAvailableBasedOnDate(today, allBookings));
        System.out.println("Room 102 Available (Date Logic): " + room102.isAvailableBasedOnDate(today, allBookings));
        System.out.println("Room 103 Available (Date Logic): " + room103.isAvailableBasedOnDate(today, allBookings));
        System.out.println("Room 108 Available (Date Logic): " + room108.isAvailableBasedOnDate(today, allBookings));

        System.out.println("Suite 201 Available (Date Logic): " + suite201.isAvailableBasedOnDate(today, allBookings));
        System.out.println("Suite 202 Available (Date Logic): " + suite202.isAvailableBasedOnDate(today, allBookings));
        System.out.println("Suite 206 Available (Date Logic): " + suite206.isAvailableBasedOnDate(today, allBookings));
        System.out.println("Suite 203 Available (Date Logic): " + suite203.isAvailableBasedOnDate(today, allBookings));

        System.out.println("EventSpace 01 Available (Date Logic): " + eventSpace01.isAvailableBasedOnDate(today, allBookings));
        System.out.println("EventSpace 02 Available (Date Logic): " + eventSpace02.isAvailableBasedOnDate(today, allBookings));
        System.out.println("EventSpace 05 Available (Date Logic): " + eventSpace05.isAvailableBasedOnDate(today, allBookings));
        System.out.println("EventSpace 07 Available (Date Logic): " + eventSpace07.isAvailableBasedOnDate(today, allBookings));

        LocalDate start = LocalDate.now().plusDays(11);
        LocalDate end = LocalDate.now().plusDays(12);

        boolean canBookRoom101 = room101.isAvailableDuringRange(start, end, allBookings);
        System.out.println("Room101 available for new booking: " + canBookRoom101);

        // Test payment status
        System.out.println("\n=== PAYMENT STATUS ===");
        System.out.println("Payment 1 Status: " + payment1.getStatus());
        System.out.println("Payment 2 Status: " + payment2.getStatus());
        System.out.println("Payment 3 Status: " + payment3.getStatus());

        // Test refund functionality
        System.out.println("\n=== REFUND TEST ===");
        if (payment1.isRefundable())
        {
            System.out.println("Payment 1 is refundable");
            payment1.refundPayment(100.0);
            System.out.println("After refund - Payment 1 Status: " + payment1.getStatus());
        }

        // Display summary statistics
        System.out.println("\n=== HOTEL SUMMARY ===");
        System.out.println("Total Rooms: 4");
        System.out.println("Total Suites: 4");
        System.out.println("Total Event Spaces: 4");
        System.out.println("Total Guests: 5");
        System.out.println("Total Bookings: 3");
        System.out.println("Total Payments: 3");
        System.out.println("Total Reviews: 3");
        System.out.println("Total Special Requests: 3");

        System.out.println();
        System.out.println("=== Hotel Management System Demo Complete ===");
    }
}