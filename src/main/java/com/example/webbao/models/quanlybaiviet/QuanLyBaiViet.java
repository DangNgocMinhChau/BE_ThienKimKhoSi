package com.example.webbao.models.quanlybaiviet;

import javax.persistence.*;

@Entity
public class QuanLyBaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="noiDung" ,columnDefinition = "TEXT")
    private String noiDung;
    @Column(name="tag" ,columnDefinition = "TEXT")
    private String tag;
    @Column(name="tieuDe" ,columnDefinition = "TEXT")
    private String tieuDe;
    @Column(name="gioiThieu" ,columnDefinition = "TEXT")
    private String gioiThieu;
    @Column(name="file" ,columnDefinition = "TEXT")
    private String file;
    @Column(name="tenFile" ,columnDefinition = "TEXT")
    private String tenFile;
    @Column(name="imgAvatar" ,columnDefinition = "TEXT")
    private String imgAvatar;
    private String trangThai;
    @Column(name="lyDoKhongDuyet" ,columnDefinition = "TEXT")
    private String lyDoKhongDuyet;
    private Integer view;
    private Long nguoiTaoId;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    public QuanLyBaiViet() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public Long getNguoiTaoId() {
        return nguoiTaoId;
    }

    public void setNguoiTaoId(Long nguoiTaoId) {
        this.nguoiTaoId = nguoiTaoId;
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

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getGioiThieu() {
        return gioiThieu;
    }

    public void setGioiThieu(String gioiThieu) {
        this.gioiThieu = gioiThieu;
    }

    public String getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(String imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

    public String getTenFile() {
        return tenFile;
    }

    public void setTenFile(String tenFile) {
        this.tenFile = tenFile;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public String getLyDoKhongDuyet() {
        return lyDoKhongDuyet;
    }

    public void setLyDoKhongDuyet(String lyDoKhongDuyet) {
        this.lyDoKhongDuyet = lyDoKhongDuyet;
    }
}
