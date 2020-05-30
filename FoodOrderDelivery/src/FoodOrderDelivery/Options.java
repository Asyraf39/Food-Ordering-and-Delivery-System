package FoodOrderDelivery;

//@author Asyraf

import static FoodOrderDelivery.FoodOrderDelivery.*;
import java.util.*;

public class Options {
    int nextOption = 1;
    
    Scanner keyboard = new Scanner(System.in);
    User u1 = new User();
    Admin a1 = new Admin();
    String current;
    
    //accessor method
    int getNextOption(){ return nextOption; }
    
    //main menu
    int choiceOption1() {
        nextOption = 1;
        clearScreen();
        
        System.out.println("Welcome to Eclipse Food Ordering and Delivery System");
        System.out.println("Choose an action");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        
        switch(validate(3)) {
            case 1:
                clearScreen();
                u1.register();
                break;
            case 2:
                clearScreen();
                u1.login();
                if(u1.getUsername().equals("admin")) {
                    if(a1.verifyPassword() == true) {
                        a1.setStatusLoggedIn(true);
                        a1.setStatusAdmin(true);
                        nextOption = 4;
                    }
                    else {
                        System.out.println("You will be returned to the main menu");
                        delay(3000);
                    }
                }
                break;
            case 3:
                clearScreen();
                System.out.println("Thanks for using our program");
                nextOption = 0;
                break;
            default:
                System.out.println("Option not available");
        }
        
        if(u1.getStatusLoggedIn() == true) {
            nextOption = 2;
        }
        
        return nextOption;
    }
    
    //options after log in
    int choiceOption2() {
        nextOption = 2;
        clearScreen();
        System.out.println("Choose an action");
        System.out.println("1. Make an order");
        System.out.println("2. Change user details");
        System.out.println("3. Log out");
        
        switch(validate(3)) {
            case 1:
                clearScreen();
                Menu m1 = new Menu();
                m1.menuPrint("food");
                m1.menuPrint("drink");
                m1.menuPrint("dessert");
                m1.printPaymentDetails();
                delay(10000);
                break;
            case 2:
                nextOption = 3;
                break;
            case 3:
                u1.setStatusLoggedIn(false);
                nextOption  = 1;
                break;
            default:
                break;
        }
        
        return nextOption;
    }
    
    //options to change user details
    int choiceOption3() {
        nextOption = 3;
        clearScreen();
        List<String> users;
        
        System.out.println("Choose an action");
        System.out.println("1. Change username");
        System.out.println("2. Change email");
        System.out.println("3. Change password");
        System.out.println("4. Change address");
        System.out.println("5. Change phone number");
        System.out.println("6. Deactivate account");
        System.out.println("7. Back");
        
        switch(validate(7)) {
            case 1:
                clearScreen();
                users = u1.load();
                System.out.print("Enter new username : ");
                String tempUsername = keyboard.nextLine();
                while(u1.existUser(users, tempUsername)) {
                    System.out.println();
                    System.out.println("That username is taken");
                    System.out.print("Choose another username : ");
                    tempUsername = keyboard.nextLine();
                }
                if(u1.verifyPassword(1) == true) {
                    int lineNumber = users.indexOf("User ID : " + u1.getCurrentUser());
                    u1.setUsername(tempUsername);
                    users.set(lineNumber + 1, "Username : " + u1.getUsername());
                    u1.write(users);
                    System.out.println();
                    System.out.println("Username changed");
                }
                else {
                    System.out.println();
                    System.out.println("Username not changed");
                }
                delay(3000);
                break;
            case 2:
                clearScreen();
                users = u1.load();
                
                System.out.print("Enter new email : ");
                String tempEmail = keyboard.nextLine();
                while(u1.existUser(users, tempEmail)) {
                    System.out.println();
                    System.out.println("That email is used");
                    System.out.print("Choose another email : ");
                    tempEmail = keyboard.nextLine();
                }
                
                System.out.print("Confirm email : ");
                while(!keyboard.nextLine().equals(tempEmail)) {
                    System.out.println();
                    System.out.println("Email is different");
                    System.out.print("Confirm email : ");
                }
                
                if(u1.verifyPassword(1) == true) {
                    int lineNumber = users.indexOf("User ID : " + u1.getCurrentUser());
                    u1.setEmail(tempEmail);
                    users.set(lineNumber + 2, "Email : " + u1.getEmail());
                    u1.write(users);
                    System.out.println();
                    System.out.println("Email changed");
                }
                else {
                    System.out.println();
                    System.out.println("Email not changed");
                }
                delay(3000);
                break;
            case 3:
                clearScreen();
                users = u1.load();
                
                if(u1.verifyPassword(1) == true) {
                    System.out.println();
                    System.out.println("Set your new password");
                    if(u1.verifyPassword(2) == true){
                        int lineNumber = users.indexOf("User ID : " + u1.getCurrentUser());
                        users.set(lineNumber, users.get(lineNumber).substring(0, 23) + u1.getPassword().length());
                        u1.encrypt(u1.getPassword());
                        users.set(lineNumber + 3, "Password : " + u1.getPassword());
                        u1.setCurrentUser(Long.parseLong(users.get(lineNumber).substring(10)));
                        u1.write(users);
                        System.out.println();
                        System.out.println("Password changed");
                    }
                    else {
                        System.out.println();
                        System.out.println("Password not changed");
                    }
                    delay(3000);
                }
                break;
            case 4:
                clearScreen();
                users = u1.load();
                
                System.out.print("Enter new address : ");
                String tempAddress = keyboard.nextLine();
                if(u1.verifyPassword(1) == true) {
                    int lineNumber = users.indexOf("User ID : " + u1.getCurrentUser());
                    u1.setAddress(tempAddress);
                    users.set(lineNumber + 4, "Address : " + u1.getAddress());
                    u1.write(users);
                    System.out.println();
                    System.out.println("Address changed");
                }
                else {
                    System.out.println();
                    System.out.println("Address not changed");
                }
                delay(3000);
                break;
            case 5:
                clearScreen();
                users = u1.load();
                
                System.out.print("Enter new phone number : ");
                String tempNumber = keyboard.nextLine();
                if(u1.verifyPassword(1) == true) {
                    int lineNumber = users.indexOf("User ID : " + u1.getCurrentUser());
                    u1.setPhoneNumber(tempNumber);
                    users.set(lineNumber + 5, "Phone number : " + u1.getPhoneNumber());
                    u1.write(users);
                    System.out.println();
                    System.out.println("Phone number changed");
                }
                else {
                    System.out.println();
                    System.out.println("Phone number not changed");
                }
                delay(3000);
                break;
            case 6:
                clearScreen();
                users = u1.load();
                
                System.out.println("Account deactivation is permanent and cannot be reversed");
                System.out.println("Do you want to proceed with this action? Y/N");
                
                boolean valid = false;
                while(!valid) {
                    System.out.print("->");
                    String choice = keyboard.nextLine().toUpperCase();
                    switch(choice) {
                        case "Y":
                            valid = true;
                            u1.deactivate();
                            System.out.println();
                            System.out.println("Account deactivated");
                            nextOption = 1;
                            break;
                        case "N":
                            valid = true;
                            System.out.println("You will be returned to the menu");
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                }
                delay(3000);
                break;
            case 7:
                nextOption -= 1;
                break;
            default:
                break;
        }
        
        return nextOption;
    }
    
    //menu for admin
    int choiceOption4() {
        nextOption = 4;
        clearScreen();
        System.out.println("Choose an action");
        System.out.println("1. Manage menu");
        System.out.println("2. Log out");
        
        switch(validate(2)) {
            case 1:
                nextOption = 5;
                break;
            case 2:
                a1.setStatusLoggedIn(false);
                a1.setStatusAdmin(false);
                nextOption  = 1;
                break;
            default:
                break;
        }
        
        return nextOption;
    }
    
    //options to manage menu
    int choiceOption5() {
        nextOption = 5;
        Menu m1 = new Menu();
        clearScreen();
        System.out.println("Choose an action");
        System.out.println("1. Add item");
        System.out.println("2. Change item name");
        System.out.println("3. Change item price");
        System.out.println("4. Remove item");
        System.out.println("5. Back");
        
        switch(validate(5)) {
            case 1:
                clearScreen();
                String name, type = "";
                double price = 0.00;
                System.out.println("Which menu do you want to add?");
                System.out.println("'food', 'drink', 'dessert'");
                boolean valid = false;
                while(!valid) {
                    System.out.print("->");
                    type = keyboard.nextLine();
                    if(type.toLowerCase().equals("food") || type.toLowerCase().equals("drink") || type.toLowerCase().equals("dessert")) {
                        valid = true;
                    }
                    else {
                        System.out.println();
                        System.out.println("Invalid input");
                    }
                }
                
                System.out.println();
                System.out.println("What is the name of the item?");
                System.out.print("->");
                name = keyboard.nextLine();
                while(m1.menuExists(name, type)) {
                    System.out.println();
                    System.out.println("Item already exist");
                    System.out.print("->");
                    name = keyboard.nextLine();
                }
                
                System.out.println();
                System.out.println("What is the price of the item?");
                
                valid = false;
                while(!valid){
                    System.out.print("->");
                    try{
                        price = Double.valueOf(keyboard.nextLine());
                        valid = true;
                        if(price <= 0){
                            System.out.println();
                            System.out.println("Invalid price");
                            valid = false;
                        }
                    }
                    catch(NumberFormatException ex){
                        System.out.println();
                        System.out.println("Invalid input");
                    }
                }
                
                m1.menuAdd(name, price, type);
                
                System.out.println();
                System.out.println("Item added");
                delay(3000);
                break;
            case 2:
                clearScreen();
                type = "";
                System.out.println("Which menu do you want to change?");
                System.out.println("'food', 'drink', 'dessert'");
                valid = false;
                while(!valid) {
                    System.out.print("->");
                    type = keyboard.nextLine();
                    if(type.toLowerCase().equals("food") || type.toLowerCase().equals("drink") || type.toLowerCase().equals("dessert")) {
                        valid = true;
                    }
                    else {
                        System.out.println();
                        System.out.println("Invalid input");
                    }
                }
                System.out.println();
                m1.menuChange(type, 1);
                
                System.out.println();
                System.out.println("Name changed");
                delay(3000);
                break;
            case 3:
                clearScreen();
                type = "";
                System.out.println("Which menu do you want to change?");
                System.out.println("'food', 'drink', 'dessert'");
                valid = false;
                while(!valid) {
                    System.out.print("->");
                    type = keyboard.nextLine();
                    if(type.toLowerCase().equals("food") || type.toLowerCase().equals("drink") || type.toLowerCase().equals("dessert")) {
                        valid = true;
                    }
                    else {
                        System.out.println();
                        System.out.println("Invalid input");
                    }
                }
                System.out.println();
                m1.menuChange(type, 2);
                
                System.out.println();
                System.out.println("Price changed");
                delay(3000);
                break;
            case 4:
                clearScreen();
                type = "";
                System.out.println("Which menu do you want to change?");
                System.out.println("'food', 'drink', 'dessert'");
                valid = false;
                while(!valid) {
                    System.out.print("->");
                    type = keyboard.nextLine();
                    if(type.toLowerCase().equals("food") || type.toLowerCase().equals("drink") || type.toLowerCase().equals("dessert")) {
                        valid = true;
                    }
                    else {
                        System.out.println();
                        System.out.println("Invalid input");
                    }
                }
                System.out.println();
                m1.menuRemove(type);
                
                System.out.println();
                System.out.println("Item removed");
                delay(3000);
                break;
            case 5:
                nextOption = 4;
                break;
            default:
                break;
        }
        
        return nextOption;
    }
    
    //validate input
    int validate(int range){
        boolean valid = false;
        String line;
        int choice = 0;
        while(!valid){
            System.out.println();
            System.out.print("->");
            line = keyboard.nextLine();
            try{
                choice = Integer.valueOf(line);
                valid = true;
                if(choice < 1 || choice > range){
                    System.out.println("Option not available");
                    valid = false;
                }
            }
            catch(NumberFormatException ex){
                System.out.println("Invalid input");
            }
        }
        return choice;
    }
}
