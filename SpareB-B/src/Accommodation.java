//Accommodation class is the abstract class.
import java.util.ArrayList;
import java.util.List;

//Base class
public abstract class Accommodation
{
    //Protected properties are accessible by subclasses, but other classes need getters and setters.
    protected String roomNumber;
    protected String roomName;
    protected String location;
    protected boolean isAvailable;
    protected double basePricePerNight;
    protected List<Facility> facilities;

    // Default constructor to initialize empty facilities list
    //Useful for creating objects that will be populated later via setters
    public Accommodation()
    {
        this.facilities = new ArrayList<>();
    }

    //Parameterized Constructor (without accommodationType)
    public Accommodation(String roomNumber, String roomName, String location,
                         boolean isAvailable, double basePricePerNight)
    {
        this(); //Calling Default Constructor to ensure facilities list exists.
        this.roomNumber = roomNumber;
        this.roomName = roomName;
        this.location = location;
        this.isAvailable = isAvailable;
        this.basePricePerNight = basePricePerNight;
    }

    //Getters and Setters provide controlled access to private/protected variables.
    //Getters
    public String getRoomNumber() { return roomNumber; }
    public String getRoomName() { return roomName; }
    public String getLocation() { return location; }
    public boolean isAvailable() { return isAvailable; }
    public double getBasePricePerNight() { return basePricePerNight; }
    public List<Facility> getFacilities() { return facilities; }

    //Setters
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    public void setRoomName(String roomName) { this.roomName = roomName; }
    public void setLocation(String location) { this.location = location; }
    public void setBasePricePerNight(double basePricePerNight)
    {
        if (basePricePerNight < 0)
        {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.basePricePerNight = basePricePerNight;
    }
    public void setIsAvailable(boolean available) { this.isAvailable = available; }

    //Methods
    //Checking for null before adding.
    public void addFacility(Facility facility)
    {
        if (facility != null)
        {
            facilities.add(facility);
        }
        else
        {
            System.out.println("Cannot add a null facility!");
        }
    }

    //Returns the facilities list.
    public List<Facility> listFacilities()
    {
        return facilities;
    }

    public void removeFacility(Facility facility)
    {
        facilities.remove(facility);
    }

    public double calculateTotalPrice(int numberOfNights)
    {
        if (numberOfNights < 1)
        {
            throw new IllegalArgumentException("Number of nights must be at least 1");
        }
        return basePricePerNight * numberOfNights;
    }


    public void displayFacilities()
    {
        if (facilities.isEmpty())
        {
            System.out.println("  No facilities available.");
        }
        else
        {
            System.out.println("  Facilities List:");
            for (Facility facility : facilities)
            {
                System.out.println("    - " + facility.getName() +
                        (facility.getAdditionalCost() > 0 ?
                                " (£" + facility.getAdditionalCost() + ")" : ""));
            }
        }
    }

    public void printDetails()
    {
        System.out.println("=== Accommodation Details ===");
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Name: " + roomName);
        System.out.println("Location: " + location);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("Base Price: £" + basePricePerNight + " per night");
        System.out.println("Facilities: " + facilities.size());
        displayFacilities();
    }
}