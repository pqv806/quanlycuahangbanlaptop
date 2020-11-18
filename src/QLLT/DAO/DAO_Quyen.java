/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.DAO;

import Ketnoi.KetNoi;
import QLLT.classs.QLTK;
import QLLT.classs.QLquyen;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinh
 */
public class DAO_Quyen {
    
      public static void dolentable(JTable tblquyen, long trang) {
        try {
            String sql = "SELECT TOP 5 *\n"
                    + "FROM dbo.phanquyen \n"
                    + "WHERE maquyen NOT IN (SELECT TOP " + (trang * 5 - 5) + " maquyen FROM dbo.phanquyen)";
            DefaultTableModel model = (DefaultTableModel) tblquyen.getModel();
            ResultSet rs = KetNoi.Select(sql);
            Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                
               
                model.addRow(v);
               
            }
            tblquyen.setModel(model);
        } catch (Exception e) {
        }
    }

   
     
     public static void Insert(QLquyen n) {
        try {
            String sql = "insert into phanquyen( maquyen, tenquyen, chitietquyen ) \n"
                    + "values(N'" + n.getMaq()+ "'"
                    + ",N'" +n.getTen()+ "'"
                 
                    + ",N'" + n.getChitietq()+ "')";
            if (Ketnoi.KetNoi.Update2(sql) > 0) {
                System.out.println("Thêm mới thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception ex) {
          }
    }
     public static void Delete(QLquyen n) {
        try {
            String sql = "delete from phanquyen\n"
                    + "where maquyen = N'" + n.getMaq()+ "'";

            if (Ketnoi.KetNoi.Update(sql) > 0) {
                
            } else {
                System.out.println("Thất bại");
                
            }

        } catch (Exception e) {
        }
    }

    public static void update(QLquyen n) {
        try {
            String sql = "update phanquyen\n"
                    + "set tenquyen = N'"+n.getTen()+"'"
                    + ",chitietquyen = N'"+n.getChitietq()+"'"
                 
                  
                  
                    
                    + "where maquyen = '"+n.getMaq()+"'";
            if (Ketnoi.KetNoi.Update(sql) > 0) {
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }
  public static  void TimKienquyen(QLquyen n,JTable tblquyen) throws SQLException {
        String sql = "";

        sql = "select * from phanquyen\n"
                    + "where tenquyen like N'%" + n.getTim()+ "%'";
        ResultSet rs = KetNoi.Select(sql);
           DefaultTableModel model = (DefaultTableModel) tblquyen.getModel();
        Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
      
            
                model.addRow(v);
            }
            tblquyen.setModel(model);
        }
}
