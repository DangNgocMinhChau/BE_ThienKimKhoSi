package com.example.webbao.services.pageManager.groupFunc;


import com.example.webbao.models.pageManager.groupFunc.GroupFunc;
import com.example.webbao.models.pageManager.groupFunc.GroupFuncDto;

import java.util.Map;

public interface GroupFuncService {
    GroupFunc findById(Long id);

    public Map<String, Object> create(GroupFuncDto groupFuncDto);

    public Map<String, Object> update(Long id, GroupFuncDto groupFuncDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData);

}
