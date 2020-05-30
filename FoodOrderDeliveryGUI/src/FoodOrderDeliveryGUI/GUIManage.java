package FoodOrderDeliveryGUI;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

//@author Asyraf

public class GUIManage implements ActionListener {
    JFrame jfManage = new JFrame("Manage");
    JButton cancelB;
    JButton saveB;
    JTextField dItem1F;
    JTextField dItem2F;
    JTextField dItem3F;
    JTextField dItem4F;
    JTextField dItem5F;
    JTextField dItem6F;
    JTextField dPrice1F;
    JTextField dPrice2F;
    JTextField dPrice3F;
    JTextField dPrice4F;
    JTextField dPrice5F;
    JTextField dPrice6F;
    JTextField fItem1F;
    JTextField fItem2F;
    JTextField fItem3F;
    JTextField fItem4F;
    JTextField fItem5F;
    JTextField fItem6F;
    JTextField fPrice1F;
    JTextField fPrice2F;
    JTextField fPrice3F;
    JTextField fPrice4F;
    JTextField fPrice5F;
    JTextField fPrice6F;
    JTextField sItem1F;
    JTextField sItem2F;
    JTextField sItem3F;
    JTextField sPrice1F;
    JTextField sPrice2F;
    JTextField sPrice3F;
    JLabel sItemL;
    JLabel sPriceL;
    JLabel fItemL;
    JLabel fPriceL;
    JLabel dItemL;
    JLabel dPriceL;
    JTabbedPane menuTP;
    JPanel foodP;
    JPanel drinkP;
    JPanel dessertP;
    
    GUIManage() {
        menuTP = new JTabbedPane();
        foodP = new JPanel();
        fItem1F = new JTextField();
        fItem2F = new JTextField();
        fItem3F = new JTextField();
        fItem4F = new JTextField();
        fItem5F = new JTextField();
        fItem6F = new JTextField();
        fItemL = new JLabel();
        fPriceL = new JLabel();
        fPrice1F = new JTextField();
        fPrice2F = new JTextField();
        fPrice3F = new JTextField();
        fPrice4F = new JTextField();
        fPrice5F = new JTextField();
        fPrice6F = new JTextField();
        drinkP = new JPanel();
        dItem1F = new JTextField();
        dItem2F = new JTextField();
        dItem3F = new JTextField();
        dItem4F = new JTextField();
        dItem5F = new JTextField();
        dItem6F = new JTextField();
        dItemL = new JLabel();
        dPriceL = new JLabel();
        dPrice1F = new JTextField();
        dPrice2F = new JTextField();
        dPrice3F = new JTextField();
        dPrice4F = new JTextField();
        dPrice5F = new JTextField();
        dPrice6F = new JTextField();
        dessertP = new JPanel();
        sItem1F = new JTextField();
        sItem2F = new JTextField();
        sItem3F = new JTextField();
        sItemL = new JLabel();
        sPriceL = new JLabel();
        sPrice1F = new JTextField();
        sPrice2F = new JTextField();
        sPrice3F = new JTextField();
        saveB = new JButton();
        cancelB = new JButton();

        jfManage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfManage.setResizable(true);

        fItem1F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        fItem2F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        fItem3F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        fItem4F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        fItem5F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        fItem6F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        fItemL.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        fItemL.setText("Item");

        fPriceL.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        fPriceL.setText("Price");

        fPrice1F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        fPrice2F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        fPrice3F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        fPrice4F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        fPrice5F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        fPrice6F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        GroupLayout foodPLayout = new GroupLayout(foodP);
        foodP.setLayout(foodPLayout);
        foodPLayout.setHorizontalGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(foodPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(fItemL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fItem1F, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(fItem2F, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(fItem3F, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(fItem4F, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(fItem5F, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(fItem6F, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(fPriceL, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(fPrice1F)
                    .addComponent(fPrice2F)
                    .addComponent(fPrice3F)
                    .addComponent(fPrice4F)
                    .addComponent(fPrice5F)
                    .addComponent(fPrice6F))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        foodPLayout.setVerticalGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(foodPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(fPriceL, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(fItemL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(fPrice1F)
                    .addComponent(fItem1F, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(fPrice2F)
                    .addComponent(fItem2F, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(fPrice3F)
                    .addComponent(fItem3F, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(fPrice4F)
                    .addComponent(fItem4F, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(fPrice5F)
                    .addComponent(fItem5F, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(fItem6F, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(fPrice6F))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuTP.addTab("Food", foodP);

        dItem1F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        dItem2F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        dItem3F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        dItem4F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        dItem5F.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        dItem5F.setToolTipText("");

        dItem6F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        dItemL.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        dItemL.setText("Item");

        dPriceL.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        dPriceL.setText("Price");

        dPrice1F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        dPrice2F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        dPrice3F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        dPrice4F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        dPrice5F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        dPrice6F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        GroupLayout drinkPLayout = new GroupLayout(drinkP);
        drinkP.setLayout(drinkPLayout);
        drinkPLayout.setHorizontalGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(drinkPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dItemL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dItem1F, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(dItem2F, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(dItem3F, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(dItem4F, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(dItem5F, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(dItem6F, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(dPriceL, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(dPrice1F)
                    .addComponent(dPrice2F)
                    .addComponent(dPrice3F)
                    .addComponent(dPrice4F)
                    .addComponent(dPrice5F)
                    .addComponent(dPrice6F))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        drinkPLayout.setVerticalGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(drinkPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(dPriceL, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(dItemL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(dPrice1F)
                    .addComponent(dItem1F, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(dPrice2F)
                    .addComponent(dItem2F, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(dPrice3F)
                    .addComponent(dItem3F, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(dPrice4F)
                    .addComponent(dItem4F, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(dPrice5F)
                    .addComponent(dItem5F, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(dItem6F, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(dPrice6F))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuTP.addTab("Drink", drinkP);

        sItem1F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        sItem2F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        sItem3F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        sItemL.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        sItemL.setText("Item");

        sPriceL.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        sPriceL.setText("Price");

        sPrice1F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        sPrice2F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        sPrice3F.setFont(new Font("Tahoma", 0, 12)); // NOI18N

        GroupLayout dessertPLayout = new GroupLayout(dessertP);
        dessertP.setLayout(dessertPLayout);
        dessertPLayout.setHorizontalGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(dessertPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(sItemL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sItem1F, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(sItem2F, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(sItem3F, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(sPriceL, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(sPrice1F)
                    .addComponent(sPrice2F)
                    .addComponent(sPrice3F))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        dessertPLayout.setVerticalGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(dessertPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(sPriceL, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(sItemL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(sPrice1F)
                    .addComponent(sItem1F, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(sPrice2F)
                    .addComponent(sItem2F, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(sPrice3F)
                    .addComponent(sItem3F, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        menuTP.addTab("Dessert", dessertP);

        saveB.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        saveB.setText("Save");
        saveB.setActionCommand("Save");
        saveB.addActionListener(this);

        cancelB.setFont(new Font("Tahoma", 0, 12)); // NOI18N
        cancelB.setText("Cancel");
        cancelB.setActionCommand("Cancel");
        cancelB.addActionListener(this);

        GroupLayout layout = new GroupLayout(jfManage.getContentPane());
        jfManage.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuTP, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(saveB, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelB))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuTP)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(saveB, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(cancelB, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jfManage.pack();
        jfManage.setLocationRelativeTo(null);
        jfManage.setVisible(true);
        load();
    }
    
    void load() {
        Menu m1 = new Menu();
        java.util.List<String> menu = m1.load();
        fItem1F.setText(menu.get(1).substring(0, 16).trim());
        fItem2F.setText(menu.get(2).substring(0, 16).trim());
        fItem3F.setText(menu.get(3).substring(0, 16).trim());
        fItem4F.setText(menu.get(4).substring(0, 16).trim());
        fItem5F.setText(menu.get(5).substring(0, 16).trim());
        fItem6F.setText(menu.get(6).substring(0, 16).trim());
        
        dItem1F.setText(menu.get(9).substring(0, 16).trim());
        dItem2F.setText(menu.get(10).substring(0, 16).trim());
        dItem3F.setText(menu.get(11).substring(0, 16).trim());
        dItem4F.setText(menu.get(12).substring(0, 16).trim());
        dItem5F.setText(menu.get(13).substring(0, 16).trim());
        dItem6F.setText(menu.get(14).substring(0, 16).trim());
        
        sItem1F.setText(menu.get(17).substring(0, 16).trim());
        sItem2F.setText(menu.get(18).substring(0, 16).trim());
        sItem3F.setText(menu.get(19).substring(0, 16).trim());
        
        fPrice1F.setText(menu.get(1).substring(21));
        fPrice2F.setText(menu.get(2).substring(21));
        fPrice3F.setText(menu.get(3).substring(21));
        fPrice4F.setText(menu.get(4).substring(21));
        fPrice5F.setText(menu.get(5).substring(21));
        fPrice6F.setText(menu.get(6).substring(21));
        
        dPrice1F.setText(menu.get(9).substring(21));
        dPrice2F.setText(menu.get(10).substring(21));
        dPrice3F.setText(menu.get(11).substring(21));
        dPrice4F.setText(menu.get(12).substring(21));
        dPrice5F.setText(menu.get(13).substring(21));
        dPrice6F.setText(menu.get(14).substring(21));
        
        sPrice1F.setText(menu.get(17).substring(21));
        sPrice2F.setText(menu.get(18).substring(21));
        sPrice3F.setText(menu.get(19).substring(21));
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Save")) {
            Menu m1 = new Menu();
            java.util.List<String> menu = new ArrayList<>();
            menu.add("Food            | Price");
            menu.add(String.format("%-16s", fItem1F.getText()) + "| RM " + String.format("%.2f", Double.parseDouble(fPrice1F.getText())));
            menu.add(String.format("%-16s", fItem2F.getText()) + "| RM " + String.format("%.2f", Double.parseDouble(fPrice2F.getText())));
            menu.add(String.format("%-16s", fItem3F.getText()) + "| RM " + String.format("%.2f", Double.parseDouble(fPrice3F.getText())));
            menu.add(String.format("%-16s", fItem4F.getText()) + "| RM " + String.format("%.2f", Double.parseDouble(fPrice4F.getText())));
            menu.add(String.format("%-16s", fItem5F.getText()) + "| RM " + String.format("%.2f", Double.parseDouble(fPrice5F.getText())));
            menu.add(String.format("%-16s", fItem6F.getText()) + "| RM " + String.format("%.2f", Double.parseDouble(fPrice6F.getText())));
            menu.add("");
            menu.add("Drink           | Price");
            menu.add(String.format("%-16s", dItem1F.getText()) + "| RM " + String.format("%.2f", Double.parseDouble(dPrice1F.getText())));
            menu.add(String.format("%-16s", dItem2F.getText()) + "| RM " + String.format("%.2f", Double.parseDouble(dPrice2F.getText())));
            menu.add(String.format("%-16s", dItem3F.getText()) + "| RM " + String.format("%.2f", Double.parseDouble(dPrice3F.getText())));
            menu.add(String.format("%-16s", dItem4F.getText()) + "| RM " + String.format("%.2f", Double.parseDouble(dPrice4F.getText())));
            menu.add(String.format("%-16s", dItem5F.getText()) + "| RM " + String.format("%.2f", Double.parseDouble(dPrice5F.getText())));
            menu.add(String.format("%-16s", dItem6F.getText()) + "| RM " + String.format("%.2f", Double.parseDouble(dPrice6F.getText())));
            menu.add("");
            menu.add("Dessert         | Price");
            menu.add(String.format("%-16s", sItem1F.getText()) + "| RM " + String.format("%.2f", Double.parseDouble(sPrice1F.getText())));
            menu.add(String.format("%-16s", sItem2F.getText()) + "| RM " + String.format("%.2f", Double.parseDouble(sPrice2F.getText())));
            menu.add(String.format("%-16s", sItem3F.getText()) + "| RM " + String.format("%.2f", Double.parseDouble(sPrice3F.getText())));
            m1.write(menu);
            
            JOptionPane.showMessageDialog(jfManage, "Menu changed successfull!", "Success", JOptionPane.INFORMATION_MESSAGE);
            jfManage.dispose();
            new GUIAdmin();
        }
        else {
            jfManage.dispose();
            new GUIAdmin();
        }
    }
}
