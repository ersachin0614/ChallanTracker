public class Vehicle {
    private String vehicleNumber;
    private String ownerName;
    private String vehicleType; // Car, Bike, Truck, E-Riksha, E-Car

    public Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    @Override
    public String toString() {
        return "Vehicle Number: " + vehicleNumber + "\nOwner: " + ownerName + "\nType: " + vehicleType;
    }
}
