package com.example.webbao.models.danhmuc.manage_banner;

public class BannerDto {
    private Long id;
    private String src;
    private String height ;
    private String width;
    private String tenNguoiTao;
    private String tag;
    private Long nguoiTaoId;
    private Long stt;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;
    private Boolean bannerNoiBat;
    private String thuocNhom;

    public BannerDto() {
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

    public String getTenNguoiTao() {
        return tenNguoiTao;
    }

    public void setTenNguoiTao(String tenNguoiTao) {
        this.tenNguoiTao = tenNguoiTao;
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
