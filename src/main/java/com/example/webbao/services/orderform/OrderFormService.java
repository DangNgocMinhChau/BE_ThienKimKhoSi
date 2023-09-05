package com.example.webbao.services.orderform;


import com.example.webbao.models.lienhequangcao.LienHeQuangCao;
import com.example.webbao.models.lienhequangcao.LienHeQuangCaoDto;
import com.example.webbao.models.orderform.OrderForm;
import com.example.webbao.models.orderform.OrderFormDto;

import java.util.Map;

public interface OrderFormService {
    OrderForm findById(Long id);

    public Map<String, Object> create(OrderFormDto orderFormDto);

    public Map<String, Object> update(Long id, OrderFormDto orderFormDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData);

}
