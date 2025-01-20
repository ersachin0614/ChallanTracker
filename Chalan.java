import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadLocalRandom;

public class Chalan {
    private static int chalanCounter = 1;  // Static variable to generate unique Chalan IDs
    private int chalanId;
    private Vehicle vehicle;
    private String violationType;
    private double fineAmount;
    private Date issueDate;  // Date of chalan issuance
    private Date submissionDeadline; // Deadline for submitting the chalan
    private boolean isPaid;  // To track if the chalan has been paid

    public Chalan(Vehicle vehicle, String violationType, double fineAmount) {
        this.chalanId = chalanCounter++;  // Assign and increment the Chalan ID
        this.vehicle = vehicle;
        this.violationType = violationType;
        this.fineAmount = fineAmount;
        this.issueDate = new Date();  // Set the current date as issue date
        this.submissionDeadline = generateRandomDeadline();  // Set random submission deadline
        this.isPaid = false;  // Initially, the chalan is not paid
    }

    public int getChalanId() {
        return chalanId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getViolationType() {
        return violationType;
    }

    public double getFineAmount() {
        return fineAmount;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getSubmissionDeadline() {
        return submissionDeadline;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void payChalan() {
        this.isPaid = true;
    }

    private Date generateRandomDeadline() {
        long randomDays = ThreadLocalRandom.current().nextLong(5, 15);
        long deadlineMillis = issueDate.getTime() + (randomDays * 24 * 60 * 60 * 1000); // Convert days to milliseconds
        return new Date(deadlineMillis);
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String paymentStatus = isPaid ? "Paid" : "Pending";
        return "Chalan ID: " + chalanId + "\nChalan for Vehicle: " + vehicle.getVehicleNumber() + 
               "\nOwner: " + vehicle.getOwnerName() +  // Including the Owner Name in the output
               "\nViolation: " + violationType + "\nFine Amount: " + fineAmount + 
               "\nDate of Issue: " + sdf.format(issueDate) + 
               "\nSubmission Deadline: " + sdf.format(submissionDeadline) + 
               "\nPayment Status: " + paymentStatus;
    }
}
