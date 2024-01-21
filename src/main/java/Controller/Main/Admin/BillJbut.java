package Controller.Main.Admin;

import DAO.BillDAO;
import DAO.CustomerDAO;
import DAO.LaptopDAO;
import DAO.StatisticalDAO;
import Model.Laptop.Bill;
import Model.Laptop.Laptop;
import Model.Laptop.Statistical;
import Model.Personn.Customers;
import ViewMain.AdminView.TabBill;

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

public class BillJbut implements ActionListener, DocumentListener, ListSelectionListener {
    private TabBill tabBill;

    public BillJbut(TabBill tabBill) {
        this.tabBill = tabBill;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Refresh")) {
            tabBill.getModel().setRowCount(0);
            ArrayList<Bill> list = BillDAO.getBillDAO().selectAll();
            tabBill.getjTable1().getColumnModel().getColumn(0).setPreferredWidth(100);
            tabBill.getjTable1().getColumnModel().getColumn(1).setPreferredWidth(250);
            tabBill.getjTable1().getColumnModel().getColumn(2).setPreferredWidth(150);
            tabBill.getjTable1().setRowHeight(40);
            int i = 1;
            for (Bill bill : list) {
                Object[] data = {bill.getID(), "Bill"+i, bill.getStatus()};
                tabBill.getModel().addRow(data);
                i++;
            }
        } else if (src.equals("Pay")) {
            double tientam = Double.parseDouble(tabBill.getjTextField7().getText());
            Statistical statistical = StatisticalDAO.getStatisticalDAO().select();
            int ssptang = statistical.getSoluongspdaban()+1;
            Double tienkiemduoc = statistical.getTienkiemduoc() + tientam;
            Double tongtien = statistical.getTongtien()+ tientam;
            StatisticalDAO.getStatisticalDAO().update(new Statistical(1,ssptang,tienkiemduoc,tongtien));
            ArrayList<Laptop> list1 = LaptopDAO.getLaptopDAO().selectAll();
            ArrayList<Bill> list2 = BillDAO.getBillDAO().selectAll();
            for (Bill bill : list2){
                if (bill.getID() == tabBill.getIDtam()){
                    for (Laptop laptop : list1){
                        if (laptop.getID() == bill.getLapID()){
                            int soluong = laptop.getQuantity() - 1;
                            LaptopDAO.getLaptopDAO().update2(new Laptop(bill.getLapID(), soluong));
                            break;
                        }
                    }
                    break;
                }
            }
            BillDAO.getBillDAO().update(new Bill(tabBill.getIDtam(),1,1,"Paid"));
            tabBill.getjPanel2().remove(tabBill.getjButton2());
            tabBill.getjPanel2().repaint();
            tabBill.getjPanel2().revalidate();
        } else {
            if (tabBill.getIDtam() == 0){
                JOptionPane.showMessageDialog(tabBill,"ID not available","error",JOptionPane.ERROR_MESSAGE);
            }else {
                  BillDAO.getBillDAO().delete(new Bill(tabBill.getIDtam()));
                JOptionPane.showMessageDialog(tabBill,"Delete successful","success",JOptionPane.YES_OPTION);
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
        String searchTextName = tabBill.getjTextField1().getText().toLowerCase();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabBill.getModel());
        tabBill.getjTable1().setRowSorter(sorter);

        if (!searchTextName.isEmpty()) {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTextName, 1));
        } else {
            sorter.setRowFilter(null);
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && tabBill.getjTable1().getSelectedRow() != -1) {
            ArrayList<Laptop> list = LaptopDAO.getLaptopDAO().selectAll();
            ArrayList<Bill> list1 = BillDAO.getBillDAO().selectAll();
            ArrayList<Customers> list2 = CustomerDAO.getCusDAO().selectAll();
            int selectedRow = tabBill.getjTable1().getSelectedRow();
            String ID1 = String.valueOf(tabBill.getjTable1().getValueAt(selectedRow, 0));
            int ID = Integer.parseInt(ID1);
            tabBill.setIDtam(ID);
            for (Bill bill : list1){
                if (bill.getID() == ID){
                    if (bill.getStatus().equals("Paid")){
                        tabBill.getjPanel2().remove(tabBill.getjButton2());
                    } else {
                        tabBill.getjPanel2().remove(tabBill.getjButton2());
                        tabBill.getLayoutClone2().putConstraint(SpringLayout.VERTICAL_CENTER,tabBill.getjButton2(),150,SpringLayout.VERTICAL_CENTER,tabBill.getjPanel2());
                        tabBill.getLayoutClone2().putConstraint(SpringLayout.HORIZONTAL_CENTER,tabBill.getjButton2(),0,SpringLayout.HORIZONTAL_CENTER,tabBill.getjPanel2());
                        tabBill.getjPanel2().add(tabBill.getjButton2());
                    }
                    for (Laptop laptop : list){
                        if (bill.getLapID() == laptop.getID()){
                            tabBill.getjTextField5().setText(1+"");
                            tabBill.getjTextField6().setText(laptop.getName());
                            tabBill.getjTextField7().setText(String.format("%.2f",laptop.getPrice()));
                            break;
                        }
                    }
                    for (Customers customers : list2){
                        if (bill.getCusID() == customers.getCusId()){
                            tabBill.getjTextField2().setText(customers.getCusId()+"");
                            tabBill.getjTextField3().setText(customers.getName());
                            tabBill.getjTextField4().setText(customers.getPhone());
                            break;
                        }
                    }
                    tabBill.getjPanel2().repaint();
                    tabBill.getjPanel2().revalidate();
                    break;
                }
            }
        }
    }
}
