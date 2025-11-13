//EventSpace class represents a specialized accommodation designed for events, conferences,weddings, and other large gatherings.

 public class EventSpace extends Accommodation
 {
    private int capacityStanding;
    private int capacitySeated;
    private String eventType;
    private boolean hasStage;
    private boolean hasAudiovisualEquipment;
    private boolean hasCateringKitchen;
    private boolean hasDanceFloor;
    private int numberOfBreakoutRooms;
    private boolean outDoorAccess;

    //Default constructor - creates empty EventSpace
    public EventSpace()
    {
        super();
    }

    //Parameterized Constructor(Bouncer)
    public EventSpace(String roomNumber, String roomName, String location,
                      boolean isAvailable, double basePricePerNight, int capacityStanding,
                      int capacitySeated, String eventType, boolean hasStage,
                      boolean hasAudiovisualEquipment, boolean hasCateringKitchen,
                      boolean hasDanceFloor, int numberOfBreakoutRooms, boolean outDoorAccess)
    {
        super(roomNumber, roomName, location, isAvailable, basePricePerNight);

        this.capacityStanding = capacityStanding;
        this.capacitySeated = capacitySeated;
        this.eventType = eventType;
        this.hasStage = hasStage;
        this.hasAudiovisualEquipment = hasAudiovisualEquipment;
        this.hasCateringKitchen = hasCateringKitchen;
        this.hasDanceFloor = hasDanceFloor;
        this.numberOfBreakoutRooms = numberOfBreakoutRooms;
        this.outDoorAccess = outDoorAccess;
    }

    // Getters
    public int getCapacityStanding() { return capacityStanding; }
    public int getCapacitySeated() { return capacitySeated; }
    public String getEventType() { return eventType; }
    public boolean hasStage() { return hasStage; }
    public boolean hasAudioVisualEquipment() { return hasAudiovisualEquipment; }
    public boolean hasCateringKitchen() { return hasCateringKitchen; }
    public boolean hasDanceFloor() { return hasDanceFloor; }
    public int getNumberOfBreakoutRooms() { return numberOfBreakoutRooms; }
    public boolean hasOutDoorAccess() { return outDoorAccess; }

    // Setters
    public void setCapacityStanding(int capacityStanding) { this.capacityStanding = capacityStanding; }
    public void setCapacitySeated(int capacitySeated) { this.capacitySeated = capacitySeated; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public void setHasStage(boolean hasStage) { this.hasStage = hasStage; }
    public void setHasAudiovisualEquipment(boolean hasAudiovisualEquipment) { this.hasAudiovisualEquipment = hasAudiovisualEquipment; }
    public void setHasCateringKitchen(boolean hasCateringKitchen) { this.hasCateringKitchen = hasCateringKitchen; }
    public void setHasDanceFloor(boolean hasDanceFloor) { this.hasDanceFloor = hasDanceFloor; }
    public void setNumberOfBreakoutRooms(int numberOfBreakoutRooms) { this.numberOfBreakoutRooms = numberOfBreakoutRooms; }
    public void setOutDoorAccess(boolean outDoorAccess) { this.outDoorAccess = outDoorAccess; }


     //Calculating event pricing based on capacity and features
     public double calculateEventPrice()
     {
         double price = getBasePricePerNight();

         price += capacitySeated * 2.0;  // £2 per seated capacity
         price += capacityStanding * 1.0; // £1 per standing capacity

         if (hasStage) price += 200.0;
         if (hasAudiovisualEquipment) price += 150.0;
         if (hasCateringKitchen) price += 300.0;
         if (hasDanceFloor) price += 100.0;
         if (outDoorAccess) price += 250.0;
         price += numberOfBreakoutRooms * 75.0;

         return price;
     }

     //Overriding the printDetails method from Accommodation class
    @Override
    public void printDetails() {
        super.printDetails();

        System.out.println("Capacity Standing: " + capacityStanding);
        System.out.println("Capacity Seated: " + capacitySeated);
        System.out.println("Event Type: " + eventType);
        System.out.println("Has Stage: " + hasStage);
        System.out.println("A/V Equipment: " + hasAudiovisualEquipment);
        System.out.println("Catering Kitchen: " + hasCateringKitchen);
        System.out.println("Dance Floor: " + hasDanceFloor);
        System.out.println("Breakout Rooms: " + numberOfBreakoutRooms);
        System.out.println("Outdoor Access: " + outDoorAccess);
    }
}