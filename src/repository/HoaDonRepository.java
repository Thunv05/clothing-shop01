/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.*;
import java.util.ArrayList;
import model.HoaDon;
import utill.DbConect;
/**
 *
 * @author ADMIN
 */
public class HoaDonRepository {
    Connection conn;
    
    public HoaDonRepository(){
        conn = DbConect.getConnection();
    }
    
    public ArrayList<HoaDon> getAll(){
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        String sql = """
                     select hd.Id, hd.MaHD, nv.Ten, kh.TenKhachHang, hd.NgayTao, hd.TongTien, vc.Ten, hd.TrangThai from HoaDon hd
                     inner join NhanVien nv on nv.Id = hd.IdNhanVien
                     inner join KhachHang kh on kh.Id = hd.IdKhachHang
                     inner join Voucher vc on vc.Id = hd.IdVoucher
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listHoaDon.add(new HoaDon(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getFloat(6),
                        rs.getString(7),
                        rs.getInt(8)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return  listHoaDon;
    }
    
     public void add(HoaDon sp){
        String sql = """
                     Insert into HoaDon(MaHD, IdNhanVien, IdKhachHang, NgayTao, TongTien, IdVoucher, TrangThai)
                     values(?,?,?,?,?,?,?)
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, sp.getMaHoaDon());
            ps.setString(2, sp.getIdNhanVien());
            ps.setString(3, sp.getIdKhachHang());
            ps.setString(4, sp.getNgayTao());
            ps.setFloat(5, sp.getTongTien());
            ps.setString(6, sp.getIdVoucher());
            ps.setInt(7, sp.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     
      public void update(HoaDon sp){
        String sql = """
                     Update  HoaDon set MaHD = ? , IdNhanVien = ?, IdKhachHang = ?, NgayTao = ?, TongTien = ?, IdVoucher = ?, TrangThai = ?
                     where Id = ? 
                   
                     """;
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, sp.getMaHoaDon());
            ps.setString(2, sp.getIdNhanVien());
            ps.setString(3, sp.getIdKhachHang());
            ps.setString(4, sp.getNgayTao());
            ps.setFloat(5, sp.getTongTien());
            ps.setString(6, sp.getIdVoucher());
            ps.setInt(7, sp.getTrangThai());
            ps.setInt(8, sp.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
