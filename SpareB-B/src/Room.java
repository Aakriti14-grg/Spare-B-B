//Room class represents an accomodation unit for rent
public class Room extends Accommodation
{
    private String roomType;
    private boolean furnished;
    private boolean kitchenAvailability;
    private int numBeds;
    private String bedSize;
    private boolean hasEnsuite;
    private boolean hasWorkDesk;

    public Room()
    {
        super();
    }

    public Room(String roomNumber, String roomName, String location,
                boolean isAvailable, double basePricePerNight, String roomType, boolean furnished, boolean kitchenAvailability,
                int numBeds, String bedSize, boolean hasEnsuite, boolean hasWorkDesk) {
        super(roomNumber, roomName, location, isAvailable, basePricePerNight);
        this.roomType = roomType;
        this.furnished = furnished;
        this.kitchenAvailability = kitchenAvailability;
        this.numBeds = numBeds;
        this.bedSize = bedSize;
        this.hasEnsuite = hasEnsuite;
        this.hasWorkDesk = hasWorkDesk;
    }

    // Getters
    public String getRoomType() { return roomType; }
    public boolean isFurnished() { return furnished; }
    public boolean isKitchenAvailable() { return kitchenAvailability; }
    public int getNumBeds() { return numBeds; }
    public String getBedSize() { return bedSize; }
    public boolean hasEnsuite() { return hasEnsuite; }
    public boolean hasWorkDesk() { return hasWorkDesk; }

    // Setters
    public void setRoomType(String roomType) { this.roomType = roomType; }
    public void setFurnished(boolean furnished) { this.furnished = furnished; }
    public void setKitchenAvailability(boolean kitchenAvailability) { this.kitchenAvailability = kitchenAvailability; }
    public void setNumBeds(int numBeds) { this.numBeds = numBeds; }
    public void setBedSize(String bedSize) { this.bedSize = bedSize; }
    public void setHasEnsuite(boolean hasEnsuite) { this.hasEnsuite = hasEnsuite; }
    public void setHasWorkDesk(boolean hasWorkDesk) { this.hasWorkDesk = hasWorkDesk; }

    @Override
    public void printDetails()
    {
        super.printDetails();
        System.out.println("Room Type: " + roomType);
        System.out.println("Furnished: " + furnished);
        System.out.println("Kitchen Available: " + kitchenAvailability);
        System.out.println("Number of Beds: " + numBeds);
        System.out.println("Bed Size: " + bedSize);
        System.out.println("Has Ensuite: " + hasEnsuite);
        System.out.println("Has Work Desk: " + hasWorkDesk);
    }
}