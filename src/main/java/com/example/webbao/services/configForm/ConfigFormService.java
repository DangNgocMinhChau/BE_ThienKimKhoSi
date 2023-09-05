package com.example.webbao.services.configForm;


import com.example.webbao.models.configForm.ConfigForm;
import com.example.webbao.models.configForm.ConfigFormDto;
import com.example.webbao.models.orderform.OrderForm;

import java.util.Map;

public interface ConfigFormService {
    ConfigForm findById(Long id);

    public Map<String, Object> create(ConfigFormDto configFormDto);

    public Map<String, Object> update(Long id, ConfigFormDto configFormDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData);

}
