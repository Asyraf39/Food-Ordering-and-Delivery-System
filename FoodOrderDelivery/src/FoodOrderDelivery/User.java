package FoodOrderDelivery;

//@author Asyraf

import static FoodOrderDelivery.FoodOrderDelivery.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class User {
    private String username;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private boolean statusLoggedIn = false;
    private long currentUser;
    private long time = 0;
    private String filename = "User\\User.txt";
    
    Scanner keyboard = new Scanner(System.in);
    
    //constructors
    User() {
        username = "";
        email = "";
        password = "";
        address = "";
        phoneNumber = "";
    }
    User(String u, String e, String p, String a, String n) {
        username = u;
        email = e;
        password = p;
        address = a;
        phoneNumber = n;
    }
    
    //accessor methods
    String getUsername() { return username; }
    String getEmail() { return email; }
    String getPassword() { return password; }
    String getAddress() { return address; }
    String getPhoneNumber() { return phoneNumber; }
    boolean getStatusLoggedIn() { return statusLoggedIn; }
    long getCurrentUser() { return currentUser; }
    long getTime() { return time; }
    String getFilename() { return filename; }
    //mutator methods
    void setUsername(String u) { username = u; }
    void setEmail(String e) { email = e; }
    void setPassword(String p) { password = p; }
    void setAddress(String a) { address = a; }
    void setPhoneNumber(String n) { phoneNumber = n; }
    void setStatusLoggedIn(boolean s) { statusLoggedIn = s; }
    void setCurrentUser(long c) { currentUser = c; }
    void setTime(long t) { time = t; }
    void setFilename(String f) { filename = f; }
    
    //user register
    void register() {
        System.out.print("Enter username : ");
        username = keyboard.nextLine();
        
        List<String> users = load();
        if(existUser(users, username)) {
            System.out.println("User already exists");
            System.out.println("Do you want to log in? Y/N");
                    
            boolean valid = false;
            while(!valid) {
                System.out.print("->");
                String choice = keyboard.nextLine().toUpperCase();
                switch(choice) {
                    case "Y":
                        valid = true;
                        clearScreen();
                        login();
                        break;
                    case "N":
                        valid = true;
                        System.out.println("Exit");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        }
        else {
            System.out.print("Enter email : ");
            email = keyboard.nextLine();
            if(existUser(users, email)) {
                System.out.println("User with that email already exists");
                System.out.println("Do you want to log in? Y/N");

                boolean valid = false;
                while(!valid) {
                    System.out.print("->");
                    String choice = keyboard.nextLine().toUpperCase();
                    switch(choice) {
                        case "Y":
                            valid = true;
                            login();
                            break;
                        case "N":
                            valid = true;
                            System.out.println("Exit");
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                }
            }
            else{
                verifyPassword(2);
                System.out.print("Enter address : ");
                address = keyboard.nextLine();
                System.out.print("Enter phone number : ");
                phoneNumber = keyboard.nextLine();
                
                int user = 0;
                if(!users.isEmpty()) {
                    user = Integer.valueOf(users.get(0));
                }
                user += 1;
                if(users.isEmpty()) {
                    users.add(Integer.toString(user));
                }
                else {
                    users.set(0, Integer.toString(user));
                }

                time = System.currentTimeMillis();
                users.add("");
                users.add("User ID : " + time + password.length());
                users.add("Username : " + username);
                users.add("Email : " + email);
                encrypt(password);
                users.add("Password : " + password);
                users.add("Address : " + address);
                users.add("Phone number : " + phoneNumber);

                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(time);
                users.add("Date created : " + date);

                write(users);

                clearScreen();
                System.out.println("User registered");
                System.out.println("You can now log in");
                System.out.println();

                login();
            }
        }
    }
    
    //user login
    void login() {
        List<String> users = load();
        if(users.isEmpty()) {
            System.out.println("No user exists yet");
            System.out.println("Do you want to register? Y/N");
            boolean valid = false;
            while(!valid) {
                System.out.print("->");
                String choice = keyboard.nextLine().toUpperCase();
                switch(choice) {
                    case "Y":
                        valid = true;
                        register();
                        break;
                    case "N":
                        valid = true;
                        System.out.println("Exit");
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }
        }
        else {
            System.out.print("Enter username : ");
            username = keyboard.nextLine();
            
            if(existUser(users, username) && !username.equals("admin")) {
                if(verifyPassword(1) == true) {
                    statusLoggedIn = true;
                    currentUser = Long.parseLong(users.get(users.indexOf("Username : " + username) - 1).substring(10));
                }
                else {
                    System.out.println("You will be returned to the main menu");
                    delay(3000);
                }
            }
            else if(username.equals("admin")) {
            }
            else {
                System.out.println("User does not exist");
                System.out.println("You will be returned to the main menu");
                delay(3000);
            }
        }
    }
    
    //deactivate account
    void deactivate(){
        List<String> users = load();
        int lineNumber = users.indexOf("User ID : " + currentUser);
        for(int i = 6; i >= -1; i--) {
            users.remove(lineNumber + i);
        }
        users.set(0, Integer.toString(Integer.valueOf(users.get(0)) - 1));
        write(users);
        currentUser = 0;
        statusLoggedIn = false;
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
    
    //encrypt password
    void encrypt(String p) {
        password = ""; //clear stored password
        
        //create encryption key
        int[][] encryptionKey = new int[3][5];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 5; j++) {
                if(j+(i*5) < Long.toString(time).length()) {
                    encryptionKey[i][j] = Long.toString(time).charAt(j+(i*5)) - '0';
                }
            }
        }
        
        //create plain text matrix
        int row = 3;
        int column;
        if(p.length() % 3 == 0) {
            column = p.length() / 3;
        }
        else {
            column = p.length() / 3 + 1;
        }
        int[][] plainMatrix = new int[column][row];
        
        for(int i = 0; i < column; i++) {
            for(int j = 0; j < row; j++) {
                if(j+(i*row) < p.length()) {
                    plainMatrix[i][j] = p.charAt(j+(i*row)) - '0';
                }
            }
        }
        p = ""; //clear plain text password
        
        //create cipher text matrix
        int[][] cipherMatrix = new int[column][5];
        for(int i = 0; i < column; i++) {
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 3; k++) {
                    cipherMatrix[i][j] += encryptionKey[k][j] * plainMatrix[i][k];
                }
            }
        }
        
        //convert cipher text matrix to password
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < column; j++) {
                password = password + cipherMatrix[j][i];
            }
        }
    }
    
    //check for existing users
    boolean existUser(List<String> lines, String input){
        return (lines.indexOf("Username : " + input) != -1 || lines.indexOf("Email : " + input) != -1);
    }
    
    //verify password
    boolean verifyPassword(int mode){
        boolean verified = false;
        switch(mode) {
            case 1:
                List<String> users = load();
                int lineNumber = users.indexOf("Username : " + username) + 2;
                time = Long.parseLong(users.get(lineNumber - 3).substring(10, 23));
                System.out.print("Enter password : ");
                encrypt(keyboard.nextLine());
                if(users.get(lineNumber).endsWith(password)) {
                    System.out.println("Correct password");
                    verified = true;
                }
                else {
                    System.out.println("Wrong password");
                }   break;
            case 2:
                String tempPass;
                System.out.print("Enter password : ");
                tempPass = keyboard.nextLine();
                boolean similar = false;
                while(!similar) {
                    System.out.print("Confirm password : ");
                    if(keyboard.nextLine().equals(tempPass)){
                        similar = true;
                        password = tempPass;
                    }
                    else {
                        System.out.println("Password is different");
                    }
                }
                verified = true;
                break;
            default:
                System.out.println("Wrong mode");
                break;
        }
        return verified;
    }
}
