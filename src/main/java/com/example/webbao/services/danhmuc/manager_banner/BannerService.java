package com.example.webbao.services.danhmuc.manager_banner;

import com.example.webbao.models.danhmuc.manage_banner.Banner;
import com.example.webbao.models.danhmuc.manage_banner.BannerDto;
import com.example.webbao.models.quanlybaiviet.QuanLyBaiViet;

import java.util.Map;

public interface BannerService {
    Banner findById(Long bannerid);

    public Map<String, Object> create(BannerDto bannerDto);

    public Map<String, Object> update(Long id, BannerDto bannerDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();


    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData);

}
