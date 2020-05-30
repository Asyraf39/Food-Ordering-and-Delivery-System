package FoodOrderDeliveryGUI;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

//@author Asyraf

public class GUIMenu implements ActionListener, KeyListener {
    JFrame jfMenu = new JFrame("Menu");
    JButton cancelB;
    JButton confirmOrderB;
    JButton resetB;
    JButton totalB;
    JTextField fItem1F;
    JTextField fItem2F;
    JTextField fItem3F;
    JTextField fItem4F;
    JTextField fItem5F;
    JTextField fItem6F;
    JTextField dItem1F;
    JTextField dItem2F;
    JTextField dItem3F;
    JTextField dItem4F;
    JTextField dItem5F;
    JTextField dItem6F;
    JTextField sItem1F;
    JTextField sItem2F;
    JTextField sItem3F;
    JTextField subtotalF;
    JTextField taxF;
    JTextField chargeF;
    JTextField totalF;
    JLabel foodL;
    JLabel fItemL;
    JLabel fQuantityL;
    JLabel fPriceL;
    JLabel fPrice1L;
    JLabel fPrice2L;
    JLabel fPrice3L;
    JLabel fPrice4L;
    JLabel fPrice5L;
    JLabel fPrice6L;
    JLabel drinkL;
    JLabel dItemL;
    JLabel dQuantityL;
    JLabel dPriceL;
    JLabel dPrice1L;
    JLabel dPrice2L;
    JLabel dPrice3L;
    JLabel dPrice4L;
    JLabel dPrice5L;
    JLabel dPrice6L;
    JLabel dessertL;
    JLabel sItemL;
    JLabel sQuantityL;
    JLabel sPriceL;
    JLabel sPrice1L;
    JLabel sPrice2L;
    JLabel sPrice3L;
    JLabel subtotalL;
    JLabel taxL;
    JLabel chargeL;
    JLabel totalL;
    JCheckBox fItem1CB;
    JCheckBox fItem2CB;
    JCheckBox fItem3CB;
    JCheckBox fItem4CB;
    JCheckBox fItem5CB;
    JCheckBox fItem6CB;
    JCheckBox dItem1CB;
    JCheckBox dItem2CB;
    JCheckBox dItem3CB;
    JCheckBox dItem4CB;
    JCheckBox dItem5CB;
    JCheckBox dItem6CB;
    JCheckBox sItem1CB;
    JCheckBox sItem2CB;
    JCheckBox sItem3CB;
    JPanel foodP;
    JPanel drinkP;
    JPanel dessertP;
    JPanel totalP;
    JScrollPane receiptSP;
    JTextArea receiptA;
    
    double subtotal, total;
    double tax = 0.03;
    double deliveryFee = 4.00;
    long currentUser;
    
    void setCurrentUser(long u) {
        currentUser = u;
    }
    
    GUIMenu() {
        drinkP = new JPanel();
        drinkL = new JLabel();
        dItem1CB = new JCheckBox();
        dItem1F = new JTextField();
        dItem2CB = new JCheckBox();
        dItem2F = new JTextField();
        dItem4F = new JTextField();
        dItem5CB = new JCheckBox();
        dItem3F = new JTextField();
        dItem3CB = new JCheckBox();
        dItemL = new JLabel();
        dQuantityL = new JLabel();
        dPriceL = new JLabel();
        dItem5F = new JTextField();
        dItem6CB = new JCheckBox();
        dItem6F = new JTextField();
        dPrice1L = new JLabel();
        dPrice2L = new JLabel();
        dPrice4L = new JLabel();
        dPrice5L = new JLabel();
        dPrice6L = new JLabel();
        dPrice3L = new JLabel();
        dItem4CB = new JCheckBox();
        dessertP = new JPanel();
        dessertL = new JLabel();
        sItem1CB = new JCheckBox();
        sItem1F = new JTextField();
        sItem2CB = new JCheckBox();
        sItem2F = new JTextField();
        sItem3CB = new JCheckBox();
        sItem3F = new JTextField();
        sItemL = new JLabel();
        sQuantityL = new JLabel();
        sPriceL = new JLabel();
        sPrice1L = new JLabel();
        sPrice2L = new JLabel();
        sPrice3L = new JLabel();
        foodP = new JPanel();
        foodL = new JLabel();
        fItem1CB = new JCheckBox();
        fItem1F = new JTextField();
        fItem2CB = new JCheckBox();
        fItem2F = new JTextField();
        fItem3CB = new JCheckBox();
        fItem3F = new JTextField();
        fItem4CB = new JCheckBox();
        fItem5F = new JTextField();
        fItem5CB = new JCheckBox();
        fItemL = new JLabel();
        fQuantityL = new JLabel();
        fPriceL = new JLabel();
        fItem4F = new JTextField();
        fPrice1L = new JLabel();
        fPrice2L = new JLabel();
        fPrice3L = new JLabel();
        fPrice4L = new JLabel();
        fPrice5L = new JLabel();
        fItem6CB = new JCheckBox();
        fItem6F = new JTextField();
        fPrice6L = new JLabel();
        totalP = new JPanel();
        subtotalL = new JLabel();
        taxL = new JLabel();
        chargeL = new JLabel();
        totalL = new JLabel();
        totalB = new JButton();
        resetB = new JButton();
        taxF = new JTextField();
        subtotalF = new JTextField();
        chargeF = new JTextField();
        totalF = new JTextField();
        receiptSP = new JScrollPane();
        receiptA = new JTextArea();
        confirmOrderB = new JButton();
        cancelB = new JButton();

        jfMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfMenu.setResizable(true);
        load();

        drinkP.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));
        
        subtotalF.setEditable(false);
        taxF.setEditable(false);
        chargeF.setEditable(false);
        totalF.setEditable(false);

        drinkL.setFont(new Font("UD Digi Kyokasho N-B", 0, 36));
        drinkL.setText("DRINK");

        dItem1CB.addActionListener(this);

        dItem1F.setText("0");
        dItem1F.setEditable(false);
        dItem1F.addActionListener(this);
        dItem1F.addKeyListener(this);

        dItem2CB.addActionListener(this);

        dItem2F.setText("0");
        dItem2F.setEditable(false);
        dItem2F.addActionListener(this);
        dItem2F.addKeyListener(this);

        dItem4F.setText("0");
        dItem4F.setEditable(false);
        dItem4F.addActionListener(this);
        dItem4F.addKeyListener(this);

        dItem5CB.addActionListener(this);

        dItem3F.setText("0");
        dItem3F.setEditable(false);
        dItem3F.addActionListener(this);
        dItem3F.addKeyListener(this);

        dItem3CB.addActionListener(this);

        dItemL.setFont(new Font("UD Digi Kyokasho NK-B", 0, 18));
        dItemL.setText("Item");

        dQuantityL.setFont(new Font("UD Digi Kyokasho NK-B", 0, 18));
        dQuantityL.setText("Quantity");

        dPriceL.setFont(new Font("UD Digi Kyokasho NK-B", 0, 18));
        dPriceL.setText("Price");

        dItem5F.setText("0");
        dItem5F.setEditable(false);
        dItem5F.addActionListener(this);
        dItem5F.addKeyListener(this);

        dItem6CB.addActionListener(this);

        dItem6F.setText("0");
        dItem6F.setEditable(false);
        dItem6F.addActionListener(this);
        dItem6F.addKeyListener(this);

        dItem4CB.addActionListener(this);

        GroupLayout drinkPLayout = new GroupLayout(drinkP);
        drinkP.setLayout(drinkPLayout);
        drinkPLayout.setHorizontalGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, drinkPLayout.createSequentialGroup()
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(dItem1CB, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dItem2CB, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dItem4CB, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dItem3CB)
                    .addComponent(dItem5CB, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dItem6CB, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                    .addGroup(drinkPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dItemL, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(drinkL, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                    .addGroup(drinkPLayout.createSequentialGroup()
                        .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(drinkPLayout.createSequentialGroup()
                                    .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(dItem2F, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dItem5F, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dItem3F, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dItem6F, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dItem4F, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
                                    .addGap(96, 96, 96))
                                .addGroup(GroupLayout.Alignment.TRAILING, drinkPLayout.createSequentialGroup()
                                    .addComponent(dQuantityL, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                    .addGap(126, 126, 126)))
                            .addGroup(drinkPLayout.createSequentialGroup()
                                .addComponent(dItem1F, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(dPrice4L)
                            .addComponent(dPrice5L)
                            .addComponent(dPrice6L)
                            .addComponent(dPrice3L)
                            .addComponent(dPriceL, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                            .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(dPrice1L, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dPrice2L, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(34, 34, 34))))
        );
        drinkPLayout.setVerticalGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(drinkPLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(drinkL, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dItemL)
                    .addComponent(dQuantityL)
                    .addComponent(dPriceL, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dItem1CB, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dItem1F, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dPrice1L))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dItem2CB, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dItem2F, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dPrice2L))
                .addGap(18, 18, 18)
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dItem3CB)
                    .addComponent(dItem3F, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(dPrice3L, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dItem4CB, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dItem4F, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dPrice4L))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dItem5CB, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dItem5F, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dPrice5L))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(drinkPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(dItem6CB, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dItem6F, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(dPrice6L, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dessertP.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));

        dessertL.setFont(new Font("UD Digi Kyokasho NK-B", 0, 32)); // NOI18N
        dessertL.setText("DESSERT");

        sItem1CB.addActionListener(this);

        sItem1F.setText("0");
        sItem1F.setEditable(false);
        sItem1F.addActionListener(this);
        sItem1F.addKeyListener(this);

        sItem2CB.addActionListener(this);

        sItem2F.setText("0");
        sItem2F.setEditable(false);
        sItem2F.addActionListener(this);
        sItem2F.addKeyListener(this);

        sItem3CB.addActionListener(this);

        sItem3F.setText("0");
        sItem3F.setEditable(false);
        sItem3F.addActionListener(this);
        sItem3F.addKeyListener(this);

        sItemL.setFont(new Font("UD Digi Kyokasho NK-B", 0, 18)); // NOI18N
        sItemL.setText("Item");

        sQuantityL.setFont(new Font("UD Digi Kyokasho NK-B", 0, 18)); // NOI18N
        sQuantityL.setText("Quantity");

        sPriceL.setFont(new Font("UD Digi Kyokasho NK-B", 0, 18)); // NOI18N
        sPriceL.setText("Price");

        GroupLayout dessertPLayout = new GroupLayout(dessertP);
        dessertP.setLayout(dessertPLayout);
        dessertPLayout.setHorizontalGroup(
            dessertPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(dessertPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(sItemL, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sItem1CB, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sItem2CB)
                    .addComponent(sItem3CB, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(dessertL, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                    .addGroup(dessertPLayout.createSequentialGroup()
                        .addGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(sItem2F, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                            .addComponent(sItem1F, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                            .addComponent(sItem3F, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                            .addComponent(sQuantityL, GroupLayout.Alignment.LEADING))
                        .addGap(90, 90, 90)
                        .addGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(sPrice2L)
                                .addComponent(sPrice3L)
                                .addComponent(sPrice1L))
                            .addComponent(sPriceL, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        dessertPLayout.setVerticalGroup(
            dessertPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(dessertPLayout.createSequentialGroup()
                .addGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(dessertPLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(dessertL, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(sQuantityL, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addComponent(sPriceL, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(sItem1F, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                            .addComponent(sPrice1L)))
                    .addGroup(dessertPLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(sItemL, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sItem1CB, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sItem2F, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sItem2CB, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sPrice2L))
                .addGap(6, 6, 6)
                .addGroup(dessertPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(sItem3F, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sItem3CB, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sPrice3L))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        foodP.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));

        foodL.setFont(new Font("UD Digi Kyokasho N-B", 0, 36)); // NOI18N
        foodL.setText("FOOD");

        fItem1CB.addActionListener(this);

        fItem1F.setText("0");
        fItem1F.setEditable(false);
        fItem1F.addActionListener(this);
        fItem1F.addKeyListener(this);

        fItem2CB.addActionListener(this);

        fItem2F.setText("0");
        fItem2F.setEditable(false);
        fItem2F.addActionListener(this);
        fItem2F.addKeyListener(this);

        fItem3CB.addActionListener(this);

        fItem3F.setText("0");
        fItem3F.setEditable(false);
        fItem3F.addActionListener(this);
        fItem3F.addKeyListener(this);

        fItem4CB.addActionListener(this);

        fItem5F.setText("0");
        fItem5F.setEditable(false);
        fItem5F.addActionListener(this);
        fItem5F.addKeyListener(this);

        fItem5CB.addActionListener(this);

        fItemL.setFont(new Font("UD Digi Kyokasho NK-B", 0, 18)); // NOI18N
        fItemL.setText("Item");

        fQuantityL.setFont(new Font("UD Digi Kyokasho NK-B", 0, 18)); // NOI18N
        fQuantityL.setText("Quantity");

        fPriceL.setFont(new Font("UD Digi Kyokasho NK-B", 0, 18)); // NOI18N
        fPriceL.setText("Price");

        fItem4F.setText("0");
        fItem4F.setEditable(false);
        fItem4F.addActionListener(this);
        fItem4F.addKeyListener(this);
        fItem6CB.addActionListener(this);

        fItem6F.setText("0");
        fItem6F.setEditable(false);
        fItem6F.addActionListener(this);
        fItem6F.addKeyListener(this);
        
        GroupLayout foodPLayout = new GroupLayout(foodP);
        foodP.setLayout(foodPLayout);
        foodPLayout.setHorizontalGroup(
            foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, foodPLayout.createSequentialGroup()
                .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(fItem2CB, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                        .addComponent(fItem1CB, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addComponent(fItem6CB, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fItem4CB, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                        .addComponent(fItem3CB, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                        .addComponent(fItem5CB, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(foodPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(fItemL, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(foodL, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
                    .addGroup(foodPLayout.createSequentialGroup()
                        .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(fItem1F, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                            .addComponent(fQuantityL, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                            .addComponent(fItem2F, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                            .addComponent(fItem3F, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                            .addComponent(fItem4F, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                            .addComponent(fItem5F, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                            .addComponent(fItem6F, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
                        .addGap(108, 108, 108)
                        .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(fPriceL, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
                            .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(fPrice1L, GroupLayout.Alignment.TRAILING)
                                .addComponent(fPrice2L, GroupLayout.Alignment.TRAILING)
                                .addComponent(fPrice3L, GroupLayout.Alignment.TRAILING)
                                .addComponent(fPrice4L, GroupLayout.Alignment.TRAILING)
                                .addComponent(fPrice5L, GroupLayout.Alignment.TRAILING))
                            .addComponent(fPrice6L))))
                .addGap(38, 38, 38))
        );
        foodPLayout.setVerticalGroup(
            foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(foodPLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(foodL, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fItemL, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(fQuantityL, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addComponent(fPriceL, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fItem1CB, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(fItem1F, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(fPrice1L))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(fItem2F, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(fItem2CB, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addComponent(fPrice2L)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fItem3CB, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(fItem3F, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(fPrice3L))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(fItem4CB, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                        .addComponent(fPrice4L))
                    .addComponent(fItem4F, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(foodPLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(fPrice5L)
                        .addGap(18, 18, 18)
                        .addComponent(fPrice6L))
                    .addGroup(foodPLayout.createSequentialGroup()
                        .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(fItem5CB, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addComponent(fItem5F, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(foodPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(fItem6CB, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                            .addComponent(fItem6F, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        totalP.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 3));

        subtotalL.setFont(new Font("UD Digi Kyokasho NK-B", 0, 18)); // NOI18N
        subtotalL.setText("SUBTOTAL");

        taxL.setFont(new Font("UD Digi Kyokasho NK-B", 0, 18)); // NOI18N
        taxL.setText("TAX");

        chargeL.setFont(new Font("UD Digi Kyokasho NK-B", 0, 18)); // NOI18N
        chargeL.setText("DELIVERY CHARGE");

        totalL.setFont(new Font("UD Digi Kyokasho NK-B", 0, 18)); // NOI18N
        totalL.setText("TOTAL");

        totalB.setText("TOTAL");
        totalB.setActionCommand("Total");
        totalB.addActionListener(this);

        resetB.setText("RESET");
        resetB.setActionCommand("Reset");
        resetB.addActionListener(this);

        GroupLayout totalPLayout = new GroupLayout(totalP);
        totalP.setLayout(totalPLayout);
        totalPLayout.setHorizontalGroup(totalPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, totalPLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(totalPLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(totalPLayout.createSequentialGroup()
                        .addGroup(totalPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(subtotalL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(taxL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chargeL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(totalPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(taxF, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                            .addComponent(subtotalF, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                            .addComponent(chargeF, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalF, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(totalPLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(totalB)
                        .addGap(32, 32, 32)
                        .addComponent(resetB)))
                .addGap(44, 44, 44))
        );
        totalPLayout.setVerticalGroup(totalPLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(totalPLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(totalPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(subtotalL, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addComponent(subtotalF, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(totalPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(taxL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(taxF, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGroup(totalPLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(totalPLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(chargeL, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
                    .addGroup(totalPLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(chargeF)))
                .addGap(18, 18, 18)
                .addGroup(totalPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(totalF, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalL, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(totalPLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(resetB)
                    .addComponent(totalB))
                .addGap(61, 61, 61))
        );

        receiptA.setColumns(20);
        receiptA.setFont(new Font("Monospaced", 0, 18)); // NOI18N
        receiptA.setRows(5);
        receiptSP.setViewportView(receiptA);

        confirmOrderB.setText("CONFIRM ORDER");
        confirmOrderB.setActionCommand("Confirm");
        confirmOrderB.addActionListener(this);
        confirmOrderB.setEnabled(false);

        cancelB.setText("CANCEL");
        cancelB.setActionCommand("Cancel");
        cancelB.addActionListener(this);

        GroupLayout layout = new GroupLayout(jfMenu.getContentPane());
        jfMenu.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(receiptSP, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(drinkP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(foodP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dessertP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(285, 285, 285)
                                .addComponent(confirmOrderB))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(321, 321, 321)
                                .addComponent(cancelB)))
                        .addGap(134, 134, 134)))
                .addContainerGap(3004, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(foodP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dessertP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(drinkP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalP, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(receiptSP, GroupLayout.PREFERRED_SIZE, 708, GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(confirmOrderB)
                        .addGap(31, 31, 31)
                        .addComponent(cancelB)))
                .addContainerGap(884, Short.MAX_VALUE))
        );

        jfMenu.pack();
        jfMenu.setLocationRelativeTo(null);
        jfMenu.setVisible(true);
    }
    
    void load() {
        Menu m1 = new Menu();
        java.util.List<String> menu = m1.load();
        fItem1CB.setText(menu.get(1).substring(0, 16).trim());
        fItem2CB.setText(menu.get(2).substring(0, 16).trim());
        fItem3CB.setText(menu.get(3).substring(0, 16).trim());
        fItem4CB.setText(menu.get(4).substring(0, 16).trim());
        fItem5CB.setText(menu.get(5).substring(0, 16).trim());
        fItem6CB.setText(menu.get(6).substring(0, 16).trim());
        
        dItem1CB.setText(menu.get(9).substring(0, 16).trim());
        dItem2CB.setText(menu.get(10).substring(0, 16).trim());
        dItem3CB.setText(menu.get(11).substring(0, 16).trim());
        dItem4CB.setText(menu.get(12).substring(0, 16).trim());
        dItem5CB.setText(menu.get(13).substring(0, 16).trim());
        dItem6CB.setText(menu.get(14).substring(0, 16).trim());
        
        sItem1CB.setText(menu.get(17).substring(0, 16).trim());
        sItem2CB.setText(menu.get(18).substring(0, 16).trim());
        sItem3CB.setText(menu.get(19).substring(0, 16).trim());
        
        fPrice1L.setText(menu.get(1).substring(18));
        fPrice2L.setText(menu.get(2).substring(18));
        fPrice3L.setText(menu.get(3).substring(18));
        fPrice4L.setText(menu.get(4).substring(18));
        fPrice5L.setText(menu.get(5).substring(18));
        fPrice6L.setText(menu.get(6).substring(18));
        
        dPrice1L.setText(menu.get(9).substring(18));
        dPrice2L.setText(menu.get(10).substring(18));
        dPrice3L.setText(menu.get(11).substring(18));
        dPrice4L.setText(menu.get(12).substring(18));
        dPrice5L.setText(menu.get(13).substring(18));
        dPrice6L.setText(menu.get(14).substring(18));
        
        sPrice1L.setText(menu.get(17).substring(18));
        sPrice2L.setText(menu.get(18).substring(18));
        sPrice3L.setText(menu.get(19).substring(18));
    }
    
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Cancel":
                jfMenu.dispose();
                new GUIUser().setCurrentUser(currentUser);
                break;
            case "Confirm":
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm:SS");
                Date date = new Date(System.currentTimeMillis() + 1800000);

                // pop up message 
                JOptionPane.showMessageDialog(jfMenu, "You have successfully made your order!\n"
                                               + "Your order will be delivered on " + date);
                
                jfMenu.dispose();
                new GUIUser().setCurrentUser(currentUser);
                break;
            case "Reset":
                fItem1F.setText("0");
                fItem1CB.setSelected(false);

                fItem2F.setText("0");
                fItem2CB.setSelected(false);

                fItem4F.setText("0");
                fItem4CB.setSelected(false);

                fItem3F.setText("0");
                fItem3CB.setSelected(false);

                fItem5F.setText("0");
                fItem5CB.setSelected(false);

                fItem6F.setText("0");
                fItem6CB.setSelected(false);

                dItem1F.setText("0");
                dItem1CB.setSelected(false);

                dItem2F.setText("0");
                dItem2CB.setSelected(false);

                dItem4F.setText("0");
                dItem4CB.setSelected(false);

                dItem5F.setText("0");
                dItem5CB.setSelected(false);

                dItem3F.setText("0");
                dItem3CB.setSelected(false);

                dItem6F.setText("0");
                dItem6CB.setSelected(false);

                sItem1F.setText("0");
                sItem1CB.setSelected(false);

                sItem2F.setText("0");
                sItem2CB.setSelected(false);

                sItem3F.setText("0");
                sItem3CB.setSelected(false);

                subtotalF.setText(null);
                taxF.setText(null);
                chargeF.setText(null);
                totalF.setText(null);
                receiptA.setText(null);
                break;
            case "Total":
                String fItem1Qty = fItem1F.getText();
                String fItem2Qty = fItem2F.getText();
                String fItem3Qty = fItem3F.getText();
                String fItem4Qty = fItem4F.getText();
                String fItem5Qty = fItem5F.getText();
                String fItem6Qty = fItem6F.getText();
                String dItem1Qty = dItem1F.getText();
                String dItem2Qty = dItem2F.getText();
                String dItem3Qty = dItem3F.getText();
                String dItem4Qty = dItem4F.getText();
                String dItem5Qty = dItem5F.getText();
                String dItem6Qty = dItem6F.getText();
                String sItem1Qty = sItem1F.getText();
                String sItem2Qty = sItem2F.getText();
                String sItem3Qty = sItem3F.getText();
                
                double fItem1Cost = Double.parseDouble(fItem1Qty) * Double.parseDouble(fPrice1L.getText().substring(3));
                double fItem2Cost = Double.parseDouble(fItem2Qty) * Double.parseDouble(fPrice2L.getText().substring(3));
                double fItem3Cost = Double.parseDouble(fItem3Qty) * Double.parseDouble(fPrice3L.getText().substring(3));
                double fItem4Cost = Double.parseDouble(fItem4Qty) * Double.parseDouble(fPrice4L.getText().substring(3));
                double fItem5Cost = Double.parseDouble(fItem5Qty) * Double.parseDouble(fPrice5L.getText().substring(3));
                double fItem6Cost = Double.parseDouble(fItem6Qty) * Double.parseDouble(fPrice6L.getText().substring(3));
                double dItem1Cost = Double.parseDouble(dItem1Qty) * Double.parseDouble(dPrice1L.getText().substring(3));
                double dItem2Cost = Double.parseDouble(dItem2Qty) * Double.parseDouble(dPrice2L.getText().substring(3));
                double dItem3Cost = Double.parseDouble(dItem3Qty) * Double.parseDouble(dPrice3L.getText().substring(3));
                double dItem4Cost = Double.parseDouble(dItem4Qty) * Double.parseDouble(dPrice4L.getText().substring(3));
                double dItem5Cost = Double.parseDouble(dItem5Qty) * Double.parseDouble(dPrice5L.getText().substring(3));
                double dItem6Cost = Double.parseDouble(dItem6Qty) * Double.parseDouble(dPrice6L.getText().substring(3));
                double sItem1Cost = Double.parseDouble(sItem1Qty) * Double.parseDouble(sPrice1L.getText().substring(3));
                double sItem2Cost = Double.parseDouble(sItem2Qty) * Double.parseDouble(sPrice2L.getText().substring(3));
                double sItem3Cost = Double.parseDouble(sItem3Qty) * Double.parseDouble(sPrice3L.getText().substring(3)); 


                subtotal = fItem1Cost + fItem2Cost + fItem4Cost + fItem3Cost + fItem5Cost + fItem6Cost + dItem1Cost + dItem2Cost + dItem4Cost + dItem5Cost + dItem3Cost + dItem6Cost + sItem1Cost + sItem2Cost + sItem3Cost;
                String subAmount = String.format("%.2f",subtotal);

                double cukai = tax * subtotal;

                total = subtotal + cukai + deliveryFee;
                String amount = String.format("%.2f",total);

                String deliveryCharge = String.format("%.2f",deliveryFee);

                subtotalF.setText(subAmount);
                taxF.setText(String.format("%.2f", cukai));
                chargeF.setText(deliveryCharge);
                totalF.setText(amount);


                formatter = new SimpleDateFormat("dd/MM/yy HH:mm:SS");
                date = new Date(System.currentTimeMillis());

                receiptA.setText("Eclipse Food Online Ordering System\n");
                receiptA.setText(receiptA.getText() + "-------------------------------------------\n");
                // add the username Customer: + username
                receiptA.setText(receiptA.getText() + date + "\n");
                receiptA.setText(receiptA.getText() + "-------------------------------------------\n");   
                receiptA.setText(receiptA.getText() + "Item\t\t\tQty\tCost\n\n");

                if(!"0".equals(fItem1Qty)) {
                receiptA.setText(receiptA.getText() + 
                            String.format("%-24s", fItem1CB.getText()) + fItem1Qty + "\t" + String.format("%.2f", fItem1Cost) + "\n"); }    

                if(!"0".equals(fItem2Qty)) {
                    receiptA.setText(receiptA.getText() + 
                            String.format("%-24s", fItem2CB.getText()) + fItem2Qty + "\t" + String.format("%.2f",fItem2Cost) + "\n");}

                if(!"0".equals(fItem3Qty)) {
                 receiptA.setText(receiptA.getText() + 
                            String.format("%-24s", fItem3CB.getText()) + fItem3Qty + "\t" + String.format("%.2f",fItem3Cost) + "\n");}

                if(!"0".equals(fItem4Qty)) {
                receiptA.setText(receiptA.getText() + 
                            String.format("%-24s", fItem4CB.getText()) + fItem4Qty + "\t" + String.format("%.2f",fItem4Cost) + "\n");}

                if(!"0".equals(fItem5Qty)) {
                receiptA.setText(receiptA.getText() + 
                            String.format("%-24s", fItem5CB.getText()) + fItem5Qty + "\t" + String.format("%.2f",fItem5Cost) + "\n");}

                if(!"0".equals(fItem6Qty)) {
                    receiptA.setText(receiptA.getText() + 
                            String.format("%-24s", fItem6CB.getText()) + fItem6Qty + "\t" + String.format("%.2f",fItem6Cost) + "\n");}

                if(!"0".equals(dItem1Qty)) {
                receiptA.setText(receiptA.getText() + 
                            String.format("%-24s", dItem1CB.getText()) + dItem1Qty + "\t" + String.format("%.2f",dItem1Cost) + "\n");}

                if(!"0".equals(dItem2Qty)) {
                receiptA.setText(receiptA.getText() + 
                            String.format("%-24s", dItem2CB.getText()) + dItem2Qty + "\t" + String.format("%.2f",dItem2Cost) + "\n");}

                if(!"0".equals(dItem3Qty)) {
                    receiptA.setText(receiptA.getText() + 
                            String.format("%-24s", dItem3CB.getText()) + dItem3Qty + "\t" + String.format("%.2f",dItem3Cost) + "\n");}

                if(!"0".equals(dItem4Qty)) {
                receiptA.setText(receiptA.getText() + 
                            String.format("%-24s", dItem4CB.getText()) + dItem4Qty + "\t" + String.format("%.2f",dItem4Cost) + "\n");}

                if(!"0".equals(dItem5Qty)) {
                receiptA.setText(receiptA.getText() + 
                            String.format("%-24s", dItem5CB.getText()) + dItem5Qty + "\t" + String.format("%.2f",dItem5Cost) + "\n");}

                if(!"0".equals(dItem6Qty)) {
                receiptA.setText(receiptA.getText() + 
                            String.format("%-24s", dItem6CB.getText()) + dItem6Qty + "\t" + String.format("%.2f",dItem6Cost) + "\n");}

                if(!"0".equals(sItem1Qty)) {
                receiptA.setText(receiptA.getText() + 
                            String.format("%-24s", sItem1CB.getText()) + sItem1Qty +  "\t" + String.format("%.2f",sItem1Cost) + "\n");}

                if(!"0".equals(sItem2Qty)) {
                receiptA.setText(receiptA.getText() + 
                            String.format("%-24s", sItem2CB.getText()) + sItem2Qty + "\t" + String.format("%.2f",sItem2Cost) + "\n");}

                if(!"0".equals(sItem3Qty)) {
                receiptA.setText(receiptA.getText() + 
                            String.format("%-24s", sItem3CB.getText()) + sItem3Qty + "\t" + String.format("%.2f",sItem3Cost) + "\n");}

                receiptA.setText(receiptA.getText() + "-------------------------------------------\n");
                receiptA.setText(receiptA.getText() + "Subtotal\t\t\t" + subtotalF.getText() + "\n");
                receiptA.setText(receiptA.getText() + "Tax 3%\t\t\t\t" + taxF.getText() + "\n");
                receiptA.setText(receiptA.getText() + "Delivery Fee\t\t\t" + chargeF.getText() + "\n");
                receiptA.setText(receiptA.getText() + "-------------------------------------------\n");
                receiptA.setText(receiptA.getText() + "Total\t\t\t\t" + totalF.getText() + "\n");
                receiptA.setText(receiptA.getText() + "-------------------------------------------\n\n");
                break;
            default:
                break;
        }
        
        if(fItem1CB.isSelected()){
            fItem1F.setEditable(true);
            fItem1F.requestFocus();
            fItem1F.setText("1");
        }
        else {
            fItem1F.setEditable(false);
            fItem1F.setText("0");
        }
        if(fItem2CB.isSelected()){
            fItem2F.setEditable(true);
            fItem2F.requestFocus();
            fItem2F.setText("1");
        }
        else {
            fItem2F.setEditable(false);
            fItem2F.setText("0");
        }
        if(fItem3CB.isSelected()){
            fItem3F.setEditable(true);
            fItem3F.requestFocus();
            fItem3F.setText("1");
        }
        else {
            fItem3F.setEditable(false);
            fItem3F.setText("0");
        }
        if(fItem4CB.isSelected()){
            fItem4F.setEditable(true);
            fItem4F.requestFocus();
            fItem4F.setText("1");
        }
        else {
            fItem4F.setEditable(false);
            fItem4F.setText("0");
        }
        if(fItem5CB.isSelected()){
            fItem5F.setEditable(true);
            fItem5F.requestFocus();
            fItem5F.setText("1");
        }
        else {
            fItem5F.setEditable(false);
            fItem5F.setText("0");
        }
        if(fItem6CB.isSelected()){
            fItem6F.setEditable(true);
            fItem6F.requestFocus();
            fItem6F.setText("1");
        }
        else {
            fItem6F.setEditable(false);
            fItem6F.setText("0");
        }
        
        if(dItem1CB.isSelected()){
            dItem1F.setEditable(true);
            dItem1F.requestFocus();
            dItem1F.setText("1");
        }
        else {
            dItem1F.setEditable(false);
            dItem1F.setText("0");
        }
        if(dItem2CB.isSelected()){
            dItem2F.setEditable(true);
            dItem2F.requestFocus();
            dItem2F.setText("1");
        }
        else {
            dItem2F.setEditable(false);
            dItem2F.setText("0");
        }
        if(dItem3CB.isSelected()){
            dItem3F.setEditable(true);
            dItem3F.requestFocus();
            dItem3F.setText("1");
        }
        else {
            dItem3F.setEditable(false);
            dItem3F.setText("0");
        }
        if(dItem4CB.isSelected()){
            dItem4F.setEditable(true);
            dItem4F.requestFocus();
            dItem4F.setText("1");
        }
        else {
            dItem4F.setEditable(false);
            dItem4F.setText("0");
        }
        if(dItem5CB.isSelected()){
            dItem5F.setEditable(true);
            dItem5F.requestFocus();
            dItem5F.setText("1");
        }
        else {
            dItem5F.setEditable(false);
            dItem5F.setText("0");
        }
        if(dItem6CB.isSelected()){
            dItem6F.setEditable(true);
            dItem6F.requestFocus();
            dItem6F.setText("1");
        }
        else {
            dItem6F.setEditable(false);
            dItem6F.setText("0");
        }
        
        if(sItem1CB.isSelected()){
            sItem1F.setEditable(true);
            sItem1F.requestFocus();
            sItem1F.setText("1");
        }
        else {
            sItem1F.setEditable(false);
            sItem1F.setText("0");
        }
        if(sItem2CB.isSelected()){
            sItem2F.setEditable(true);
            sItem2F.requestFocus();
            sItem2F.setText("1");
        }
        else {
            sItem2F.setEditable(false);
            sItem2F.setText("0");
        }
        if(sItem3CB.isSelected()){
            sItem3F.setEditable(true);
            sItem3F.requestFocus();
            sItem3F.setText("1");
        }
        else {
            sItem3F.setEditable(false);
            sItem3F.setText("0");
        }
        
        if(receiptA.getText().isEmpty()) {
            confirmOrderB.setEnabled(false);
        }
        else {
            confirmOrderB.setEnabled(true);
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
