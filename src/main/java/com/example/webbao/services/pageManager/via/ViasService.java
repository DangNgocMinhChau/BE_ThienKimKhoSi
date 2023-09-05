package com.example.webbao.services.pageManager.via;

import com.example.webbao.models.pageManager.via.ViasDto;

import java.util.Map;

public interface ViasService {
    public Map<String, Object> create(ViasDto viasDto);

    public Map<String, Object> update(Long id, ViasDto viasDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> getSelectById();

    public Map<String, Object> getSelect();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData);

    public Map<String, Object> deletePermanently(Long[] listIds);
}
