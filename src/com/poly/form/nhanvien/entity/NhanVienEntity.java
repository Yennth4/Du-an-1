/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.form.nhanvien.entity;

//import java.sql.Date;
import java.util.Date;


public class NhanVienEntity {

    private int id;
    private String username;
    private String ten;
    private String maDinhDanh;
    private String soDienThoai;
    private Date ngaySinh;
    private String email;
    private String gioiTinh;
    private String diaChi;
    private String trangThai;
    private Date thoiGianTao;
    private Date thoiGianSua;

    public NhanVienEntity() {
    }

    public NhanVienEntity(int id, String username, String ten, String maDinhDanh, String soDienThoai, Date ngaySinh, String email, String gioiTinh, String diaChi, String trangThai, Date thoiGianTao, Date thoiGianSua) {
        this.id = id;
        this.username = username;
        this.ten = ten;
        this.maDinhDanh = maDinhDanh;
        this.soDienThoai = soDienThoai;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
        this.thoiGianTao = thoiGianTao;
        this.thoiGianSua = thoiGianSua;
    }

    public NhanVienEntity(String username, String ten, String maDinhDanh, String soDienThoai, Date ngaySinh, String email, String gioiTinh, String diaChi, String trangThai, Date thoiGianTao, Date thoiGianSua) {
        this.username = username;
        this.ten = ten;
        this.maDinhDanh = maDinhDanh;
        this.soDienThoai = soDienThoai;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
        this.thoiGianTao = thoiGianTao;
        this.thoiGianSua = thoiGianSua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMaDinhDanh() {
        return maDinhDanh;
    }

    public void setMaDinhDanh(String maDinhDanh) {
        this.maDinhDanh = maDinhDanh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Date thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public Date getThoiGianSua() {
        return thoiGianSua;
    }

    public void setThoiGianSua(Date thoiGianSua) {
        this.thoiGianSua = thoiGianSua;
    }


    public Object[] todataRow() {
        return new Object[]{
           id, username, ten, email, soDienThoai, gioiTinh, trangThai, ngaySinh, diaChi, maDinhDanh, thoiGianTao, thoiGianSua
        };
    }
}
