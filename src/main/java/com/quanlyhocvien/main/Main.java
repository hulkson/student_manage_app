
package com.quanlyhocvien.main;
import com.quanlyhocvien.view.DangNhapJDialog;


public class Main {
    public static void main(String[] args) {
        DangNhapJDialog dialog = new DangNhapJDialog(null, true);
        dialog.setTitle("Đăng Nhập Hệ Thống");
        dialog.setResizable(false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
