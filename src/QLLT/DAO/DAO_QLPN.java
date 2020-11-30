/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.DAO;

import Ketnoi.KetNoi;
import QLLT.classs.QLPN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinh
 */
public class DAO_QLPN {
    public static void dolentable(JTable tblpn, long trang) {
        try {
          
            String sql = "SELECT  *\n"
                    + "FROM dbo.phieunhap ";
                 
            DefaultTableModel model = (DefaultTableModel) tblpn.getModel();
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
            tblpn.setModel(model);
        } catch (Exception e) {
        }
       
     }

   
     
     public static void Insert(QLPN n) {
        try {
            String sql = "insert into phieunhap(mapn, mancc, manv, ngaynhap, tongtien ) \n"
                    + "values(N'" + n.getMapn()+ "'"
                    + ",N'" + n.getMancc()+ "'"
                    + ",'" + n.getManv()+ "'"
                    + ",N'" + n.getNgaylap()+ "'"
                    + ",N'" + n.getTongtien()+ "')";

            if (Ketnoi.KetNoi.Update(sql) > 0) {
                System.out.println("Thêm mới thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
       
        
    }
    

    
    
  public static  void TimKiemPN(QLPN n,JTable tblpn) throws SQLException {
        String sql = "";

        sql = "select * from phieunhap\n"
                    + "where mapn like N'%" + n.getTim()+ "%'";
        ResultSet rs = KetNoi.Select(sql);
           DefaultTableModel model = (DefaultTableModel) tblpn.getModel();
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
            tblpn.setModel(model);
        }
 
}
