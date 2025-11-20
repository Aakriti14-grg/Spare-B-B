//Another base class and subclass of Accommodation
//Represents a facility or amenity that can be available in an accomm

public class Facility implements Pricable
{
    protected String name;
    protected String description;
    protected boolean isAvailable;
    protected double additionalCost;
    protected String operatingHours;

   //Default constructor - creates a Facility with no initial values
    public Facility() {}

    //Parameterized Constructor(Bouncer)
    public Facility(String name, String description, boolean isAvailable,
                    double additionalCost, String operatingHours)
    {
        this.name = name;
        this.description = description;
        this.isAvailable = isAvailable;
        this.additionalCost = additionalCost;
        this.operatingHours = operatingHours;
    }

    //Getters
    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isAvailable() { return isAvailable; }
    public double getAdditionalCost() { return additionalCost; }
    public String getOperatingHours() { return operatingHours; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setAvailable(boolean available) { isAvailable = available; }
    public void setAdditionalCost(double additionalCost) { this.additionalCost = additionalCost; }
    public void setOperatingHours(String operatingHours) { this.operatingHours = operatingHours; }

    public boolean isAvailableNow()
    {
        return isAvailable;
    }

    //Calculates the total cost for using this facility
    public double calculateCost(int quantity)
    {
        return additionalCost * quantity; //Returns price * quantity.
    }

    @Override
    public double calculateCost()
    {
        return additionalCost; //Returns the single-unit price.
    }
}