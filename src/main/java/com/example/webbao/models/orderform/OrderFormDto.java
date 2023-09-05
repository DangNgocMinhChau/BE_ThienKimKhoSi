package com.example.webbao.models.orderform;

public class OrderFormDto {
    private Long id;
    private String url;
    private String api;
    private String formName;
    private String typeForms;
    private String notes;
    private String formMapping;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    public OrderFormDto() {
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

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
