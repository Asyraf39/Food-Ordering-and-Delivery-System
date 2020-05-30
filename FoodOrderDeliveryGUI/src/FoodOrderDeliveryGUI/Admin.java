package FoodOrderDeliveryGUI;

//@author Asyraf

import java.util.List;


public class Admin extends User{
    
    //constructor
    Admin(){
        super();
        super.setUsername("admin");
        super.setFilename("User\\Admin.txt");
    }
    
    //verify admin password
    boolean verifyPassword(String p){
        boolean verified = false;
        List<String> admin = load();
        super.setTime(1554821101879L);
        
        encrypt(p);
        if(admin.get(0).endsWith(super.getPassword())) { verified = true; }
        
        return verified;
    }
}
