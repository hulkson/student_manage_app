
package com.quanlyhocvien.controller;

import com.quanlyhocvien.model.Student;
import com.quanlyhocvien.services.HocVienService;
import com.quanlyhocvien.services.HocVienServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HocVienController {
    private JButton btnSubmit;
    private JTextField jtfMaHocVien;
    private JTextField jtfHoTen;
    private JDateChooser jdcNgaySinh;
    private JRadioButton jrdNam;
    private JRadioButton jrdNu;
    private JTextField jtfSoDienThoai;
    private JTextArea jtaDiaChi;
    private JCheckBox jcbTinhTrang;
    private JLabel jlbMsg;
    
    private Student hocVien = null;
    private HocVienService hocVienService = null;

    public HocVienController(JButton btnSubmit, JTextField jtfMaHocVien, JTextField jtfHoTen, 
            JDateChooser jdcNgaySinh, JRadioButton jrdNam, JRadioButton jrdNu, JTextField jtfSoDienThoai, 
            JTextArea jtaDiaChi, JCheckBox jcbTinhTrang, JLabel jlbMsg) {
        this.btnSubmit = btnSubmit;
        this.jtfMaHocVien = jtfMaHocVien;
        this.jtfHoTen = jtfHoTen;
        this.jdcNgaySinh = jdcNgaySinh;
        this.jrdNam = jrdNam;
        this.jrdNu = jrdNu;
        this.jtfSoDienThoai = jtfSoDienThoai;
        this.jtaDiaChi = jtaDiaChi;
        this.jcbTinhTrang = jcbTinhTrang;
        this.jlbMsg = jlbMsg;
        
        this.hocVienService = new HocVienServiceImpl();
    }

    public HocVienController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public void setView(Student hocVien) {
        this.hocVien = hocVien;
        
        jtfMaHocVien.setText("#" + hocVien.getStudent_number());
        jtfHoTen.setText(hocVien.getStudent_name());
        jdcNgaySinh.setDate(hocVien.getStudent_birth());
        
        if(hocVien.isStudent_gender()) {
            jrdNam.setSelected(true);
            jrdNu.setSelected(false);
        }
        else {
            jrdNam.setSelected(false);
            jrdNu.setSelected(true);
        }
        
        jtfSoDienThoai.setText(hocVien.getStudent_phone());
        jtaDiaChi.setText(hocVien.getStudent_address());
        jcbTinhTrang.setSelected(hocVien.isStudent_gender());
    }
    
    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfHoTen.getText().length() == 0 || jdcNgaySinh.getDate() == null) {
                    jlbMsg.setText("Vui lòng nhập dữ liệu");
                }
                
                else {
                    hocVien.setStudent_name(jtfHoTen.getText());
                    hocVien.setStudent_birth(jdcNgaySinh.getDate());
                    hocVien.setStudent_gender(jrdNam.isSelected());
                    hocVien.setStudent_phone(jtfSoDienThoai.getText());
                    hocVien.setStudent_address(jtaDiaChi.getText());
                    hocVien.setStudent_state(jcbTinhTrang.isSelected());
                    int lastId = hocVienService.createOrUpdate(hocVien);
                    if(lastId >= 0) {
                        hocVien.setStudent_number(lastId);
                        jtfMaHocVien.setText("#" + lastId);
                        jlbMsg.setText("Cập Nhật Dữ Liệu Thành Công");
                    }
                    
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSubmit.setBackground(new Color(100, 221, 23));
            }  
        });
    }
}
