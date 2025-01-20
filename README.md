# ChallanTracker
 Focuses on tracking and managing traffic challans.
 The Traffic Challan System is a Java-based application designed to simulate the management of traffic fines (chalans) and violations. The system allows users (like police officers) to issue chalans, search for chalans by ID, view chalans for specific vehicles, and track the payment status of fines. It also helps keep track of vehicles, their owners, and violations related to traffic laws.

This project is useful for simulating and managing traffic-related tasks in a structured way, potentially supporting authorities in enforcing traffic rules and regulations.
Features
Vehicle Management: Store and manage details about vehicles including vehicle number, owner name, and vehicle type (Car, Bike, Truck, E-Riksha, E-Car).
Chalan Issuance: Issue a chalan to a vehicle for a traffic violation, with a fine amount and violation type.
Search by Chalan ID: Find details of a specific chalan using its unique ID.
View Chalans for Vehicle: View all chalans associated with a specific vehicle number.
Pending Chalans: View a list of all pending chalans (i.e., chalans that haven't been paid yet).
Chalan Payment: Mark a chalan as paid after the user makes the payment.
Submission Deadline: Each chalan comes with a random submission deadline between 5 and 15 days.
Usage
Once the program is running, you'll be presented with a menu with the following options:

Issue a Traffic Chalan:

Enter the vehicle number (e.g., ABC1234).
Provide the owner's name.
Choose the vehicle type (Car, Bike, Truck, E-Riksha, E-Car).
Specify the violation type (e.g., Speeding, No Helmet).
Enter the fine amount.
A new chalan will be issued with a unique ID.
Search Chalan by Chalan ID:

Input a Chalan ID to retrieve details about a specific chalan (such as the vehicle number, violation, fine amount, and payment status).
View Chalans for a Vehicle:

Enter a vehicle number to view all chalans issued for that vehicle.
View Pending Chalans:

This will show all chalans that are still pending (i.e., not paid).
Pay a Chalan:

Enter the Chalan ID and mark it as paid once the payment has been made.
Exit:

Exit the program.
Code Structure
TrafficChallanSystem.java: The main entry point of the program, containing the main loop and handling user interactions.
Vehicle.java: Class representing a vehicle with properties like vehicle number, owner name, and vehicle type.
Chalan.java: Class representing a chalan (traffic fine) issued to a vehicle, containing details like violation type, fine amount, and payment status.
PoliceOfficer.java: Class representing a police officer who issues chalans and manages the collection of chalans.
Code Explanation
Vehicle Class:

Stores vehicle details such as number, owner name, and type.
Provides a string representation for displaying vehicle information.
Chalan Class:

Stores information about the chalan such as the vehicle associated with it, the violation type, fine amount, issue date, submission deadline, and payment status.
Automatically generates a random submission deadline (between 5 and 15 days).
Provides methods to mark a chalan as paid and to display chalan details.
PoliceOfficer Class:

Responsible for issuing chalans, viewing chalans for a vehicle, and paying chalans.
Uses a Map to store chalans by ID and vehicle number.
