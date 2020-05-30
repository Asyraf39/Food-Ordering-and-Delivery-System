package FoodOrderDelivery;

import java.awt.*;
import java.io.*;

public class FoodOrderDelivery {
    public static void main(String[] args) {
        Options o1 = new Options();
        while(o1.getNextOption() != 0) {
            switch(o1.getNextOption()) {
                case 1:
                    o1.choiceOption1();
                    break;
                case 2:
                    o1.choiceOption2();
                    break;
                case 3:
                    o1.choiceOption3();
                    break;
                case 4:
                    o1.choiceOption4();
                    break;
                case 5:
                    o1.choiceOption5();
                    break;
                default:
                    break;
            }
        }
    }
    
    //clear console screen
    static void clearScreen() {
        Console con = System.console();
        if(con == null){
            try {
                Robot pressbot = new Robot();
                pressbot.keyPress(17);
                pressbot.keyPress(76);
                pressbot.keyRelease(17);
                pressbot.keyRelease(76);
            }
            catch(AWTException ex) {
                ex.printStackTrace();
            }
        }
        else{
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            catch(IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        delay(1000);
    }
    
    //add delay
    static void delay(int milli) {
        try {
            Thread.sleep(milli);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
