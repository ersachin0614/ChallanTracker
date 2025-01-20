import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class PoliceOfficer {
    private Map<Integer, Chalan> issuedChalans;  // To store chalans by Chalan ID
    private Map<String, List<Chalan>> vehicleChalans; // To store chalans by Vehicle Number

    public PoliceOfficer() {
        issuedChalans = new HashMap<>();
        vehicleChalans = new HashMap<>();
    }

    // Method to issue a chalan
    public void issueChalan(Vehicle vehicle, String violationType, double fineAmount) {
        Chalan chalan = new Chalan(vehicle, violationType, fineAmount);
        issuedChalans.put(chalan.getChalanId(), chalan);
        
        // Add the chalan to the vehicle's list
        vehicleChalans.putIfAbsent(vehicle.getVehicleNumber(), new ArrayList<>());
        vehicleChalans.get(vehicle.getVehicleNumber()).add(chalan);
        
        System.out.println("\nChalan issued successfully with ID: " + chalan.getChalanId());
    }

    // Method to search chalan by Chalan ID
    public Chalan searchChalanById(int chalanId) {
        return issuedChalans.get(chalanId);
    }

    // Method to view chalans for a specific vehicle number
    public void viewChalansForVehicle(String vehicleNumber) {
        if (vehicleChalans.containsKey(vehicleNumber)) {
            System.out.println("\nChalans for Vehicle: " + vehicleNumber);
            for (Chalan chalan : vehicleChalans.get(vehicleNumber)) {
                System.out.println(chalan);
            }
        } else {
            System.out.println("\nNo chalans found for Vehicle: " + vehicleNumber);
        }
    }

    // Method to view all pending chalans
    public void viewPendingChalans() {
        boolean hasPending = false;
        for (Chalan chalan : issuedChalans.values()) {
            if (!chalan.isPaid()) {
                hasPending = true;
                System.out.println(chalan);
            }
        }
        if (!hasPending) {
            System.out.println("\nNo pending chalans.");
        }
    }
    
    // Method to pay a chalan
    public void payChalan(int chalanId) {
        Chalan chalan = issuedChalans.get(chalanId);
        if (chalan != null) {
            if (!chalan.isPaid()) {
                chalan.payChalan();
                System.out.println("\nChalan ID " + chalanId + " has been marked as paid.");
            } else {
                System.out.println("\nChalan ID " + chalanId + " has already been paid.");
            }
        } else {
            System.out.println("\nNo chalan found with ID: " + chalanId);
        }
    }
}
