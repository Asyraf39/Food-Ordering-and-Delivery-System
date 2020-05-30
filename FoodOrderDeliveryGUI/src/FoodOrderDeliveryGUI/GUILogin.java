package FoodOrderDeliveryGUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//@author Asyraf

public class GUILogin implements ActionListener {
    JFrame jfLogin = new JFrame("Login");
    JButton jbCancel;
    JButton jbLogin;
    JLabel jlPassword;
    JLabel jlUsername;
    JPasswordField jpfPassword;
    JTextField jtfUsername;
    long currentUser;
    
    GUILogin() {
        jbCancel = new JButton();
        jbLogin = new JButton();
        jlPassword = new JLabel();
        jlUsername = new JLabel();
        jpfPassword = new JPasswordField();
        jtfUsername = new JTextField();
        
        jfLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfLogin.setResizable(true);

        jlUsername.setFont(new Font("Tahoma", 0, 12));
        jlUsername.setText("Username :");

        jlPassword.setFont(new Font("Tahoma", 0, 12));
        jlPassword.setText("Password :");

        jtfUsername.setFont(new Font("Tahoma", 0, 12));

        jpfPassword.setFont(new Font("Tahoma", 0, 12));

        jbCancel.setText("Cancel");
        jbCancel.setActionCommand("Cancel");
        jbCancel.addActionListener(this);

        jbLogin.setText("Login");
        jbLogin.setActionCommand("Login");
        jbLogin.addActionListener(this);

        GroupLayout layout = new GroupLayout(jfLogin.getContentPane());
        jfLogin.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCancel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbLogin, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfUsername)
                            .addComponent(jpfPassword, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfUsername, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jlUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlPassword, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(jpfPassword))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLogin, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jfLogin.pack();
        jfLogin.setLocationRelativeTo(null);
        jfLogin.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Login")) {
            User u1 = new User();
            
            java.util.List<String> users = u1.load();
            if(users.isEmpty() && !jtfUsername.getText().equals("admin")) {
                int choice = JOptionPane.showConfirmDialog(jfLogin, "No user exists yet!\nDo you want to register?", "No User Registered", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(choice == JOptionPane.YES_OPTION) {
                    jfLogin.dispose();
                    GUIRegister guiRegister = new GUIRegister();
                }
            }
            else {
                if(jtfUsername.getText().equals("admin")) {
                    Admin a1 = new Admin();
                    if(a1.verifyPassword(new String(jpfPassword.getPassword())) == true) {
                        JOptionPane.showMessageDialog(jfLogin, "Log in successfull!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        jfLogin.dispose();
                        GUIAdmin guiAdmin = new GUIAdmin();
                    }
                    else {
                        JOptionPane.showMessageDialog(jfLogin, "Incorrect password!", "Wrong Password", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else {
                    if(u1.existUser(users, jtfUsername.getText())) {
                        u1.setUsername(jtfUsername.getText());
                        u1.setPassword(new String(jpfPassword.getPassword()));
                        if(u1.verifyPassword() == true) {
                            u1.login();
                            currentUser = u1.getCurrentUser();
                            JOptionPane.showMessageDialog(jfLogin, "Log in successfull!", "Success", JOptionPane.INFORMATION_MESSAGE);

                            jfLogin.dispose();
                            GUIUser guiMenu = new GUIUser();
                            guiMenu.setCurrentUser(currentUser);
                        }
                        else {
                            JOptionPane.showMessageDialog(jfLogin, "Incorrect password!", "Wrong Password", JOptionPane.WARNING_MESSAGE);
                        }
                    }
                    else {
                        int choice = JOptionPane.showConfirmDialog(jfLogin, "That username is not registered!\nDo you want to register?", "No User Found", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                        if(choice == JOptionPane.YES_OPTION) {
                            jfLogin.dispose();
                            GUIRegister guiRegister = new GUIRegister();
                        }
                    }
                }
            }
        }
        else if(ae.getActionCommand().equals("Cancel")) {
            jfLogin.dispose();
            GUIFoodOrderDelivery guiMainMenu = new GUIFoodOrderDelivery();
        }
    }
}
