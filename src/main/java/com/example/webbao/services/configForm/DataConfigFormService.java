package com.example.webbao.services.configForm;


import com.example.webbao.models.configForm.ConfigForm;
import com.example.webbao.models.configForm.ConfigFormDto;
import com.example.webbao.models.configForm.DataConfigForm;
import com.example.webbao.models.configForm.DataConfigFormDto;

import java.util.Map;

public interface DataConfigFormService {
    DataConfigForm findById(Long id);

    public Map<String, Object> create(DataConfigFormDto dataConfigFormDto);

    public Map<String, Object> update(Long id, DataConfigFormDto dataConfigFormDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData);

}
