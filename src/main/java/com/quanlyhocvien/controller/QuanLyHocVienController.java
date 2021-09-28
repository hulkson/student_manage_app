
package com.quanlyhocvien.controller;

import com.quanlyhocvien.model.Student;
import com.quanlyhocvien.services.HocVienService;
import com.quanlyhocvien.services.HocVienServiceImpl;
import com.quanlyhocvien.ulility.ClassTableModel;
import com.quanlyhocvien.view.HocVienJFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class QuanLyHocVienController {
    private JPanel jpnView;
    private JButton btnAdd;
    private JTextField jtfSearch;
    
    private HocVienService hocVienService = null;
    private String[] listColumn = {"Mã Học Viên", "STT", "Họ và Tên", "Ngày Sinh", "Giới Tính", "Phone", "Địa Chỉ", "Tình Trạng"};
    
    private TableRowSorter<TableModel> rowSorter = null;

    public QuanLyHocVienController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        
        this.hocVienService = new HocVienServiceImpl();
    }
    
    public void setDateToTable() {
        List<Student> listItem = hocVienService.getList();
        
        DefaultTableModel model = new ClassTableModel().setTableHocVien(listItem, listColumn);
        JTable table = new JTable(model);   
        
        rowSorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(rowSorter);
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                }
                else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if(text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                }
                else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });
        
        // set table min, max width
        table.getColumnModel().getColumn(0).setMinWidth(0);
        table.getColumnModel().getColumn(0).setMaxWidth(0);
        table.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        table.getColumnModel().getColumn(1).setMinWidth(80);
        table.getColumnModel().getColumn(1).setMaxWidth(80);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int selectRowIndex = table.getSelectedRow();
                    selectRowIndex = table.convertRowIndexToModel(selectRowIndex);
                    
                    Student hocVien = new Student();
                    hocVien.setStudent_number((int) model.getValueAt(selectRowIndex, 0));
                    hocVien.setStudent_name(model.getValueAt(selectRowIndex, 2).toString());
                    hocVien.setStudent_birth((Date) model.getValueAt(selectRowIndex, 3));
                    hocVien.setStudent_gender(model.getValueAt(selectRowIndex, 4).toString().equalsIgnoreCase("Nam"));
                    hocVien.setStudent_phone(model.getValueAt(selectRowIndex, 5) != null ?
                            model.getValueAt(selectRowIndex, 5).toString() : "");
                    hocVien.setStudent_address(model.getValueAt(selectRowIndex, 6) != null ?
                            model.getValueAt(selectRowIndex, 6).toString() : "");
                    hocVien.setStudent_state((boolean) model.getValueAt(selectRowIndex, 7));
                    
                    HocVienJFrame frame = new HocVienJFrame(hocVien);
                    frame.setTitle("Thông Tin Học Viên");
                    frame.setResizable(false);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    
                }
            }
            
        });
        
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();
        
        JScrollPane scrollPanel = new JScrollPane();
        scrollPanel.getViewport().add(table);
        scrollPanel.setPreferredSize(new Dimension(1300, 400));
        jpnView .removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPanel);
        jpnView.validate();
        jpnView.repaint();
    }
    
    public void setEvent() {
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                HocVienJFrame frame = new HocVienJFrame(new Student());
                frame.setTitle("Thông Tin Học Viên");
                frame.setLocationRelativeTo(null);
                frame.setResizable(false);
                frame.setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(100, 221, 23));
            }
        });
    }
    
}

