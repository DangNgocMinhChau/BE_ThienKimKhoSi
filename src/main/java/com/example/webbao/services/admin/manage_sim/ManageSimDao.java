package com.example.webbao.services.admin.manage_sim;

import com.example.webbao.models.admin.manage_sim.ManageSim;
import com.example.webbao.models.configForm.ConfigForm;
import com.example.webbao.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class ManageSimDao {
    @Autowired
    private EntityManager entityManager;

    public List<ManageSim> getList(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object numberSeri = null;
        Object numberPhone = null;
        Object nameSim = null;
        Object typeSim = null;
        Object email = null;
        Object social = null;
        Object HSDSim = null;
        Object password = null;
        Object noteSim = null;

        sql.append("select");
        sql.append(" manageSim");
        sql.append(" from ManageSim manageSim");
        sql.append(" where");
        sql.append(" manageSim.id is not null and ");
        sql.append(" manageSim.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);


            numberSeri = listSearchParams.get("numberSeri");
            if (numberSeri != null && numberSeri != "") {
                sql.append(" AND LOWER(manageSim.numberSeri) LIKE :numberSeri");
            }
            numberPhone = listSearchParams.get("numberPhone");
            if (numberPhone != null && numberPhone != "") {
                sql.append(" AND LOWER(manageSim.numberPhone) LIKE :numberPhone");
            }
            nameSim = listSearchParams.get("nameSim");
            if (nameSim != null && nameSim != "") {
                sql.append(" AND LOWER(manageSim.nameSim) LIKE :nameSim");
            }
            typeSim = listSearchParams.get("typeSim");
            if (typeSim != null && typeSim != "") {
                sql.append(" AND LOWER(manageSim.typeSim) LIKE :typeSim");
            }
            email = listSearchParams.get("email");
            if (email != null && email != "") {
                sql.append(" AND LOWER(manageSim.email) LIKE :email");
            }
            social = listSearchParams.get("social");
            if (social != null && social != "") {
                sql.append(" AND LOWER(manageSim.fb) LIKE :fb");
            }

            HSDSim = listSearchParams.get("HSDSim");
            if (HSDSim != null && HSDSim != "") {
                sql.append(" AND LOWER(manageSim.HSDSim) LIKE :HSDSim");
            }
            password = listSearchParams.get("password");
            if (password != null && password != "") {
                sql.append(" AND LOWER(manageSim.password) LIKE :password");
            }

            noteSim = listSearchParams.get("noteSim");
            if (noteSim != null && noteSim != "") {
                sql.append(" AND LOWER(manageSim.noteSim) LIKE :noteSim");
            }
        }

        if (sortData != null) {
            String sortQuery = Util.convertSortDataWithAlias(sortData, "manageSim");
            sql.append(" ORDER BY " + sortQuery);
        }

        TypedQuery<ManageSim> query = entityManager.createQuery(sql.toString(), ManageSim.class);

        if (numberSeri != null && numberSeri != "") {
            query.setParameter("numberSeri", "%" + numberSeri.toString().toLowerCase() + "%");
        }
        if (numberPhone != null && numberPhone != "") {
            query.setParameter("numberPhone", "%" + numberPhone.toString().toLowerCase() + "%");
        }

        if (nameSim != null && nameSim != "") {
            query.setParameter("nameSim", "%" + nameSim.toString().toLowerCase() + "%");
        }


        if (typeSim != null && typeSim != "") {
            query.setParameter("typeSim", "%" + typeSim.toString().toLowerCase() + "%");
        }

        if (email != null && email != "") {
            query.setParameter("email", "%" + email.toString().toLowerCase() + "%");
        }
        if (social != null && social != "") {
            query.setParameter("social", "%" + social.toString().toLowerCase() + "%");
        }

        if (HSDSim != null && HSDSim != "") {
            query.setParameter("HSDSim", "%" + HSDSim.toString().toLowerCase() + "%");
        }
        if (password != null && password != "") {
            query.setParameter("password", "%" + password.toString().toLowerCase() + "%");
        }
        if (noteSim != null && noteSim != "") {
            query.setParameter("noteSim", "%" + noteSim.toString().toLowerCase() + "%");
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
        Object nameSim = null;
        Object typeSim = null;
        Object email = null;
        Object social = null;
        Object HSDSim = null;
        Object password = null;
        Object noteSim = null;

        sql.append("select");
        sql.append(" count(manageSim)");
        sql.append(" from ManageSim manageSim");
        sql.append(" where");
        sql.append(" manageSim.id is not null and ");
        sql.append(" manageSim.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            numberSeri = listSearchParams.get("numberSeri");
            if (numberSeri != null && numberSeri != "") {
                sql.append(" AND LOWER(manageSim.numberSeri) LIKE :numberSeri");
            }
            numberPhone = listSearchParams.get("numberPhone");
            if (numberPhone != null && numberPhone != "") {
                sql.append(" AND LOWER(manageSim.numberPhone) LIKE :numberPhone");
            }
            nameSim = listSearchParams.get("nameSim");
            if (nameSim != null && nameSim != "") {
                sql.append(" AND LOWER(manageSim.nameSim) LIKE :nameSim");
            }
            typeSim = listSearchParams.get("typeSim");
            if (typeSim != null && typeSim != "") {
                sql.append(" AND LOWER(manageSim.typeSim) LIKE :typeSim");
            }
            email = listSearchParams.get("email");
            if (email != null && email != "") {
                sql.append(" AND LOWER(manageSim.email) LIKE :email");
            }
            social = listSearchParams.get("fb");
            if (social != null && social != "") {
                sql.append(" AND LOWER(manageSim.fb) LIKE :fb");
            }
            HSDSim = listSearchParams.get("tiktok");
            if (HSDSim != null && HSDSim != "") {
                sql.append(" AND LOWER(manageSim.tiktok) LIKE :tiktok");
            }
            password = listSearchParams.get("password");
            if (password != null && password != "") {
                sql.append(" AND LOWER(manageSim.password) LIKE :password");
            }
            noteSim = listSearchParams.get("noteSim");
            if (noteSim != null && noteSim != "") {
                sql.append(" AND LOWER(manageSim.noteSim) LIKE :noteSim");
            }
        }

        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);
        if (numberSeri != null && numberSeri != "") {
            query.setParameter("numberSeri", "%" + numberSeri.toString().toLowerCase() + "%");
        }
        if (numberPhone != null && numberPhone != "") {
            query.setParameter("numberPhone", "%" + numberPhone.toString().toLowerCase() + "%");
        }

        if (nameSim != null && nameSim != "") {
            query.setParameter("nameSim", "%" + nameSim.toString().toLowerCase() + "%");
        }


        if (typeSim != null && typeSim != "") {
            query.setParameter("typeSim", "%" + typeSim.toString().toLowerCase() + "%");
        }

        if (email != null && email != "") {
            query.setParameter("email", "%" + email.toString().toLowerCase() + "%");
        }
        if (social != null && social != "") {
            query.setParameter("social", "%" + social.toString().toLowerCase() + "%");
        }
        if (HSDSim != null && HSDSim != "") {
            query.setParameter("HSDSim", "%" + HSDSim.toString().toLowerCase() + "%");
        }
        if (password != null && password != "") {
            query.setParameter("password", "%" + password.toString().toLowerCase() + "%");
        }
        if (noteSim != null && noteSim != "") {
            query.setParameter("noteSim", "%" + noteSim.toString().toLowerCase() + "%");
        }
        return ((Number) query.getSingleResult()).intValue();
    }
}
