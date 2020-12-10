/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.from;

import Ketnoi.KetNoi;
import QLLT.classs.piceFormatter;
import java.sql.ResultSet;
import java.time.Year;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import quanlylaptopadmin.trangchinh;

/**
 *
 * @author tytun
 */
public class thongkeok extends javax.swing.JPanel {

    /**
     * Creates new form thongkeok
     */
    Ketnoi.KetNoi cn = new KetNoi();
    DefaultTableModel model; // ban ra
    DefaultTableModel model2; //nhapvao
    DefaultTableModel model3; // chi tiet banra
    DefaultTableModel model4; // chi tiet nhapvao
    DefaultTableModel model5; //top nhanvien
    DefaultTableModel model6; //top sanpham ban
    DefaultTableModel model7; //top ncc
    DefaultTableModel model8; //top ncc nhap
    DefaultTableModel model9; //top kh nhap
    int thang;
    public thongkeok() {
        initComponents();

        String headers[] = {"Mã Hóa Đơn", "Tên Nhân Viên", "Tên Khách Hàng", "Ngày Bán", "Tổng Tiền"};
        String data[][] = null;
        model = new DefaultTableModel(data, headers);
        tblBanRa.setModel(model);

        String headers2[] = {"Mã Phiếu Nhập", "Tên Nhân Viên", "Tên Nhà Cung Cấp", "Ngày Nhập", "Tổng Tiền"};
        String data2[][] = null;
        model2 = new DefaultTableModel(data2, headers2);
        tblNhapVao.setModel(model2);

        String headers3[] = {"Mã Hóa Đơn", "Tên Sản Phẩm", "Số Lượng", "Giá Bán"};
        String data3[][] = null;
        model3 = new DefaultTableModel(data3, headers3);
        tblChiTietBan.setModel(model3);

        String headers4[] = {"Mã Phiếu Nhập", "Tên Sản Phẩm", "Số Lượng", "Giá Nhập"};
        String data4[][] = null;
        model4 = new DefaultTableModel(data4, headers4);
        tblChiTietNhap.setModel(model4);

        String headers5[] = {"Mã Nhân Viên", "Tên Nhân Viên", "Tổng Hóa Đơn", "Tổng Tiền Bán"};
        String data5[][] = null;
        model5 = new DefaultTableModel(data5, headers5);
        topnhanvien.setModel(model5);

        String headers6[] = {"Mã Sản Phẩm", "Tên Sản Phẩm", "Tổng Đã Bán"};
        String data6[][] = null;
        model6 = new DefaultTableModel(data6, headers6);
        topsanpham.setModel(model6);

        String headers7[] = {"Mã Nhà Cung Cấp", "Nhà Cung Cấp", "Tổng Phiếu Nhập", "Tổng Tiền Nhập"};
        String data7[][] = null;
        model7 = new DefaultTableModel(data7, headers7);
        topncc.setModel(model7);

        String headers8[] = {"Mã Sản Phẩm", "Tên Sản Phẩm", "Tổng Đã Nhập"};
        String data8[][] = null;
        model8 = new DefaultTableModel(data8, headers8);
        topnhap.setModel(model8);

        String headers9[] = {"Mã Khách Hàng", "Tên Khách Hàng", "Tổng Hóa Đơn", "Tổng Tiền"};
        String data9[][] = null;
        model9 = new DefaultTableModel(data9, headers9);
        topkhachhang.setModel(model9);

        try {
            String sql = "SELECT MONTH(GETDATE())";
            ResultSet rs = KetNoi.Select(sql);
            while (rs.next()) {
                thang = rs.getInt(1);
            }

        } catch (Exception e) {
        }
        
        lblTopNhanVien.setText(lblTopNhanVien.getText()+ " " + String.valueOf(thang));
        lblNhaCungCap.setText(lblNhaCungCap.getText()+ " " + String.valueOf(thang));
        lblSanPhamNhap.setText(lblSanPhamNhap.getText()+ " " + String.valueOf(thang));
        lblTopSanPhamBan.setText(lblTopSanPhamBan.getText()+ " " + String.valueOf(thang));
        
        try {
            String sql = "SELECT hoadon.makh, tenkh ,COUNT(hoadon.mahd) AS tonghoadon, SUM(tongtien) AS tongtien FROM dbo.hoadon INNER JOIN dbo.khachhang ON khachhang.makh = hoadon.makh\n"
                    + "INNER JOIN dbo.hoadonchitiet ON hoadonchitiet.mahd = hoadon.mahd\n"
                    + "GROUP BY hoadon.makh, tenkh\n"
                    + "ORDER BY tongtien DESC";
            ResultSet rs = KetNoi.Select(sql);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(piceFormatter.format(rs.getFloat(4)));
                model9.addRow(v);
            }

        } catch (Exception e) {
        }

        try {
            String sql = "SELECT masp, tensp,sum(soluong)  FROM dbo.chitietphieunhap\n"
                    + "GROUP BY masp,tensp\n"
                    + "ORDER BY sum(soluong) DESC";
            ResultSet rs = KetNoi.Select(sql);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                model8.addRow(v);
            }

        } catch (Exception e) {
        }

        try {
            String sql = "SELECT dbo.phieunhap.mancc, tenncc,COUNT(dbo.phieunhap.mancc), SUM(tongtien) AS tongtien FROM dbo.phieunhap INNER JOIN dbo.nhacungcap ON nhacungcap.mancc = phieunhap.mancc\n"
                    + "WHERE MONTH(GETDATE()) - MONTH(ngaynhap) = 0\n"
                    + "GROUP BY dbo.phieunhap.mancc,tenncc\n"
                    + "ORDER BY tongtien DESC";
            ResultSet rs = KetNoi.Select(sql);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(piceFormatter.format(rs.getFloat(4)));
                model7.addRow(v);
            }

        } catch (Exception e) {
        }

        try {
            String sql = "SELECT masp, tensp,sum(soluong) FROM dbo.hoadonchitiet\n"
                    + "GROUP BY masp,tensp\n"
                    + "ORDER BY sum(soluong) DESC";
            ResultSet rs = KetNoi.Select(sql);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                model6.addRow(v);
            }

        } catch (Exception e) {
        }

        try {
            String sql = "SELECT dbo.hoadon.manv, tennv,COUNT(dbo.hoadon.manv) , SUM(tongtien) AS tongtien  FROM dbo.hoadon INNER JOIN dbo.nhanvien ON nhanvien.manv = hoadon.manv\n"
                    + "WHERE MONTH(GETDATE()) - MONTH(ngaylap) = 0\n"
                    + "GROUP BY dbo.hoadon.manv,tennv\n"
                    + "ORDER BY tongtien DESC";
            ResultSet rs = KetNoi.Select(sql);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(piceFormatter.format(rs.getFloat(4)));
                model5.addRow(v);
            }

        } catch (Exception e) {
        }

        try {
            String sql = "SELECT mapn,tennv, tenncc, ngaynhap, tongtien FROM dbo.phieunhap INNER JOIN dbo.nhacungcap ON nhacungcap.mancc = phieunhap.mancc\n"
                    + "INNER JOIN dbo.nhanvien ON nhanvien.manv = phieunhap.manv";
            ResultSet rs = KetNoi.Select(sql);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(piceFormatter.format(rs.getFloat(5)));
                model2.addRow(v);
            }

        } catch (Exception e) {
        }

        try {
            String sql = "SELECT mahd, tennv, tenkh, ngaylap, tongtien FROM dbo.hoadon INNER JOIN dbo.nhanvien ON nhanvien.manv = hoadon.manv\n"
                    + "INNER JOIN dbo.khachhang ON khachhang.makh = hoadon.makh";
            ResultSet rs = KetNoi.Select(sql);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(piceFormatter.format(rs.getFloat(5)));
                model.addRow(v);
            }

        } catch (Exception e) {
        }

        try {
            String sql = "SELECT COUNT(masp) FROM dbo.sanpham";
            ResultSet rs = KetNoi.Select(sql);
            while (rs.next()) {
                txtSanPham.setText(String.valueOf(rs.getInt(1)));
            }
        } catch (Exception e) {
        }

        try {
            String sql = "SELECT COUNT(manv) FROM dbo.nhanvien";
            ResultSet rs = KetNoi.Select(sql);
            while (rs.next()) {
                txtNhanVien.setText(String.valueOf(rs.getInt(1)));
            }
        } catch (Exception e) {
        }

        try {
            String sql = "SELECT COUNT(makh) FROM dbo.khachhang";
            ResultSet rs = KetNoi.Select(sql);
            while (rs.next()) {
                txtKhachHang.setText(String.valueOf(rs.getInt(1)));
            }
        } catch (Exception e) {
        }

        try {
            String sql = "SELECT COUNT(mancc) FROM dbo.nhacungcap";
            ResultSet rs = KetNoi.Select(sql);
            while (rs.next()) {
                txtNhaCungCap.setText(String.valueOf(rs.getInt(1)));
            }
        } catch (Exception e) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSanPham = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtNhanVien = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtKhachHang = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNhaCungCap = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jDesktopPane4 = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBanRa = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiTietBan = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jDesktopPane5 = new javax.swing.JDesktopPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNhapVao = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblChiTietNhap = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        topsanpham = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        topncc = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        topnhap = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        topnhanvien = new javax.swing.JTable();
        lblTopSanPhamBan = new javax.swing.JLabel();
        lblTopNhanVien = new javax.swing.JLabel();
        lblNhaCungCap = new javax.swing.JLabel();
        lblSanPhamNhap = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        topkhachhang = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();

        jDesktopPane1.setBackground(new java.awt.Color(240, 240, 240));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Thống Kê Tổng Quát");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Sản Phẩm");

        txtSanPham.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtSanPham.setText("0");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Monitor.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(txtSanPham))
                    .addComponent(jLabel1))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtSanPham))
                .addGap(40, 40, 40))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Nhân Viên");

        txtNhanVien.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtNhanVien.setText("0");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(txtNhanVien))
                    .addComponent(jLabel8))
                .addGap(31, 31, 31))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtNhanVien))
                .addGap(41, 41, 41))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Khách Hàng");

        txtKhachHang.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtKhachHang.setText("0");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Friends.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(txtKhachHang))
                    .addComponent(jLabel3))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(txtKhachHang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Nhà Cung Cấp");

        txtNhaCungCap.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtNhaCungCap.setText("0");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_company_30px.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNhaCungCap)
                        .addGap(28, 28, 28))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(txtNhaCungCap))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jDesktopPane4.setBackground(new java.awt.Color(240, 240, 240));

        tblBanRa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tblBanRa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBanRaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBanRa);

        tblChiTietBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblChiTietBan);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Chi Tiết Bán Ra");

        jDesktopPane4.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane4.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane4Layout = new javax.swing.GroupLayout(jDesktopPane4);
        jDesktopPane4.setLayout(jDesktopPane4Layout);
        jDesktopPane4Layout.setHorizontalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addGap(446, 446, 446)
                .addComponent(jLabel6)
                .addContainerGap(469, Short.MAX_VALUE))
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jDesktopPane4Layout.setVerticalGroup(
            jDesktopPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(2, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Bán Ra", jDesktopPane4);

        jDesktopPane5.setBackground(new java.awt.Color(240, 240, 240));

        tblNhapVao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tblNhapVao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhapVaoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblNhapVao);

        tblChiTietNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblChiTietNhap);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Chi Tiết Nhập Vào");

        jDesktopPane5.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane5.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane5Layout = new javax.swing.GroupLayout(jDesktopPane5);
        jDesktopPane5.setLayout(jDesktopPane5Layout);
        jDesktopPane5Layout.setHorizontalGroup(
            jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jDesktopPane5Layout.createSequentialGroup()
                .addGap(446, 446, 446)
                .addComponent(jLabel7)
                .addContainerGap(450, Short.MAX_VALUE))
        );
        jDesktopPane5Layout.setVerticalGroup(
            jDesktopPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane5.addTab("Nhập Vào", jDesktopPane5);

        jDesktopPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jTabbedPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(395, 395, 395)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane5)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(23, 23, 23)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tổng Quát", jDesktopPane1);

        jDesktopPane2.setBackground(new java.awt.Color(240, 240, 240));

        topsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(topsanpham);

        topncc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(topncc);

        topnhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(topnhap);

        topnhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(topnhanvien);

        lblTopSanPhamBan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTopSanPhamBan.setText("TOP Sản Phẩm Bán Chạy Trong Tháng");

        lblTopNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTopNhanVien.setText("TOP Nhân Viên Bán Được Tổng Tiền Trong Tháng");

        lblNhaCungCap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNhaCungCap.setText("TOP Nhà Cung Cấp Nhập Nhiều Trong Tháng");

        lblSanPhamNhap.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSanPhamNhap.setText("TOP Sản Phẩm Nhập Nhiều Trong Tháng");

        topkhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(topkhachhang);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("TOP Khách Hàng Mua Nhiều Nhất");

        jDesktopPane2.setLayer(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jScrollPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jScrollPane7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jScrollPane8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(lblTopSanPhamBan, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(lblTopNhanVien, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(lblNhaCungCap, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(lblSanPhamNhap, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jScrollPane9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(lblTopNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 177, Short.MAX_VALUE)
                .addComponent(lblTopSanPhamBan)
                .addGap(142, 142, 142))
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(88, 88, 88)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(lblNhaCungCap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSanPhamNhap)
                        .addGap(114, 114, 114))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(272, 272, 272))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(373, 373, 373))))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTopSanPhamBan)
                    .addComponent(lblTopNhanVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSanPhamNhap)
                    .addComponent(lblNhaCungCap))
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Xếp Loại", jDesktopPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblBanRaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBanRaMouseClicked
        // TODO add your handling code here:
        int index = tblBanRa.getSelectedRow();
        String mahoadon = tblBanRa.getValueAt(index, 0).toString();

        try {
            String sql = "SELECT hoadon.mahd,tensp,soluong,dongia,tongtien FROM dbo.hoadon JOIN dbo.hoadonchitiet ON hoadonchitiet.mahd = hoadon.mahd\n"
                    + "where hoadon.mahd = N'" + mahoadon + "'";
            ResultSet rs = KetNoi.Select(sql);
            Vector v = null;
            model3.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(piceFormatter.format(rs.getFloat(4)));

                model3.addRow(v);

            }
            tblChiTietBan.setModel(model3);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblBanRaMouseClicked

    private void tblNhapVaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhapVaoMouseClicked
        // TODO add your handling code here:
        int index = tblNhapVao.getSelectedRow();
        String mapn = tblNhapVao.getValueAt(index, 0).toString();

        try {
            String sql = "SELECT chitietphieunhap.mapn,tensp,soluong,dongia FROM dbo.phieunhap JOIN dbo.chitietphieunhap ON chitietphieunhap.mapn = phieunhap.mapn\n"
                    + "where chitietphieunhap.mapn = N'" + mapn + "'";
            ResultSet rs = KetNoi.Select(sql);
            Vector v = null;
            model4.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));

                v.add(piceFormatter.format(rs.getFloat(4)));

                model4.addRow(v);

            }
            tblChiTietNhap.setModel(model4);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblNhapVaoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JDesktopPane jDesktopPane4;
    private javax.swing.JDesktopPane jDesktopPane5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JLabel lblNhaCungCap;
    private javax.swing.JLabel lblSanPhamNhap;
    private javax.swing.JLabel lblTopNhanVien;
    private javax.swing.JLabel lblTopSanPhamBan;
    private javax.swing.JTable tblBanRa;
    private javax.swing.JTable tblChiTietBan;
    private javax.swing.JTable tblChiTietNhap;
    private javax.swing.JTable tblNhapVao;
    private javax.swing.JTable topkhachhang;
    private javax.swing.JTable topncc;
    private javax.swing.JTable topnhanvien;
    private javax.swing.JTable topnhap;
    private javax.swing.JTable topsanpham;
    private javax.swing.JLabel txtKhachHang;
    private javax.swing.JLabel txtNhaCungCap;
    private javax.swing.JLabel txtNhanVien;
    private javax.swing.JLabel txtSanPham;
    // End of variables declaration//GEN-END:variables
}
