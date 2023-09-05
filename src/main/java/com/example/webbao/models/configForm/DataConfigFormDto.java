package com.example.webbao.models.configForm;

public class DataConfigFormDto {
    private Long id;
    private String codeForm;
    private String urlMapping;
    private String dataForm;
    private String idForm;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    public DataConfigFormDto() {
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
