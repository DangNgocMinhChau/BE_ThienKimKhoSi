package com.example.webbao.services.danhmuc.tag;

import com.example.webbao.models.danhmuc.tag.Tag;
import com.example.webbao.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class TagDao {
    @Autowired
    private EntityManager entityManager;

    public List<Tag> getListTag(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object ma = null;
        Object ten = null;
        Object nhomMenu = null;
        Object phanLoai = null;

        sql.append("select");
        sql.append(" t");
        sql.append(" from Tag t");
        sql.append(" where");
        sql.append(" t.id is not null and ");
        sql.append(" t.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            ma = listSearchParams.get("ma");
            if (ma != null && ma != "") {
                sql.append(" AND LOWER(t.ma) LIKE :ma");
            }

            ten = listSearchParams.get("ten");
            if (ten != null && ten != "") {
                sql.append(" AND LOWER(t.ten) LIKE :ten");
            }
            nhomMenu = listSearchParams.get("nhomMenu");
            if (nhomMenu != null && ten != "") {
                sql.append(" AND LOWER(t.nhomMenu) LIKE :nhomMenu");
            }

            phanLoai = listSearchParams.get("phanLoai");
            if (phanLoai != null && phanLoai != "") {
                sql.append(" AND LOWER(t.phanLoai) LIKE :phanLoai");
            }
        }

        if (sortData != null) {
            String sortQuery = Util.convertSortDataWithAlias(sortData, "t");
            sql.append(" ORDER BY " + sortQuery);
        }

        TypedQuery<Tag> query = entityManager.createQuery(sql.toString(), Tag.class);
        if (ten != null && ten != "") {
            query.setParameter("ten", "%" + ten.toString().toLowerCase() + "%");
        }

        if (ma != null && ma != "") {
            query.setParameter("ma", "%" + ma.toString().toLowerCase() + "%");
        }


        if (nhomMenu != null && nhomMenu != "") {
            query.setParameter("nhomMenu", "%" + nhomMenu.toString().toLowerCase() + "%");
        }
        if (phanLoai != null && phanLoai != "") {
            query.setParameter("phanLoai", "%" + phanLoai.toString().toLowerCase() + "%");
        }
        if (pageable != null) {
            return query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer countTag(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object ten = null;
        Object ma = null;
        Object nhomMenu = null;
        Object phanLoai = null;

        sql.append("select");
        sql.append(" count(t)");
        sql.append(" from Tag t");
        sql.append(" where");
        sql.append(" t.id is not null and ");
        sql.append(" t.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            ten = listSearchParams.get("ten");
            if (ten != null && ten != "") {
                sql.append(" AND LOWER(t.ten) LIKE :ten");
            }

            ma = listSearchParams.get("ma");
            if (ma != null && ma != "") {
                sql.append(" AND LOWER(t.ma) LIKE :ma");
            }

            nhomMenu = listSearchParams.get("nhomMenu");
            if (nhomMenu != null && nhomMenu != "") {
                sql.append(" AND LOWER(t.nhomMenu) LIKE :nhomMenu");
            }

            phanLoai = listSearchParams.get("phanLoai");
            if (phanLoai != null && phanLoai != "") {
                sql.append(" AND LOWER(t.phanLoai) LIKE :phanLoai");
            }
        }


        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);
        if (ten != null && ten != "") {
            query.setParameter("ten", "%" + ten.toString().toLowerCase() + "%");
        }

        if (ma != null && ma != "") {
            query.setParameter("ma", "%" + ma.toString().toLowerCase() + "%");
        }
        if (nhomMenu != null && nhomMenu != "") {
            query.setParameter("nhomMenu", "%" + nhomMenu.toString().toLowerCase() + "%");
        }

        if (phanLoai != null && phanLoai != "") {
            query.setParameter("phanLoai", "%" + phanLoai.toString().toLowerCase() + "%");
        }

        return ((Number) query.getSingleResult()).intValue();
    }
}
