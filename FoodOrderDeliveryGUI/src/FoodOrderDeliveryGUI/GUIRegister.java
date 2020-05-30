package FoodOrderDeliveryGUI;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

//@author Asyraf

public class GUIRegister implements ActionListener, KeyListener {
    JFrame jfRegister = new JFrame("Register");
    JPasswordField jpfPassword;
    JPasswordField jpfConfirmPassword;
    JTextField jtfUsername;
    JTextField jtfEmail;
    JTextField jtfAddress;
    JTextField jtfNumber;
    JButton jbCancel;
    JButton jbRegister;
    JLabel jlAddress;
    JLabel jlConfirmPassword;
    JLabel jlEmail;
    JLabel jlNumber;
    JLabel jlPassword;
    JLabel jlUsername;
    
    GUIRegister() {
        jpfPassword = new JPasswordField();
        jpfConfirmPassword = new JPasswordField();
        jtfUsername = new JTextField();
        jtfEmail = new JTextField();
        jtfAddress = new JTextField();
        jtfNumber = new JTextField();
        jbCancel = new JButton();
        jbRegister = new JButton();
        jlAddress = new JLabel();
        jlConfirmPassword = new JLabel();
        jlEmail = new JLabel();
        jlNumber = new JLabel();
        jlPassword = new JLabel();
        jlUsername = new JLabel();

        jfRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfRegister.setResizable(true);

        jlUsername.setText("Username :");
        jlEmail.setText("Email :");
        jlPassword.setText("Password :");
        jlConfirmPassword.setText("Confirm password :");
        jlAddress.setText("Address :");
        jlNumber.setText("Phone number :");
        jtfNumber.addKeyListener(this);

        jbCancel.setText("Cancel");
        jbCancel.setActionCommand("Cancel");
        jbCancel.addActionListener(this);
        
        jbRegister.setText("Register");
        jbRegister.setActionCommand("Register");
        jbRegister.addActionListener(this);

        GroupLayout layout = new GroupLayout(jfRegister.getContentPane());
        jfRegister.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlAddress, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlUsername, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlEmail, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlPassword, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlConfirmPassword, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlNumber, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfUsername)
                            .addComponent(jtfEmail)
                            .addComponent(jpfPassword)
                            .addComponent(jpfConfirmPassword)
                            .addComponent(jtfAddress)
                            .addComponent(jtfNumber, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jbCancel, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jbRegister, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfUsername, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jlUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfEmail)
                    .addComponent(jlEmail, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpfPassword)
                    .addComponent(jlPassword, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpfConfirmPassword)
                    .addComponent(jlConfirmPassword, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfAddress)
                    .addComponent(jlAddress, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlNumber, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jtfNumber))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbRegister, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jfRegister.pack();
        jfRegister.setLocationRelativeTo(null);
        jfRegister.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Register")) {
            if(Arrays.equals(jpfPassword.getPassword(), jpfConfirmPassword.getPassword())) {
                User u1 = new User();
                java.util.List<String> users = u1.load();
                if(u1.existUser(users ,jtfUsername.getText())) {
                    int choice = JOptionPane.showConfirmDialog(jfRegister, "User already exists!\nDo you want to log in?", "User Exists", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if(choice == JOptionPane.YES_OPTION) {
                        jfRegister.dispose();
                        GUILogin guiLogin = new GUILogin();
                    }
                }
                else {
                    if(u1.existUser(users, jtfEmail.getText())) {
                        JOptionPane.showMessageDialog(jfRegister, "User with that email already exists", "Email In Use", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                        u1.setUsername(jtfUsername.getText());
                        u1.setEmail(jtfEmail.getText());
                        u1.setPassword(new String(jpfPassword.getPassword()));
                        u1.setAddress(jtfAddress.getText());
                        u1.setPhoneNumber(jtfNumber.getText());
                        u1.register();
                        JOptionPane.showMessageDialog(jfRegister, "User registered!\nYou can now log in.", "Success", JOptionPane.INFORMATION_MESSAGE);
                        
                        jfRegister.dispose();
                        GUILogin guiLogin = new GUILogin();
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(jfRegister, "Password is not similar!", "Different Password", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(ae.getActionCommand().equals("Cancel")) {
            jfRegister.dispose();
            GUIFoodOrderDelivery guiMainMenu = new GUIFoodOrderDelivery();
        }
    }
    
    public void keyTyped(KeyEvent evt) {                    
        char number = evt.getKeyChar();
        
        if(! (Character.isDigit(number) || number < 0 ) )
        {
            evt.consume();
        }
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
