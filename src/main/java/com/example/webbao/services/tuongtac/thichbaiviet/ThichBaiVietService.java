package com.example.webbao.services.tuongtac.thichbaiviet;


import com.example.webbao.models.tuongtac.thichbaiviet.ThichBaiViet;
import com.example.webbao.models.tuongtac.thichbaiviet.ThichBaiVietDto;

import java.util.Map;

public interface ThichBaiVietService {
    ThichBaiViet findById(Long id);

    Map<String, Object> create(ThichBaiVietDto thichBaiVietDto);

    Map<String, Object> update(Long id, ThichBaiVietDto thichBaiVietDto);

    Map<String, Object> fetchById(Long id);

    Map<String, Object> countBaiViet(Long id);

}
