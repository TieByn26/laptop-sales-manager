package Controller.Main.Admin;

import DAO.LaptopDAO;
import Model.Laptop.Laptop;
import ViewMain.AdminView.AddLaptop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InsertLaptop implements ActionListener {
    private AddLaptop addLaptop;


    public InsertLaptop(AddLaptop addLaptop) {
        this.addLaptop = addLaptop;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Laptop> list = LaptopDAO.getLaptopDAO().selectAll();
        String src = e.getActionCommand();
        int ID = Integer.parseInt(new String(addLaptop.getjTextField1().getText()));
        int count = 0;
        if (src.equals("INSERT")) {
            for (Laptop laptop : list){
                if (laptop.getID() == ID){
                    count = 1;
                    addLaptop.getjTextField2().setText(laptop.getName());
                    addLaptop.getjTextField3().setText(String.format("%.2f",laptop.getPrice()));
                    addLaptop.getjTextField4().setText(String.format("%.2f",laptop.getCprice()));
                    addLaptop.getjTextField5().setText(laptop.getType());
                    addLaptop.getjTextField6().setText(laptop.getQuantity()+"");
                    addLaptop.getjTextField7().setText(laptop.getAbout());
                    addLaptop.getjTextField8().setText(laptop.getPicture());
                    break;
                }
            }
            if (count == 0){
                JOptionPane.showMessageDialog(addLaptop,"ID not found","error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
