package com.example.webbao.services.pageManager.sim;

import com.example.webbao.models.pageManager.menu.MenuCore;
import com.example.webbao.models.pageManager.sim.Sim;
import com.example.webbao.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class SimDao {
    @Autowired
    private EntityManager entityManager;
    public List<Sim> getList(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object numberSeri = null;
        Object numberPhone = null;
        Object typeSim = null;
        Object hsdsim = null;

        sql.append("select");
        sql.append(" sim");
        sql.append(" from Sim sim");
        sql.append(" where");
        sql.append(" sim.id is not null and ");
        sql.append(" sim.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);


            numberSeri = listSearchParams.get("numberSeri");
            if (numberSeri != null && numberSeri != "") {
                sql.append(" AND LOWER(sim.numberSeri) LIKE :numberSeri");
            }

            numberPhone = listSearchParams.get("numberPhone");
            if (numberPhone != null && numberPhone != "") {
                sql.append(" AND LOWER(sim.numberPhone) LIKE :numberPhone");
            }
            typeSim = listSearchParams.get("typeSim");
            if (typeSim != null && typeSim != "") {
                sql.append(" AND LOWER(sim.typeSim) LIKE :typeSim");
            }
            hsdsim = listSearchParams.get("hsdsim");
            if (hsdsim != null && hsdsim != "") {
                sql.append(" AND LOWER(sim.hsdsim) LIKE :hsdsim");
            }

        }

        if (sortData != null) {
            String sortQuery = Util.convertSortDataWithAlias(sortData, "sim");
            sql.append(" ORDER BY " + sortQuery);
        }

        TypedQuery<Sim> query = entityManager.createQuery(sql.toString(), Sim.class);
        if (numberSeri != null && numberSeri != "") {
            query.setParameter("numberSeri", "%" + numberSeri.toString().toLowerCase() + "%");
        }

        if (numberPhone != null && numberPhone != "") {
            query.setParameter("numberPhone", "%" + numberPhone.toString().toLowerCase() + "%");
        }


        if (typeSim != null && typeSim != "") {
            query.setParameter("typeSim", "%" + typeSim.toString().toLowerCase() + "%");
        }

        if (hsdsim != null && hsdsim != "") {
            query.setParameter("hsdsim", "%" + hsdsim.toString().toLowerCase() + "%");
        }

        if (pageable != null) {
            return query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer count(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object numberSeri = null;
        Object numberPhone = null;
        Object typeSim = null;
        Object hsdsim = null;

        sql.append("select");
        sql.append(" count(sim)");
        sql.append(" from Sim sim");
        sql.append(" where");
        sql.append(" sim.id is not null and ");
        sql.append(" sim.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            numberSeri = listSearchParams.get("numberSeri");
            if (numberSeri != null && numberSeri != "") {
                sql.append(" AND LOWER(sim.numberSeri) LIKE :numberSeri");
            }

            numberPhone = listSearchParams.get("numberPhone");
            if (numberPhone != null && numberPhone != "") {
                sql.append(" AND LOWER(sim.numberPhone) LIKE :numberPhone");
            }
            typeSim = listSearchParams.get("typeSim");
            if (typeSim != null && typeSim != "") {
                sql.append(" AND LOWER(sim.typeSim) LIKE :typeSim");
            }
            hsdsim = listSearchParams.get("hsdsim");
            if (hsdsim != null && hsdsim != "") {
                sql.append(" AND LOWER(sim.hsdsim) LIKE :hsdsim");
            }
        }

        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);

        if (numberSeri != null && numberSeri != "") {
            query.setParameter("numberSeri", "%" + numberSeri.toString().toLowerCase() + "%");
        }

        if (numberPhone != null && numberPhone != "") {
            query.setParameter("numberPhone", "%" + numberPhone.toString().toLowerCase() + "%");
        }


        if (typeSim != null && typeSim != "") {
            query.setParameter("typeSim", "%" + typeSim.toString().toLowerCase() + "%");
        }

        if (hsdsim != null && hsdsim != "") {
            query.setParameter("hsdsim", "%" + hsdsim.toString().toLowerCase() + "%");
        }
        return ((Number) query.getSingleResult()).intValue();
    }
}
