/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Date;

/**
 *
 * @author Hoàng
 */
public class QuyTienThuongModel {
    
    private int ID;
    private String hoTen;
    private int soTien;
    private Date ngayThang;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public Date getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(Date ngayThang) {
        this.ngayThang = ngayThang;
    }
    
    // hàm lấy thông tin các đợt nhận/chi tiền theo mã html
    // đối với thông tin nhận gồm ID, người tài trợ, thời gian, sồ tiền,...
    // đối với thông tin chi gồm ID, học sinh/trẻ em được thưởng, phần quà, giá trị, thời gian
    @Override
    public String toString() {
        String kieu_thay_doi = this.getSoTien() > 0 ? "Ủng hộ:" : "Thụ hưởng:";
        int kieutien = this.getSoTien() >= 0 ? 1:-1;
        String res =  "<html><style>h3 {margin-left: 100px; color: blue;} table { width: 100%} table, th, td {border:1px solid black; border-collapse: collapse;}"
                + "th, td {padding: 15px; text-align: left;} #t01 tr:nth-child(even) { background-color: #eee;}"
                + "#t01 tr:nth-child(odd) {background-color: #fff;} #t01 th {background-color: black;color: white;}</style><div>"
                + "<h3>Thông tin cơ bản hộ gia đình:"
                + "<p>Họ tên : <b>" + this.getHoTen()+ "</p>"
                + "<p>" + kieu_thay_doi +"<b>" + this.getSoTien()*kieutien+" đồng" + "</p>"
                + "<p>Ngày thay đổi: <b>" + this.getNgayThang()+ "</p>"
                + "<table id = 't01'>"
                + "<tr>"
                + "<th>Họ tên</th>"
                + "<th>"+kieu_thay_doi+"</th>"
                + "<th>Ngày thay đổi</th>"
                + "</tr>"
                + "<tr>"
                + "<td>" + this.getHoTen()+ "</td>"
                + "<td>" + this.getSoTien()*kieutien+" đồng" + "</td>"
                + "<td>" + this.getNgayThang()+ "</th>"
                + "</tr>";
        res +=  "</table>"
                + "</div></html>";
        return res;
    }
    
    
}
