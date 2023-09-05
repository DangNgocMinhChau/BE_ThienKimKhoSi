package com.example.webbao.services.danhmuc.url;

import com.example.webbao.models.danhmuc.url.Url;
import com.example.webbao.models.danhmuc.url.UrlDto;

import java.util.Map;

public interface UrlService {
    Url findById(Long id);

    public Map<String, Object> create(UrlDto urlDto);

    public Map<String, Object> update(Long id, UrlDto urlDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> getAllSelect();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData);

}
