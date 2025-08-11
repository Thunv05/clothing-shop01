/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.*;
import java.util.ArrayList;
import model.ChucVu;
import utill.DbConect;
/**
 *
 * @author ADMIN
 */
public class ChucVuRepository {
    Connection conn;
    
    public ChucVuRepository(){
        conn = DbConect.getConnection();
    }
    
    
    public ArrayList<ChucVu> getAll(){
        ArrayList<ChucVu> listChucVu = new ArrayList<>();
        String sql = """
                     Select Id, TenChucVu, MoTa, TrangThai from ChucVu;
                     """;
        try{
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listChucVu.add(new ChucVu(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                ));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listChucVu;
    }
    
    public void add(ChucVu cv){
        String sql = """
                     Insert into ChucVu 
                     values TenChucVu = ?, MoTa = ?, TrangThai = ? 
                     """;
        try{
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, cv.getTenChucVu());
            ps.setString(2, cv.getMoTa());
            ps.setInt(3, cv.getTrangThai());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void update(ChucVu cv){
        String sql = """
                     update ChucVu set TenChucVu = ? , MoTa = ?, TrangThai = ? 
                     where Id = ?
                     """;
        try{
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, cv.getTenChucVu());
            ps.setString(2, cv.getMoTa());
            ps.setInt(3, cv.getTrangThai());
            ps.setInt(4, cv.getId());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
