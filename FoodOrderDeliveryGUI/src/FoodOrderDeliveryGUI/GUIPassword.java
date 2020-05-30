package FoodOrderDeliveryGUI;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

//@author Asyraf

public class GUIPassword implements ActionListener {
    JFrame jfPassword = new JFrame("Change Password");
    JButton cancelB;
    JButton changePassB;
    JPasswordField passwordF;
    JPasswordField newPassF;
    JPasswordField confirmPassF;
    JLabel currentPassL;
    JLabel newPassL;
    JLabel confirmPassL;
    long currentUser;
    
    void setCurrentUser(long u) {
        currentUser = u;
    }
    
    GUIPassword() {
        newPassL = new JLabel();
        newPassF = new JPasswordField();
        currentPassL = new JLabel();
        cancelB = new JButton();
        changePassB = new JButton();
        passwordF = new JPasswordField();
        confirmPassL = new JLabel();
        confirmPassF = new JPasswordField();

        jfPassword.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfPassword.setResizable(true);

        newPassL.setText("New password :");
        newPassL.setToolTipText("");

        currentPassL.setText("Current password :");
        currentPassL.setToolTipText("");

        cancelB.setText("Cancel");
        cancelB.setActionCommand("Cancel");
        cancelB.addActionListener(this);

        changePassB.setText("Change Password");
        changePassB.setActionCommand("Change");
        changePassB.addActionListener(this);

        confirmPassL.setText("Confirm password :");

        GroupLayout layout = new GroupLayout(jfPassword.getContentPane());
        jfPassword.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(cancelB, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(changePassB)
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(newPassL, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(currentPassL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(confirmPassL, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(newPassF, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(passwordF, GroupLayout.Alignment.LEADING)
                            .addComponent(confirmPassF))))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(currentPassL, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordF, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(newPassL, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPassF, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmPassL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(confirmPassF, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelB, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(changePassB, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jfPassword.pack();
        jfPassword.setLocationRelativeTo(null);
        jfPassword.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Change")) {
            User u1 = new User();
            java.util.List<String> users = u1.load();
            u1.setPassword(new String(passwordF.getPassword()));
            int lineNumber = users.indexOf("User ID : " + currentUser);
            u1.setUsername(users.get(lineNumber + 1).substring(11));
            if(u1.verifyPassword() == true) {
                if(Arrays.equals(newPassF.getPassword(), confirmPassF.getPassword())) {
                    u1.setPassword(new String(newPassF.getPassword()));
                    users.set(lineNumber, users.get(lineNumber).substring(0, 23) + u1.getPassword().length());
                    u1.encrypt(u1.getPassword());
                    users.set(lineNumber + 3, "Password : " + u1.getPassword());
                    u1.setCurrentUser(Long.parseLong(users.get(lineNumber).substring(10)));
                    u1.write(users);
                    
                    currentUser = u1.getCurrentUser();
                    JOptionPane.showMessageDialog(jfPassword, "Password successfully changed!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    jfPassword.dispose();
                    GUIDetails guiDetails = new GUIDetails();
                    guiDetails.setCurrentUser(currentUser);
                }
                else {
                    JOptionPane.showMessageDialog(jfPassword, "Password is not similar!", "Different Password", JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(jfPassword, "Incorrect password!", "Wrong Password", JOptionPane.WARNING_MESSAGE);
            }
        }
        else {
            jfPassword.dispose();
            GUIDetails guiDetails = new GUIDetails();
        }
    }
}
