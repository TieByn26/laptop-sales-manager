package Controller.Main.Admin;

import ViewMain.AdminView.AdminView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChangeTab implements ActionListener, MouseListener {

    private AdminView adminView ;
    private JButton jButton;

    public JButton getjButton() {
        return jButton;
    }

    public void setjButton(JButton jButton) {
        this.jButton = jButton;
    }

    public ChangeTab(AdminView adminView) {
        adminView.setPanelTam(adminView.getTabHome());
        this.adminView = adminView;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Home")){
            adminView.removeTab(adminView.getPanelTam());
            adminView.addTab(adminView.getTabHome());
            adminView.setPanelTam(adminView.getTabHome());
        }else if (src.equals("Shop")){
            adminView.removeTab(adminView.getPanelTam());
            adminView.addTab(adminView.getTabShop());
            adminView.setPanelTam(adminView.getTabShop());
        } else if (src.equals("Sell")){
            adminView.removeTab(adminView.getPanelTam());
            adminView.addTab(adminView.getTabSell());
            adminView.setPanelTam(adminView.getTabSell());
        } else if (src.equals("Employee")){
            adminView.removeTab(adminView.getPanelTam());
            adminView.addTab(adminView.getTabEmployee());
            adminView.setPanelTam(adminView.getTabEmployee());
        } else if(src.equals("Bill")){
            adminView.removeTab(adminView.getPanelTam());
            adminView.addTab(adminView.getTabBill());
            adminView.setPanelTam(adminView.getTabBill());
        } else if (src.equals("Statistical")){
            adminView.removeTab(adminView.getPanelTam());
            adminView.addTab(adminView.getTabStatistical());
            adminView.setPanelTam(adminView.getTabStatistical());
        } else if (src.equals("about")){
            JOptionPane.showMessageDialog(adminView,"Version 1.0","About",JOptionPane.OK_CANCEL_OPTION);
        } else {
            System.exit(0);
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

    @Override
    public void mouseEntered(MouseEvent e) {
        setjButton((JButton) e.getSource());
        getjButton().setFont(new Font("Arial",Font.BOLD,16));
        getjButton().setForeground(Color.WHITE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setjButton((JButton) e.getSource());
        getjButton().setFont(new Font("Arial",Font.ROMAN_BASELINE,14));
        getjButton().setForeground(Color.WHITE);
    }
}
