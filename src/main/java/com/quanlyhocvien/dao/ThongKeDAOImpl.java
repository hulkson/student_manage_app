
package com.quanlyhocvien.dao;

import com.quanlyhocvien.bean.KhoaHocBean;
import com.quanlyhocvien.bean.LopHocBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThongKeDAOImpl implements ThongKeDAO {

    @Override
    public List<LopHocBean> getListByLopHoc() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT class_reg_date, COUNT(*) AS so_luong FROM classes GROUP BY class_reg_date";
            List<LopHocBean> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LopHocBean lopHocBean = new LopHocBean();
                lopHocBean.setNgayDangKy(rs.getString("class_reg_date"));
                lopHocBean.setSoLuongHocVien(rs.getInt("so_luong"));
                list.add(lopHocBean);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<KhoaHocBean> getListByKhoaHoc() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT course_name, course_start_date, course_end_date FROM course WHERE course_state = true;";
            List<KhoaHocBean> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhoaHocBean khoaHocBean = new KhoaHocBean();
                khoaHocBean.setTenKhoaHoc(rs.getString("course_name"));
                khoaHocBean.setNgayBatDau(rs.getDate("course_start_date"));
                khoaHocBean.setNgayKetThuc(rs.getDate("course_end_date"));
                list.add(khoaHocBean);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
