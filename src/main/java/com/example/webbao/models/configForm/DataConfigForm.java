package com.example.webbao.models.configForm;

import javax.persistence.*;

@Entity
public class DataConfigForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "codeForm", columnDefinition = "TEXT")
    private String codeForm;

    @Column(name = "urlMapping", columnDefinition = "TEXT")
    private String urlMapping;

    @Column(name = "dataForm", columnDefinition = "TEXT")
    private String dataForm;

    @Column(name = "idForm")
    private String idForm;

    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    public DataConfigForm() {
    }

    public DataConfigForm(Long id, String codeForm, String urlMapping, String dataForm, String idForm, String ngayTaoBanGhi, String ngayChinhSua, Boolean flag) {
        this.id = id;
        this.codeForm = codeForm;
        this.urlMapping = urlMapping;
        this.dataForm = dataForm;
        this.idForm = idForm;
        this.ngayTaoBanGhi = ngayTaoBanGhi;
        this.ngayChinhSua = ngayChinhSua;
        this.flag = flag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeForm() {
        return codeForm;
    }

    public void setCodeForm(String codeForm) {
        this.codeForm = codeForm;
    }

    public String getUrlMapping() {
        return urlMapping;
    }

    public void setUrlMapping(String urlMapping) {
        this.urlMapping = urlMapping;
    }

    public String getDataForm() {
        return dataForm;
    }

    public void setDataForm(String dataForm) {
        this.dataForm = dataForm;
    }

    public String getIdForm() {
        return idForm;
    }

    public void setIdForm(String idForm) {
        this.idForm = idForm;
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