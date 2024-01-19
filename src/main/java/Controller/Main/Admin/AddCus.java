package Controller.Main.Admin;

import DAO.CustomerDAO;
import Model.Personn.Customers;
import ViewMain.AdminView.AddCustomer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class AddCus implements ActionListener {
    private AddCustomer addCustomer;

    public AddCus(AddCustomer addCustomer) {
        this.addCustomer = addCustomer;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Customers> list = CustomerDAO.getCusDAO().selectAll();
        String src = e.getActionCommand();
        int ID = Integer.parseInt(new String(addCustomer.getjTextField1().getText()));
        if (src.equals("INSERT")) {
            int count = 0;
            for (Customers customers : list){
                if (ID == customers.getCusId()){
                    count = 1;
                    addCustomer.getjTextField2().setText(customers.getName());
                    addCustomer.getjTextField3().setText(customers.getGender());
                    addCustomer.getjTextField4().setText(customers.getAddress());
                    addCustomer.getjTextField5().setText(customers.getPhone());
                    break;
                }
            }
            if (count == 0){
                JOptionPane.showMessageDialog(addCustomer,"ID not found","error",JOptionPane.ERROR_MESSAGE);
            }
        } else if (src.equals("UPDATE")){
            int count = 0;
            for (Customers customers : list){
                if (ID == customers.getCusId()){
                    count = 1;
                    String name = addCustomer.getjTextField2().getText();
                    String gender = addCustomer.getjTextField3().getText();
                    String address = addCustomer.getjTextField4().getText();
                    String phone = addCustomer.getjTextField5().getText();
                    CustomerDAO.getCusDAO().update(new Customers(ID,name,gender,address,phone));
                    JOptionPane.showMessageDialog(addCustomer,"Update successful","success",JOptionPane.YES_OPTION);
                    break;
                }
            }
            if (count == 0){
                JOptionPane.showMessageDialog(addCustomer,"ID not found","error",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            int count = 0;
            for (Customers customers : list){
                if (ID == customers.getCusId()){
                    count = 1;
                    CustomerDAO.getCusDAO().delete(customers);
                    JOptionPane.showMessageDialog(addCustomer,"Delete successful","success",JOptionPane.YES_OPTION);
                    break;
                }
            }
            if (count == 0){
                JOptionPane.showMessageDialog(addCustomer,"ID not found","error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
