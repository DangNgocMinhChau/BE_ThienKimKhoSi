package com.example.webbao.services.lienhequangcao;


import com.example.webbao.models.danhmuc.tag.Tag;
import com.example.webbao.models.danhmuc.tag.TagDto;
import com.example.webbao.models.lienhequangcao.LienHeQuangCao;
import com.example.webbao.models.lienhequangcao.LienHeQuangCaoDto;

import java.util.Map;

public interface LienHeQuangCaoService {
    LienHeQuangCao findById(Long lhqcId);

    public Map<String, Object> create(LienHeQuangCaoDto lienHeQuangCaoDto);

    public Map<String, Object> update(Long id, LienHeQuangCaoDto lienHeQuangCaoDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData);

}
