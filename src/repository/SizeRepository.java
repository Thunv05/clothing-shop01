/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.*;
import java.util.ArrayList;
import model.Size;
import utill.DbConect;
/**
 *
 * @author ADMIN
 */
public class SizeRepository {
    Connection conn;
    
    public SizeRepository(){
        conn = DbConect.getConnection();
    }
    
    public ArrayList<Size> getAll(){
        ArrayList<Size> listSize = new ArrayList<>();
        String sql = """
                     Select Id, MaSize, MoTa, TrangThai from Size 
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listSize.add(new Size(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                ));
            }
        } catch (Exception e) { 
            e.printStackTrace();
        }
        return listSize;
    }
    
    public void add(Size s){
        String sql  = """
                      Insert into Size(MaSize, MoTa, TrangThai) values (?,?,?)
                      """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, s.getMaSize());
            ps.setString(2, s.getMoTa());
            ps.setInt(3, s.getTrangThai());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(Size s){
        String sql  = """
                      Update Size set MaSize = ? , MoTa = ? , TrangThai = ? where Id = ?
                      """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, s.getMaSize());
            ps.setString(2, s.getMoTa());
            ps.setInt(3, s.getTrangThai());
            ps.setInt(4, s.getId());
            ps.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
