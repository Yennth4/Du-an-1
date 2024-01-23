package com.poly.form.doihang.view;

import com.formdev.flatlaf.FlatClientProperties;
import com.poly.Application;
import com.poly.form.doihang.entity.DoiHangResponse.HoaDon;
import com.poly.form.doihang.entity.DoiHangResponse.ProductDetailResponse;
import com.poly.menu.Menu;
import com.poly.form.doihang.service.DoiHangService.impl.PhieuDoiService;
import com.poly.form.doihang.service.DoiHangService.impl.ProductDetailService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import raven.toast.Notifications;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Raven
 */
public class FormQuanLyDoiHang extends javax.swing.JPanel {

    private Long idHoaDon = 0L;
    private ProductDetailService productDetailService = new ProductDetailService();
    private Map<String, ProductDetailResponse> listIdDaDoi = new HashMap<>();
    private Menu menu;
    private DoiHangConfigs doiHangConfigs;
    private DefaultTableModel tableModel = new DefaultTableModel();
    private DefaultTableModel tableDoi = new DefaultTableModel();
    private PhieuDoiService phieuDoiService = new PhieuDoiService();
    private Map<String, HoaDon> mapHoaDon = new HashMap<>();
    private Long id;

    public FormQuanLyDoiHang(Menu menu, DoiHangConfigs doiHangConfigs) {
        this.menu = menu;
        this.doiHangConfigs = doiHangConfigs;
        initComponents();
        Title.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        tblListHoaDon.setModel(tableModel);
        showTable(phieuDoiService.getAll3Day(txtSearch.getText(), 1));
        showCBX();
    }

    public void showCBX() {
//        cbxTrangThai.removeAllItems();
//        cbxTrangThai.addItem("Đã hoàn thành");
//        cbxTrangThai.addItem("Chưa hoàn thành");
    }

    public void showTable(List<HoaDon> list) {
        tableModel.setRowCount(0);
        tableModel.setColumnIdentifiers(new Object[]{"STT", "Mã HD", "tên khách", "Sdt", "tổng tiền", "Ngày tạo"});
        mapHoaDon = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            HoaDon hoaDon = list.get(i);
            mapHoaDon.put(hoaDon.getMaHoaDon(), hoaDon);
            tableModel.addRow(new Object[]{i + 1, hoaDon.getMaHoaDon(),
                hoaDon.getTenKhachHang(), hoaDon.getSdt(), new BigDecimal(hoaDon.getTongTienHoaDon()) + "₫", hoaDon.getThoiGianTao()});
        }
    }

    public void clear() {
        txtMa.setText("");
        txtTen.setText("");
        txtSDT.setText("");
        txtNgayTao.setText("");
        txtTongTien.setText("");
    }

    public void showDetail(HoaDon hd) {
        txtMa.setText(hd.getMaHoaDon());
        txtTen.setText(hd.getTenKhachHang());
        txtSDT.setText(hd.getSdt());
        txtNgayTao.setText(hd.getThoiGianTao().toString());
        txtTongTien.setText(hd.getTongTienHoaDon() + "₫");
    }

    public void showTableDoi(List<ProductDetailResponse> list) {
        tblDoi.setModel(tableDoi);
        tableDoi.setRowCount(0);
        tableDoi.setColumnIdentifiers(new Object[]{"STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Lý do", "Loại"});
        listIdDaDoi = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            ProductDetailResponse response = list.get(i);
            listIdDaDoi.put("SP00" + response.getIdsanphamdetail(), response);
            tableDoi.addRow(new Object[]{i + 1, response.getMaSanPham(), response.getTenSanPham(),
                response.getSoLuong(), new BigDecimal(response.getGiaTien()) + "₫", response.getLyDoDoi(), response.getLoai()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListHoaDon = new javax.swing.JTable();
        ctnBoLoc = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnXemChiTiet = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDoi = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnXacNhan = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtTen = new javax.swing.JTextField();
        txtMa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();

        Title.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Đổi Hàng");

        tblListHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hd", "Tên khách", "SDT", "Tổng tiền", "Ngày tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblListHoaDon.setRowHeight(50);
        tblListHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListHoaDon);
        if (tblListHoaDon.getColumnModel().getColumnCount() > 0) {
            tblListHoaDon.getColumnModel().getColumn(0).setMaxWidth(30);
            tblListHoaDon.getColumnModel().getColumn(1).setMaxWidth(70);
        }

        ctnBoLoc.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bộ lọc hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Tìm kiếm");

        javax.swing.GroupLayout ctnBoLocLayout = new javax.swing.GroupLayout(ctnBoLoc);
        ctnBoLoc.setLayout(ctnBoLocLayout);
        ctnBoLocLayout.setHorizontalGroup(
            ctnBoLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctnBoLocLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ctnBoLocLayout.setVerticalGroup(
            ctnBoLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ctnBoLocLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(ctnBoLocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTitle.setText("Hóa đơn đã hoàn thành trong 3 ngày");

        btnXemChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnXemChiTiet.setForeground(new java.awt.Color(102, 204, 255));
        btnXemChiTiet.setText("Xem chi tiết");
        btnXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiTietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(120, 120, 120)
                        .addComponent(btnXemChiTiet))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                    .addComponent(ctnBoLoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ctnBoLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXemChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phiếu đổi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        tblDoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Lý do"
            }
        ));
        tblDoi.setRowHeight(50);
        tblDoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDoiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDoi);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Sản phẩm đổi");

        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnXacNhan.setForeground(new java.awt.Color(102, 255, 102));
        btnXacNhan.setText("Xác nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N

        txtTen.setEditable(false);
        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMa.setEditable(false);
        txtMa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Mã hóa đơn");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tên khách hàng");

        txtSDT.setEditable(false);
        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Số điện thoại");

        txtTongTien.setEditable(false);
        txtTongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tổng tiền");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Ngày tạo");

        txtNgayTao.setEditable(false);
        txtNgayTao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(39, 39, 39))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10))
                                        .addGap(40, 40, 40)))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                                        .addComponent(txtSDT))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(48, 48, 48)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Title)
                .addGap(482, 482, 482))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed
    public List<ProductDetailResponse> showSPChiTiet() {
        Long id = null;
        for (HoaDon hoaDon : phieuDoiService.getAll3Day(txtSearch.getText(), 1)) {
            if (hoaDon.getMaHoaDon().trim().equalsIgnoreCase((String) tblListHoaDon.getValueAt(tblListHoaDon.getSelectedRow(), 1))) {
                id = hoaDon.getId();
                this.idHoaDon = hoaDon.getId();
                showDetail(hoaDon);
            }
        }
        if (id != null) {
            this.id = id;
            showTableDoi(productDetailService.sanPhamDaDoi(id));
        }

        return productDetailService.sanPhamDaDoi(id);
    }
    private void tblListHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListHoaDonMouseClicked
        showSPChiTiet();
    }//GEN-LAST:event_tblListHoaDonMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        showTable(phieuDoiService.getAll3Day(txtSearch.getText(), 1));
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietActionPerformed
        int i = tblListHoaDon.getSelectedRow();
        if (i != -1) {
            for (Map.Entry<String, HoaDon> hoaDon : mapHoaDon.entrySet()) {
                String key = hoaDon.getKey();
                if (key.equalsIgnoreCase((String) tblListHoaDon.getValueAt(i, 1))) {
                    doiHangConfigs.setIdHD(hoaDon.getValue().getId());
                }
            }
            doiHangConfigs.setMaHoaDon((String) tblListHoaDon.getValueAt(i, 1));
            new ChiTietHoaDon(doiHangConfigs, menu, this).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Hãy chọn hóa đơn");
        }

    }//GEN-LAST:event_btnXemChiTietActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        if (id != null && productDetailService.sanPhamDaDoi(id).size() > 0) {
            int i = JOptionPane.showConfirmDialog(this, "Xác nhận đổi", "Xác Nhận?", JOptionPane.YES_NO_OPTION);
            if (i == 0) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Đổi thành công");
            }
            List<ProductDetailResponse> list = new ArrayList<>();
            showTableDoi(list);
            clear();
            id=null;
        } else {
            Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Hãy chọn sản phẩm để đổi!");
        }

    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void tblDoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDoiMouseClicked
        int index = tblDoi.getSelectedRow();
        List<ProductDetailResponse> list = showSPChiTiet();
        new UpdateSanPhamDoi(list.get(index), idHoaDon, this).setVisible(true);
    }//GEN-LAST:event_tblDoiMouseClicked

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JPanel ctnBoLoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblDoi;
    private javax.swing.JTable tblListHoaDon;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
