package FoodOrderDeliveryGUI;
import java.awt.event.*;
import javax.swing.*;

//@author Asyraf

public class GUIUsername implements ActionListener {
    JFrame jfUsername = new JFrame("Change Username");
    JButton cancelB;
    JButton changeB;
    JTextField newUsernameF;
    JPasswordField passwordF;
    JLabel passwordL;
    JLabel usernameL;
    long currentUser;
    
    void setCurrentUser(long u) {
        currentUser = u;
    }
    
    GUIUsername() {
        passwordL = new JLabel();
        passwordF = new JPasswordField();
        usernameL = new JLabel();
        newUsernameF = new JTextField();
        cancelB = new JButton();
        changeB = new JButton();

        jfUsername.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfUsername.setResizable(true);

        passwordL.setText("Password :");
        passwordL.setToolTipText("");

        usernameL.setText("New username :");

        cancelB.setText("Cancel");
        cancelB.setActionCommand("Cancel");
        cancelB.addActionListener(this);

        changeB.setText("Change Username");
        changeB.setActionCommand("Change");
        changeB.addActionListener(this);

        GroupLayout layout = new GroupLayout(jfUsername.getContentPane());
        jfUsername.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(usernameL, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordL, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(newUsernameF, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordF, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelB, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(changeB)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameL, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                    .addComponent(newUsernameF, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
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

        jfUsername.pack();
        jfUsername.setLocationRelativeTo(null);
        jfUsername.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Change")) {
            User u1 = new User();
            java.util.List<String> users = u1.load();
            if(users.indexOf("Username : " + newUsernameF.getText()) != -1) {
                JOptionPane.showMessageDialog(jfUsername, "User already exists!", "User Exists", JOptionPane.WARNING_MESSAGE);
            }
            else {
                u1.setPassword(new String(passwordF.getPassword()));
                int lineNumber = users.indexOf("User ID : " + currentUser);
                u1.setUsername(users.get(lineNumber + 1).substring(11));
                if(u1.verifyPassword() == true) {
                    u1.setCurrentUser(currentUser);
                    users.set(lineNumber + 1, "Username : " + newUsernameF.getText());
                    u1.write(users);
                    
                    JOptionPane.showMessageDialog(jfUsername, "Username successfully changed!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    jfUsername.dispose();
                    GUIDetails guiDetails = new GUIDetails();
                    guiDetails.setCurrentUser(currentUser);
                }
                else {
                    JOptionPane.showMessageDialog(jfUsername, "Incorrect password!", "Wrong Password", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        else {
            jfUsername.dispose();
            GUIDetails guiDetails = new GUIDetails();
            guiDetails.setCurrentUser(currentUser);
        }
    }
}
