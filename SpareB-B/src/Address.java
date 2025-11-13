//Address class represents a physical mailing address with comprehensive location details and provides address validation and formatting

public class Address
{
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String country;

    public Address() {}

    public Address(String street, String city, String state, String zipcode, String country)
    {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.country = country;
    }

    // Getters
    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipcode() { return zipcode; }
    public String getCountry() { return country; }

    // Setters
    public void setStreet(String street) { this.street = street; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }
    public void setCountry(String country) { this.country = country; }

    // Methods
    public String getFullAddress()
    {
        return street + ", " + city + ", " + state + " " + zipcode + ", " + country;
    }

    public void printAddress()
    {
        System.out.println("=== Address Details ===");
        System.out.println("Street: " + (street != null ? street : "Not provided"));
        System.out.println("City: " + (city != null ? city : "Not provided"));
        System.out.println("State: " + (state != null ? state : "Not provided"));
        System.out.println("Zipcode: " + (zipcode != null ? zipcode : "Not provided"));
        System.out.println("Country: " + (country != null ? country : "Not provided"));
        System.out.println("Full Address: " + getFullAddress());
    }

}
