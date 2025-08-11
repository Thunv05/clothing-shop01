/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.*;
import java.util.ArrayList;
import model.SanPham;
import utill.DbConect;
/**
 *
 * @author ADMIN
 */
public class SanPhamRepository {
    Connection conn;
    
    public SanPhamRepository(){
        conn = DbConect.getConnection();
    }
    
    
    public ArrayList<SanPham> getAll(){
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        String sql = """
                     Select sp.Id, sp.TenSp, sp.MaSP, sp.MoTa, cl.TenChatLieu, kd.TenKieuDang, size.MaSize, ms.TenMau, ncc.TenNhaCungCap, sp.GiaBan, sp.GiaNhap, sp.SoLuong, sp.TrangThai from SanPham sp
                     inner join ChatLieu cl on sp.IdChatLieu = cl.Id
                     inner join KieuDang kd on sp.IdKieuDang = kd.Id
                     inner join Size size on sp.IdSize = size.Id
                     inner join MauSac ms  on sp.IdMauSac = ms.id
                     inner join NhaCungCap ncc on sp.IdNhaCungCap = ncc.Id
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listSanPham.add(new SanPham(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getFloat(10),
                        rs.getFloat(11),
                        rs.getInt(12),
                        rs.getInt(13)
                ));
            }
        } catch (Exception e) {
        }
        return listSanPham;
    }
    public ArrayList<SanPham> getAllSoLuong(){
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        String sql = """
                     Select sp.Id, sp.TenSp, sp.MaSP, SUM( hdct.SoLuong ) AS TongSoLuong 
                                                               from HoaDonChiTiet hdct
                                                               inner join HoaDon hd on hdct.IdHoaDon = hd.Id
                                                             
                                          					 inner join SanPham sp on sp.Id = hdct.IdSanPham
                                                               where MONTH( hd.NgayTao ) = MONTH ( GETDATE( )) AND YEAR( hd.NgayTao ) = YEAR ( GETDATE( )) 
                                          					 group by sp.Id, sp.TenSp, sp.MaSP  
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listSanPham.add(new SanPham(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                        
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPham;
    }
    
    public void add(SanPham sp){
        String sql = """
                     Insert into SanPham(TenSp, MaSP, MoTa, IdChatLieu, IdKieuDang, IdSize, IdMauSac, IdNhaCungCap, GiaBan, GiaNhap, SoLuong, TrangThai)
                     values(?,?,?,?,?,?,?,?,?,?,?,?)
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, sp.getTen());
            ps.setString(2, sp.getMaSp());
            ps.setString(3, sp.getMoTa());
            ps.setString(4, sp.getIdChatLieu());
            ps.setString(5, sp.getIdKieuDang());
            ps.setString(6, sp.getIdSize());
            ps.setString(7, sp.getIdMauSac());
            ps.setString(8, sp.getIdNhaCungCap());
            ps.setFloat(9, sp.getGiaBan());
            ps.setFloat(10, sp.getGiaNhap());
            ps.setInt(11, sp.getSoLuong());
            ps.setInt(12, sp.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(SanPham sp){
        String sql = """
                     Update SanPham set 
                     TenSp = ?, MaSP= ?, MoTa= ?, IdChatLieu= ?, IdKieuDang= ?, IdSize= ?, IdMauSac= ?, IdNhaCungCap= ?, GiaBan= ?, GiaNhap= ?, SoLuong= ?, TrangThai= ?
                     where Id = ?
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, sp.getTen());
            ps.setString(2, sp.getMaSp());
            ps.setString(3, sp.getMoTa());
            ps.setString(4, sp.getIdChatLieu());
            ps.setString(5, sp.getIdKieuDang());
            ps.setString(6, sp.getIdSize());
            ps.setString(7, sp.getIdMauSac());
            ps.setString(8, sp.getIdNhaCungCap());
            ps.setFloat(9, sp.getGiaBan());
            ps.setFloat(10, sp.getGiaNhap());
            ps.setInt(11, sp.getSoLuong());
            ps.setInt(12, sp.getTrangThai());
            ps.setInt(13, sp.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public SanPham getByMaSP(String maSP) {
    String sql = """
        SELECT sp.Id, sp.TenSp, sp.MaSP, sp.MoTa, cl.TenChatLieu, kd.TenKieuDang, 
               size.MaSize, ms.TenMau, ncc.TenNhaCungCap, sp.GiaBan, sp.GiaNhap, 
               sp.SoLuong, sp.TrangThai
        FROM SanPham sp
        INNER JOIN ChatLieu cl ON sp.IdChatLieu = cl.Id
        INNER JOIN KieuDang kd ON sp.IdKieuDang = kd.Id
        INNER JOIN Size size ON sp.IdSize = size.Id
        INNER JOIN MauSac ms ON sp.IdMauSac = ms.Id
        INNER JOIN NhaCungCap ncc ON sp.IdNhaCungCap = ncc.Id
        WHERE sp.MaSP = ?
    """;

    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, maSP);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new SanPham(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8),
                rs.getString(9),
                rs.getFloat(10),
                rs.getFloat(11),
                rs.getInt(12),
                rs.getInt(13)
            );
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}

    public int getIdSanPhamMoiNhat() {
    String sql = "SELECT TOP 1 Id FROM SanPham ORDER BY Id DESC";
    try {
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return -1;
}

}
