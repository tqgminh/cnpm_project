package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.TreEmModel;

/**
 *
 * @author Duy
 */
public class TreEmService {

    // lấy trẻ em theo ID
    public TreEmModel getTreEm(int ID) {
        TreEmModel treEm = new TreEmModel();
        // truy cap db
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM tre_em WHERE id = " + ID;
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                treEm.setID(rs.getInt("id"));
                treEm.setHoTen(rs.getString("hoTen"));
                treEm.setTuoi(rs.getInt("tuoi"));
                treEm.setID_HoGiaDinh(rs.getInt("id_hoGiaDinh"));
                treEm.setPhanThuong(rs.getString("phanThuong"));
                treEm.setGiaTri(rs.getInt("giaTri"));
                treEm.setID_NhanThuong(rs.getInt("id_nhanThuong"));
                treEm.setNgayThuong(rs.getDate("ngayThuong"));
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        return treEm;
    }

    // láy danh sách toàn bộ trẻ em
    public List<TreEmModel> getListTreEm() {
        List<TreEmModel> list = new ArrayList<>();
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM tre_em ORDER BY id";
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

    // tìm kiếm trẻ em theo tên
    public List<TreEmModel> search(String keyword) {
        List<TreEmModel> list = new ArrayList<>();
        String query;
        if (keyword.trim().isEmpty()) {
            return this.getListTreEm();
        }
        // truy cap db
        // create query
        query = "SELECT * "
                + "FROM tre_em "
                + "WHERE hoTen LIKE N'%"
                + keyword
                + "%'";

        // execute query
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
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
