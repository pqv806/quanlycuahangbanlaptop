/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.DAO;

import Ketnoi.KetNoi;
import java.sql.ResultSet;

/**
 *
 * @author vinh
 */
public class nextid {
String ma;

    public void layid()
    {
         try {
            String sql = "SELECT NEXT VALUE FOR manext;";
          
            ResultSet rs = KetNoi.Select(sql);
     
        
            while (rs.next()) {
                ma=rs.getString(1);
       
            }
     
        } catch (Exception e) {
        }
    }
    public String maphanquyen()
    {
        return "Q" + String.valueOf(this.ma);
    }
    public String manv()
    {
        return "NV" + String.valueOf(this.ma);
    }
    public String masp()
    {
        return "SP" + String.valueOf(this.ma);
    }
    public String maloai()
    {
        return "ML" + String.valueOf(this.ma);
    }
    public String mahoadon()
    {
        return "Q" + String.valueOf(this.ma);
    }
    
}
