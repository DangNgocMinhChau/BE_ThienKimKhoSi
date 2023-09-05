package com.example.webbao.models.configForm;

public class ConfigFormDto {
    private Long id;
    private String codeForm;
    private String menuMapping;
    private String nameForm;
    private String typeForm;
    private String fieldMapform;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    public ConfigFormDto() {
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

    public String getMenuMapping() {
        return menuMapping;
    }

    public void setMenuMapping(String menuMapping) {
        this.menuMapping = menuMapping;
    }

    public String getNameForm() {
        return nameForm;
    }

    public void setNameForm(String nameForm) {
        this.nameForm = nameForm;
    }

    public String getTypeForm() {
        return typeForm;
    }

    public void setTypeForm(String typeForm) {
        this.typeForm = typeForm;
    }

    public String getFieldMapform() {
        return fieldMapform;
    }

    public void setFieldMapform(String fieldMapform) {
        this.fieldMapform = fieldMapform;
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
