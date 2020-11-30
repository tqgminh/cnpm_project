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
import models.QuyTienThuongModel;
import services.HoGiaDinhService;
import services.HocSinhGioiService;
import services.MysqlConnection;

/**
 *
 * @author Thoại
 */

public class AddController {
    
    // check ID mã nhận thưởng của học sinh I (có tồn tại trong bảng không)
    public int checkID(int ID_NhanThuong) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM hoc_sinh_gioi WHERE id_nhanThuong = "+ID_NhanThuong;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_nhanThuong");
            }
            connection.close();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! Vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
        }
        return -1;
    }
    
    public int checkID_HoGiaDinh(int ID_HoGiaDinh) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM ho_gia_dinh WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, ID_HoGiaDinh);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
            connection.close();
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! Vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
        }
        return -1;
    }
   
    // hàm thêm học sinh giỏi vào bảng HSG trong CSDL, đồng thời thêm vào bảng quỹ tiền thưởng, cập nhật bảng hộ gia đình
    public boolean addHocSinhGioi(HocSinhGioiModel hocSinhGioiModel) throws SQLException, ClassNotFoundException{
        HocSinhGioiModel hocSinhGioi = hocSinhGioiModel;
        Connection connection = MysqlConnection.getMysqlConnection();
            if (!hocSinhGioi.isChungNhan()) hocSinhGioi.setGiaTri(0);
            
            String SQL_quy_tien_thuong = "INSERT INTO quy_tien_thuong(id, hoTen, soTien, ngayThang)"
                    + " values (?, ?, ?, ?)";
            PreparedStatement preStatement = connection.prepareStatement(SQL_quy_tien_thuong);
            preStatement.setInt(1, hocSinhGioi.getID_NhanThuong());
            preStatement.setString(2,  hocSinhGioi.getHoTen());
            preStatement.setInt(3, - hocSinhGioi.getGiaTri());
            java.sql.Date ngayThuong = new java.sql.Date( hocSinhGioi.getNgayThuong().getTime());
            preStatement.setDate(4, ngayThuong);
            preStatement.executeUpdate();
            // 1-11
            String query = "INSERT INTO hoc_sinh_gioi (id, hoTen, tuoi, truongLop, thanhTich, chungNhan, id_hoGiaDinh, phanThuong, giaTri, id_NhanThuong, ngayThuong)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, hocSinhGioi.getID());
            preparedStatement.setString(2, hocSinhGioi.getHoTen());
            preparedStatement.setInt(3, hocSinhGioi.getTuoi());
            preparedStatement.setString(4, hocSinhGioi.getTruongLop());
            preparedStatement.setString(5, hocSinhGioi.getThanhTich());
            preparedStatement.setBoolean(6, hocSinhGioi.isChungNhan());
            preparedStatement.setInt(7, hocSinhGioi.getID_HoGiaDinh());
            preparedStatement.setString(8, hocSinhGioi.getPhanThuong());
            preparedStatement.setInt(9, hocSinhGioi.getGiaTri());
            preparedStatement.setInt(10, hocSinhGioi.getID_NhanThuong());
            preparedStatement.setDate(11, ngayThuong);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            String sql_ho_gia_dinh = "UPDATE ho_gia_dinh SET soTien = soTien + "
                    + hocSinhGioi.getGiaTri()
                    + " WHERE id = "
                    + hocSinhGioi.getID_HoGiaDinh();
            PreparedStatement prst = connection.prepareStatement(sql_ho_gia_dinh);
            prst.execute();
            prst.close();
        connection.close();
        return true;
    }
}
