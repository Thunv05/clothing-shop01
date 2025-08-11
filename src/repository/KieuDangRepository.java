/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.*;
import java.util.ArrayList;
import model.KieuDang;
import utill.DbConect;
/**
 *
 * @author ADMIN
 */
public class KieuDangRepository {
    Connection conn;
    
    public KieuDangRepository(){
        conn = DbConect.getConnection();
    }
    
    public ArrayList<KieuDang> getAll(){
        ArrayList<KieuDang> listKieuDang = new ArrayList<>();
        String sql = """
                     Select Id, TenKieuDang, GioiTinh, MoTa, TrangThai from KieuDang
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listKieuDang.add(new KieuDang(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(5)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return  listKieuDang;
    }
    
    public void add(KieuDang kd){
        String sql = """
                     Insert into KieuDang(TenKieuDang, GioiTinh, MoTa, TrangThai ) 
                     values(?,?,?,?)
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, kd.getTenKieuDang());
            ps.setInt(2, kd.getGioiTinh());
            ps.setString(3, kd.getMoTa());
            ps.setInt(4, kd.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void update(KieuDang kd){
        String sql = """
                    Update KieuDang set TenKieuDang = ?, GioiTinh = ?, MoTa = ? , TrangThai = ?
                     where Id = ?
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, kd.getTenKieuDang());
            ps.setInt(2, kd.getGioiTinh());
            ps.setString(3, kd.getMoTa());
            ps.setInt(4, kd.getTrangThai());
            ps.setInt(5, kd.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
