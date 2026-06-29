public class Room {
    private int roomNumber;
    private String roomType;
    private int price;
    private boolean isBooked;
    //constructor
    public Room(int roomNumber,String roomType, int price){
        this.roomNumber=roomNumber;
        this.roomType=roomType;
        this.price=price;
        this.isBooked=false; // because now room is available
    }

    public int getRoomNo(){
        return roomNumber;
    }
    public String getRoomType(){
        return roomType;
    }
    public int getPrice(){
        return price;
    }
    public boolean isBooked(){
        return isBooked;
    }

    public void setBooked(boolean booked){
        isBooked=booked;
    }
    public void displayRoomDetails(){
        System.out.println("Room No: "+roomNumber);
        System.out.println("Room Type: "+roomType);
        System.out.println("Price: "+price);
        System.out.println("Room Status: "+(isBooked?"booked":"Available"));
    }
}
