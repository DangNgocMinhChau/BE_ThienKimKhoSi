package com.example.webbao.services.pageManager.devices;

import com.example.webbao.models.pageManager.devices.DevicesDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface DevicesService {
    public Map<String, Object> create(DevicesDto devicesDto);

    public Map<String, Object> update(Long id, DevicesDto devicesDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> getSelectById();

    public Map<String, Object> getSelect();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData);

    public Map<String, Object> deletePermanently(Long[] listIds);


}
