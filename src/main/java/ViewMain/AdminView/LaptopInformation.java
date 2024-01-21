package ViewMain.AdminView;

import Controller.Main.Admin.Addnew;
import Controller.Main.Admin.Addpicture;
import Controller.Main.Admin.InsertLaptop;
import Controller.Main.Admin.UpdateLaptop;
import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import java.awt.*;

public class LaptopInformation extends JFrame {
    private ImageIcon imageIcon1;
    private JPanel jPanel2;
    private JPanel jPanel1;
    private SpringLayout layoutMain = new SpringLayout();
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;
    private JTextField jTextField6;
    private JTextArea jTextArea;

    public LaptopInformation(){
        this.setSize(700,450);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.initj();
        this.setVisible(true);
    }
    public void initj(){

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jTextField3 = new JTextField();
        jTextField4 = new JTextField();
        jTextField5 = new JTextField();
        jTextField6 = new JTextField();
        jTextArea = new JTextArea();

        jPanel1.setLayout(layoutMain);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField1,-180,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField1,170,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField2,-145,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField2,170,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField3,-110,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField3,170,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField4,-75,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField4,170,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField5,-40,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField5,170,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField6,-5,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField6,170,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jTextArea,65,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextArea,170,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jPanel2,-45,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jPanel2,-160,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        PromptSupport.setPrompt("Product ID", jTextField1);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField1);
        PromptSupport.setForeground(Color.GRAY, jTextField1);

        PromptSupport.setPrompt("Product's name", jTextField2);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField2);
        PromptSupport.setForeground(Color.GRAY, jTextField2);

        PromptSupport.setPrompt("Product price", jTextField3);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField3);
        PromptSupport.setForeground(Color.GRAY, jTextField3);

        PromptSupport.setPrompt("Product type", jTextField4);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField4);
        PromptSupport.setForeground(Color.GRAY, jTextField4);

        PromptSupport.setPrompt("The number of products", jTextField5);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField5);
        PromptSupport.setForeground(Color.GRAY, jTextField5);

        PromptSupport.setPrompt("Status", jTextField6);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField6);
        PromptSupport.setForeground(Color.GRAY, jTextField6);

        PromptSupport.setPrompt("Product information", jTextArea);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextArea);
        PromptSupport.setForeground(Color.GRAY, jTextArea);


        jPanel1.setPreferredSize(new Dimension(700,450));
        jPanel2.setPreferredSize(new Dimension(300,300));
        jPanel2.setBackground(Color.WHITE);
        jTextField1.setPreferredSize(new Dimension(300,30));
        jTextField1.setEditable(false);
        jTextField2.setPreferredSize(new Dimension(300,30));
        jTextField2.setEditable(false);
        jTextField3.setPreferredSize(new Dimension(300,30));
        jTextField3.setEditable(false);
        jTextField4.setPreferredSize(new Dimension(300,30));
        jTextField4.setEditable(false);
        jTextField5.setPreferredSize(new Dimension(300,30));
        jTextField5.setEditable(false);
        jTextField6.setPreferredSize(new Dimension(300,30));
        jTextField6.setEditable(false);
        jTextArea.setPreferredSize(new Dimension(300,80));
        jTextArea.setLineWrap(true);
        jTextArea.setEditable(false);

        ImageIcon imageIcon = new ImageIcon("D:\\PictureForJava\\Nenabout.jpg");
        ImageIcon imageIcon1 = new ImageIcon(imageIcon.getImage().getScaledInstance(700,450,Image.SCALE_SMOOTH));
        JLabel jLabel = new JLabel(imageIcon1);

        jPanel1.add(jTextField1);
        jPanel1.add(jTextField2);
        jPanel1.add(jTextField3);
        jPanel1.add(jTextField4);
        jPanel1.add(jTextField5);
        jPanel1.add(jTextField6);
        jPanel1.add(jTextArea);
        jPanel1.add(jPanel2);
        this.add(jPanel1);
        jPanel1.add(jLabel);

    }
    public void repai(){
        this.revalidate();
        this.repaint();
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public SpringLayout getLayoutMain() {
        return layoutMain;
    }

    public void setLayoutMain(SpringLayout layoutMain) {
        this.layoutMain = layoutMain;
    }

    public JTextField getjTextField1() {
        return jTextField1;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.jTextField1 = jTextField1;
    }

    public JTextField getjTextField2() {
        return jTextField2;
    }

    public void setjTextField2(JTextField jTextField2) {
        this.jTextField2 = jTextField2;
    }

    public JTextField getjTextField3() {
        return jTextField3;
    }

    public void setjTextField3(JTextField jTextField3) {
        this.jTextField3 = jTextField3;
    }

    public JTextField getjTextField4() {
        return jTextField4;
    }

    public void setjTextField4(JTextField jTextField4) {
        this.jTextField4 = jTextField4;
    }

    public JTextField getjTextField5() {
        return jTextField5;
    }

    public void setjTextField5(JTextField jTextField5) {
        this.jTextField5 = jTextField5;
    }

    public JTextField getjTextField6() {
        return jTextField6;
    }

    public void setjTextField6(JTextField jTextField6) {
        this.jTextField6 = jTextField6;
    }

    public JTextArea getjTextArea() {
        return jTextArea;
    }

    public void setjTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    public ImageIcon getImageIcon1() {
        return imageIcon1;
    }

    public void setImageIcon1(ImageIcon imageIcon1) {
        this.imageIcon1 = imageIcon1;
    }

    public static void main(String[] args) {
        new LaptopInformation();
    }
}
