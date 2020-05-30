package FoodOrderDeliveryGUI;
import java.awt.event.*;
import javax.swing.*;

//@author Asyraf

public class GUIEmail implements ActionListener {
    JFrame jfEmail = new JFrame("Change Email");
    JButton cancelB;
    JButton changeB;
    JTextField newEmailF;
    JPasswordField passwordF;
    JLabel passwordL;
    JLabel emailL;
    long currentUser;
    
    void setCurrentUser(long u) {
        currentUser = u;
    }
    
    GUIEmail() {
        passwordL = new JLabel();
        passwordF = new JPasswordField();
        emailL = new JLabel();
        newEmailF = new JTextField();
        cancelB = new JButton();
        changeB = new JButton();

        jfEmail.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfEmail.setResizable(true);

        passwordL.setText("Password :");
        passwordL.setToolTipText("");

        emailL.setText("New email :");

        cancelB.setText("Cancel");
        cancelB.setActionCommand("Cancel");
        cancelB.addActionListener(this);

        changeB.setText("Change Email");
        changeB.setActionCommand("Change");
        changeB.addActionListener(this);

        GroupLayout layout = new GroupLayout(jfEmail.getContentPane());
        jfEmail.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(emailL, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordL, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(newEmailF, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(emailL, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                    .addComponent(newEmailF, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
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

        jfEmail.pack();
        jfEmail.setLocationRelativeTo(null);
        jfEmail.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Change")) {
            User u1 = new User();
            java.util.List<String> users = u1.load();
            if(users.indexOf("Email : " + newEmailF.getText()) != -1) {
                JOptionPane.showMessageDialog(jfEmail, "Email already in use!", "Email In Use", JOptionPane.WARNING_MESSAGE);
            }
            else {
                u1.setPassword(new String(passwordF.getPassword()));
                int lineNumber = users.indexOf("User ID : " + currentUser);
                u1.setUsername(users.get(lineNumber + 1).substring(11));
                if(u1.verifyPassword() == true) {
                    u1.setCurrentUser(currentUser);
                    users.set(lineNumber + 2, "Email : " + newEmailF.getText());
                    u1.write(users);
                    
                    JOptionPane.showMessageDialog(jfEmail, "Email successfully changed!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    jfEmail.dispose();
                    GUIDetails guiDetails = new GUIDetails();
                    guiDetails.setCurrentUser(currentUser);
                }
                else {
                    JOptionPane.showMessageDialog(jfEmail, "Incorrect password!", "Wrong Password", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        else {
            jfEmail.dispose();
            GUIDetails guiDetails = new GUIDetails();
            guiDetails.setCurrentUser(currentUser);
        }
    }
}
