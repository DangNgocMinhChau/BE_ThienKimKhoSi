package com.example.webbao.models.pageManager.menu;

import javax.persistence.*;

@Entity
public class MenuCore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nameMenu" ,columnDefinition = "TEXT")
    private String nameMenu;
    @Column(name="urlMapping" ,columnDefinition = "TEXT")
    private String urlMapping;
    @Column(name="iconMenu" ,columnDefinition = "TEXT")
    private String iconMenu;
    @Column(name="typeMenu" ,columnDefinition = "TEXT")
    private String typeMenu;
    @Column(name="pid" ,columnDefinition = "TEXT")
    private String pid;
    @Column(name="checkUrlId" )
    private Boolean checkUrlId;
    private Long nguoiTaoId;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    public MenuCore() {
    }

    public MenuCore(String nameMenu, String urlMapping, String iconMenu, String typeMenu, String pid, Long nguoiTaoId, String ngayTaoBanGhi, String ngayChinhSua, Boolean flag) {
        this.nameMenu = nameMenu;
        this.urlMapping = urlMapping;
        this.iconMenu = iconMenu;
        this.typeMenu = typeMenu;
        this.pid = pid;
        this.nguoiTaoId = nguoiTaoId;
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

    public String getNameMenu() {
        return nameMenu;
    }

    public void setNameMenu(String nameMenu) {
        this.nameMenu = nameMenu;
    }

    public String getUrlMapping() {
        return urlMapping;
    }

    public void setUrlMapping(String urlMapping) {
        this.urlMapping = urlMapping;
    }

    public String getIconMenu() {
        return iconMenu;
    }

    public void setIconMenu(String iconMenu) {
        this.iconMenu = iconMenu;
    }

    public String getTypeMenu() {
        return typeMenu;
    }

    public void setTypeMenu(String typeMenu) {
        this.typeMenu = typeMenu;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public Boolean getCheckUrlId() {
        return checkUrlId;
    }

    public void setCheckUrlId(Boolean checkUrlId) {
        this.checkUrlId = checkUrlId;
    }
}


