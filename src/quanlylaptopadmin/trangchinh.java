/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlylaptopadmin;

import QLLT.classs.danhmuc;
import QLLT.classs.chuyenmanhinh;
import QLLT.from.login;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vinh
 */
public class trangchinh extends javax.swing.JFrame {

    /**
     * Creates new form trangchinh
     */
    public trangchinh() {
        initComponents();
        setLocationRelativeTo(null);

       
       
        List<danhmuc> listItem = new ArrayList<>();
        listItem.add(new danhmuc("nhom 5", jpnnhom5, jlbnhom5));
        listItem.add(new danhmuc("bán hàng", jpnbanhang, jlpbanhang));
        listItem.add(new danhmuc("nhập hàng", jpnnhaphang, jlpnhaphang));
        listItem.add(new danhmuc("sản phẩm", jpnsanpham, jlpsanpham));
        listItem.add(new danhmuc("hóa đơn", jpnhoadon, jlphoadon));
        listItem.add(new danhmuc("nhân viên", jpnnhanvien, jlpnhanvien));
        listItem.add(new danhmuc("khách hàng", jpnkhachhang, jlpkhachhang));
        listItem.add(new danhmuc("NCC", jpnNCC, jlpNCC));
        listItem.add(new danhmuc("tài khoản", jpnTK, jlpTK));
        listItem.add(new danhmuc("thống kê", jpnthongke, jlpthongke));
        listItem.add(new danhmuc("bảo hành", jpnbaohanh, jlpbaohanh));
        chuyenmanhinh cmh = new chuyenmanhinh(jpnview);
        cmh.setview(jpnnhom5, jlbnhom5);
        cmh.seteven(listItem);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnroot = new javax.swing.JPanel();
        jpnview = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jpnmenu = new javax.swing.JPanel();
        jpnnhom5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlbnhom5 = new javax.swing.JLabel();
        jpnbanhang = new javax.swing.JPanel();
        jlpbanhang = new javax.swing.JLabel();
        jpnnhaphang = new javax.swing.JPanel();
        jlpnhaphang = new javax.swing.JLabel();
        jpnsanpham = new javax.swing.JPanel();
        jlpsanpham = new javax.swing.JLabel();
        jpnhoadon = new javax.swing.JPanel();
        jlphoadon = new javax.swing.JLabel();
        jpnnhanvien = new javax.swing.JPanel();
        jlpnhanvien = new javax.swing.JLabel();
        jpnkhachhang = new javax.swing.JPanel();
        jlpkhachhang = new javax.swing.JLabel();
        jpnNCC = new javax.swing.JPanel();
        jlpNCC = new javax.swing.JLabel();
        jpnTK = new javax.swing.JPanel();
        jlpTK = new javax.swing.JLabel();
        jpnthongke = new javax.swing.JPanel();
        jlpthongke = new javax.swing.JLabel();
        jpnbaohanh = new javax.swing.JPanel();
        jlpbaohanh = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cửa Hàng Bán LAPTOP");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new java.awt.CardLayout());

        jpnview.setPreferredSize(new java.awt.Dimension(900, 0));

        javax.swing.GroupLayout jpnviewLayout = new javax.swing.GroupLayout(jpnview);
        jpnview.setLayout(jpnviewLayout);
        jpnviewLayout.setHorizontalGroup(
            jpnviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1052, Short.MAX_VALUE)
        );
        jpnviewLayout.setVerticalGroup(
            jpnviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jpnmenu.setBackground(new java.awt.Color(102, 102, 102));

        jpnnhom5.setBackground(new java.awt.Color(255, 51, 51));
        jpnnhom5.setPreferredSize(new java.awt.Dimension(150, 50));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_shutdown_30px_1.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jlbnhom5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbnhom5.setForeground(new java.awt.Color(255, 255, 255));
        jlbnhom5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbnhom5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fpt.png"))); // NOI18N
        jlbnhom5.setText("Nhóm 2");

        javax.swing.GroupLayout jpnnhom5Layout = new javax.swing.GroupLayout(jpnnhom5);
        jpnnhom5.setLayout(jpnnhom5Layout);
        jpnnhom5Layout.setHorizontalGroup(
            jpnnhom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnnhom5Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbnhom5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnnhom5Layout.setVerticalGroup(
            jpnnhom5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(jlbnhom5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpnbanhang.setBackground(new java.awt.Color(0, 153, 51));
        jpnbanhang.setPreferredSize(new java.awt.Dimension(150, 50));

        jlpbanhang.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlpbanhang.setForeground(new java.awt.Color(255, 255, 255));
        jlpbanhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlpbanhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_small_business_30px_3.png"))); // NOI18N
        jlpbanhang.setText("Bán Hàng");

        javax.swing.GroupLayout jpnbanhangLayout = new javax.swing.GroupLayout(jpnbanhang);
        jpnbanhang.setLayout(jpnbanhangLayout);
        jpnbanhangLayout.setHorizontalGroup(
            jpnbanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlpbanhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnbanhangLayout.setVerticalGroup(
            jpnbanhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnbanhangLayout.createSequentialGroup()
                .addComponent(jlpbanhang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpnnhaphang.setBackground(new java.awt.Color(0, 153, 51));
        jpnnhaphang.setPreferredSize(new java.awt.Dimension(150, 50));

        jlpnhaphang.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlpnhaphang.setForeground(new java.awt.Color(255, 255, 255));
        jlpnhaphang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlpnhaphang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add to basket.png"))); // NOI18N
        jlpnhaphang.setText("Nhập Hàng");

        javax.swing.GroupLayout jpnnhaphangLayout = new javax.swing.GroupLayout(jpnnhaphang);
        jpnnhaphang.setLayout(jpnnhaphangLayout);
        jpnnhaphangLayout.setHorizontalGroup(
            jpnnhaphangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlpnhaphang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnnhaphangLayout.setVerticalGroup(
            jpnnhaphangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlpnhaphang, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jpnsanpham.setBackground(new java.awt.Color(0, 153, 51));
        jpnsanpham.setPreferredSize(new java.awt.Dimension(150, 50));

        jlpsanpham.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlpsanpham.setForeground(new java.awt.Color(255, 255, 255));
        jlpsanpham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlpsanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Computer.png"))); // NOI18N
        jlpsanpham.setText("Sản Phẩm");

        javax.swing.GroupLayout jpnsanphamLayout = new javax.swing.GroupLayout(jpnsanpham);
        jpnsanpham.setLayout(jpnsanphamLayout);
        jpnsanphamLayout.setHorizontalGroup(
            jpnsanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlpsanpham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnsanphamLayout.setVerticalGroup(
            jpnsanphamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnsanphamLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlpsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpnhoadon.setBackground(new java.awt.Color(0, 153, 51));
        jpnhoadon.setPreferredSize(new java.awt.Dimension(150, 50));

        jlphoadon.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlphoadon.setForeground(new java.awt.Color(255, 255, 255));
        jlphoadon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlphoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_agreement_30px.png"))); // NOI18N
        jlphoadon.setText("Hóa Đơn");

        javax.swing.GroupLayout jpnhoadonLayout = new javax.swing.GroupLayout(jpnhoadon);
        jpnhoadon.setLayout(jpnhoadonLayout);
        jpnhoadonLayout.setHorizontalGroup(
            jpnhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlphoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnhoadonLayout.setVerticalGroup(
            jpnhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlphoadon, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jpnnhanvien.setBackground(new java.awt.Color(0, 153, 51));
        jpnnhanvien.setPreferredSize(new java.awt.Dimension(150, 50));

        jlpnhanvien.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlpnhanvien.setForeground(new java.awt.Color(255, 255, 255));
        jlpnhanvien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlpnhanvien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_assistant_30px.png"))); // NOI18N
        jlpnhanvien.setText("Nhân Viên");

        javax.swing.GroupLayout jpnnhanvienLayout = new javax.swing.GroupLayout(jpnnhanvien);
        jpnnhanvien.setLayout(jpnnhanvienLayout);
        jpnnhanvienLayout.setHorizontalGroup(
            jpnnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlpnhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
        jpnnhanvienLayout.setVerticalGroup(
            jpnnhanvienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnnhanvienLayout.createSequentialGroup()
                .addComponent(jlpnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpnkhachhang.setBackground(new java.awt.Color(0, 153, 51));
        jpnkhachhang.setPreferredSize(new java.awt.Dimension(150, 50));

        jlpkhachhang.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlpkhachhang.setForeground(new java.awt.Color(255, 255, 255));
        jlpkhachhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlpkhachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_user_30px.png"))); // NOI18N
        jlpkhachhang.setText("Khách Hàng");

        javax.swing.GroupLayout jpnkhachhangLayout = new javax.swing.GroupLayout(jpnkhachhang);
        jpnkhachhang.setLayout(jpnkhachhangLayout);
        jpnkhachhangLayout.setHorizontalGroup(
            jpnkhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlpkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnkhachhangLayout.setVerticalGroup(
            jpnkhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlpkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jpnNCC.setBackground(new java.awt.Color(0, 153, 51));
        jpnNCC.setPreferredSize(new java.awt.Dimension(150, 50));

        jlpNCC.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlpNCC.setForeground(new java.awt.Color(255, 255, 255));
        jlpNCC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlpNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_company_30px.png"))); // NOI18N
        jlpNCC.setText("Nhà Cung Cấp");

        javax.swing.GroupLayout jpnNCCLayout = new javax.swing.GroupLayout(jpnNCC);
        jpnNCC.setLayout(jpnNCCLayout);
        jpnNCCLayout.setHorizontalGroup(
            jpnNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlpNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnNCCLayout.setVerticalGroup(
            jpnNCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnNCCLayout.createSequentialGroup()
                .addComponent(jlpNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jpnTK.setBackground(new java.awt.Color(0, 153, 51));
        jpnTK.setPreferredSize(new java.awt.Dimension(150, 50));

        jlpTK.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlpTK.setForeground(new java.awt.Color(255, 255, 255));
        jlpTK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlpTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_key_30px.png"))); // NOI18N
        jlpTK.setText("Tài Khoản");

        javax.swing.GroupLayout jpnTKLayout = new javax.swing.GroupLayout(jpnTK);
        jpnTK.setLayout(jpnTKLayout);
        jpnTKLayout.setHorizontalGroup(
            jpnTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlpTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnTKLayout.setVerticalGroup(
            jpnTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlpTK, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jpnthongke.setBackground(new java.awt.Color(0, 153, 51));
        jpnthongke.setPreferredSize(new java.awt.Dimension(150, 50));

        jlpthongke.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlpthongke.setForeground(new java.awt.Color(255, 255, 255));
        jlpthongke.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlpthongke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_bar_chart_30px.png"))); // NOI18N
        jlpthongke.setText("Thống Kê");

        javax.swing.GroupLayout jpnthongkeLayout = new javax.swing.GroupLayout(jpnthongke);
        jpnthongke.setLayout(jpnthongkeLayout);
        jpnthongkeLayout.setHorizontalGroup(
            jpnthongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlpthongke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnthongkeLayout.setVerticalGroup(
            jpnthongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnthongkeLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlpthongke, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpnbaohanh.setBackground(new java.awt.Color(0, 153, 51));
        jpnbaohanh.setPreferredSize(new java.awt.Dimension(150, 50));

        jlpbaohanh.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlpbaohanh.setForeground(new java.awt.Color(255, 255, 255));
        jlpbaohanh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlpbaohanh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_support_30px.png"))); // NOI18N
        jlpbaohanh.setText("Đổi Trả");

        javax.swing.GroupLayout jpnbaohanhLayout = new javax.swing.GroupLayout(jpnbaohanh);
        jpnbaohanh.setLayout(jpnbaohanhLayout);
        jpnbaohanhLayout.setHorizontalGroup(
            jpnbaohanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlpbaohanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpnbaohanhLayout.setVerticalGroup(
            jpnbaohanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlpbaohanh, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnmenuLayout = new javax.swing.GroupLayout(jpnmenu);
        jpnmenu.setLayout(jpnmenuLayout);
        jpnmenuLayout.setHorizontalGroup(
            jpnmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnmenuLayout.createSequentialGroup()
                .addGroup(jpnmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnthongke, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jpnNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jpnkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jpnnhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jpnhoadon, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jpnnhaphang, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jpnbanhang, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jpnnhom5, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jpnbaohanh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jpnsanpham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jpnTK, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addContainerGap(158, Short.MAX_VALUE))
        );
        jpnmenuLayout.setVerticalGroup(
            jpnmenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnmenuLayout.createSequentialGroup()
                .addComponent(jpnnhom5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnbanhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnnhaphang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnnhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jpnthongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jpnbaohanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jpnmenu);

        javax.swing.GroupLayout jpnrootLayout = new javax.swing.GroupLayout(jpnroot);
        jpnroot.setLayout(jpnrootLayout);
        jpnrootLayout.setHorizontalGroup(
            jpnrootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnrootLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnview, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE))
        );
        jpnrootLayout.setVerticalGroup(
            jpnrootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnrootLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jpnrootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnview, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)))
        );

        getContentPane().add(jpnroot, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        int hoi = JOptionPane.showConfirmDialog(this, "bạn có muốn đăng xuất");

        if (hoi == JOptionPane.YES_OPTION) {
            new login().setVisible(true);
            dispose();
        } else {

        }
    }//GEN-LAST:event_jLabel1MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlbnhom5;
    private javax.swing.JLabel jlpNCC;
    private javax.swing.JLabel jlpTK;
    private javax.swing.JLabel jlpbanhang;
    private javax.swing.JLabel jlpbaohanh;
    private javax.swing.JLabel jlphoadon;
    private javax.swing.JLabel jlpkhachhang;
    private javax.swing.JLabel jlpnhanvien;
    private javax.swing.JLabel jlpnhaphang;
    private javax.swing.JLabel jlpsanpham;
    private javax.swing.JLabel jlpthongke;
    private javax.swing.JPanel jpnNCC;
    private javax.swing.JPanel jpnTK;
    private javax.swing.JPanel jpnbanhang;
    private javax.swing.JPanel jpnbaohanh;
    private javax.swing.JPanel jpnhoadon;
    private javax.swing.JPanel jpnkhachhang;
    private javax.swing.JPanel jpnmenu;
    private javax.swing.JPanel jpnnhanvien;
    private javax.swing.JPanel jpnnhaphang;
    private javax.swing.JPanel jpnnhom5;
    private javax.swing.JPanel jpnroot;
    private javax.swing.JPanel jpnsanpham;
    private javax.swing.JPanel jpnthongke;
    private javax.swing.JPanel jpnview;
    // End of variables declaration//GEN-END:variables
}
