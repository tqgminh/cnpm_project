package utility;


import java.util.List;
import javax.swing.table.DefaultTableModel;
import models.HoGiaDinhModel;
import models.TreEmModel;
import models.HocSinhGioiModel;
import models.QuyTienThuongModel;


/**
 *
 * @author Minh
 * class dinh nghia cac dang table co trong phan mem
 */
public class ClassTableModel {
    // bang cho main frame
    public DefaultTableModel setTableHocSinhGioi(List<HocSinhGioiModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 5 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((HocSinhGioiModel item) -> {
            //"ID", "Họ tên", "Tuổi", "Trường lớp", "Thành tích", "Chứng nhận", "Mã nhận thưởng", "Thời gian"
            obj[0] = item.getID();
            obj[1] = item.getHoTen();
            obj[2] = item.getTuoi();
            obj[3] = item.getTruongLop();
            obj[4] = item.getThanhTich();
            obj[5] = item.isChungNhan();
            obj[6] = item.getID_NhanThuong();
            obj[7] = item.getNgayThuong();
            dtm.addRow(obj);
        });
        return dtm;
    }
    
    public DefaultTableModel setTableTreEm(List<TreEmModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((TreEmModel item) -> {
            //"ID", "Họ tên", "Tuổi", "Phần thưởng", "Giá trị", "Mã nhận thưởng", "Thời gian"
            obj[0] = item.getID();
            obj[1] = item.getHoTen();
            obj[2] = item.getTuoi();
            obj[3] = item.getPhanThuong();
            obj[4] = item.getGiaTri();
            obj[5] = item.getID_NhanThuong();
            obj[6] = item.getNgayThuong();
            dtm.addRow(obj);
        });
        return dtm;
    }
    
    public DefaultTableModel setTableQuyTienThuong(List<QuyTienThuongModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 4 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((QuyTienThuongModel item) -> {
            //"ID", "Họ tên", "Nhận/Chi", "Thời gian"
            obj[0] = item.getID();
            obj[1] = item.getHoTen();
            obj[2] = item.getSoTien();
            obj[3] = item.getNgayThang();
            dtm.addRow(obj);
        });
        return dtm;
    }
    
    public DefaultTableModel setTableHoGiaDinh(List<HoGiaDinhModel> listItem, String[] listColumn) {
        final int columns = listColumn.length;
        DefaultTableModel dtm = new DefaultTableModel()  {
            @Override
            public boolean isCellEditable(int row, int column) {
                return super.isCellEditable(row, column); //To change body of generated methods, choose Tools | Templates.
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 4 ? Boolean.class : String.class;
            }
        };
        dtm.setColumnIdentifiers(listColumn);
        Object[] obj;
        obj = new Object[columns];
        listItem.forEach((HoGiaDinhModel item) -> {
            //"ID", "Chủ hộ", "Địa chỉ", "Số tiền"
            obj[0] = item.getID();
            obj[1] = item.getChuHo();
            obj[2] = item.getDiaChi();
            obj[3] = item.getSoTien();
            dtm.addRow(obj);
        });
        return dtm;
    }
}
