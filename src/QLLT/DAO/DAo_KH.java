/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.DAO;

import Ketnoi.KetNoi;
import QLLT.classs.QLKH;
import QLLT.classs.QLNV;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinh
 */
public class DAo_KH {
    public static void dolentable(JTable tblKH, long trang) {
        try {
          
            String sql = "SELECT TOP 5 *\n"
                    + "FROM dbo.khachhang \n"
                    + "WHERE makh NOT IN (SELECT TOP " + (trang * 5 - 5) + " makh FROM dbo.khachhang)";
            DefaultTableModel model = (DefaultTableModel) tblKH.getModel();
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
            
                model.addRow(v);

            }
            tblKH.setModel(model);
        } catch (Exception e) {
        }
       
     }

   
     
     public static void Insert(QLKH n) {
        try {
            String sql = "insert into khachhang(makh, tenkh, diachi, sdt, trangthai) \n"
                    + "values(N'" + n.getMakh()+ "'"
                    + ",N'" + n.getTenkh()+ "'"
                    + ",'" + n.getDiachi()+ "'"
                    + ",N'" + n.getSdt()+ "'"  
                    + ",N'" + n.getTrangthai()+ "')";

            if (Ketnoi.KetNoi.Update(sql) > 0) {
                System.out.println("Thêm mới thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
       
        
    }
     public static void Delete(QLKH n) {
        try {
            String sql = "delete from khachhang\n"
                    + "where makh = N'" + n.getMakh()+ "'";

            if (Ketnoi.KetNoi.Update(sql) > 0) {
                
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
        
    }

    public static void update(QLKH n) {
        try {
            String sql = "update khachhang\n"
                    + "set tenkh = N'"+n.getTenkh()+"'"
                    + ",diachi = '"+n.getDiachi()+"'"
                 
                    + ",sdt=N'"+n.getDiachi()+"'"
                  
                   
                    + ",trangthai=N'"+n.getTrangthai()+"'"
                    + "where makh = '"+n.getMakh()+"'";
            if (Ketnoi.KetNoi.Update(sql) > 0) {
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
        
    }
  public static  void TimKiemKH(QLKH n,JTable tblkh) throws SQLException {
        String sql = "";

        sql = "select * from khachhang\n"
                    + "where tenkh like N'%" + n.getTim()+ "%'";
        ResultSet rs = KetNoi.Select(sql);
           DefaultTableModel model = (DefaultTableModel) tblkh.getModel();
        Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));              
          
                model.addRow(v);
            }
            tblkh.setModel(model);
        }

   
    
}
