package ViewMain.AdminView;

import javax.swing.*;
import java.awt.*;

public class TabStatistical extends JPanel {
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private SpringLayout springLayout = new SpringLayout();
    private SpringLayout springLayout1 = new SpringLayout();
    private SpringLayout springLayout2 = new SpringLayout();
    private SpringLayout springLayout3 = new SpringLayout();

    public TabStatistical(){
        this.setPreferredSize(new Dimension(1020,750));
        this.setBackground(Color.lightGray);
        this.init();
    }
    public void init(){
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel("Sold");
        jLabel5 = new JLabel("Profit");
        jLabel6 = new JLabel("Funds");
        this.setLayout(springLayout);
        jPanel1.setLayout(springLayout1);
        jPanel2.setLayout(springLayout2);
        jPanel3.setLayout(springLayout3);
        Font font = new Font("Arial",Font.BOLD,30);

        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER,jPanel1,0,SpringLayout.VERTICAL_CENTER,this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,jPanel1,260,SpringLayout.HORIZONTAL_CENTER,this);

        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER,jPanel2,0,SpringLayout.VERTICAL_CENTER,this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,jPanel2,0,SpringLayout.HORIZONTAL_CENTER,this);

        springLayout.putConstraint(SpringLayout.VERTICAL_CENTER,jPanel3,0,SpringLayout.VERTICAL_CENTER,this);
        springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER,jPanel3,-260,SpringLayout.HORIZONTAL_CENTER,this);

        springLayout1.putConstraint(SpringLayout.VERTICAL_CENTER,jLabel1,30,SpringLayout.VERTICAL_CENTER,jPanel1);
        springLayout1.putConstraint(SpringLayout.HORIZONTAL_CENTER,jLabel1,7,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        springLayout1.putConstraint(SpringLayout.VERTICAL_CENTER,jLabel4,-35,SpringLayout.VERTICAL_CENTER,jPanel1);
        springLayout1.putConstraint(SpringLayout.HORIZONTAL_CENTER,jLabel4,0,SpringLayout.HORIZONTAL_CENTER,jPanel1);

        springLayout2.putConstraint(SpringLayout.VERTICAL_CENTER,jLabel2,30,SpringLayout.VERTICAL_CENTER,jPanel2);
        springLayout2.putConstraint(SpringLayout.HORIZONTAL_CENTER,jLabel2,0,SpringLayout.HORIZONTAL_CENTER,jPanel2);

        springLayout2.putConstraint(SpringLayout.VERTICAL_CENTER,jLabel5,-35,SpringLayout.VERTICAL_CENTER,jPanel2);
        springLayout2.putConstraint(SpringLayout.HORIZONTAL_CENTER,jLabel5,0,SpringLayout.HORIZONTAL_CENTER,jPanel2);

        springLayout3.putConstraint(SpringLayout.VERTICAL_CENTER,jLabel3,30,SpringLayout.VERTICAL_CENTER,jPanel3);
        springLayout3.putConstraint(SpringLayout.HORIZONTAL_CENTER,jLabel3,0,SpringLayout.HORIZONTAL_CENTER,jPanel3);

        springLayout3.putConstraint(SpringLayout.VERTICAL_CENTER,jLabel6,-35,SpringLayout.VERTICAL_CENTER,jPanel3);
        springLayout3.putConstraint(SpringLayout.HORIZONTAL_CENTER,jLabel6,0,SpringLayout.HORIZONTAL_CENTER,jPanel3);

        jPanel1.setPreferredSize(new Dimension(250,250));
        jPanel1.setOpaque(true);
        jPanel2.setPreferredSize(new Dimension(250,250));
        jPanel2.setOpaque(true);
        jPanel3.setPreferredSize(new Dimension(250,250));
        jPanel3.setOpaque(true);

        jLabel1.setFont(font);
        jLabel2.setFont(font);
        jLabel3.setFont(font);
        jLabel4.setFont(font);
        jLabel5.setFont(font);
        jLabel6.setFont(font);

        jPanel1.add(jLabel1);
        jPanel1.add(jLabel4);
        jPanel2.add(jLabel2);
        jPanel2.add(jLabel5);
        jPanel3.add(jLabel3);
        jPanel3.add(jLabel6);
        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public SpringLayout getSpringLayout() {
        return springLayout;
    }

    public void setSpringLayout(SpringLayout springLayout) {
        this.springLayout = springLayout;
    }
}
