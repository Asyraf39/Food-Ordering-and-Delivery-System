package FoodOrderDeliveryGUI;

//@author Asyraf

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class User {
    private String username;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private long currentUser;
    private long time = 0;
    private String filename = "User\\User.txt";
    
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
    long getCurrentUser() { return currentUser; }
    long getTime() { return time; }
    String getFilename() { return filename; }
    //mutator methods
    void setUsername(String u) { username = u; }
    void setEmail(String e) { email = e; }
    void setPassword(String p) { password = p; }
    void setAddress(String a) { address = a; }
    void setPhoneNumber(String n) { phoneNumber = n; }
    void setCurrentUser(long c) { currentUser = c; }
    void setTime(long t) { time = t; }
    void setFilename(String f) { filename = f; }
    
    //user register
    void register() {
        List<String> users = load();
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
    }
    
    //user login
    void login() {
        List<String> users = load();
        currentUser = Long.parseLong(users.get(users.indexOf("Username : " + username) - 1).substring(10));
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
    boolean verifyPassword(){
        boolean verified = false;
        List<String> users = load();
        int lineNumber = users.indexOf("Username : " + username) + 2;
        time = Long.parseLong(users.get(lineNumber - 3).substring(10, 23));
        encrypt(password);
        if(users.get(lineNumber).endsWith(password)) {
            verified = true;
        }
        return verified;
    }
}
