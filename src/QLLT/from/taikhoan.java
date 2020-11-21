/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.from;

import Ketnoi.KetNoi;
import QLLT.DAO.DAO_Quyen;
import QLLT.DAO.DAO_TK;
import QLLT.classs.QLTK;
import QLLT.classs.QLquyen;
import QLLT.from.fromcon.suaTK;
import QLLT.from.fromcon.suaquyen;
import QLLT.from.fromcon.themTK;
import QLLT.from.fromcon.themquyen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinh
 */
public class taikhoan extends javax.swing.JPanel {

    DefaultTableModel model;
    public static String ma,ten,tenq, mk, manv, mq,chitiet;
    Ketnoi.KetNoi cn = new KetNoi();
    QLTK n = new QLTK();
    QLquyen m = new QLquyen();
    long count, sotrang, trang = 1;

    /**
     * Creates new form taikhoan
     */
    public taikhoan() {
        initComponents();
        laysodong();
        if (count % 5 == 0) {
            sotrang = count / 5;
        } else {
            sotrang = count / 5 + 1;
        }
        DAO_TK.dolentable(tbltk, 1);
        
        lbltrang.setText("1");
        lblsotrang.setText("1/" + sotrang);

        jButton3.setEnabled(false);
        jButton1.setEnabled(false);
      

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
        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txttim = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltk = new javax.swing.JTable();
        nextlui1tk = new javax.swing.JButton();
        nextvetk = new javax.swing.JButton();
        lbltrang = new javax.swing.JLabel();
        nexttien1tk = new javax.swing.JButton();
        nexttientk = new javax.swing.JButton();
        lblsotrang = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        txttim1 = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblquyen = new javax.swing.JTable();
        nextphanquyen = new javax.swing.JButton();
        next1phanquyen = new javax.swing.JButton();
        lbltrang1 = new javax.swing.JLabel();
        nexttienphanquyen1 = new javax.swing.JButton();
        nexttienphanquyen = new javax.swing.JButton();
        lblsotrang1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jTabbedPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPane1ComponentShown(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jDesktopPane1.setBackground(new java.awt.Color(240, 240, 240));
        jDesktopPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jDesktopPane1ComponentShown(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        jButton3.setText("sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        jButton1.setText("xóa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        jButton2.setText("thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txttim.setBorder(javax.swing.BorderFactory.createTitledBorder("tìm kiếm"));
        txttim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimActionPerformed(evt);
            }
        });
        txttim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttimKeyReleased(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_replay_30px.png"))); // NOI18N
        jButton7.setText("làm mới");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        tbltk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "tên tài khoản", "mật khẩu", "mã nhân viên", "mã quyền"
            }
        ));
        tbltk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbltkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbltk);

        nextlui1tk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/107816534_335383491191669_6858896409213148801_n.png"))); // NOI18N
        nextlui1tk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextlui1tkActionPerformed(evt);
            }
        });

        nextvetk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/109458344_606525943604283_1735448384254130874_n.png"))); // NOI18N
        nextvetk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextvetkActionPerformed(evt);
            }
        });

        lbltrang.setText("jLabel1");

        nexttien1tk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/108190622_330299054646593_925802538658998860_n.png"))); // NOI18N
        nexttien1tk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nexttien1tkActionPerformed(evt);
            }
        });

        nexttientk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/107792122_206608630685120_4490402718207329408_n (1).png"))); // NOI18N
        nexttientk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nexttientkActionPerformed(evt);
            }
        });

        lblsotrang.setText("jLabel2");

        jDesktopPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(txttim, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(nextlui1tk, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(nextvetk, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbltrang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(nexttien1tk, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(nexttientk, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lblsotrang, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(nextvetk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextlui1tk)
                                .addGap(18, 18, 18)
                                .addComponent(lbltrang)
                                .addGap(18, 18, 18)
                                .addComponent(nexttien1tk)
                                .addGap(18, 18, 18)
                                .addComponent(nexttientk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblsotrang))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(65, 65, 65)
                                        .addComponent(jButton1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                                        .addComponent(txttim, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)))
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                        .addGap(69, 69, 69)
                                        .addComponent(jButton3))
                                    .addComponent(jButton7))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(20, 20, 20)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttim, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblsotrang)
                            .addComponent(lbltrang)))
                    .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nextvetk, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nextlui1tk, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nexttien1tk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nexttientk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        jPanel1.add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Tài Khoản", jPanel1);

        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });
        jPanel2.setLayout(new java.awt.CardLayout());

        jDesktopPane2.setBackground(new java.awt.Color(240, 240, 240));
        jDesktopPane2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jDesktopPane2ComponentShown(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit.png"))); // NOI18N
        jButton5.setText("sửa");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        jButton6.setText("xóa");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        jButton8.setText("thêm");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        txttim1.setBorder(javax.swing.BorderFactory.createTitledBorder("tìm kiếm"));
        txttim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttim1ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_replay_30px.png"))); // NOI18N
        jButton10.setText("làm mới");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        tblquyen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "mã quyền", "tên quyền", "chi tiết quyền"
            }
        ));
        tblquyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblquyenMouseClicked(evt);
            }
        });
        tblquyen.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tblquyenComponentShown(evt);
            }
        });
        jScrollPane2.setViewportView(tblquyen);

        nextphanquyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/109458344_606525943604283_1735448384254130874_n.png"))); // NOI18N
        nextphanquyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextphanquyenActionPerformed(evt);
            }
        });

        next1phanquyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/107816534_335383491191669_6858896409213148801_n.png"))); // NOI18N
        next1phanquyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                next1phanquyenActionPerformed(evt);
            }
        });

        lbltrang1.setText("jLabel1");

        nexttienphanquyen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/108190622_330299054646593_925802538658998860_n.png"))); // NOI18N
        nexttienphanquyen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nexttienphanquyen1ActionPerformed(evt);
            }
        });

        nexttienphanquyen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/107792122_206608630685120_4490402718207329408_n (1).png"))); // NOI18N
        nexttienphanquyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nexttienphanquyenActionPerformed(evt);
            }
        });

        lblsotrang1.setText("jLabel2");

        jDesktopPane2.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jButton8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(txttim1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jButton10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(nextphanquyen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(next1phanquyen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(lbltrang1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(nexttienphanquyen1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(nexttienphanquyen, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(lblsotrang1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane2Layout = new javax.swing.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE))
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txttim1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                .addComponent(jButton8)
                                .addGap(52, 52, 52)
                                .addComponent(jButton6)))
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jButton10))
                            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jButton5)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(nextphanquyen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(next1phanquyen)
                .addGap(18, 18, 18)
                .addComponent(lbltrang1)
                .addGap(18, 18, 18)
                .addComponent(nexttienphanquyen1)
                .addGap(18, 18, 18)
                .addComponent(nexttienphanquyen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblsotrang1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton8))
                .addGap(26, 26, 26)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttim1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblsotrang1)
                            .addComponent(lbltrang1)))
                    .addGroup(jDesktopPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nextphanquyen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(next1phanquyen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nexttienphanquyen1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nexttienphanquyen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        jPanel2.add(jDesktopPane2, "card2");

        jTabbedPane1.addTab("Phân Quyền", jPanel2);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        suaTK slsp = new suaTK();
        jDesktopPane1.add(slsp);
        slsp.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        themDL();

        int hoi = JOptionPane.showConfirmDialog(this, "xóa tài khoản");
        if (hoi == JOptionPane.YES_OPTION) {
            DAO_TK.Delete(n);
            DAO_TK.dolentable(tbltk, trang);

            JOptionPane.showMessageDialog(this, "xóa thành công");

        } else {
            JOptionPane.showMessageDialog(this, "chưa xóa");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        themTK tlsp = new themTK();
        jDesktopPane1.add(tlsp);
        tlsp.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txttimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        txttim.setText("");
        DAO_TK.dolentable(tbltk, trang);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tbltkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltkMouseClicked

        int row = tbltk.getSelectedRow();
        ten = tbltk.getValueAt(row, 0).toString();
        mk = tbltk.getValueAt(row, 1).toString();

        manv = tbltk.getValueAt(row, 2).toString();
        mq = tbltk.getValueAt(row, 3).toString();
        jButton3.setEnabled(true);
        jButton1.setEnabled(true);
        jButton3.setEnabled(true);
    }//GEN-LAST:event_tbltkMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        suaquyen slsp = new suaquyen();
        jDesktopPane2.add(slsp);
        slsp.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       themDL();
        DAO_Quyen.Delete(m);
        DAO_Quyen.dolentable(tblquyen, trang);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        themquyen tlsp = new themquyen();
        jDesktopPane2.add(tlsp);
        tlsp.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txttim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttim1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttim1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
//        model.setRowCount(0);
//        txttim.setText("");
//        loaddatatable();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void tblquyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblquyenMouseClicked

        int row = tblquyen.getSelectedRow();
        mq = tblquyen.getValueAt(row, 0).toString();
        tenq = tblquyen.getValueAt(row, 1).toString();

       chitiet  = tblquyen.getValueAt(row, 2).toString();

        jButton6.setEnabled(true);
        jButton5.setEnabled(true);
    }//GEN-LAST:event_tblquyenMouseClicked

    private void nextlui1tkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextlui1tkActionPerformed
        // TODO add your handling code here:
        if (trang > 1) {
            trang--;
           DAO_TK.dolentable(tbltk, trang);
            lblsotrang.setText(trang + "/" + sotrang);
            lbltrang.setText("" + trang);
        }
    }//GEN-LAST:event_nextlui1tkActionPerformed

    private void nextvetkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextvetkActionPerformed
        // TODO add your handling code here:
        trang = 1;

      DAO_TK.dolentable(tbltk, trang);
        lblsotrang.setText(trang + "/" + sotrang);
        lbltrang.setText("" + trang);

    }//GEN-LAST:event_nextvetkActionPerformed

    private void nexttien1tkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nexttien1tkActionPerformed
        // TODO add your handling code here:
        if (trang < sotrang) {
            trang++;
            DAO_TK.dolentable(tbltk, trang);
            lblsotrang.setText(trang + "/" + sotrang);
            lbltrang.setText("" + trang);
        }
    }//GEN-LAST:event_nexttien1tkActionPerformed

    private void nexttientkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nexttientkActionPerformed
        // TODO add your handling code here:
        trang = sotrang;

        DAO_TK.dolentable(tbltk, trang);
        lblsotrang.setText(trang + "/" + sotrang);
        lbltrang.setText("" + trang);

    }//GEN-LAST:event_nexttientkActionPerformed

    private void txttimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimKeyReleased
        // TODO add your handling code here:
        themDL();
        try {
            DAO_TK.TimKiemnhanvien(n, tbltk);
        } catch (SQLException ex) {
            Logger.getLogger(taikhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txttimKeyReleased

    private void jDesktopPane2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jDesktopPane2ComponentShown
        // TODO add your handling code here:
    
  
    }//GEN-LAST:event_jDesktopPane2ComponentShown

    private void tblquyenComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblquyenComponentShown
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tblquyenComponentShown

    private void nextphanquyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextphanquyenActionPerformed
        // TODO add your handling code here:
         trang = 1;

        DAO_Quyen.dolentable(tblquyen, trang);
        lblsotrang1.setText(trang + "/" + sotrang);
        lbltrang1.setText("" + trang);
    }//GEN-LAST:event_nextphanquyenActionPerformed

    private void next1phanquyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_next1phanquyenActionPerformed
        // TODO add your handling code here:
        if (trang > 1) {
            trang--;
            DAO_TK.dolentable(tblquyen, trang);
            lblsotrang1.setText(trang + "/" + sotrang);
            lbltrang1.setText("" + trang);
        }
    }//GEN-LAST:event_next1phanquyenActionPerformed

    private void nexttienphanquyen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nexttienphanquyen1ActionPerformed
        // TODO add your handling code here:
         if (trang < sotrang) {
            trang++;
            DAO_TK.dolentable(tblquyen, trang);
            lblsotrang1.setText(trang + "/" + sotrang);
            lbltrang1.setText("" + trang);
        }
    }//GEN-LAST:event_nexttienphanquyen1ActionPerformed

    private void nexttienphanquyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nexttienphanquyenActionPerformed
        // TODO add your handling code here:
         trang = sotrang;

        DAO_Quyen.dolentable(tblquyen, trang);
        lblsotrang1.setText(trang + "/" + sotrang);
        lbltrang1.setText("" + trang);
    }//GEN-LAST:event_nexttienphanquyenActionPerformed

    private void jTabbedPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentShown
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTabbedPane1ComponentShown

    private void jDesktopPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jDesktopPane1ComponentShown
        // TODO add your handling code here:
   
    }//GEN-LAST:event_jDesktopPane1ComponentShown

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown
        // TODO add your handling code here:
           jButton6.setEnabled(false);
        jButton5.setEnabled(false);
         DAO_Quyen.dolentable(tblquyen, trang);
          lbltrang1.setText("1");
        lblsotrang1.setText("1/" + sotrang);
    }//GEN-LAST:event_jPanel2ComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblsotrang;
    private javax.swing.JLabel lblsotrang1;
    private javax.swing.JLabel lbltrang;
    private javax.swing.JLabel lbltrang1;
    private javax.swing.JButton next1phanquyen;
    private javax.swing.JButton nextlui1tk;
    private javax.swing.JButton nextphanquyen;
    private javax.swing.JButton nexttien1tk;
    private javax.swing.JButton nexttienphanquyen;
    private javax.swing.JButton nexttienphanquyen1;
    private javax.swing.JButton nexttientk;
    private javax.swing.JButton nextvetk;
    private javax.swing.JTable tblquyen;
    private javax.swing.JTable tbltk;
    private javax.swing.JTextField txttim;
    private javax.swing.JTextField txttim1;
    // End of variables declaration//GEN-END:variables

    public void laysodong() {
        try {
            String sql = "SELECT COUNT(*) FROM dbo.taikhoan";
            ResultSet rs = KetNoi.Select(sql);
            while (rs.next()) {
                count = rs.getLong(1);
            }

        } catch (Exception e) {
        }
    }

    public void themDL() {
        n.setTim(txttim.getText());
        n.setManv(manv);
        m.setMaq(mq);
    }
}
