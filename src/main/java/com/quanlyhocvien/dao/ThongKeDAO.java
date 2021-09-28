
package com.quanlyhocvien.dao;

import com.quanlyhocvien.bean.KhoaHocBean;
import com.quanlyhocvien.bean.LopHocBean;
import java.util.List;

public interface ThongKeDAO {
    public List<LopHocBean> getListByLopHoc();
    
    public List<KhoaHocBean> getListByKhoaHoc();
}
