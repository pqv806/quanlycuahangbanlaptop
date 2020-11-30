/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.DAO;

import Ketnoi.KetNoi;
import QLLT.classs.QLLSP;
import QLLT.classs.piceFormatter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author THINKPAD T460S
 */
public class DAO_LSP {
     public static void dolentable(JTable tbllsp, long trang) {
        try {
            String sql = "SELECT TOP 10 *\n"
                    + "FROM dbo.loaisanpham \n"
                    + "WHERE malsp NOT IN (SELECT TOP " + (trang * 5 - 5) + " malsp FROM dbo.loaisanpham)";
            DefaultTableModel model = (DefaultTableModel) tbllsp.getModel();
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
            tbllsp.setModel(model);
        } catch (Exception e) {
        }
        
    }
      public static void Insert(QLLSP n) {
        try {
            String sql = "insert into loaisanpham( malsp, tenlsp, mota ) \n"
                    + "values(N'" + n.getMalsp()+ "'"
                    + ",N'" +n.getTenlsp()+ "'"
                 
                    + ",N'" + n.getMota()+ "')";
            if (Ketnoi.KetNoi.Update2(sql) > 0) {
                System.out.println("Thêm mới thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception ex) {
        }
    }
     public static void Delete(QLLSP n) {
        try {
            String sql = "delete from loaisanpham\n"
                    + "where malsp = N'" + n.getMalsp()+ "'";

            if (Ketnoi.KetNoi.Update(sql) > 0) {
                
            } else {
                System.out.println("Thất bại");
                
            }

        } catch (Exception e) {
        }
        
    }

    public static void update(QLLSP n) {
        try {
            String sql = "update loaisanpham\n"
                    + "set tenlsp = N'"+n.getTenlsp()+"'"
                    + ",mota = N'"+n.getMota()+"'"
                 
                  
                  
                    
                    + "where malsp = '"+n.getMalsp()+"'";
            if (Ketnoi.KetNoi.Update(sql) > 0) {
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
        
    }
   
  public static  void TimKienLSP(QLLSP n,JTable tbllsp) throws SQLException {
        String sql = "";

        sql = "select * from loaisanpham\n"
                    + "where tenlsp like N'%" + n.getTim()+ "%'";
        ResultSet rs = KetNoi.Select(sql);
           DefaultTableModel model = (DefaultTableModel) tbllsp.getModel();
        Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
      
            
                model.addRow(v);
            }
            tbllsp.setModel(model);
        }
}
