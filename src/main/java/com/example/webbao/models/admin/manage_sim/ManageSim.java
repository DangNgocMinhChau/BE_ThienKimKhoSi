package com.example.webbao.models.admin.manage_sim;

import javax.persistence.*;

@Entity
public class ManageSim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numberSeri;
    private String numberPhone;
    private String nameSim;
    private String typeSim;
    @Column(name="email" ,columnDefinition = "TEXT")
    private String email;
    @Column(name="social" ,columnDefinition = "TEXT")
    private String social;
    @Column(name="HSDSim" ,columnDefinition = "TEXT")
    private String HSDSim;
    @Column(name="password" ,columnDefinition = "TEXT")
    private String password;
    @Column(name="noteSim" ,columnDefinition = "TEXT")
    private String noteSim;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    public ManageSim() {

    }

    public ManageSim(Long id, String numberSeri, String numberPhone, String nameSim, String typeSim, String email, String social, String HSDSim, String password) {
        this.id = id;
        this.numberSeri = numberSeri;
        this.numberPhone = numberPhone;
        this.nameSim = nameSim;
        this.typeSim = typeSim;
        this.email = email;
        this.social = social;
        this.HSDSim = HSDSim;
        this.password = password;
    }

    public Long getId() {
        return id;
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

    public String getNameSim() {
        return nameSim;
    }

    public void setNameSim(String nameSim) {
        this.nameSim = nameSim;
    }

    public String getTypeSim() {
        return typeSim;
    }

    public void setTypeSim(String typeSim) {
        this.typeSim = typeSim;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    public String getHSDSim() {
        return HSDSim;
    }

    public void setHSDSim(String HSDSim) {
        this.HSDSim = HSDSim;
    }

    public String getNoteSim() {
        return noteSim;
    }

    public void setNoteSim(String noteSim) {
        this.noteSim = noteSim;
    }
}
