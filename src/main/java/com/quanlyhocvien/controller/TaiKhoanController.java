
package com.quanlyhocvien.controller;

import com.quanlyhocvien.model.TaiKhoan;
import com.quanlyhocvien.services.TaiKhoanService;
import com.quanlyhocvien.services.TaiKhoanServiceImpl;
import com.quanlyhocvien.view.MainJFrame;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TaiKhoanController {
    
    private JDialog dialog;
    private JButton btnSubmit;
    private JTextField jtfTenDangNhap;
    private JPasswordField jtfMatKhau;
    private JLabel jlbMsg;
    
    private TaiKhoanService taiKhoanService = null;

    public TaiKhoanController(JDialog dialog, JButton btnSummit, JTextField jtfTenDangNhap, JPasswordField jtfMatKhau, JLabel jlbMsg) {
        this.dialog = dialog;
        this.btnSubmit = btnSummit;
        this.jtfTenDangNhap = jtfTenDangNhap;
        this.jtfMatKhau = jtfMatKhau;
        this.jlbMsg = jlbMsg;
        
        taiKhoanService = new TaiKhoanServiceImpl();
    }
    
    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(jtfTenDangNhap.getText().length() == 0 || jtfMatKhau.getText().length() == 0) {
                    jlbMsg.setText("Vui lòng nhập dữ liệu");
                }
                
                else {
                    TaiKhoan taiKhoan = taiKhoanService.login(jtfTenDangNhap.getText(),jtfMatKhau.getText());
                    if (taiKhoan == null) {
                        jlbMsg.setText("Tên đăng nhập hoặc mật khẩu không đúng");
                    }
                    else {
                        if (taiKhoan.isTinh_trang() == false) {
                            jlbMsg.setText("Tài khoản đang tạm khóa");
                        }
                        else {
                            dialog.dispose();
                            MainJFrame frame = new MainJFrame();
                            frame.setTitle("Quản Lý Học Viên");
                            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            frame.setVisible(true);
                        }
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
