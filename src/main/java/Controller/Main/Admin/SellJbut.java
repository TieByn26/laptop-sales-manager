package Controller.Main.Admin;

import DAO.BillDAO;
import DAO.CustomerDAO;
import DAO.LaptopDAO;
import Model.Laptop.Bill;
import Model.Laptop.Laptop;
import Model.Personn.Customers;
import ViewMain.AdminView.AddCustomer;
import ViewMain.AdminView.TabSell;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SellJbut implements ActionListener, DocumentListener, ListSelectionListener {
    private TabSell tabSell;

    public SellJbut(TabSell tabSell) {
        this.tabSell = tabSell;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Customer")){
            new AddCustomer();
        }else if (src.equals("Customerr")){
            ArrayList<Customers> list = CustomerDAO.getCusDAO().selectAll();
            int ID = Integer.parseInt(tabSell.getjTextField2().getText());
            int count = 0;
            for (Customers customers : list){
                if (customers.getCusId() == ID){
                    tabSell.getjTextField3().setText(customers.getName());
                    tabSell.getjTextField4().setText(customers.getPhone());
                    count = 1;
                    break;
                }
            }
            if (count == 0){
                JOptionPane.showMessageDialog(tabSell,"ID not available","error",JOptionPane.ERROR_MESSAGE);
            }
        }else {
            if (tabSell.getjTextField2().getText().isEmpty()){
                JOptionPane.showMessageDialog(tabSell,"ID not available","error",JOptionPane.ERROR_MESSAGE);
            } else {
                ArrayList<Customers> list = CustomerDAO.getCusDAO().selectAll();
                int ID = Integer.parseInt(tabSell.getjTextField2().getText());
                int count = 0;
                for (Customers customers : list){
                    if (customers.getCusId() == ID && tabSell.getIDtam() != 0){
                        int Cusid = customers.getCusId();
                        int lapid = tabSell.getIDtam();
                        String Status = "Unpaid";
                        BillDAO.getBillDAO().insert(new Bill(Cusid,lapid,Status));
                        JOptionPane.showMessageDialog(tabSell,"Create Bill successful","success",JOptionPane.YES_OPTION);
                        count = 1;
                        break;
                    }
                }
                if (count == 0 ){
                    JOptionPane.showMessageDialog(tabSell,"ID not available","error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        updateTable();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        updateTable();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        updateTable();
    }
    private void updateTable() {
        String searchTextName = tabSell.getjTextField1().getText().toLowerCase();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabSell.getModel());
        tabSell.getjTable1().setRowSorter(sorter);

        if (!searchTextName.isEmpty()) {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTextName, 1));
        } else {
            sorter.setRowFilter(null);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && tabSell.getjTable1().getSelectedRow() != -1) {
            ArrayList<Laptop> list = LaptopDAO.getLaptopDAO().selectAll();
            int selectedRow = tabSell.getjTable1().getSelectedRow();
            String ID1 = String.valueOf(tabSell.getjTable1().getValueAt(selectedRow, 0));
            int ID = Integer.parseInt(ID1);
            int count = 0;
            for (Laptop laptop : list){
                if (ID == laptop.getID() && laptop.getQuantity() != 0){
                    tabSell.getjTextField5().setText(1+"");
                    tabSell.getjTextField6().setText(laptop.getName());
                    tabSell.getjTextField7().setText(String.format("%.2f",laptop.getPrice()));
                    tabSell.setIDtam(laptop.getID());
                    count = 1;
                    break;
                }
            }
            if (count == 0){
                JOptionPane.showMessageDialog(tabSell,"ID not available or out of stock","error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
