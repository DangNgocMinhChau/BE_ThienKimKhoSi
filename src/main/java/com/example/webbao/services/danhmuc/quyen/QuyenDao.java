package com.example.webbao.services.danhmuc.quyen;

import com.example.webbao.models.danhmuc.quyen.Quyen;
import com.example.webbao.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class QuyenDao {
    @Autowired
    private EntityManager entityManager;

    public List<Quyen> getListQuyen(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object ma = null;
        Object ten = null;

        sql.append("select");
        sql.append(" q");
        sql.append(" from Quyen q");
        sql.append(" where");
        sql.append(" q.id is not null and ");
        sql.append(" q.flag = true ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            ma = listSearchParams.get("ma");
            if(ma != null && ma != ""){
                sql.append(" AND LOWER(q.ma) LIKE :ma");
            }

            ten = listSearchParams.get("ten");
            if(ten != null && ten != ""){
                sql.append(" AND LOWER(q.ten) LIKE :ten");
            }
        }

        if(sortData != null){
            String sortQuery = Util.convertSortDataWithAlias(sortData,"q");
            sql.append(" ORDER BY " + sortQuery);
        }

        TypedQuery<Quyen> query = entityManager.createQuery(sql.toString(), Quyen.class);
        if(ten != null && ten !=""){
            query.setParameter("ten","%" + ten.toString().toLowerCase() + "%");
        }

        if(ma != null && ma !=""){
            query.setParameter("ma","%" + ma.toString().toLowerCase() + "%");
        }
        if(pageable != null){
            return  query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer countQuyen(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object ten = null;
        Object ma = null;

        sql.append("select");
        sql.append(" count(q)");
        sql.append(" from Quyen q");
        sql.append(" where");
        sql.append(" q.id is not null and ");
        sql.append(" q.flag = true ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            ten = listSearchParams.get("ten");
            if(ten != null && ten != ""){
                sql.append(" AND LOWER(q.ten) LIKE :ten");
            }

            ma = listSearchParams.get("ma");
            if(ma != null && ma != ""){
                sql.append(" AND LOWER(q.ma) LIKE :ma");
            }
        }

        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);
        if(ten != null && ten !=""){
            query.setParameter("ten","%" + ten.toString().toLowerCase() + "%");
        }

        if(ma != null && ma !=""){
            query.setParameter("ma","%" + ma.toString().toLowerCase() + "%");
        }

        return ((Number) query.getSingleResult()).intValue();
    }
}
