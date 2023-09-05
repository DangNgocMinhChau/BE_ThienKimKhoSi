package com.example.webbao.repositorys.danhmuc.tag;

import com.example.webbao.models.danhmuc.tag.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TagRepository extends JpaRepository<Tag, Long> {
    @Query(value = "select * from tag t " +
            "where t.ma like CONCAT(:ma) and t.flag = true ;"
            , nativeQuery = true)
    Tag checkMaTrungNhau(@Param("ma") String ma);
}
