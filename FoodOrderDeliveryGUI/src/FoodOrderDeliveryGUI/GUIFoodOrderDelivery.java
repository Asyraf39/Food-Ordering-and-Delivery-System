package FoodOrderDeliveryGUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//@author Asyraf

public class GUIFoodOrderDelivery implements ActionListener {
    JFrame jfMainMenu = new JFrame("Eclipse Food Ordering and Delivery System");
    
    GUIFoodOrderDelivery() {
        JLabel jlWelcome = new JLabel();
        JButton jbRegister = new JButton();
        JButton jbLogin = new JButton();               
        JLabel jlBackground = new JLabel();

        jfMainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfMainMenu.setResizable(true);

        
        jfMainMenu.setMinimumSize(new Dimension(548, 400));
        jfMainMenu.setPreferredSize(new Dimension(548, 400));
        jfMainMenu.setSize(new Dimension(548, 400));
        jfMainMenu.getContentPane().setLayout(null);

        jlWelcome.setBackground(new Color(255, 255, 255));
        jlWelcome.setFont(new Font("Tahoma", 0, 20)); // NOI18N
        jlWelcome.setForeground(new Color(255, 102, 0));
        jlWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        jlWelcome.setText("Welcome to Eclipse Food Ordering and Delivery System");
        jfMainMenu.getContentPane().add(jlWelcome);
        jlWelcome.setBounds(10, 30, 510, 41);
        jlWelcome.setBackground(new Color(0,204,204));
        jlWelcome.setOpaque(true);

        jbRegister.setText("Register");
        jbRegister.setActionCommand("Register");
        jbRegister.addActionListener(this);
        jfMainMenu.getContentPane().add(jbRegister);
        jbRegister.setBounds(280, 140, 224, 39);

        jbLogin.setText("Login");
        jbLogin.setActionCommand("Login");
        jbLogin.addActionListener(this);
        jfMainMenu.getContentPane().add(jbLogin);
        jbLogin.setBounds(280, 200, 224, 39);

        jlBackground.setIcon(new ImageIcon("Background.jpg")); // NOI18N
        jlBackground.setText("jLabel1");
        jfMainMenu.getContentPane().add(jlBackground);
        jlBackground.setBounds(0, 0, 550, 375);

        jfMainMenu.pack();
        jfMainMenu.setLocationRelativeTo(null);
        jfMainMenu.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        jfMainMenu.dispose();
        if(ae.getActionCommand().equals("Register")) {
            GUIRegister guiRegister = new GUIRegister();
        }
        else if(ae.getActionCommand().equals("Login")) {
            GUILogin guiLogin = new GUILogin();
        }
    }
    
    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        SwingUtilities.invokeLater(new Runnable() {
           public void run() {
               new GUIFoodOrderDelivery();
           } 
        });
    }
}
