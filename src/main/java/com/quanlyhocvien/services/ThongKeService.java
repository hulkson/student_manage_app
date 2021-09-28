
package com.quanlyhocvien.services;

import com.quanlyhocvien.bean.KhoaHocBean;
import com.quanlyhocvien.bean.LopHocBean;
import java.util.List;

public interface ThongKeService {
    
    public List<LopHocBean> getListByLopHoc();
    
    public List<KhoaHocBean> getListByKhoaHoc();
}
