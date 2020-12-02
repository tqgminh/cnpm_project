package controllers.HocSinhGioiManagerController;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.HocSinhGioiModel;
import services.HocSinhGioiService;
import services.MysqlConnection;

/**
 *
 * @author Thoại
 */
public class DeleteController {
    
    // check ID mã nhận thưởng của học sinh I (có tồn tại trong bảng không)
    public int checkID(int ID_NhanThuong) {
       try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM hoc_sinh_gioi WHERE id_nhanThuong = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, ID_NhanThuong);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_nhanThuong");
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
        }
        return -1;
    }
    
  
    // truy vấn vào cơ sở dữ liệu và xóa học sinh với ID nhận thưởng như trên
    // cập nhật và xóa ở các bảng có liên quan
    public boolean deleteHocSinhGioi(int ID_NhanThuong) throws SQLException, ClassNotFoundException {
        // cập nhật số tiền trong bảng hộ gia đình
        
        Connection connection= MysqlConnection.getMysqlConnection();
        
        String query = "SELECT * FROM hoc_sinh_gioi"
                + " WHERE id_nhanThuong = "
                + ID_NhanThuong;
        PreparedStatement subStatement = connection.prepareStatement(query);
        ResultSet rs = subStatement.executeQuery();
        int giaTri = 0, id_hoGiaDinh = 0;
        while (rs.next()) {
            giaTri = rs.getInt("giaTri");
            id_hoGiaDinh = rs.getInt("id_hoGiaDinh");
        }
        String sql_ho_gia_dinh = "UPDATE ho_gia_dinh"
                + " SET soTien = soTien - "
                + giaTri
                + " WHERE id = "
                + id_hoGiaDinh;
        PreparedStatement preStatement = connection.prepareStatement(sql_ho_gia_dinh);
        preStatement.execute();
        preStatement.close();

        String sql_tre_em = "DELETE FROM hoc_sinh_gioi"
                + " WHERE id_nhanThuong = "
                + ID_NhanThuong;
        PreparedStatement preparedStatement = connection.prepareStatement(sql_tre_em);
        preparedStatement.execute();
        preparedStatement.close();

        String sql_quy_tien_thuong = "DELETE FROM quy_tien_thuong"
                + " WHERE id = "
                + ID_NhanThuong;
        PreparedStatement prst = connection.prepareStatement(sql_quy_tien_thuong);
        prst.execute();
        prst.close();
        connection.close();
        return true;
    }

    private void exceptionHandle(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
