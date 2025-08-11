/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.*;
import java.util.ArrayList;
import model.KhachHang;
import utill.DbConect;
/**
 *
 * @author ADMIN
 */
public class KhachHangRepository {
    Connection conn;
    
    public KhachHangRepository(){
        conn = DbConect.getConnection();
    }
    
    public ArrayList<KhachHang> getAll(){
        ArrayList<KhachHang> danhSach = new ArrayList<>();
        String sql = """
                     select Id, TenKhachHang, SDT, Email, TrangThai from KhachHang
                     """;
        try{
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                danhSach.add(new KhachHang(
                        rs.getInt("ID"),
                        rs.getString("TenKhachHang"),
                        rs.getString("SDT"),
                        rs.getString("Email"),
                        rs.getInt("TrangThai")
                ));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return danhSach;
    }
    
    public void add(KhachHang kh){
        String sql = """
                     Insert into KhachHang(TenKhachHang, SDT, Email, TrangThai)
                     values(?,?,?,?)
                     """;
        try{
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, kh.getTenKhachHang());
            ps.setString(2, kh.getsDT());
            ps.setString(3, kh.getEmail());
            ps.setInt(4, kh.getTrangThai());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void update(KhachHang kh){
        String sql = """
                    Update KhachHang set TenKhachHang = ? , SDT = ? , Email = ? , TrangThai = ?
                     where id = ? 
                     """;
        try{
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, kh.getTenKhachHang());
            ps.setString(2, kh.getsDT());
            ps.setString(3, kh.getEmail());
            ps.setInt(4, kh.getTrangThai());
            ps.setInt(5, kh.getId());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}

