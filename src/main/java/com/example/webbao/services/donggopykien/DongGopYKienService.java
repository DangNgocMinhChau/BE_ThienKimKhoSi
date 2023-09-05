package com.example.webbao.services.donggopykien;

import com.example.webbao.models.donggopykien.DongGopYKien;
import com.example.webbao.models.donggopykien.DongGopYKienDto;

import javax.mail.MessagingException;
import java.util.Map;

public interface DongGopYKienService {
    DongGopYKien findById(Long id);

    public Map<String, Object> create(DongGopYKienDto dongGopYKienDto);

    public Map<String, Object> update(Long id, DongGopYKienDto dongGopYKienDto);

    public Map<String, Object> fetchById(Long id);

    public Map<String, Object> getAll();

    public Map<String, Object> delete(Long[] listIds);

    public Map<String, Object> deleteVinhVien(Long[] listIds);

    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData);
    public Map<String, Object> sendMail(Long id,  String cauTraLoi) throws MessagingException;



}
