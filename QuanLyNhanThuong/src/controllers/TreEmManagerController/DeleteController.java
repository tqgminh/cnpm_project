package controllers.TreEmManagerController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EventObject;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import services.MysqlConnection;
import services.TreEmService;

/**
 *
 * @author Duy
 */
public class DeleteController {

    // check ID nhận thưởng của trẻ em (kiểm tra xem có trong bảng không)
    public int checkID(int ID_NhanThuong) {
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM tre_em WHERE id_nhanThuong = " + ID_NhanThuong;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_nhanThuong");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
        }
        return -1;
    }

    // xóa trẻ em với thông tin ID_NhanThuong
    // cập nhật bảng liên quan
    public boolean deleteTreEm(int ID_NhanThuong) throws SQLException, ClassNotFoundException {
        //thực hiện xóa khỏi bảng Tre Em
        Connection connection = MysqlConnection.getMysqlConnection();

        String query = "SELECT * FROM tre_em"
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

        String sql_tre_em = "DELETE FROM tre_em"
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

        return true;
    }

}
