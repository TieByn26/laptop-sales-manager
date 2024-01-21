package ViewMain.AdminView;

import javax.swing.*;
import java.awt.*;

public class TabHome extends JPanel {
    private SpringLayout springLayout = new SpringLayout();
    public TabHome(){
        ImageIcon imageIcon = new ImageIcon("D:\\PictureForJava\\Nenabout.jpg");
        ImageIcon imageIcon1 = new ImageIcon(imageIcon.getImage().getScaledInstance(1020,750,Image.SCALE_SMOOTH));
        JLabel jLabel = new JLabel(imageIcon1);
        this.setPreferredSize(new Dimension(1020,750));
        this.setBackground(Color.YELLOW);
        this.add(jLabel);
    }
}
