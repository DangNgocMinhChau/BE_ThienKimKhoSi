package com.example.webbao.services.quanlycmnd;


import com.example.webbao.models.quanlycmnd.QuanLyCMND;
import com.example.webbao.repositorys.quanlycmnd.QuanLyCmndRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuanLyCmndServiceImpl implements QuanLyCmndService {

    @Autowired
    QuanLyCmndRepository quanLyCmndRepository;

    @Override
    public Map<String, Object> create(QuanLyCMND quanLyCMND) {
        Map<String, Object> result = new HashMap<>();
        try {
            quanLyCmndRepository.save(quanLyCMND);
            result.put("result", quanLyCMND);
            result.put("msg", "Thêm mói thành công");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Thêm mới thất bại");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, QuanLyCMND quanLyCMND) {
        return null;
    }

    @Override
    public Map<String, Object> fetchById(Long id) {
        return null;
    }

    @Override
    public Map<String, Object> getAllCMND() {
        List<QuanLyCMND> quanLyCMNDList = quanLyCmndRepository.findAll();
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("result", quanLyCMNDList);
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Lay danh sach  that bai");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> delete(Long[] listIds) {
        return null;
    }

    @Override
    public Map<String, Object> deleteById(Long id) {
        quanLyCmndRepository.deleteById(id);
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("result", "Xóa thành công");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Xóa thất bại");
            result.put("status", false);
        }
        return result;
    }
}
