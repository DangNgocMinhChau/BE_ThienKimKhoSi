package com.example.webbao.services.pageManager.via;

import com.example.webbao.models.pageManager.devices.Devices;
import com.example.webbao.models.pageManager.via.Vias;
import com.example.webbao.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class ViasDao {
    @Autowired
    private EntityManager entityManager;
    public List<Vias> getList(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object typeApps = null;
        Object numberPhone = null;
        Object device = null;
        Object nameVia = null;
        Object passZalo = null;
        Object dateCreate = null;

        sql.append("select");
        sql.append(" vias");
        sql.append(" from Vias vias");
        sql.append(" where");
        sql.append(" vias.id is not null and ");
        sql.append(" vias.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);


            typeApps = listSearchParams.get("typeApps");
            if (typeApps != null && typeApps != "") {
                sql.append(" AND LOWER(vias.typeApps) LIKE :typeApps");
            }
            numberPhone = listSearchParams.get("numberPhone");
            if (numberPhone != null && numberPhone != "") {
                sql.append(" AND LOWER(vias.numberPhone) LIKE :numberPhone");
            }
            device = listSearchParams.get("device");
            if (device != null && device != "") {
                sql.append(" AND LOWER(vias.device) LIKE :device");
            }
            nameVia = listSearchParams.get("nameVia");
            if (nameVia != null && nameVia != "") {
                sql.append(" AND LOWER(vias.nameVia) LIKE :nameVia");
            }
            passZalo = listSearchParams.get("passZalo");
            if (passZalo != null && passZalo != "") {
                sql.append(" AND LOWER(vias.passZalo) LIKE :passZalo");
            }
            dateCreate = listSearchParams.get("dateCreate");
            if (dateCreate != null && dateCreate != "") {
                sql.append(" AND LOWER(devices.dateCreate) LIKE :dateCreate");
            }
        }

        if (sortData != null) {
            String sortQuery = Util.convertSortDataWithAlias(sortData, "vias");
            sql.append(" ORDER BY " + sortQuery);
        }

        TypedQuery<Vias> query = entityManager.createQuery(sql.toString(), Vias.class);

        if (typeApps != null && typeApps != "") {
            query.setParameter("vias", "%" + typeApps.toString().toLowerCase() + "%");
        }
        if (numberPhone != null && numberPhone != "") {
            query.setParameter("vias", "%" + numberPhone.toString().toLowerCase() + "%");
        }
        if (device != null && device != "") {
            query.setParameter("vias", "%" + device.toString().toLowerCase() + "%");
        }
        if (nameVia != null && nameVia != "") {
            query.setParameter("vias", "%" + nameVia.toString().toLowerCase() + "%");
        }
        if (passZalo != null && passZalo != "") {
            query.setParameter("vias", "%" + passZalo.toString().toLowerCase() + "%");
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
        Object typeApps = null;
        Object numberPhone = null;
        Object device = null;
        Object nameVia = null;
        Object passZalo = null;
        Object dateCreate = null;

        sql.append("select");
        sql.append(" count(vias)");
        sql.append(" from Vias vias");
        sql.append(" where");
        sql.append(" vias.id is not null and ");
        sql.append(" vias.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            typeApps = listSearchParams.get("typeApps");
            if (typeApps != null && typeApps != "") {
                sql.append(" AND LOWER(vias.typeApps) LIKE :typeApps");
            }
            numberPhone = listSearchParams.get("numberPhone");
            if (numberPhone != null && numberPhone != "") {
                sql.append(" AND LOWER(vias.numberPhone) LIKE :numberPhone");
            }
            device = listSearchParams.get("device");
            if (device != null && device != "") {
                sql.append(" AND LOWER(vias.device) LIKE :device");
            }
            nameVia = listSearchParams.get("nameVia");
            if (nameVia != null && nameVia != "") {
                sql.append(" AND LOWER(vias.nameVia) LIKE :nameVia");
            }
            passZalo = listSearchParams.get("passZalo");
            if (passZalo != null && passZalo != "") {
                sql.append(" AND LOWER(vias.passZalo) LIKE :passZalo");
            }
            dateCreate = listSearchParams.get("dateCreate");
            if (dateCreate != null && dateCreate != "") {
                sql.append(" AND LOWER(devices.dateCreate) LIKE :dateCreate");
            }
        }

        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);

        if (typeApps != null && typeApps != "") {
            query.setParameter("vias", "%" + typeApps.toString().toLowerCase() + "%");
        }
        if (numberPhone != null && numberPhone != "") {
            query.setParameter("vias", "%" + numberPhone.toString().toLowerCase() + "%");
        }
        if (device != null && device != "") {
            query.setParameter("vias", "%" + device.toString().toLowerCase() + "%");
        }
        if (nameVia != null && nameVia != "") {
            query.setParameter("vias", "%" + nameVia.toString().toLowerCase() + "%");
        }
        if (passZalo != null && passZalo != "") {
            query.setParameter("vias", "%" + passZalo.toString().toLowerCase() + "%");
        }

        if (dateCreate != null && dateCreate != "") {
            query.setParameter("dateCreate", "%" + dateCreate.toString().toLowerCase() + "%");
        }

        return ((Number) query.getSingleResult()).intValue();
    }
}
