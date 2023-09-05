package com.example.webbao.services.danhmuc.url;

import com.example.webbao.models.danhmuc.url.Url;
import com.example.webbao.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class UrlDao {
    @Autowired
    private EntityManager entityManager;

    public List<Url> getListUrl(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object ma = null;
        Object ten = null;
        Object stt = null;
        Object pId = null;
        Object level = null;

        sql.append("select");
        sql.append(" url");
        sql.append(" from Url url");
        sql.append(" where");
        sql.append(" url.id is not null and ");
        sql.append(" url.flag is true ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            ma = listSearchParams.get("ma");
            if(ma != null && ma != ""){
                sql.append(" AND LOWER(url.ma) LIKE :ma");
            }

            ten = listSearchParams.get("ten");
            if(ten != null && ten != ""){
                sql.append(" AND LOWER(url.ten) LIKE :ten");
            }


            stt = listSearchParams.get("stt");
            if(stt != null && stt != ""){
                sql.append(" AND LOWER(url.stt) LIKE :stt");
            }

            pId = listSearchParams.get("pId");
            if(pId != null && pId != ""){
                sql.append(" AND LOWER(url.pId) LIKE :pId");
            }

            level = listSearchParams.get("level");
            if(level != null && level != ""){
                sql.append(" AND LOWER(url.level) LIKE :level");
            }

        }

        if(sortData != null){
            String sortQuery = Util.convertSortDataWithAlias(sortData,"url");
            sql.append(" ORDER BY " + sortQuery);
        }

        TypedQuery<Url> query = entityManager.createQuery(sql.toString(), Url.class);
        if(ten != null && ten !=""){
            query.setParameter("ten","%" + ten.toString().toLowerCase() + "%");
        }

        if(ma != null && ma !=""){
            query.setParameter("ma","%" + ma.toString().toLowerCase() + "%");
        }

        if(stt != null && stt !=""){
            query.setParameter("stt","%" + stt.toString().toLowerCase() + "%");
        }

        if(pId != null && pId !=""){
            query.setParameter("pId","%" + pId.toString().toLowerCase() + "%");
        }

        if(level != null && level !=""){
            query.setParameter("level","%" + level.toString().toLowerCase() + "%");
        }

        if(pageable != null){
            return  query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer countUrl(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object ten = null;
        Object ma = null;
        Object stt = null;
        Object pId = null;
        Object level = null;

        sql.append("select");
        sql.append(" count(url)");
        sql.append(" from Url url");
        sql.append(" where");
        sql.append(" url.id is not null and ");
        sql.append(" url.flag = true ");

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
            pId = listSearchParams.get("pId");
            if(pId != null && pId != ""){
                sql.append(" AND LOWER(url.pId) LIKE :pId");
            }

            level = listSearchParams.get("level");
            if(level != null && level != ""){
                sql.append(" AND LOWER(url.level) LIKE :level");
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

        if(pId != null && pId !=""){
            query.setParameter("pId","%" + pId.toString().toLowerCase() + "%");
        }

        if(level != null && level !=""){
            query.setParameter("level","%" + level.toString().toLowerCase() + "%");
        }
        return ((Number) query.getSingleResult()).intValue();
    }
}
