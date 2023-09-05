package com.example.webbao.services.orderform;

import com.example.webbao.models.lienhequangcao.LienHeQuangCao;
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
public class OrderFormDao {
    @Autowired
    private EntityManager entityManager;

    public List<OrderForm> getList(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object url = null;
        Object Api = null;
        Object formName = null;
        Object typeForms = null;
        Object notes = null;
        Object formMapping = null;


        sql.append("select");
        sql.append(" odform");
        sql.append(" from OrderForm odform");
        sql.append(" where");
        sql.append(" odform.id is not null and ");
        sql.append(" odform.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);


            url = listSearchParams.get("url");
            if (url != null && url != "") {
                sql.append(" AND LOWER(odform.url) LIKE :url");
            }
            Api = listSearchParams.get("Api");
            if (Api != null && Api != "") {
                sql.append(" AND LOWER(odform.Api) LIKE :Api");
            }

            formName = listSearchParams.get("formName");
            if (formName != null && formName != "") {
                sql.append(" AND LOWER(odform.formName) LIKE :formName");
            }

            typeForms = listSearchParams.get("typeForms");
            if (typeForms != null && typeForms != "") {
                sql.append(" AND LOWER(odform.typeForms) LIKE :typeForms");
            }

            notes = listSearchParams.get("notes");
            if (notes != null && notes != "") {
                sql.append(" AND LOWER(odform.notes) LIKE :notes");
            }

            formMapping = listSearchParams.get("formMapping");
            if (formMapping != null && formMapping != "") {
                sql.append(" AND LOWER(odform.formMapping) LIKE :formMapping");
            }

        }

        if (sortData != null) {
            String sortQuery = Util.convertSortDataWithAlias(sortData, "odform");
            sql.append(" ORDER BY " + sortQuery);
        }
        TypedQuery<OrderForm> query = entityManager.createQuery(sql.toString(), OrderForm.class);

        if (Api != null && Api != "") {
            query.setParameter("Api", "%" + Api.toString().toLowerCase() + "%");
        }
        if (url != null && url != "") {
            query.setParameter("url", "%" + url.toString().toLowerCase() + "%");
        }

        if (formName != null && formName != "") {
            query.setParameter("formName", "%" + formName.toString().toLowerCase() + "%");
        }


        if (typeForms != null && typeForms != "") {
            query.setParameter("typeForms", "%" + typeForms.toString().toLowerCase() + "%");
        }

        if (notes != null && notes != "") {
            query.setParameter("notes", "%" + notes.toString().toLowerCase() + "%");
        }

        if (formMapping != null && formMapping != "") {
            query.setParameter("formMapping", "%" + formMapping.toString().toLowerCase() + "%");
        }

        if (pageable != null) {
            return query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer count(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object url = null;
        Object Api = null;
        Object formName = null;
        Object typeForms = null;
        Object notes = null;
        Object formMapping = null;

        sql.append("select");
        sql.append(" count(odform)");
        sql.append(" from OrderForm odform");
        sql.append(" where");
        sql.append(" odform.id is not null and ");
        sql.append(" odform.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            url = listSearchParams.get("url");
            if (url != null && url != "") {
                sql.append(" AND LOWER(odform.url) LIKE :url");
            }
            Api = listSearchParams.get("url");
            if (Api != null && Api != "") {
                sql.append(" AND LOWER(odform.Api) LIKE :Api");
            }
            formName = listSearchParams.get("formName");
            if (formName != null && formName != "") {
                sql.append(" AND LOWER(odform.formName) LIKE :formName");
            }
            typeForms = listSearchParams.get("typeForms");
            if (typeForms != null && typeForms != "") {
                sql.append(" AND LOWER(odform.typeForms) LIKE :typeForms");
            }
            notes = listSearchParams.get("notes");
            if (notes != null && notes != "") {
                sql.append(" AND LOWER(odform.notes) LIKE :notes");
            }
            formMapping = listSearchParams.get("formMapping");
            if (formMapping != null && formMapping != "") {
                sql.append(" AND LOWER(odform.formMapping) LIKE :formMapping");
            }


        }


        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);
        if (Api != null && Api != "") {
            query.setParameter("Api", "%" + Api.toString().toLowerCase() + "%");
        }
        if (url != null && url != "") {
            query.setParameter("url", "%" + url.toString().toLowerCase() + "%");
        }

        if (formName != null && formName != "") {
            query.setParameter("formName", "%" + formName.toString().toLowerCase() + "%");
        }


        if (typeForms != null && typeForms != "") {
            query.setParameter("typeForms", "%" + typeForms.toString().toLowerCase() + "%");
        }

        if (notes != null && notes != "") {
            query.setParameter("notes", "%" + notes.toString().toLowerCase() + "%");
        }

        if (formMapping != null && formMapping != "") {
            query.setParameter("formMapping", "%" + formMapping.toString().toLowerCase() + "%");
        }

        return ((Number) query.getSingleResult()).intValue();
    }
}
