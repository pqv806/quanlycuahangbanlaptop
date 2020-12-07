/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.DAO;

import Ketnoi.KetNoi;
import QLLT.classs.QLquyen;
import QLLT.classs.QLtrahang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinh
 */
public class DAO_TRAHANG {
     public static void dolentable(JTable tbltrahang) {
        try {
            String sql = "SELECT *\n"
                    + "FROM dbo.trahang1 \n";
                  
            DefaultTableModel model = (DefaultTableModel) tbltrahang.getModel();
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
                v.add(rs.getString(7));
                v.add(rs.getString(8));
                v.add(rs.getString(9));

                model.addRow(v);
               
            }
            tbltrahang.setModel(model);
        } catch (Exception e) {
        }
       
    }

   
     
     public static void Insert(QLtrahang n) {
        try {
            String sql = "insert into trahang1(matrahang,masp,mahd,makh,phuongthuctra,ngay,lydodoitra,trangthai,ghichu) \n"
                    + "values(N'" + n.getMatrahang()+ "'"
                    + ",N'" +n.getMasp()+ "'"
                    + ",N'" +n.getMahd()+ "'"
                    + ",N'" +n.getMakh()+ "'"
                    + ",N'" +n.getPhuongthuctra()+ "'"
                    + ",N'" +n.getNgay()+ "'"
                    + ",N'" +n.getLydodoitra()+ "'"
                   + ",N'" +n.getTrangthai()+ "'"
                    + ",N'" + n.getGhichu()+ "')";
            
            if (Ketnoi.KetNoi.Update2(sql) > 0) {
                System.out.println("Thêm mới thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception ex) {
        }
    }
     public static void Delete(QLtrahang n) {
        try {
            String sql = "delete from trahang1\n"
                    + "where matrahang = N'" + n.getMatrahang()+ "'";

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
