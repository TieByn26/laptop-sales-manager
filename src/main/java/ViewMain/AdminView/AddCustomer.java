package ViewMain.AdminView;

import Controller.Main.Admin.*;
import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import java.awt.*;

public class AddCustomer extends JFrame {
    private AddCus addCus = new AddCus(this);

    private ImageIcon imageIcon1;
    private JPanel jPanel2;
    private JPanel jPanel1;
    private SpringLayout layoutMain = new SpringLayout();
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private JTextField jTextField4;
    private JTextField jTextField5;

    public AddCustomer(){
        this.setSize(600,400);
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
        jButton1 = new JButton("INSERT");
        jButton2 = new JButton("ADDNEW");
        jButton4 = new JButton("UPDATE");

        jPanel1.setLayout(layoutMain);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField1,-150,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField1,170,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField2,-95,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField2,170,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField3,-40,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField3,170,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField4,15,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField4,170,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jTextField5,70,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jTextField5,170,SpringLayout.HORIZONTAL_CENTER,jPanel1);


        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jButton1,130,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jButton1,0,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jButton2,130,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jButton2,180,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jButton4,130,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jButton4,-170,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER,jPanel2,-45,SpringLayout.VERTICAL_CENTER,jPanel1);
        layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER,jPanel2,-135,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        PromptSupport.setPrompt("Customer ID", jTextField1);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField1);
        PromptSupport.setForeground(Color.GRAY, jTextField1);

        PromptSupport.setPrompt("Customer name", jTextField2);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField2);
        PromptSupport.setForeground(Color.GRAY, jTextField2);

        PromptSupport.setPrompt("Gender", jTextField3);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField3);
        PromptSupport.setForeground(Color.GRAY, jTextField3);

        PromptSupport.setPrompt("Address", jTextField4);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField4);
        PromptSupport.setForeground(Color.GRAY, jTextField4);

        PromptSupport.setPrompt("Phone", jTextField5);
        PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jTextField5);
        PromptSupport.setForeground(Color.GRAY, jTextField5);


        jPanel1.setPreferredSize(new Dimension(600,400));
        jPanel2.setPreferredSize(new Dimension(260,260));
        jPanel2.setBackground(Color.YELLOW);
        jTextField1.setPreferredSize(new Dimension(300,50));
        jTextField2.setPreferredSize(new Dimension(300,50));
        jTextField3.setPreferredSize(new Dimension(300,50));
        jTextField4.setPreferredSize(new Dimension(300,50));
        jTextField5.setPreferredSize(new Dimension(300,50));
        jButton1.setPreferredSize(new Dimension(150,50));
        jButton1.addActionListener(addCus);
        jButton2.setPreferredSize(new Dimension(150,50));
        jButton2.addActionListener(addCus);
        jButton4.setPreferredSize(new Dimension(150,50));
        jButton4.addActionListener(addCus);
        jPanel1.add(jTextField1);
        jPanel1.add(jTextField2);
        jPanel1.add(jTextField3);
        jPanel1.add(jTextField4);
        jPanel1.add(jTextField5);
        jPanel1.add(jButton1);
        jPanel1.add(jButton2);
        jPanel1.add(jButton4);
        jPanel1.add(jPanel2);
        this.add(jPanel1);

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

    public JButton getjButton1() {
        return jButton1;
    }

    public void setjButton1(JButton jButton1) {
        this.jButton1 = jButton1;
    }

    public JButton getjButton2() {
        return jButton2;
    }

    public void setjButton2(JButton jButton2) {
        this.jButton2 = jButton2;
    }

    public JButton getjButton3() {
        return jButton3;
    }

    public void setjButton3(JButton jButton3) {
        this.jButton3 = jButton3;
    }

    public JButton getjButton4() {
        return jButton4;
    }

    public void setjButton4(JButton jButton4) {
        this.jButton4 = jButton4;
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

    public ImageIcon getImageIcon1() {
        return imageIcon1;
    }

    public void setImageIcon1(ImageIcon imageIcon1) {
        this.imageIcon1 = imageIcon1;
    }

    public static void main(String[] args) {
        new AddCustomer();
    }
}
