package com.quanlyhocvien.controller;

import com.quanlyhocvien.bean.DanhMucBean;
import com.quanlyhocvien.view.HocVienPanel;
import com.quanlyhocvien.view.KhoaHocPanel;
import com.quanlyhocvien.view.LopHocPanel;
import com.quanlyhocvien.view.ThongKePanel;
import com.quanlyhocvien.view.TrangChuPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ChangeViewController {
    
    private JPanel root;
    private String kindSelected = "";
    
    private List<DanhMucBean> listItem = null;

    public ChangeViewController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "TrangChu";
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));
        
        
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuPanel());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DanhMucBean> listItem) {
        this.listItem = listItem;
        
        for(DanhMucBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    
    class LabelEvent implements MouseListener {
        
        private JPanel node;
        private String kind;
        
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        

        @Override
        public void mouseClicked(MouseEvent e) {
            switch(kind) {
                case "TrangChu":
                    node = new TrangChuPanel();
                    break;
                case "HocVien":
                    node = new HocVienPanel();
                    break;
                case "KhoaHoc":
                    node = new KhoaHocPanel();
                    break;
                case "LopHoc":
                    node = new LopHocPanel();
                    break;
                case "ThongKe":
                    node = new ThongKePanel();
                    break;
                    
                default: 
                    node = new TrangChuPanel();
                    break;
            }
            
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackGround(kind);
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(102, 255 ,255));
                jlbItem.setBackground(new Color(102, 255 ,255));
            }
        }
        
    }
    
    private void setChangeBackGround(String kind) {
        for(DanhMucBean item : listItem) {
            if(item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(96, 100, 191));
                item.getJlb().setBackground(new Color(96, 100, 191));
            }
            else {
                item.getJpn().setBackground(new Color(102, 255 ,255));
                item.getJlb().setBackground(new Color(102, 255 ,255));
            }
        }
    }
}
