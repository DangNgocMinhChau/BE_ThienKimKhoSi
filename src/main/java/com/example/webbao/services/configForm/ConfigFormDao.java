package com.example.webbao.services.configForm;

import com.example.webbao.models.configForm.ConfigForm;
import com.example.webbao.models.orderform.OrderForm;
import com.example.webbao.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class ConfigFormDao {
    @Autowired
    private EntityManager entityManager;

    public List<ConfigForm> getList(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object codeForm = null;
        Object menuMapping = null;
        Object nameForm = null;
        Object typeForm = null;
        Object fieldMapform = null;

        sql.append("select");
        sql.append(" configForm");
        sql.append(" from ConfigForm configForm");
        sql.append(" where");
        sql.append(" configForm.id is not null and ");
        sql.append(" configForm.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);


            codeForm = listSearchParams.get("codeForm");
            if (codeForm != null && codeForm != "") {
                sql.append(" AND LOWER(configForm.codeForm) LIKE :codeForm");
            }
            menuMapping = listSearchParams.get("menuMapping");
            if (menuMapping != null && menuMapping != "") {
                sql.append(" AND LOWER(configForm.menuMapping) LIKE :menuMapping");
            }

            nameForm = listSearchParams.get("nameForm");
            if (nameForm != null && nameForm != "") {
                sql.append(" AND LOWER(configForm.nameForm) LIKE :nameForm");
            }

            typeForm = listSearchParams.get("typeForm");
            if (typeForm != null && typeForm != "") {
                sql.append(" AND LOWER(configForm.typeForm) LIKE :typeForm");
            }

            fieldMapform = listSearchParams.get("fieldMapform");
            if (fieldMapform != null && fieldMapform != "") {
                sql.append(" AND LOWER(configForm.fieldMapform) LIKE :fieldMapform");
            }

        }

        if (sortData != null) {
            String sortQuery = Util.convertSortDataWithAlias(sortData, "configForm");
            sql.append(" ORDER BY " + sortQuery);
        }
        TypedQuery<ConfigForm> query = entityManager.createQuery(sql.toString(), ConfigForm.class);

        if (codeForm != null && codeForm != "") {
            query.setParameter("codeForm", "%" + codeForm.toString().toLowerCase() + "%");
        }
        if (menuMapping != null && menuMapping != "") {
            query.setParameter("menuMapping", "%" + menuMapping.toString().toLowerCase() + "%");
        }

        if (nameForm != null && nameForm != "") {
            query.setParameter("nameForm", "%" + nameForm.toString().toLowerCase() + "%");
        }


        if (typeForm != null && typeForm != "") {
            query.setParameter("typeForm", "%" + typeForm.toString().toLowerCase() + "%");
        }

        if (fieldMapform != null && fieldMapform != "") {
            query.setParameter("fieldMapform", "%" + fieldMapform.toString().toLowerCase() + "%");
        }

        if (pageable != null) {
            return query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer count(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object codeForm = null;
        Object menuMapping = null;
        Object nameForm = null;
        Object typeForm = null;
        Object fieldMapform = null;

        sql.append("select");
        sql.append(" count(configForm)");
        sql.append(" from ConfigForm configForm");
        sql.append(" where");
        sql.append(" configForm.id is not null and ");
        sql.append(" configForm.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            codeForm = listSearchParams.get("codeForm");
            if (codeForm != null && codeForm != "") {
                sql.append(" AND LOWER(configForm.codeForm) LIKE :codeForm");
            }
            menuMapping = listSearchParams.get("menuMapping");
            if (menuMapping != null && menuMapping != "") {
                sql.append(" AND LOWER(configForm.menuMapping) LIKE :menuMapping");
            }

            nameForm = listSearchParams.get("nameForm");
            if (nameForm != null && nameForm != "") {
                sql.append(" AND LOWER(configForm.nameForm) LIKE :nameForm");
            }

            typeForm = listSearchParams.get("typeForm");
            if (typeForm != null && typeForm != "") {
                sql.append(" AND LOWER(configForm.typeForm) LIKE :typeForm");
            }

            fieldMapform = listSearchParams.get("fieldMapform");
            if (fieldMapform != null && fieldMapform != "") {
                sql.append(" AND LOWER(configForm.fieldMapform) LIKE :fieldMapform");
            }
        }

        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);
        if (codeForm != null && codeForm != "") {
            query.setParameter("codeForm", "%" + codeForm.toString().toLowerCase() + "%");
        }
        if (menuMapping != null && menuMapping != "") {
            query.setParameter("menuMapping", "%" + menuMapping.toString().toLowerCase() + "%");
        }

        if (nameForm != null && nameForm != "") {
            query.setParameter("nameForm", "%" + nameForm.toString().toLowerCase() + "%");
        }


        if (typeForm != null && typeForm != "") {
            query.setParameter("typeForm", "%" + typeForm.toString().toLowerCase() + "%");
        }

        if (fieldMapform != null && fieldMapform != "") {
            query.setParameter("fieldMapform", "%" + fieldMapform.toString().toLowerCase() + "%");
        }

        return ((Number) query.getSingleResult()).intValue();
    }
}
