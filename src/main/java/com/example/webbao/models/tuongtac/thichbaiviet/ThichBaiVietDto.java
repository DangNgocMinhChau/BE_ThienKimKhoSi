package com.example.webbao.models.tuongtac.thichbaiviet;

public class ThichBaiVietDto {
    private Long id;
    private Long idUser;
    private Long idBaiViet;
    private String daLike;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    public ThichBaiVietDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdBaiViet() {
        return idBaiViet;
    }

    public void setIdBaiViet(Long idBaiViet) {
        this.idBaiViet = idBaiViet;
    }

    public String getDaLike() {
        return daLike;
    }

    public void setDaLike(String daLike) {
        this.daLike = daLike;
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
}
