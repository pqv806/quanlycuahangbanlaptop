/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.classs;

import QLLT.from.nhom5;
import QLLT.from.banhang;
import QLLT.from.baohanh;
import QLLT.from.hoadon;
import QLLT.from.khachhang;


import QLLT.from.nhacungcap;
import QLLT.from.nhaphang;
//import QLLT.from.phieunhap;
//import QLLT.from.quyen;
//import QLLT.from.sanpham;
//import QLLT.from.sanpham;
import QLLT.from.sanpham1;
import QLLT.from.taikhoan;
import QLLT.from.thongke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author vinh
 */
public class chuyenmanhinh {

    private JPanel root;
    private String kindselected = "";
    private List<danhmuc> listitem = null;

    public chuyenmanhinh(JPanel jpnroot) {
        this.root = jpnroot;
    }

    public void setview(JPanel jpnItem, JLabel jlbItem) {
        kindselected = "nhóm 5";
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new nhom5());
        root.validate();
        root.repaint();

    }

    public void seteven(List<danhmuc> listitem) {
        this.listitem = listitem;
        for (danhmuc item : listitem) {
            item.getJlb().addMouseListener(new labelevent(item.getKind(), item.getJpn(), item.getJlb()));
        }

    }

    class labelevent implements MouseListener {

        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jblItem;

        public labelevent( String kind, JPanel jpnItem, JLabel jblItem) {
            
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jblItem = jblItem;
        }

        

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                    case "nhom 5":
                        node = new nhom5();
                        break;
                        case "bán hàng":
                            node = new banhang();
                            break;
                             case "nhập hàng":
                            node = new nhaphang();
                            break;
                             case "sản phẩm":
                            node = new sanpham1();
                            break;
                             case "loại sản phẩm":
                     
                            break;
                             case "hóa đơn":
                            node = new hoadon();
                            break;
                             case "phiếu nhập":
//                            node = new phieunhap();
                            break;
                             case "nhân viên":
                        node = new QLLT.from.nhanvien();
                            break;
                             case "khách hàng":
                            node = new khachhang();
                            break;
                             case "NCC":
                            node = new nhacungcap();
                            break;
                             case "tài khoản":
                            node = new taikhoan();
                            break;
                             case "quyền":
//                            node = new quyen();
                            break;
                             case "thống kê":
                            node = new thongke();
                            break;
                             case "bảo hành":
                            node = new baohanh();
                            break;
                            
                            default:
                                break;
               

            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setbackgroud(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindselected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jblItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jblItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindselected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(76, 175, 80));
                jblItem.setBackground(new Color(76, 175, 80));
            }
        }

    }

    private void setbackgroud(String kind) {
        for (danhmuc item : listitem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(96, 100, 191));
                item.getJlb().setBackground(new Color(96, 100, 191));
            } else {
                item.getJpn().setBackground(new Color(76, 175, 80));
                item.getJlb().setBackground(new Color(76, 175, 80));
            }
        }
    }
}
