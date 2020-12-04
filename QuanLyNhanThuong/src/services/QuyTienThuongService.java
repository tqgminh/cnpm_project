/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.QuyTienThuongModel;

/**
 *
 * @author Khương
 */
public class QuyTienThuongService {
    
    // hàm lấy nhận chi theo mã ID
    public QuyTienThuongModel getQuyTienThuong(int ID) {
        QuyTienThuongModel quyTienThuong = new QuyTienThuongModel();
        //code here;
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM quy_tien_thuong  WHERE id = " + ID;
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
          
               quyTienThuong.setID(rs.getInt("id"));
               quyTienThuong.setHoTen(rs.getString("hoTen"));
               quyTienThuong.setSoTien(rs.getInt("soTien"));
               quyTienThuong.setNgayThang(rs.getDate("ngayThang"));
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            this.exceptionHandle(e.getMessage());
        }
        return quyTienThuong;
    }
    
    // hàm lấy danh sách nhận chi có trong bảng
    public List<QuyTienThuongModel> getListQuyTienThuong() {
        List<QuyTienThuongModel> list = new ArrayList<>();
        //code here
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "select * from quy_tien_thuong order by id";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
              QuyTienThuongModel quyTienThuongModel = new QuyTienThuongModel();
              quyTienThuongModel.setHoTen(rs.getString("hoTen"));
              quyTienThuongModel.setID(rs.getInt("id"));
              quyTienThuongModel.setSoTien(rs.getInt("soTien"));
              quyTienThuongModel.setNgayThang(rs.getDate("ngayThang"));
              list.add(quyTienThuongModel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
            return list;
    }
    
    // tìm kiếm quỹ tiền thưởng theo họ tên
    public List<QuyTienThuongModel> search(String keyword) {
        List<QuyTienThuongModel> list = new ArrayList<>();
        //code here
        String query;
        if (keyword.trim().isEmpty()) {
            return this.getListQuyTienThuong();
        }
        // truy cap db
        // create query
        query = "SELECT * "
                + "FROM quy_tien_thuong "
                + "WHERE hoTen LIKE N'%"
                + keyword
                + "%'";

        // execute query
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
               QuyTienThuongModel quyTienThuongModel = new QuyTienThuongModel();
              quyTienThuongModel.setHoTen(rs.getString("hoTen"));
              quyTienThuongModel.setID(rs.getInt("id"));
              quyTienThuongModel.setSoTien(rs.getInt("soTien"));
              quyTienThuongModel.setNgayThang(rs.getDate("ngayThang"));
              list.add(quyTienThuongModel);
            }
            preparedStatement.close();
            connection.close();
        } catch (Exception mysqlException) {
            this.exceptionHandle(mysqlException.getMessage());
        }
        return list;
    }
    
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
        
    }
}
