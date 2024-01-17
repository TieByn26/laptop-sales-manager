package ViewLogin;

import Controller.Log.Login;
import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class ViewLog extends JFrame {
    private SpringLayout layoutMain = new SpringLayout();
    private SpringLayout layoutClone = new SpringLayout();
    private JPanel panel = new JPanel();
    private JLabel imageLabel;
    private RoundPanel panel1 = new RoundPanel(20);
    private JTextField jt;
    private JPasswordField jp;
    private JButton jbutt;
    private JButton jbut;
    private JCheckBox jc;
    private Login login = new Login(this);

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

            graphics.setColor(getBackground());
            graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // paint background
            graphics.setColor(getForeground());
            graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height); // paint border
        }
    }



    public ViewLog() {
        this.setSize(950, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.showPass();
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
            jp = new JPasswordField();
            jt.setForeground(Color.WHITE);
            jp.setForeground(Color.WHITE);

            // Thêm chữ gợi ý mờ cho JTextField
            PromptSupport.setPrompt("Username", jt);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jt);
            PromptSupport.setForeground(Color.WHITE, jt);
            // Thêm chữ gợi ý mờ cho JPasswordField
            PromptSupport.setPrompt("Password", jp);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, jp);
            PromptSupport.setForeground(Color.WHITE, jp);



            jt.setFont(font2);
            jt.setBackground(new Color(0, 0, 0, 100));
            jp.setFont(font2);
            jp.setBackground(new Color(0, 0, 0, 100));
            layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jt,-60,SpringLayout.VERTICAL_CENTER,panel1);
            layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jt,0,SpringLayout.HORIZONTAL_CENTER,panel1);
            layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jp,-5,SpringLayout.VERTICAL_CENTER,panel1);
            layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jp,0,SpringLayout.HORIZONTAL_CENTER,panel1);
            jt.setPreferredSize(new Dimension(330,40));
            jp.setPreferredSize(new Dimension(330,40));
            panel1.add(jt);
            panel1.add(jp);

            JLabel jl = new JLabel("LOGIN HERE");
            jl.setForeground(Color.WHITE);
            layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jl,-125,SpringLayout.VERTICAL_CENTER,panel1);
            layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jl,0,SpringLayout.HORIZONTAL_CENTER,panel1);
            jl.setFont(font1);
            panel1.add(jl);

            Font font3 = new Font("Arial", Font.BOLD, 20);
            Color greenn = new Color(30, 160, 50);
            jbut = new JButton("Login");
            jbut.setForeground(Color.WHITE);
            jbut.setBackground(greenn);
            jbut.setFont(font3);
            jbut.addActionListener(login);
            panel1.add(jbut);
            layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER ,jbut, 0, SpringLayout.HORIZONTAL_CENTER, panel1);
            layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER, jbut, 90, SpringLayout.VERTICAL_CENTER, panel1);
            jbut.setPreferredSize(new Dimension(120, 39));
            panel1.setOpaque(false);



        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
    public void forgotPass() {
        Font font = new Font("Arial", Font.ITALIC, 12);
        jbutt = new JButton("Forgot password?");
        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER, jbutt, 40, SpringLayout.VERTICAL_CENTER, panel1);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER, jbutt, 110, SpringLayout.HORIZONTAL_CENTER, panel1);
        jbutt.setFont(font);
        jbutt.addActionListener(login);
        jbutt.setForeground(Color.WHITE);
        jbutt.setOpaque(false);
        jbutt.setContentAreaFilled(false); // Tắt vùng chứa nội dung
        jbutt.setBorderPainted(false); // Tắt việc vẽ đường viền
        jbutt.setFocusPainted(false); // Tắt hiển thị viền khi JButton được nhấn
        jbutt.setBackground(new Color(0, 0, 0, 100)); // Đặt màu nền có độ trong suốt
        jbutt.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 100), 2, true)); // Đặt đường viền có độ trong suốt
        panel1.add(jbutt);
        jbutt.addMouseListener(login);
    }
    public void showPass(){
        jc = new JCheckBox("Show Password");
        jc.setForeground(Color.WHITE);
        jc.setAlignmentX(Component.LEFT_ALIGNMENT);
        jc.setFocusPainted(false);
        jc.addActionListener(login);
        jc.setOpaque(false);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jc,-110,SpringLayout.HORIZONTAL_CENTER,panel1);
        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jc,38,SpringLayout.VERTICAL_CENTER,panel1);
        panel1.add(jc);
    }

    public SpringLayout getLayoutMain() {
        return layoutMain;
    }

    public JTextField getJt() {
        return jt;
    }

    public JPasswordField getJp() {
        return jp;
    }

    public JButton getJbutt() {
        return jbutt;
    }

    public JButton getJbut() {
        return jbut;
    }

    public JCheckBox getJc() {
        return jc;
    }

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new ViewLog());
        new ViewLog();
    }
}
