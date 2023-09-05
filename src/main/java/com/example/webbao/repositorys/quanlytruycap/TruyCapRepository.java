package com.example.webbao.repositorys.quanlytruycap;

import com.example.webbao.models.quanlytruycap.TruyCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TruyCapRepository extends JpaRepository<TruyCap, Long> {
    @Query(value = "select count(ngay_truy_cap) as view from truy_cap tc " +
            "where tc.ngay_truy_cap like CONCAT(:ngayTruyCap);"
            , nativeQuery = true)
    Long view (@Param("ngayTruyCap") String ngayTruyCap);

}
