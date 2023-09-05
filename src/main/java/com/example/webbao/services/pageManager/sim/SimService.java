package com.example.webbao.services.pageManager.sim;

import com.example.webbao.models.pageManager.sim.SimDto;

import java.util.Map;

public interface SimService {
    public Map<String, Object> create(SimDto simDto);

    public Map<String, Object> update(Long id, SimDto simDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> getSelectById();

    public Map<String, Object> getSelect();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData);

    public Map<String, Object> deletePermanently(Long[] listIds);
}
