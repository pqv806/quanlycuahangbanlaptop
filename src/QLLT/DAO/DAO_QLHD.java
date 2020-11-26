/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.DAO;

import Ketnoi.KetNoi;
import QLLT.classs.QLHD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinh
 */
public class DAO_QLHD {
     public static void dolentable(JTable tblhd, long trang) {
        try {
          
            String sql = "SELECT  *\n"
                    + "FROM dbo.hoadon \n"
                    + "WHERE mahd NOT IN (SELECT TOP " + (trang * 5 - 5) + " mahd FROM dbo.hoadon)";
            DefaultTableModel model = (DefaultTableModel) tblhd.getModel();
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
            tblhd.setModel(model);
        } catch (Exception e) {
        }
       
     }

   
     
     public static void Insert(QLHD n) {
        try {
            String sql = "insert into hoadon(mahd,manv,makh,ngaylap,makhuyenmai,tongtien ) \n"
                    + "values(N'" + n.getMahd()+ "'"
                    + ",N'" + n.getManv()+ "'"
                    + ",'" + n.getMakh()+ "'"
                    + ",N'" + n.getNgaylap()+ "'"
                    + ",'" + n.getMakhuyenmai()+ "'"
                    + ",N'" + n.getTongtien()+ "')";

            if (Ketnoi.KetNoi.Update(sql) > 0) {
                System.out.println("Thêm mới thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
       
        
    }
    

    
    
  public static  void TimKiemhoadon(QLHD n,JTable tblhd) throws SQLException {
        String sql = "";

        sql = "select * from hoadon\n"
                    + "where mahd like N'%" + n.getTim()+ "%'";
        ResultSet rs = KetNoi.Select(sql);
           DefaultTableModel model = (DefaultTableModel) tblhd.getModel();
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
            tblhd.setModel(model);
        }
}
