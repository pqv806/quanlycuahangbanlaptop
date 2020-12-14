/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.DAO;

import Ketnoi.KetNoi;
import QLLT.classs.QLNCC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinh
 */
public class DAO_NCC {

    public static void dolentable(JTable tblNCC, long trang) {
        try {
            String sql = "SELECT TOP 5 *\n"
                    + "FROM dbo.nhacungcap \n"
                    + "WHERE mancc NOT IN (SELECT TOP " + (trang * 5 - 5) + " mancc FROM dbo.nhacungcap)";
            DefaultTableModel model = (DefaultTableModel) tblNCC.getModel();
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
            tblNCC.setModel(model);
        } catch (Exception e) {
        }
    }

    public static void Insert(QLNCC n) {
        try {
            String sql = "insert into nhacungcap( mancc, tenncc, diachi, sdt, fax ) \n"
                    + "values(N'" + n.getMancc() + "'"
                    + ",N'" + n.getTenncc() + "'"
                    + ",N'" + n.getDiachi() + "'"
                    + ",N'" + n.getSdt() + "'"
                    + ",N'" + n.getFax() + "')";

            if (Ketnoi.KetNoi.Update(sql) > 0) {
                System.out.println("Thêm mới thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }

    public static void Delete(QLNCC n) {
        try {
            String sql = "delete from nhacungcap\n"
                    + "where mancc = N'" + n.getMancc() + "'";

            if (Ketnoi.KetNoi.Update(sql) > 0) {

            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }

    public static void update(QLNCC n) {
        try {
            String sql = "update nhacungcap\n"
                    + "set tenncc = N'" + n.getTenncc() + "'"
                    + ",diachi = N'" + n.getDiachi() + "'"
                    + ",sdt=N'" + n.getSdt() + "'"
                    + ",fax=N'" + n.getFax() + "'"
                    + "where mancc = '" + n.getMancc() + "'";
            if (Ketnoi.KetNoi.Update(sql) > 0) {
                System.out.println("Cập nhật thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
    }

    public static void TimKiemNCC(QLNCC n, JTable tblNCC) throws SQLException {
        String sql = "";

        sql = "select * from nhacungcap\n"
                + "where tenncc like N'%" + n.getTim() + "%'"
                + "or tenncc like N'%" + n.getTim() + "%'"
                + "or mancc like N'%" + n.getTim() + "%'"
                + "or diachi like N'%" + n.getTim() + "%'"
                + "or sdt like N'%" + n.getTim() + "%'"
                + "or fax like N'%" + n.getTim() + "%'";
        ResultSet rs = KetNoi.Select(sql);
        DefaultTableModel model = (DefaultTableModel) tblNCC.getModel();
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
        tblNCC.setModel(model);
    }

}
