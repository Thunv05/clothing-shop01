/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package viewMain;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChatLieu;
import model.HinhAnh;
import model.KieuDang;
import model.MauSac;
import model.NhaCungCap;
import model.SanPham;
import model.Size;
import repository.ChatLieuRepository;
import repository.HinhAnhRepository;
import repository.KieuDangRepository;
import repository.MauSacRepository;
import repository.NhaCungCapRepository;
import repository.SanPhamRepository;
import repository.SizeRepository;

/**
 *
 * @author Os
 */
public class ViewSanPham extends javax.swing.JPanel {
    DefaultTableModel dtm ;
    DefaultTableModel dtmMauSac ;
    DefaultTableModel dtmSize ;
    DefaultTableModel dtmNcc ;
    DefaultTableModel dtmChatLieu ;
    DefaultTableModel dtmKieuDang ;
    
    SanPhamRepository sanPhamRepository;
    MauSacRepository mauSacRepository;
    SizeRepository sizeRepository;
    NhaCungCapRepository nhaCungCapRepository;
    KieuDangRepository kieuDangRepository;
    ChatLieuRepository chatLieuRepository;
    HinhAnhRepository hinhAnhRepository;
    
    DefaultComboBoxModel cbmChatLieu;
    DefaultComboBoxModel cbmKieuDang;
    DefaultComboBoxModel cbmSize;
    DefaultComboBoxModel cbmMauSac;
    DefaultComboBoxModel cbmNhaCungCap;
    /**
     * Creates new form SanPham
     */
    public ViewSanPham() {
        initComponents();
        sanPhamRepository = new SanPhamRepository();
        mauSacRepository = new MauSacRepository();
        sizeRepository = new SizeRepository();
        nhaCungCapRepository = new NhaCungCapRepository();
        chatLieuRepository = new ChatLieuRepository();
        kieuDangRepository = new KieuDangRepository();
        hinhAnhRepository = new HinhAnhRepository();
        
        dtm = (DefaultTableModel) this.tblSanPham.getModel();
        dtmMauSac = (DefaultTableModel) this.tblMauSac.getModel();
        dtmSize = (DefaultTableModel) this.tblSize.getModel();
        dtmNcc = (DefaultTableModel) this.tblNhaCungCap.getModel();
        dtmChatLieu = (DefaultTableModel) this.tblChatLieu.getModel();
        dtmKieuDang = (DefaultTableModel) this.tblKieuDang.getModel();
        
        cbmChatLieu = (DefaultComboBoxModel) this.cbbKieuDang.getModel();
        cbmKieuDang = (DefaultComboBoxModel) this.cbbKieuDang.getModel();
        cbmSize = (DefaultComboBoxModel) this.cbbSize.getModel();
        cbmMauSac = (DefaultComboBoxModel) this.cbbMauSac.getModel();
        cbmNhaCungCap = (DefaultComboBoxModel) this.cbbNhaCungCap.getModel();
        
        
        this.fillTable(sanPhamRepository.getAll());
        this.fillTableMauSac(mauSacRepository.getAll());
        this.fillTableSize(sizeRepository.getAll());
        this.fillTableChatLieu(chatLieuRepository.getAll());
        this.fillTableKieuDang(kieuDangRepository.getAll());
        this.fillTableNhaCungCap(nhaCungCapRepository.getAll());
        
        
        this.fillComboBoxChatLieu(chatLieuRepository.getAll());
        this.fillComboBoxKieuDang(kieuDangRepository.getAll());
        this.fillComboBoxSize(sizeRepository.getAll());
        this.fillComboBoxMauSac(mauSacRepository.getAll());
        this.fillComboBoxNhaCungCap(nhaCungCapRepository.getAll());
        
    }
String duongDanAnh ;
private File fileAnhDaChon = null;
    public void fillTable(ArrayList<SanPham> listSanPham){
        int row = this.tblSanPham.getSelectedRow();
        dtm.setRowCount(0);
        for(SanPham sp : listSanPham){
            dtm.addRow(new Object[]{
                sp.getId(),
                sp.getTen(),
                sp.getMaSp(),
                sp.getMoTa(),
                sp.getIdChatLieu(),
                sp.getIdKieuDang(),
                sp.getIdSize(),
                sp.getIdMauSac(),
                sp.getIdNhaCungCap(),
                sp.getGiaBan(),
                sp.getGiaNhap(),
                sp.getSoLuong(),
                sp.getTrangThai() == 1 ? "Kinh doanh" : "Ngừng kinh doanh"
            });
        }
    }
    
    public void fillTableMauSac(ArrayList<MauSac> listMauSac){
        int row = this.tblMauSac.getSelectedRow();
        dtmMauSac.setRowCount(0);
        for(MauSac ms : listMauSac){
            dtmMauSac.addRow(new Object[]{
                ms.getId(),
                ms.getTenMau(),
                ms.getMoTa(),
                ms.getTrangThai() == 1 ? "Hoạt động" : "Dừng hoạt động"
            });
        }
    }
    
    public void fillTableSize(ArrayList<Size> listSize){
      int row = this.tblSize.getSelectedRow();
      dtmSize.setRowCount(0);
      for(Size s : listSize){
          dtmSize.addRow(new Object[]{
              s.getId(), 
              s.getMaSize(),
              s.getMoTa(),
              s.getTrangThai() == 1 ? "Hoạt động" : "Dừng hoạt động"
          });
      }
    }
    
    public void fillTableNhaCungCap(ArrayList<NhaCungCap> listNcc){
        int row = this.tblNhaCungCap.getSelectedRow();
        dtmNcc.setRowCount(0);
        for(NhaCungCap ncc : listNcc){
            dtmNcc.addRow(new Object[]{
                ncc.getId(), 
                ncc.getTen(),
                ncc.getsDT(), 
                ncc.getDiaChi(), 
                ncc.getEmail(),
                ncc.getTrangThai() == 1 ? "Hoạt động" : "Dừng hoạt động"
            });
        }
    }
    
    public void fillTableChatLieu(ArrayList<ChatLieu> listChatLieu){
        int row = this.tblChatLieu.getSelectedRow();
      dtmChatLieu.setRowCount(0);
      for(ChatLieu cl : listChatLieu){
          dtmChatLieu.addRow(new Object[]{
              cl.getId(), 
              cl.getTenChatLieu(),
              cl.getMoTa(),
              cl.getTrangThai() == 1 ? "Hoạt động" : "Dừng hoạt động"
          });
      }
    }
    
    
    public void fillTableKieuDang(ArrayList<KieuDang> listKieuDang){
        int row = this.tblKieuDang.getSelectedRow();
      dtmKieuDang.setRowCount(0);
       String giotTinh = "";
      for(KieuDang kd : listKieuDang){
        switch (kd.getGioiTinh()) {
            case 0 -> giotTinh = "Nam";
            case 1 -> giotTinh = "Nữ";
            case 2 -> giotTinh = "Unisex";
        }
          dtmKieuDang.addRow(new Object[]{
              kd.getId(), 
              kd.getTenKieuDang(),
              giotTinh,
              kd.getMoTa(),
              kd.getTrangThai() == 1 ? "Hoạt động" : "Dừng hoạt động"
          });
      }
    }
     public void fillComboBoxChatLieu(ArrayList<ChatLieu> listChatLieu){
        cbbChatLieu.removeAllItems();
        listChatLieu.forEach(s -> cbbChatLieu.addItem(s.getTenChatLieu()));
    }
      public void fillComboBoxKieuDang(ArrayList<KieuDang> listKIeuDang){
        cbbKieuDang.removeAllItems();
        listKIeuDang.forEach(s -> cbbKieuDang.addItem(s.getTenKieuDang()));
    }
       public void fillComboBoxSize(ArrayList<Size> listSize){
        cbbSize.removeAllItems();
        listSize.forEach(s -> cbbSize.addItem(s.getMaSize()));
    }
         public void fillComboBoxMauSac(ArrayList<MauSac> listMauSac){
        cbbMauSac.removeAllItems();
        listMauSac.forEach(s -> cbbMauSac.addItem(s.getTenMau()));
    }
           public void fillComboBoxNhaCungCap(ArrayList<NhaCungCap> listNcc){
        cbbNhaCungCap.removeAllItems();
        listNcc.forEach(s -> cbbNhaCungCap.addItem(s.getTen()));
    }
       
    public SanPham getFormSanPham(){
        Integer id = this.txtIdSanPham.getText().isBlank() ? 0 : Integer.valueOf(this.txtIdSanPham.getText());
        String tenSanPham = this.txtTenSanPham.getText();
        String maSp = this.txtMaSanPham.getText();
        String moTa = this.txtMoTaSanPham.getText().toString();
        int ChatLieu = this.cbbChatLieu.getSelectedIndex();
        String idChatLieu = String.valueOf(chatLieuRepository.getAll().get(ChatLieu).getId());
        int kieuDang = this.cbbKieuDang.getSelectedIndex();
        String idKieuDang = String.valueOf(kieuDangRepository.getAll().get(kieuDang).getId());
        int size = this.cbbSize.getSelectedIndex();
        String idSize = String.valueOf(sizeRepository.getAll().get(size).getId());
        int mauSac = this.cbbMauSac.getSelectedIndex();
        String idMauSac = String.valueOf(mauSacRepository.getAll().get(mauSac).getId());
        int NhaCC = this.cbbNhaCungCap.getSelectedIndex();
        String idNHaCC = String.valueOf(nhaCungCapRepository.getAll().get(NhaCC).getId());
        Float giaBan = Float.valueOf(this.txtGiaBan.getText());
        Float giaNhap = Float.valueOf(this.txtGiaNHap.getText());
        int soLuong = Integer.valueOf(this.txtSoLuongSanPham.getText());
        int trangThai = this.rdoSanPhamKinhDoanh.isSelected() == true ? 1:0;
        return new SanPham(id, tenSanPham, maSp, moTa, idChatLieu, idKieuDang, idSize, idMauSac, idNHaCC, giaNhap, giaBan, soLuong, trangThai);
    }
    
    public MauSac getFormMauSac(){
        Integer id = this.txtIdMauSac.getText().isBlank() ? 0 : Integer.valueOf(this.txtIdMauSac.getText());
         String tenMau = this.txtTenMau.getText();
         String moTa =this.txtMoTaMau.getText().toString();
         Integer trangThai = this.rdoMauHoatDong.isSelected() == true ? 1 : 0;       
        return new MauSac(id, tenMau, moTa,trangThai);
    }
    public HinhAnh getFormHinhAnh(){
        Integer id = this.txtIdSanPham.getText().isBlank() ? 0 : Integer.valueOf(this.txtIdSanPham.getText());
        Integer idSP = this.txtIdSanPham.getText().isBlank() ? 0 : Integer.valueOf(this.txtIdSanPham.getText());
         String URL = this.txtURLAnh.getText();
         String TenAnh ="";
         String MoTa = "";       
        return new HinhAnh(id,idSP, URL, TenAnh,MoTa);
    }
    public Size getFormSize(){
        Integer id = this.txtIdSize.getText().isBlank() ? 0 : Integer.valueOf(this.txtIdSize.getText());
         String maSize = this.txtMaSize.getText();
         String moTa =this.txtMoTaSize.getText().toString();
         Integer trangThai = this.rdoHoatDongSize.isSelected() == true ? 1 : 0;       
        return new Size(id, maSize, moTa,trangThai);
    }
    
    public ChatLieu getFormChatLieu(){
        Integer id = this.txtIdChatLieu.getText().isBlank() ? 0 : Integer.valueOf(this.txtIdChatLieu.getText());
         String tenChatLieu = this.txtTenChatLieu.getText();
         String moTa =this.txtMoTaChatLieu.getText().toString();
         Integer trangThai = this.rdoHoatDongChatLieu.isSelected() == true ? 1 : 0;       
        return new ChatLieu(id, tenChatLieu, moTa, trangThai);
    }
     public KieuDang getFormKieuDang(){
        Integer id = this.txtIdKieuDang.getText().isBlank() ? 0 : Integer.valueOf(this.txtIdKieuDang.getText());
         String tenKieuDang = this.txtTenKieuDang.getText();
         int gioiTinh = -1;
         if (this.rdoUnisex.isSelected()) {
              gioiTinh = 2;
         }else if (this.rdoNam.isSelected()) {
             gioiTinh = 0;
         }else if (this.rdoNu.isSelected()) {
             gioiTinh = 1;
         }
         String moTa =this.txtMoTaKieuDang.getText().toString();
         Integer trangThai = this.rdoHoatDongKieuDang.isSelected() == true ? 1 : 0;       
        return new KieuDang(id, tenKieuDang, gioiTinh, moTa, trangThai);
    }
     
      public NhaCungCap getFormNhaCungCap(){
        Integer id = this.txtIdNcc.getText().isBlank() ? 0 : Integer.valueOf(this.txtIdNcc.getText());
         String tenNcc = this.txtTenNhaCungCap.getText();
         String sDT =this.txtSDTNCC.getText().toString();
         String diaChi = this.txtDiaChiNCC.getText();
         String email = this.txtEmailNCC.getText();
         Integer trangThai = this.rdoHoatDongNCC.isSelected() == true ? 1 : 0;       
        return new NhaCungCap(id, tenNcc, sDT, diaChi, email, trangThai);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        txtURLAnh = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        rdoSanPhamKinhDoanh = new javax.swing.JRadioButton();
        rdoSanPhamNgungKinhDoanh = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        JlbHinhAnh = new javax.swing.JLabel();
        btnClearSanPham = new javax.swing.JButton();
        btnAddSanPham = new javax.swing.JButton();
        btnUpDateSanPham = new javax.swing.JButton();
        txtTimKiemSanPham = new javax.swing.JTextField();
        btnSearchSanPham = new javax.swing.JButton();
        btnDoiAnhSanPham = new javax.swing.JButton();
        txtIdSanPham = new javax.swing.JTextField();
        txtGiaNHap = new javax.swing.JTextField();
        txtTenSanPham = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        txtMaSanPham = new javax.swing.JTextField();
        txtSoLuongSanPham = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtMoTaSanPham = new javax.swing.JTextArea();
        cbbSize = new javax.swing.JComboBox<>();
        cbbMauSac = new javax.swing.JComboBox<>();
        cbbNhaCungCap = new javax.swing.JComboBox<>();
        cbbKieuDang = new javax.swing.JComboBox<>();
        cbbChatLieu = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblMauSac = new javax.swing.JTable();
        txtMoTaMau = new javax.swing.JTextField();
        rdoMauDungHoatDong = new javax.swing.JRadioButton();
        txtIdMauSac = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        btnClearFormMau = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        btnUpdateMauSac = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        btnAddMauSac = new javax.swing.JButton();
        rdoMauHoatDong = new javax.swing.JRadioButton();
        jLabel40 = new javax.swing.JLabel();
        txtTenMau = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblSize = new javax.swing.JTable();
        txtMoTaSize = new javax.swing.JTextField();
        rdoDungHoatDongSize = new javax.swing.JRadioButton();
        txtIdSize = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        btnClearFormSize = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        btnUpdateSize = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        btnAddSize = new javax.swing.JButton();
        rdoHoatDongSize = new javax.swing.JRadioButton();
        jLabel46 = new javax.swing.JLabel();
        txtMaSize = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblChatLieu = new javax.swing.JTable();
        txtMoTaChatLieu = new javax.swing.JTextField();
        rdoDungHoatDongChatLieu = new javax.swing.JRadioButton();
        txtIdChatLieu = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        btnClearFormChatLieu = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        btnUpdateChatLieu = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        btnAddChatLieu = new javax.swing.JButton();
        rdoHoatDongChatLieu = new javax.swing.JRadioButton();
        jLabel50 = new javax.swing.JLabel();
        txtTenChatLieu = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblKieuDang = new javax.swing.JTable();
        rdoNu = new javax.swing.JRadioButton();
        txtIdKieuDang = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        btnClearFormKieuDang = new javax.swing.JButton();
        btnUpdateKieuDang = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        btnAddKieuDang = new javax.swing.JButton();
        rdoUnisex = new javax.swing.JRadioButton();
        jLabel54 = new javax.swing.JLabel();
        txtTenKieuDang = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        txtMoTaKieuDang = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        rdoHoatDongKieuDang = new javax.swing.JRadioButton();
        rdoDungHoatDongKieuDang = new javax.swing.JRadioButton();
        rdoNam = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        txtSDTNCC = new javax.swing.JTextField();
        btnClearNCC = new javax.swing.JButton();
        btnUpdateNCC = new javax.swing.JButton();
        btnAddNCC = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblNhaCungCap = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtIdNcc = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtTenNhaCungCap = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtEmailNCC = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtDiaChiNCC = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rdoHoatDongNCC = new javax.swing.JRadioButton();
        rdoDungHoatDongNCC = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 650));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setText("Quản lý sản phẩm ");

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên", "Mã SP", "Mô tả", "Chất liệu", "Kiểu dáng ", "Size", "Màu sắc", "Nhà cung cấp", "Giá bán ", "Giá nhập", "Số lượng", "Trạng thái "
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        jLabel3.setText("ID");

        jLabel4.setText("Tên");

        jLabel5.setText("Mã SP");

        jLabel6.setText("Giá nhập");

        jLabel7.setText("Chất liệu");

        jLabel8.setText("Kiểu dáng ");

        jLabel9.setText("Size ");

        jLabel10.setText("Màu sắc");

        jLabel11.setText("Nhà CC");

        jLabel12.setText("Giá bán ");

        jLabel13.setText("Mô tả ");

        jLabel26.setText("Số lượng");

        jLabel31.setText("Trạng thái ");

        buttonGroup1.add(rdoSanPhamKinhDoanh);
        rdoSanPhamKinhDoanh.setSelected(true);
        rdoSanPhamKinhDoanh.setText("Kinh doanh");

        buttonGroup1.add(rdoSanPhamNgungKinhDoanh);
        rdoSanPhamNgungKinhDoanh.setText("Ngừng kinh doanh");
        rdoSanPhamNgungKinhDoanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoSanPhamNgungKinhDoanhActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JlbHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(JlbHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btnClearSanPham.setText("Clear");
        btnClearSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearSanPhamActionPerformed(evt);
            }
        });

        btnAddSanPham.setText("Add");
        btnAddSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSanPhamActionPerformed(evt);
            }
        });

        btnUpDateSanPham.setText("Update");
        btnUpDateSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpDateSanPhamActionPerformed(evt);
            }
        });

        btnSearchSanPham.setText("Tìm kiếm ");

        btnDoiAnhSanPham.setText("Đổi ảnh ");
        btnDoiAnhSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiAnhSanPhamActionPerformed(evt);
            }
        });

        txtMoTaSanPham.setColumns(20);
        txtMoTaSanPham.setRows(5);
        jScrollPane6.setViewportView(txtMoTaSanPham);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSearchSanPham)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addComponent(btnClearSanPham)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddSanPham)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpDateSanPham))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnDoiAnhSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGiaNHap, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(txtIdSanPham)
                                    .addComponent(cbbMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbChatLieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(43, 43, 43)
                                        .addComponent(txtTenSanPham))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtGiaBan))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbbKieuDang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(23, 23, 23)
                                        .addComponent(cbbNhaCungCap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(txtMaSanPham)
                                    .addComponent(txtSoLuongSanPham)
                                    .addComponent(cbbSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoSanPhamKinhDoanh)
                                .addGap(18, 18, 18)
                                .addComponent(rdoSanPhamNgungKinhDoanh)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(txtIdSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12)
                            .addComponent(jLabel26)
                            .addComponent(txtGiaNHap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuongSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel13)
                            .addComponent(cbbKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDoiAnhSanPham))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(rdoSanPhamKinhDoanh)
                            .addComponent(rdoSanPhamNgungKinhDoanh)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiemSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchSanPham))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpDateSanPham)
                            .addComponent(btnAddSanPham)
                            .addComponent(btnClearSanPham))
                        .addGap(26, 26, 26)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản lý sản phẩm ", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Màu sắc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N

        tblMauSac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Mô tả", "Trạng thái"
            }
        ));
        tblMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMauSacMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblMauSac);

        buttonGroup2.add(rdoMauDungHoatDong);
        rdoMauDungHoatDong.setText("Dừng hoạt động");

        jLabel42.setText("Trạng Thái");

        btnClearFormMau.setText("Clear");
        btnClearFormMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormMauActionPerformed(evt);
            }
        });

        jLabel41.setText("Mô tả");

        btnUpdateMauSac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Up.png"))); // NOI18N
        btnUpdateMauSac.setText("Update");
        btnUpdateMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateMauSacActionPerformed(evt);
            }
        });

        jLabel39.setText("Id");

        btnAddMauSac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnAddMauSac.setText("Add");
        btnAddMauSac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMauSacActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdoMauHoatDong);
        rdoMauHoatDong.setSelected(true);
        rdoMauHoatDong.setText("Hoạt động");

        jLabel40.setText("Tên");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnClearFormMau, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdateMauSac)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel42)
                            .addGap(18, 18, 18)
                            .addComponent(rdoMauHoatDong)
                            .addGap(18, 18, 18)
                            .addComponent(rdoMauDungHoatDong))
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel40)
                                .addComponent(jLabel41)
                                .addComponent(jLabel39))
                            .addGap(25, 25, 25)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIdMauSac)
                                .addComponent(txtTenMau)
                                .addComponent(txtMoTaMau, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(txtIdMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(txtTenMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(txtMoTaMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(rdoMauHoatDong)
                            .addComponent(rdoMauDungHoatDong))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClearFormMau, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdateMauSac)
                            .addComponent(btnAddMauSac))))
                .addGap(0, 51, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Bảng Size", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N

        tblSize.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Mã Size", "Mô tả", "TrangThai"
            }
        ));
        tblSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSizeMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblSize);

        buttonGroup3.add(rdoDungHoatDongSize);
        rdoDungHoatDongSize.setText("Dừng hoạt động");

        jLabel43.setText("Trạng Thái");

        btnClearFormSize.setText("Clear");
        btnClearFormSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormSizeActionPerformed(evt);
            }
        });

        jLabel44.setText("Mô tả");

        btnUpdateSize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Up.png"))); // NOI18N
        btnUpdateSize.setText("Update");
        btnUpdateSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateSizeActionPerformed(evt);
            }
        });

        jLabel45.setText("Id");

        btnAddSize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnAddSize.setText("Add");
        btnAddSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSizeActionPerformed(evt);
            }
        });

        buttonGroup3.add(rdoHoatDongSize);
        rdoHoatDongSize.setSelected(true);
        rdoHoatDongSize.setText("Hoạt động");

        jLabel46.setText("Mã Size");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMaSize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                            .addComponent(txtIdSize, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMoTaSize)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btnClearFormSize, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdateSize)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddSize, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel43)
                                .addGap(18, 18, 18)
                                .addComponent(rdoHoatDongSize)
                                .addGap(18, 18, 18)
                                .addComponent(rdoDungHoatDongSize)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(txtIdSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(txtMaSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(txtMoTaSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(rdoHoatDongSize)
                            .addComponent(rdoDungHoatDongSize))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClearFormSize, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdateSize)
                            .addComponent(btnAddSize))))
                .addGap(0, 38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Màu sắc & Size", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Chất liệu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N

        tblChatLieu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Mô tả", "Trạng thái"
            }
        ));
        tblChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChatLieuMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblChatLieu);

        buttonGroup4.add(rdoDungHoatDongChatLieu);
        rdoDungHoatDongChatLieu.setText("Dừng hoạt động");

        jLabel47.setText("Trạng Thái");

        btnClearFormChatLieu.setText("Clear");
        btnClearFormChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormChatLieuActionPerformed(evt);
            }
        });

        jLabel48.setText("Mô tả");

        btnUpdateChatLieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Up.png"))); // NOI18N
        btnUpdateChatLieu.setText("Update");
        btnUpdateChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateChatLieuActionPerformed(evt);
            }
        });

        jLabel49.setText("Id");

        btnAddChatLieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnAddChatLieu.setText("Add");
        btnAddChatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddChatLieuActionPerformed(evt);
            }
        });

        buttonGroup4.add(rdoHoatDongChatLieu);
        rdoHoatDongChatLieu.setSelected(true);
        rdoHoatDongChatLieu.setText("Hoạt động");

        jLabel50.setText("Tên chất liệu");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(btnClearFormChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdateChatLieu)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel47)
                            .addGap(18, 18, 18)
                            .addComponent(rdoHoatDongChatLieu)
                            .addGap(18, 18, 18)
                            .addComponent(rdoDungHoatDongChatLieu))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel50)
                                .addComponent(jLabel48)
                                .addComponent(jLabel49))
                            .addGap(25, 25, 25)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtIdChatLieu)
                                .addComponent(txtTenChatLieu)
                                .addComponent(txtMoTaChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(txtIdChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(txtTenChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(txtMoTaChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(rdoHoatDongChatLieu)
                            .addComponent(rdoDungHoatDongChatLieu))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClearFormChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdateChatLieu)
                            .addComponent(btnAddChatLieu))))
                .addGap(0, 51, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Kiểu dáng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N

        tblKieuDang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Tên", "Giới tính", "Mô tả", "Trạng thái"
            }
        ));
        tblKieuDang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKieuDangMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblKieuDang);

        buttonGroup7.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel51.setText("Giới tính");

        btnClearFormKieuDang.setText("Clear");
        btnClearFormKieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFormKieuDangActionPerformed(evt);
            }
        });

        btnUpdateKieuDang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Up.png"))); // NOI18N
        btnUpdateKieuDang.setText("Update");
        btnUpdateKieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateKieuDangActionPerformed(evt);
            }
        });

        jLabel53.setText("Id");

        btnAddKieuDang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnAddKieuDang.setText("Add");
        btnAddKieuDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddKieuDangActionPerformed(evt);
            }
        });

        buttonGroup7.add(rdoUnisex);
        rdoUnisex.setText("Unisex");

        jLabel54.setText("Tên kiểu dáng ");

        jLabel55.setText("Mô tả");

        jLabel56.setText("Trạng Thái");

        buttonGroup5.add(rdoHoatDongKieuDang);
        rdoHoatDongKieuDang.setSelected(true);
        rdoHoatDongKieuDang.setText("Hoạt động");

        buttonGroup5.add(rdoDungHoatDongKieuDang);
        rdoDungHoatDongKieuDang.setText("Dừng hoạt động");

        buttonGroup7.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel54)
                            .addComponent(jLabel55)
                            .addComponent(jLabel51)
                            .addComponent(jLabel56))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(rdoHoatDongKieuDang)
                                .addGap(18, 18, 18)
                                .addComponent(rdoDungHoatDongKieuDang))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdoUnisex))
                            .addComponent(txtTenKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMoTaKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addGap(86, 86, 86)
                        .addComponent(txtIdKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btnClearFormKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdateKieuDang)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(txtIdKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(txtTenKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMoTaKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(rdoUnisex)
                            .addComponent(rdoNu)
                            .addComponent(rdoNam))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(rdoHoatDongKieuDang)
                            .addComponent(rdoDungHoatDongKieuDang))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClearFormKieuDang, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdateKieuDang)
                            .addComponent(btnAddKieuDang)))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Chất liệu & Kiểu dáng", jPanel3);

        btnClearNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnClearNCC.setText("Clear");
        btnClearNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearNCCActionPerformed(evt);
            }
        });

        btnUpdateNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh.png"))); // NOI18N
        btnUpdateNCC.setText("Update");
        btnUpdateNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateNCCActionPerformed(evt);
            }
        });

        btnAddNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnAddNCC.setText("Add");
        btnAddNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNCCActionPerformed(evt);
            }
        });

        tblNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Tên", "SDT", "Địa chỉ ", "Email", "Trạng thái"
            }
        ));
        tblNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhaCungCapMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblNhaCungCap);

        jLabel34.setText("SDT");

        jLabel35.setText("ID");

        jLabel36.setText("Địa chỉ");

        jLabel37.setText("Tên");

        jLabel38.setText("Email");

        jLabel1.setText("Trạng thái ");

        buttonGroup6.add(rdoHoatDongNCC);
        rdoHoatDongNCC.setSelected(true);
        rdoHoatDongNCC.setText("Hoạt động");

        buttonGroup6.add(rdoDungHoatDongNCC);
        rdoDungHoatDongNCC.setText("Dừng hoạt động");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jLabel35)
                    .addComponent(jLabel37)
                    .addComponent(jLabel34)
                    .addComponent(jLabel38)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenNhaCungCap, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(txtIdNcc, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(txtSDTNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(txtEmailNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(txtDiaChiNCC))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnUpdateNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAddNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnClearNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(rdoHoatDongNCC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoDungHoatDongNCC)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnAddNCC))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(txtIdNcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37))))
                .addGap(11, 11, 11)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnUpdateNCC)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(txtSDTNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiaChiNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmailNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnClearNCC)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rdoHoatDongNCC)
                    .addComponent(rdoDungHoatDongNCC))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nhà cung cấp ", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSizeActionPerformed
        this.sizeRepository.add(this.getFormSize());
        this.fillTableSize(sizeRepository.getAll());
         JOptionPane.showMessageDialog(this, "Thêm thành công!");
    }//GEN-LAST:event_btnAddSizeActionPerformed

    private void btnUpdateSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateSizeActionPerformed
         sizeRepository.update(this.getFormSize());
        this.fillTableSize(sizeRepository.getAll());
        JOptionPane.showMessageDialog(this, "Thêm thành công!");
    }//GEN-LAST:event_btnUpdateSizeActionPerformed

    private void tblSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSizeMouseClicked
        int row = this.tblSize.getSelectedRow();
       String id = String.valueOf(this.tblSize.getValueAt(row, 0));
       String maSize = String.valueOf(this.tblSize.getValueAt(row, 1));
       String moTa = String.valueOf(this.tblSize.getValueAt(row, 2));
       String tranThai = String.valueOf(this.tblSize.getValueAt(row, 3));
        if (tranThai.equalsIgnoreCase("Hoạt động")) {
            this.rdoHoatDongSize.setSelected(true);
        }else{
            this.rdoDungHoatDongSize.setSelected(true);
        }
       this.txtIdSize.setText(id);
       this.txtMaSize.setText(maSize);
       this.txtMoTaSize.setText(moTa);
    }//GEN-LAST:event_tblSizeMouseClicked

    private void btnAddMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMauSacActionPerformed
        this.mauSacRepository.add(this.getFormMauSac());
        this.fillTableMauSac(mauSacRepository.getAll());
        JOptionPane.showMessageDialog(this, "Thêm thành công!");
    }//GEN-LAST:event_btnAddMauSacActionPerformed

    private void btnUpdateMauSacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateMauSacActionPerformed
       this.mauSacRepository.update(this.getFormMauSac());
        this.fillTableMauSac(mauSacRepository.getAll());
        JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
    }//GEN-LAST:event_btnUpdateMauSacActionPerformed

    private void tblMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMauSacMouseClicked
       int row = this.tblMauSac.getSelectedRow();
       String id = String.valueOf(this.tblMauSac.getValueAt(row, 0));
       String tenMau = String.valueOf(this.tblMauSac.getValueAt(row, 1));
       String moTa = String.valueOf(this.tblMauSac.getValueAt(row, 2));
       String tranThai = String.valueOf(this.tblMauSac.getValueAt(row, 3));
        if (tranThai.equalsIgnoreCase("Hoạt động")) {
            this.rdoMauHoatDong.setSelected(true);
        }else{
            this.rdoMauDungHoatDong.setSelected(true);
        }
       this.txtIdMauSac.setText(id);
       this.txtTenMau.setText(tenMau);
       this.txtMoTaMau.setText(moTa);
       
    }//GEN-LAST:event_tblMauSacMouseClicked

    private void tblNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhaCungCapMouseClicked
      int row = this.tblNhaCungCap.getSelectedRow();
       String id = String.valueOf(this.tblNhaCungCap.getValueAt(row, 0));
       String tenNCc = String.valueOf(this.tblNhaCungCap.getValueAt(row, 1));
       String sDT = String.valueOf(this.tblNhaCungCap.getValueAt(row, 2));
       String diaChi = String.valueOf(this.tblNhaCungCap.getValueAt(row, 3));
       String email = String.valueOf(this.tblNhaCungCap.getValueAt(row, 4));
       String tranThai = String.valueOf(this.tblNhaCungCap.getValueAt(row, 5));
        if (tranThai.equalsIgnoreCase("Hoạt động")) {
            this.rdoHoatDongNCC.setSelected(true);
        }else{
            this.rdoDungHoatDongNCC.setSelected(true);
        }
       this.txtIdNcc.setText(id);
       this.txtTenNhaCungCap.setText(tenNCc);
       this.txtSDTNCC.setText(sDT);
       this.txtEmailNCC.setText(email);
       this.txtDiaChiNCC.setText(diaChi);
    }//GEN-LAST:event_tblNhaCungCapMouseClicked

    private void btnAddNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNCCActionPerformed
       this.nhaCungCapRepository.add(this.getFormNhaCungCap());
        this.fillTableNhaCungCap(nhaCungCapRepository.getAll());
       JOptionPane.showMessageDialog(this, "Thêm thành công!");
    }//GEN-LAST:event_btnAddNCCActionPerformed

    private void btnUpdateNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateNCCActionPerformed
        this.nhaCungCapRepository.update(this.getFormNhaCungCap());
        this.fillTableNhaCungCap(nhaCungCapRepository.getAll());
        JOptionPane.showMessageDialog(this, "Update thành công!");
    }//GEN-LAST:event_btnUpdateNCCActionPerformed

    private void btnClearNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearNCCActionPerformed
       this.txtIdNcc.setText("");
       this.txtTenNhaCungCap.setText("");
       this.txtSDTNCC.setText("");
       this.txtEmailNCC.setText("");
       this.txtDiaChiNCC.setText("");
    }//GEN-LAST:event_btnClearNCCActionPerformed

    private void rdoSanPhamNgungKinhDoanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoSanPhamNgungKinhDoanhActionPerformed
       
    }//GEN-LAST:event_rdoSanPhamNgungKinhDoanhActionPerformed

    private void tblChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChatLieuMouseClicked
      int row = this.tblChatLieu.getSelectedRow();
       String id = String.valueOf(this.tblChatLieu.getValueAt(row, 0));
       String tenChatLieu = String.valueOf(this.tblChatLieu.getValueAt(row, 1));
       String moTa = String.valueOf(this.tblChatLieu.getValueAt(row, 2));
       String tranThai = String.valueOf(this.tblChatLieu.getValueAt(row, 3));
        if (tranThai.equalsIgnoreCase("Hoạt động")) {
            this.rdoHoatDongChatLieu.setSelected(true);
        }else{
            this.rdoDungHoatDongChatLieu.setSelected(true);
        }
       this.txtIdChatLieu.setText(id);
       this.txtTenChatLieu.setText(tenChatLieu);
       this.txtMoTaChatLieu.setText(moTa);
    }//GEN-LAST:event_tblChatLieuMouseClicked

    private void btnUpdateChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateChatLieuActionPerformed
       this.chatLieuRepository.update(this.getFormChatLieu());
       this.fillTableChatLieu(chatLieuRepository.getAll());
       JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
    }//GEN-LAST:event_btnUpdateChatLieuActionPerformed

    private void btnAddChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddChatLieuActionPerformed
         this.chatLieuRepository.add(this.getFormChatLieu());
       this.fillTableChatLieu(chatLieuRepository.getAll());
       JOptionPane.showMessageDialog(this, "Thêm thành công!");
    }//GEN-LAST:event_btnAddChatLieuActionPerformed

    private void tblKieuDangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKieuDangMouseClicked
         int row = this.tblKieuDang.getSelectedRow();
       String id = String.valueOf(this.tblKieuDang.getValueAt(row, 0));
       String tenKieuDang = String.valueOf(this.tblKieuDang.getValueAt(row, 1));
       String gioiTinh = String.valueOf(this.tblKieuDang.getValueAt(row, 2));
       String moTa = String.valueOf(this.tblKieuDang.getValueAt(row, 3));
       String tranThai = String.valueOf(this.tblKieuDang.getValueAt(row, 4));
        if (gioiTinh.equalsIgnoreCase("Nam")) {
            this.rdoNam.setSelected(true);
        }else if (gioiTinh.equalsIgnoreCase("Nữ")) {
            this.rdoNu.setSelected(true);
        }else{
            this.rdoUnisex.setSelected(true);
        }

       if (tranThai.equalsIgnoreCase("Hoạt động")) {
            this.rdoHoatDongChatLieu.setSelected(true);
        }else{
            this.rdoDungHoatDongChatLieu.setSelected(true);
        }
       this.txtIdKieuDang.setText(id);
       this.txtTenKieuDang.setText(tenKieuDang);
       this.txtMoTaKieuDang.setText(moTa);
    }//GEN-LAST:event_tblKieuDangMouseClicked

    private void btnUpdateKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateKieuDangActionPerformed
        this.kieuDangRepository.update(this.getFormKieuDang());
        this.fillTableKieuDang(kieuDangRepository.getAll());
       JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
    }//GEN-LAST:event_btnUpdateKieuDangActionPerformed

    private void btnAddKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddKieuDangActionPerformed
        this.kieuDangRepository.update(this.getFormKieuDang());
        this.fillTableKieuDang(kieuDangRepository.getAll());
       JOptionPane.showMessageDialog(this, "Thêm thành công!");
    }//GEN-LAST:event_btnAddKieuDangActionPerformed

    private void btnClearFormMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormMauActionPerformed
        this.txtIdMauSac.setText("");
        this.txtTenMau.setText("");
        this.txtMoTaMau.setText("");
    }//GEN-LAST:event_btnClearFormMauActionPerformed

    private void btnClearFormSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormSizeActionPerformed
        this.txtIdSize.setText("");
       this.txtMaSize.setText("");
       this.txtMoTaSize.setText("");
    }//GEN-LAST:event_btnClearFormSizeActionPerformed

    private void btnClearFormKieuDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormKieuDangActionPerformed
        this.txtIdKieuDang.setText("");
       this.txtTenKieuDang.setText("");
       this.txtMoTaKieuDang.setText("");
    }//GEN-LAST:event_btnClearFormKieuDangActionPerformed

    private void btnClearFormChatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFormChatLieuActionPerformed
        this.txtIdChatLieu.setText("");
       this.txtTenChatLieu.setText("");
       this.txtMoTaChatLieu.setText("");
    }//GEN-LAST:event_btnClearFormChatLieuActionPerformed

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int row = this.tblSanPham.getSelectedRow();
        String idSp = String.valueOf(this.tblSanPham.getValueAt(row, 0));
        String tenSp = String.valueOf(this.tblSanPham.getValueAt(row, 1));
        String maSp = String.valueOf(this.tblSanPham.getValueAt(row, 2));
        String moTa = String.valueOf(this.tblSanPham.getValueAt(row, 3));
        String idChatLieu = String.valueOf(this.tblSanPham.getValueAt(row, 4));
        String idKieuDang = String.valueOf(this.tblSanPham.getValueAt(row, 5));
        String idSize = String.valueOf(this.tblSanPham.getValueAt(row, 6));
        String idMauSac = String.valueOf(this.tblSanPham.getValueAt(row, 7));
        String idNhaCungCap = String.valueOf(this.tblSanPham.getValueAt(row, 8));
        String giaNhap = String.valueOf(this.tblSanPham.getValueAt(row, 9));
        String giaBan = String.valueOf(this.tblSanPham.getValueAt(row, 10));
        String SoLuong = String.valueOf(this.tblSanPham.getValueAt(row, 11));
        String trangThai = String.valueOf(this.tblSanPham.getValueAt(row, 12));
        if (trangThai.equalsIgnoreCase("Kinh Doanh")) {
            this.rdoSanPhamKinhDoanh.setSelected(true);
        }else{
            this.rdoSanPhamNgungKinhDoanh.setSelected(true);
        }
        
        this.txtIdSanPham.setText(idSp);
        this.txtTenSanPham.setText(tenSp);
        this.txtMaSanPham.setText(maSp);
        this.txtMoTaSanPham.setText(moTa);
        this.cbbChatLieu.setSelectedItem(idChatLieu);
        this.cbbKieuDang.setSelectedItem(idKieuDang);
        this.cbbSize.setSelectedItem(idSize);
        this.cbbMauSac.setSelectedItem(idMauSac);
        this.cbbNhaCungCap.setSelectedItem(idNhaCungCap);
        this.txtGiaBan.setText(giaBan);
        this.txtGiaNHap.setText(giaNhap);
        this.txtSoLuongSanPham.setText(SoLuong);
        Integer idSpHienThiAnh = Integer.valueOf(idSp);
       this.hienThiAnhTheoSanPham(idSpHienThiAnh, JlbHinhAnh);
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnClearSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSanPhamActionPerformed
        this.txtIdSanPham.setText("");
        this.txtTenSanPham.setText("");
        this.txtMaSanPham.setText("");
        this.txtMoTaSanPham.setText("");
         this.txtGiaBan.setText("");
        this.txtGiaNHap.setText("");
        this.txtSoLuongSanPham.setText("");
    }//GEN-LAST:event_btnClearSanPhamActionPerformed

    private void btnAddSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSanPhamActionPerformed
//        int row = this.tblSanPham.getSelectedRow();
//        String id = String.valueOf(this.tblSanPham.getValueAt(row, 0));
//        Integer idSp = Integer.valueOf(id);
//        String url = this.txtURLAnh.getText();
//        this.sanPhamRepository.add(this.getFormSanPham());    
//        this.hinhAnhRepository.add(new HinhAnh(null, idSp, url, "", ""));
//         this.fillTable(sanPhamRepository.getAll());
//        JOptionPane.showMessageDialog(this, "Thêm thành công!");

 // Thêm sản phẩm vào DB
    SanPham sanPham = this.getFormSanPham();
    this.sanPhamRepository.add(sanPham);

    // Lấy lại Id sản phẩm vừa thêm (tốt nhất nên có hàm trả về Id)
    int idSpMoi = this.sanPhamRepository.getIdSanPhamMoiNhat(); // bạn cần thêm hàm này

    // Thêm ảnh tương ứng
    String url = txtURLAnh.getText();
    HinhAnh hinhAnh = new HinhAnh(null, idSpMoi, url, "", "");
    this.hinhAnhRepository.add(hinhAnh);

    // Làm mới bảng
    this.fillTable(this.sanPhamRepository.getAll());
    JOptionPane.showMessageDialog(this, "Thêm sản phẩm và ảnh thành công!");
    }//GEN-LAST:event_btnAddSanPhamActionPerformed

    private void btnUpDateSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpDateSanPhamActionPerformed

 int row = tblSanPham.getSelectedRow();
    if (row == -1) return;

    // Cập nhật sản phẩm
    SanPham sanPham = this.getFormSanPham();
    this.sanPhamRepository.update(sanPham);

    // Cập nhật ảnh tương ứng
    int idSp = sanPham.getId();
    String url = txtURLAnh.getText();

    // Xóa ảnh cũ (nếu muốn) và thêm mới
    this.hinhAnhRepository.deleteByIdSanPham(idSp);
    this.hinhAnhRepository.add(new HinhAnh(null, idSp, url, "", ""));

    this.fillTable(this.sanPhamRepository.getAll());
    JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm và ảnh thành công!");
    }//GEN-LAST:event_btnUpDateSanPhamActionPerformed

    public ImageIcon ResizeImage(String ImagePath){
        ImageIcon imageIcon = new ImageIcon(ImagePath);
        Image img = imageIcon.getImage();
        Image newImg = img.getScaledInstance(JlbHinhAnh.getWidth(), JlbHinhAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    private void btnDoiAnhSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiAnhSanPhamActionPerformed
        try {
            JFileChooser f = new JFileChooser(new File("src/img"));
            f.setDialogTitle("Mở file");
            f.showOpenDialog(null);
            File ftenanh = f.getSelectedFile();       
            duongDanAnh = ftenanh.getAbsolutePath();
            if(duongDanAnh != null){
                JlbHinhAnh.setIcon(ResizeImage(String.valueOf(duongDanAnh)));
                this.txtURLAnh.setText(duongDanAnh);
            }else{
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn ảnh nào");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnDoiAnhSanPhamActionPerformed

    
public void loadAnh(JLabel lbl, String path) {
    try {
        File file = new File(path);
        ImageIcon icon;

        if (file.exists()) {
            // Load ảnh từ ổ đĩa
            icon = new ImageIcon(file.getAbsolutePath());
        } else {
            // Load ảnh từ resource
            if (path.startsWith("/")) path = path.substring(1);
            URL url = getClass().getClassLoader().getResource(path);
            if (url == null) {
                lbl.setText("Không tìm thấy ảnh");
                System.err.println("Ảnh không tồn tại trong resource: " + path);
                return;
            }
            icon = new ImageIcon(url);
        }

        Image img = icon.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH);
        lbl.setIcon(new ImageIcon(img));
    } catch (Exception e) {
        lbl.setText("Lỗi khi load ảnh");
        e.printStackTrace();
    }
}

    
    public void hienThiAnhTheoSanPham(int idSanPham, JLabel lblAnh) {
    HinhAnhRepository repo = new HinhAnhRepository();
    HinhAnh ha = repo.getAll(idSanPham);

    if (ha != null) {
        loadAnh(lblAnh, ha.getUrl());
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JlbHinhAnh;
    private javax.swing.JButton btnAddChatLieu;
    private javax.swing.JButton btnAddKieuDang;
    private javax.swing.JButton btnAddMauSac;
    private javax.swing.JButton btnAddNCC;
    private javax.swing.JButton btnAddSanPham;
    private javax.swing.JButton btnAddSize;
    private javax.swing.JButton btnClearFormChatLieu;
    private javax.swing.JButton btnClearFormKieuDang;
    private javax.swing.JButton btnClearFormMau;
    private javax.swing.JButton btnClearFormSize;
    private javax.swing.JButton btnClearNCC;
    private javax.swing.JButton btnClearSanPham;
    private javax.swing.JButton btnDoiAnhSanPham;
    private javax.swing.JButton btnSearchSanPham;
    private javax.swing.JButton btnUpDateSanPham;
    private javax.swing.JButton btnUpdateChatLieu;
    private javax.swing.JButton btnUpdateKieuDang;
    private javax.swing.JButton btnUpdateMauSac;
    private javax.swing.JButton btnUpdateNCC;
    private javax.swing.JButton btnUpdateSize;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.JComboBox<String> cbbChatLieu;
    private javax.swing.JComboBox<String> cbbKieuDang;
    private javax.swing.JComboBox<String> cbbMauSac;
    private javax.swing.JComboBox<String> cbbNhaCungCap;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoDungHoatDongChatLieu;
    private javax.swing.JRadioButton rdoDungHoatDongKieuDang;
    private javax.swing.JRadioButton rdoDungHoatDongNCC;
    private javax.swing.JRadioButton rdoDungHoatDongSize;
    private javax.swing.JRadioButton rdoHoatDongChatLieu;
    private javax.swing.JRadioButton rdoHoatDongKieuDang;
    private javax.swing.JRadioButton rdoHoatDongNCC;
    private javax.swing.JRadioButton rdoHoatDongSize;
    private javax.swing.JRadioButton rdoMauDungHoatDong;
    private javax.swing.JRadioButton rdoMauHoatDong;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoSanPhamKinhDoanh;
    private javax.swing.JRadioButton rdoSanPhamNgungKinhDoanh;
    private javax.swing.JRadioButton rdoUnisex;
    private javax.swing.JTable tblChatLieu;
    private javax.swing.JTable tblKieuDang;
    private javax.swing.JTable tblMauSac;
    private javax.swing.JTable tblNhaCungCap;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblSize;
    private javax.swing.JTextField txtDiaChiNCC;
    private javax.swing.JTextField txtEmailNCC;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaNHap;
    private javax.swing.JTextField txtIdChatLieu;
    private javax.swing.JTextField txtIdKieuDang;
    private javax.swing.JTextField txtIdMauSac;
    private javax.swing.JTextField txtIdNcc;
    private javax.swing.JTextField txtIdSanPham;
    private javax.swing.JTextField txtIdSize;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtMaSize;
    private javax.swing.JTextField txtMoTaChatLieu;
    private javax.swing.JTextField txtMoTaKieuDang;
    private javax.swing.JTextField txtMoTaMau;
    private javax.swing.JTextArea txtMoTaSanPham;
    private javax.swing.JTextField txtMoTaSize;
    private javax.swing.JTextField txtSDTNCC;
    private javax.swing.JTextField txtSoLuongSanPham;
    private javax.swing.JTextField txtTenChatLieu;
    private javax.swing.JTextField txtTenKieuDang;
    private javax.swing.JTextField txtTenMau;
    private javax.swing.JTextField txtTenNhaCungCap;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTimKiemSanPham;
    private javax.swing.JTextField txtURLAnh;
    // End of variables declaration//GEN-END:variables
}
