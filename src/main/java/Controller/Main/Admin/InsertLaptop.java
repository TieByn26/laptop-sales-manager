package Controller.Main.Admin;

import DAO.LaptopDAO;
import Model.Laptop.Laptop;
import ViewMain.AdminView.AddLaptop;
import ViewMain.AdminView.DeleteLaptop;

import javax.swing.*;
import java.awt.*;
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
        int count = 0;
        if (src.equals("INSERT")) {
            int ID = Integer.parseInt(new String(addLaptop.getjTextField1().getText()));
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
                    addLaptop.setImageIcon1(new ImageIcon(laptop.getPicture()));
                    addLaptop.getjPanel2().removeAll();
                    ImageIcon imageIcon = new ImageIcon(addLaptop.getImageIcon1().getImage().getScaledInstance(300, 280, Image.SCALE_SMOOTH));
                    JLabel imageJlabel = new JLabel(imageIcon);
                    addLaptop.getjPanel2().add(imageJlabel);
                    addLaptop.revalidate();
                    addLaptop.repaint();
                    break;
                }
            }
            if (count == 0){
                JOptionPane.showMessageDialog(addLaptop,"ID not found","error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
