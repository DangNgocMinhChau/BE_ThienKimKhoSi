package com.example.webbao.models.orderform;

import javax.persistence.*;

@Entity
public class OrderForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="url" ,columnDefinition = "TEXT")
    private String url;

    @Column(name="Api" ,columnDefinition = "TEXT")
    private String Api;

    @Column(name="formName" ,columnDefinition = "TEXT")
    private String formName;

    @Column(name="typeForms" ,columnDefinition = "TEXT")
    private String typeForms;

    @Column(name="notes" ,columnDefinition = "TEXT")
    private String notes;

    @Column(name="formMapping" ,columnDefinition = "TEXT")
    private String formMapping;

    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    public OrderForm() {
    }

    public OrderForm(Long id, String url, String api, String formName, String typeForms, String notes, String formMapping, String ngayTaoBanGhi, String ngayChinhSua, Boolean flag) {
        this.id = id;
        this.url = url;
        Api = api;
        this.formName = formName;
        this.typeForms = typeForms;
        this.notes = notes;
        this.formMapping = formMapping;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApi() {
        return Api;
    }

    public void setApi(String api) {
        Api = api;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getTypeForms() {
        return typeForms;
    }

    public void setTypeForms(String typeForms) {
        this.typeForms = typeForms;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFormMapping() {
        return formMapping;
    }

    public void setFormMapping(String formMapping) {
        this.formMapping = formMapping;
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