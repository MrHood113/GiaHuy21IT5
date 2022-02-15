/*
 * Created by JFormDesigner on Tue Feb 15 01:02:26 ICT 2022
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
public class UpdateBook extends JDialog {
    public UpdateBook() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) throws SQLException{
        // TODO add your code here
        Book bk = new Book();
        String Masach = textMasach.getText();
        String Tensach = textTensach.getText();
        String Tacgia = textTacgia.getText();
        String Ngonngu = (String )cbNgonngu.getSelectedItem();
        String Theloai = textTheloai.getText();
        String Tinhtrang = textTinhtrang.getText();

        bk.setMasach(Masach);
        bk.setTensach(Tensach);
        bk.setTacgia(Tacgia);
        bk.setNgonngu(Ngonngu);
        bk.setTheloai(Theloai);
        bk.setTinhtrang(Tinhtrang);

        EditBook.updateBook(bk);

        Manage mg = new Manage();
        mg.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Huy Cận
        panel1 = new JPanel();
        label1 = new JLabel();
        textMasach = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        button1 = new JButton();
        textTacgia = new JTextField();
        textTensach = new JTextField();
        textTheloai = new JTextField();
        textTinhtrang = new JTextField();
        label6 = new JLabel();
        cbNgonngu = new JComboBox<>();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(102, 102, 255));
            panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
            ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
            .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069al\u006fg", java .awt . Font. BOLD ,12 ) ,java . awt
            . Color .red ) ,panel1. getBorder () ) ); panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
            propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062or\u0064er" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
            ;} } );
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("M\u00e3 s\u00e1ch:");
            label1.setForeground(Color.white);
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 2f));
            panel1.add(label1);
            label1.setBounds(30, 23, 70, label1.getPreferredSize().height);

            //---- textMasach ----
            textMasach.setBackground(Color.white);
            textMasach.setForeground(Color.black);
            panel1.add(textMasach);
            textMasach.setBounds(100, 20, 180, 30);

            //---- label2 ----
            label2.setText("T\u00ean s\u00e1ch:");
            label2.setForeground(Color.white);
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 2f));
            panel1.add(label2);
            label2.setBounds(30, 68, 70, 20);

            //---- label3 ----
            label3.setText("T\u00e1c gi\u1ea3:");
            label3.setForeground(Color.white);
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 2f));
            panel1.add(label3);
            label3.setBounds(30, 113, 70, 20);

            //---- label4 ----
            label4.setText("Ng\u00f4n ng\u1eef:");
            label4.setForeground(Color.white);
            label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD, label4.getFont().getSize() + 2f));
            panel1.add(label4);
            label4.setBounds(320, 23, 85, 20);

            //---- label5 ----
            label5.setText("Th\u1ec3 lo\u1ea1i:");
            label5.setForeground(Color.white);
            label5.setFont(label5.getFont().deriveFont(label5.getFont().getStyle() | Font.BOLD, label5.getFont().getSize() + 2f));
            panel1.add(label5);
            label5.setBounds(320, 68, 70, 20);

            //---- button1 ----
            button1.setText("OK");
            button1.setBackground(new Color(255, 102, 255));
            button1.setForeground(Color.white);
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
            button1.setBounds(265, 165, 95, 35);

            //---- textTacgia ----
            textTacgia.setBackground(Color.white);
            textTacgia.setForeground(Color.black);
            panel1.add(textTacgia);
            textTacgia.setBounds(100, 110, 180, 30);

            //---- textTensach ----
            textTensach.setBackground(Color.white);
            textTensach.setForeground(Color.black);
            panel1.add(textTensach);
            textTensach.setBounds(100, 65, 180, 30);

            //---- textTheloai ----
            textTheloai.setBackground(Color.white);
            textTheloai.setForeground(Color.black);
            panel1.add(textTheloai);
            textTheloai.setBounds(405, 65, 180, 30);

            //---- textTinhtrang ----
            textTinhtrang.setBackground(Color.white);
            textTinhtrang.setForeground(Color.black);
            panel1.add(textTinhtrang);
            textTinhtrang.setBounds(405, 110, 180, 30);

            //---- label6 ----
            label6.setText("T\u00ecnh tr\u1ea1ng:");
            label6.setForeground(Color.white);
            label6.setFont(label6.getFont().deriveFont(label6.getFont().getStyle() | Font.BOLD, label6.getFont().getSize() + 2f));
            panel1.add(label6);
            label6.setBounds(320, 113, 85, 20);

            //---- cbNgonngu ----
            cbNgonngu.setBackground(Color.white);
            cbNgonngu.setForeground(Color.black);
            cbNgonngu.setModel(new DefaultComboBoxModel<>(new String[] {
                "Vi\u1ec7t Nam",
                "Trung Qu\u1ed1c",
                "H\u00e0n Qu\u1ed1c",
                "Nh\u1eadt B\u1ea3n",
                "M\u1ef9",
                "Ph\u00e1p ",
                "\u0110\u1ee9c",
                "Nga"
            }));
            panel1.add(cbNgonngu);
            cbNgonngu.setBounds(405, 20, 120, cbNgonngu.getPreferredSize().height);

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
        panel1.setBounds(0, 0, 620, 275);

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
    public JTextField textMasach;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JButton button1;
    public JTextField textTacgia;
    public JTextField textTensach;
    public JTextField textTheloai;
    public JTextField textTinhtrang;
    private JLabel label6;
    public JComboBox<String> cbNgonngu;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
