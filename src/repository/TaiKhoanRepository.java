/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import utill.DbConect;
import java.sql.*;
/**
 *
 * @author ADMIN
 */
public class TaiKhoanRepository {
    private Connection conn = null;
    public TaiKhoanRepository(){
        conn = DbConect.getConnection();
    }
    public boolean login(String tenDangNhap, String matKhau){
        Boolean result = null;
        String sql = """
                     Select * from TaiKhoan where TenDangNhap = ? and MatKhau = ? ;
                     """;
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            result = rs.next() ? true : false;
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
