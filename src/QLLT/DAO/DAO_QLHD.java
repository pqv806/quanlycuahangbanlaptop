/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.DAO;

import Ketnoi.KetNoi;
import QLLT.classs.QLHD;
import QLLT.classs.piceFormatter;

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
                    + "FROM dbo.hoadon ";
                 
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
                v.add(piceFormatter.format(rs.getFloat(5)));
               
                model.addRow(v);

            }
            tblhd.setModel(model);
        } catch (Exception e) {
        }
       
     }

   
     
     public static void Insert(QLHD n) {
        try {
            String sql = "insert into hoadon(mahd,manv,makh,ngaylap,tongtien ) \n"
                    + "values(N'" + n.getMahd()+ "'"
                    + ",N'" + n.getManv()+ "'"
                    + ",'" + n.getMakh()+ "'"
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
         
                model.addRow(v);
            }
            tblhd.setModel(model);
        }
   public static  void TimKiemsp(QLHD n,JTable tblsp) throws SQLException {
        String sql = "";

        sql = "select * from sanpham\n"
                    + "where tensp like N'%" + n.getTim()+ "%'"
                + "or masp like N'%" + n.getTim()+ "%'"
                + "or tensp like N'%" + n.getTim()+ "%'"
                + "or malsp like N'%" + n.getTim()+ "%'"
                + "or giaban like N'%" + n.getTim()+ "%'"
                + "or soluong like N'%" + n.getTim()+ "%'"
                + "or hinhanh like N'%" + n.getTim()+ "%'"
                + "or mota like N'%\" + n.getTim()+ \"%'";
        ResultSet rs = KetNoi.Select(sql);
           DefaultTableModel model = (DefaultTableModel) tblsp.getModel();
        Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(piceFormatter.format(rs.getFloat(4)));
                v.add(rs.getString(6));              
                v.add(rs.getString(7));
                model.addRow(v);
            }
            tblsp.setModel(model);
        }
   public static  void TimKiemspnhap(QLHD n,JTable tblsp) throws SQLException {
        String sql = "";

        sql = "select * from sanpham\n"
                    + "where tensp like N'%" + n.getTim()+ "%'"
                + "or masp like N'%" + n.getTim()+ "%'"
                + "or tensp like N'%" + n.getTim()+ "%'"
                + "or malsp like N'%" + n.getTim()+ "%'"
                + "or giaban like N'%" + n.getTim()+ "%'"
                + "or soluong like N'%" + n.getTim()+ "%'"
                + "or hinhanh like N'%" + n.getTim()+ "%'"
                + "or mota like N'%\" + n.getTim()+ \"%'";
        ResultSet rs = KetNoi.Select(sql);
           DefaultTableModel model = (DefaultTableModel) tblsp.getModel();
        Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(piceFormatter.format(rs.getFloat(5)));
                v.add(rs.getString(6));              
                v.add(rs.getString(7));
                model.addRow(v);
            }
            tblsp.setModel(model);
        }
}
