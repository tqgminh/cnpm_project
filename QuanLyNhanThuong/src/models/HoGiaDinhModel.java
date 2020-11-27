/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Hoàng
 */
public class HoGiaDinhModel {
    
    private int ID;
    private String chuHo;
    private String diaChi;
    private int soTien;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getChuHo() {
        return chuHo;
    }

    public void setChuHo(String chuHo) {
        this.chuHo = chuHo;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }
    
    // hàm lấy toàn bộ thông tin của hộ gia đình viết theo html
    // thông tin gồm ID, chủ hộ, địa chỉ, số tiền đã nhận, danh sách học sinh, trẻ em đã nhận cụ thể gồm tên, tuổi, phần thưởng, giá trị, thời gian
    @Override
    public String toString() {
        String res =  "<html><style>h3 {margin-left: 100px; color: blue;} table { width: 100%} table, th, td {border:1px solid black; border-collapse: collapse;}"
                + "th, td {padding: 15px; text-align: left;} #t01 tr:nth-child(even) { background-color: #eee;}"
                + "#t01 tr:nth-child(odd) {background-color: #fff;} #t01 th {background-color: black;color: white;}</style><div>"
                + "<h3>Thông tin cơ bản hộ gia đình:"
                + "<p>Họ tên chủ hộ: <b>" + this.getChuHo()+ "</p>"
                + "<p>Địa chỉ: <b>" + this.getDiaChi()+ "</p>"
                + "<p>Tiền đã nhận: <b>" + this.getSoTien()+ "</p>"
                + "<table id = 't01'>"
                + "<tr>"
                + "<th>Họ tên</th>"
                + "<th>Địa chỉ</th>"
                + "<th>Số tiền đã nhận</th>"
                + "</tr>"
                + "<tr>"
                + "<td>" + this.getChuHo()+ "</td>"
                + "<td>" + this.getDiaChi()+ "</td>"
                + "<td>" + this.getSoTien()+ "</th>"
                + "</tr>";
        res +=  "</table>"
                + "</div></html>";
        return res;
    }
    
    
}
