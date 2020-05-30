package FoodOrderDeliveryGUI;
import java.awt.event.*;
import javax.swing.*;

//@author Asyraf

public class GUIPhoneNumber implements ActionListener, KeyListener {
    JFrame jfNumber = new JFrame("Change Phone Number");
    JButton cancelB;
    JButton changeB;
    JTextField newNumberF;
    JPasswordField passwordF;
    JLabel passwordL;
    JLabel numberL;
    long currentUser;
    
    void setCurrentUser(long u) {
        currentUser = u;
    }
    
    GUIPhoneNumber() {
        passwordL = new JLabel();
        passwordF = new JPasswordField();
        numberL = new JLabel();
        newNumberF = new JTextField();
        cancelB = new JButton();
        changeB = new JButton();

        jfNumber.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfNumber.setResizable(true);

        passwordL.setText("Password :");

        numberL.setText("New phone number :");
        newNumberF.addKeyListener(this);

        cancelB.setText("Cancel");
        cancelB.setActionCommand("Cancel");
        cancelB.addActionListener(this);

        changeB.setText("Change Phone Number");
        changeB.setActionCommand("Change");
        changeB.addActionListener(this);

        GroupLayout layout = new GroupLayout(jfNumber.getContentPane());
        jfNumber.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(numberL, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordL, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(newNumberF, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(numberL, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                    .addComponent(newNumberF, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
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

        jfNumber.pack();
        jfNumber.setLocationRelativeTo(null);
        jfNumber.setVisible(true);
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
                users.set(lineNumber + 5, "Phone number : " + newNumberF.getText());
                u1.write(users);

                JOptionPane.showMessageDialog(jfNumber, "Phone number successfully changed!", "Success", JOptionPane.INFORMATION_MESSAGE);
                jfNumber.dispose();
                GUIDetails guiDetails = new GUIDetails();
                guiDetails.setCurrentUser(currentUser);
            }
            else {
                JOptionPane.showMessageDialog(jfNumber, "Incorrect password!", "Wrong Password", JOptionPane.WARNING_MESSAGE);
            }
        }
        else {
            jfNumber.dispose();
            GUIDetails guiDetails = new GUIDetails();
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
