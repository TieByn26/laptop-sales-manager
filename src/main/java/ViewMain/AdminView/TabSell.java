package ViewMain.AdminView;

import DAO.LaptopDAO;
import Model.Laptop.Laptop;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TabSell extends JPanel {
    private ArrayList<Laptop> list = LaptopDAO.getLaptopDAO().selectAll();
    private DefaultTableModel model;
    private JTable jTable1;
    private JScrollPane jscrollPane1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private SpringLayout layoutMain = new SpringLayout();
    private SpringLayout layoutClone = new SpringLayout();
    private JSeparator separatorVertical4FD = new JSeparator(SwingConstants.VERTICAL);
    public TabSell() {
        this.setPreferredSize(new Dimension(1020,750));
        this.setBackground(Color.WHITE);
        this.initj();
        this.initTable();
    }
    public void initj(){
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jButton1 = new JButton("Customer");
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
        jscrollPane1 = new JScrollPane(jTable1);
        this.setLayout(layoutMain);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jPanel1,55,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jPanel1,-290,SpringLayout.HORIZONTAL_CENTER,this);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField1,-225,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField1,-390,SpringLayout.HORIZONTAL_CENTER,this);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jButton1,-225,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jButton1,-190,SpringLayout.HORIZONTAL_CENTER,this);

        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jscrollPane1,0,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jscrollPane1,0,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        jPanel1.setPreferredSize(new Dimension(400,500));
        jPanel1.setBackground(Color.YELLOW);
        jTextField1.setPreferredSize(new Dimension(190,50));
        jButton1.setPreferredSize(new Dimension(190,50));
        jTable1.setPreferredSize(new Dimension(400,500));
        jscrollPane1.setPreferredSize(new Dimension(400,500));

        jPanel1.add(jscrollPane1);
        jPanel1.setLayout(layoutClone);
        this.add(jPanel1);
        this.add(jTextField1);
        this.add(jButton1);


    }
    public void initTable() {
        String[] columNames = {"ID", "Name product", "Price"};
        for (String columName : columNames) {
            model.addColumn(columName);
        }
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);

        jTable1.setRowHeight(40);

        for (Laptop laptop : list) {
            Object[] data = {laptop.getID(), laptop.getName(), laptop.getPrice()};
            model.addRow(data);
        }
    }

    public static void main(String[] args) {
        new AdminView();
    }
}
