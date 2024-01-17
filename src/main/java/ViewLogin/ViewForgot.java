package ViewLogin;

import Controller.Log.Forgot;
import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewForgot extends JFrame {
    private SpringLayout layoutMain = new SpringLayout();
    private SpringLayout layoutClone = new SpringLayout();
    private JPanel panel = new JPanel();
    private JLabel imageLabel;
    private RoundPanel panel1 = new RoundPanel(20);
    private JButton jbutt;
    private JButton jbut;
    private JCheckBox jc;
    private JPasswordField Jp;
    private JPasswordField Jp1;
    private Forgot forgot = new Forgot(this);
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



    public ViewForgot() {
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
            Font font1 = new Font("Arial", Font.ROMAN_BASELINE, 30);
            Font font2 = new Font("Times New Roman", Font.ROMAN_BASELINE, 16);
            panel1.setLayout(layoutClone);
            panel1.setPreferredSize(new Dimension(480, 350));
            panel1.setBackground(new Color(0, 0, 0, 140));
            layoutMain.putConstraint(SpringLayout.HORIZONTAL_CENTER, panel1, 0, SpringLayout.HORIZONTAL_CENTER, panel);
            layoutMain.putConstraint(SpringLayout.VERTICAL_CENTER, panel1, 0, SpringLayout.VERTICAL_CENTER, panel);
            panel.add(panel1);
            //set Jpass
            Jp = new JPasswordField();
            Jp1 = new JPasswordField();
            Jp1.setForeground(Color.WHITE);
            Jp.setForeground(Color.WHITE);

            // Thêm chữ gợi ý mờ cho JTextField
            PromptSupport.setPrompt("Enter Pass", Jp);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, Jp);
            PromptSupport.setForeground(Color.WHITE, Jp);
            // Thêm chữ gợi ý mờ cho JPasswordField
            PromptSupport.setPrompt("Enter Again Pass", Jp1);
            PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.HIDE_PROMPT, Jp1);
            PromptSupport.setForeground(Color.WHITE, Jp1);

            Jp.setFont(font2);
            Jp.setBackground(new Color(0, 0, 0, 100));
            Jp1.setFont(font2);
            Jp1.setBackground(new Color(0, 0, 0, 100));
            layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,Jp,-60,SpringLayout.VERTICAL_CENTER,panel1);
            layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,Jp,0,SpringLayout.HORIZONTAL_CENTER,panel1);
            layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,Jp1,-5,SpringLayout.VERTICAL_CENTER,panel1);
            layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,Jp1,0,SpringLayout.HORIZONTAL_CENTER,panel1);
            Jp.setPreferredSize(new Dimension(330,40));
            Jp1.setPreferredSize(new Dimension(330,40));
            panel1.add(Jp);
            panel1.add(Jp1);
            //
            JLabel jl = new JLabel("Recovery Password");
            jl.setForeground(Color.WHITE);
            layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jl,-125,SpringLayout.VERTICAL_CENTER,panel1);
            layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jl,0,SpringLayout.HORIZONTAL_CENTER,panel1);
            jl.setFont(font1);
            panel1.add(jl);
            //set submit
            Font font3 = new Font("Arial", Font.BOLD, 20);
            Color greenn = new Color(30, 160, 50);
            jbut = new JButton("Submit");
            jbut.setForeground(Color.WHITE);
            jbut.setBackground(greenn);
            jbut.setFont(font3);
            jbut.addActionListener(forgot);
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
        jbutt = new JButton("Cancel/ try again enter pass?");
        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER, jbutt, 40, SpringLayout.VERTICAL_CENTER, panel1);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER, jbutt, 90, SpringLayout.HORIZONTAL_CENTER, panel1);
        jbutt.setFont(font);
        jbutt.setForeground(Color.WHITE);
        jbutt.setOpaque(false);
        jbutt.setContentAreaFilled(false); // Tắt vùng chứa nội dung
        jbutt.setBorderPainted(false); // Tắt việc vẽ đường viền
        jbutt.setFocusPainted(false); // Tắt hiển thị viền khi JButton được nhấn
        jbutt.addActionListener(forgot);
        Color transparentBlack = new Color(0, 0, 0, 100);
        jbutt.setBackground(transparentBlack); // Đặt màu nền có độ trong suốt
        jbutt.setBorder(BorderFactory.createLineBorder(transparentBlack, 2, true)); // Đặt đường viền có độ trong suốt
        jbutt.addActionListener(forgot);
        panel1.add(jbutt);

    }
    public void showPass(){
        jc = new JCheckBox("Show Password");
        jc.setForeground(Color.WHITE);
        jc.setAlignmentX(Component.LEFT_ALIGNMENT);
        jc.setFocusPainted(false);
        jc.addActionListener(forgot);
        panel1.add(jc);
        jc.setOpaque(false);
        layoutClone.putConstraint(SpringLayout.HORIZONTAL_CENTER,jc,-110,SpringLayout.HORIZONTAL_CENTER,panel1);
        layoutClone.putConstraint(SpringLayout.VERTICAL_CENTER,jc,38,SpringLayout.VERTICAL_CENTER,panel1);
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

    public JPasswordField getJp() {
        return Jp;
    }

    public JPasswordField getJp1() {
        return Jp1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ViewForgot());
    }
}
