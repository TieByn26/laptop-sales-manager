package Controller.Main.Admin;

import ViewMain.AdminView.TabShop;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class SearchLaptop implements DocumentListener {
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
}
