package FoodOrderDelivery;

//@author Asyraf

import java.text.SimpleDateFormat;
import java.util.Date;


public class Delivery {
    
    //print current date
    void print1() {
    
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm:SS");
        Date date = new Date(System.currentTimeMillis());

        System.out.println(date);

    }
    //print date after 30 minutes
    void print2() {
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm:SS");
        Date date = new Date(System.currentTimeMillis() + 1800000);

        System.out.println(date);

    }
}
