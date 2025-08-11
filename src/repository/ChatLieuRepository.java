/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.*;
import java.util.ArrayList;
import model.ChatLieu;
import utill.DbConect;
/**
 *
 * @author ADMIN
 */
public class ChatLieuRepository {
    Connection conn;
    
    public ChatLieuRepository(){
        conn = DbConect.getConnection();
    }
    
    public ArrayList<ChatLieu> getAll(){
        ArrayList<ChatLieu> listChatLieu = new ArrayList<>();
        String sql = """
                     Select Id, TenChatLieu, MoTa, TrangThai from ChatLieu
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listChatLieu.add(new ChatLieu(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listChatLieu;
    }
    
    public void add(ChatLieu cl){
        String sql = """
                     Insert into ChatLieu(TenChatLieu, MoTa, TrangThai) 
                     values(?,?,?)
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, cl.getTenChatLieu());
            ps.setString(2, cl.getMoTa());
            ps.setInt(3, cl.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(ChatLieu cl){
        String sql = """
                     Update ChatLieu set TenChatlieu = ? , MoTa = ? , TrangThai = ?
                     where Id = ?
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, cl.getTenChatLieu());
            ps.setString(2, cl.getMoTa());
            ps.setInt(3, cl.getTrangThai());
            ps.setInt(4, cl.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
