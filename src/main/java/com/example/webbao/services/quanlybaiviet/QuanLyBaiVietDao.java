package com.example.webbao.services.quanlybaiviet;

import com.example.webbao.models.quanlybaiviet.QuanLyBaiViet;
import com.example.webbao.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class QuanLyBaiVietDao {
    @Autowired
    private EntityManager entityManager;

    public List<QuanLyBaiViet> getListBaiViet(String searchString, Pageable pageable,String sortData) {
        StringBuilder sql = new StringBuilder();
        Object noiDung = null;
        Object tag = null;
        Object tieuDe = null;
        Object gioiThieu = null;
        Object file = null;
        Object tenFile = null;
        Object imgAvatar = null;
        Object trangThai = null;
        Object nguoiTaoId = null;
        Object view = null;
        Object lyDoKhongDuyet = null;

        sql.append("select");
        sql.append(" bv");
        sql.append(" from QuanLyBaiViet bv");
        sql.append(" where");
        sql.append(" bv.id is not null ");
        sql.append(" and");
        sql.append(" bv.flag = true");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            noiDung = listSearchParams.get("noiDung");
            if(noiDung != null && noiDung != ""){
                sql.append(" AND LOWER(bv.noiDung) LIKE :noiDung");
            }

            tag = listSearchParams.get("tag");
            if(tag != null && tag != ""){
                sql.append(" AND LOWER(bv.tag) LIKE :tag");
            }

            tieuDe = listSearchParams.get("tieuDe");
            if(tieuDe != null && tieuDe != ""){
                sql.append(" AND LOWER(bv.tieuDe) LIKE :tieuDe");
            }

            gioiThieu = listSearchParams.get("gioiThieu");
            if(gioiThieu != null && gioiThieu != ""){
                sql.append(" AND LOWER(bv.gioiThieu) LIKE :gioiThieu");
            }

            file = listSearchParams.get("file");
            if(file != null && file != ""){
                sql.append(" AND LOWER(bv.file) LIKE :file");
            }

            tenFile = listSearchParams.get("tenFile");
            if(tenFile != null && tenFile != ""){
                sql.append(" AND LOWER(bv.tenFile) LIKE :tenFile");
            }

            imgAvatar = listSearchParams.get("imgAvatar");
            if(imgAvatar != null && imgAvatar != ""){
                sql.append(" AND LOWER(bv.imgAvatar) LIKE :imgAvatar");
            }

            trangThai = listSearchParams.get("trangThai");
            if(trangThai != null && trangThai != ""){
                sql.append(" AND LOWER(bv.trangThai) LIKE :trangThai");
            }

            nguoiTaoId = listSearchParams.get("nguoiTaoId");
            if(nguoiTaoId != null && nguoiTaoId != ""){
                sql.append(" AND LOWER(bv.nguoiTaoId) LIKE :nguoiTaoId");
            }

            view = listSearchParams.get("view");
            if(view != null && view != ""){
                sql.append(" AND LOWER(bv.view) LIKE :view");
            }
            lyDoKhongDuyet = listSearchParams.get("lyDoKhongDuyet");
            if(lyDoKhongDuyet != null && lyDoKhongDuyet != ""){
                sql.append(" AND LOWER(bv.lyDoKhongDuyet) LIKE :lyDoKhongDuyet");
            }

        }
        if(sortData!=null){
            String sortQuery = Util.convertSortDataWithAlias(sortData,"bv");
            sql.append(" ORDER BY " + sortQuery);
        }


        TypedQuery<QuanLyBaiViet> query = entityManager.createQuery(sql.toString(), QuanLyBaiViet.class);
        if(noiDung != null && noiDung !=""){
            query.setParameter("noiDung","%" + noiDung.toString().toLowerCase() + "%");
        }

        if(tag != null && tag !=""){
            query.setParameter("tag","%" + tag.toString().toLowerCase() + "%");
        }

        if(tieuDe != null && tieuDe !=""){
            query.setParameter("tieuDe","%" + tieuDe.toString().toLowerCase() + "%");
        }

        if(gioiThieu != null && gioiThieu !=""){
            query.setParameter("gioiThieu","%" + gioiThieu.toString().toLowerCase() + "%");
        }

        if(file != null && file !=""){
            query.setParameter("file","%" + file.toString().toLowerCase() + "%");
        }

        if(tenFile != null && tenFile !=""){
            query.setParameter("tenFile","%" + tenFile.toString().toLowerCase() + "%");
        }

        if(imgAvatar != null && imgAvatar !=""){
            query.setParameter("imgAvatar","%" + imgAvatar.toString().toLowerCase() + "%");
        }

        if(trangThai != null && trangThai !=""){
            query.setParameter("trangThai","%" + trangThai.toString().toLowerCase() + "%");
        }

        if(nguoiTaoId != null && nguoiTaoId !=""){
            query.setParameter("nguoiTaoId",Long.parseLong((String) nguoiTaoId));
        }

        if(view != null && view !=""){
            query.setParameter("view",Long.parseLong((String) view));
        }
        if(lyDoKhongDuyet != null && lyDoKhongDuyet !=""){
            query.setParameter("lyDoKhongDuyet","%" + lyDoKhongDuyet.toString().toLowerCase() + "%");
        }



        if(pageable != null){
            return query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer countBaiViet(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object noiDung = null;
        Object tag = null;
        Object tieuDe = null;
        Object gioiThieu = null;
        Object file = null;
        Object tenFile = null;
        Object imgAvatar = null;
        Object trangThai = null;
        Object nguoiTaoId = null;
        Object view = null;
        Object lyDoKhongDuyet = null;

        sql.append("select");
        sql.append(" count(bv)");
        sql.append(" from QuanLyBaiViet bv");
        sql.append(" where");
        sql.append(" bv.id is not null ");
        sql.append(" and ");
        sql.append(" bv.flag = true");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            noiDung = listSearchParams.get("noiDung");
            if(noiDung != null && noiDung != ""){
                sql.append(" AND LOWER(bv.noiDung) LIKE :noiDung");
            }

            tag = listSearchParams.get("tag");
            if(tag != null && tag != ""){
                sql.append(" AND LOWER(bv.tag) LIKE :tag");
            }

            tieuDe = listSearchParams.get("tieuDe");
            if(tieuDe != null && tieuDe != ""){
                sql.append(" AND LOWER(bv.tieuDe) LIKE :tieuDe");
            }

            gioiThieu = listSearchParams.get("gioiThieu");
            if(gioiThieu != null && gioiThieu != ""){
                sql.append(" AND LOWER(bv.gioiThieu) LIKE :gioiThieu");
            }

            file = listSearchParams.get("file");
            if(file != null && file != ""){
                sql.append(" AND LOWER(bv.file) LIKE :file");
            }
            tenFile = listSearchParams.get("tenFile");
            if(tenFile != null && tenFile != ""){
                sql.append(" AND LOWER(bv.tenFile) LIKE :tenFile");
            }

            imgAvatar = listSearchParams.get("imgAvatar");
            if(imgAvatar != null && imgAvatar != ""){
                sql.append(" AND LOWER(bv.imgAvatar) LIKE :imgAvatar");
            }

            trangThai = listSearchParams.get("trangThai");
            if(trangThai != null && trangThai != ""){
                sql.append(" AND LOWER(bv.trangThai) LIKE :trangThai");
            }
            nguoiTaoId = listSearchParams.get("nguoiTaoId");
            if(nguoiTaoId != null && nguoiTaoId != ""){
                sql.append(" AND LOWER(bv.nguoiTaoId) LIKE :nguoiTaoId");
            }

            view = listSearchParams.get("view");
            if(view != null && view != ""){
                sql.append(" AND LOWER(bv.view) LIKE :view");
            }

            lyDoKhongDuyet = listSearchParams.get("lyDoKhongDuyet");
            if(lyDoKhongDuyet != null && lyDoKhongDuyet != ""){
                sql.append(" AND LOWER(bv.lyDoKhongDuyet) LIKE :lyDoKhongDuyet");
            }
        }



        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);
        if(noiDung != null && noiDung !=""){
            query.setParameter("noiDung","%" + noiDung.toString().toLowerCase() + "%");
        }

        if(tag != null && tag !=""){
            query.setParameter("tag","%" + tag.toString().toLowerCase() + "%");
        }

        if(tieuDe != null && tieuDe !=""){
            query.setParameter("tieuDe","%" + tieuDe.toString().toLowerCase() + "%");
        }

        if(gioiThieu != null && gioiThieu !=""){
            query.setParameter("gioiThieu","%" + gioiThieu.toString().toLowerCase() + "%");
        }

        if(file != null && file !=""){
            query.setParameter("file","%" + file.toString().toLowerCase() + "%");
        }

        if(tenFile != null && tenFile !=""){
            query.setParameter("tenFile","%" + tenFile.toString().toLowerCase() + "%");
        }

        if(imgAvatar != null && imgAvatar !=""){
            query.setParameter("imgAvatar","%" + imgAvatar.toString().toLowerCase() + "%");
        }

        if(trangThai != null && trangThai !=""){
            query.setParameter("trangThai","%" + trangThai.toString().toLowerCase() + "%");
        }
        if(nguoiTaoId != null && nguoiTaoId !=""){
            query.setParameter("nguoiTaoId",Long.parseLong((String) nguoiTaoId));
        }
        if(view != null && view !=""){
            query.setParameter("view",Long.parseLong((String) view));
        }
        if(lyDoKhongDuyet != null && lyDoKhongDuyet !=""){
            query.setParameter("lyDoKhongDuyet","%" + lyDoKhongDuyet.toString().toLowerCase() + "%");
        }

        return ((Number) query.getSingleResult()).intValue();
    }
}
