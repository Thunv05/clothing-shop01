/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.sql.*;
import java.util.ArrayList;
import model.Voucher;
import utill.DbConect;
/**
 *
 * @author ADMIN
 */
public class VoucherRepository {
   Connection conn;
    
    public VoucherRepository(){
        conn = DbConect.getConnection();
    }
    
    
    public ArrayList<Voucher> getAll(){
        ArrayList<Voucher> listVoucher = new ArrayList<>();
        String sql = """
                    select Id, Ten, PhanTramGiam, DieuKienApDung, NgayBatDau, NgayKetThuc, TrangThai from Voucher
                     """;
        try{
            expireOutdated();
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                listVoucher.add(new Voucher(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getDate(6),
                        rs.getInt(7)
                ));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listVoucher;
    }

    public void expireOutdated(){
        String sql = "UPDATE Voucher SET TrangThai = 0 WHERE NgayKetThuc <= CAST(GETDATE() AS date) AND TrangThai <> 0";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void add(Voucher vc){
        String sql = """
                     Insert into Voucher( Ten, PhanTramGiam, DieuKienApDung, NgayBatDau, NgayKetThuc, TrangThai)
                     Values(?,?,?,?,?,?)
                     """;
        try{
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, vc.getTen());
            ps.setInt(2, vc.getPhanTramGiam());
            ps.setString(3, vc.getDieuKienApDung());
            java.util.Date ngayBatDau = vc.getNgayBatBau();  // Giả sử nv.getNgaySinh() trả về java.util.Date
            if (ngayBatDau != null) {
                java.sql.Date ngayBatDauSql = new java.sql.Date(ngayBatDau.getTime());  // Chuyển đổi java.util.Date thành java.sql.Date
                ps.setDate(4, ngayBatDauSql);  // Sử dụng java.sql.Date cho setDate()
            } else {
                ps.setNull(4, java.sql.Types.DATE);  // Nếu ngày sinh là null, sử dụng setNull
            }
            java.util.Date ngayKetThuc = vc.getNgayKetThuc();  // Giả sử nv.getNgaySinh() trả về java.util.Date
            if (ngayKetThuc != null) {
                java.sql.Date ngayKetThucSql = new java.sql.Date(ngayKetThuc.getTime());  // Chuyển đổi java.util.Date thành java.sql.Date
                ps.setDate(5, ngayKetThucSql);  // Sử dụng java.sql.Date cho setDate()
            } else {
                ps.setNull(5, java.sql.Types.DATE);  // Nếu ngày sinh là null, sử dụng setNull
            }
            // Nếu ngay khi thêm mà đã quá ngày kết thúc thì set trạng thái dừng hoạt động
            int trangThai = vc.getTrangThai();
            try {
                if (ngayKetThuc != null) {
                    java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
                    java.sql.Date endSql = new java.sql.Date(ngayKetThuc.getTime());
                    if (!today.before(endSql)) { // today >= end
                        trangThai = 0; // dừng hoạt động
                    }
                }
            } catch (Exception ignore) {}
            ps.setInt(6, trangThai);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void update(Voucher vc){
        String sql = """
                     Update Voucher set 
                     Ten = ? , PhanTramGiam = ?, DieuKienApDung = ? , NgayBatDau = ? , NgayKetThuc=? , TrangThai = ?
                     where Id = ?
                     """;
        try{
            PreparedStatement ps = conn.prepareCall(sql);
            ps.setString(1, vc.getTen());
            ps.setInt(2, vc.getPhanTramGiam());
            ps.setString(3, vc.getDieuKienApDung());
            java.util.Date ngayBatDau = vc.getNgayBatBau();  // Giả sử nv.getNgaySinh() trả về java.util.Date
            if (ngayBatDau != null) {
                java.sql.Date ngayBatDauSql = new java.sql.Date(ngayBatDau.getTime());  // Chuyển đổi java.util.Date thành java.sql.Date
                ps.setDate(4, ngayBatDauSql);  // Sử dụng java.sql.Date cho setDate()
            } else {
                ps.setNull(4, java.sql.Types.DATE);  // Nếu ngày sinh là null, sử dụng setNull
            }
            java.util.Date ngayKetThuc = vc.getNgayKetThuc();  // Giả sử nv.getNgaySinh() trả về java.util.Date
            if (ngayKetThuc != null) {
                java.sql.Date ngayKetThucSql = new java.sql.Date(ngayKetThuc.getTime());  // Chuyển đổi java.util.Date thành java.sql.Date
                ps.setDate(5, ngayKetThucSql);  // Sử dụng java.sql.Date cho setDate()
            } else {
                ps.setNull(5, java.sql.Types.DATE);  // Nếu ngày sinh là null, sử dụng setNull
            }
            // Nếu đã quá ngày kết thúc thì tự cập nhật trạng thái dừng hoạt động
            int trangThai = vc.getTrangThai();
            try {
                if (ngayKetThuc != null) {
                    java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
                    java.sql.Date endSql = new java.sql.Date(ngayKetThuc.getTime());
                    if (!today.before(endSql)) { // today >= end
                        trangThai = 0; // dừng hoạt động
                    }
                }
            } catch (Exception ignore) {}
            ps.setInt(6, trangThai);
            ps.setInt(7, vc.getId());
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
