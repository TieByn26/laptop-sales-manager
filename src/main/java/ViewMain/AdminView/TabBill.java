package ViewMain.AdminView;

import Controller.Main.Admin.BillJbut;
import Controller.Main.Admin.SellJbut;
import DAO.BillDAO;
import DAO.LaptopDAO;
import Model.Laptop.Bill;
import Model.Laptop.Laptop;
import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class TabBill extends JPanel {
    private int IDtam;
    private BillJbut billJbut = new BillJbut(this);
    private DefaultTableModel model;
    private JTable jTable1;
    private JScrollPane jscrollPane1;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextField jTextField7;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private SpringLayout layoutMain = new SpringLayout();
    private SpringLayout layoutClone = new SpringLayout();
    private SpringLayout layoutClone2 = new SpringLayout();
    private JSeparator separatorVertical4FD = new JSeparator(SwingConstants.VERTICAL);
    public TabBill() {
        this.setPreferredSize(new Dimension(1020,750));
        this.setBackground(Color.lightGray);
        this.initj();
        this.initTable();
    }
    public void initj(){
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();
        jTextField7 = new JTextField();
        jButton1 = new JButton("Refresh");
        jButton2 = new JButton("Pay");
        jButton3 = new JButton("Delete Bill");
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
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

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jPanel2,25,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jPanel2,220,SpringLayout.HORIZONTAL_CENTER,this);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField1,-225,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField1,-390,SpringLayout.HORIZONTAL_CENTER,this);

        layoutClone2.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField2,-230,SpringLayout.VERTICAL_CENTER,jPanel2);
        layoutClone2.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField2,0,SpringLayout.HORIZONTAL_CENTER,jPanel2);

        layoutClone2.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField3,-170,SpringLayout.VERTICAL_CENTER,jPanel2);
        layoutClone2.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField3,0,SpringLayout.HORIZONTAL_CENTER,jPanel2);

        layoutClone2.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField4,-110,SpringLayout.VERTICAL_CENTER,jPanel2);
        layoutClone2.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField4,0,SpringLayout.HORIZONTAL_CENTER,jPanel2);

        layoutClone2.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField5,-50,SpringLayout.VERTICAL_CENTER,jPanel2);
        layoutClone2.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField5,0,SpringLayout.HORIZONTAL_CENTER,jPanel2);

        layoutClone2.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField6,10,SpringLayout.VERTICAL_CENTER,jPanel2);
        layoutClone2.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField6,0,SpringLayout.HORIZONTAL_CENTER,jPanel2);

        layoutClone2.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField7,70,SpringLayout.VERTICAL_CENTER,jPanel2);
        layoutClone2.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField7,0,SpringLayout.HORIZONTAL_CENTER,jPanel2);

        layoutClone2.putConstraint(SpringLayout.VERTICAL_CENTER,jButton2,150,SpringLayout.VERTICAL_CENTER,jPanel2);
        layoutClone2.putConstraint(SpringLayout.HORIZONTAL_CENTER,jButton2,0,SpringLayout.HORIZONTAL_CENTER,jPanel2);

        layoutClone2.putConstraint(SpringLayout.VERTICAL_CENTER,jButton3,200,SpringLayout.VERTICAL_CENTER,jPanel2);
        layoutClone2.putConstraint(SpringLayout.HORIZONTAL_CENTER,jButton3,0,SpringLayout.HORIZONTAL_CENTER,jPanel2);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jButton1,-225,SpringLayout.VERTICAL_CENTER,this);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jButton1,-190,SpringLayout.HORIZONTAL_CENTER,this);

        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jscrollPane1,0,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jscrollPane1,0,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        jPanel1.setPreferredSize(new Dimension(400,500));
        jPanel1.setBackground(Color.lightGray);
        jPanel2.setPreferredSize(new Dimension(550,550));
        jPanel2.setBackground(Color.gray);
        jTextField1.setPreferredSize(new Dimension(190,50));
        jTextField2.setPreferredSize(new Dimension(400,40));
        jTextField2.setEditable(false);
        jTextField3.setPreferredSize(new Dimension(400,40));
        jTextField3.setEditable(false);
        jTextField4.setPreferredSize(new Dimension(400,40));
        jTextField4.setEditable(false);
        jTextField5.setPreferredSize(new Dimension(400,40));
        jTextField5.setEditable(false);
        jTextField6.setPreferredSize(new Dimension(400,40));
        jTextField6.setEditable(false);
        jTextField7.setPreferredSize(new Dimension(400,40));
        jTextField7.setEditable(false);

        PromptSupport.setPrompt("Customer ID", jTextField2);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField2);
        PromptSupport.setForeground(Color.GRAY, jTextField2);
        PromptSupport.setPrompt("Customer Name", jTextField3);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField3);
        PromptSupport.setForeground(Color.GRAY, jTextField3);
        PromptSupport.setPrompt("Phone", jTextField4);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField4);
        PromptSupport.setForeground(Color.GRAY, jTextField4);
        PromptSupport.setPrompt("Quantity", jTextField5);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField5);
        PromptSupport.setForeground(Color.GRAY, jTextField5);
        PromptSupport.setPrompt("Product Name", jTextField6);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField6);
        PromptSupport.setForeground(Color.GRAY, jTextField6);
        PromptSupport.setPrompt("Price", jTextField7);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField7);
        PromptSupport.setForeground(Color.GRAY, jTextField7);




        jButton1.setPreferredSize(new Dimension(190,50));
        jButton2.setPreferredSize(new Dimension(190,50));
        jButton3.setPreferredSize(new Dimension(190,50));
        jTable1.setPreferredSize(new Dimension(400,500));
        jscrollPane1.setPreferredSize(new Dimension(400,500));

        jButton1.addActionListener(billJbut);
        jButton2.addActionListener(billJbut);
        jButton3.addActionListener(billJbut);
        jTextField1.getDocument().addDocumentListener(billJbut);
        PromptSupport.setPrompt("Search by Name", jTextField1);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField1);
        PromptSupport.setForeground(Color.GRAY, jTextField1);
        ListSelectionModel selectionModel =  jTable1.getSelectionModel();
        selectionModel.addListSelectionListener(billJbut);

        jPanel1.add(jscrollPane1);
        jPanel1.setLayout(layoutClone);
        jPanel2.setLayout(layoutClone2);
        jPanel2.add(jTextField2);
        jPanel2.add(jTextField3);
        jPanel2.add(jTextField4);
        jPanel2.add(jTextField5);
        jPanel2.add(jTextField6);
        jPanel2.add(jTextField7);
        jPanel2.add(jButton2);
        jPanel2.add(jButton3);
        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jTextField1);
        this.add(jButton1);

    }
    public void initTable() {
        ArrayList<Bill> list = BillDAO.getBillDAO().selectAll();
        String[] columNames = {"ID", "Name Bill", "Status"};
        for (String columName : columNames) {
            model.addColumn(columName);
        }
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);

        jTable1.setRowHeight(40);
        int i = 1;
        for (Bill bill : list) {
            Object[] data = {bill.getID(), "Bill"+i, bill.getStatus()};
            model.addRow(data);
            i++;
        }
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }

    public JScrollPane getJscrollPane1() {
        return jscrollPane1;
    }

    public void setJscrollPane1(JScrollPane jscrollPane1) {
        this.jscrollPane1 = jscrollPane1;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public void setjTextField2(JTextField jTextField2) {
        this.jTextField2 = jTextField2;
    }

    public JTextField getjTextField3() {
        return jTextField3;
    }

    public void setjTextField3(JTextField jTextField3) {
        this.jTextField3 = jTextField3;
    }

    public JTextField getjTextField4() {
        return jTextField4;
    }

    public void setjTextField4(JTextField jTextField4) {
        this.jTextField4 = jTextField4;
    }

    public JTextField getjTextField5() {
        return jTextField5;
    }

    public void setjTextField5(JTextField jTextField5) {
        this.jTextField5 = jTextField5;
    }

    public JTextField getjTextField6() {
        return jTextField6;
    }

    public void setjTextField6(JTextField jTextField6) {
        this.jTextField6 = jTextField6;
    }

    public JTextField getjTextField7() {
        return jTextField7;
    }

    public void setjTextField7(JTextField jTextField7) {
        this.jTextField7 = jTextField7;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JButton getjButton2() {
        return jButton2;
    }

    public void setjButton2(JButton jButton2) {
        this.jButton2 = jButton2;
    }

    public JButton getjButton3() {
        return jButton3;
    }

    public void setjButton3(JButton jButton3) {
        this.jButton3 = jButton3;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public SpringLayout getLayoutMain() {
        return layoutMain;
    }

    public void setLayoutMain(SpringLayout layoutMain) {
        this.layoutMain = layoutMain;
    }

    public SpringLayout getLayoutClone() {
        return layoutClone;
    }

    public void setLayoutClone(SpringLayout layoutClone) {
        this.layoutClone = layoutClone;
    }

    public SpringLayout getLayoutClone2() {
        return layoutClone2;
    }

    public void setLayoutClone2(SpringLayout layoutClone2) {
        this.layoutClone2 = layoutClone2;
    }

    public JSeparator getSeparatorVertical4FD() {
        return separatorVertical4FD;
    }

    public void setSeparatorVertical4FD(JSeparator separatorVertical4FD) {
        this.separatorVertical4FD = separatorVertical4FD;
    }

    public int getIDtam() {
        return IDtam;
    }

    public void setIDtam(int IDtam) {
        this.IDtam = IDtam;
    }

    public static void main(String[] args) {
        new AdminView();
    }
}
