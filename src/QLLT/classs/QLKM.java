/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLLT.classs;

import java.util.Date;
import javafx.scene.chart.PieChart;

/**
 *
 * @author vinh
 */
public class QLKM {
   private String makm,tenkm,ghichu;
   private float dieukien,phantram;
   private Date ngaybd,ngaykt;

    public String getMakm() {
        return makm;
    }

    public void setMakm(String makm) {
        this.makm = makm;
    }

    public String getTenkm() {
        return tenkm;
    }

    public void setTenkm(String tenkm) {
        this.tenkm = tenkm;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public float getDieukien() {
        return dieukien;
    }

    public void setDieukien(float dieukien) {
        this.dieukien = dieukien;
    }

    public float getPhantram() {
        return phantram;
    }

    public void setPhantram(float phantram) {
        this.phantram = phantram;
    }

    public Date getNgaybd() {
        return ngaybd;
    }

    public void setNgaybd(Date ngaybd) {
        this.ngaybd = ngaybd;
    }

    public Date getNgaykt() {
        return ngaykt;
    }

    public void setNgaykt(Date ngaykt) {
        this.ngaykt = ngaykt;
    }
   
}
