package com.example.webbao.models.pageManager.groupFunc;

public class GroupFuncDto {
    private Long id;
    private String nameGroupFunc;
    private String codeGroupFunc;
    private String groupFunc;
    private Long nguoiTaoId;
    private String ngayTaoBanGhi;
    private String ngayChinhSua;
    private Boolean flag;

    public GroupFuncDto() {
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
