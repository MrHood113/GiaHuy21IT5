/*
 * Created by JFormDesigner on Sun Feb 06 23:56:13 ICT 2022
 */

package Project;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.*;
import javax.swing.table.*;


/**
 * @author Huy Cận
 */
public class Manage extends JFrame {
    DefaultTableModel tableModel;
    DefaultTableModel tableModel1;

    List<information> informationList = new ArrayList<>();
    List<Book> BookList = new ArrayList<>();

    public Manage() throws SQLException {
        initComponents();

        tableModel = (DefaultTableModel) tableInf.getModel();
        tableModel1 = (DefaultTableModel) tableBook.getModel();

        showinformation();
        showBook();

    }

    private void label13MouseClicked(MouseEvent e) {
        System.exit(0);
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        this.setVisible(false);
        Library lb = new Library();
        lb.setVisible(true);
    }

    //Hien thi thong tin doc gia
    private void showinformation() {
        List<information> informationList = EditInformation.findAll();
        tableModel.setRowCount(0);

        informationList.forEach((information) -> {
            tableModel.addRow(new Object[] {information.getMadocgia(), information.getHovaten(), information.getTuoi(), information.getGioitinh(),
                    information.getDiachi(), information.getSodienthoai(), information.getEmail(), information.getTensach(),
                    information.getNgaymuon(), information.getNgaytra()});
        });
    }
    
    //Insert in Muon Tra
    private void buttonInsertMouseClicked(MouseEvent e) {
        // TODO add your code here
        String Madocgia = txtMadocgia.getText();
        String Hovaten = txtHovaten.getText();
        int Tuoi = Integer.parseInt(txtTuoi.getText());
        String Gioitinh = cbGioitinh.getSelectedItem().toString();
        String Diachi = txtDiachi.getText();
        String Sodienthoai = txtSodienthoai.getText();
        String Email = txtEmail.getText();
        String Tensach = txtTensach.getText();
        String Ngaymuon = txtNgaymuon.getText();
        String Ngaytra = txtNgaytra.getText();

        information inf = new information(Madocgia, Hovaten, Tuoi, Gioitinh, Diachi, Sodienthoai, Email, Tensach, Ngaymuon, Ngaytra);

        EditInformation.insert(inf);

        showinformation();
    }

    
    //Delete in Muon Tra
    private void buttonDeleteMouseClicked(MouseEvent e) {
        // TODO add your code here
        try {
            int row = tableInf.getSelectedRow();
            String Madocgia = (String)tableInf.getValueAt(row, 0);
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "0a0ab00chh");
            String tra = "DELETE FROM information WHERE Madocgia = ?";
            PreparedStatement ps = conn.prepareStatement(tra);

            ps.setString(1, Madocgia);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xoa thanh cong!");
            tableModel.removeRow(tableInf.getSelectedRow());
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Find in Muon Tra
    private void buttonTimkiemMouseClicked(MouseEvent e) {
        // TODO add your code here
        tableModel.getDataVector().removeAllElements();

        informationList = EditInformation.findByMadocgia();

            informationList.forEach((information) -> {
                tableModel.addRow(new Object[] {information.getMadocgia(), information.getHovaten(), information.getTuoi(), information.getGioitinh(),
                        information.getDiachi(), information.getSodienthoai(), information.getEmail(), information.getTensach(),
                        information.getNgaymuon(), information.getNgaytra()});
            });

    }

    //Update
    private void buttonCapnhatMouseClicked(MouseEvent e) {
        // TODO add your code here
        int row = tableInf.getSelectedRow();

        String Madocgia = (String) tableInf.getValueAt(row, 0);
        String Hovaten = (String) tableInf.getValueAt(row, 1);
        int Tuoi = (int) tableInf.getValueAt(row, 2);
        String Gioitinh = (String) tableInf.getValueAt(row, 3);
        String Diachi = (String) tableInf.getValueAt(row, 4);
        String Sodienthoai = (String) tableInf.getValueAt(row, 5);
        String Email = (String) tableInf.getValueAt(row, 6);
        String Tensach = (String) tableInf.getValueAt(row, 7);
        String Ngaymuon = (String) tableInf.getValueAt(row, 8);
        String Ngaytra = (String) tableInf.getValueAt(row, 9);


        information inf = new information(Madocgia, Hovaten, Tuoi, Gioitinh, Diachi, Sodienthoai, Email, Tensach, Ngaymuon, Ngaytra);

        EditInformation.update(inf);

        Update up = new Update();
        up.tfMadocgia.setText(Madocgia);
        up.tfHovaten.setText(Hovaten);
        up.tfTuoi.setText(String.valueOf(Tuoi));
        up.cbGioitinh1.setSelectedItem((Gioitinh));
        up.tfDiachi.setText(Diachi);
        up.tfSodienthoai.setText(Sodienthoai);
        up.tfEmail.setText(Email);
        up.tfTensach.setText(Tensach);
        up.tfNgaymuon.setText(Ngaymuon);
        up.tfNgaytra.setText(Ngaytra);

        up.setVisible(true);

        showinformation();
    }

    //-----------------------------------------------------------------------------------------

    //Hien thi thong tin sach
    private void showBook() {
        List<Book> BookList = EditBook.findBook();
        tableModel1.setRowCount(0);

        BookList.forEach((Book) -> {
            tableModel1.addRow(new Object[] {Book.getMasach(), Book.getTensach(), Book.getTacgia(),
                    Book.getNgonngu(), Book.getTheloai(), Book.getTinhtrang()});
        });
    }

    //Insert in Manage Book
    private void btNhapMouseClicked(MouseEvent e) {
        // TODO add your code here
        String Masach = txtMasach.getText();
        String Tensach = txtTensachBk.getText();
        String Tacgia = txtTacgia.getText();
        String Ngonngu = cbNgonNgu.getSelectedItem().toString();
        String Theloai = txtTheLoai.getText();
        String Tinhtrang = txtTinhtrang.getText();

            Book bk = new Book(Masach, Tensach, Tacgia, Ngonngu, Theloai, Tinhtrang);

            EditBook.insert(bk);

            showBook();
        }

    //Delete in Manage Book
        private void btLoaiMouseClicked(MouseEvent e) {
            // TODO add your code here
            try {
                int row = tableBook.getSelectedRow();
                String Masach = (String)tableBook.getValueAt(row, 0);
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "0a0ab00chh");
                String tra = "DELETE FROM book WHERE Masach = ?";
                PreparedStatement ps = conn.prepareStatement(tra);

                ps.setString(1, Masach);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Xóa thành công!");
                tableModel1.removeRow(tableBook.getSelectedRow());
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        //Find in Manage Book
        private void btFindMouseClicked(MouseEvent e) {
            // TODO add your code here
            tableModel1.getDataVector().removeAllElements();

            BookList = EditBook.findMasach();

            BookList.forEach((Book) -> {
                tableModel1.addRow(new Object[] {Book.getMasach(), Book.getTensach(), Book.getTacgia(),
                Book.getNgonngu(), Book.getTheloai(), Book.getTinhtrang()});
            });
        }

        //Update Book
        private void btCapnhatMouseClicked(MouseEvent e) {
            // TODO add your code here
            int row = tableBook.getSelectedRow();

            String Masach = (String) tableBook.getValueAt(row, 0);
            String Tensach = (String) tableBook.getValueAt(row, 1);
            String Tacgia = (String) tableBook.getValueAt(row, 2);
            String Ngonngu = (String) tableBook.getValueAt(row, 3);
            String Theloai = (String) tableBook.getValueAt(row, 4);
            String Tinhtrang = (String) tableBook.getValueAt(row, 5);

            Book bk = new Book(Masach, Tensach, Tacgia, Ngonngu, Theloai, Tinhtrang);

            EditBook.updateBook(bk);

            UpdateBook upbk = new UpdateBook();
            upbk.textMasach.setText(Masach);
            upbk.textTensach.setText(Tensach);
            upbk.textTacgia.setText(Tacgia);
            upbk.cbNgonngu.setSelectedItem(Ngonngu);
            upbk.textTheloai.setText(Theloai);
            upbk.textTinhtrang.setText(Tinhtrang);

            upbk.setVisible(true);

            showBook();
        }

        private void buttonSuaMouseClicked(MouseEvent e) {
            // TODO add your code here
        }


        //--------------------------------------------------------------------------------------------------------

    private void initComponents() throws SQLException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Huy Cận
        panel1 = new JPanel();
        label1 = new JLabel();
        tabbedPane1 = new JTabbedPane();
        panel3 = new JPanel();
        txtMadocgia = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        txtHovaten = new JTextField();
        label5 = new JLabel();
        txtTuoi = new JTextField();
        label6 = new JLabel();
        txtDiachi = new JTextField();
        txtSodienthoai = new JTextField();
        label7 = new JLabel();
        label8 = new JLabel();
        scrollPane2 = new JScrollPane();
        tableInf = new JTable();
        buttonInsert = new JButton();
        buttonDelete = new JButton();
        buttonCapnhat = new JButton();
        txtEmail = new JTextField();
        label15 = new JLabel();
        txtTensach = new JTextField();
        txtNgaymuon = new JTextField();
        label16 = new JLabel();
        label17 = new JLabel();
        txtNgaytra = new JTextField();
        label20 = new JLabel();
        cbGioitinh = new JComboBox<>();
        buttonTimkiem = new JButton();
        panel4 = new JPanel();
        label9 = new JLabel();
        txtTensachBk = new JTextField();
        label10 = new JLabel();
        txtTacgia = new JTextField();
        label11 = new JLabel();
        cbNgonNgu = new JComboBox<>();
        label12 = new JLabel();
        txtTheLoai = new JTextField();
        btLoai = new JButton();
        scrollPane1 = new JScrollPane();
        tableBook = new JTable();
        label18 = new JLabel();
        txtTinhtrang = new JTextField();
        btNhap = new JButton();
        btFind = new JButton();
        txtMasach = new JTextField();
        label19 = new JLabel();
        btCapnhat = new JButton();
        button2 = new JButton();
        label13 = new JLabel();

        //======== this ========
        setTitle("Giao di\u1ec7n qu\u1ea3n l\u00ed");
        setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        setIconImage(new ImageIcon("C:\\Users\\admin\\Desktop\\open-book.png").getImage());
        setUndecorated(true);
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(153, 204, 255));
            panel1.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
            swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border
            .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog"
            ,java.awt.Font.BOLD,12),java.awt.Color.red),panel1. getBorder
            ()));panel1. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
            .beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException
            ();}});
            panel1.setLayout(null);

            //---- label1 ----
            label1.setBackground(Color.black);
            label1.setFont(new Font("UTM Alberta Heavy", Font.ITALIC, 50));
            label1.setForeground(new Color(255, 102, 51));
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setText("Qu\u1ea3n l\u00ed th\u01b0 vi\u1ec7n");
            panel1.add(label1);
            label1.setBounds(-25, 20, 425, 60);

            //======== tabbedPane1 ========
            {
                tabbedPane1.setBackground(new Color(51, 51, 255));
                tabbedPane1.setForeground(Color.white);
                tabbedPane1.setFont(tabbedPane1.getFont().deriveFont(tabbedPane1.getFont().getStyle() | Font.BOLD, tabbedPane1.getFont().getSize() + 5f));

                //======== panel3 ========
                {
                    panel3.setBackground(Color.white);
                    panel3.setLayout(null);

                    //---- txtMadocgia ----
                    txtMadocgia.setBackground(Color.white);
                    txtMadocgia.setForeground(Color.black);
                    panel3.add(txtMadocgia);
                    txtMadocgia.setBounds(55, 35, 183, 30);

                    //---- label3 ----
                    label3.setText("M\u00e3 \u0111\u1ed9c gi\u1ea3");
                    label3.setForeground(Color.black);
                    label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 2f));
                    panel3.add(label3);
                    label3.setBounds(58, 15, 75, label3.getPreferredSize().height);

                    //---- label4 ----
                    label4.setText("H\u1ecd v\u00e0 t\u00ean");
                    label4.setForeground(Color.black);
                    label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD, label4.getFont().getSize() + 2f));
                    panel3.add(label4);
                    label4.setBounds(58, 75, 70, label4.getPreferredSize().height);

                    //---- txtHovaten ----
                    txtHovaten.setBackground(Color.white);
                    txtHovaten.setForeground(Color.black);
                    panel3.add(txtHovaten);
                    txtHovaten.setBounds(55, 95, 183, 30);

                    //---- label5 ----
                    label5.setText("Tu\u1ed5i");
                    label5.setForeground(Color.black);
                    label5.setFont(label5.getFont().deriveFont(label5.getFont().getStyle() | Font.BOLD, label5.getFont().getSize() + 2f));
                    panel3.add(label5);
                    label5.setBounds(298, 15, 70, label5.getPreferredSize().height);

                    //---- txtTuoi ----
                    txtTuoi.setBackground(Color.white);
                    txtTuoi.setForeground(Color.black);
                    panel3.add(txtTuoi);
                    txtTuoi.setBounds(295, 35, 183, 30);

                    //---- label6 ----
                    label6.setText("S\u1ed1 \u0111i\u1ec7n tho\u1ea1i");
                    label6.setForeground(Color.black);
                    label6.setFont(label6.getFont().deriveFont(label6.getFont().getStyle() | Font.BOLD, label6.getFont().getSize() + 2f));
                    panel3.add(label6);
                    label6.setBounds(538, 15, 105, 20);

                    //---- txtDiachi ----
                    txtDiachi.setBackground(Color.white);
                    txtDiachi.setForeground(Color.black);
                    panel3.add(txtDiachi);
                    txtDiachi.setBounds(295, 95, 183, 30);

                    //---- txtSodienthoai ----
                    txtSodienthoai.setBackground(Color.white);
                    txtSodienthoai.setForeground(Color.black);
                    panel3.add(txtSodienthoai);
                    txtSodienthoai.setBounds(535, 35, 183, 30);

                    //---- label7 ----
                    label7.setText("\u0110\u1ecba ch\u1ec9");
                    label7.setForeground(Color.black);
                    label7.setFont(label7.getFont().deriveFont(label7.getFont().getStyle() | Font.BOLD, label7.getFont().getSize() + 2f));
                    panel3.add(label7);
                    label7.setBounds(298, 75, 75, 20);

                    //---- label8 ----
                    label8.setText("Gi\u1edbi t\u00ednh");
                    label8.setForeground(Color.black);
                    label8.setFont(label8.getFont().deriveFont(label8.getFont().getStyle() | Font.BOLD, label8.getFont().getSize() + 2f));
                    panel3.add(label8);
                    label8.setBounds(58, 135, 75, 20);

                    //======== scrollPane2 ========
                    {

                        //---- tableInf ----
                        tableInf.setForeground(Color.black);
                        tableInf.setBackground(Color.white);
                        tableInf.setModel(new DefaultTableModel(
                            new Object[][] {
                                {null, null, "", null, null, null, null, null, null, null},
                                {null, null, null, null, null, null, null, null, null, null},
                            },
                            new String[] {
                                "M\u00e3 \u0111\u1ed9c gi\u1ea3", "H\u1ecd v\u00e0 t\u00ean", "Tu\u1ed5i", "Gi\u1edbi t\u00ednh", "\u0110\u1ecba ch\u1ec9", "S\u1ed1 \u0111i\u1ec7n tho\u1ea1i", "Email", "T\u00ean s\u00e1ch", "Ng\u00e0y m\u01b0\u1ee3n", "Ng\u00e0y tr\u1ea3"
                            }
                        ));
                        scrollPane2.setViewportView(tableInf);
                    }
                    panel3.add(scrollPane2);
                    scrollPane2.setBounds(10, 200, 1015, 360);

                    //---- buttonInsert ----
                    buttonInsert.setText("M\u01b0\u1ee3n");
                    buttonInsert.setBackground(new Color(255, 102, 255));
                    buttonInsert.setForeground(Color.white);
                    buttonInsert.setFont(buttonInsert.getFont().deriveFont(buttonInsert.getFont().getStyle() | Font.BOLD, buttonInsert.getFont().getSize() + 2f));
                    buttonInsert.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            buttonInsertMouseClicked(e);
                        }
                    });
                    panel3.add(buttonInsert);
                    buttonInsert.setBounds(255, 155, 100, buttonInsert.getPreferredSize().height);

                    //---- buttonDelete ----
                    buttonDelete.setText("Tr\u1ea3");
                    buttonDelete.setBackground(new Color(255, 102, 255));
                    buttonDelete.setForeground(Color.white);
                    buttonDelete.setFont(buttonDelete.getFont().deriveFont(buttonDelete.getFont().getStyle() | Font.BOLD, buttonDelete.getFont().getSize() + 2f));
                    buttonDelete.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            buttonDeleteMouseClicked(e);
                        }
                    });
                    panel3.add(buttonDelete);
                    buttonDelete.setBounds(380, 155, 100, buttonDelete.getPreferredSize().height);

                    //---- buttonCapnhat ----
                    buttonCapnhat.setText("C\u1eadp nh\u1eadt");
                    buttonCapnhat.setBackground(new Color(255, 102, 255));
                    buttonCapnhat.setForeground(Color.white);
                    buttonCapnhat.setFont(buttonCapnhat.getFont().deriveFont(buttonCapnhat.getFont().getStyle() | Font.BOLD, buttonCapnhat.getFont().getSize() + 2f));
                    buttonCapnhat.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            buttonCapnhatMouseClicked(e);
                        }
                    });
                    panel3.add(buttonCapnhat);
                    buttonCapnhat.setBounds(505, 155, 100, buttonCapnhat.getPreferredSize().height);

                    //---- txtEmail ----
                    txtEmail.setBackground(Color.white);
                    txtEmail.setForeground(Color.black);
                    panel3.add(txtEmail);
                    txtEmail.setBounds(535, 95, 183, 30);

                    //---- label15 ----
                    label15.setText("Email");
                    label15.setForeground(Color.black);
                    label15.setFont(label15.getFont().deriveFont(label15.getFont().getStyle() | Font.BOLD, label15.getFont().getSize() + 2f));
                    panel3.add(label15);
                    label15.setBounds(538, 75, 105, 20);

                    //---- txtTensach ----
                    txtTensach.setBackground(Color.white);
                    txtTensach.setForeground(Color.black);
                    panel3.add(txtTensach);
                    txtTensach.setBounds(775, 35, 183, 30);

                    //---- txtNgaymuon ----
                    txtNgaymuon.setBackground(Color.white);
                    txtNgaymuon.setForeground(Color.black);
                    panel3.add(txtNgaymuon);
                    txtNgaymuon.setBounds(775, 95, 183, 30);

                    //---- label16 ----
                    label16.setText("T\u00ean s\u00e1ch");
                    label16.setForeground(Color.black);
                    label16.setFont(label16.getFont().deriveFont(label16.getFont().getStyle() | Font.BOLD, label16.getFont().getSize() + 2f));
                    panel3.add(label16);
                    label16.setBounds(778, 15, 105, 20);

                    //---- label17 ----
                    label17.setText("Ng\u00e0y m\u01b0\u1ee3n");
                    label17.setForeground(Color.black);
                    label17.setFont(label17.getFont().deriveFont(label17.getFont().getStyle() | Font.BOLD, label17.getFont().getSize() + 2f));
                    panel3.add(label17);
                    label17.setBounds(778, 75, 105, 20);

                    //---- txtNgaytra ----
                    txtNgaytra.setBackground(Color.white);
                    txtNgaytra.setForeground(Color.black);
                    panel3.add(txtNgaytra);
                    txtNgaytra.setBounds(775, 155, 183, 30);

                    //---- label20 ----
                    label20.setText("Ng\u00e0y tr\u1ea3");
                    label20.setForeground(Color.black);
                    label20.setFont(label20.getFont().deriveFont(label20.getFont().getStyle() | Font.BOLD, label20.getFont().getSize() + 2f));
                    panel3.add(label20);
                    label20.setBounds(778, 135, 105, 20);

                    //---- cbGioitinh ----
                    cbGioitinh.setBackground(Color.white);
                    cbGioitinh.setForeground(Color.black);
                    cbGioitinh.setModel(new DefaultComboBoxModel<>(new String[] {
                        "Nam",
                        "N\u1eef"
                    }));
                    panel3.add(cbGioitinh);
                    cbGioitinh.setBounds(55, 155, 95, cbGioitinh.getPreferredSize().height);

                    //---- buttonTimkiem ----
                    buttonTimkiem.setText("T\u00ecm ki\u1ebfm");
                    buttonTimkiem.setBackground(new Color(255, 102, 255));
                    buttonTimkiem.setForeground(Color.white);
                    buttonTimkiem.setFont(buttonTimkiem.getFont().deriveFont(buttonTimkiem.getFont().getStyle() | Font.BOLD, buttonTimkiem.getFont().getSize() + 2f));
                    buttonTimkiem.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            buttonTimkiemMouseClicked(e);
                        }
                    });
                    panel3.add(buttonTimkiem);
                    buttonTimkiem.setBounds(630, 155, 100, buttonTimkiem.getPreferredSize().height);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel3.getComponentCount(); i++) {
                            Rectangle bounds = panel3.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel3.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel3.setMinimumSize(preferredSize);
                        panel3.setPreferredSize(preferredSize);
                    }
                }
                tabbedPane1.addTab("M\u01b0\u1ee3n tr\u1ea3", panel3);

                //======== panel4 ========
                {
                    panel4.setBackground(Color.white);
                    panel4.setLayout(null);

                    //---- label9 ----
                    label9.setText("T\u00ean s\u00e1ch:");
                    label9.setForeground(Color.black);
                    label9.setFont(label9.getFont().deriveFont(label9.getFont().getStyle() | Font.BOLD, label9.getFont().getSize() + 2f));
                    panel4.add(label9);
                    label9.setBounds(70, 73, 70, label9.getPreferredSize().height);

                    //---- txtTensachBk ----
                    txtTensachBk.setBackground(Color.white);
                    txtTensachBk.setForeground(Color.black);
                    panel4.add(txtTensachBk);
                    txtTensachBk.setBounds(160, 70, 155, 30);

                    //---- label10 ----
                    label10.setText("T\u00e1c gi\u1ea3:");
                    label10.setForeground(Color.black);
                    label10.setFont(label10.getFont().deriveFont(label10.getFont().getStyle() | Font.BOLD, label10.getFont().getSize() + 2f));
                    panel4.add(label10);
                    label10.setBounds(390, 23, 70, 20);

                    //---- txtTacgia ----
                    txtTacgia.setBackground(Color.white);
                    txtTacgia.setForeground(Color.black);
                    panel4.add(txtTacgia);
                    txtTacgia.setBounds(480, 20, 155, 30);

                    //---- label11 ----
                    label11.setText("Ng\u00f4n ng\u1eef:");
                    label11.setForeground(Color.black);
                    label11.setFont(label11.getFont().deriveFont(label11.getFont().getStyle() | Font.BOLD, label11.getFont().getSize() + 2f));
                    panel4.add(label11);
                    label11.setBounds(390, 73, 90, 20);

                    //---- cbNgonNgu ----
                    cbNgonNgu.setForeground(Color.black);
                    cbNgonNgu.setBackground(Color.white);
                    cbNgonNgu.setModel(new DefaultComboBoxModel<>(new String[] {
                        "Vi\u1ec7t Nam",
                        "Trung Qu\u1ed1c",
                        "H\u00e0n Qu\u1ed1c",
                        "Nh\u1eadt B\u1ea3n",
                        "M\u1ef9",
                        "Ph\u00e1p ",
                        "\u0110\u1ee9c",
                        "Nga"
                    }));
                    cbNgonNgu.setFont(cbNgonNgu.getFont().deriveFont(cbNgonNgu.getFont().getStyle() & ~Font.BOLD, cbNgonNgu.getFont().getSize() + 3f));
                    panel4.add(cbNgonNgu);
                    cbNgonNgu.setBounds(480, 70, 125, cbNgonNgu.getPreferredSize().height);

                    //---- label12 ----
                    label12.setText("Th\u1ec3 lo\u1ea1i:");
                    label12.setForeground(Color.black);
                    label12.setFont(label12.getFont().deriveFont(label12.getFont().getStyle() | Font.BOLD, label12.getFont().getSize() + 2f));
                    panel4.add(label12);
                    label12.setBounds(710, 23, 70, 20);

                    //---- txtTheLoai ----
                    txtTheLoai.setBackground(Color.white);
                    txtTheLoai.setForeground(Color.black);
                    panel4.add(txtTheLoai);
                    txtTheLoai.setBounds(800, 20, 155, 27);

                    //---- btLoai ----
                    btLoai.setText("Lo\u1ea1i");
                    btLoai.setForeground(Color.white);
                    btLoai.setFont(btLoai.getFont().deriveFont(btLoai.getFont().getStyle() | Font.BOLD, btLoai.getFont().getSize() + 2f));
                    btLoai.setBackground(new Color(255, 102, 255));
                    btLoai.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            btLoaiMouseClicked(e);
                        }
                    });
                    panel4.add(btLoai);
                    btLoai.setBounds(370, 135, 120, 35);

                    //======== scrollPane1 ========
                    {

                        //---- tableBook ----
                        tableBook.setForeground(Color.black);
                        tableBook.setBackground(Color.white);
                        tableBook.setModel(new DefaultTableModel(
                            new Object[][] {
                                {null, "", "", "", "", null},
                                {null, "", "", "", "", null},
                                {null, "", "", "", "", null},
                                {null, "", "", "", "", null},
                            },
                            new String[] {
                                "M\u00e3 s\u00e1ch", "T\u00ean s\u00e1ch", "T\u00e1c gi\u1ea3", "Ng\u00f4n ng\u1eef", "Th\u1ec3 lo\u1ea1i", "T\u00ecnh tr\u1ea1ng"
                            }
                        ));
                        tableBook.setPreferredScrollableViewportSize(new Dimension(450, 600));
                        scrollPane1.setViewportView(tableBook);
                    }
                    panel4.add(scrollPane1);
                    scrollPane1.setBounds(5, 210, 1020, 350);

                    //---- label18 ----
                    label18.setText("T\u00ecnh tr\u1ea1ng:");
                    label18.setForeground(Color.black);
                    label18.setFont(label18.getFont().deriveFont(label18.getFont().getStyle() | Font.BOLD, label18.getFont().getSize() + 2f));
                    panel4.add(label18);
                    label18.setBounds(710, 73, 80, 20);

                    //---- txtTinhtrang ----
                    txtTinhtrang.setBackground(Color.white);
                    txtTinhtrang.setForeground(Color.black);
                    panel4.add(txtTinhtrang);
                    txtTinhtrang.setBounds(800, 70, 155, 27);

                    //---- btNhap ----
                    btNhap.setText("Nh\u1eadp");
                    btNhap.setForeground(Color.white);
                    btNhap.setFont(btNhap.getFont().deriveFont(btNhap.getFont().getStyle() | Font.BOLD, btNhap.getFont().getSize() + 2f));
                    btNhap.setBackground(new Color(255, 102, 255));
                    btNhap.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            btNhapMouseClicked(e);
                        }
                    });
                    panel4.add(btNhap);
                    btNhap.setBounds(200, 135, 120, 35);

                    //---- btFind ----
                    btFind.setText("T\u00ecm ki\u1ebfm");
                    btFind.setForeground(Color.white);
                    btFind.setFont(btFind.getFont().deriveFont(btFind.getFont().getStyle() | Font.BOLD, btFind.getFont().getSize() + 2f));
                    btFind.setBackground(new Color(255, 102, 255));
                    btFind.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            btFindMouseClicked(e);
                        }
                    });
                    panel4.add(btFind);
                    btFind.setBounds(710, 135, 120, 35);

                    //---- txtMasach ----
                    txtMasach.setBackground(Color.white);
                    txtMasach.setForeground(Color.black);
                    panel4.add(txtMasach);
                    txtMasach.setBounds(160, 20, 155, 30);

                    //---- label19 ----
                    label19.setText("M\u00e3 s\u00e1ch:");
                    label19.setForeground(Color.black);
                    label19.setFont(label19.getFont().deriveFont(label19.getFont().getStyle() | Font.BOLD, label19.getFont().getSize() + 2f));
                    panel4.add(label19);
                    label19.setBounds(70, 23, 70, 20);

                    //---- btCapnhat ----
                    btCapnhat.setText("C\u1eadp nh\u1eadt");
                    btCapnhat.setForeground(Color.white);
                    btCapnhat.setBackground(new Color(255, 102, 255));
                    btCapnhat.setFont(btCapnhat.getFont().deriveFont(btCapnhat.getFont().getStyle() | Font.BOLD, btCapnhat.getFont().getSize() + 2f));
                    btCapnhat.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            btCapnhatMouseClicked(e);
                        }
                    });
                    panel4.add(btCapnhat);
                    btCapnhat.setBounds(540, 135, 120, 35);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel4.getComponentCount(); i++) {
                            Rectangle bounds = panel4.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel4.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel4.setMinimumSize(preferredSize);
                        panel4.setPreferredSize(preferredSize);
                    }
                }
                tabbedPane1.addTab("Qu\u1ea3n l\u00ed s\u00e1ch", panel4);
            }
            panel1.add(tabbedPane1);
            tabbedPane1.setBounds(0, 110, 1035, 645);

            //---- button2 ----
            button2.setText("\u0110\u0103ng xu\u1ea5t");
            button2.setBackground(new Color(255, 102, 255));
            button2.setFont(button2.getFont().deriveFont(button2.getFont().getStyle() | Font.BOLD, button2.getFont().getSize() + 2f));
            button2.setForeground(Color.white);
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    button2MouseClicked(e);
                }
            });
            panel1.add(button2);
            button2.setBounds(915, 80, 108, 30);

            //---- label13 ----
            label13.setText("X");
            label13.setForeground(Color.black);
            label13.setFont(label13.getFont().deriveFont(label13.getFont().getStyle() | Font.BOLD, label13.getFont().getSize() + 5f));
            label13.setBackground(Color.white);
            label13.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    label13MouseClicked(e);
                }
            });
            panel1.add(label13);
            label13.setBounds(1005, 5, 20, 20);

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
        panel1.setBounds(0, 0, 1035, 710);

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
    private JTabbedPane tabbedPane1;
    private JPanel panel3;
    private JTextField txtMadocgia;
    private JLabel label3;
    private JLabel label4;
    private JTextField txtHovaten;
    private JLabel label5;
    private JTextField txtTuoi;
    private JLabel label6;
    private JTextField txtDiachi;
    private JTextField txtSodienthoai;
    private JLabel label7;
    private JLabel label8;
    private JScrollPane scrollPane2;
    private JTable tableInf;
    private JButton buttonInsert;
    private JButton buttonDelete;
    private JButton buttonCapnhat;
    private JTextField txtEmail;
    private JLabel label15;
    private JTextField txtTensach;
    private JTextField txtNgaymuon;
    private JLabel label16;
    private JLabel label17;
    private JTextField txtNgaytra;
    private JLabel label20;
    private JComboBox<String> cbGioitinh;
    private JButton buttonTimkiem;
    private JPanel panel4;
    private JLabel label9;
    private JTextField txtTensachBk;
    private JLabel label10;
    private JTextField txtTacgia;
    private JLabel label11;
    private JComboBox<String> cbNgonNgu;
    private JLabel label12;
    private JTextField txtTheLoai;
    private JButton btLoai;
    private JScrollPane scrollPane1;
    private JTable tableBook;
    private JLabel label18;
    private JTextField txtTinhtrang;
    private JButton btNhap;
    private JButton btFind;
    private JTextField txtMasach;
    private JLabel label19;
    private JButton btCapnhat;
    private JButton button2;
    private JLabel label13;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
