package com.example.webbao.services.danhmuc.quyen;

import com.example.webbao.models.danhmuc.quyen.Quyen;
import com.example.webbao.models.danhmuc.quyen.QuyenDto;

import java.util.Map;

public interface QuyenService {
    Quyen findById(Long quyenId);

    public Map<String, Object> create(QuyenDto quyenDto);

    public Map<String, Object> update(Long id, QuyenDto quyenDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> getAllSelect();


    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

    public Map<String, Object> findAll(String  searchString,Integer pageSize,Integer page,String sortData);


}
