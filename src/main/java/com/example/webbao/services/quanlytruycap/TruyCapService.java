package com.example.webbao.services.quanlytruycap;

import com.example.webbao.models.quanlytruycap.TruyCapDto;

import java.util.Map;

public interface TruyCapService {
    public Map<String, Object> create(TruyCapDto truyCapDto);
    public Map<String, Object> getAll();
    public Map<String, Object> tongView();
    public Map<String, Object> allViewTrongNgay(String ngayTruyCap);
}
