package FoodOrderDelivery;

//@author Asyraf

import java.io.*;
import java.util.*;


public class Menu {
    String filename;
    double price, total_price = 0.00;
    
    Scanner keyboard = new Scanner(System.in);
    
    //accessor method
    double getTotalPrice() { return total_price; };
    
    //add item
    void menuAdd(String name, double price, String type) {
        filename = "Menu\\Menu_" + type + ".txt";
        List<String> menu = load();
        
        name = String.format("%-16s", name);
        if(menu.isEmpty()) {
            menu.add("100. " + String.format("%-16s", name) + "| RM " + String.format("%.2f", price));
        }
        else {
            menu.add((Integer.valueOf(menu.get(menu.size() - 1).substring(0, 3)) + 1) + ". " + String.format("%-16s", name) + "| RM " + String.format("%.2f", price));
        }
        
        write(menu);
    }
    
    //change item details
    void menuChange(String type, int mode) {
        filename = "Menu\\Menu_" + type + ".txt";
        List<String> menu = load();
        
        for(String m : menu){
            System.out.println(m);
        }
        
        int choice = validate(Integer.valueOf(menu.get(0).substring(0, 3)), Integer.valueOf(menu.get(menu.size() - 1).substring(0, 3)), 1);
        int lineNumber = 0;
        int i = 0;
        while(lineNumber == 0 && i < menu.size()) {
            if(Integer.valueOf(menu.get(i).substring(0, 3)) == choice) {
                lineNumber = i + 1;
            }
            i++;
        }
        String line = menu.get(lineNumber - 1);
        switch(mode) {
            case 1:
                System.out.print("Enter new name : ");
                String name = keyboard.nextLine();
                menu.set(lineNumber - 1, line.substring(0, 5) + String.format("%-16s", name) + line.substring(21));
                break;
            case 2:
                double itemPrice = 0.00;
                boolean valid = false;
                while(!valid) {
                    System.out.println();
                    System.out.print("Enter new price : ");
                    try{
                        itemPrice = Double.valueOf(keyboard.nextLine());
                        valid = true;
                    }
                    catch(NumberFormatException ex){
                        System.out.println("Invalid input");
                    }
                }
                menu.set(lineNumber - 1, line.substring(0, 26) + String.format("%.2f", itemPrice));
                break;
            default:
                break;
        }
        write(menu);
    }
    
    //remove item
    void menuRemove(String type) {
        filename = "Menu\\Menu_" + type + ".txt";
        List<String> menu = load();
        
        for(String m : menu){
            System.out.println(m);
        }
        
        int choice = validate(Integer.valueOf(menu.get(0).substring(0, 3)), Integer.valueOf(menu.get(menu.size() - 1).substring(0, 3)), 1);
        int lineNumber = 0;
        int i = 0;
        while(lineNumber == 0 && i < menu.size()) {
            if(Integer.valueOf(menu.get(i).substring(0, 3)) == choice) {
                lineNumber = i + 1;
            }
            i++;
        }
        menu.remove(lineNumber - 1);
        for(int j = 0; j < menu.size(); j++) {
            String line = menu.get(j);
            menu.set(j, (100 + j) + line.substring(3));
        }
        write(menu);
    }
    
    //display menu
    void menuPrint(String type){
        filename = "Menu\\Menu_" + type + ".txt";
        List<String> menu = load();
        
        System.out.println("Here is our " + type + " menu.");
        for(String m : menu){
            System.out.println(m);
        }
        
        int choice = validate(Integer.valueOf(menu.get(0).substring(0, 3)), Integer.valueOf(menu.get(menu.size() - 1).substring(0, 3)), 1);
        int quantity = validate(0, 0, 2);
        
        System.out.println();
        int lineNumber = 0;
        int i = 0;
        while(lineNumber == 0 && i < menu.size()){
            if(menu.get(i).substring(0, 3).equals(Integer.toString(choice))) {
                lineNumber = i + 1;
            }
            i++;
        }
        
        System.out.println(quantity + " \"" + menu.get(lineNumber - 1).substring(5, 21).trim() + "\" is selected");
        price = Double.valueOf(menu.get(lineNumber - 1).substring(26, 30)) * quantity;
        total_price += price;
        System.out.print("Total " + type + " price: RM ");
        System.out.printf("%.2f" + "\n", price);
        System.out.println();
    }
    
    //check for existing items
    boolean menuExists(String name, String type) {
        boolean exist = false;
        filename = "Menu\\Menu_" + type + ".txt";
        List<String> menu = load();
        
        for(String m : menu){
            if(m.substring(5, 21).trim().equals(name)) {
                exist = true;
            }
        }
        
        return exist;
    }
    
    //validate input
    int validate(int start, int end, int mode){
        boolean valid = false;
        String line;
        int choice = 0;
        while(!valid){
            System.out.println();
            switch (mode) {
                case 1:
                    System.out.print("Enter your choice : ");
                    break;
                case 2:
                    System.out.print("Enter the quantity : ");
                    break;
                default:
                    break;
            }
            line = keyboard.nextLine();
            try{
                choice = Integer.valueOf(line);
                valid = true;
                switch (mode) {
                    case 1:
                        if(choice < start || choice > end){
                            System.out.println("Option not available");
                            valid = false;
                        }
                        break;
                    case 2:
                        if(choice < 1){
                            System.out.println("Option not available");
                            valid = false;
                        }
                        break;
                    default:
                        break;
                }
            }
            catch(NumberFormatException ex){
                System.out.println("Invalid input");
            }
        }
        return choice;
    }
    
    //print payment details
    void printPaymentDetails(){
        Payment p1 = new Payment();
        p1.print(total_price);
    }
    
    //load from file
    List<String> load() {
        String line;
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(filename);
            if(!file.exists()) {
                file.createNewFile();
            }
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        return lines;
    }
    
    //write to file
    void write(List<String> lines) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for(int i = 0; i < lines.size(); i++) {
                bufferedWriter.write(lines.get(i));
                bufferedWriter.newLine();
            }
            
            bufferedWriter.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
