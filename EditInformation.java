package Project;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;

public class EditInformation {
    public static List<information> findAll() {
        List<information> informationList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "0a0ab00chh");

            //query
            String query = "Select * from information";
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                information inf = new information(rs.getString("Madocgia"), rs.getString("Hovaten"), rs.getInt("Tuoi"), rs.getString("Gioitinh"),
                        rs.getString("Diachi"), rs.getString("Sodienthoai"), rs.getString("Email"), rs.getString("Tensach"),
                        rs.getString("Ngaymuon"), rs.getString("Ngaytra"));
                informationList.add(inf);
            }
        } catch (Exception e) {
            Logger.getLogger(EditInformation.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                    Logger.getLogger(EditInformation.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    Logger.getLogger(EditInformation.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        //end

        return informationList;
    }

    //insert (muon)
    public static void insert(information inf) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "0a0ab00chh");

            //query
            String query = "insert into information(Madocgia, Hovaten, Tuoi, Gioitinh, Diachi, Sodienthoai, Email, Tensach, Ngaymuon, Ngaytra) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(query);

            statement.setString(1, inf.getMadocgia());
            statement.setString(2, inf.getHovaten());
            statement.setInt(3, inf.getTuoi());
            statement.setString(4, inf.getGioitinh());
            statement.setString(5, inf.getDiachi());
            statement.setString(6, inf.getSodienthoai());
            statement.setString(7, inf.getEmail());
            statement.setString(8, inf.getTensach());
            statement.setString(9, inf.getNgaymuon());
            statement.setString(10, inf.getNgaytra());

            statement.execute();

        } catch (Exception e) {
            Logger.getLogger(EditInformation.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                    Logger.getLogger(EditInformation.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    Logger.getLogger(EditInformation.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }

    }

    //delete (tra)
    public static void delete(information inf) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "0a0ab00chh");

            //query
            String query = "delete from information where Madocgia = ?";
            statement = connection.prepareCall(query);

            statement.setString(1, inf.getMadocgia());

            statement.execute();

        } catch (Exception e) {
            Logger.getLogger(EditInformation.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                    Logger.getLogger(EditInformation.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    Logger.getLogger(EditInformation.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }

    }

    //Find (tim kiem)

    public static List<information> findByMadocgia() {
        List<information> informationList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "0a0ab00chh");

            //query
            String input = JOptionPane.showInputDialog(null, "Nhập mã độc giả: ");
            String query = "Select * from information where Madocgia like ?";

            statement = connection.prepareStatement(query);
            statement.setString(1, "%" + input + "%");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                information inf = new information(rs.getString("Madocgia"), rs.getString("Hovaten"), rs.getInt("Tuoi"), rs.getString("Gioitinh"),
                        rs.getString("Diachi"), rs.getString("Sodienthoai"), rs.getString("Email"), rs.getString("Tensach"),
                        rs.getString("Ngaymuon"), rs.getString("Ngaytra"));
                informationList.add(inf);
            }
        } catch (Exception e) {
            Logger.getLogger(EditInformation.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                    Logger.getLogger(EditInformation.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    Logger.getLogger(EditInformation.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return informationList;
    }

    //Update (cap nhat)
    static void update(information inf) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "0a0ab00chh");

            //query
            String query = "update information set Hovaten = ?, Tuoi = ?, Gioitinh = ?, Diachi = ?, " +
                    "Sodienthoai = ?, Email =?, Tensach = ?, Ngaymuon = ?, Ngaytra = ? where Madocgia = ?";

            statement = connection.prepareCall(query);

            statement.setString(1, inf.getHovaten());
            statement.setInt(2, inf.getTuoi());
            statement.setString(3, inf.getGioitinh());
            statement.setString(4, inf.getDiachi());
            statement.setString(5, inf.getSodienthoai());
            statement.setString(6, inf.getEmail());
            statement.setString(7, inf.getTensach());
            statement.setString(8, inf.getNgaymuon());
            statement.setString(9, inf.getNgaytra());
            statement.setString(10, inf.getMadocgia());


            statement.execute();

        } catch (Exception e) {
            Logger.getLogger(EditInformation.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                    Logger.getLogger(EditInformation.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    Logger.getLogger(EditInformation.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

}
