package com.example.webbao.services.danhmuc.tag;


import com.example.webbao.models.danhmuc.tag.Tag;
import com.example.webbao.models.danhmuc.tag.TagDto;

import java.util.Map;

public interface TagService {
    Tag findById(Long tagId);

    public Map<String, Object> create(TagDto tagDto);

    public Map<String, Object> update(Long id, TagDto tagDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();
    public Map<String, Object> getAllSelect();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

    public Map<String, Object> findAll(String  searchString,Integer pageSize,Integer page,String sortData);

}
