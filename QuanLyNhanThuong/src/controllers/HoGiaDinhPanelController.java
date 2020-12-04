/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import models.HoGiaDinhModel;
import services.HoGiaDinhService;
import utility.ClassTableModel;
import views.infoViews.InfoJframe;

/**
 *
 * @author Minh
 */
public class HoGiaDinhPanelController {
    
    private JPanel jpnView;
    private JTextField jtfSearch;
    private HoGiaDinhService hoGiaDinhService;
    private List<HoGiaDinhModel> listHoGiaDinh;
    private ClassTableModel classTableModel = null;
    private final String[] COLUMNS = {"ID", "Chủ hộ", "Địa chỉ", "Số tiền"};
    private JFrame parentJFrame;
    
    public HoGiaDinhPanelController(JPanel jpnView, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        classTableModel = new ClassTableModel();
        this.hoGiaDinhService = new HoGiaDinhService();
        this.listHoGiaDinh = this.hoGiaDinhService.getListHoGiaDinh();
        initAction();
    }
    
    public HoGiaDinhPanelController() {
        
    }
    
    public void initAction(){
        this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listHoGiaDinh = hoGiaDinhService.search(key.trim());
                setDataTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listHoGiaDinh = hoGiaDinhService.search(key.trim());
                setDataTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listHoGiaDinh = hoGiaDinhService.search(key.trim());
                setDataTable();
            }
        });
    }
    
    public void setDataTable() {
        List<HoGiaDinhModel> listItem = new ArrayList<>();
        this.listHoGiaDinh.forEach(hoGiaDinh -> {
            listItem.add(hoGiaDinh);
        });
        DefaultTableModel model = classTableModel.setTableHoGiaDinh(listItem, COLUMNS);
        JTable table = new JTable(model) {
            @Override
            public boolean editCellAt(int row, int column, EventObject e) {
                return false;
            }
            
        };
        
        // thiet ke bang
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getColumnModel().getColumn(0).setMaxWidth(80);
        table.getColumnModel().getColumn(0).setMinWidth(80);
        table.getColumnModel().getColumn(0).setPreferredWidth(80);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                JOptionPane.showConfirmDialog(null, table.getSelectedRow());
                if (e.getClickCount() > 1) {
                    HoGiaDinhModel info = listHoGiaDinh.get(table.getSelectedRow());
                    InfoJframe infoJframe = new InfoJframe(info.toString(), parentJFrame);
                    infoJframe.setLocationRelativeTo(null);
                    infoJframe.setVisible(true);
                }
            }
            
        });
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(table);
        scroll.setPreferredSize(new Dimension(1350, 400));
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scroll);
        jpnView.validate();
        jpnView.repaint();
    }

    public void setParentJFrame(JFrame parentJFrame) {
        this.parentJFrame = parentJFrame;
    }
    
    public void refreshData() {
        this.listHoGiaDinh = this.hoGiaDinhService.getListHoGiaDinh();
        setDataTable();
    }
    public JPanel getJpnView() {
        return jpnView;
    }

    public void setJpnView(JPanel jpnView) {
        this.jpnView = jpnView;
    }

    public JTextField getJtfSearch() {
        return jtfSearch;
    }

    public void setJtfSearch(JTextField jtfSearch) {
        this.jtfSearch = jtfSearch;
    }
    
}
