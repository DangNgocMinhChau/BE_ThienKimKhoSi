package com.example.webbao.services.configForm;

import com.example.webbao.models.configForm.DataConfigForm;
import com.example.webbao.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class DataConfigFormDao {
    @Autowired
    private EntityManager entityManager;

    public List<DataConfigForm> getList(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object codeForm = null;
        Object urlMapping = null;
        Object dataForm = null;
        Object idForm = null;

        sql.append("select");
        sql.append(" dataConfigForm");
        sql.append(" from DataConfigForm dataConfigForm");
        sql.append(" where");
        sql.append(" dataConfigForm.id is not null and ");
        sql.append(" dataConfigForm.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);


            codeForm = listSearchParams.get("codeForm");
            if (codeForm != null && codeForm != "") {
                sql.append(" AND LOWER(dataConfigForm.codeForm) LIKE :codeForm");
            }
            urlMapping = listSearchParams.get("urlMapping");
            if (urlMapping != null && urlMapping != "") {
                sql.append(" AND LOWER(dataConfigForm.urlMapping) LIKE :urlMapping");
            }

            dataForm = listSearchParams.get("dataForm");
            if (dataForm != null && dataForm != "") {
                sql.append(" AND LOWER(dataConfigForm.dataForm) LIKE :dataForm");
            }

            idForm = listSearchParams.get("idForm");
            if (idForm != null && idForm != "") {
                sql.append(" AND LOWER(dataConfigForm.idForm) LIKE :idForm");
            }

        }

        if (sortData != null) {
            String sortQuery = Util.convertSortDataWithAlias(sortData, "dataConfigForm");
            sql.append(" ORDER BY " + sortQuery);
        }
        TypedQuery<DataConfigForm> query = entityManager.createQuery(sql.toString(), DataConfigForm.class);

        if (codeForm != null && codeForm != "") {
            query.setParameter("codeForm", "%" + codeForm.toString().toLowerCase() + "%");
        }
        if (urlMapping != null && urlMapping != "") {
            query.setParameter("urlMapping", "%" + urlMapping.toString().toLowerCase() + "%");
        }

        if (dataForm != null && dataForm != "") {
            query.setParameter("dataForm", "%" + dataForm.toString().toLowerCase() + "%");
        }


        if (idForm != null && idForm != "") {
            query.setParameter("idForm", "%" + idForm.toString().toLowerCase() + "%");
        }

        if (pageable != null) {
            return query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer count(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object codeForm = null;
        Object urlMapping = null;
        Object dataForm = null;
        Object idForm = null;

        sql.append("select");
        sql.append(" count(dataConfigForm)");
        sql.append(" from DataConfigForm dataConfigForm");
        sql.append(" where");
        sql.append(" dataConfigForm.id is not null and ");
        sql.append(" dataConfigForm.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            codeForm = listSearchParams.get("codeForm");
            if (codeForm != null && codeForm != "") {
                sql.append(" AND LOWER(dataConfigForm.codeForm) LIKE :codeForm");
            }
            urlMapping = listSearchParams.get("urlMapping");
            if (urlMapping != null && urlMapping != "") {
                sql.append(" AND LOWER(dataConfigForm.urlMapping) LIKE :urlMapping");
            }

            dataForm = listSearchParams.get("dataForm");
            if (dataForm != null && dataForm != "") {
                sql.append(" AND LOWER(dataConfigForm.dataForm) LIKE :dataForm");
            }

            idForm = listSearchParams.get("idForm");
            if (idForm != null && idForm != "") {
                sql.append(" AND LOWER(dataConfigForm.idForm) LIKE :idForm");
            }
        }

        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);
        if (codeForm != null && codeForm != "") {
            query.setParameter("codeForm", "%" + codeForm.toString().toLowerCase() + "%");
        }
        if (urlMapping != null && urlMapping != "") {
            query.setParameter("urlMapping", "%" + urlMapping.toString().toLowerCase() + "%");
        }

        if (dataForm != null && dataForm != "") {
            query.setParameter("dataForm", "%" + dataForm.toString().toLowerCase() + "%");
        }


        if (idForm != null && idForm != "") {
            query.setParameter("idForm", "%" + idForm.toString().toLowerCase() + "%");
        }
        return ((Number) query.getSingleResult()).intValue();
    }
}
