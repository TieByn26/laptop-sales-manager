package Controller.Main.Admin;

import DAO.LaptopDAO;
import DAO.StatisticalDAO;
import Model.Laptop.Laptop;
import Model.Laptop.Statistical;
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
        int ID = Integer.parseInt(new String(addLaptop.getjTextField1().getText()));
        int count = 0;
        if (src.equals("ADDNEW")){
            for (Laptop laptop : list){
                if (laptop.getID() == ID){
                    count = 1;
                    JOptionPane.showMessageDialog(addLaptop,"ID already exists","error",JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
            if (count == 0){

                String name = addLaptop.getjTextField2().getText();
                double price = Double.parseDouble(addLaptop.getjTextField3().getText());
                double cprice = Double.parseDouble(addLaptop.getjTextField4().getText());
                String type = addLaptop.getjTextField5().getText();
                int quantity = Integer.parseInt(addLaptop.getjTextField6().getText());
                String about = addLaptop.getjTextField7().getText();
                String picture =addLaptop.getjTextField8().getText();
                Laptop newLaptop = new Laptop(ID, name, price, cprice, type, about, quantity, picture);
                LaptopDAO.getLaptopDAO().insert(newLaptop);
                JOptionPane.showMessageDialog(addLaptop,"Add successful","success",JOptionPane.YES_OPTION);
                addLaptop.repai();
                Statistical statistical = StatisticalDAO.getStatisticalDAO().select();
                StatisticalDAO.getStatisticalDAO().update(new Statistical(1, statistical.getSoluongspdaban(), statistical.getTienkiemduoc(), (statistical.getTongtien()-(cprice*quantity))));
            }
        }
    }
}
