/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;


/**
 *
 * @author ADMIN
 */

public class Voucher {
    private Integer id;
    private String ten;
    private int phanTramGiam;
    private String dieuKienApDung;
    private Date ngayBatBau;
    private Date ngayKetThuc;
    private int trangThai;

    public Voucher() {
    }

    public Voucher(Integer id, String ten, int phanTramGiam, String dieuKienApDung, Date ngayBatBau, Date ngayKetThuc, int trangThai) {
        this.id = id;
        this.ten = ten;
        this.phanTramGiam = phanTramGiam;
        this.dieuKienApDung = dieuKienApDung;
        this.ngayBatBau = ngayBatBau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(int phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public String getDieuKienApDung() {
        return dieuKienApDung;
    }

    public void setDieuKienApDung(String dieuKienApDung) {
        this.dieuKienApDung = dieuKienApDung;
    }

    public Date getNgayBatBau() {
        return ngayBatBau;
    }

    public void setNgayBatBau(Date ngayBatBau) {
        this.ngayBatBau = ngayBatBau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
    
}
