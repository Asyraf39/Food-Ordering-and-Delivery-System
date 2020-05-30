package FoodOrderDeliveryGUI;
import java.awt.event.*;
import javax.swing.*;

//@author Asyraf

public class GUIDetails implements ActionListener {
    JFrame jfDetails = new JFrame("Change Details");
    JButton nameB;
    JButton emailB;
    JButton passB;
    JButton addressB;
    JButton phoneB;
    JButton deactivateB;
    JButton backB;
    long currentUser;
    
    void setCurrentUser(long u) {
        currentUser = u;
    }
    
    GUIDetails() {
        passB = new JButton();
        nameB = new JButton();
        addressB = new JButton();
        emailB = new JButton();
        phoneB = new JButton();
        deactivateB = new JButton();
        backB = new JButton();

        jfDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfDetails.setResizable(true);

        nameB.setText("Change Username");
        nameB.setActionCommand("Username");
        nameB.addActionListener(this);
        
        emailB.setText("Change Email");
        emailB.setActionCommand("Email");
        emailB.addActionListener(this);

        passB.setText("Change Password");
        passB.setActionCommand("Password");
        passB.addActionListener(this);

        addressB.setText("Change Address");
        addressB.setActionCommand("Address");
        addressB.addActionListener(this);

        phoneB.setText("Change Phone Number");
        phoneB.setActionCommand("Number");
        phoneB.addActionListener(this);

        deactivateB.setText("Deactivate Account");
        deactivateB.setActionCommand("Deactivate");
        deactivateB.addActionListener(this);

        backB.setText("Back");
        backB.setActionCommand("Back");
        backB.addActionListener(this);

        GroupLayout layout = new GroupLayout(jfDetails.getContentPane());
        jfDetails.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(phoneB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deactivateB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addressB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameB, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(nameB, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(emailB, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(passB, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addressB, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(phoneB, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deactivateB, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backB, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jfDetails.pack();
        jfDetails.setLocationRelativeTo(null);
        jfDetails.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Username":
                jfDetails.dispose();
                GUIUsername guiUsername = new GUIUsername();
                guiUsername.setCurrentUser(currentUser);
                break;
            case "Email":
                jfDetails.dispose();
                GUIEmail guiEmail = new GUIEmail();
                guiEmail.setCurrentUser(currentUser);
                break;
            case "Password":
                jfDetails.dispose();
                GUIPassword guiPassword = new GUIPassword();
                guiPassword.setCurrentUser(currentUser);
                break;
            case "Address":
                jfDetails.dispose();
                GUIAddress guiAddress = new GUIAddress();
                guiAddress.setCurrentUser(currentUser);
                break;
            case "Number":
                jfDetails.dispose();
                GUIPhoneNumber guiPhoneNumber = new GUIPhoneNumber();
                guiPhoneNumber.setCurrentUser(currentUser);
                break;
            case "Deactivate":
                int choice = JOptionPane.showConfirmDialog(jfDetails, "Account deactivation is permanent and cannot be reversed\n"
                                                        + "Do you want to proceed with this action?", "Deactivate Account", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(choice == JOptionPane.YES_OPTION) {
                    User u1 = new User();
                    u1.setCurrentUser(currentUser);
                    u1.deactivate();
                    
                    jfDetails.dispose();
                    JOptionPane.showMessageDialog(jfDetails, "Account deactivated\n"
                                                + "You will be returned to the menu", "Success", JOptionPane.INFORMATION_MESSAGE);
                    GUIFoodOrderDelivery guiMainMenu = new GUIFoodOrderDelivery();
                }
                break;
            default:
                jfDetails.dispose();
                GUIUser guiMenu = new GUIUser();
                break;
        }
    }
}
