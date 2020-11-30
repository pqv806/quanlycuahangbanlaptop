/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.DAO;

import QLLT.classs.QLCTPN;


/**
 *
 * @author vinh
 */
public class DAO_CTPN {
         public static void Insert(QLCTPN n) {
        try {
            String sql = "insert into chitietphieunhap(mapn, masp,tensp, soluong, dongia ) \n"
                    + "values(N'" + n.getMapn()+ "'"
                     + ",N'" + n.getMasp()+ "'"
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
       
}
}
