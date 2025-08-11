/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.HinhAnh;
import utill.DbConect;
/**
 *
 * @author ADMIN
 */
public class HinhAnhRepository {
     private Connection conn;

    public HinhAnhRepository() {
        conn = DbConect.getConnection();
    }

    public HinhAnh getAll(int idSanPham) {
        String sql = "SELECT * FROM HinhAnhSanPham where IdSanPham = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idSanPham);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
              HinhAnh ha = new HinhAnh();
                     ha.setId(rs.getInt("Id"));
                    ha.setIdSanPham(rs.getInt("IdSanPham"));
                    ha.setUrl(rs.getString("URL"));
                    ha.setTenAnh(rs.getString("TenAnh"));
                    ha.setMoTa(rs.getString("MoTa"));
                    return  ha;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void add(HinhAnh ha){
        String sql = """
                     Insert into HinhAnhSanPham(IdSanPham, URL, TenAnh, MoTa)
                     values(?,?,?,?)
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, ha.getIdSanPham());
            ps.setString(2, ha.getUrl());
            ps.setString(3, ha.getTenAnh());
            ps.setString(4, ha.getMoTa());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void update(HinhAnh ha){
        String sql = """
                     Update HinhAnhSanPham set IdSanPham = ?, URL = ? , TenAnh = ?, MoTa = ? where IdSanPham = ?
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setInt(1, ha.getIdSanPham());
            ps.setString(2, ha.getUrl());
            ps.setString(3, ha.getTenAnh());
            ps.setString(4, ha.getMoTa());
            ps.setInt(5, ha.getIdSanPham());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteByIdSanPham(int idSanPham) {
    String sql = "DELETE FROM HinhAnhSanPham WHERE IdSanPham = ?";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idSanPham);
        ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

        
}
