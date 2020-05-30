package FoodOrderDeliveryGUI;

//@author Asyraf

import java.io.*;
import java.util.*;


public class Menu {
    String filename = "Menu\\Menu.txt";
    
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
