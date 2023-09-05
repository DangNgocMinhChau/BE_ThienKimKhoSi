package com.example.webbao.models.quanlytruycap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TruyCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ngayTruyCap;

    public TruyCap() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNgayTruyCap() {
        return ngayTruyCap;
    }

    public void setNgayTruyCap(String ngayTruyCap) {
        this.ngayTruyCap = ngayTruyCap;
    }
}
