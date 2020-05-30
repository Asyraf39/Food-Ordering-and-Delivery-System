package FoodOrderDelivery;

//@author Asyraf

import java.util.List;


public class Admin extends User{
    private boolean statusAdmin;
    
    //constructor
    Admin(){
        super();
        super.setUsername("admin");
        super.setFilename("User\\Admin.txt");
        statusAdmin = false;
    }
    
    //accessor method
    boolean getStatusAdmin() { return statusAdmin; }
    //mutator method
    void setStatusAdmin(boolean s) { statusAdmin = s; }
    
    //verify admin password
    boolean verifyPassword(){
        boolean verified = false;
        List<String> admin = load();
        super.setTime(1554821101879L);
        System.out.print("Enter password : ");
        encrypt(keyboard.nextLine());
        if(admin.get(0).endsWith(super.getPassword())) {
            System.out.println("Correct password");
            verified = true;
        }
        else {
            System.out.println("Wrong password");
        }
        return verified;
    }
}
