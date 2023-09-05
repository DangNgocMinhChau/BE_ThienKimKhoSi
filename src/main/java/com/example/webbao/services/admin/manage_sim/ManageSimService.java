package com.example.webbao.services.admin.manage_sim;


import com.example.webbao.models.admin.manage_sim.ManageSim;
import com.example.webbao.models.admin.manage_sim.ManageSimDto;
import com.example.webbao.models.configForm.ConfigFormDto;

import java.util.Map;

public interface ManageSimService {
    ManageSim findById(Long id);

    public Map<String, Object> create(ManageSimDto manageSimDto);

    public Map<String, Object> update(Long id, ManageSimDto manageSimDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData);

}
