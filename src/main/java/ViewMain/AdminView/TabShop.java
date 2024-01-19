package ViewMain.AdminView;

import Controller.Main.Admin.ClassifyLaptop;
import Controller.Main.Admin.SearchLaptop;
import DAO.LaptopDAO;
import Model.Laptop.Laptop;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TabShop extends JPanel {
    private SearchLaptop searchLaptop = new SearchLaptop(this);
    private ClassifyLaptop classifyLaptop = new ClassifyLaptop(this);
    private ArrayList<Laptop> list = LaptopDAO.getLaptopDAO().selectAll();
    private DefaultTableModel model ;
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JTable jTable1 ;
    private JScrollPane scrollPane1 ;
    private JPanel jPanel1 ;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JTextField jTextField1 = new JTextField();
    private JTextField jTextField2 = new JTextField();
    private SpringLayout layoutMain = new SpringLayout();
    private SpringLayout layoutClone = new SpringLayout();
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
        this.initTable();
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
        jPanel1 = new JPanel();
        model = new DefaultTableModel() {
            @Override
            public Object getValueAt(int row, int column) {
                Object value = super.getValueAt(row, column);
                if (value instanceof Number) {
                    if (value instanceof Integer) {
                        return String.format("%,d", value);
                    } else if (value instanceof Double) {
                        return String.format("%.2f", value);
                    }
                }
                return value;
            }
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable1 = new JTable(model);
        scrollPane1 = new JScrollPane(jTable1);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jPanel1,70,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jPanel1,0,SpringLayout.HORIZONTAL_CENTER,this);

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

        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,scrollPane1,0,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,scrollPane1,0,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        jPanel1.setPreferredSize(new Dimension(945,450));
        jPanel1.setBackground(Color.WHITE);
        jPanel1.setLayout(layoutClone);
        jPanel1.add(scrollPane1);

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

        jTable1.setPreferredSize(new Dimension(947,453));
        scrollPane1.setPreferredSize(new Dimension(947,453));

        this.add(jPanel1);
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
    public void initTable(){
        String[] columNames = {"ID","Name product","Price","Capital price","Type","Quantity"};
        for (String columName : columNames){
            model.addColumn(columName);
        }
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(500);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(100);

        jTable1.setRowHeight(40);

        for (Laptop laptop : list){
            Object[] data = {laptop.getID(),laptop.getName(),laptop.getPrice(),laptop.getCprice(),laptop.getType(),laptop.getQuantity()};
            model.addRow(data);
        }
        jTextField1.getDocument().addDocumentListener(searchLaptop);
        jTextField2.getDocument().addDocumentListener(searchLaptop);
        buttonGroup.add(jCheckBox1);
        buttonGroup.add(jCheckBox2);
        buttonGroup.add(jCheckBox3);
        buttonGroup.add(jCheckBox4);
        jCheckBox1.addChangeListener(classifyLaptop);
        jCheckBox2.addChangeListener(classifyLaptop);
        jCheckBox3.addChangeListener(classifyLaptop);
        jCheckBox4.addChangeListener(classifyLaptop);
        jButton1.addActionListener(searchLaptop);
        jButton2.addActionListener(searchLaptop);
    }

    public ArrayList<Laptop> getList() {
        return list;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public JScrollPane getScrollPane1() {
        return scrollPane1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public SpringLayout getLayoutMain() {
        return layoutMain;
    }

    public SpringLayout getLayoutClone() {
        return layoutClone;
    }

    public JCheckBox getjCheckBox1() {
        return jCheckBox1;
    }

    public JCheckBox getjCheckBox2() {
        return jCheckBox2;
    }

    public JCheckBox getjCheckBox3() {
        return jCheckBox3;
    }

    public JCheckBox getjCheckBox4() {
        return jCheckBox4;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public JButton getjButton2() {
        return jButton2;
    }

    public static void main(String[] args) {
        new AdminView();
    }

}
