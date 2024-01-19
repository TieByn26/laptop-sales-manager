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

public class InsertLaptop2 implements ActionListener {

    private DeleteLaptop deleteLaptop;

    public InsertLaptop2(DeleteLaptop deleteLaptop) {
        this.deleteLaptop = deleteLaptop;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Laptop> list = LaptopDAO.getLaptopDAO().selectAll();
        String src = e.getActionCommand();
        int count = 0;
        if (src.equals("INSERT")) {
            int ID = Integer.parseInt(new String(deleteLaptop.getjTextField1().getText()));
            for (Laptop laptop : list){
                if (laptop.getID() == ID){
                    count = 1;
                    deleteLaptop.getjTextField2().setText(laptop.getName());
                    deleteLaptop.getjTextField3().setText(String.format("%.2f",laptop.getPrice()));
                    deleteLaptop.getjTextField4().setText(String.format("%.2f",laptop.getCprice()));
                    deleteLaptop.getjTextField5().setText(laptop.getType());
                    deleteLaptop.getjTextField6().setText(laptop.getQuantity()+"");
                    deleteLaptop.getjTextField7().setText(laptop.getAbout());
                    deleteLaptop.getjTextField8().setText(laptop.getPicture());
                    deleteLaptop.setImageIcon1(new ImageIcon(laptop.getPicture()));
                    deleteLaptop.getjPanel2().removeAll();
                    ImageIcon imageIcon = new ImageIcon(deleteLaptop.getImageIcon1().getImage().getScaledInstance(300, 280, Image.SCALE_SMOOTH));
                    JLabel imageJlabel = new JLabel(imageIcon);
                    deleteLaptop.getjPanel2().add(imageJlabel);
                    deleteLaptop.revalidate();
                    deleteLaptop.repaint();
                    break;
                }
            }
            if (count == 0 || deleteLaptop.getjTextField1().getText().isEmpty()){
                JOptionPane.showMessageDialog(deleteLaptop,"ID not found","error",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            int ID = Integer.parseInt(new String(deleteLaptop.getjTextField1().getText()));
            for (Laptop laptop : list){
                if (laptop.getID() == ID){
                    count = 1;
                    LaptopDAO.getLaptopDAO().delete(laptop);
                    JOptionPane.showMessageDialog(deleteLaptop,"Delete successful","success",JOptionPane.YES_OPTION);
                    break;
                }
            }
            if (count == 0){
                JOptionPane.showMessageDialog(deleteLaptop,"ID not found","error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
