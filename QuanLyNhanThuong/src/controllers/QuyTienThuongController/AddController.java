/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.QuyTienThuongManagerController;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.QuyTienThuongModel;
import services.MysqlConnection;

/**
 *
 * @author Khương
 */
public class AddController {
    // hàm thêm người chi tiền vào bảng quỹ tiền thưởng với thông tin nhận được
    public boolean addQuyTienThuong(QuyTienThuongModel quyTienThuongModel) throws SQLException, ClassNotFoundException {
        QuyTienThuongModel quyTienThuong = quyTienThuongModel;
        Connection connection = MysqlConnection.getMysqlConnection();
        
        String query = "INSERT INTO quy_tien_thuong(id, hoTen, soTien, ngayThang)"
                + " values (?, ?, ?, ?)";
        PreparedStatement preStatement = connection.prepareStatement(query);
        preStatement.setInt(1, quyTienThuongModel.getID());
        preStatement.setString(2, quyTienThuongModel.getHoTen());
        preStatement.setInt(3, quyTienThuongModel.getSoTien());
        java.sql.Date ngayThang = new java.sql.Date(quyTienThuongModel.getNgayThang().getTime());
        preStatement.setDate(4, ngayThang);
        preStatement.executeUpdate();
        return true;
    } 

    public boolean add(QuyTienThuongModel quyTienThuongModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    
}
