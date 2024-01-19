package Controller.Main.Admin;

import ViewMain.AdminView.AddLaptop;

import javax.swing.*;
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
        }
    }
}
