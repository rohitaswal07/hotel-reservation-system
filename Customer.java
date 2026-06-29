public class Customer {
    private String name;
    private String contact;
    private String email;

    public Customer(String name, String contact, String email){
        this.name=name;
        this.contact=contact;
        this.email=email;
    }

    //getters

    public String getName(){
        return name;
    }
    public String getContact(){
        return contact;
    }
    public String getEmail(){
        return email;
    }

    public void displayCustomerDetails(){
        System.out.println("Name: "+name);
        System.out.println("Contact No: "+contact);
        System.out.println("email: "+email);
    }
}
