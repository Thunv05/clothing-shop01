/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.*;
import java.util.ArrayList;
import model.NhanVien;
import utill.DbConect;
/**
 *
 * @author ADMIN
 */
public class NhanVienRepository {
    Connection conn;
    
    public NhanVienRepository(){
        conn = DbConect.getConnection();
    }
    
    public ArrayList<NhanVien> getAll(){
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        String sql = """
                     select nv.Id, nv.Ten, nv.MaNV, nv.NgaySinh, nv.GioiTinh, nv.Sdt, cv.TenChucVu, nv.TrangThai 
                     from NhanVien nv 
                     inner join ChucVu cv on nv.IdChucVu = cv.Id
                     """;
        try{
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listNhanVien.add(new NhanVien(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8)
                ));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listNhanVien;
    }
    
    public void add(NhanVien nv){
        String sql = """
                     Insert into NhanVien( Ten, MaNV, NgaySinh, GioiTinh, Sdt, IdChucVu, TrangThai)
                     values(?,?,?,?,?,?,?)
                     """;
        try{
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, nv.getTen());
            ps.setString(2, nv.getMaNv());
            java.util.Date ngaySinhUtil = nv.getNgaySinh();  // Giả sử nv.getNgaySinh() trả về java.util.Date
            if (ngaySinhUtil != null) {
                java.sql.Date ngaySinhSql = new java.sql.Date(ngaySinhUtil.getTime());  // Chuyển đổi java.util.Date thành java.sql.Date
                ps.setDate(3, ngaySinhSql);  // Sử dụng java.sql.Date cho setDate()
            } else {
                ps.setNull(3, java.sql.Types.DATE);  // Nếu ngày sinh là null, sử dụng setNull
            }
            ps.setInt(4, nv.getGioiTinh());
            ps.setString(5, nv.getsDt());
            ps.setString(6, nv.getIdChucVu());
            ps.setInt(7, nv.getTrangThai());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void update(NhanVien nv){
        String sql = """ 
                     update NhanVien set Ten = ? , MaNV = ?, NgaySinh = ?, GioiTinh = ? , Sdt = ? ,IdChucVu = ?, TrangThai = ? 
                     where Id = ? ;
                     """;
        try{
            PreparedStatement ps = conn.prepareCall(sql);
                ps.setString(1, nv.getTen());
                ps.setString(2, nv.getMaNv());
                java.util.Date ngaySinhUtil = nv.getNgaySinh();  // Giả sử nv.getNgaySinh() trả về java.util.Date
                if (ngaySinhUtil != null) {
                    java.sql.Date ngaySinhSql = new java.sql.Date(ngaySinhUtil.getTime());  // Chuyển đổi java.util.Date thành java.sql.Date
                    ps.setDate(3, ngaySinhSql);  // Sử dụng java.sql.Date cho setDate()
                } else {
                    ps.setNull(3, java.sql.Types.DATE);  // Nếu ngày sinh là null, sử dụng setNull
                }
                ps.setInt(4, nv.getGioiTinh());
                ps.setInt(7, nv.getTrangThai());
                ps.setString(5, nv.getsDt());
                ps.setString(6, nv.getIdChucVu());
                ps.setInt(8, nv.getId());
                ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
