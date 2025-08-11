/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewMain;

import javax.swing.JFrame;

/**
 *
 * @author ADMIN
 */
public class TestJpanel {
    
    public static void main(String[] args) {
        // Tạo frame tạm để chứa panel cần test
        JFrame frame = new JFrame("Test PanelKhachHang");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Thêm panel cần test vào frame
        ViewKhachHang panel = new ViewKhachHang();
        frame.setContentPane(panel);

        // Cài đặt kích thước và hiển thị
        frame.pack(); // Hoặc frame.setSize(800, 600);
        frame.setLocationRelativeTo(null); // Center màn hình
        frame.setVisible(true);
    }
}