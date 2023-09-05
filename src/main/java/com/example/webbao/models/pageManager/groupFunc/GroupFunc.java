package com.example.webbao.models.pageManager.groupFunc;

import javax.persistence.*;

@Entity
public class GroupFunc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nameGroupFunc" ,columnDefinition = "TEXT")
    private String nameGroupFunc;
    @Column(name="codeGroupFunc" ,columnDefinition = "TEXT")
    private String codeGroupFunc;
    @Column(name="groupFunc" ,columnDefinition = "TEXT")
    private String groupFunc;
    private Long nguoiTaoId;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    public GroupFunc() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameGroupFunc() {
        return nameGroupFunc;
    }

    public void setNameGroupFunc(String nameGroupFunc) {
        this.nameGroupFunc = nameGroupFunc;
    }

    public String getCodeGroupFunc() {
        return codeGroupFunc;
    }

    public void setCodeGroupFunc(String codeGroupFunc) {
        this.codeGroupFunc = codeGroupFunc;
    }

    public String getGroupFunc() {
        return groupFunc;
    }

    public void setGroupFunc(String groupFunc) {
        this.groupFunc = groupFunc;
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
}


