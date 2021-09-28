
package com.quanlyhocvien.ulility;

import com.quanlyhocvien.model.Student;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ClassTableModel {
    
    public DefaultTableModel setTableHocVien(List<Student> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            // make state column become checkbox
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 7 ? Boolean.class : String.class;
            }
            
            
        };
        
        dtm.setColumnIdentifiers(listColumn);
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();
        if(rows > 0) {
            for (int i = 0; i < rows; i++) {
                Student student = listItem.get(i);
                obj = new Object[columns];
                obj[0] = student.getStudent_number();
                obj[1] = (i + 1);
                obj[2] = student.getStudent_name();
                obj[3] = student.getStudent_birth();
                obj[4] = student.isStudent_gender() == true ? "Nam" : "Nữ";
                obj[5] = student.getStudent_phone();
                obj[6] = student.getStudent_address();
                obj[7] = student.isStudent_state();
                dtm.addRow(obj);
            }
        }
        return dtm;
    } 
}
