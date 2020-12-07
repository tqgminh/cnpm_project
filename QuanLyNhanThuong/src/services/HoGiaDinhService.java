/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.HoGiaDinhModel;

/**
 *
 * @author Minh
 */
public class HoGiaDinhService {
    
    // hàm truy vấn lấy về toàn bộ hộ gia đình trong bảng
    public List<HoGiaDinhModel> getListHoGiaDinh() {
        List<HoGiaDinhModel> list = new ArrayList<>();
        //code here
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            String query = "SELECT * FROM ho_gia_dinh ORDER BY id";
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                HoGiaDinhModel hoGiaDinh = new HoGiaDinhModel();
                hoGiaDinh.setID(rs.getInt("id"));
                hoGiaDinh.setChuHo(rs.getString("chuHo"));
                hoGiaDinh.setDiaChi(rs.getString("diaChi"));
                hoGiaDinh.setSoTien(rs.getInt("soTien"));
                list.add(hoGiaDinh);
            }
            preparedStatement.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    // hàm tìm kiếm hộ gia đình theo tên chủ hộ
    public List<HoGiaDinhModel> search(String keyword) {
        List<HoGiaDinhModel> list = new ArrayList<>();
        //code here
        String query;
        if(keyword.trim().isEmpty()) {
            return this.getListHoGiaDinh();
        }
        query = "SELECT * FROM ho_gia_dinh WHERE chuHo LIKE N'%"
                +keyword+"%'";
        try {
            Connection connection = MysqlConnection.getMysqlConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
                HoGiaDinhModel hoGiaDinh = new HoGiaDinhModel();
                hoGiaDinh.setID(rs.getInt("id"));
                hoGiaDinh.setChuHo(rs.getString("chuHo"));
                hoGiaDinh.setDiaChi(rs.getString("diaChi"));
                hoGiaDinh.setSoTien(rs.getInt("soTien"));
                list.add(hoGiaDinh);
            }
            preparedStatement.close();
            connection.close();
        }
        catch(Exception mysqlException) {
            this.exceptionHandle(mysqlException.getMessage());
        }
        return list;
    }
    
    private void exceptionHandle(String message) {
        JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.ERROR_MESSAGE);
    }
    
}
