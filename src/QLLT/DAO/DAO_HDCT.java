/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.DAO;
import Ketnoi.KetNoi;
import QLLT.classs.QLHD;
import QLLT.classs.QLHDCT;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author vinh
 */
public class DAO_HDCT {
     public static void Insert(QLHDCT n) {
        try {
            String sql = "insert into hoadonchitiet(mahd, tensp, soluong, dongia ) \n"
                    + "values(N'" + n.getMahd()+ "'"
                    + ",N'" + n.getTensp()+ "'"
                   + ",N'" + n.getSl()+ "'"
                    + ",N'" + n.getDongia()+ "')";

            if (Ketnoi.KetNoi.Update(sql) > 0) {
                System.out.println("Thêm mới thành công");
            } else {
                System.out.println("Thất bại");
            }

        } catch (Exception e) {
        }
       
}}
