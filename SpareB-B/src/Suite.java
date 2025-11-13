//Suite class represents a luxury accommodation type that extends the base Accommodation class.
 //Suites are premium accommodations with additional luxury features like multiple rooms, private amenities, and premium services not available in standard rooms.
public class Suite extends Accommodation
{
    private int livingRoomCount;
    private int diningRoomCount;
    private boolean hasPrivateBar;
    private boolean hasButlerService;
    private boolean hasPrivateEntrance;
    private String suiteCategory; //Presidential, Royal, Executive

    //Default constructor - creates an empty Suite
    public Suite()
    {
        super(); // Calling Accommodation() constructor
    }

    //Parameterized Constructor(Bouncer)
    public Suite(String roomNumber, String roomName, String location,
                 boolean isAvailable, double basePricePerNight, int livingRoomCount,
                 int diningRoomCount, boolean hasPrivateBar, boolean hasButlerService,
                 boolean hasPrivateEntrance, String suiteCategory)
    {
        // Calling parent constructor to initialize base accommodation properties
        super(roomNumber, roomName, location, isAvailable, basePricePerNight);

        this.livingRoomCount = livingRoomCount;
        this.diningRoomCount = diningRoomCount;
        this.hasPrivateBar = hasPrivateBar;
        this.hasButlerService = hasButlerService;
        this.hasPrivateEntrance = hasPrivateEntrance;
        this.suiteCategory = suiteCategory;
    }

    //Getters
    public int getLivingRoomCount() { return livingRoomCount; }
    public int getDiningRoomCount() { return diningRoomCount; }
    public boolean hasPrivateBar() { return hasPrivateBar; }
    public boolean hasButlerService() { return hasButlerService; }
    public boolean hasPrivateEntrance() { return hasPrivateEntrance; }
    public String getSuiteCategory() { return suiteCategory; }

    //Setters
    public void setLivingRoomCount(int livingRoomCount) { this.livingRoomCount = livingRoomCount; }
    public void setDiningRoomCount(int diningRoomCount) { this.diningRoomCount = diningRoomCount; }
    public void setHasPrivateBar(boolean hasPrivateBar) { this.hasPrivateBar = hasPrivateBar; }
    public void setHasButlerService(boolean hasButlerService) { this.hasButlerService = hasButlerService; }
    public void setHasPrivateEntrance(boolean hasPrivateEntrance) { this.hasPrivateEntrance = hasPrivateEntrance; }
    public void setSuiteCategory(String suiteCategory) { this.suiteCategory = suiteCategory; }

    //Methods

    //Calculates the total luxury premium for the suite based on its features
    public double calculateLuxuryPremium()
    {
        double premium = 0.0;

        // Premium for multiple rooms
        premium += livingRoomCount * 0.15; // 15% per living room
        premium += diningRoomCount * 0.10; // 10% per dining room

        // Premium for luxury features
        if (hasPrivateBar) premium += 0.20;        // 20% for private bar
        if (hasButlerService) premium += 0.30;     // 30% for butler service
        if (hasPrivateEntrance) premium += 0.15;   // 15% for private entrance

        // Premium for suite category
        switch (suiteCategory.toLowerCase()) {
            case "presidential": premium += 0.50; break; // 50% for presidential
            case "royal": premium += 0.40; break;        // 40% for royal
            case "executive": premium += 0.25; break;    // 25% for executive
        }

        return premium;
    }

    //Calculates the total price per night including luxury premiums
    public double getTotalPricePerNight()
    {
        double premium = calculateLuxuryPremium();
        return getBasePricePerNight() * (1 + premium);
    }


    @Override
    public void printDetails()
    {
        // Calling parent method to display base accommodation details
        super.printDetails();

        // Printing Suite-specific luxury details
        System.out.println("=== Suite Luxury Features ===");
        System.out.println("Living Rooms: " + livingRoomCount);
        System.out.println("Dining Rooms: " + diningRoomCount);
        System.out.println("Private Bar: " + (hasPrivateBar ? "Yes" : "No"));
        System.out.println("Butler Service: " + (hasButlerService ? "Yes" : "No"));
        System.out.println("Private Entrance: " + (hasPrivateEntrance ? "Yes" : "No"));
        System.out.println("Suite Category: " + suiteCategory);
        System.out.println("Luxury Premium: " + String.format("%.0f%%", calculateLuxuryPremium() * 100));
        System.out.println("Total Price/Night: £" + String.format("%.2f", getTotalPricePerNight()));
    }
}
