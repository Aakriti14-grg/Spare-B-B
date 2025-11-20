//Payment class represents a financial transaction in the accommodation booking system. It supports various payment methods and maintains a complete audit trails.
import java.time.LocalDateTime;

public class Payment
{
    private String paymentID;
    private double amount;
    private String paymentMethod; // CREDIT_CARD, DEBIT_CARD, CASH, etc.
    private String status; // PENDING, COMPLETED, FAILED, REFUNDED
    private LocalDateTime paymentDate;
    private String transactionID;
    private String cardLastFour;
    private String billingAddress;
    private double refundAmount;
    private LocalDateTime refundDate;

    private Booking booking;


    //Placeholder object || Default constructor
    public Payment() {}

    public Payment(String paymentID, Booking booking, String paymentMethod) {
        this.paymentID = paymentID;
        this.booking = booking;
        this.amount = booking.calculateTotalPrice();  ;
        this.paymentMethod = paymentMethod;
        this.status = "PENDING";
        this.paymentDate = LocalDateTime.now();
    }

    // Getters
    public String getPaymentID() { return paymentID; }
    public double getAmount() { return amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getStatus() { return status; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
    public String getTransactionID() { return transactionID; }
    public String getCardLastFour() { return cardLastFour; }
    public String getBillingAddress() { return billingAddress; }
    public double getRefundAmount() { return refundAmount; }
    public LocalDateTime getRefundDate() { return refundDate; }

    // Setters
    public void setPaymentID(String paymentID) { this.paymentID = paymentID; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public void setStatus(String status) {
        if (isValidStatus(status)) {
            this.status = status.toUpperCase();
        } else {
            throw new IllegalArgumentException("Invalid payment status: " + status);
        }
    }
    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }
    public void setTransactionID(String transactionID) { this.transactionID = transactionID; }
    public void setCardLastFour(String cardLastFour) { this.cardLastFour = cardLastFour; }
    public void setBillingAddress(String billingAddress) { this.billingAddress = billingAddress; }
    public void setRefundAmount(double refundAmount) { this.refundAmount = refundAmount; }
    public void setRefundDate(LocalDateTime refundDate) { this.refundDate = refundDate; }

    // Method to validate status
    private boolean isValidStatus(String status)
    {
        String upperStatus = status.toUpperCase();
        return upperStatus.equals("PENDING") ||
                upperStatus.equals("COMPLETED") ||
                upperStatus.equals("FAILED") ||
                upperStatus.equals("REFUNDED");
    }

    // Process Payment
    public boolean processPayment()
    {
        this.status = "COMPLETED";
        this.paymentDate = LocalDateTime.now();

        // Mark accommodation as unavailable AFTER payment
        if (booking != null)
        {
            booking.getAccommodation().setIsAvailable(false);
        }
        return true;
    }

    //refund logic
    public boolean refundPayment(double amount)
    {
        if (amount <= 0 || amount > this.amount)
        {
            return false;
        }
        this.refundAmount = amount;
        this.refundDate = LocalDateTime.now();
        this.status = "REFUNDED";
        return true;
    }

    public boolean isRefundable()
    {
        return "COMPLETED".equals(status) && refundAmount == 0;
    }

    public String getPaymentDetails()
    {
        return "Payment ID: " + paymentID +
                ", Amount: $" + amount +
                ", Method: " + paymentMethod +
                ", Status: " + status +
                ", Date: " + paymentDate;
    }
}