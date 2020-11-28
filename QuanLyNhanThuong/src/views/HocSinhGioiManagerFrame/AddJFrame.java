package views.HocSinhGioiManagerFrame;


import controllers.HocSinhGioiManagerController.AddController;
import controllers.HocSinhGioiPanelController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import models.HocSinhGioiModel;
import controllers.HocSinhGioiManagerController.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Thoại
 */
public class AddJFrame extends javax.swing.JFrame {

    /**
     * Creates new form AddJFrame
     */
    private HocSinhGioiPanelController parentController;
    private JFrame parentJFrame;
    private HocSinhGioiModel hocSinhGioiModel;
    private AddController controller;


    public AddJFrame(HocSinhGioiPanelController parentController, JFrame parentJFrame) {
        this.parentController = parentController;
        this.parentJFrame = parentJFrame;
        this.parentJFrame.setEnabled(false);
        this.hocSinhGioiModel = new HocSinhGioiModel();
        initComponents();
        setTitle("Thêm mới học sinh giỏi");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        controller = new AddController();
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
            }
            
        });
    }
    
    public AddJFrame(JFrame parentJFrame) {
        this.parentController = new HocSinhGioiPanelController(){
            @Override
            public void refreshData() {
                // do nothing
            }

            @Override
            public void initAction() {
                // do nothing
            }
            
            
        };
        this.parentJFrame = parentJFrame;
        this.parentJFrame.setEnabled(false);
        this.hocSinhGioiModel = new HocSinhGioiModel();
        initComponents();
        setTitle("Thêm mới học sinh giỏi");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        controller = new AddController();
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Warning!!", JOptionPane.YES_NO_OPTION) == 0) {
                    close();
                }
            }
            
        });
    }
    
    void close() {
        this.parentJFrame.setEnabled(true);
        dispose();
    }
    
    // kiểm tra các giá trị trong form
    private boolean validateValueInForm() {
       if (((IDTxb.getText().trim().isEmpty() 
                || hoTenTxb.getText().trim().isEmpty()
                || truongLopTxb.getText().trim().isEmpty()
                || thanhTichTxb.getText().trim().isEmpty()
                || idHoGiaDinhTxb.getText().trim().isEmpty()
                || ID_NhanThuongJtf.getText().trim().isEmpty())==true)
        ) { 
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập hết các trường bắt buộc", "Warning", JOptionPane.WARNING_MESSAGE);
            return false;
        }
       
        // check định dạng ID
        try {
               int a1 = Integer.parseInt(IDTxb.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đúng định dạng ID!", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        
        //check định dạng ID_hoGiaDinh
        try {
                int a2 = Integer.parseInt(idHoGiaDinhTxb.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đúng định dạng ID Hộ Gia Đình!", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
     
        //check định dạng ID_NhanThuong
        if (chungNhanCbx.isSelected()==true) {
            // check định dạng Giá trị
            if (giaTriJtf.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập Giá trị!", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            } 
            if (phanThuongJft.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập Phần thưởng!", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            } 
            try {
                int a3 = Integer.parseInt(giaTriJtf.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đúng định dạng Giá trị!", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }
        
        try {
                int a4 = Integer.parseInt(ID_NhanThuongJtf.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đúng định dạng ID Nhận Thưởng!", "Warning", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        
        
         return true;
    }
         

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        hoTenTxb = new javax.swing.JTextField();
        idHoGiaDinhTxb = new javax.swing.JTextField();
        truongLopTxb = new javax.swing.JTextField();
        thanhTichTxb = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        IDTxb = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        phanThuongJft = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        giaTriJtf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ID_NhanThuongJtf = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        chungNhanCbx = new javax.swing.JCheckBox();
        tuoiCbb = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        addBtn.setBackground(new java.awt.Color(255, 255, 255));
        addBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        addBtn.setText("Thêm");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(255, 255, 255));
        cancelBtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cancelBtn.setText("Hủy");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Họ và tên:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("(*)");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("(*)");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Thành tích:");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("(*)");

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setText("(*)");

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Tuổi:");

        jLabel35.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel35.setText("ID Hộ gia đình:");

        jLabel36.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel36.setText("Trường lớp:");

        jLabel38.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel38.setText("Chứng nhận:");

        hoTenTxb.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        idHoGiaDinhTxb.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        truongLopTxb.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        thanhTichTxb.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("ID:");

        IDTxb.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("(*)");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Phần thưởng:");

        phanThuongJft.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Giá trị:");

        giaTriJtf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Mã nhận thưởng:");

        ID_NhanThuongJtf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setText("(*)");

        jDateChooser2.setEnabled(false);
        jDateChooser2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Ngày thưởng");

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setText("(*)");

        chungNhanCbx.setBackground(new java.awt.Color(255, 255, 255));
        chungNhanCbx.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chungNhanCbx.setForeground(new java.awt.Color(255, 0, 0));
        chungNhanCbx.setText("Đã chứng nhận");
        chungNhanCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chungNhanCbxActionPerformed(evt);
            }
        });

        tuoiCbb.setEditable(true);
        tuoiCbb.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tuoiCbb.setMaximumRowCount(30);
        tuoiCbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        tuoiCbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuoiCbbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IDTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(ID_NhanThuongJtf)
                                    .addGap(125, 125, 125))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(giaTriJtf)
                                    .addGap(123, 123, 123))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addComponent(phanThuongJft, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(thanhTichTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                            .addComponent(jLabel6))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(truongLopTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(hoTenTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(idHoGiaDinhTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(chungNhanCbx)
                    .addComponent(tuoiCbb, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hoTenTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tuoiCbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(thanhTichTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(truongLopTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chungNhanCbx)
                                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idHoGiaDinhTxb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(phanThuongJft, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(giaTriJtf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ID_NhanThuongJtf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Xử lý sự kiện nút thêm
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {
        if (this.validateValueInForm()){
            if (JOptionPane.showConfirmDialog(null, "Thêm mới học sinh với thông tin như trên?","Confirm",JOptionPane.YES_NO_OPTION) == 0){
                
                    hocSinhGioiModel = new HocSinhGioiModel();
                    hocSinhGioiModel.setID(Integer.parseInt(IDTxb.getText()));
                    hocSinhGioiModel.setHoTen(hoTenTxb.getText());
                    hocSinhGioiModel.setTuoi(Integer.parseInt(tuoiCbb.getItemAt(tuoiCbb.getSelectedIndex())));
                    hocSinhGioiModel.setTruongLop(truongLopTxb.getText());
                    hocSinhGioiModel.setThanhTich(thanhTichTxb.getText());
                    hocSinhGioiModel.setChungNhan(chungNhanCbx.isSelected());
                    hocSinhGioiModel.setID_HoGiaDinh(Integer.parseInt(idHoGiaDinhTxb.getText()));
                    hocSinhGioiModel.setPhanThuong(phanThuongJft.getText());
                    if (chungNhanCbx.isSelected()==true){
                    hocSinhGioiModel.setGiaTri(Integer.parseInt(giaTriJtf.getText()));}
                    else hocSinhGioiModel.setGiaTri(0);
                    hocSinhGioiModel.setID_NhanThuong(Integer.parseInt(ID_NhanThuongJtf.getText()));
                    hocSinhGioiModel.setNgayThuong(jDateChooser2.getDate());
                    
                    //check học sinh giỏi đã tồn tại chưa
                    if (this.controller.checkID(hocSinhGioiModel.getID_NhanThuong())!=-1) {
                        JOptionPane.showMessageDialog(null, "Đã tồn tại học sinh này, vui lòng thay đổi ID và ID Nhận Thưởng!", "Warning!!", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    
                    //check hộ gia đình đã tồn tại chưa
                    
                    if (this.controller.checkID_HoGiaDinh(hocSinhGioiModel.getID_HoGiaDinh())==-1){
                        JOptionPane.showMessageDialog(null, "Không tồn tại hộ gia đình này!", "Warning!!", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                try {    
                    if (this.controller.addHocSinhGioi(hocSinhGioiModel)){
                        JOptionPane.showMessageDialog(null, "Thêm thành công!!");
                        this.parentJFrame.setEnabled(true);
                        parentController.refreshData();
                        close();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Có lỗi xảy ra! Vui lòng kiểm tra lại.", "Warning!!", JOptionPane.WARNING_MESSAGE);
                }
        
            }
        }
    }

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Are you sure to close this??","Confirm",JOptionPane.YES_NO_OPTION) == 0) {
            close();
        }
    }//GEN-LAST:event_cancelBtnActionPerformed
//GEN-FIRST:event_CreateBtnActionPerformed

//GEN-LAST:event_CreateBtnActionPerformed

    private void chungNhanCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chungNhanCbxActionPerformed
        // TODO controller your handling code here:
    }//GEN-LAST:event_chungNhanCbxActionPerformed

    private void tuoiCbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuoiCbbActionPerformed
        // TODO controller your handling code here:
    }//GEN-LAST:event_tuoiCbbActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDTxb;
    private javax.swing.JTextField ID_NhanThuongJtf;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JCheckBox chungNhanCbx;
    private javax.swing.JTextField giaTriJtf;
    private javax.swing.JTextField hoTenTxb;
    private javax.swing.JTextField idHoGiaDinhTxb;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField phanThuongJft;
    private javax.swing.JTextField thanhTichTxb;
    private javax.swing.JTextField truongLopTxb;
    private javax.swing.JComboBox<String> tuoiCbb;
    // End of variables declaration//GEN-END:variables

}