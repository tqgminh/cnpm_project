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
import models.TreEmModel;
import services.TreEmService;
import utility.ClassTableModel;
import views.infoViews.InfoJframe;

/**
 *
 * @author Duy
 */
public class TreEmPanelController {
    private JPanel jpnView;
    private JTextField jtfSearch;
    private TreEmService treEmService;
    private List<TreEmModel> listTreEm;
    private ClassTableModel classTableModel = null;
    private final String COLUMNS[] = {"ID", "Họ tên", "Tuổi", "Phần thưởng", "Giá trị", "Mã nhận thưởng", "Thời gian"}; 
    private JFrame parentJFrame;

    public TreEmPanelController(JPanel jpnView, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.jtfSearch = jtfSearch;
        classTableModel = new ClassTableModel();
        this.treEmService = new TreEmService();
        this.listTreEm = this.treEmService.getListTreEm();
        initAction();
    }

    public TreEmPanelController() {
    }
    
    
    //viết hàm search ở HocSinhGioiService hiện ra học sinh với ID tương ứng
    public void initAction(){
        this.jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listTreEm = treEmService.search(key.trim());
                setDataTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listTreEm = treEmService.search(key.trim());
                setDataTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String key = jtfSearch.getText();
                listTreEm = treEmService.search(key.trim());
                setDataTable();
            }
        });
    }
    
    public void setDataTable() {
        List<TreEmModel> listItem = new ArrayList<>();
        this.listTreEm.forEach(treEm -> {
            listItem.add(treEm);
        });
        DefaultTableModel model = classTableModel.setTableTreEm(listItem, COLUMNS);
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
                    TreEmModel info = listTreEm.get(table.getSelectedRow());
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
        this.listTreEm = this.treEmService.getListTreEm();
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

    public TreEmService getTreEmService() {
        return treEmService;
    }

    public void setTreEmService(TreEmService treEmService) {
        this.treEmService = treEmService;
    }

    public List<TreEmModel> getListTreEmBeans() {
        return listTreEm;
    }

    public void setListTreEmBeans(List<TreEmModel> listTreEm) {
        this.listTreEm = listTreEm;
    }

    public ClassTableModel getClassTableModel() {
        return classTableModel;
    }

    public void setClassTableModel(ClassTableModel classTableModel) {
        this.classTableModel = classTableModel;
    }
    
    
    
}
