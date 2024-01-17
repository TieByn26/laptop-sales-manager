package Controller.Log;

import DAO.LoginDAO;
import ViewLogin.ViewCapcha;
import ViewLogin.ViewLog;
import ViewMain.AdminView.AdminView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;


public class Login implements ActionListener, MouseListener {
    private ViewLog viewLog;
    private ArrayList<Model.Login.Login> list = LoginDAO.getLogin().selectAll();
    private String user;
    private String pass;
    private AdminView adminView ;
    private JButton jButton;

    public JButton getjButton() {
        return jButton;
    }

    public void setjButton(JButton jButton) {
        this.jButton = jButton;
    }


    public Login(ViewLog viewLog) {
        this.viewLog = viewLog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (Model.Login.Login login : list){
            setUser(login.getUserName());
            setPass(login.getPassword());
        }

        String src = e.getActionCommand();
        if (src.equals("Login")){
            if (viewLog.getJt().getText().isEmpty()){
                JOptionPane.showMessageDialog(viewLog,"You have not entered a password or username","error",JOptionPane.ERROR_MESSAGE);
            } else if (viewLog.getJp().getPassword().length == 0){
                JOptionPane.showMessageDialog(viewLog,"You have not entered a password or username","error",JOptionPane.ERROR_MESSAGE);
            } else {
                char[] pass = viewLog.getJp().getPassword();
                String password = new String(pass);
                if (viewLog.getJt().getText().equals(getUser()) && password.equals(getPass())){
                    new AdminView();
                    viewLog.dispose();
                } else {
                    JOptionPane.showMessageDialog(viewLog,"You entered the wrong account or password","error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }else if (src.equals("Forgot password?")){
            viewLog.dispose();
            new ViewCapcha();

        }else{
            boolean check = viewLog.getJc().isSelected();
            if (check) {
                viewLog.getJp().setEchoChar((char) 0);
            } else {
                viewLog.getJp().setEchoChar('*');
            }
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
