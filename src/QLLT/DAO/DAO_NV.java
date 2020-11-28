/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.DAO;

import Ketnoi.KetNoi;
import static Ketnoi.KetNoi.cn;
import QLLT.classs.QLNV;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinh 
 */

public class DAO_NV {
  

     public static void dolentable(JTable tblNV, long trang) {
        try {
          
            String sql = "SELECT TOP 5 *\n"
                    + "FROM dbo.nhanvien \n"
                    + "WHERE manv NOT IN (SELECT TOP " + (trang * 5 - 5) + " manv FROM dbo.nhanvien)";
            DefaultTableModel model = (DefaultTableModel) tblNV.getModel();
            ResultSet rs = KetNoi.Select(sql);
            Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));
                model.addRow(v);

            }
            tblNV.setModel(model);
        } catch (Exception e) {
        }
       
     }

   
     
     public static void Insert(QLNV n) {
        try {
            String sql = "insert into nhanvien(manv,tennv,ngaysinh,diachi,sdt,trangthai ) \n"
                    + "values(N'" + n.getManv()+ "'"
                    + ",N'" + n.getTennv()+ "'"
                    + ",'" + n.getNgaysinh()+ "'"
                    + ",N'" + n.getDiachi()+ "'"
                    + ",'" + n.getSdt()+ "'"
                    + ",N'" + n.getTrangthai()+ "')";

            if (Ketnoi.KetNoi.Update(sql) > 0) {
                System.out.println("Thêm mới thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
       
        
    }
     public static void Delete(QLNV n) {
        try {
            String sql = "delete from nhanvien\n"
                    + "where manv = N'" + n.getManv()+ "'";

            if (Ketnoi.KetNoi.Update(sql) > 0) {
                
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
        
    }

    public static void update(QLNV n) {
        try {
            String sql = "update nhanvien\n"
                    + "set tennv = N'"+n.getTennv()+"'"
                    + ",ngaysinh = '"+n.getNgaysinh()+"'"
                 
                    + ",diachi=N'"+n.getDiachi()+"'"
                  
                    + ",sdt =N'"+n.getSdt()+"'"
                    + ",trangthai=N'"+n.getTrangthai()+"'"
                    + "where manv = '"+n.getManv()+"'";
            if (Ketnoi.KetNoi.Update(sql) > 0) {
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
        
    }
  public static  void TimKiemKhachHang(QLNV n,JTable tblNV) throws SQLException {
        String sql = "";

        sql = "select * from nhanvien\n"
                    + "where tennv like N'%" + n.getTim()+ "%'"
                + "or tennv like N'%" + n.getTim()+ "%'"
                + "or manv like N'%" + n.getTim()+ "%'"
                + "or ngaysinh like N'%" + n.getTim()+ "%'"
                + "or diachi like N'%" + n.getTim()+ "%'"
                + "or sdt like N'%" + n.getTim()+ "%'"
                + "or trangthai like N'%" + n.getTim()+ "%'";
        ResultSet rs = KetNoi.Select(sql);
           DefaultTableModel model = (DefaultTableModel) tblNV.getModel();
        Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));              
                v.add(rs.getString(6));
                model.addRow(v);
            }
            tblNV.setModel(model);
        }
 
  
    }
        
    
   
    

