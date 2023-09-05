package com.example.webbao.services.lienhequangcao;

import com.example.webbao.models.danhmuc.tag.Tag;
import com.example.webbao.models.lienhequangcao.LienHeQuangCao;
import com.example.webbao.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class LienHeQuangCaoDao {
    @Autowired
    private EntityManager entityManager;

    public List<LienHeQuangCao> getListLhqc(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object email = null;
        Object ten = null;
        Object sdt = null;


        sql.append("select");
        sql.append(" lhqc");
        sql.append(" from LienHeQuangCao lhqc");
        sql.append(" where");
        sql.append(" lhqc.id is not null and ");
        sql.append(" lhqc.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);


            ten = listSearchParams.get("ten");
            if (ten != null && ten != "") {
                sql.append(" AND LOWER(lhqc.ten) LIKE :ten");
            }
            sdt = listSearchParams.get("sdt");
            if (sdt != null && ten != "") {
                sql.append(" AND LOWER(lhqc.sdt) LIKE :sdt");
            }

            email = listSearchParams.get("email");
            if (email != null && email != "") {
                sql.append(" AND LOWER(lhqc.email) LIKE :email");
            }
        }

        if (sortData != null) {
            String sortQuery = Util.convertSortDataWithAlias(sortData, "lhqc");
            sql.append(" ORDER BY " + sortQuery);
        }

        TypedQuery<LienHeQuangCao> query = entityManager.createQuery(sql.toString(), LienHeQuangCao.class);
        if (ten != null && ten != "") {
            query.setParameter("ten", "%" + ten.toString().toLowerCase() + "%");
        }

        if (email != null && email != "") {
            query.setParameter("email", "%" + email.toString().toLowerCase() + "%");
        }


        if (sdt != null && sdt != "") {
            query.setParameter("sdt", "%" + sdt.toString().toLowerCase() + "%");
        }

        if (pageable != null) {
            return query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer countLHQC(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object email = null;
        Object ten = null;
        Object sdt = null;

        sql.append("select");
        sql.append(" count(lhqc)");
        sql.append(" from LienHeQuangCao lhqc");
        sql.append(" where");
        sql.append(" lhqc.id is not null and ");
        sql.append(" lhqc.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            ten = listSearchParams.get("ten");
            if (ten != null && ten != "") {
                sql.append(" AND LOWER(lhqc.ten) LIKE :ten");
            }

            sdt = listSearchParams.get("sdt");
            if (sdt != null && ten != "") {
                sql.append(" AND LOWER(lhqc.sdt) LIKE :sdt");
            }

            email = listSearchParams.get("email");
            if (email != null && email != "") {
                sql.append(" AND LOWER(lhqc.email) LIKE :email");
            }
        }


        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);
        if (ten != null && ten != "") {
            query.setParameter("ten", "%" + ten.toString().toLowerCase() + "%");
        }

        if (email != null && email != "") {
            query.setParameter("email", "%" + email.toString().toLowerCase() + "%");
        }


        if (sdt != null && sdt != "") {
            query.setParameter("sdt", "%" + sdt.toString().toLowerCase() + "%");
        }

        return ((Number) query.getSingleResult()).intValue();
    }
}
