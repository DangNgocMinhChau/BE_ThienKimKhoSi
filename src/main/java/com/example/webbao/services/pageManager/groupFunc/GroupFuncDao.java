package com.example.webbao.services.pageManager.groupFunc;

import com.example.webbao.models.pageManager.groupFunc.GroupFunc;
import com.example.webbao.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class GroupFuncDao {
    @Autowired
    private EntityManager entityManager;

    public List<GroupFunc> getList(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object nameGroupFunc = null;
        Object codeGroupFunc = null;
        Object groupFunc = null;

        sql.append("select");
        sql.append(" groupFunc");
        sql.append(" from GroupFunc groupFunc");
        sql.append(" where");
        sql.append(" groupFunc.id is not null and ");
        sql.append(" groupFunc.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);


            nameGroupFunc = listSearchParams.get("nameGroupFunc");
            if (nameGroupFunc != null && nameGroupFunc != "") {
                sql.append(" AND LOWER(groupFunc.nameGroupFunc) LIKE :nameGroupFunc");
            }
            codeGroupFunc = listSearchParams.get("codeGroupFunc");
            if (codeGroupFunc != null && codeGroupFunc != "") {
                sql.append(" AND LOWER(groupFunc.codeGroupFunc) LIKE :codeGroupFunc");
            }
            groupFunc = listSearchParams.get("groupFunc");
            if (groupFunc != null && groupFunc != "") {
                sql.append(" AND LOWER(groupFunc.groupFunc) LIKE :groupFunc");
            }

        }

        if (sortData != null) {
            String sortQuery = Util.convertSortDataWithAlias(sortData, "groupFunc");
            sql.append(" ORDER BY " + sortQuery);
        }
        TypedQuery<GroupFunc> query = entityManager.createQuery(sql.toString(), GroupFunc.class);

        if (nameGroupFunc != null && nameGroupFunc != "") {
            query.setParameter("nameGroupFunc", "%" + nameGroupFunc.toString().toLowerCase() + "%");
        }
        if (codeGroupFunc != null && codeGroupFunc != "") {
            query.setParameter("codeGroupFunc", "%" + codeGroupFunc.toString().toLowerCase() + "%");
        }

        if (groupFunc != null && groupFunc != "") {
            query.setParameter("groupFunc", "%" + groupFunc.toString().toLowerCase() + "%");
        }

        if (pageable != null) {
            return query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer count(String searchString) {
        StringBuilder sql = new StringBuilder();

        Object nameGroupFunc = null;
        Object codeGroupFunc = null;
        Object groupFunc = null;

        sql.append("select");
        sql.append(" count(groupFunc)");
        sql.append(" from GroupFunc groupFunc");
        sql.append(" where");
        sql.append(" groupFunc.id is not null and ");
        sql.append(" groupFunc.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);



            nameGroupFunc = listSearchParams.get("nameGroupFunc");
            if (nameGroupFunc != null && nameGroupFunc != "") {
                sql.append(" AND LOWER(groupFunc.nameGroupFunc) LIKE :nameGroupFunc");
            }
            codeGroupFunc = listSearchParams.get("codeGroupFunc");
            if (codeGroupFunc != null && codeGroupFunc != "") {
                sql.append(" AND LOWER(groupFunc.codeGroupFunc) LIKE :codeGroupFunc");
            }
            groupFunc = listSearchParams.get("groupFunc");
            if (groupFunc != null && groupFunc != "") {
                sql.append(" AND LOWER(groupFunc.groupFunc) LIKE :groupFunc");
            }

        }

        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);
        if (nameGroupFunc != null && nameGroupFunc != "") {
            query.setParameter("nameGroupFunc", "%" + nameGroupFunc.toString().toLowerCase() + "%");
        }
        if (codeGroupFunc != null && codeGroupFunc != "") {
            query.setParameter("codeGroupFunc", "%" + codeGroupFunc.toString().toLowerCase() + "%");
        }

        if (groupFunc != null && groupFunc != "") {
            query.setParameter("groupFunc", "%" + groupFunc.toString().toLowerCase() + "%");
        }

        return ((Number) query.getSingleResult()).intValue();
    }
}
