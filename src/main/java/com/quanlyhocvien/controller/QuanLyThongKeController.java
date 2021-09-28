
package com.quanlyhocvien.controller;

import com.quanlyhocvien.bean.KhoaHocBean;
import com.quanlyhocvien.bean.LopHocBean;
import com.quanlyhocvien.services.ThongKeService;
import com.quanlyhocvien.services.ThongKeServiceImpl;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.gantt.Task;
import org.jfree.data.gantt.TaskSeries;
import org.jfree.data.gantt.TaskSeriesCollection;

public class QuanLyThongKeController {
    
    private ThongKeService thongKeService = null;

    public QuanLyThongKeController() {
        thongKeService = new ThongKeServiceImpl();
    }
    
    public void setDataToChart1(JPanel jpnItem) {
        List<LopHocBean> listItem = thongKeService.getListByLopHoc();
        if (listItem != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (LopHocBean item : listItem) {
                dataset.addValue(item.getSoLuongHocVien(), "Học Viên", item.getNgayDangKy());
            }
            
            JFreeChart chart = ChartFactory.createBarChart("Số Lượng Học Viên Đăng Ký", "Thời Gian", "Số Lượng", dataset);
            
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));
            
            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
        
    }
    
    public void setDataToChart2(JPanel jpnItem) {
        List<KhoaHocBean> listItem = thongKeService.getListByKhoaHoc();
        if (listItem != null) {
            TaskSeriesCollection ds = new TaskSeriesCollection();
            
            TaskSeries taskSeries;
            Task task;
            
            for (KhoaHocBean item : listItem) {
                taskSeries = new TaskSeries(item.getTenKhoaHoc());
                task = new Task(item.getTenKhoaHoc(), item.getNgayBatDau(), item.getNgayKetThuc());
                taskSeries.add(task);
                ds.add(taskSeries);
            }
            
            JFreeChart chart = ChartFactory.createGanttChart("Thống Kê Tình Trạng Khóa Học", "Khóa Học", "Thời Gian", ds);
            
            ChartPanel chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));
            
            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(chartPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
    }
}
