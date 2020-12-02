/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.QuyTienThuongManagerController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import services.MysqlConnection;
import java.sql.ResultSet;
import models.QuyTienThuongModel;
/**
 *
 * @author Khương
 */
public class DeleteController {
    
    // kiểm tra xem ID có tồn tại trong bảng quỹ tiền thưởng không
    public int checkID(int ID) {
       
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * from quy_tien_thuong WHERE id = ? and soTien > 0";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,ID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                return rs.getInt("id");
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
        }
        return -1;
    }
    
    // xóa khỏi bảng quỹ tiền thưởng với ID trên
    public boolean deleteQuyTienThuong(int ID) throws SQLException, ClassNotFoundException  {
        //thực hiện xóa khỏi bảng Hoc Sinh Gioi
        Connection connection = MysqlConnection.getMysqlConnection();
        
        String query = "DELETE FROM quy_tien_thuong WHERE id = "+ID;
        PreparedStatement preStatement = connection.prepareStatement(query);
        preStatement.execute();
        preStatement.close();
        return true;
    }
}
