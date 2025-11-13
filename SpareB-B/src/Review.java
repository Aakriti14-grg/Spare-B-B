//Review class represents a customer review or feedback for an accommodation stay.
import java.time.LocalDate;

public class Review
{
    private String title;
    private String comment;
    private LocalDate stayDate;
    private boolean verifiedStay;

    //Default Constructor
    public Review() {}

    //Parametarized constructor
    public Review(String title, String comment, LocalDate stayDate, boolean verifiedStay)
    {
        this.title = title;
        this.comment = comment;
        this.stayDate = stayDate;
        this.verifiedStay = verifiedStay;
    }

    // Getters
    public String getTitle() { return title; }
    public String getComment() { return comment; }
    public LocalDate getStayDate() { return stayDate; }
    public boolean isVerifiedStay() { return verifiedStay; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setComment(String comment) { this.comment = comment; }
    public void setStayDate(LocalDate stayDate) { this.stayDate = stayDate; }
    public void setVerifiedStay(boolean verifiedStay) { this.verifiedStay = verifiedStay; }

    //Method
    public boolean isRecent()
    {
        if (stayDate == null) return false;
        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        return stayDate.isAfter(thirtyDaysAgo) || stayDate.isEqual(thirtyDaysAgo);
    }

    public void printDetails()
    {
        System.out.println("Title: " + title);
        System.out.println("Comment: " + comment);
        System.out.println("Stay Date: " + stayDate);
        System.out.println("Verified Stay: " + verifiedStay);
        System.out.println("Recent Review: " + (isRecent() ? "Yes" : "No"));
    }
}