
package com.quanlyhocvien.dao;

import com.quanlyhocvien.model.Student;
import java.util.List;


public interface HocVienDAO {

    public List<Student> getList();
    public int createOrUpdate(Student hocVien);
    
}
