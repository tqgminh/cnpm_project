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
public class TreEmModel {
    
    private int ID;
    private String hoTen;
    private int tuoi;
    private int ID_HoGiaDinh;
    private String phanThuong;
    private int giaTri;
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

    public int getID_HoGiaDinh() {
        return ID_HoGiaDinh;
    }

    public void setID_HoGiaDinh(int ID_HoGiaDinh) {
        this.ID_HoGiaDinh = ID_HoGiaDinh;
    }

    public String getPhanThuong() {
        return phanThuong;
    }

    public void setPhanThuong(String phanThuong) {
        this.phanThuong = phanThuong;
    }

    public int getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(int giaTri) {
        this.giaTri = giaTri;
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
                    "FROM ho_gia_dinh, tre_em " + 
                    "WHERE ho_gia_dinh.id = tre_em.id_hoGiaDinh and tre_em.id = " +
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
    
    // hàm lấy thông tin trẻ em theo mã html
    // cần in ra các thông tin gồm ID, họ tên, tuổi, ID gia đình, phần thưởng, giá trị, ngày tháng,..
    @Override
    public String toString() {
        String res =  "<html><style>h3 {margin-left: 100px; color: blue;} table { width: 100%} table, th, td {border:1px solid black; border-collapse: collapse;}"
                + "th, td {padding: 15px; text-align: left;} #t01 tr:nth-child(even) { background-color: #eee;}"
                + "#t01 tr:nth-child(odd) {background-color: #fff;} #t01 th {background-color: black;color: white;}</style><div>"
                + "<h3>Thông tin cơ bản hộ gia đình:"
                + "<p>Họ tên trẻ: <b>" + this.getHoTen()+ "</p>"
                + "<p>Tuổi: <b>" + this.getTuoi()+ "</p>"
                + "<p>Phần thưởng: <b>" + this.getPhanThuong()+ "</p>"
                + "<p>Giá trị phần thưởng: <b>" + this.getGiaTri()+" đồng"+ "</p>"
                + "<p>Ngày thưởng: <b>" + this.getNgayThuong()+ "</p>"
                + "<p>Họ tên chủ hộ: <b>" + this.getHoGiaDinhModel().getChuHo()+ "</p>"
                + "<p>Địa chỉ: <b>"+ this.getHoGiaDinhModel().getDiaChi()+"</p>";
        /*
                + "<table id = 't01'>"
                + "<tr>"
                + "<th>Họ tên</th>"
                + "<th>Địa chỉ</th>"
                + "<th>Phần thưởng</th>"
                + "<th>Giá trị phần thưởng</th>"
                + "<th>Ngày thưởng</th>"
                + "</tr>"
                + "<tr>"
                + "<td>" + this.getHoTen()+ "</td>"
                + "<td>" + this.getTuoi()+ "</td>"
                + "<td>" + this.getPhanThuong()+ "</th>"
                + "<td>" + this.getGiaTri()+" đồng"+ "</th>"
                + "<td>" + this.getNgayThuong()+ "</th>"
                + "</tr>";*/
        res += "</div></html>";
        return res;
    }
}
