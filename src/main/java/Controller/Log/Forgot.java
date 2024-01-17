package Controller.Log;

import DAO.LoginDAO;
import Model.Login.Login;
import ViewLogin.ViewForgot;
import ViewLogin.ViewLog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Forgot implements ActionListener, MouseListener {
    private ViewForgot viewForgot;
    private Login login = new Login();
    private JButton jButton;

    public JButton getjButton() {
        return jButton;
    }

    public void setjButton(JButton jButton) {
        this.jButton = jButton;
    }

    public Forgot(ViewForgot viewForgot) {
        this.viewForgot = viewForgot;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Submit")) {
            if (new String(viewForgot.getJp().getPassword()).equals(new String(viewForgot.getJp1().getPassword()))) {
                login.setPassword(new String(viewForgot.getJp().getPassword()));
                LoginDAO.getLogin().update(login);
                JOptionPane.showMessageDialog(viewForgot, "Password changed successfully", "success", JOptionPane.OK_OPTION);
            } else if (viewForgot.getJp().getPassword().length == 0 || viewForgot.getJp1().getPassword().length == 0){
                JOptionPane.showMessageDialog(viewForgot,"Empty password","error",JOptionPane.ERROR_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(viewForgot,"Password mismatch","error",JOptionPane.ERROR_MESSAGE);
            }
        } else if(src.equals("Cancel/ try again enter pass?")) {
            viewForgot.dispose();
            new ViewLog();
        } else {
            boolean check = viewForgot.getJc().isSelected();
            if (check) {
                viewForgot.getJp().setEchoChar((char) 0);
                viewForgot.getJp1().setEchoChar((char) 0);
            } else {
                viewForgot.getJp().setEchoChar('*');
                viewForgot.getJp1().setEchoChar('*');
            }
        }
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
