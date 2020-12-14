package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import services.MysqlConnection;
/**
 *
 * @author Hoàng
 */
public class HocSinhGioiModel {

    private int ID;
    private String hoTen;
    private int tuoi;
    private String truongLop;
    private String thanhTich;
    private boolean chungNhan;
    private int ID_HoGiaDinh;
    private int giaTri;
    private String phanThuong;
    private int ID_NhanThuong;
    private Date ngayThuong;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getTruongLop() {
        return truongLop;
    }

    public void setTruongLop(String truongLop) {
        this.truongLop = truongLop;
    }

    public String getThanhTich() {
        return thanhTich;
    }

    public void setThanhTich(String thanhTich) {
        this.thanhTich = thanhTich;
    }

    public boolean isChungNhan() {
        return chungNhan;
    }

    public void setChungNhan(boolean chungNhan) {
        this.chungNhan = chungNhan;
    }

    public int getID_HoGiaDinh() {
        return ID_HoGiaDinh;
    }

    public void setID_HoGiaDinh(int ID_HoGiaDinh) {
        this.ID_HoGiaDinh = ID_HoGiaDinh;
    }

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
    }

    public String getPhanThuong() {
        return phanThuong;
    }

    public void setPhanThuong(String phanThuong) {
        this.phanThuong = phanThuong;
    }

    public int getID_NhanThuong() {
        return ID_NhanThuong;
    }

    public void setID_NhanThuong(int ID_NhanThuong) {
        this.ID_NhanThuong = ID_NhanThuong;
    }

    public Date getNgayThuong() {
        return ngayThuong;
    }

    public void setNgayThuong(Date ngayThuong) {
        this.ngayThuong = ngayThuong;
    }
    
    public HoGiaDinhModel getHoGiaDinhModel() {
        HoGiaDinhModel hoGiaDinh = new HoGiaDinhModel();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT ho_gia_dinh.* " + 
                    "FROM ho_gia_dinh, hoc_sinh_gioi " + 
                    "WHERE ho_gia_dinh.id = hoc_sinh_gioi.id_hoGiaDinh and hoc_sinh_gioi.id = " +
                    ID;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                hoGiaDinh.setID(rs.getInt("id"));
                hoGiaDinh.setChuHo(rs.getString("chuHo"));
                hoGiaDinh.setDiaChi(rs.getString("diaChi"));
                hoGiaDinh.setSoTien(rs.getInt("soTien"));
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hoGiaDinh;
    }
    // hàm lấy thông tin học sinh giỏi theo mã html
    // thông tin gồm ID, tên, tuổi, trường lớp, thành tích, chứng nhận, ID hộ gia đình, phần thưởng, giá trị, ngày tháng
    @Override
    public String toString() {
        String chungNhan = this.isChungNhan() ? "đã chứng nhận" : "chưa được chứng nhận";
        String res =  "<html><style>h3 {margin-left: 100px; color: blue;} table { width: 100%} table, th, td {border:1px solid black; border-collapse: collapse;}"
                + "th, td {padding: 15px; text-align: left;} #t01 tr:nth-child(even) { background-color: #eee;}"
                + "#t01 tr:nth-child(odd) {background-color: #fff;} #t01 th {background-color: black;color: white;}</style><div>"
                + "<h3>Thông tin cơ bản:"
                + "<p>Họ tên học sinh: <b>" + this.getHoTen()+ "</p>"
                + "<p>Tuổi: <b>" + this.getTuoi()+ "</p>"
                + "<p>Trường lớp: <b>" + this.getTruongLop()+ "</p>"
                + "<p>Thành tích: <b>" + this.getThanhTich()+ "</p>"
                + "<p>Chứng nhận: <b>" + chungNhan+ "</p>"
                + "<p>Phần thưởng: <b>" + this.getPhanThuong()+ "</p>"
                + "<p>Giá trị phần thưởng: <b>" + this.getGiaTri()+" đồng"+"</p>"
                + "<p>Ngày nhận thưởng: <b>" + this.getNgayThuong()+ "</p>"
                + "<p>Họ tên chủ hộ: <b>" + this.getHoGiaDinhModel().getChuHo()+ "</p>"
                + "<p>Địa chỉ: <b>"+ this.getHoGiaDinhModel().getDiaChi()+"</p>";
        res += "</div></html>";
        return res;
    }
    
}
