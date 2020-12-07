/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import services.MysqlConnection;

/**
 *
 * @author Hoàng
 */
public class HoGiaDinhModel {
    
    private int ID;
    private String chuHo;
    private String diaChi;
    private int soTien;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getChuHo() {
        return chuHo;
    }

    public void setChuHo(String chuHo) {
        this.chuHo = chuHo;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public List<HocSinhGioiModel> getListHocSinhGioi() {
        List<HocSinhGioiModel> list = new ArrayList<HocSinhGioiModel>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT hsg.*" + 
                "FROM hoc_sinh_gioi hsg INNER JOIN ho_gia_dinh " + 
                "ON ho_gia_dinh.id = hsg.id_hoGiaDinh " + 
                "WHERE ho_gia_dinh.id = "+this.getID();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                HocSinhGioiModel hocSinhGioi = new HocSinhGioiModel();
                hocSinhGioi.setHoTen(rs.getString("hoTen"));
                hocSinhGioi.setTuoi(rs.getInt("tuoi"));
                hocSinhGioi.setTruongLop(rs.getString("truongLop"));
                hocSinhGioi.setThanhTich(rs.getString("thanhTich"));
                hocSinhGioi.setChungNhan(rs.getBoolean("chungNhan"));
                hocSinhGioi.setID_HoGiaDinh(rs.getInt("id_hoGiaDinh"));
                hocSinhGioi.setPhanThuong(rs.getString("phanThuong"));
                hocSinhGioi.setGiaTri(rs.getInt("giaTri"));
                hocSinhGioi.setID_NhanThuong(rs.getInt("id_nhanThuong"));
                hocSinhGioi.setNgayThuong(rs.getDate("ngayThuong"));
                list.add(hocSinhGioi);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public List<TreEmModel> getListTreEm() {
        List<TreEmModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT tre_em.* " + 
                    "FROM ho_gia_dinh, tre_em " + 
                    "WHERE ho_gia_dinh.id = tre_em.id_hoGiaDinh and tre_em.id = " +
                    ID;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
//            int idNhanKhau = -1;
            while (rs.next()) {
                TreEmModel treEm = new TreEmModel();
                treEm.setID(rs.getInt("id"));
                treEm.setHoTen(rs.getString("hoTen"));
                treEm.setTuoi(rs.getInt("tuoi"));
                treEm.setID_HoGiaDinh(rs.getInt("id_hoGiaDinh"));
                treEm.setPhanThuong(rs.getString("phanThuong"));
                treEm.setGiaTri(rs.getInt("giaTri"));
                treEm.setID_NhanThuong(rs.getInt("id_nhanThuong"));
                treEm.setNgayThuong(rs.getDate("ngayThuong"));
                list.add(treEm);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    
    // hàm lấy toàn bộ thông tin của hộ gia đình viết theo html
    // thông tin gồm ID, chủ hộ, địa chỉ, số tiền đã nhận, danh sách học sinh, trẻ em đã nhận cụ thể gồm tên, tuổi, phần thưởng, giá trị, thời gian
    @Override
    public String toString() {
        String res =  "<html><style>h3 {margin-left: 100px; color: blue;} table { width: 100%} table, th, td {border:1px solid black; border-collapse: collapse;}"
                + "th, td {padding: 15px; text-align: left;} #t01 tr:nth-child(even) { background-color: #eee;}"
                + "#t01 tr:nth-child(odd) {background-color: #fff;} #t01 th {background-color: black;color: white;}</style><div>"
                + "<h3>Thông tin cơ bản hộ gia đình:"
                + "<p>Họ tên chủ hộ: <b>" + this.getChuHo()+ "</p>"
                + "<p>Địa chỉ: <b>" + this.getDiaChi()+ "</p>"
                + "<p>Tiền đã nhận: <b>" + this.getSoTien()+ " đồng" + "</p>"
                + "<h4>Chi tiết các đợt nhận thưởng học sinh giỏi<table>"
                + "<tr>"
                + "<th>Họ tên</th>"
                + "<th>Tuổi</th>"
                + "<th>Trường lớp</th>"
                + "<th>Thành tích</th>"
                + "<th>Chứng nhận</th>"
                + "<th>Phần thưởng</th>"
                + "<th>Giá trị</th>"
                + "<th>Ngày thưởng</th>"
                + "</tr>";
        for(int i = 0; i < this.getListHocSinhGioi().size(); i++) {
            res += "<tr>"
                    + "<td>"
                    + this.getListHocSinhGioi().get(i).getHoTen()
                    + "</td>"
                    + "<td>"
                    + this.getListHocSinhGioi().get(i).getTuoi()
                    + "</td>"
                    + "<td>"
                    + this.getListHocSinhGioi().get(i).getTruongLop()
                    + "</td>"
                    + "<td>"
                    + this.getListHocSinhGioi().get(i).getThanhTich()
                    + "</td>"
                    + "<td>"
                    + (this.getListHocSinhGioi().get(i).isChungNhan() == true ? "Có" : "Không")
                    + "</td>"
                    + "<td>"
                    + this.getListHocSinhGioi().get(i).getPhanThuong()
                    + "</td>"
                    + "<td>"
                    + this.getListHocSinhGioi().get(i).getGiaTri()+" đồng"
                    + "</td>"
                    + "<td>"
                    + this.getListHocSinhGioi().get(i).getNgayThuong()
                    + "</td>"
                    + "</tr>";
        }
        res += "</table>";
        
        res += "<h4>Chi tiết các đợt nhận thưởg lễ, Tết<table>"
                + "<tr>"
                + "<th>Họ tên</th>"
                + "<th>Tuổi</th>"
                + "<th>Phần thưởng</th>"
                + "<th>Giá trị</th>"
                + "<th>Ngày thưởng</th>"
                + "</tr>";
        for(int i = 0; i < this.getListTreEm().size(); i++) {
             res += "<tr>"
                    + "<td>"
                    + this.getListTreEm().get(i).getHoTen()
                    + "</td>"
                    + "<td>"
                    + this.getListTreEm().get(i).getTuoi()
                    + "</td>"
                    + "<td>"
                    + this.getListTreEm().get(i).getPhanThuong()
                    + "</td>"
                    + "<td>"
                    + this.getListTreEm().get(i).getGiaTri()+" đồng"
                    + "</td>"
                    + "<td>"
                    + this.getListTreEm().get(i).getNgayThuong()
                    + "</td>"
                    + "</tr>";
        }
        res +=  "</table>"
                
                + "</div></html>";
        return res;
    }
    
    
}
