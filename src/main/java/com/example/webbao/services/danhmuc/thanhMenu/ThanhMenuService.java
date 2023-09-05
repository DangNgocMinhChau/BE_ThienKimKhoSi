package com.example.webbao.services.danhmuc.thanhMenu;


import com.example.webbao.models.danhmuc.thanhmenu.ThanhMenu;
import com.example.webbao.models.danhmuc.thanhmenu.ThanhMenuDto;

import java.util.Map;

public interface ThanhMenuService {
    ThanhMenu findById(Long thanhmenuId);

    public Map<String, Object> create(ThanhMenuDto thanhMenuDto);

    public Map<String, Object> update(Long id, ThanhMenuDto thanhMenuDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> getAllSelect();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData);

}
