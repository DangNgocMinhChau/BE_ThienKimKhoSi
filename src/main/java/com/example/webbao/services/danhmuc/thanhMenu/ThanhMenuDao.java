package com.example.webbao.services.danhmuc.thanhMenu;

import com.example.webbao.models.danhmuc.tag.Tag;
import com.example.webbao.models.danhmuc.thanhmenu.ThanhMenu;
import com.example.webbao.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class ThanhMenuDao {
    @Autowired
    private EntityManager entityManager;

    public List<ThanhMenu> getListThanhMenu(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object ma = null;
        Object ten = null;
        Object stt = null;
        Object phanLoai = null;

        sql.append("select");
        sql.append(" tm");
        sql.append(" from ThanhMenu tm");
        sql.append(" where");
        sql.append(" tm.id is not null and ");
        sql.append(" tm.flag is true ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            ma = listSearchParams.get("ma");
            if(ma != null && ma != ""){
                sql.append(" AND LOWER(tm.ma) LIKE :ma");
            }

            ten = listSearchParams.get("ten");
            if(ten != null && ten != ""){
                sql.append(" AND LOWER(tm.ten) LIKE :ten");
            }


            stt = listSearchParams.get("stt");
            if(stt != null && stt != ""){
                sql.append(" AND LOWER(tm.stt) LIKE :stt");
            }
            phanLoai = listSearchParams.get("phanLoai");
            if(phanLoai != null && phanLoai != ""){
                sql.append(" AND LOWER(tm.phanLoai) LIKE :phanLoai");
            }

        }

        if(sortData != null){
            String sortQuery = Util.convertSortDataWithAlias(sortData,"tm");
            sql.append(" ORDER BY " + sortQuery);
        }

        TypedQuery<ThanhMenu> query = entityManager.createQuery(sql.toString(), ThanhMenu.class);
        if(ten != null && ten !=""){
            query.setParameter("ten","%" + ten.toString().toLowerCase() + "%");
        }

        if(ma != null && ma !=""){
            query.setParameter("ma","%" + ma.toString().toLowerCase() + "%");
        }

        if(stt != null && stt !=""){
            query.setParameter("stt","%" + stt.toString().toLowerCase() + "%");
        }

        if(phanLoai != null && phanLoai !=""){
            query.setParameter("phanLoai","%" + phanLoai.toString().toLowerCase() + "%");
        }

        if(pageable != null){
            return  query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer countThanhMenu(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object ten = null;
        Object ma = null;
        Object stt = null;
        Object phanLoai = null;

        sql.append("select");
        sql.append(" count(tm)");
        sql.append(" from ThanhMenu tm");
        sql.append(" where");
        sql.append(" tm.id is not null and ");
        sql.append(" tm.flag = true ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            ten = listSearchParams.get("ten");
            if(ten != null && ten != ""){
                sql.append(" AND LOWER(tm.ten) LIKE :ten");
            }

            ma = listSearchParams.get("ma");
            if(ma != null && ma != ""){
                sql.append(" AND LOWER(tm.ma) LIKE :ma");
            }
            stt = listSearchParams.get("stt");
            if(stt != null && stt != ""){
                sql.append(" AND LOWER(tm.stt) LIKE :stt");
            }
            phanLoai = listSearchParams.get("phanLoai");
            if(phanLoai != null && phanLoai != ""){
                sql.append(" AND LOWER(tm.phanLoai) LIKE :phanLoai");
            }
        }



        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);
        if(ten != null && ten !=""){
            query.setParameter("ten","%" + ten.toString().toLowerCase() + "%");
        }

        if(ma != null && ma !=""){
            query.setParameter("ma","%" + ma.toString().toLowerCase() + "%");
        }
        if(stt != null && stt !=""){
            query.setParameter("stt","%" + stt.toString().toLowerCase() + "%");
        }

        if(phanLoai != null && phanLoai !=""){
            query.setParameter("phanLoai","%" + phanLoai.toString().toLowerCase() + "%");
        }

        return ((Number) query.getSingleResult()).intValue();
    }
}
