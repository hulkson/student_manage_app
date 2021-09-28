
package com.quanlyhocvien.services;

import com.quanlyhocvien.dao.HocVienDAO;
import com.quanlyhocvien.dao.HocVienDAOImpl;
import com.quanlyhocvien.model.Student;
import java.util.List;

public class HocVienServiceImpl implements HocVienService {
    
    private HocVienDAO hocVienDAO = null;
    
    public HocVienServiceImpl() {
        hocVienDAO = new HocVienDAOImpl();
    }

    @Override
    public List<Student> getList() {
        return hocVienDAO.getList();
    }

    @Override
    public int createOrUpdate(Student hocVien) {
        return hocVienDAO.createOrUpdate(hocVien);
    }
    
}
