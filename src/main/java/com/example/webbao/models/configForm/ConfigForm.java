package com.example.webbao.models.configForm;

import javax.persistence.*;

@Entity
public class ConfigForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="codeForm" ,columnDefinition = "TEXT")
    private String codeForm;

    @Column(name="menuMapping" ,columnDefinition = "TEXT")
    private String menuMapping;

    @Column(name="nameForm" ,columnDefinition = "TEXT")
    private String nameForm;

    @Column(name="typeForm" ,columnDefinition = "TEXT")
    private String typeForm;

    @Column(name="fieldMapform" ,columnDefinition = "TEXT")
    private String fieldMapform;

    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    public ConfigForm() {
    }

    public ConfigForm(String codeForm, String menuMapping, String nameForm, String typeForm, String fieldMapform, String ngayTaoBanGhi, String ngayChinhSua, Boolean flag) {
        this.codeForm = codeForm;
        this.menuMapping = menuMapping;
        this.nameForm = nameForm;
        this.typeForm = typeForm;
        this.fieldMapform = fieldMapform;
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