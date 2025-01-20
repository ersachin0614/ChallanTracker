import java.util.Scanner;

public class TrafficChallanSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PoliceOfficer officer = new PoliceOfficer();

        while (true) {
            System.out.println("\n====================================");
            System.out.println("Welcome to the Traffic Challan System!");
            System.out.println("====================================");
            System.out.println("Please choose an option:");
            System.out.println("1. Issue a Traffic Chalan");
            System.out.println("2. Search Chalan by Chalan ID");
            System.out.println("3. View Chalans for a Vehicle");
            System.out.println("4. View Pending Chalans");
            System.out.println("5. Pay a Chalan");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline character

            switch (choice) {
                case 1: // Issue a Chalan
                    // Take input for vehicle details
                    String vehicleNumber;
                    while (true) {
                        System.out.print("\nEnter Vehicle Number (e.g., ABC1234, AB1234CD): ");
                        vehicleNumber = scanner.nextLine().trim();  // Strip leading/trailing spaces
                        if (isValidVehicleNumber(vehicleNumber)) {
                            break;
                        } else {
                            System.out.println("Invalid vehicle number format. Please follow the format correctly.");
                        }
                    }

                    String ownerName;
                    while (true) {
                        System.out.print("\nEnter Owner Name (Only A-Z, a-z, and spaces allowed): ");
                        ownerName = scanner.nextLine().trim();  // Strip leading/trailing spaces
                        if (isValidOwnerName(ownerName)) {
                            break;
                        } else {
                            System.out.println("Invalid name. Special characters are not allowed.");
                        }
                    }

                    String vehicleType;
                    while (true) {
                        System.out.print("\nEnter Vehicle Type (Car/Bike/Truck/E-Riksha/E-Car): ");
                        vehicleType = scanner.nextLine().trim();  // Strip leading/trailing spaces
                        if (isValidVehicleType(vehicleType)) {
                            break;
                        } else {
                            System.out.println("Invalid vehicle type. Please choose a valid type from the options.");
                        }
                    }

                    // Create the Vehicle object
                    Vehicle vehicle = new Vehicle(vehicleNumber, ownerName, vehicleType);

                    // Take input for violation details
                    String violationType;
                    while (true) {
                        System.out.print("\nEnter Violation Type (e.g., Speeding, No Helmet, etc.): ");
                        violationType = scanner.nextLine().trim();  // Strip leading/trailing spaces
                        if (!violationType.isEmpty()) {
                            break;
                        } else {
                            System.out.println("Violation Type cannot be empty.");
                        }
                    }

                    double fineAmount;
                    while (true) {
                        System.out.print("Enter Fine Amount (Positive number): ");
                        try {
                            fineAmount = Double.parseDouble(scanner.nextLine().trim());
                            if (fineAmount > 0) {
                                break;
                            } else {
                                System.out.println("Fine amount must be a positive number.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid fine amount. Please enter a valid number.");
                        }
                    }

                    // Issue chalan
                    officer.issueChalan(vehicle, violationType, fineAmount);
                    break;

                case 2: // Search Chalan by Chalan ID
                    System.out.print("\nEnter Chalan ID to search: ");
                    int chalanId = scanner.nextInt();
                    scanner.nextLine();  

                    // Search for the chalan
                    Chalan foundChalan = officer.searchChalanById(chalanId);
                    if (foundChalan != null) {
                        System.out.println("\nChalan found:");
                        System.out.println(foundChalan);
                    } else {
                        System.out.println("\nNo chalan found with ID: " + chalanId);
                    }
                    break;

                case 3: // View Chalans for a Vehicle
                    System.out.print("\nEnter Vehicle Number to view chalans: ");
                    String vehicleNum = scanner.nextLine().trim();
                    officer.viewChalansForVehicle(vehicleNum);
                    break;

                case 4: // View Pending Chalans
                    officer.viewPendingChalans();
                    break;

                case 5: 
                    System.out.print("\nEnter Chalan ID to pay: ");
                    int payChalanId = scanner.nextInt();
                    scanner.nextLine();  
                    officer.payChalan(payChalanId);
                    break;

                case 6: 
                    System.out.print("\nAre you sure you want to exit? (y/n): ");
                    String exitChoice = scanner.nextLine().trim().toLowerCase();
                    if (exitChoice.equals("y")) {
                        System.out.println("Exiting the Traffic Challan System. Goodbye!");
                        scanner.close();
                        System.exit(0);
                    }
                    break;

                default:
                    System.out.println("\nInvalid choice! Please select a valid option.");
            }
        }
    }

    public static boolean isValidVehicleNumber(String vehicleNumber) {
        String regex = "^[A-Z]{2}[0-9]{1,2}[A-Z]{1,2}[0-9]{1,4}$";
        return vehicleNumber.matches(regex);
    }

    public static boolean isValidOwnerName(String name) {
        return name.matches("[A-Za-z ]+");
    }

    public static boolean isValidVehicleType(String vehicleType) {
        return vehicleType.equalsIgnoreCase("Car") || vehicleType.equalsIgnoreCase("Bike") ||
               vehicleType.equalsIgnoreCase("Truck") || vehicleType.equalsIgnoreCase("E-Riksha") ||
               vehicleType.equalsIgnoreCase("E-Car");
    }
}
