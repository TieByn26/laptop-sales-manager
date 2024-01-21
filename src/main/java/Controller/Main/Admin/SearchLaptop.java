package Controller.Main.Admin;

import DAO.BillDAO;
import DAO.LaptopDAO;
import Model.Laptop.Bill;
import Model.Laptop.Laptop;
import ViewMain.AdminView.AddLaptop;
import ViewMain.AdminView.DeleteLaptop;
import ViewMain.AdminView.LaptopInformation;
import ViewMain.AdminView.TabShop;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchLaptop implements DocumentListener, ActionListener, ListSelectionListener {
    private TabShop tabShop;

    public SearchLaptop(TabShop tabShop) {
        this.tabShop = tabShop;
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
        String searchTextID = tabShop.getjTextField1().getText().toLowerCase();
        String searchTextName = tabShop.getjTextField2().getText().toLowerCase();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabShop.getModel());
        tabShop.getjTable1().setRowSorter(sorter);

        if (!searchTextID.isEmpty()) {
            sorter.setRowFilter(RowFilter.regexFilter(searchTextID, 0));
        } else if (!searchTextName.isEmpty()) {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchTextName, 1));
        } else {
            sorter.setRowFilter(null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Add Laptop")){
            new AddLaptop();
        } else if (src.equals("Delete Laptop")){
            new DeleteLaptop();
        } else {
            ArrayList<Laptop> list = LaptopDAO.getLaptopDAO().selectAll();
            tabShop.getModel().setRowCount(0);
            tabShop.getjTable1().getColumnModel().getColumn(0).setPreferredWidth(100);
            tabShop.getjTable1().getColumnModel().getColumn(1).setPreferredWidth(500);
            tabShop.getjTable1().getColumnModel().getColumn(2).setPreferredWidth(250);
            tabShop.getjTable1().getColumnModel().getColumn(3).setPreferredWidth(250);
            tabShop.getjTable1().getColumnModel().getColumn(4).setPreferredWidth(250);
            tabShop.getjTable1().getColumnModel().getColumn(5).setPreferredWidth(100);
            tabShop.getjTable1().setRowHeight(30);
            for (Laptop laptop : list){
                Object[] data = {laptop.getID(),laptop.getName(),laptop.getPrice(),laptop.getCprice(),laptop.getType(),laptop.getQuantity()};
                tabShop.getModel().addRow(data);
            }
            tabShop.getButtonGroup().clearSelection();
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && tabShop.getjTable1().getSelectedRow() != -1){
            LaptopInformation infor = new LaptopInformation();
            int selectedRow = tabShop.getjTable1().getSelectedRow();
            String ID1 = String.valueOf(tabShop.getjTable1().getValueAt(selectedRow, 0));
            int ID = Integer.parseInt(ID1);
            ArrayList<Laptop> list = LaptopDAO.getLaptopDAO().selectAll();
            for (Laptop laptop : list){
                if (laptop.getID() == ID){
                    infor.getjTextField1().setText(laptop.getID()+"");
                    infor.getjTextField2().setText(laptop.getName());
                    infor.getjTextField3().setText(String.format("%.2f",laptop.getPrice()));
                    infor.getjTextField4().setText(laptop.getType());
                    infor.getjTextField5().setText(laptop.getQuantity()+"");
                    if (laptop.getQuantity() > 0){
                        infor.getjTextField6().setText("Stocking");
                    }else{
                        infor.getjTextField6().setText("out of stock");
                    }
                    infor.getjTextArea().setText(laptop.getAbout());
                    ImageIcon imageIcon = new ImageIcon(laptop.getPicture());
                    ImageIcon imageIcon1 = new ImageIcon(imageIcon.getImage().getScaledInstance(300,300, Image.SCALE_SMOOTH));
                    JLabel imageLabel = new JLabel(imageIcon1);
                    infor.getjPanel2().add(imageLabel);
                }
            }
        }
    }
}
