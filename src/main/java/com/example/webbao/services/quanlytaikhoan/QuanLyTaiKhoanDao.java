package com.example.webbao.services.quanlytaikhoan;

import com.example.webbao.models.quanlytaikhoan.QuanLyTaiKhoan;
import com.example.webbao.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class QuanLyTaiKhoanDao {
    @Autowired
    private EntityManager entityManager;

    public List<QuanLyTaiKhoan> getListTaiKhoan(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object tenNguoiDung = null;
        Object tenDangNhap = null;
        Object matKhau = null;
        Object xacNhanMatKhau = null;
        Object ngaySinh = null;
        Object matKhauGoc = null;
        Object gioiTinh = null;
        Object facebook = null;
        Object soDienThoai = null;
        Object cmnd = null;
        Object img = null;
        Object lockUser = null;
        Object soLanDangNhapSai = null;

        sql.append("select");
        sql.append(" tk");
        sql.append(" from QuanLyTaiKhoan tk");
        sql.append(" LEFT JOIN FETCH tk.quyen ");
        sql.append(" where");
        sql.append(" tk.id is not null and ");
        sql.append(" tk.flag = true ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            tenNguoiDung = listSearchParams.get("tenNguoiDung");
            if(tenNguoiDung != null && tenNguoiDung != ""){
                sql.append(" AND LOWER(tk.tenNguoiDung) LIKE :tenNguoiDung");
            }

            tenDangNhap = listSearchParams.get("tenDangNhap");
            if(tenDangNhap != null && tenDangNhap != ""){
                sql.append(" AND LOWER(tk.tenDangNhap) LIKE :tenDangNhap");
            }

            matKhau = listSearchParams.get("matKhau");
            if(matKhau != null && matKhau != ""){
                sql.append(" AND LOWER(tk.matKhau) LIKE :matKhau");
            }

            xacNhanMatKhau = listSearchParams.get("xacNhanMatKhau");
            if(xacNhanMatKhau != null && xacNhanMatKhau != ""){
                sql.append(" AND LOWER(tk.xacNhanMatKhau) LIKE :xacNhanMatKhau");
            }

            matKhauGoc = listSearchParams.get("matKhauGoc");
            if(matKhauGoc != null && matKhauGoc != ""){
                sql.append(" AND LOWER(tk.matKhauGoc) LIKE :matKhauGoc");
            }

            ngaySinh = listSearchParams.get("ngaySinh");
            if(ngaySinh != null && ngaySinh != ""){
                sql.append(" AND LOWER(tk.ngaySinh) LIKE :ngaySinh");
            }

            gioiTinh = listSearchParams.get("gioiTinh");
            if(gioiTinh != null && gioiTinh != ""){
                sql.append(" AND LOWER(tk.gioiTinh) LIKE :gioiTinh");
            }

            facebook = listSearchParams.get("facebook");
            if(facebook != null && facebook != ""){
                sql.append(" AND LOWER(tk.facebook) LIKE :facebook");
            }

            soDienThoai = listSearchParams.get("soDienThoai");
            if(soDienThoai != null && soDienThoai != ""){
                sql.append(" AND LOWER(tk.soDienThoai) LIKE :soDienThoai");
            }

            cmnd = listSearchParams.get("cmnd");
            if(cmnd != null && cmnd != ""){
                sql.append(" AND LOWER(tk.cmnd) LIKE :cmnd");
            }

            img = listSearchParams.get("img");
            if(img != null && img != ""){
                sql.append(" AND LOWER(tk.img) LIKE :img");
            }

            lockUser = listSearchParams.get("lockUser");
            if(lockUser != null && lockUser != ""){
                sql.append(" AND LOWER(tk.lockUser) LIKE :lockUser");
            }

            soLanDangNhapSai = listSearchParams.get("soLanDangNhapSai");
            if(soLanDangNhapSai != null && soLanDangNhapSai != ""){
                sql.append(" AND LOWER(tk.soLanDangNhapSai) LIKE :soLanDangNhapSai");
            }
        }

        if(sortData != null){
            String sortQuery = Util.convertSortDataWithAlias(sortData,"tk");
            sql.append(" ORDER BY " + sortQuery);
        }

        TypedQuery<QuanLyTaiKhoan> query = entityManager.createQuery(sql.toString(), QuanLyTaiKhoan.class);
        if(tenNguoiDung != null && tenNguoiDung !=""){
            query.setParameter("tenNguoiDung","%" + tenNguoiDung.toString().toLowerCase() + "%");
        }

        if(tenDangNhap != null && tenDangNhap !=""){
            query.setParameter("tenDangNhap","%" + tenDangNhap.toString().toLowerCase() + "%");
        }
        if(matKhau != null && matKhau !=""){
            query.setParameter("matKhau","%" + matKhau.toString().toLowerCase() + "%");
        }

        if(xacNhanMatKhau != null && xacNhanMatKhau !=""){
            query.setParameter("xacNhanMatKhau","%" + xacNhanMatKhau.toString().toLowerCase() + "%");
        }

        if(matKhauGoc != null && matKhauGoc !=""){
            query.setParameter("matKhauGoc","%" + matKhauGoc.toString().toLowerCase() + "%");
        }

        if(ngaySinh != null && ngaySinh !=""){
            query.setParameter("ngaySinh","%" + ngaySinh.toString().toLowerCase() + "%");
        }

        if(gioiTinh != null && gioiTinh !=""){
            query.setParameter("gioiTinh","%" + gioiTinh.toString().toLowerCase() + "%");
        }

        if(facebook != null && facebook !=""){
            query.setParameter("facebook","%" + facebook.toString().toLowerCase() + "%");
        }

        if(soDienThoai != null && soDienThoai !=""){
            query.setParameter("soDienThoai","%" + soDienThoai.toString().toLowerCase() + "%");
        }

        if(cmnd != null && cmnd !=""){
            query.setParameter("cmnd","%" + cmnd.toString().toLowerCase() + "%");
        }


        if(img != null && img !=""){
            query.setParameter("img","%" + img.toString().toLowerCase() + "%");
        }

        if(lockUser != null && lockUser !=""){
            query.setParameter("lockUser","%" + lockUser.toString().toLowerCase() + "%");
        }

        if(soLanDangNhapSai != null && soLanDangNhapSai !=""){
            query.setParameter("soLanDangNhapSai","%" + soLanDangNhapSai.toString().toLowerCase() + "%");
        }

        if(pageable != null){
            return  query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer countTaiKhoan(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object tenNguoiDung = null;
        Object tenDangNhap = null;
        Object matKhau = null;
        Object xacNhanMatKhau = null;
        Object ngaySinh = null;
        Object matKhauGoc = null;
        Object gioiTinh = null;
        Object facebook = null;
        Object soDienThoai = null;
        Object cmnd = null;
        Object img = null;
        Object lockUser = null;
        Object soLanDangNhapSai = null;

        sql.append("select");
        sql.append(" count(tk)");
        sql.append(" from QuanLyTaiKhoan tk");

        sql.append(" where");
        sql.append(" tk.id is not null and ");
        sql.append(" tk.flag = true ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            tenNguoiDung = listSearchParams.get("tenNguoiDung");
            if(tenNguoiDung != null && tenNguoiDung != ""){
                sql.append(" AND LOWER(tk.tenNguoiDung) LIKE :tenNguoiDung");
            }

            tenDangNhap = listSearchParams.get("tenDangNhap");
            if(tenDangNhap != null && tenDangNhap != ""){
                sql.append(" AND LOWER(tk.tenDangNhap) LIKE :tenDangNhap");
            }

            matKhau = listSearchParams.get("matKhau");
            if(matKhau != null && matKhau != ""){
                sql.append(" AND LOWER(tk.matKhau) LIKE :matKhau");
            }

            xacNhanMatKhau = listSearchParams.get("xacNhanMatKhau");
            if(xacNhanMatKhau != null && xacNhanMatKhau != ""){
                sql.append(" AND LOWER(tk.xacNhanMatKhau) LIKE :xacNhanMatKhau");
            }

            matKhauGoc = listSearchParams.get("matKhauGoc");
            if(matKhauGoc != null && matKhauGoc != ""){
                sql.append(" AND LOWER(tk.matKhauGoc) LIKE :matKhauGoc");
            }

            ngaySinh = listSearchParams.get("ngaySinh");
            if(ngaySinh != null && ngaySinh != ""){
                sql.append(" AND LOWER(tk.ngaySinh) LIKE :ngaySinh");
            }

            gioiTinh = listSearchParams.get("gioiTinh");
            if(gioiTinh != null && gioiTinh != ""){
                sql.append(" AND LOWER(tk.gioiTinh) LIKE :gioiTinh");
            }

            facebook = listSearchParams.get("facebook");
            if(facebook != null && facebook != ""){
                sql.append(" AND LOWER(tk.facebook) LIKE :facebook");
            }

            soDienThoai = listSearchParams.get("soDienThoai");
            if(soDienThoai != null && soDienThoai != ""){
                sql.append(" AND LOWER(tk.soDienThoai) LIKE :soDienThoai");
            }

            cmnd = listSearchParams.get("cmnd");
            if(cmnd != null && cmnd != ""){
                sql.append(" AND LOWER(tk.cmnd) LIKE :cmnd");
            }

            img = listSearchParams.get("img");
            if(img != null && img != ""){
                sql.append(" AND LOWER(tk.img) LIKE :img");
            }

            lockUser = listSearchParams.get("lockUser");
            if(lockUser != null && lockUser != ""){
                sql.append(" AND LOWER(tk.lockUser) LIKE :lockUser");
            }

            soLanDangNhapSai = listSearchParams.get("soLanDangNhapSai");
            if(soLanDangNhapSai != null && soLanDangNhapSai != ""){
                sql.append(" AND LOWER(tk.soLanDangNhapSai) LIKE :soLanDangNhapSai");
            }
        }

        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);
        if(tenNguoiDung != null && tenNguoiDung !=""){
            query.setParameter("tenNguoiDung","%" + tenNguoiDung.toString().toLowerCase() + "%");
        }

        if(tenDangNhap != null && tenDangNhap !=""){
            query.setParameter("tenDangNhap","%" + tenDangNhap.toString().toLowerCase() + "%");
        }
        if(matKhau != null && matKhau !=""){
            query.setParameter("matKhau","%" + matKhau.toString().toLowerCase() + "%");
        }

        if(xacNhanMatKhau != null && xacNhanMatKhau !=""){
            query.setParameter("xacNhanMatKhau","%" + xacNhanMatKhau.toString().toLowerCase() + "%");
        }

        if(matKhauGoc != null && matKhauGoc !=""){
            query.setParameter("matKhauGoc","%" + matKhauGoc.toString().toLowerCase() + "%");
        }

        if(ngaySinh != null && ngaySinh !=""){
            query.setParameter("ngaySinh","%" + ngaySinh.toString().toLowerCase() + "%");
        }

        if(gioiTinh != null && gioiTinh !=""){
            query.setParameter("gioiTinh","%" + gioiTinh.toString().toLowerCase() + "%");
        }

        if(facebook != null && facebook !=""){
            query.setParameter("facebook","%" + facebook.toString().toLowerCase() + "%");
        }

        if(soDienThoai != null && soDienThoai !=""){
            query.setParameter("soDienThoai","%" + soDienThoai.toString().toLowerCase() + "%");
        }

        if(cmnd != null && cmnd !=""){
            query.setParameter("cmnd","%" + cmnd.toString().toLowerCase() + "%");
        }

        if(img != null && img !=""){
            query.setParameter("img","%" + img.toString().toLowerCase() + "%");
        }

        if(lockUser != null && lockUser !=""){
            query.setParameter("lockUser","%" + lockUser.toString().toLowerCase() + "%");
        }

        if(soLanDangNhapSai != null && soLanDangNhapSai !=""){
            query.setParameter("soLanDangNhapSai","%" + soLanDangNhapSai.toString().toLowerCase() + "%");
        }
        return ((Number) query.getSingleResult()).intValue();
    }
}
