package Project;

public class information {
    String Madocgia;
    String Hovaten;
    String Gioitinh;
    String Diachi;
    String Sodienthoai;
    String Email;
    String Tensach;
    String Ngaymuon;
    String Ngaytra;
    int Tuoi;

    public information() {
    }

    public information(String Madocgia, String Hovaten, int Tuoi, String Gioitinh, String Diachi, String Sodienthoai, String Email, String Tensach, String Ngaymuon, String Ngaytra) {
        this.Madocgia = Madocgia;
        this.Hovaten = Hovaten;
        this.Tuoi = Tuoi;
        this.Gioitinh = Gioitinh;
        this.Diachi = Diachi;
        this.Sodienthoai = Sodienthoai;
        this.Email = Email;
        this.Tensach = Tensach;
        this.Ngaymuon = Ngaymuon;
        this.Ngaytra = Ngaytra;
    }

    public String getMadocgia() {
        return Madocgia;
    }

    public void setMadocgia(String madocgia) {

        Madocgia = madocgia;
    }

    public String getHovaten() {

        return Hovaten;
    }

    public void setHovaten(String hovaten) {

        Hovaten = hovaten;
    }

    public String getGioitinh() {

        return Gioitinh;
    }

    public void setGioitinh(String gioitinh) {

        Gioitinh = gioitinh;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int tuoi) {

        Tuoi = tuoi;
    }

    public String getDiachi() {

        return Diachi;
    }

    public void setDiachi(String diachi) {

        Diachi = diachi;
    }

    public String getSodienthoai() {

        return Sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {

        Sodienthoai = sodienthoai;
    }

    public String getEmail() {

        return Email;
    }

    public void setEmail(String email) {

        Email = email;
    }

    public String getTensach() {

        return Tensach;
    }

    public void setTensach(String tensach) {
        Tensach = tensach;
    }

    public String getNgaymuon() {
        return Ngaymuon;
    }

    public void setNgaymuon(String ngaymuon) {
        Ngaymuon = ngaymuon;
    }

    public String getNgaytra() {
        return Ngaytra;
    }

    public void setNgaytra(String ngaytra) {
        Ngaytra = ngaytra;
    }
}


