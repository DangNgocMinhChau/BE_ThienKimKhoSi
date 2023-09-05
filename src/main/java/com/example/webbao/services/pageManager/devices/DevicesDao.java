package com.example.webbao.services.pageManager.devices;

import com.example.webbao.models.pageManager.devices.Devices;
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
public class DevicesDao {
    @Autowired
    private EntityManager entityManager;
    public List<Devices> getList(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object environment = null;
        Object devices = null;
        Object proxy = null;
        Object apps = null;
        Object dateCreate = null;

        sql.append("select");
        sql.append(" devices");
        sql.append(" from Devices devices");
        sql.append(" where");
        sql.append(" devices.id is not null and ");
        sql.append(" devices.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);


            environment = listSearchParams.get("environment");
            if (environment != null && environment != "") {
                sql.append(" AND LOWER(devices.environment) LIKE :environment");
            }

            devices = listSearchParams.get("devices");
            if (devices != null && devices != "") {
                sql.append(" AND LOWER(devices.devices) LIKE :devices");
            }

            proxy = listSearchParams.get("proxy");
            if (proxy != null && proxy != "") {
                sql.append(" AND LOWER(devices.proxy) LIKE :proxy");
            }

            apps = listSearchParams.get("apps");
            if (apps != null && apps != "") {
                sql.append(" AND LOWER(devices.apps) LIKE :apps");
            }
            dateCreate = listSearchParams.get("dateCreate");
            if (dateCreate != null && dateCreate != "") {
                sql.append(" AND LOWER(devices.dateCreate) LIKE :dateCreate");
            }


        }

        if (sortData != null) {
            String sortQuery = Util.convertSortDataWithAlias(sortData, "devices");
            sql.append(" ORDER BY " + sortQuery);
        }

        TypedQuery<Devices> query = entityManager.createQuery(sql.toString(), Devices.class);

        if (environment != null && environment != "") {
            query.setParameter("environment", "%" + environment.toString().toLowerCase() + "%");
        }

        if (devices != null && devices != "") {
            query.setParameter("devices", "%" + devices.toString().toLowerCase() + "%");
        }


        if (proxy != null && proxy != "") {
            query.setParameter("proxy", "%" + proxy.toString().toLowerCase() + "%");
        }

        if (apps != null && apps != "") {
            query.setParameter("apps", "%" + apps.toString().toLowerCase() + "%");
        }

        if (dateCreate != null && dateCreate != "") {
            query.setParameter("dateCreate", "%" + dateCreate.toString().toLowerCase() + "%");
        }

        if (pageable != null) {
            return query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer count(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object environment = null;
        Object devices = null;
        Object proxy = null;
        Object apps = null;
        Object dateCreate = null;

        sql.append("select");
        sql.append(" count(devices)");
        sql.append(" from Devices devices");
        sql.append(" where");
        sql.append(" devices.id is not null and ");
        sql.append(" devices.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            environment = listSearchParams.get("environment");
            if (environment != null && environment != "") {
                sql.append(" AND LOWER(devices.environment) LIKE :environment");
            }

            devices = listSearchParams.get("devices");
            if (devices != null && devices != "") {
                sql.append(" AND LOWER(devices.devices) LIKE :devices");
            }

            proxy = listSearchParams.get("proxy");
            if (proxy != null && proxy != "") {
                sql.append(" AND LOWER(devices.proxy) LIKE :proxy");
            }

            apps = listSearchParams.get("apps");
            if (apps != null && apps != "") {
                sql.append(" AND LOWER(devices.apps) LIKE :apps");
            }
            dateCreate = listSearchParams.get("dateCreate");
            if (dateCreate != null && dateCreate != "") {
                sql.append(" AND LOWER(devices.dateCreate) LIKE :dateCreate");
            }
        }

        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);

        if (environment != null && environment != "") {
            query.setParameter("environment", "%" + environment.toString().toLowerCase() + "%");
        }

        if (devices != null && devices != "") {
            query.setParameter("devices", "%" + devices.toString().toLowerCase() + "%");
        }


        if (proxy != null && proxy != "") {
            query.setParameter("proxy", "%" + proxy.toString().toLowerCase() + "%");
        }

        if (apps != null && apps != "") {
            query.setParameter("apps", "%" + apps.toString().toLowerCase() + "%");
        }

        if (dateCreate != null && dateCreate != "") {
            query.setParameter("dateCreate", "%" + dateCreate.toString().toLowerCase() + "%");
        }

        return ((Number) query.getSingleResult()).intValue();
    }
}
