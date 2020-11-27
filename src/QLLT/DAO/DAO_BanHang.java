/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.DAO;

import Ketnoi.KetNoi;
import QLLT.classs.QLSP;

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
public class DAO_BanHang {
    public static void dolentable(JTable tblsp, long trang) {
        try {
            String sql = "SELECT *\n"
                    + "FROM dbo.sanpham \n"
                    ;
            DefaultTableModel model = (DefaultTableModel) tblsp.getModel();
            ResultSet rs = KetNoi.Select(sql);
            Vector v = null;
            model.setRowCount(0);
            while (rs.next()) {
                v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(piceFormatter.format(rs.getFloat(4))); 
                v.add(rs.getInt(6));
                v.add(rs.getString(7));
          
                model.addRow(v);

            }
            tblsp.setModel(model);
        } catch (Exception e) {
        }

    }
   
    
}
