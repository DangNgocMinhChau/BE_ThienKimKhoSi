package com.example.webbao.repositorys.tuongtac.thichbaiviet;

import com.example.webbao.models.tuongtac.thichbaiviet.ThichBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ThichBaiVietRepository extends JpaRepository<ThichBaiViet, Long> {
    @Query(value = "select count(id_bai_viet) as count from thich_bai_viet t where t.id_bai_viet = ?1", nativeQuery = true)
    Long countBaiViet(@Param("idBaiViet") Long idBaiViet);
}
