package FoodOrderDeliveryGUI;
import java.awt.event.*;
import javax.swing.*;

//@author Asyraf

public class GUIAddress implements ActionListener {
    JFrame jfAddress = new JFrame("Change Address");
    JButton cancelB;
    JButton changeB;
    JTextField newAddressF;
    JPasswordField passwordF;
    JLabel passwordL;
    JLabel addressL;
    long currentUser;
    
    void setCurrentUser(long u) {
        currentUser = u;
    }
    
    GUIAddress() {
        passwordL = new JLabel();
        passwordF = new JPasswordField();
        addressL = new JLabel();
        newAddressF = new JTextField();
        cancelB = new JButton();
        changeB = new JButton();

        jfAddress.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfAddress.setResizable(true);

        passwordL.setText("Password :");
        passwordL.setToolTipText("");

        addressL.setText("New address :");

        cancelB.setText("Cancel");
        cancelB.setActionCommand("Cancel");
        cancelB.addActionListener(this);

        changeB.setText("Change Address");
        changeB.setActionCommand("Change");
        changeB.addActionListener(this);

        GroupLayout layout = new GroupLayout(jfAddress.getContentPane());
        jfAddress.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(addressL, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordL, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(newAddressF, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordF, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelB, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(changeB)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addressL, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                    .addComponent(newAddressF, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordL, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordF, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(changeB, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelB, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jfAddress.pack();
        jfAddress.setLocationRelativeTo(null);
        jfAddress.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Change")) {
            User u1 = new User();
            java.util.List<String> users = u1.load();
            u1.setPassword(new String(passwordF.getPassword()));
            int lineNumber = users.indexOf("User ID : " + currentUser);
            u1.setUsername(users.get(lineNumber + 1).substring(11));
            if(u1.verifyPassword() == true) {
                u1.setCurrentUser(currentUser);
                users.set(lineNumber + 4, "Address : " + newAddressF.getText());
                u1.write(users);

                JOptionPane.showMessageDialog(jfAddress, "Address successfully changed!", "Success", JOptionPane.INFORMATION_MESSAGE);
                jfAddress.dispose();
                GUIDetails guiDetails = new GUIDetails();
                guiDetails.setCurrentUser(currentUser);
            }
            else {
                JOptionPane.showMessageDialog(jfAddress, "Incorrect password!", "Wrong Password", JOptionPane.WARNING_MESSAGE);
            }
        }
        else {
            jfAddress.dispose();
            GUIDetails guiDetails = new GUIDetails();
            guiDetails.setCurrentUser(currentUser);
        }
    }
}
