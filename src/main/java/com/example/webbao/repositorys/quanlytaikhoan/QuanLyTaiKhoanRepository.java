package com.example.webbao.repositorys.quanlytaikhoan;

import com.example.webbao.models.quanlytaikhoan.QuanLyTaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuanLyTaiKhoanRepository extends JpaRepository<QuanLyTaiKhoan, Long> {
    @Query(value = "select * from quan_ly_tai_khoan u " +
            "where u.ten_dang_nhap like CONCAT(:account) and u.mat_khau like CONCAT(:password);"
            , nativeQuery = true)
    QuanLyTaiKhoan loginUser(@Param("account") String account, @Param("password") String password);

    @Query(value = "select * from quan_ly_tai_khoan u " +
            "where u.ten_dang_nhap like CONCAT(:account) and u.flag = true ;"
            , nativeQuery = true)
    QuanLyTaiKhoan getAccoutByTenDangNhap(@Param("account") String account);

    @Query(value = "select * from quan_ly_tai_khoan u " +
            "where u.ten_dang_nhap like CONCAT(:account) and u.cmnd like CONCAT(:cmnd)  and u.so_dien_thoai like CONCAT(:sdt);"
            , nativeQuery = true)
    QuanLyTaiKhoan resetPass(@Param("account") String account, @Param("cmnd") String cmnd, @Param("sdt") String sdt);


}
