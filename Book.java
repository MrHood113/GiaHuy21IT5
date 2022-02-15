package Project;

public class Book {
    String Masach, Tensach, Tacgia, Ngonngu, Theloai, Tinhtrang;

    public Book() {
    }

    public Book(String Masach, String Tensach, String Tacgia, String Ngonngu, String Theloai, String Tinhtrang) {
        this.Masach = Masach;
        this.Tensach = Tensach;
        this.Tacgia = Tacgia;
        this.Ngonngu = Ngonngu;
        this.Theloai = Theloai;
        this.Tinhtrang = Tinhtrang;
    }

    public String getMasach() {
        return Masach;
    }

    public void setMasach(String masach) {
        Masach = masach;
    }

    public String getTensach() {
        return Tensach;
    }

    public void setTensach(String tensach) {
        Tensach = tensach;
    }

    public String getTacgia() {
        return Tacgia;
    }

    public void setTacgia(String tacgia) {
        Tacgia = tacgia;
    }

    public String getNgonngu() {
        return Ngonngu;
    }

    public void setNgonngu(String ngonngu) {
        Ngonngu = ngonngu;
    }

    public String getTheloai() {
        return Theloai;
    }

    public void setTheloai(String theloai) {
        Theloai = theloai;
    }

    public String getTinhtrang() {
        return Tinhtrang;
    }

    public void setTinhtrang(String tinhtrang) {
        Tinhtrang = tinhtrang;
    }
}
