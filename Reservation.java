public class Reservation {
    private int reservationId;
   private Room room;
   private Customer customer;

   public Reservation(int reservationId, Room room, Customer customer){
       this.reservationId=reservationId;
       this.room=room;
       this.customer=customer;

   }

   public int getReservationId(){
       return reservationId;
   }
    public Room getRoom(){
        return room;
    }
    public Customer getCustomer(){
        return customer;
    }



    public void displayReservationDetails(){
       System.out.println("Reservation Id: "+reservationId);
       System.out.println("Room No: "+room.getRoomNo());
        System.out.println("Room Type: "+room.getRoomType());
        System.out.println("Price: "+room.getPrice());
       System.out.println("Customer Name: "+customer.getName());
        System.out.println("Contact No: "+customer.getContact());

    }
}
