package ViewMain.AdminView;

import javax.swing.*;
import java.awt.*;

public class TabShop extends JPanel {
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private SpringLayout layoutMain = new SpringLayout();
    private JCheckBox jCheckBox1 = new JCheckBox("Office");
    private JCheckBox jCheckBox2 = new JCheckBox("Gaming");
    private JCheckBox jCheckBox3 = new JCheckBox("In stock");
    private JCheckBox jCheckBox4 = new JCheckBox("Out of stock");
    private JButton jButton1 = new JButton("Add Laptop");
    private JButton jButton2 = new JButton("Delete Laptop");


    public TabShop() {
        this.setPreferredSize(new Dimension(1020, 750));
        this.setBackground(Color.WHITE);
        this.setLayout(layoutMain);
        this.initJ();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int Hrec = 950;
        int Wrec =450;
        int x = (getWidth() - Hrec) / 2;
        int y = (getHeight() - Wrec) / 2 +70;

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(x, y, Hrec, Wrec);
        g2d.setStroke(new BasicStroke(5.0f));
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x, y, Hrec, Wrec);
    }
    public void initJ(){
        jLabel1 = new JLabel("Search");
        jLabel2 = new JLabel("Classify");
        jLabel3 = new JLabel("Warehouse");
        jLabel4 = new JLabel("Addnew");

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jLabel1,-300,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jLabel1,-350,SpringLayout.HORIZONTAL_CENTER,this);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jLabel2,-300,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jLabel2,-120,SpringLayout.HORIZONTAL_CENTER,this);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jLabel3, -300,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jLabel3,110,SpringLayout.HORIZONTAL_CENTER,this);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jLabel4,-300,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jLabel4,340,SpringLayout.HORIZONTAL_CENTER,this);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField1,-250,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField1,-350,SpringLayout.HORIZONTAL_CENTER,this);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField2,-200,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField2,-350,SpringLayout.HORIZONTAL_CENTER,this);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jCheckBox1,-250,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jCheckBox1,-120,SpringLayout.HORIZONTAL_CENTER,this);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jCheckBox2,-200,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jCheckBox2,-120,SpringLayout.HORIZONTAL_CENTER,this);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jCheckBox3,-250,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jCheckBox3,110,SpringLayout.HORIZONTAL_CENTER,this);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jCheckBox4,-200,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jCheckBox4,110,SpringLayout.HORIZONTAL_CENTER,this);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jButton1,-250,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jButton1,340,SpringLayout.HORIZONTAL_CENTER,this);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jButton2,-200,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jButton2,340,SpringLayout.HORIZONTAL_CENTER,this);

        jLabel1.setPreferredSize(new Dimension(200,30));
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setBackground(Color.BLACK);            
        jLabel1.setOpaque(true);

        jLabel2.setPreferredSize(new Dimension(200,30));
        jLabel2.setForeground(Color.WHITE);
        jLabel2.setBackground(Color.BLACK);
        jLabel2.setOpaque(true);

        jLabel3.setPreferredSize(new Dimension(200,30));
        jLabel3.setForeground(Color.WHITE);
        jLabel3.setBackground(Color.BLACK);
        jLabel3.setOpaque(true);

        jLabel4.setPreferredSize(new Dimension(200,30));
        jLabel4.setForeground(Color.WHITE);
        jLabel4.setBackground(Color.BLACK);
        jLabel4.setOpaque(true);

        jTextField1.setPreferredSize(new Dimension(200,40));

        jTextField2.setPreferredSize(new Dimension(200,40));

        jCheckBox1.setPreferredSize(new Dimension(200,40));
        jCheckBox2.setPreferredSize(new Dimension(200,40));
        jCheckBox3.setPreferredSize(new Dimension(200,40));
        jCheckBox4.setPreferredSize(new Dimension(200,40));
        jButton1.setPreferredSize(new Dimension(200,40));
        jButton2.setPreferredSize(new Dimension(200,40));

        this.add(jLabel1);
        this.add(jLabel2);
        this.add(jLabel3);
        this.add(jLabel4);
        this.add(jTextField1);
        this.add(jTextField2);
        this.add(jCheckBox1);
        this.add(jCheckBox2);
        this.add(jCheckBox3);
        this.add(jCheckBox4);
        this.add(jButton1);
        this.add(jButton2);

    }

}
