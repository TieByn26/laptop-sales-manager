package Controller.Log;

import DAO.LoginDAO;
import Model.Login.Login;
import ViewLogin.ViewCapcha;
import ViewLogin.ViewForgot;
import ViewLogin.ViewLog;
import ViewMain.AdminView.AdminView;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

public class Capcha implements ActionListener, MouseListener {
    private ViewCapcha capcha;
    private String user;
    private AdminView adminView ;
    private JButton jButton;

    private ArrayList<Login> list = LoginDAO.getLogin().selectAll();
    private int rand;
    final String from = "dxuantienn@gmail.com";
    final String passw = "pspofvstxlfpouin";
    final String to = "dxuantien5@gmail.com";

    public Capcha(ViewCapcha capcha) {
        this.capcha = capcha;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Model.Login.Login login : list){
            setUser(login.getUserName());
        }
        String src = e.getActionCommand();
        if (src.equals("SendMail")){
            if (capcha.getJt().getText().equals(getUser())){
                rand = (int)((Math.random()+1)*1000);
                Properties pro = new Properties();
                pro.put("mail.smtp.host","smtp.gmail.com");
                pro.put("mail.smtp.port","587");
                pro.put("mail.smtp.auth","true");
                pro.put("mail.smtp.starttls.enable","true");
                Authenticator auth = new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,passw);
                    }
                };
                Session session = Session.getInstance(pro,auth);
                MimeMessage msg = new MimeMessage(session);
                try {
                    msg.addHeader("Content-type","text/HTML; charset=UTF-8");
                    msg.setFrom(from);
                    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
                    msg.setSubject("Password recovery capcha");
                    msg.setSentDate(new Date());
                    msg.setText(rand+"","UTF-8");
                    Transport.send(msg);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                capcha.removej(capcha.getJbut());
                capcha.addj(capcha.getJbuttt());
            }else {
                JOptionPane.showMessageDialog(capcha,"Please enter the correct username","error",JOptionPane.ERROR_MESSAGE);
            }
        } else if (src.equals("Submit")){
            if (capcha.getJt().getText().equals(getUser()) && capcha.getJt1().getText().equals(rand+"")){
                capcha.dispose();
                new ViewForgot();
            } else {
                JOptionPane.showMessageDialog(capcha,"Username or capcha is incorrect, please check again","error",JOptionPane.ERROR_MESSAGE);
            }
        } else {
            capcha.dispose();
            new ViewLog();
        }

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    public JButton getjButton() {
        return jButton;
    }

    public void setjButton(JButton jButton) {
        this.jButton = jButton;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setjButton((JButton) e.getSource());
        getjButton().setFont(new Font("Arial",Font.ITALIC,13));
        getjButton().setForeground(Color.WHITE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setjButton((JButton) e.getSource());
        getjButton().setFont(new Font("Arial",Font.ITALIC,12));
        getjButton().setForeground(Color.WHITE);
    }
}
