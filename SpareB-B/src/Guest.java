//Guest class represents a customer or guest who can book accommodations
//This class works with the Address class to store complete guest information.

import java.time.LocalDate;

public class Guest
{
    private String userId;
    private String name;
    private String email;
    private String phone;
    private Address address;
    private LocalDate registrationDate;

    //Default constructor
    //Useful for creating guest objects that will be populated later via setters

    public Guest() {}

    //Parameterized Constructor(Bouncer)
    public Guest(String userId, String name, String email, String phone,
                 Address address, LocalDate registrationDate)
    {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.registrationDate = registrationDate;
    }

    // Getters
    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public Address getAddress() { return address; }
    public LocalDate getRegistrationDate() { return registrationDate; }

    // Setters
    public void setUserId(String userId) { this.userId = userId; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setAddress(Address address) { this.address = address; }
    public void setRegistrationDate(LocalDate registrationDate) { this.registrationDate = registrationDate; }

    //Methods
    public boolean isValidEmail()
    {
        return email != null && email.contains("@") && email.contains(".");
    }

    public boolean isValidPhone()
    {
        return phone != null && phone.matches("^[+]?[0-9\\s-()]{10,}$");
    }

    public void printDetails()
    {
        System.out.println("Guest ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Registration Date: " + registrationDate);
        if (address != null)
        {
            System.out.println("Address: " + address.getFullAddress());
        }
        else
        {
            System.out.println("Address: Not provided");
        }
    }
}
