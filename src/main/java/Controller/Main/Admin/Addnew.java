package Controller.Main.Admin;

import DAO.CustomerDAO;
import DAO.LaptopDAO;
import DAO.StatisticalDAO;
import Model.Laptop.Laptop;
import Model.Laptop.Statistical;
import Model.Personn.Customers;
import ViewMain.AdminView.AddLaptop;
import ViewMain.AdminView.TabShop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Addnew implements ActionListener {
    private AddLaptop addLaptop;

    public Addnew(AddLaptop addLaptop) {
        this.addLaptop = addLaptop;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Laptop> list = LaptopDAO.getLaptopDAO().selectAll();
        String src = e.getActionCommand();
        int count = 0;
        if (src.equals("ADDNEW")){
            try {
                String input2 = addLaptop.getjTextField1().getText();
                String regex = "^[0-9]+$";
                if (!input2.matches(regex)) {
                    JOptionPane.showMessageDialog(null, "ID chỉ được nhập số", "error", JOptionPane.ERROR_MESSAGE);
                    addLaptop.getjTextField1().setText("");
                }else {
                    int ID = Integer.parseInt(addLaptop.getjTextField1().getText());
                    for (Laptop laptop : list){
                        if (laptop.getID() == ID){
                            count = 1;
                            JOptionPane.showMessageDialog(addLaptop,"ID already exists","error",JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
            if (count == 0){
                int ID = Integer.parseInt(addLaptop.getjTextField1().getText());
                String name = addLaptop.getjTextField2().getText();
                double price = Double.parseDouble(addLaptop.getjTextField3().getText());
                double cprice = Double.parseDouble(addLaptop.getjTextField4().getText());
                String type = addLaptop.getjTextField5().getText();
                int quantity = Integer.parseInt(addLaptop.getjTextField6().getText());
                String about = addLaptop.getjTextField7().getText();
                String picture =addLaptop.getjTextField8().getText();

                try {
                    String input = addLaptop.getjTextField3().getText();
                    String input1 = addLaptop.getjTextField4().getText();
                    String regex1 = "^[0-9]{1,100000000}$";if (!input.matches(regex1)){
                        JOptionPane.showMessageDialog(null, "Giá chỉ được nhập số", "error", JOptionPane.ERROR_MESSAGE);
                        addLaptop.getjTextField3().setText("");
                    } else if (!input1.matches(regex1)){
                        JOptionPane.showMessageDialog(null, "Giá vốn chỉ được nhập số", "error", JOptionPane.ERROR_MESSAGE);
                        addLaptop.getjTextField4().setText("");
                    } else {
                        JOptionPane.showMessageDialog(null,"Add successful","success",JOptionPane.YES_OPTION);
                        Laptop newLaptop = new Laptop(ID, name, price, cprice, type, about, quantity, picture);
                        LaptopDAO.getLaptopDAO().insert(newLaptop);
                        Statistical statistical = StatisticalDAO.getStatisticalDAO().select();
                        StatisticalDAO.getStatisticalDAO().update(new Statistical(1, statistical.getSoluongspdaban(), statistical.getTienkiemduoc(), (statistical.getTongtien()-(cprice*quantity))));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
