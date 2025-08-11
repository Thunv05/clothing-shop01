/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.*;
import java.util.ArrayList;
import model.NhaCungCap;
import utill.DbConect;
/**
 *
 * @author ADMIN
 */
public class NhaCungCapRepository {
    Connection conn;
    
    public NhaCungCapRepository(){
        conn = DbConect.getConnection();
    }
    
    public ArrayList<NhaCungCap> getAll(){
        ArrayList<NhaCungCap> listNcc = new ArrayList<>();
        String sql = """
                     select Id, TenNhaCungCap, SDT, DiaChi, Email, TrangThai from NhaCungCap
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listNcc.add(new NhaCungCap(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNcc;
    }
    public void add(NhaCungCap ncc){
        String sql = """
                     Insert into NhaCungCap(TenNhaCungCap, SDT, DiaChi, Email, TrangThai) 
                     values(?,?,?,?,?)
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, ncc.getTen());
            ps.setString(2, ncc.getsDT());
            ps.setString(3, ncc.getDiaChi());
            ps.setString(4, ncc.getEmail());
            ps.setInt(5, ncc.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(NhaCungCap ncc){
        String sql = """
                    update NhaCungCap set TenNhaCungCap = ? , SDT = ? , DiaChi = ?, Email = ? , TrangThai = ? 
                     where Id = ?
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, ncc.getTen());
            ps.setString(2, ncc.getsDT());
            ps.setString(3, ncc.getDiaChi());
            ps.setString(4, ncc.getEmail());
            ps.setInt(5, ncc.getTrangThai());
            ps.setInt(6, ncc.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
