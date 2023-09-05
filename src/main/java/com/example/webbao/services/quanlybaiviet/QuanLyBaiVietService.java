package com.example.webbao.services.quanlybaiviet;

import com.example.webbao.models.quanlybaiviet.QuanLyBaiViet;
import com.example.webbao.models.quanlybaiviet.QuanLyBaiVietDto;

import java.util.Map;

public interface QuanLyBaiVietService {
    QuanLyBaiViet findById(Long baiVietId);

    public Map<String, Object> create(QuanLyBaiVietDto quanLyBaiVietDto);

    public Map<String, Object> update(Long id, QuanLyBaiVietDto quanLyBaiVietDto);

    public Map<String, Object> countView(Long id);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> getTinTucTheoTag(String tag);


    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData);

}
