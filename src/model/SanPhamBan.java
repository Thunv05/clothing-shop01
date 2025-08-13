/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Os
 */
public class SanPhamBan {
    private int idSanPham;
    private String tenSanPham;
    private String maSanPham;
    private int soLuongBan;
    private LocalDateTime ngayBan;
    private float tongTienHoaDon;
    private String tenKhachHang;

    public SanPhamBan(int idSanPham, String tenSanPham, String maSanPham, int soLuongBan,
                      LocalDateTime ngayBan, float tongTienHoaDon, String tenKhachHang) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.maSanPham = maSanPham;
        this.soLuongBan = soLuongBan;
        this.ngayBan = ngayBan;
        this.tongTienHoaDon = tongTienHoaDon;
        this.tenKhachHang = tenKhachHang;
    }

    public int getIdSanPham() { return idSanPham; }
    public String getTenSanPham() { return tenSanPham; }
    public String getMaSanPham() { return maSanPham; }
    public int getSoLuongBan() { return soLuongBan; }
    public LocalDateTime getNgayBan() { return ngayBan; }
    public float getTongTienHoaDon() { return tongTienHoaDon; }
    public String getTenKhachHang() { return tenKhachHang; }
}

