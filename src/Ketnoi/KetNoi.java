/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ketnoi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author vinh
 */
public class KetNoi {
     private static String url = "jdbc:sqlserver://localhost:1433;databaseName=qllaptop4";
    private static String name = "sa";
    private static String password = "Anh123456";
    public static Connection cn ;
    
     public KetNoi() {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(url, name, password);
     
        } catch (Exception e) {
            System.out.println("Lỗi");
        }

    }
      public static ResultSet Select(String sql) {
        try {
            Statement stm = cn.createStatement();
            //Thực thi truy vấn 
            ResultSet rs = stm.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            System.out.println("lỗi kết nối csdl");
            System.out.println(e);
            return null;
        }
    }

    public static int  Update(String sql) {
        try {
            Statement stm = cn.createStatement();
            return stm.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Lỗi kết nối update");
            e.printStackTrace();
            return -1;
        }
    }
       public static int  Update2(String sql) {
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi kết nối update");
          e.printStackTrace();
            return -1;
        }
    }
}
