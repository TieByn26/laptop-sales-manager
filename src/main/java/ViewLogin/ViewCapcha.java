package ViewLogin;

import Controller.Log.Capcha;
import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewCapcha extends JFrame {
    private SpringLayout layoutMain = new SpringLayout();
    private SpringLayout layoutClone = new SpringLayout();
    private JPanel panel = new JPanel();
    private JLabel imageLabel;
    private RoundPanel panel1 = new RoundPanel(20);
    private JTextField jt;
    private JTextField jt1;
    private JButton jbutt;
    private JButton jbut;
    private JButton jbuttt;
    private Capcha capcha = new Capcha(this);

    class RoundPanel extends JPanel {
        private int cornerRadius;

        public RoundPanel(int cornerRadius) {
            this.cornerRadius = cornerRadius;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Dimension arcs = new Dimension(cornerRadius, cornerRadius);
            int width = getWidth();
            int height = getHeight();
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draws the rounded opaque panel with borders.
            graphics.setColor(getBackground());
            graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // paint background
            graphics.setColor(getForeground());
            graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // paint border
        }
    }



    public ViewCapcha() {
        this.setSize(950, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.forgotPass();
        this.initMain();
        this.initBack();
        this.setVisible(true);
    }

    public void initBack() {
        ImageIcon backIcon = new ImageIcon("C:/Users/ADMIN/Pictures/PicforJv/Back9.jpg");
        ImageIcon backIcon2 = new ImageIcon(backIcon.getImage().getScaledInstance(950, 600, Image.SCALE_SMOOTH));

        imageLabel = new JLabel(backIcon2);
        panel.setLayout(layoutMain);
        panel.add(imageLabel);
        this.getContentPane().add(panel);
    }
    public void initMain(){
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());

            panel1.setLayout(layoutClone);
            panel1.setPreferredSize(new Dimension(480, 350));
            panel1.setBackground(new Color(0, 0, 0, 140));
            layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER, panel1, 0, SpringLayout.HORIZONTAL_CENTER, panel);
            layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER, panel1, 0, SpringLayout.VERTICAL_CENTER, panel);
            panel.add(panel1);

            Font font1 = new Font("Arial", Font.ROMAN_BASELINE, 30);
            Font font2 = new Font("Times New Roman", Font.ROMAN_BASELINE, 16);
            jt = new JTextField();
            jt.setForeground(Color.WHITE);
            jt.setHorizontalAlignment(SwingConstants.CENTER);

            jt1 = new JTextField();
            jt1.setForeground(Color.WHITE);
            jt1.setHorizontalAlignment(SwingConstants.CENTER);


            // Thêm chữ gợi ý mờ cho JTextField
            PromptSupport.setPrompt("ENTER USER", jt);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jt);
            PromptSupport.setForeground(Color.WHITE, jt);
            PromptSupport.setPrompt("Pls check email to get the capcha", jt1);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jt1);
            PromptSupport.setForeground(Color.WHITE, jt1);

            jt.setFont(font2);
            jt.setBackground(new Color(0, 0, 0, 100));
            jt1.setFont(font2);
            jt1.setBackground(new Color(0, 0, 0, 100));


            layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jt,-60,SpringLayout.VERTICAL_CENTER,panel1);
            layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jt,0,SpringLayout.HORIZONTAL_CENTER,panel1);
            layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jt1,-5,SpringLayout.VERTICAL_CENTER,panel1);
            layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jt1,0,SpringLayout.HORIZONTAL_CENTER,panel1);
            jt.setPreferredSize(new Dimension(330,40));
            jt1.setPreferredSize(new Dimension(330,40));

            panel1.add(jt);
            panel1.add(jt1);


            JLabel jl = new JLabel("Recovery Password");
            jl.setForeground(Color.WHITE);
            layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jl,-125,SpringLayout.VERTICAL_CENTER,panel1);
            layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jl,0,SpringLayout.HORIZONTAL_CENTER,panel1);
            jl.setFont(font1);
            panel1.add(jl);

            Font font3 = new Font("Arial", Font.BOLD, 20);
            Color greenn = new Color(30, 160, 50);
            jbut = new JButton("SendMail");
            jbut.setForeground(Color.WHITE);
            jbut.setBackground(greenn);
            jbut.setFont(font3);
            jbut.addActionListener(capcha);
            panel1.add(jbut);
            layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER ,jbut, 0, SpringLayout.HORIZONTAL_CENTER, panel1);
            layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER, jbut, 90, SpringLayout.VERTICAL_CENTER, panel1);
            jbut.setPreferredSize(new Dimension(120, 39));

            jbuttt = new JButton("Submit");
            jbuttt.setForeground(Color.WHITE);
            jbuttt.setBackground(greenn);
            jbuttt.setFont(font3);
            jbuttt.addActionListener(capcha);
            layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER ,jbuttt, 0, SpringLayout.HORIZONTAL_CENTER, panel1);
            layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER, jbuttt, 90, SpringLayout.VERTICAL_CENTER, panel1);
            jbuttt.setPreferredSize(new Dimension(120, 39));
            panel1.setOpaque(false);


        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
    public void forgotPass() {
        Font font = new Font("Arial", Font.ITALIC, 12);
        jbutt = new JButton("Cancel/ try again enter pass?");
        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER, jbutt, 40, SpringLayout.VERTICAL_CENTER, panel1);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER, jbutt, 90, SpringLayout.HORIZONTAL_CENTER, panel1);
        jbutt.setFont(font);
        jbutt.setForeground(Color.WHITE);
        jbutt.setOpaque(false);
        jbutt.addActionListener(capcha);
        jbutt.setContentAreaFilled(false); // Tắt vùng chứa nội dung
        jbutt.setBorderPainted(false); // Tắt việc vẽ đường viền
        jbutt.setFocusPainted(false); // Tắt hiển thị viền khi JButton được nhấn
        Color transparentBlack = new Color(0, 0, 0, 100);
        jbutt.setBackground(transparentBlack); // Đặt màu nền có độ trong suốt
        jbutt.setBorder(BorderFactory.createLineBorder(transparentBlack, 2, true)); // Đặt đường viền có độ trong suốt
        jbutt.addMouseListener(capcha);
        panel1.add(jbutt);

    }

    public JTextField getJt() {
        return jt;
    }

    public JTextField getJt1() {
        return jt1;
    }

    public JButton getJbutt() {
        return jbutt;
    }

    public JButton getJbut() {
        return jbut;
    }

    public RoundPanel getPanel1() {
        return panel1;
    }

    public SpringLayout getLayoutMain() {
        return layoutMain;
    }

    public SpringLayout getLayoutClone() {
        return layoutClone;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JLabel getImageLabel() {
        return imageLabel;
    }

    public JButton getJbuttt() {
        return jbuttt;
    }

    public void removej(JButton j){
        panel1.remove(j);
        panel.repaint();
        panel.revalidate();
    }
    public void addj(JButton j){
        panel1.add(j);
        panel.repaint();
        panel.revalidate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ViewCapcha());
    }
}
