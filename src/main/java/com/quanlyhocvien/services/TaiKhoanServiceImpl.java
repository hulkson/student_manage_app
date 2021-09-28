
package com.quanlyhocvien.services;

import com.quanlyhocvien.dao.TaiKhoanDAO;
import com.quanlyhocvien.dao.TaiKhoanDAOImpl;
import com.quanlyhocvien.model.TaiKhoan;

public class TaiKhoanServiceImpl implements TaiKhoanService {
    
    private TaiKhoanDAO taiKhoanDAO = null;

    public TaiKhoanServiceImpl() {
        taiKhoanDAO = new TaiKhoanDAOImpl();
    }
    
    

    @Override
    public TaiKhoan login(String tdn, String mk) {
        return taiKhoanDAO.login(tdn, mk);
    }

}
