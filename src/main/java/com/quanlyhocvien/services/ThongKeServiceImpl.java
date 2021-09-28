
package com.quanlyhocvien.services;

import com.quanlyhocvien.bean.KhoaHocBean;
import com.quanlyhocvien.bean.LopHocBean;
import com.quanlyhocvien.dao.ThongKeDAO;
import com.quanlyhocvien.dao.ThongKeDAOImpl;
import java.util.List;

public class ThongKeServiceImpl implements ThongKeService {
    
    private ThongKeDAO thongKeDAO = null;

    public ThongKeServiceImpl() {
        thongKeDAO = new ThongKeDAOImpl();
    }
    
    
    public List<LopHocBean> getListByLopHoc() {
        return thongKeDAO.getListByLopHoc();
    }

    @Override
    public List<KhoaHocBean> getListByKhoaHoc() {
        return thongKeDAO.getListByKhoaHoc();
    }

}
