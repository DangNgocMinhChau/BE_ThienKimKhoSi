package com.example.webbao.repositorys.quanlybaiviet;

import com.example.webbao.models.quanlybaiviet.QuanLyBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuanLyBaiVietRepository extends JpaRepository<QuanLyBaiViet, Long> {
    @Query(value = "select * from quan_ly_bai_viet u " +
            "where " +
            "u.flag = true " +
            "and" +
            " u.tag like CONCAT('%',:tag,'%') " +
            "order by id desc"
            , nativeQuery = true)
    List<QuanLyBaiViet> baiVietTheoTag (@Param("tag") String tag);

}
