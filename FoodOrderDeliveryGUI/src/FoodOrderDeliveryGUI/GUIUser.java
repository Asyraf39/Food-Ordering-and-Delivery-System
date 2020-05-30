package FoodOrderDeliveryGUI;
import java.awt.event.*;
import javax.swing.*;

//@author Asyraf

public class GUIUser implements ActionListener {
    JFrame jfMenu = new JFrame("Menu");       
    JButton changeDetailsB;
    JButton logOutB;
    JButton makeOrderB;
    long currentUser;
     
    void setCurrentUser(long u) {
     
        currentUser = u;
    }
    
    GUIUser() {
        makeOrderB = new JButton();
        changeDetailsB = new JButton();
        logOutB = new JButton();

        jfMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfMenu.setResizable(true);

        makeOrderB.setText("MAKE ORDER");
        makeOrderB.setActionCommand("Order");
        makeOrderB.addActionListener(this);

        changeDetailsB.setText("CHANGE USER DETAILS");
        changeDetailsB.setActionCommand("Change");
        changeDetailsB.addActionListener(this);

        logOutB.setText("LOG OUT");
        logOutB.setActionCommand("Log Out");
        logOutB.addActionListener(this);

        GroupLayout layout = new GroupLayout(jfMenu.getContentPane());
        jfMenu.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(makeOrderB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changeDetailsB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logOutB, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(makeOrderB, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(changeDetailsB, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(logOutB, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );

        jfMenu.pack();
        jfMenu.setLocationRelativeTo(null);
        jfMenu.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        jfMenu.dispose();
        switch (ae.getActionCommand()) {
            case "Order":
                GUIMenu guiMenu = new GUIMenu();
                guiMenu.setCurrentUser(currentUser);
                break;
            case "Change":
                GUIDetails guiDetails = new GUIDetails();
                guiDetails.setCurrentUser(currentUser);
                break;
            default:
                GUIFoodOrderDelivery guiMainMenu = new GUIFoodOrderDelivery();
                break;
        }
    }
}
