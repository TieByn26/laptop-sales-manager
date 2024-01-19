package Controller.Main.Admin;

import ViewMain.AdminView.AddLaptop;
import ViewMain.AdminView.DeleteLaptop;
import ViewMain.AdminView.TabShop;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchLaptop implements DocumentListener, ActionListener {
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
        }
    }
}
