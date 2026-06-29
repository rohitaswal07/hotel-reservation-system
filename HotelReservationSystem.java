import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelReservationSystem {

    private List<Room> rooms;
    private List<Reservation> reservations;
    Scanner s;

    // constructor
    public HotelReservationSystem() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        s = new Scanner(System.in);

        rooms.add(new Room(101,"AC", 2000));
        rooms.add(new Room(102,"NON-AC", 1000));
        rooms.add(new Room(103,"AC", 2000));
        rooms.add(new Room(104,"NON-AC", 1000));
    }

    // first interface
    public void start() {
        while (true) {
            System.out.println("======Hotel Reservation System======");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Enter choice : ");

            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    userMenu();
                    break;
                case 3:
                    System.out.println("Thanks for visiting");
                    return;
                default:
                    System.out.println("Invalid choice! Try Again.");
                    break;
            }
        }
    }

    // admin interface
    private void adminMenu() {
        while (true) {
            System.out.println("1. Add Room");
            System.out.println("2. Remove Room");
            System.out.println("3. View All Rooms");
            System.out.println("4. View All Reservations");
            System.out.println("5. Log Out");
            System.out.print("Enter choice: ");

            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    addRoom();
                    break;
                case 2:
                    removeRoom();
                    break;
                case 3:
                    viewAllRooms();
                    break;
                case 4:
                    viewAllReservations();
                    break;
                case 5:
                    return;      // log out
                default:
                    System.out.println("Invalid choice! Try Again.");
                    break;
            }
        }
    }

    //Admin function()
    private void addRoom() {

        System.out.print("Enter Room Number: ");                // input room no
        int roomNumber = s.nextInt();
        s.nextLine();


        for (Room r : rooms) {                                         // check if the room no entered by admin already exists or not
            if (roomNumber == r.getRoomNo()) {                        //  if it exists, return;
                System.out.println("Room no already exists");
                System.out.println("----------");
                return;
            }

        }
        System.out.print("Enter Room Type (AC/NON-AC): ");        // input room type
        String roomType = s.nextLine();

        System.out.print("Enter Room Price: ");                  // input room price
        int price = s.nextInt();

        Room newRoom = new Room(roomNumber, roomType, price);       // create room obj
        rooms.add(newRoom);

        System.out.println("✅ Room added successfully");
        System.out.println("----------");
    }


    private void removeRoom() {
        System.out.print("Enter Room Number to remove: ");      // input room no to delete that room
        int roomNumber = s.nextInt();

        Room toRemove = null;

        for (Room r : rooms) {
            if (roomNumber == r.getRoomNo()) {                   // find that room and store it in toRemove
                toRemove = r;
                break;
            }
        }
        if (toRemove != null) {                             // if you find that room, delete it
            rooms.remove(toRemove);
            System.out.println("✅Room removed successfully!");
            System.out.println("----------");
        } else {
            System.out.println("❌Room not found");      // else return
            System.out.println("----------");
        }
    }


    private void viewAllRooms() {
        if (rooms.isEmpty()) {                                           // if rooms list is empty, return
            System.out.println("No rooms available in the system");
            System.out.println("----------");
            return;
        }

        System.out.println("----Lists of Rooms----");              // else print room details with help of loop
        for (Room r : rooms) {
            r.displayRoomDetails();
            System.out.println("----------");
        }
    }


    private void viewAllReservations() {
        if (reservations.isEmpty()) {                                       // if reservations list is empty, return
            System.out.println("No Reservations found in the system");
            System.out.println("----------");
            return;
        }
        System.out.println("----Lists of Reservations----");
        for (Reservation rev : reservations) {                             // else print reservation details with help of loop
            rev.displayReservationDetails();
            System.out.println("----------");
        }
    }


    // user interface
    private void userMenu() {
        while (true) {
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. View My Reservation");
            System.out.println("4. Cancel My Reservations");
            System.out.println("5. Log Out");
            System.out.print("Enter choice: ");

            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewMyReservation();
                    break;
                case 4:
                    cancelMyReservation();
                    break;
                case 5:
                    return;    // log out
                default:
                    System.out.println("Invalid choice! Try Again.");
                    break;
            }
        }
    }

    // User functions

    private void viewAvailableRooms() {
        if (rooms.isEmpty()) {                                             // if rooms list is empty return
            System.out.println("No rooms available in the system");
            System.out.println("----------");
            return;
        }

        System.out.println("----Lists of Rooms----");
        boolean anyAvailable = false;
        for (Room r : rooms) {
            if (!r.isBooked()) {                           // available rooms check and display it
                r.displayRoomDetails();
                System.out.println("----------");
                anyAvailable = true;
            }
        }

        if (!anyAvailable) {                                           //  if all rooms already booked, return
            System.out.println("No available rooms right now");
            System.out.println("----------");
        }
    }


    private void makeReservation() {
        s.nextLine();

        System.out.print("Enter your name: ");     // input customer name
        String name = s.nextLine();

        System.out.print("Enter your contact no: ");   //contact
        String contact = s.nextLine();

        if (contact.length()!=10){
            System.out.println("Invalid Contact Number. ");
            System.out.println("----------");
            return;
        }

        System.out.print("Enter your Email: ");       // email
        String email = s.nextLine();

        Customer newCustomer = new Customer(name, contact, email);   // customer object

        // available rooms check and display it
        System.out.println("----Available Rooms----");
        boolean anyAvailable = false;
        for (Room r : rooms) {
            if (!r.isBooked()) {
                r.displayRoomDetails();
                System.out.println("----------");
                anyAvailable = true;
            }
        }
        if (!anyAvailable) {                                    //  if all rooms already booked, return
            System.out.println("No available rooms right now");
            System.out.println("----------");
            return;
        }

        // room selection
        System.out.print("Enter Room Number: ");
        int roomNumber = s.nextInt();
        s.nextLine(); // clear buffer

        Room selectedRoom = null;
        for (Room r : rooms) {                             // find selectedRoom room
            if (roomNumber == r.getRoomNo()) {
                selectedRoom = r;
                break;
            }
        }
        if (selectedRoom == null) {                      // if selectedRoom is null, return
            System.out.println("Invalid room number");
            System.out.println("----------");
            return;
        }

        if (selectedRoom.isBooked()) {                 // if SelectedRoom is booked, return
            System.out.println("Room is already booked");
            System.out.println("----------");
            return;
        }


        int reservationId = reservations.size() + 1;

        // reservation obj
        Reservation newRes = new Reservation(reservationId, selectedRoom, newCustomer);

        selectedRoom.setBooked(true); // set booked
        reservations.add(newRes);     // add reservation in list

        System.out.println("✅ Reservation successful! ");
        System.out.println("Your Reservation Id : " + reservationId);
        System.out.println("----------");


    }


    private void viewMyReservation() {
        while (true) {
            System.out.println("----View Reservation----");
            System.out.println("1. View by Reservation Id");
            System.out.println("2. View by Email Id");
            System.out.println("3. Back");
            System.out.print("Enter choice: ");

            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    viewByReservationId();
                    break;
                case 2:
                    viewByEmailId();
                    break;
                case 3:
                    return;    // log out
                default:
                    System.out.println("Invalid choice! Try Again.");
                    break;
            }
        }
    }


    private void viewByReservationId() {

        if (reservations.isEmpty()) {                                          // if reservations list is empty, return
            System.out.println("No Reservations found in the system.");
            System.out.println("----------");
            return;
        }

        System.out.print("Enter your Reservation Id to view: ");          // input reservation id to display
        int reservationId = s.nextInt();

        for (Reservation rev : reservations) {                                //  find reservation with help reservation id
            if (reservationId == rev.getReservationId()) {
                System.out.println("----Reservation Details----");
                rev.displayReservationDetails();
                System.out.println("----------");
                return;
            }
        }
        System.out.println("Reservation not found for Id: " + reservationId);     // if reservation id does not match,return
        System.out.println("----------");
    }


    private void viewByEmailId() {

        if (reservations.isEmpty()) {                                            // if reservations list is empty, return
            System.out.println("No Reservations found in the system.");
            System.out.println("----------");
            return;
        }
        s.nextLine();
        System.out.print("Enter your Email Id to view: ");                   // input email id to display
        String email = s.nextLine();

        boolean found = false;
        for (Reservation rev : reservations) {                                    //  find reservation with help email id
            if (rev.getCustomer().getEmail().equalsIgnoreCase(email)) {
                System.out.println("----Reservation Details----");
                rev.displayReservationDetails();
                System.out.println("----------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("Reservation not found for Email Id: " + email);// if email id does not match,return
            System.out.println("----------");
        }
    }


    private void cancelMyReservation() {
        if (reservations.isEmpty()) {                                          // if reservations list is empty, return
            System.out.println("No Reservations found in the system.");
            System.out.println("----------");
            return;
        }

        System.out.print("Enter your Reservation Id to cancel: ");          // input reservation id to cancel
        int reservationId = s.nextInt();

        Reservation revToCancel = null;
        for (Reservation rev : reservations) {                                //  find reservation with help reservation id
            if (reservationId == rev.getReservationId()) {
                revToCancel = rev;
                break;
            }
        }

        if (revToCancel!=null){
            revToCancel.getRoom().setBooked(false);           // make room available
            reservations.remove(revToCancel);                 // remove reservation
            System.out.println("Reservation cancelled successfully");
            System.out.println("----------");
        }
        else {
            System.out.println("Reservation not found for "+reservationId);
            System.out.println("----------");
        }
    }

}


