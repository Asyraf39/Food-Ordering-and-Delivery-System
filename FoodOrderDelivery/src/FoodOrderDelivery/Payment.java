package FoodOrderDelivery;

//@author Asyraf

public class Payment {
    double tax;
    double payPrice;
    
    //accessor methods
    double get_Tax() { return tax; }
    double get_payPrice() { return payPrice; }
    
    //calculate tax
    double tax(double p) { return 0.10 * p; }
    //calculate pay price
    double payPrice(double p) { return p + tax(p); }
     
    //print receipt
    void print(double p) {
        System.out.printf("Total price without tax is RM " + "%.2f", p);
        System.out.println();
        
        System.out.printf("Your total tax is RM " + "%.2f", tax(p));
        System.out.println();
        
        System.out.printf("Your total payment including the tax is RM " + "%.2f", payPrice(p));
        System.out.println();
        
        System.out.println("Thank you! Your order will be delivered soon!");
        
        Delivery d1 = new Delivery();
        System.out.print("You made your order on ");
        d1.print1();
        
        System.out.print("Your order is estimated delivered on ");
        d1.print2();
    }
}
