package com.example.webbao.models.pageManager.sim;

import javax.persistence.*;

@Entity
public class Sim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numberSeri;
    private String numberPhone;
    private String typeSim;
    @Column(name="hsdsim" ,columnDefinition = "TEXT")
    private String hsdsim;

    private Long nguoiTaoId;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    public Sim() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberSeri() {
        return numberSeri;
    }

    public void setNumberSeri(String numberSeri) {
        this.numberSeri = numberSeri;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getTypeSim() {
        return typeSim;
    }

    public void setTypeSim(String typeSim) {
        this.typeSim = typeSim;
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

    public String getHsdsim() {
        return hsdsim;
    }

    public void setHsdsim(String hsdsim) {
        this.hsdsim = hsdsim;
    }
}


