package com.example.webbao.services.pageManager.menu;

import com.example.webbao.models.donggopykien.DongGopYKien;
import com.example.webbao.models.pageManager.menu.MenuCore;
import com.example.webbao.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class MenuCoreDao {
    @Autowired
    private EntityManager entityManager;
    public List<MenuCore> getList(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object nameMenu = null;
        Object urlMapping = null;
        Object iconMenu = null;
        Object typeMenu = null;
        Object pid = null;
        Object checkUrlId = null;

        sql.append("select");
        sql.append(" menu");
        sql.append(" from MenuCore menu");
        sql.append(" where");
        sql.append(" menu.id is not null and ");
        sql.append(" menu.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);


            nameMenu = listSearchParams.get("nameMenu");
            if (nameMenu != null && nameMenu != "") {
                sql.append(" AND LOWER(menu.nameMenu) LIKE :nameMenu");
            }

            urlMapping = listSearchParams.get("urlMapping");
            if (urlMapping != null && urlMapping != "") {
                sql.append(" AND LOWER(menu.urlMapping) LIKE :urlMapping");
            }

            iconMenu = listSearchParams.get("iconMenu");
            if (iconMenu != null && iconMenu != "") {
                sql.append(" AND LOWER(menu.iconMenu) LIKE :iconMenu");
            }

            typeMenu = listSearchParams.get("typeMenu");
            if (typeMenu != null && typeMenu != "") {
                sql.append(" AND LOWER(menu.typeMenu) LIKE :typeMenu");
            }

            pid = listSearchParams.get("pid");
            if (pid != null && pid != "") {
                sql.append(" AND LOWER(menu.pid) LIKE :pid");
            }
            checkUrlId = listSearchParams.get("checkUrlId");
            if (checkUrlId != null && checkUrlId != "") {
                sql.append(" AND LOWER(menu.checkUrlId) LIKE :checkUrlId");
            }


        }

        if (sortData != null) {
            String sortQuery = Util.convertSortDataWithAlias(sortData, "menu");
            sql.append(" ORDER BY " + sortQuery);
        }

        TypedQuery<MenuCore> query = entityManager.createQuery(sql.toString(), MenuCore.class);
        if (nameMenu != null && nameMenu != "") {
            query.setParameter("nameMenu", "%" + nameMenu.toString().toLowerCase() + "%");
        }

        if (urlMapping != null && urlMapping != "") {
            query.setParameter("urlMapping", "%" + urlMapping.toString().toLowerCase() + "%");
        }


        if (iconMenu != null && iconMenu != "") {
            query.setParameter("iconMenu", "%" + iconMenu.toString().toLowerCase() + "%");
        }

        if (typeMenu != null && typeMenu != "") {
            query.setParameter("typeMenu", "%" + typeMenu.toString().toLowerCase() + "%");
        }

        if (pid != null && pid != "") {
            query.setParameter("pid", "%" + pid.toString().toLowerCase() + "%");
        }
        if (checkUrlId != null && checkUrlId != "") {
            query.setParameter("checkUrlId", "%" + checkUrlId.toString().toLowerCase() + "%");
        }

        if (pageable != null) {
            return query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer count(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object nameMenu = null;
        Object urlMapping = null;
        Object iconMenu = null;
        Object typeMenu = null;
        Object pid = null;
        Object checkUrlId = null;

        sql.append("select");
        sql.append(" count(menu)");
        sql.append(" from MenuCore menu");
        sql.append(" where");
        sql.append(" menu.id is not null and ");
        sql.append(" menu.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            nameMenu = listSearchParams.get("nameMenu");
            if (nameMenu != null && nameMenu != "") {
                sql.append(" AND LOWER(menu.nameMenu) LIKE :nameMenu");
            }

            urlMapping = listSearchParams.get("urlMapping");
            if (urlMapping != null && urlMapping != "") {
                sql.append(" AND LOWER(menu.urlMapping) LIKE :urlMapping");
            }

            iconMenu = listSearchParams.get("iconMenu");
            if (iconMenu != null && iconMenu != "") {
                sql.append(" AND LOWER(menu.iconMenu) LIKE :iconMenu");
            }

            typeMenu = listSearchParams.get("typeMenu");
            if (typeMenu != null && typeMenu != "") {
                sql.append(" AND LOWER(menu.typeMenu) LIKE :typeMenu");
            }

            pid = listSearchParams.get("pid");
            if (pid != null && pid != "") {
                sql.append(" AND LOWER(menu.pid) LIKE :pid");
            }

            checkUrlId = listSearchParams.get("checkUrlId");
            if (checkUrlId != null && checkUrlId != "") {
                sql.append(" AND LOWER(menu.checkUrlId) LIKE :checkUrlId");
            }
        }


        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);
        if (nameMenu != null && nameMenu != "") {
            query.setParameter("nameMenu", "%" + nameMenu.toString().toLowerCase() + "%");
        }

        if (urlMapping != null && urlMapping != "") {
            query.setParameter("urlMapping", "%" + urlMapping.toString().toLowerCase() + "%");
        }


        if (iconMenu != null && iconMenu != "") {
            query.setParameter("iconMenu", "%" + iconMenu.toString().toLowerCase() + "%");
        }

        if (typeMenu != null && typeMenu != "") {
            query.setParameter("typeMenu", "%" + typeMenu.toString().toLowerCase() + "%");
        }

        if (pid != null && pid != "") {
            query.setParameter("pid", "%" + pid.toString().toLowerCase() + "%");
        }
        if (checkUrlId != null && checkUrlId != "") {
            query.setParameter("checkUrlId", "%" + checkUrlId.toString().toLowerCase() + "%");
        }

        return ((Number) query.getSingleResult()).intValue();
    }
}
