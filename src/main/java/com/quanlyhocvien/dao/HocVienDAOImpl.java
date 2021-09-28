
package com.quanlyhocvien.dao;

import com.quanlyhocvien.model.Student;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class HocVienDAOImpl implements HocVienDAO {

    @Override
    public List<Student> getList() {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM `student`;";
            List<Student> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setStudent_number(rs.getInt("student_number"));
                student.setStudent_name(rs.getString("student_name"));
                student.setStudent_phone(rs.getString("student_phone"));
                student.setStudent_birth(rs.getDate("student_birth"));
                student.setStudent_gender(rs.getBoolean("student_gender"));
                student.setStudent_state(rs.getBoolean("student_state"));
                student.setStudent_address(rs.getString("student_address"));
                list.add(student);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    @Override
    public int createOrUpdate(Student hocVien) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO student(student_number, student_name, student_birth, student_gender, student_phone, student_address, student_state) "
                    + "VALUES(?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE student_name = VALUES(student_name), "
                    + "student_birth = VALUES(student_birth), student_gender = VALUES(student_gender), student_phone = VALUES(student_phone), "
                    + "student_address = VALUES(student_address), student_state = VALUES(student_state);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, hocVien.getStudent_number());
            ps.setString(2, hocVien.getStudent_name());
            ps.setDate(3, new Date(hocVien.getStudent_birth().getTime()));
            ps.setBoolean(4, hocVien.isStudent_gender());
            ps.setString(5, hocVien.getStudent_phone());
            ps.setString(6, hocVien.getStudent_address());
            ps.setBoolean(7, hocVien.isStudent_state());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = 0;
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    
    public static void main(String[] args) {
        HocVienDAO hocVienDAO = new HocVienDAOImpl();
        System.out.println(hocVienDAO.getList());
    }

}
