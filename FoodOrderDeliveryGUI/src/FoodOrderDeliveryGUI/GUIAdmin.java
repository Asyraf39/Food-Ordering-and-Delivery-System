package FoodOrderDeliveryGUI;
import java.awt.event.*;
import javax.swing.*;

//@author Asyraf

public class GUIAdmin implements ActionListener {
    JFrame jfAdmin = new JFrame("Admin Menu");              
    JButton jbLogOut;
    JButton jbManageMenu;
    
    GUIAdmin() {
        jbManageMenu = new JButton();
        jbLogOut = new JButton();

        jfAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfAdmin.setResizable(true);

        jbManageMenu.setText("Manage menu");
        jbManageMenu.setActionCommand("Manage");
        jbManageMenu.addActionListener(this);

        jbLogOut.setText("Log out");
        jbLogOut.setActionCommand("Log out");
        jbLogOut.addActionListener(this);

        GroupLayout layout = new GroupLayout(jfAdmin.getContentPane());
        jfAdmin.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbManageMenu, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(jbLogOut, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jbManageMenu, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbLogOut, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jfAdmin.pack();
        jfAdmin.setLocationRelativeTo(null);
        jfAdmin.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        jfAdmin.dispose();
        if(ae.getActionCommand().equals("Manage")) {
            GUIManage guiManage = new GUIManage();
        }
        else {
            GUIFoodOrderDelivery jfMainMenu = new GUIFoodOrderDelivery();
        }
    }
}
