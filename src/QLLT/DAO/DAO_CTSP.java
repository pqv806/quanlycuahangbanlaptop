/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.DAO;

import Ketnoi.KetNoi;
import QLLT.classs.QLCTSP;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinh
 */
public class DAO_CTSP {
    
    public static void dolentable(JTable tblctsp, long trang) {
        try {
            String sql = "SELECT TOP 5 *\n"
                    + "FROM dbo.chitietsanpham \n"
                    + "WHERE masp NOT IN (SELECT TOP " + (trang * 5 - 5) + " masp FROM dbo.chitietsanpham)";
            DefaultTableModel model = (DefaultTableModel) tblctsp.getModel();
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
            tblctsp.setModel(model);
        } catch (Exception e) {
        }
    }

    public static void Insert(QLCTSP n) {
        try {
            String sql = "insert into chitietsanpham( masp, ram, bonho, camera, manhinh,pin,cpu,vo,khac ) \n"
                    + "values(N'" + n.getMasp()+ "'"
                    + ",N'" + n.getRam()+ "'"
                    + ",N'" + n.getBonho()+ "'"
                    + ",N'" + n.getCamera()+ "'"
                    + ",N'" + n.getManhinh()+ "'"
                    + ",N'" + n.getPin()+ "'"
                    + ",'" + n.getCpu()+ "'"
                    + ",N'" + n.getVo() + "'"
                    + ",N'" + n.getKhac()+ "')";

            if (Ketnoi.KetNoi.Update(sql) > 0) {
                System.out.println("Thêm mới thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }

    public static void Delete(QLCTSP n) {
        try {
            String sql = "delete from chitietsanpham\n"
                    + "where masp = N'" + n.getMasp()+ "'";

            if (Ketnoi.KetNoi.Update(sql) > 0) {

            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }

//    public static void update(QLCTSP n) {
//        try {
//            String sql = "update nhacungcap\n"
//                    + "set tenncc = N'" + n.getTenncc() + "'"
//                    + ",diachi = '" + n.getDiachi() + "'"
//                    + ",sdt=N'" + n.getSdt() + "'"
//                    + ",fax=N'" + n.getFax() + "'"
//                    + "where mancc = '" + n.getMancc() + "'";
//            if (Ketnoi.KetNoi.Update(sql) > 0) {
//                System.out.println("Cập nhật thành công");
//            } else {
//                System.out.println("Thất bại");
//            }
//
//        } catch (Exception e) {
//        }
//    }
    
}
