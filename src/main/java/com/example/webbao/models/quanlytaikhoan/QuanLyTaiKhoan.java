package com.example.webbao.models.quanlytaikhoan;

import com.example.webbao.models.danhmuc.quyen.Quyen;

import javax.persistence.*;

@Entity
public class QuanLyTaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tenNguoiDung;
    private String tenDangNhap;
    private String matKhau;
    private String xacNhanMatKhau;
    private String matKhauGoc;
    private String ngaySinh;
    private String gioiTinh;
    private String facebook;
    private String soDienThoai;
    private String cmnd;
    @Column(name="tag" ,columnDefinition = "TEXT")
    private String img;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;
    private Boolean lockUser;
    private Integer soLanDangNhapSai;

    @ManyToOne
    @JoinColumn(name = "quyen_id", nullable = false)
    private Quyen quyen;

    public QuanLyTaiKhoan() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getXacNhanMatKhau() {
        return xacNhanMatKhau;
    }

    public void setXacNhanMatKhau(String xacNhanMatKhau) {
        this.xacNhanMatKhau = xacNhanMatKhau;
    }

    public String getMatKhauGoc() {
        return matKhauGoc;
    }

    public void setMatKhauGoc(String matKhauGoc) {
        this.matKhauGoc = matKhauGoc;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNgayTaoBanGhi() {
        return ngayTaoBanGhi;
    }

    public void setNgayTaoBanGhi(String ngayTaoBanGhi) {
        this.ngayTaoBanGhi = ngayTaoBanGhi;
    }

    public String getNgayChinhSua() {
        return ngayChinhSua;
    }

    public void setNgayChinhSua(String ngayChinhSua) {
        this.ngayChinhSua = ngayChinhSua;
    }

    public Quyen getQuyen() {
        return quyen;
    }

    public void setQuyen(Quyen quyen) {
        this.quyen = quyen;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Boolean getLockUser() {
        return lockUser;
    }

    public void setLockUser(Boolean lockUser) {
        this.lockUser = lockUser;
    }

    public Integer getSoLanDangNhapSai() {
        return soLanDangNhapSai;
    }

    public void setSoLanDangNhapSai(Integer soLanDangNhapSai) {
        this.soLanDangNhapSai = soLanDangNhapSai;
    }
}
