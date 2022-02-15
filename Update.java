/*
 * Created by JFormDesigner on Mon Feb 14 23:33:30 ICT 2022
 */

package Project;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author Huy Cận
 */
public class Update extends JDialog {
    public Update() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) throws SQLException {
        information inf = new information();
        String Madocgia = tfMadocgia.getText();
        String Hovaten = tfHovaten.getText();
        int Tuoi = Integer.parseInt(tfTuoi.getText());
        String Gioitinh = (String) cbGioitinh1.getSelectedItem();
        String Diachi = tfDiachi.getText();
        String Sodienthoi = tfSodienthoai.getText();
        String Email = tfEmail.getText();
        String Tensach = tfTensach.getText();
        String Ngaymuon = tfNgaymuon.getText();
        String Ngaytra = tfNgaytra.getText();

        inf.setMadocgia(Madocgia);
        inf.setHovaten(Hovaten);
        inf.setTuoi(Tuoi);
        inf.setGioitinh(Gioitinh);
        inf.setDiachi(Diachi);
        inf.setSodienthoai(Sodienthoi);
        inf.setEmail(Email);
        inf.setTensach(Tensach);
        inf.setNgaymuon(Ngaymuon);
        inf.setNgaytra(Ngaytra);

        EditInformation.update(inf);

        Manage mg = new Manage();
        mg.setVisible(true);

    }

    private void initComponents() {
        // Generated using JFormDesigner Evaluation license - Huy Cận
        panel1 = new JPanel();
        label1 = new JLabel();
        tfMadocgia = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        tfHovaten = new JTextField();
        tfSodienthoai = new JTextField();
        tfTuoi = new JTextField();
        cbGioitinh1 = new JComboBox<>();
        tfDiachi = new JTextField();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        tfEmail = new JTextField();
        tfTensach = new JTextField();
        tfNgaymuon = new JTextField();
        tfNgaytra = new JTextField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(102, 102, 255));
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
            border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder. CENTER
            ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .awt . Font
            . BOLD ,12 ) ,java . awt. Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener(
            new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062order"
            .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("M\u00e3 \u0111\u1ed9c gi\u1ea3:");
            label1.setForeground(Color.white);
            label1.setHorizontalAlignment(SwingConstants.LEFT);
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 2f));
            panel1.add(label1);
            label1.setBounds(30, 20, 75, 25);

            //---- tfMadocgia ----
            tfMadocgia.setBackground(Color.white);
            tfMadocgia.setForeground(Color.black);
            panel1.add(tfMadocgia);
            tfMadocgia.setBounds(120, 20, 180, 30);

            //---- label2 ----
            label2.setText("H\u1ecd v\u00e0 t\u00ean:");
            label2.setForeground(Color.white);
            label2.setHorizontalAlignment(SwingConstants.LEFT);
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 2f));
            panel1.add(label2);
            label2.setBounds(30, 60, 75, 25);

            //---- label3 ----
            label3.setText("Tu\u1ed5i:");
            label3.setForeground(Color.white);
            label3.setHorizontalAlignment(SwingConstants.LEFT);
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 2f));
            panel1.add(label3);
            label3.setBounds(30, 100, 75, 25);

            //---- label4 ----
            label4.setText("\u0110\u1ecba ch\u1ec9:");
            label4.setForeground(Color.white);
            label4.setHorizontalAlignment(SwingConstants.LEFT);
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD, label4.getFont().getSize() + 2f));
            panel1.add(label4);
            label4.setBounds(30, 180, 75, 25);

            //---- label5 ----
            label5.setText("S\u1ed1 \u0111i\u1ec7n tho\u1ea1i:");
            label5.setForeground(Color.white);
            label5.setHorizontalAlignment(SwingConstants.LEFT);
            label5.setFont(label5.getFont().deriveFont(label5.getFont().getStyle() | Font.BOLD, label5.getFont().getSize() + 2f));
            panel1.add(label5);
            label5.setBounds(345, 20, 100, 25);

            //---- label6 ----
            label6.setText("GI\u1edbi t\u00ednh:");
            label6.setForeground(Color.white);
            label6.setHorizontalAlignment(SwingConstants.LEFT);
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getStyle() | Font.BOLD, label6.getFont().getSize() + 2f));
            panel1.add(label6);
            label6.setBounds(30, 140, 75, 25);

            //---- tfHovaten ----
            tfHovaten.setBackground(Color.white);
            tfHovaten.setForeground(Color.black);
            panel1.add(tfHovaten);
            tfHovaten.setBounds(120, 60, 180, 30);

            //---- tfSodienthoai ----
            tfSodienthoai.setBackground(Color.white);
            tfSodienthoai.setForeground(Color.black);
            panel1.add(tfSodienthoai);
            tfSodienthoai.setBounds(450, 20, 180, 30);

            //---- tfTuoi ----
            tfTuoi.setBackground(Color.white);
            tfTuoi.setForeground(Color.black);
            panel1.add(tfTuoi);
            tfTuoi.setBounds(120, 100, 180, 30);

            //---- cbGioitinh1 ----
            cbGioitinh1.setForeground(Color.black);
            cbGioitinh1.setBackground(Color.white);
            cbGioitinh1.setModel(new DefaultComboBoxModel<>(new String[] {
                "Nam",
                "N\u1eef"
            }));
            panel1.add(cbGioitinh1);
            cbGioitinh1.setBounds(120, 140, 100, 30);

            //---- tfDiachi ----
            tfDiachi.setBackground(Color.white);
            tfDiachi.setForeground(Color.black);
            panel1.add(tfDiachi);
            tfDiachi.setBounds(120, 180, 180, 30);

            //---- label7 ----
            label7.setText("Email:");
            label7.setForeground(Color.white);
            label7.setHorizontalAlignment(SwingConstants.LEFT);
            label7.setFont(label7.getFont().deriveFont(label7.getFont().getStyle() | Font.BOLD, label7.getFont().getSize() + 2f));
            panel1.add(label7);
            label7.setBounds(345, 60, 100, 25);

            //---- label8 ----
            label8.setText("T\u00ean s\u00e1ch:");
            label8.setForeground(Color.white);
            label8.setHorizontalAlignment(SwingConstants.LEFT);
            label8.setFont(label8.getFont().deriveFont(label8.getFont().getStyle() | Font.BOLD, label8.getFont().getSize() + 2f));
            panel1.add(label8);
            label8.setBounds(345, 100, 100, 25);

            //---- label9 ----
            label9.setText("Ng\u00e0y m\u01b0\u1ee3n:");
            label9.setForeground(Color.white);
            label9.setHorizontalAlignment(SwingConstants.LEFT);
            label9.setFont(label9.getFont().deriveFont(label9.getFont().getStyle() | Font.BOLD, label9.getFont().getSize() + 2f));
            panel1.add(label9);
            label9.setBounds(345, 140, 100, 25);

            //---- label10 ----
            label10.setText("Ng\u00e0y tr\u1ea3:");
            label10.setForeground(Color.white);
            label10.setHorizontalAlignment(SwingConstants.LEFT);
            label10.setFont(label10.getFont().deriveFont(label10.getFont().getStyle() | Font.BOLD, label10.getFont().getSize() + 2f));
            panel1.add(label10);
            label10.setBounds(345, 180, 100, 25);

            //---- tfEmail ----
            tfEmail.setBackground(Color.white);
            tfEmail.setForeground(Color.black);
            panel1.add(tfEmail);
            tfEmail.setBounds(450, 60, 180, 30);

            //---- tfTensach ----
            tfTensach.setBackground(Color.white);
            tfTensach.setForeground(Color.black);
            panel1.add(tfTensach);
            tfTensach.setBounds(450, 100, 180, 30);

            //---- tfNgaymuon ----
            tfNgaymuon.setBackground(Color.white);
            tfNgaymuon.setForeground(Color.black);
            panel1.add(tfNgaymuon);
            tfNgaymuon.setBounds(450, 140, 180, 30);

            //---- tfNgaytra ----
            tfNgaytra.setBackground(Color.white);
            tfNgaytra.setForeground(Color.black);
            panel1.add(tfNgaytra);
            tfNgaytra.setBounds(450, 180, 180, 30);

            //---- button1 ----
            button1.setText("OK");
            button1.setForeground(Color.white);
            button1.setBackground(new Color(255, 102, 255));
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        button1MouseClicked(e);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            panel1.add(button1);
            button1.setBounds(290, 235, 90, 35);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 670, 320);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Huy Cận
    private JPanel panel1;
    private JLabel label1;
    public JTextField tfMadocgia;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    public JTextField tfHovaten;
    public JTextField tfSodienthoai;
    public JTextField tfTuoi;
    public JComboBox<String> cbGioitinh1;
    public JTextField tfDiachi;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    public JTextField tfEmail;
    public JTextField tfTensach;
    public JTextField tfNgaymuon;
    public JTextField tfNgaytra;
    private JButton button1;

    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
