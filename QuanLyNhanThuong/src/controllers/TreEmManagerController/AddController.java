package controllers.TreEmManagerController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EventObject;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.HocSinhGioiModel;
import models.TreEmModel;
import services.MysqlConnection;
import services.TreEmService;

/**
 *
 * @author Duy
 */
public class AddController {
    
    // hàm thêm mới trẻ em được nhận thưởng với đầu vào là đối tượng TreEmBean
    // cập nhật các bảng liên quan
    public boolean addTreEm(TreEmModel treEmModel) throws SQLException, ClassNotFoundException {
        TreEmModel treEm = treEmModel;
        Connection connection = MysqlConnection.getMysqlConnection();
        
        String query = "INSERT INTO quy_tien_thuong(id, hoTen, soTien, ngayThang)"
                + " values (?, ?, ?, ?)";
        PreparedStatement preStatement = connection.prepareStatement(query);
        preStatement.setInt(1, treEm.getID_NhanThuong());
        preStatement.setString(2, treEm.getHoTen());
        preStatement.setInt(3, -treEm.getGiaTri());
        java.sql.Date ngayThuong = new java.sql.Date(treEm.getNgayThuong().getTime());
        preStatement.setDate(4, ngayThuong);
        preStatement.executeUpdate();
            
        String sql_quy_tien_thuong = "INSERT INTO tre_em (id, hoTen, tuoi, id_hoGiaDinh, phanThuong, giaTri, id_nhanThuong, ngayThuong)"
                + " values (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql_quy_tien_thuong);
        preparedStatement.setInt(1, treEm.getID());
        preparedStatement.setString(2, treEm.getHoTen());
        preparedStatement.setInt(3, treEm.getTuoi());
        preparedStatement.setInt(4, treEm.getID_HoGiaDinh());
        preparedStatement.setString(5, treEm.getPhanThuong());
        preparedStatement.setInt(6, treEm.getGiaTri());
        preparedStatement.setInt(7, treEm.getID_NhanThuong());
        preparedStatement.setDate(8, ngayThuong);
        preparedStatement.execute();
        preparedStatement.close();

        String sql_ho_gia_dinh = "UPDATE ho_gia_dinh"
                + " SET soTien = soTien + "
                + treEm.getGiaTri()
                + " WHERE id = "
                + treEm.getID_HoGiaDinh();
        PreparedStatement prst = connection.prepareStatement(sql_ho_gia_dinh);
        prst.execute();
        prst.close();
        
        connection.close();
        return true;
    }
}
