package com.example.webbao.repositorys.danhmuc.thanhmenu;

import com.example.webbao.models.danhmuc.tag.Tag;
import com.example.webbao.models.danhmuc.thanhmenu.ThanhMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThanhMenuRepository extends JpaRepository<ThanhMenu, Long> {
}
