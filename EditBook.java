package Project;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EditBook {
    public static List<Book> findBook() {
        List<Book> BookList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "0a0ab00chh");

            //query
            String query = "Select * from book";
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Book bk = new Book(rs.getString("Masach"), rs.getString("Tensach"), rs.getString("Tacgia"),
                        rs.getString("Ngonngu"), rs.getString("Theloai"), rs.getString("Tinhtrang"));
                BookList.add(bk);
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
        //end

        return BookList;
    }

    //Nhap
    public static void insert(Book bk) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "0a0ab00chh");

            //query
            String query = "insert into book(Masach, Tensach, Tacgia, Ngonngu, Theloai, Tinhtrang) values(?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(query);

            statement.setString(1, bk.getMasach());
            statement.setString(2, bk.getTensach());
            statement.setString(3, bk.getTacgia());
            statement.setString(4, bk.getNgonngu());
            statement.setString(5, bk.getTheloai());
            statement.setString(6, bk.getTinhtrang());

            statement.execute();
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
    }

    //Loai
    public static void delete(Book bk) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "0a0ab00chh");

            //query
            String query = "delete from book where Masach = ?";
            statement = connection.prepareCall(query);

            statement.setString(1, bk.getMasach());

            statement.execute();
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
    }

    //Find (tim kiem)
    public static List<Book> findMasach() {
        List<Book> BookList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "0a0ab00chh");

            //query
            String input = JOptionPane.showInputDialog(null, "Nhập mã sách: ");
            String query = "Select * from book where Masach like ?";

            statement = connection.prepareStatement(query);
            statement.setString(1, "%" + input + "%");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Book bk = new Book(rs.getString("Masach"), rs.getString("Tensach"), rs.getString("Tacgia"),
                        rs.getString("Ngonngu"), rs.getString("Theloai"), rs.getString("Tinhtrang"));
                BookList.add(bk);
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

        return BookList;
    }

    //Update (Cap nhat)
    static void updateBook(Book bk) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "0a0ab00chh");

            //query
            String query = "update book set Tensach = ?, Tacgia = ?, Ngonngu = ?, Theloai = ?, " +
                    "Tinhtrang = ? where Masach = ?";

            statement = connection.prepareCall(query);

            statement.setString(1, bk.getTensach());
            statement.setString(2, bk.getTacgia());
            statement.setString(3, bk.getNgonngu());
            statement.setString(4, bk.getTheloai());
            statement.setString(5, bk.getTinhtrang());
            statement.setString(6, bk.getMasach());

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
