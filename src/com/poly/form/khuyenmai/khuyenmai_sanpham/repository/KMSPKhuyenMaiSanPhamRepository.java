package com.poly.form.khuyenmai.khuyenmai_sanpham.repository;

import com.poly.database.DBConnect;
import com.poly.form.khuyenmai.khuyenmai_sanpham.entity.KhuyenMaiTheoSanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class KMSPKhuyenMaiSanPhamRepository {

    public void themKhuyenMaiSanPham(Long idKM, Long id)
            throws Exception {
        String query = "INSERT INTO sanphamchitiet_khuyenmai (id_khuyen_mai, id_san_pham_chi_tiet) VALUES (?, ?)";
        try (Connection conn = DBConnect.getConnection(); PreparedStatement ps
                = conn.prepareStatement(query)) {
            ps.setLong(1, idKM);
            ps.setLong(2, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public boolean tonTai(String ten) throws Exception {
        String query = "SELECT * FROM khuyen_mai WHERE ten_khuyen_mai = ?";
        try (Connection conn = DBConnect.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, ten);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Check if there are any results
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Return false if there's an exception or no results
    }

//    public static void main(String[] args) {
//        KMSPKhuyenMaiSanPhamRepository repository = new KMSPKhuyenMaiSanPhamRepository();
//        try {
//            boolean tonTai = repository.tonTai("Khuyến mãi");
//            System.out.println("Ton tai: " + tonTai);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
}
