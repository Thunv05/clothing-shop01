/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


/**
 *
 * @author ADMIN
 */

public class SanPham {
    private int id;
    private String ten;
    private String MaSp;
    private String moTa;
    private String idChatLieu;
    private String idKieuDang;
    private String idSize;
    private String idMauSac;
    private String idNhaCungCap;
    private float giaNhap;
    private float giaBan;
    private int soLuong;
    private int trangThai;
     private int SoLuongBan;

    public SanPham() {
    }

    public SanPham(int id, String ten, String MaSp, String moTa, String idChatLieu, String idKieuDang, String idSize, String idMauSac, String idNhaCungCap, float giaNhap, float giaBan, int soLuong, int trangThai) {
        this.id = id;
        this.ten = ten;
        this.MaSp = MaSp;
        this.moTa = moTa;
        this.idChatLieu = idChatLieu;
        this.idKieuDang = idKieuDang;
        this.idSize = idSize;
        this.idMauSac = idMauSac;
        this.idNhaCungCap = idNhaCungCap;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
        this.trangThai = trangThai;
    }
    
    public SanPham(int id, String ten, String MaSp,int SoLuongBan ) {
        this.id = id;
        this.ten = ten;
        this.MaSp = MaSp;
        this.SoLuongBan = SoLuongBan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getSoLuongBan() {
        return SoLuongBan;
    }

    public void setSoLuongBan(int id) {
        this.SoLuongBan = id;
    }


    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String MaSp) {
        this.MaSp = MaSp;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(String idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public String getIdKieuDang() {
        return idKieuDang;
    }

    public void setIdKieuDang(String idKieuDang) {
        this.idKieuDang = idKieuDang;
    }

    public String getIdSize() {
        return idSize;
    }

    public void setIdSize(String idSize) {
        this.idSize = idSize;
    }

    public String getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(String idMauSac) {
        this.idMauSac = idMauSac;
    }

    public String getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public void setIdNhaCungCap(String idNhaCungCap) {
        this.idNhaCungCap = idNhaCungCap;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
