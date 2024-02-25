package Controller.Main.Admin;

import DAO.LaptopDAO;
import Model.Laptop.Laptop;
import ViewMain.AdminView.AddLaptop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdateLaptop implements ActionListener {
    private AddLaptop addLaptop;

    public UpdateLaptop(AddLaptop addLaptop) {
        this.addLaptop = addLaptop;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Laptop> list = LaptopDAO.getLaptopDAO().selectAll();
        String src = e.getActionCommand();
        int ID = Integer.parseInt(new String(addLaptop.getjTextField1().getText()));
        int count = 0;
        if (src.equals("UPDATE")) {
            for (Laptop laptop : list){
                if (laptop.getID() == ID){
                    count = 1;
                    String name = addLaptop.getjTextField2().getText();
                    double price = Double.parseDouble(addLaptop.getjTextField4().getText());
                    double cprice = Double.parseDouble(addLaptop.getjTextField4().getText());
                    String type = addLaptop.getjTextField5().getText();
                    int quantity = Integer.parseInt(addLaptop.getjTextField6().getText());
                    String about = addLaptop.getjTextField7().getText();
                    String picture =addLaptop.getjTextField8().getText();
                    LaptopDAO.getLaptopDAO().update(new Laptop(ID, name,price,cprice,type,about,quantity,picture));
                    JOptionPane.showMessageDialog(addLaptop,"Update successful","success",JOptionPane.YES_OPTION);
                    break;
                }
            }
            if (count == 0){
                JOptionPane.showMessageDialog(addLaptop,"ID not found","error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
