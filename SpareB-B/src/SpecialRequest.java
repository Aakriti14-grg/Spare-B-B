//SpecialRequest class represents additional guest requests or services beyond standard accommodation.
import java.time.LocalDateTime;

public class SpecialRequest implements Pricable {
    private String requestId;
    private String category;
    private String description;
    private String status; // PENDING, APPROVED, REJECTED, COMPLETED
    private double additionalCost;
    private String assignedStaff;
    private LocalDateTime requestDate;
    private LocalDateTime completeDate;
    private String notes;

    //Default Constructor
    public SpecialRequest() {}

    //Parametarized Constructor
    public SpecialRequest(String requestId, String category, String description)
    {
        this.requestId = requestId;
        this.category = category;
        this.description = description;
        this.status = "PENDING";
        this.requestDate = LocalDateTime.now();
    }

    // Getters
    public String getRequestId() { return requestId; }
    public String getCategory() { return category; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
    public double getAdditionalCost() { return additionalCost; }
    public String getAssignedStaff() { return assignedStaff; }
    public LocalDateTime getRequestDate() { return requestDate; }
    public LocalDateTime getCompleteDate() { return completeDate; }
    public String getNotes() { return notes; }

    // Setters
    public void setRequestId(String requestId) { this.requestId = requestId; }
    public void setCategory(String category) { this.category = category; }
    public void setDescription(String description) { this.description = description; }
    public void setStatus(String status)
    {
        // Validate status value
        if (isValidStatus(status)) {
            this.status = status.toUpperCase();
        } else {
            throw new IllegalArgumentException("Invalid status: " + status);
        }
    }
    public void setAdditionalCost(double additionalCost)
    {
        if (additionalCost < 0) {
            throw new IllegalArgumentException("Additional cost cannot be negative");
        }
        this.additionalCost = additionalCost;
    }
    public void setAssignedStaff(String assignedStaff) { this.assignedStaff = assignedStaff; }
    public void setRequestDate(LocalDateTime requestDate) { this.requestDate = requestDate; }
    public void setCompleteDate(LocalDateTime completeDate) { this.completeDate = completeDate; }
    public void setNotes(String notes) { this.notes = notes; }

    // Helper method to validate status
    private boolean isValidStatus(String status) {
        String upperStatus = status.toUpperCase();
        return upperStatus.equals("PENDING") ||
                upperStatus.equals("APPROVED") ||
                upperStatus.equals("REJECTED") ||
                upperStatus.equals("COMPLETED");
    }

    // Methods
    public void approveRequest()
    {
        this.status = "APPROVED";
    }

    public void rejectRequest(String reason)
    {
        this.status = "REJECTED";
        this.notes = reason;
    }

    public void completeRequest()
    {
        this.status = "COMPLETED";
        this.completeDate = LocalDateTime.now();
    }

    @Override
    public double calculateCost()
    {
        return additionalCost;
    }

}