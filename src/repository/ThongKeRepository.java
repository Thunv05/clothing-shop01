/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;
import model.SanPhamBan;
import model.ThongKe;
import utill.DbConect;

/**
 *
 * @author Os
 */
public class ThongKeRepository {
      private final Connection conn;

    public ThongKeRepository() {
        this.conn = DbConect.getConnection();
    }

    public ThongKe thongKeTheoNgay(int ngay, int thang, int nam) {
        String sql = """
            SELECT ISNULL(SUM(hd.TongTien), 0) AS TongTien,
                   ISNULL(SUM(hdct.SoLuong), 0) AS TongSoLuong
            FROM HoaDon hd
            INNER JOIN HoaDonChiTiet hdct ON hd.Id = hdct.IdHoaDon
            WHERE DAY(hd.NgayTao) = ? AND MONTH(hd.NgayTao) = ? AND YEAR(hd.NgayTao) = ?
        """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ngay);
            ps.setInt(2, thang);
            ps.setInt(3, nam);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new ThongKe(rs.getFloat(1), rs.getInt(2));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ThongKe thongKeTheoThang(int thang, int nam) {
        String sql = """
            SELECT ISNULL(SUM(hd.TongTien), 0) AS TongTien,
                   ISNULL(SUM(hdct.SoLuong), 0) AS TongSoLuong
            FROM HoaDon hd
            INNER JOIN HoaDonChiTiet hdct ON hd.Id = hdct.IdHoaDon
            WHERE MONTH(hd.NgayTao) = ? AND YEAR(hd.NgayTao) = ?
        """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, thang);
            ps.setInt(2, nam);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new ThongKe(rs.getFloat(1), rs.getInt(2));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ThongKe thongKeTheoNam(int nam) {
        String sql = """
            SELECT ISNULL(SUM(hd.TongTien), 0) AS TongTien,
                   ISNULL(SUM(hdct.SoLuong), 0) AS TongSoLuong
            FROM HoaDon hd
            INNER JOIN HoaDonChiTiet hdct ON hd.Id = hdct.IdHoaDon
            WHERE YEAR(hd.NgayTao) = ?
        """;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, nam);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new ThongKe(rs.getFloat(1), rs.getInt(2));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<SanPham> thongKeSanPham(Integer day, Integer month, Integer year) {
        String sql = """
            SELECT sp.Id, sp.TenSp, sp.MaSP, SUM(hdct.SoLuong) AS TongSoLuong
            FROM HoaDonChiTiet hdct
            INNER JOIN HoaDon hd ON hd.Id = hdct.IdHoaDon
            INNER JOIN SanPham sp ON sp.Id = hdct.IdSanPham
            WHERE (? IS NULL OR DAY(hd.NgayTao) = ?)
              AND (? IS NULL OR MONTH(hd.NgayTao) = ?)
              AND (? IS NULL OR YEAR(hd.NgayTao) = ?)
            GROUP BY sp.Id, sp.TenSp, sp.MaSP
            ORDER BY TongSoLuong DESC
        """;
        List<SanPham> result = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            // day
            if (day == null) {
                ps.setNull(1, java.sql.Types.INTEGER);
                ps.setNull(2, java.sql.Types.INTEGER);
            } else {
                ps.setInt(1, day);
                ps.setInt(2, day);
            }
            // month
            if (month == null) {
                ps.setNull(3, java.sql.Types.INTEGER);
                ps.setNull(4, java.sql.Types.INTEGER);
            } else {
                ps.setInt(3, month);
                ps.setInt(4, month);
            }
            // year
            if (year == null) {
                ps.setNull(5, java.sql.Types.INTEGER);
                ps.setNull(6, java.sql.Types.INTEGER);
            } else {
                ps.setInt(5, year);
                ps.setInt(6, year);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result.add(new SanPham(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<SanPhamBan> thongKeSanPhamChiTiet(Integer day, Integer month, Integer year) {
        String sql = """
            SELECT sp.Id, sp.TenSp, sp.MaSP, hdct.SoLuong,
                   CAST(hd.NgayTao AS datetime) AS NgayBan,
                   hd.TongTien, kh.TenKhachHang
            FROM HoaDonChiTiet hdct
            INNER JOIN HoaDon hd ON hd.Id = hdct.IdHoaDon
            INNER JOIN SanPham sp ON sp.Id = hdct.IdSanPham
            INNER JOIN KhachHang kh ON kh.Id = hd.IdKhachHang
            WHERE (? IS NULL OR DAY(hd.NgayTao) = ?)
              AND (? IS NULL OR MONTH(hd.NgayTao) = ?)
              AND (? IS NULL OR YEAR(hd.NgayTao) = ?)
            ORDER BY hd.NgayTao DESC
        """;
        List<SanPhamBan> result = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            if (day == null) { ps.setNull(1, java.sql.Types.INTEGER); ps.setNull(2, java.sql.Types.INTEGER);} else { ps.setInt(1, day); ps.setInt(2, day);}        
            if (month == null) { ps.setNull(3, java.sql.Types.INTEGER); ps.setNull(4, java.sql.Types.INTEGER);} else { ps.setInt(3, month); ps.setInt(4, month);}  
            if (year == null) { ps.setNull(5, java.sql.Types.INTEGER); ps.setNull(6, java.sql.Types.INTEGER);} else { ps.setInt(5, year); ps.setInt(6, year);}    
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    result.add(new SanPhamBan(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getTimestamp(5).toLocalDateTime(),
                        rs.getFloat(6),
                        rs.getString(7)
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}


