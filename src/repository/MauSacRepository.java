/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.*;
import java.util.ArrayList;
import model.MauSac;
import utill.DbConect;
/**
 *
 * @author ADMIN
 */
public class MauSacRepository {
    Connection conn;
    
    public MauSacRepository(){
        conn = DbConect.getConnection();
    }
    
    public ArrayList<MauSac> getAll(){
        ArrayList<MauSac> listMauSac = new ArrayList<>();
        String sql = """
                     Select Id, TenMau, MoTa, TrangThai from MauSac;
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listMauSac.add(new MauSac(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMauSac;
    }
    
    public void add(MauSac ms ){
        String sql = """
                     Insert into MauSac(TenMau, MoTa, TrangThai) values (?,?,?)
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, ms.getTenMau());
            ps.setString(2, ms.getMoTa());
            ps.setInt(3, ms.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(MauSac ms ){
        String sql = """
                     Update MauSac set TenMau = ? , MoTa = ? , TrangThai = ? where Id = ?
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, ms.getTenMau());
            ps.setString(2, ms.getMoTa());
            ps.setInt(3, ms.getTrangThai());
            ps.setInt(4, ms.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
