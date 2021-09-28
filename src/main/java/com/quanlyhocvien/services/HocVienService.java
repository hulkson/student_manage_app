package com.quanlyhocvien.services;

import com.quanlyhocvien.model.Student;
import java.util.List;

public interface HocVienService {
    public List<Student> getList();
    public int createOrUpdate(Student hocVien);
}
