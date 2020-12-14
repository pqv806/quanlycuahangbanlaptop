/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.from.fromcon;

import Ketnoi.KetNoi;
import QLLT.DAO.DAO_Quyen;
import QLLT.DAO.nextid;
import QLLT.classs.QLquyen;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author vinh
 */
public class themquyen extends javax.swing.JInternalFrame {

    Ketnoi.KetNoi cn = new KetNoi();
    QLquyen n = new QLquyen();
    nextid id = new nextid();
    String ma, banhang1="a", nhaphang1="a", sanpham1="a", hd1="a",nv1="a",kh1="a",ncc="a",tk="a",doitra="a",thongke="a";

    /**
     * Creates new form themquyen
     */
    public themquyen() {
        initComponents();
        cboban.setEnabled(false);
        cbonhap.setEnabled(false);
        cbosp.setEnabled(false);
        cbohd.setEnabled(false);
        cbonv.setEnabled(false);
        cbokh.setEnabled(false);
        cboncc.setEnabled(false);
        cbothongke.setEnabled(false);
        cbodoitra.setEnabled(false);
        cbotk.setEnabled(false);

        id.layid();

        txtq.setText(id.maphanquyen());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtq = new javax.swing.JTextField();
        txttk = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cbban = new javax.swing.JCheckBox();
        cbnhap = new javax.swing.JCheckBox();
        cbsp = new javax.swing.JCheckBox();
        cbhd = new javax.swing.JCheckBox();
        cbnv = new javax.swing.JCheckBox();
        cbkh = new javax.swing.JCheckBox();
        cbtk = new javax.swing.JCheckBox();
        cbthongke = new javax.swing.JCheckBox();
        cbdt = new javax.swing.JCheckBox();
        cbncc = new javax.swing.JCheckBox();
        cboban = new javax.swing.JComboBox<>();
        cbonhap = new javax.swing.JComboBox<>();
        cbosp = new javax.swing.JComboBox<>();
        cbohd = new javax.swing.JComboBox<>();
        cbonv = new javax.swing.JComboBox<>();
        cbokh = new javax.swing.JComboBox<>();
        cboncc = new javax.swing.JComboBox<>();
        cbothongke = new javax.swing.JComboBox<>();
        cbotk = new javax.swing.JComboBox<>();
        cbodoitra = new javax.swing.JComboBox<>();

        setTitle("Thêm Quyền");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Exit.png"))); // NOI18N
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtq.setEditable(false);
        txtq.setBorder(javax.swing.BorderFactory.createTitledBorder("Mã Quyền"));

        txttk.setBorder(javax.swing.BorderFactory.createTitledBorder("Tên Quyền"));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_replay_30px.png"))); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết quyền"));

        cbban.setText("Bán Hàng");
        cbban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbanMouseClicked(evt);
            }
        });

        cbnhap.setText("Nhập Hàng");
        cbnhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbnhapMouseClicked(evt);
            }
        });

        cbsp.setText("Sản Phẩm");
        cbsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbspMouseClicked(evt);
            }
        });

        cbhd.setText("Hóa Đơn");
        cbhd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbhdMouseClicked(evt);
            }
        });

        cbnv.setText("Nhân Viên");
        cbnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbnvMouseClicked(evt);
            }
        });

        cbkh.setText("Khách Hàng");
        cbkh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbkhMouseClicked(evt);
            }
        });

        cbtk.setText("Tài Khoản");
        cbtk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbtkMouseClicked(evt);
            }
        });

        cbthongke.setText("Thống Kê");
        cbthongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbthongkeMouseClicked(evt);
            }
        });

        cbdt.setText("Đổi Trả");
        cbdt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbdtMouseClicked(evt);
            }
        });

        cbncc.setText("Nhà Cung Cấp");
        cbncc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbnccMouseClicked(evt);
            }
        });

        cboban.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BANHANG" }));

        cbonhap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NHAPHANG" }));

        cbosp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "QLSP" }));
        cbosp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbospActionPerformed(evt);
            }
        });

        cbohd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "QLHD" }));

        cbonv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "QLNV" }));

        cbokh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "QLKH" }));

        cboncc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "QLNCC" }));

        cbothongke.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "QLTk" }));

        cbotk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "QLTaiKhoan" }));
        cbotk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotkActionPerformed(evt);
            }
        });

        cbodoitra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "QLDT" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbban)
                    .addComponent(cbnhap)
                    .addComponent(cbdt)
                    .addComponent(cbthongke)
                    .addComponent(cbtk)
                    .addComponent(cbncc)
                    .addComponent(cbkh)
                    .addComponent(cbnv)
                    .addComponent(cbhd)
                    .addComponent(cbsp))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbonhap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbodoitra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboban, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbothongke, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbotk, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbosp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbohd, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboncc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbonv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbokh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbban)
                    .addComponent(cboban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbnhap)
                    .addComponent(cbonhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbsp)
                    .addComponent(cbosp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbhd)
                    .addComponent(cbohd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbnv)
                    .addComponent(cbonv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbkh)
                    .addComponent(cbokh, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbncc)
                    .addComponent(cboncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbtk)
                    .addComponent(cbotk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbthongke)
                    .addComponent(cbothongke, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbdt)
                    .addComponent(cbodoitra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtq, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txttk, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            if (check()) {
                themDL();
                DAO_Quyen.Insert(n);
                JOptionPane.showMessageDialog(this, "Đã Thêm");
                dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbbanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbanMouseClicked
        // TODO add your handling code here:
        if (cbban.isSelected()) {
            cboban.setEnabled(true);
            banhang1=cboban.getSelectedItem().toString();
        }
        else
        {
                 cboban.setEnabled(false);
                 banhang1="";
        }
    }//GEN-LAST:event_cbbanMouseClicked

    private void cbnhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbnhapMouseClicked
        // TODO add your handling code here:
        if (cbnhap.isSelected()) {
            cbonhap.setEnabled(true);
              nhaphang1=cbonhap.getSelectedItem().toString();
        }
        else
        {
                 cbonhap.setEnabled(false);
                 nhaphang1="";
        }
    }//GEN-LAST:event_cbnhapMouseClicked

    private void cbotkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbotkActionPerformed

    private void cbspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbspMouseClicked
        // TODO add your handling code here:
        if (cbsp.isSelected()) {
            cbosp.setEnabled(true);
           sanpham1=cbosp.getSelectedItem().toString();
        }
        else
        {
              cbosp.setEnabled(false);
              sanpham1="";
        }
    }//GEN-LAST:event_cbspMouseClicked

    private void cbhdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbhdMouseClicked
        // TODO add your handling code here:
        if (cbhd.isSelected()) {
            cbohd.setEnabled(true);
          hd1=cbohd.getSelectedItem().toString();
        }
        else
        {
                 cbohd.setEnabled(false);
                 hd1="";
        }
    }//GEN-LAST:event_cbhdMouseClicked

    private void cbnvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbnvMouseClicked
        // TODO add your handling code here:
        if (cbnv.isSelected()) {
            cbonv.setEnabled(true);
          nv1=cbonv.getSelectedItem().toString();
        }
        else
        {
                 cbonv.setEnabled(false);
                 nv1="";
        }
    }//GEN-LAST:event_cbnvMouseClicked

    private void cbkhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbkhMouseClicked
        // TODO add your handling code here:
        if (cbkh.isSelected()) {
            cbokh.setEnabled(true);
            
         kh1=cbokh.getSelectedItem().toString();
        }
        else
        {
                 cbokh.setEnabled(false);
               kh1="";
        }
    }//GEN-LAST:event_cbkhMouseClicked

    private void cbospActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbospActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbospActionPerformed

    private void cbnccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbnccMouseClicked
        // TODO add your handling code here:
        if (cbncc.isSelected()) {
            cboncc.setEnabled(true);
            
         ncc=cboncc.getSelectedItem().toString();
        }
        else
        {
                 cboncc.setEnabled(false);
               ncc="";
        }
    }//GEN-LAST:event_cbnccMouseClicked

    private void cbtkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbtkMouseClicked
        // TODO add your handling code here:
         if (cbtk.isSelected()) {
            cbotk.setEnabled(true);
            
         tk=cbotk.getSelectedItem().toString();
        }
        else
        {
                 cbotk.setEnabled(false);
               tk="";
        }
    }//GEN-LAST:event_cbtkMouseClicked

    private void cbdtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbdtMouseClicked
        // TODO add your handling code here:
           if (cbdt.isSelected()) {
            cbodoitra.setEnabled(true);
            
         doitra=cbodoitra.getSelectedItem().toString();
        }
        else
        {
                 cbodoitra.setEnabled(false);
               doitra="";
        }
    }//GEN-LAST:event_cbdtMouseClicked

    private void cbthongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbthongkeMouseClicked
        // TODO add your handling code here:
          if (cbthongke.isSelected()) {
            cbothongke.setEnabled(true);
            
         thongke=cbothongke.getSelectedItem().toString();
        }
        else
        {
                 cbothongke.setEnabled(false);
               thongke="";
        }
    }//GEN-LAST:event_cbthongkeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbban;
    private javax.swing.JCheckBox cbdt;
    private javax.swing.JCheckBox cbhd;
    private javax.swing.JCheckBox cbkh;
    private javax.swing.JCheckBox cbncc;
    private javax.swing.JCheckBox cbnhap;
    private javax.swing.JCheckBox cbnv;
    private javax.swing.JComboBox<String> cboban;
    private javax.swing.JComboBox<String> cbodoitra;
    private javax.swing.JComboBox<String> cbohd;
    private javax.swing.JComboBox<String> cbokh;
    private javax.swing.JComboBox<String> cboncc;
    private javax.swing.JComboBox<String> cbonhap;
    private javax.swing.JComboBox<String> cbonv;
    private javax.swing.JComboBox<String> cbosp;
    private javax.swing.JComboBox<String> cbothongke;
    private javax.swing.JComboBox<String> cbotk;
    private javax.swing.JCheckBox cbsp;
    private javax.swing.JCheckBox cbthongke;
    private javax.swing.JCheckBox cbtk;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtq;
    private javax.swing.JTextField txttk;
    // End of variables declaration//GEN-END:variables

    private void clear() {

        txttk.setText("");

    }

    public void themDL() {
        n.setMaq(txtq.getText());
        n.setTen(txttk.getText());
        n.setChitietq(banhang1 +" "+nhaphang1+" "+sanpham1+" "+hd1+" " +nv1+" "+kh1+" "+ncc+" "+tk+" "+thongke+" "+doitra+" ");

    }


    private boolean check() {
//        if(txtchitiet.getText().equals("") || txtq.getText().equals("") || txttk.getText().equals("")){
//            JOptionPane.showMessageDialog(this, "Nhập đầy đủ thông tin");
//            return false;
//        }
        return true;
    }
}
