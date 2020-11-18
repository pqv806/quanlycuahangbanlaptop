/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.DAO;

import Ketnoi.KetNoi;
import Ketnoi.MD5;
import QLLT.classs.QLNV;
import QLLT.classs.QLTK;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinh
 */
public class DAO_TK {
    
     public static void dolentable(JTable tbltk, long trang) {
        try {
            String sql = "SELECT TOP 5 *\n"
                    + "FROM dbo.taikhoan \n"
                    + "WHERE manv NOT IN (SELECT TOP " + (trang * 5 - 5) + " manv FROM dbo.taikhoan)";
            DefaultTableModel model = (DefaultTableModel) tbltk.getModel();
            ResultSet rs = KetNoi.Select(sql);
            Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
               
                model.addRow(v);
               
            }
            tbltk.setModel(model);
        } catch (Exception e) {
        }
    }

   
     
     public static void Insert(QLTK n) {
        try {
            String sql = "insert into taikhoan(tentaikhoan,matkhau,manv,maquyen) \n"
                    + "values(N'" + n.getTentk()+ "'"
                    + ",N'" +n.getMk()+ "'"
                    + ",'" + n.getManv()+ "'"
                    + ",N'" + n.getMaquyen()+ "')";
            if (Ketnoi.KetNoi.Update2(sql) > 0) {
                System.out.println("Thêm mới thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception ex) {
          }
    }
     public static void Delete(QLTK n) {
        try {
            String sql = "delete from taikhoan\n"
                    + "where manv = N'" + n.getManv()+ "'";

            if (Ketnoi.KetNoi.Update(sql) > 0) {
                
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }

    public static void update(QLTK n) {
        try {
            String sql = "update taikhoan\n"
                    + "set tentaikhoan = N'"+n.getTentk()+"'"
                    + ",matkhau = '"+n.getMk()+"'"
                 
                    + ",maquyen=N'"+n.getMaquyen()+"'"
                  
                    
                    + "where manv = '"+n.getManv()+"'";
            if (Ketnoi.KetNoi.Update(sql) > 0) {
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }
  public static  void TimKiemnhanvien(QLTK n,JTable tbltk) throws SQLException {
        String sql = "";

        sql = "select * from taikhoan\n"
                    + "where tentaikhoan like N'%" + n.getTim()+ "%'";
        ResultSet rs = KetNoi.Select(sql);
           DefaultTableModel model = (DefaultTableModel) tbltk.getModel();
        Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
            
                model.addRow(v);
            }
            tbltk.setModel(model);
        }
}
