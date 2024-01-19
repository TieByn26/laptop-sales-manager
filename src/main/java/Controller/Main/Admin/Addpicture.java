package Controller.Main.Admin;

import ViewMain.AdminView.AddLaptop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class Addpicture implements ActionListener {
    private AddLaptop addLaptop;

    public Addpicture(AddLaptop addLaptop) {
        this.addLaptop = addLaptop;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser("D:\\PictureForJava");
        int result = fileChooser.showOpenDialog(addLaptop);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            addLaptop.getjTextField8().setText(filePath.replace("\\", "\\\\"));
            addLaptop.setImageIcon1(new ImageIcon(filePath.replace("\\", "\\\\")));
            addLaptop.getjPanel2().removeAll();
            ImageIcon imageIcon = new ImageIcon(addLaptop.getImageIcon1().getImage().getScaledInstance(300, 280, Image.SCALE_SMOOTH));
            JLabel imageJlabel = new JLabel(imageIcon);
            addLaptop.getjPanel2().add(imageJlabel);
            addLaptop.revalidate();
            addLaptop.repaint();
        }
    }
}
