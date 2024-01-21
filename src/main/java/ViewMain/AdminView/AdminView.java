package ViewMain.AdminView;

import Controller.Main.Admin.ChangeTab;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JFrame {
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JPanel panel = new JPanel();
    private JPanel panel1 = new JPanel();;
    private JPanel panel2 = new JPanel();
    private JPanel panelTam = new JPanel();
    private TabHome tabHome = new TabHome();
    private TabShop tabShop = new TabShop();
    private TabSell tabSell = new TabSell();
    private TabBill tabBill = new TabBill();
    private TabStatistical tabStatistical = new TabStatistical();
    private SpringLayout layoutMain = new SpringLayout();
    private SpringLayout layoutClone = new SpringLayout();
    private SpringLayout layoutClone2 = new SpringLayout();

    public AdminView(){
        this.setSize(1300,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.initMain();
        this.setVisible(true);
    }
    public void initMain(){
        this.initClone();
        this.initTitle();
        this.initButton();
        this.initTab();
        this.addController();
        this.initIcon();
    }
    public void initClone(){
        panel1.setLayout(layoutClone);
        panel.setLayout(layoutMain);
        this.getContentPane().add(panel);
        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,panel1,0,SpringLayout.VERTICAL_CENTER,panel);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,panel1,-505,SpringLayout.HORIZONTAL_CENTER,panel);
        panel1.setPreferredSize(new Dimension(280,750));
        panel1.setBackground(new Color(89,106,123));
        panel.add(panel1);

        panel2.setLayout(layoutClone2);
        panel2.setPreferredSize(new Dimension(1020,750));
        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,panel2,0,SpringLayout.VERTICAL_CENTER,panel);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,panel2,133,SpringLayout.HORIZONTAL_CENTER,panel);
        panel.add(panel2);
    }
    public void initTitle(){
        JLabel jLabel0 = new JLabel("SyncPOS");
        jLabel0.setFont(new Font("Arial",Font.BOLD,40));
        jLabel0.setForeground(Color.WHITE);
        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jLabel0,-330,SpringLayout.VERTICAL_CENTER,panel1);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jLabel0,0,SpringLayout.HORIZONTAL_CENTER,panel1);
        panel1.add(jLabel0);
        JLabel jLabel1 = new JLabel("Main Navigation");
        jLabel1.setFont(new Font("Arial",Font.BOLD,18));
        jLabel1.setForeground(new Color(192,192,192));
        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jLabel1,-190,SpringLayout.VERTICAL_CENTER,panel1);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jLabel1,0,SpringLayout.HORIZONTAL_CENTER,panel1);
        panel1.add(jLabel1);


    }
    public void initButton(){
        jButton1 = new JButton("<html>Tien Shop<br>Admin</html>");
        setPNGButton(jButton1);
        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jButton1,-250,SpringLayout.VERTICAL_CENTER,panel1);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jButton1,0,SpringLayout.HORIZONTAL_CENTER,panel1);
        jButton1.setPreferredSize(new Dimension(280,90));
        panel1.add(jButton1);
        jButton2 = new JButton("Home");
        setPNGButton(jButton2);
        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jButton2,-150,SpringLayout.VERTICAL_CENTER,panel1);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jButton2,0,SpringLayout.HORIZONTAL_CENTER,panel1);
        jButton2.setPreferredSize(new Dimension(280,50));
        panel1.add(jButton2);
        jButton3 = new JButton("Shop");
        setPNGButton(jButton3);
        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jButton3,-100,SpringLayout.VERTICAL_CENTER,panel1);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jButton3,0,SpringLayout.HORIZONTAL_CENTER,panel1);
        jButton3.setPreferredSize(new Dimension(280,50));
        panel1.add(jButton3);
        jButton4 = new JButton("Sell");
        setPNGButton(jButton4);
        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jButton4,-50,SpringLayout.VERTICAL_CENTER,panel1);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jButton4,0,SpringLayout.HORIZONTAL_CENTER,panel1);
        jButton4.setPreferredSize(new Dimension(280,50));
        panel1.add(jButton4);
        jButton6 = new JButton("Bill");
        setPNGButton(jButton6);
        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jButton6,0,SpringLayout.VERTICAL_CENTER,panel1);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jButton6,0,SpringLayout.HORIZONTAL_CENTER,panel1);
        jButton6.setPreferredSize(new Dimension(280,50));
        panel1.add(jButton6);
        jButton7 = new JButton("about");
        setPNGButton(jButton7);
        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jButton7,335,SpringLayout.VERTICAL_CENTER,panel1);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jButton7,-65,SpringLayout.HORIZONTAL_CENTER,panel1);
        jButton7.setPreferredSize(new Dimension(140,40));
        panel1.add(jButton7);
        jButton8 = new JButton("logout");
        setPNGButton(jButton8);
        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jButton8,335,SpringLayout.VERTICAL_CENTER,panel1);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jButton8,75,SpringLayout.HORIZONTAL_CENTER,panel1);
        jButton8.setPreferredSize(new Dimension(140,40));
        panel1.add(jButton8);
        jButton9 = new JButton("Statistical");
        setPNGButton(jButton9);
        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jButton9,50,SpringLayout.VERTICAL_CENTER,panel1);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jButton9,0,SpringLayout.HORIZONTAL_CENTER,panel1);
        jButton9.setPreferredSize(new Dimension(280,50));
        panel1.add(jButton9);



    }
    public void initTab(){
        panel2.add(tabHome);
        layoutClone2.putConstraint(SpringLayout.VERTICAL_CENTER,tabHome,0,SpringLayout.VERTICAL_CENTER,panel2);
        layoutClone2.putConstraint(SpringLayout.HORIZONTAL_CENTER,tabHome,0,SpringLayout.HORIZONTAL_CENTER,panel2);

        //next tab
        layoutClone2.putConstraint(SpringLayout.VERTICAL_CENTER,tabShop,0,SpringLayout.VERTICAL_CENTER,panel2);
        layoutClone2.putConstraint(SpringLayout.HORIZONTAL_CENTER,tabShop,0,SpringLayout.HORIZONTAL_CENTER,panel2);

        layoutClone2.putConstraint(SpringLayout.VERTICAL_CENTER,tabSell,0,SpringLayout.VERTICAL_CENTER,panel2);
        layoutClone2.putConstraint(SpringLayout.HORIZONTAL_CENTER,tabSell,0,SpringLayout.HORIZONTAL_CENTER,panel2);


        layoutClone2.putConstraint(SpringLayout.VERTICAL_CENTER,tabBill,0,SpringLayout.VERTICAL_CENTER,panel2);
        layoutClone2.putConstraint(SpringLayout.HORIZONTAL_CENTER,tabBill,0,SpringLayout.HORIZONTAL_CENTER,panel2);

        layoutClone2.putConstraint(SpringLayout.VERTICAL_CENTER,tabStatistical,0,SpringLayout.VERTICAL_CENTER,panel2);
        layoutClone2.putConstraint(SpringLayout.HORIZONTAL_CENTER,tabStatistical,0,SpringLayout.HORIZONTAL_CENTER,panel2);
    }
    public void addController(){

        ChangeTab ch = new ChangeTab(this);
        jButton2.addActionListener(ch);
        jButton2.addMouseListener(ch);
        jButton3.addActionListener(ch);
        jButton3.addMouseListener(ch);
        jButton4.addActionListener(ch);
        jButton4.addMouseListener(ch);
        jButton6.addActionListener(ch);
        jButton6.addMouseListener(ch);
        jButton7.addActionListener(ch);
        jButton7.addMouseListener(ch);
        jButton8.addActionListener(ch);
        jButton8.addMouseListener(ch);
        jButton9.addActionListener(ch);
        jButton9.addMouseListener(ch);

    }
    public void initIcon() {
        ImageIcon adminIcon = new ImageIcon("C:/Users/ADMIN/Pictures/PicforJv/iconAdmin.png");
        jButton1.setIcon(adminIcon);
        ImageIcon homeIcon = new ImageIcon("C:/Users/ADMIN/Pictures/PicforJv/homeIcon.png");
        jButton2.setIcon(homeIcon);
        ImageIcon shopIcon = new ImageIcon("C:/Users/ADMIN/Pictures/PicforJv/shopIcon.png");
        jButton3.setIcon(shopIcon);
        ImageIcon customerIcon = new ImageIcon("C:/Users/ADMIN/Pictures/PicforJv/employeeIcon.png");
        jButton4.setIcon(customerIcon);
        ImageIcon billIcon= new ImageIcon("C:/Users/ADMIN/Pictures/PicforJv/billicon.png");
        jButton6.setIcon(billIcon);
        ImageIcon aboutIcon = new ImageIcon("C:/Users/ADMIN/Pictures/PicforJv/aboutIcon.png");
        jButton7.setIcon(aboutIcon);
        ImageIcon logoutIcon = new ImageIcon("C:/Users/ADMIN/Pictures/PicforJv/logoutIcon.png");
        jButton8.setIcon(logoutIcon);
        ImageIcon statisticalIcon = new ImageIcon("C:/Users/ADMIN/Pictures/PicforJv/statisticalIcon.png");
        jButton9.setIcon(statisticalIcon);
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JPanel getPanel() {
        return panel;
    }

    public SpringLayout getLayoutMain() {
        return layoutMain;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public TabHome getTabHome() {
        return tabHome;
    }

    public TabShop getTabShop() {
        return tabShop;
    }
    public JButton getjButton1() {
        return jButton1;
    }



    public TabSell getTabSell() {
        return tabSell;
    }

    public TabBill getTabBill() {
        return tabBill;
    }

    public TabStatistical getTabStatistical() {
        return tabStatistical;
    }

    public JPanel getPanelTam() {
        return panelTam;
    }

    public void setPanelTam(JPanel panelTam) {
        this.panelTam = panelTam;
    }

    public static void main(String[] args) {
        new AdminView();
    }
    public void removeTab(JPanel jPanel){
        panel2.remove(jPanel);
        panel.repaint();
        panel.revalidate();
    }
    public void addTab(JPanel jPanel){
        panel2.add(jPanel);
        panel.repaint();
        panel.revalidate();
    }
    public void setPNGButton(JButton jButton){
        jButton.setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
        jButton.setForeground(Color.WHITE);
        jButton.setOpaque(false);
        jButton.setContentAreaFilled(false);
        jButton.setBorderPainted(false);
        jButton.setFocusPainted(false);
        jButton.setBackground(new Color(0, 0, 0, 100));
        jButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 100), 2, true));

    }
}
