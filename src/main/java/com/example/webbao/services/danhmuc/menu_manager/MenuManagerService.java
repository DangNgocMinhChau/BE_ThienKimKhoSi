package com.example.webbao.services.danhmuc.menu_manager;


import com.example.webbao.models.danhmuc.menu_manager.MenuManager;
import com.example.webbao.models.danhmuc.menu_manager.MenuManagerDto;

import java.util.Map;

public interface MenuManagerService {
    MenuManager findById(Long menuId);

    public Map<String, Object> create(MenuManagerDto menuManagerDto);

    public Map<String, Object> update(Long id, MenuManagerDto menuManagerDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> getAllSelect();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData);

}
