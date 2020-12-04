package services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.HocSinhGioiModel;

/**
 *
 * @author Thoại
 */
public class HocSinhGioiService {
    
    /* 
     * Ham lay ra 1 hoc sinh gioi bang ID nhan thuong
     * 
     */
    public HocSinhGioiModel getHocSinhGioi(int ID) {
        HocSinhGioiModel hocSinhGioi = new HocSinhGioiModel();
        // truy cap db
        try { 
            Connection connection = MysqlConnection.getMysqlConnection(); //kết nối csdl
            String query = "SELECT * FROM hoc_sinh_gioi WHERE id_nhanThuong= " + ID;
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            //truy vấn dữ liệu xong
            while (rs.next()){ //truy vấn có kết quả thành công, set các thuộc tính cho hsg
                hocSinhGioi.setID(rs.getInt("id"));
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
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return hocSinhGioi;
    }
    
     // lấy danh sách học sinh giỏi trong bảng 
    public List<HocSinhGioiModel> getListHocSinhGioi() {
        List<HocSinhGioiModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM hoc_sinh_gioi ORDER BY id DESC";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                HocSinhGioiModel hocSinhGioi = new HocSinhGioiModel(); //truy vấn có kết quả thành công, set các thuộc tính cho hsg
                hocSinhGioi.setID(rs.getInt("id"));
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
        
    
     // tìm kiếm học sinh giỏi theo tên
    public List<HocSinhGioiModel> search(String keyword) throws ClassNotFoundException {
        List<HocSinhGioiModel> list = new ArrayList<>();
        if (keyword.trim().isEmpty()) {
            return this.getListHocSinhGioi();
        }
        String query ="SELECT *FROM hoc_sinh_gioi WHERE hoTen LIKE N'%"+keyword+"%'";
        
        try {
            Connection connection = MysqlConnection.getMysqlConnection(); 
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                HocSinhGioiModel hocSinhGioi = new HocSinhGioiModel();
                hocSinhGioi.setID(rs.getInt("id"));
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
        } catch (Exception mysqlException) {
            this.exceptionHandle(mysqlException.getMessage());
        }
        return list;
    }
    
    /*
     * Ham sử lý ngoại lệ : thông báo ra lỗi nhận được
     */
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
}
