package com.example.webbao.models.danhmuc.manage_banner;

import javax.persistence.*;

@Entity
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="src" ,columnDefinition = "TEXT")
    private String src;
    @Column(name="height" ,columnDefinition = "TEXT")
    private String height;
    @Column(name="width" ,columnDefinition = "TEXT")
    private String width;
    @Column(name="tag" ,columnDefinition = "TEXT")
    private String tag;
    @Column(name="thuocNhom" ,columnDefinition = "TEXT")
    private String thuocNhom;
    private Boolean bannerNoiBat;
    private Long nguoiTaoId;
    private Long stt;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    public Banner() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Boolean getBannerNoiBat() {
        return bannerNoiBat;
    }

    public void setBannerNoiBat(Boolean bannerNoiBat) {
        this.bannerNoiBat = bannerNoiBat;
    }

    public Long getStt() {
        return stt;
    }

    public void setStt(Long stt) {
        this.stt = stt;
    }

    public String getThuocNhom() {
        return thuocNhom;
    }

    public void setThuocNhom(String thuocNhom) {
        this.thuocNhom = thuocNhom;
    }
}
