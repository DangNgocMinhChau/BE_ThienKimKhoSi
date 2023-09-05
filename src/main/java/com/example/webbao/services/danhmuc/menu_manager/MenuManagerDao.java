package com.example.webbao.services.danhmuc.menu_manager;

import com.example.webbao.models.danhmuc.menu_manager.MenuManager;
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
public class MenuManagerDao {
    @Autowired
    private EntityManager entityManager;

    public List<MenuManager> getListMenuManager(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object ma = null;
        Object ten = null;
        Object stt = null;
        Object nhomMenu = null;
        Object url = null;

        sql.append("select");
        sql.append(" menu");
        sql.append(" from MenuManager menu");
        sql.append(" where");
        sql.append(" menu.id is not null and ");
        sql.append(" menu.flag = true ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            ma = listSearchParams.get("ma");
            if(ma != null && ma != ""){
                sql.append(" AND LOWER(menu.ma) LIKE :ma");
            }

            ten = listSearchParams.get("ten");
            if(ten != null && ten != ""){
                sql.append(" AND LOWER(menu.ten) LIKE :ten");
            }

            stt = listSearchParams.get("stt");
            if(stt != null && ten != ""){
                sql.append(" AND LOWER(menu.stt) LIKE :stt");
            }

            nhomMenu = listSearchParams.get("nhomMenu");
            if(nhomMenu != null && nhomMenu != ""){
                sql.append(" AND LOWER(menu.nhomMenu) LIKE :nhomMenu");
            }
            url = listSearchParams.get("url");
            if(url != null && url != ""){
                sql.append(" AND LOWER(menu.url) LIKE :url");
            }
        }

        if(sortData != null){
            String sortQuery = Util.convertSortDataWithAlias(sortData,"menu");
            sql.append(" ORDER BY " + sortQuery);
        }

        TypedQuery<MenuManager> query = entityManager.createQuery(sql.toString(), MenuManager.class);
        if(ten != null && ten !=""){
            query.setParameter("ten","%" + ten.toString().toLowerCase() + "%");
        }

        if(ma != null && ma !=""){
            query.setParameter("ma","%" + ma.toString().toLowerCase() + "%");
        }

        if(stt != null && stt !=""){
            query.setParameter("stt","%" + stt.toString().toLowerCase() + "%");
        }

        if(nhomMenu != null && nhomMenu !=""){
            query.setParameter("nhomMenu","%" + nhomMenu.toString().toLowerCase() + "%");
        }
        if(url != null && url !=""){
            query.setParameter("url","%" + url.toString().toLowerCase() + "%");
        }
        if(pageable != null){
            return  query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer countMenuManager(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object ten = null;
        Object ma = null;
        Object stt = null;
        Object nhomMenu = null;
        Object url = null;

        sql.append("select");
        sql.append(" count(menu)");
        sql.append(" from ThanhMenu menu");
        sql.append(" where");
        sql.append(" menu.id is not null and ");
        sql.append(" menu.flag = true ");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            ten = listSearchParams.get("ten");
            if(ten != null && ten != ""){
                sql.append(" AND LOWER(menu.ten) LIKE :ten");
            }

            ma = listSearchParams.get("ma");
            if(ma != null && ma != ""){
                sql.append(" AND LOWER(menu.ma) LIKE :ma");
            }

            stt = listSearchParams.get("stt");
            if(stt != null && stt != ""){
                sql.append(" AND LOWER(menu.stt) LIKE :stt");
            }

            nhomMenu = listSearchParams.get("nhomMenu");
            if(nhomMenu != null && nhomMenu != ""){
                sql.append(" AND LOWER(menu.nhomMenu) LIKE :nhomMenu");
            }

            url = listSearchParams.get("url");
            if(url != null && url != ""){
                sql.append(" AND LOWER(menu.url) LIKE :url");
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

        if(nhomMenu != null && nhomMenu !=""){
            query.setParameter("nhomMenu","%" + nhomMenu.toString().toLowerCase() + "%");
        }

        if(url != null && url !=""){
            query.setParameter("url","%" + url.toString().toLowerCase() + "%");
        }
        return ((Number) query.getSingleResult()).intValue();
    }
}
