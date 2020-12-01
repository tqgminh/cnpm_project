/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.HocSinhGioiManagerController;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import models.HocSinhGioiModel;
import services.MysqlConnection;
/**
 *
 * @author Hoàng
 */
public class CertificateController {
    
    // hàm check ID mã nhận thưởng của học sinh có hợp lệ không (có tồn tại trong bảng không và có đúng là học sinh chưa được chứng nhận không)
    public int checkID(String ID_NhanThuong) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM hoc_sinh_gioi where chungNhan = 0 and id_nhanThuong = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ID_NhanThuong);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID_NhanThuong");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
        }
        return -1;
    }
    
    // hàm thêm chứng nhận cho học sinh với ID hợp lệ (update cho học sinh với những thông tin mới nhận được)
    // lưu ý thêm vào bảng có liên quan (bảng Quy Tien Thuong, cập nhật bảng Ho Gia Dinh)
    public boolean certificateHocSinhGioi(HocSinhGioiModel hsgModel) {
         try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "update hoc_sinh_gioi set chungNhan = ?, phanThuong = ?, giaTri = ?, ngayThuong = ? where id_nhanThuong = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, hsgModel.getPhanThuong());
            preparedStatement.setString(3, String.valueOf(hsgModel.getGiaTri()));
            Date ngayThuong = new Date(hsgModel.getNgayThuong().getTime());
            preparedStatement.setDate(4, ngayThuong);
            preparedStatement.setInt(5, hsgModel.getID_NhanThuong());
            preparedStatement.execute();
            preparedStatement.close();
            query = "update quy_tien_thuong set soTien = ?, ngayThang = ? where id in (select id from hoc_sinh_gioi where id_nhanThuong = ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, -hsgModel.getGiaTri());
            preparedStatement.setDate(2, ngayThuong);
            preparedStatement.setInt(3, hsgModel.getID_NhanThuong());
            preparedStatement.execute();
            preparedStatement.close();
            query = "update ho_gia_dinh set soTien = soTien + ? where id = (select id_hoGiaDinh from hoc_sinh_gioi where id_nhanThuong = ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, hsgModel.getGiaTri());
            preparedStatement.setInt(2, hsgModel.getID_NhanThuong());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
}
