package com.example.webbao.services.pageManager.menu;

import com.example.webbao.models.pageManager.menu.MenuCoreDto;

import java.util.Map;

public interface MenuCoreService {
    public Map<String, Object> create(MenuCoreDto menuCoreDto);

    public Map<String, Object> update(Long id, MenuCoreDto menuCoreDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> getSelectById();

    public Map<String, Object> getSelect();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData);

    public Map<String, Object> deletePermanently (Long[] listIds);
}
