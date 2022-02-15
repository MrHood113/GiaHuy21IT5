/*
 * Created by JFormDesigner on Wed Jan 19 21:58:50 ICT 2022
 */

package Project;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.text.View;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/**
 * @author unknown
 */
public class Library extends JFrame {
    public Library() {
        initComponents();
    }

    private void exit(ActionEvent e) {

        System.exit(0);
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        try{
            if(account.equals("") || password.equals("")){
                JOptionPane.showMessageDialog(this,"Nhập tài khoản và mật khẩu");
            }
            else{
                String query = "Select * from quanlithuvien where taikhoan=? and matkhau=?";
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "0a0ab00chh");
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1,account.getText());
                stmt.setString(2,password.getText());
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    Manage mg = new Manage();
                    mg.setVisible(true);
                    this.setVisible(false);
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
                }
                else{
                    JOptionPane.showMessageDialog(this,"Tài khoản hoặc mật khẩu sai");
                }
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void label3MouseClicked(MouseEvent e) {
        System.exit(0);
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Huy Cận
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        account = new JTextField();
        password = new JPasswordField();
        button1 = new JButton();
        label3 = new JLabel();

        //======== this ========
        setForeground(SystemColor.textText);
        setBackground(Color.pink);
        setTitle("\u0110\u0103ng nh\u1eadp");
        setIconImage(new ImageIcon("C:\\Users\\admin\\Desktop\\sign-in.png").getImage());
        setResizable(false);
        setUndecorated(true);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(102, 102, 255));
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
            0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder
            .BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.
            red),panel1. getBorder()));panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.
            beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}});
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("Ng\u01b0\u1eddi qu\u1ea3n l\u00fd");
            label1.setForeground(Color.white);
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 3f));
            label1.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\account.png"));
            panel1.add(label1);
            label1.setBounds(20, 65, 140, 35);

            //---- label2 ----
            label2.setText("M\u1eadt kh\u1ea9u");
            label2.setForeground(Color.white);
            label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 3f));
            label2.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\padlock.png"));
            panel1.add(label2);
            label2.setBounds(17, 105, 115, 35);

            //---- account ----
            account.setForeground(Color.black);
            account.setBackground(Color.white);
            account.setFont(account.getFont().deriveFont(account.getFont().getStyle() & ~Font.BOLD));
            panel1.add(account);
            account.setBounds(160, 70, 220, 27);

            //---- password ----
            password.setForeground(Color.black);
            password.setBackground(Color.white);
            panel1.add(password);
            password.setBounds(160, 110, 220, 27);

            //---- button1 ----
            button1.setText("\u0110\u0103ng nh\u1eadp");
            button1.setForeground(Color.white);
            button1.setBackground(new Color(255, 102, 255));
            button1.setIcon(null);
            button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD, button1.getFont().getSize() + 3f));
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button1MouseClicked(e);
                }
            });
            panel1.add(button1);
            button1.setBounds(265, 150, 115, 35);

            //---- label3 ----
            label3.setText("X");
            label3.setForeground(Color.white);
            label3.setHorizontalAlignment(SwingConstants.CENTER);
            label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 5f));
            label3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label3MouseClicked(e);
                }
            });
            panel1.add(label3);
            label3.setBounds(375, 5, 35, 30);
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 415, 235);

        contentPane.setPreferredSize(new Dimension(415, 220));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Huy Cận
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JTextField account;
    private JPasswordField password;
    private JButton button1;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}


