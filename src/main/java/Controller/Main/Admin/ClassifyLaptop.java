package Controller.Main.Admin;

import ViewMain.AdminView.TabShop;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassifyLaptop implements ChangeListener , ActionListener {
    private TabShop tabShop;

    public ClassifyLaptop(TabShop tabShop) {
        this.tabShop = tabShop;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        updateTable();
    }

    private void updateTable() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabShop.getModel());
        tabShop.getjTable1().setRowSorter(sorter);
        if (tabShop.getjCheckBox1().isSelected()) {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + "Office", 4));
        } else if (tabShop.getjCheckBox2().isSelected()) {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + "Gaming", 4));
        } else if (tabShop.getjCheckBox3().isSelected()) {
            sorter.setRowFilter(RowFilter.regexFilter("^0$", 5));
        } else if (tabShop.getjCheckBox4().isSelected()) {
            sorter.setRowFilter(RowFilter.notFilter(RowFilter.regexFilter("^0$", 5)));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
