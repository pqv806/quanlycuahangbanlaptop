/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.DAO;

import Ketnoi.KetNoi;
import QLLT.nhanvien.trangchinh1;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import quanlylaptopadmin.trangchinh;

/**
 *
 * @author vinh
 */
public class DAO_Dangnhap {
     public static String name, pas, role;
     public static ResultSet DNhapTheoMa(String TK, String MK) {
        try {
            String sql = "select * from taikhoan where tentaikhoan =N'" + TK + "'\n"
                    + "and  matkhau = N'" + MK + "'";
            return KetNoi.Select(sql);

        } catch (Exception e) {
            System.out.println("Loi DAO DN");
            return null;
        }

    }
     public static boolean KT_DangNhap(String TK, String MK) {
        ResultSet rs = DAO_Dangnhap.DNhapTheoMa(TK, MK);

        try {
            if(rs.next()) {
                if (rs.getString(1).matches(TK)) {
                    if (rs.getString(2).matches(MK)) {
                        
                        role = rs.getString(4);
                       if (role.equals("Q01")) {
                    
                        trangchinh ql = new trangchinh();
                        ql.setVisible(true);
                     
                    } else if (role.equals("Q02")) {
                     
                        trangchinh1 a = new trangchinh1();
                        a.setVisible(true);
                   
                    }

                        return true;
                    }

                    System.out.println("Tài khoản hoặc mật khẩu sai rồi hi");
                    return false;
                } else {
                    System.out.println("Tiếc quá bạn đã đăng nhập thất bại rồi");
                    return false;
                }
                
            }
            else{
                System.out.println("Đăng nhập thất bại");
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
