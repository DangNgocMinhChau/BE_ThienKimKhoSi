package com.example.webbao.services.donggopykien;

import com.example.webbao.models.donggopykien.DongGopYKien;
import com.example.webbao.models.lienhequangcao.LienHeQuangCao;
import com.example.webbao.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class DongGopYKienDao {
    @Autowired
    private EntityManager entityManager;

    public List<DongGopYKien> getListdgyk(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object email = null;
        Object ten = null;
        Object sdt = null;
        Object diaChi = null;
        Object tieuDe = null;
        Object noiDung = null;
        Object daTraLoi = null;


        sql.append("select");
        sql.append(" dgyk");
        sql.append(" from DongGopYKien dgyk");
        sql.append(" where");
        sql.append(" dgyk.id is not null and ");
        sql.append(" dgyk.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);


            ten = listSearchParams.get("ten");
            if (ten != null && ten != "") {
                sql.append(" AND LOWER(dgyk.ten) LIKE :ten");
            }
            sdt = listSearchParams.get("sdt");
            if (sdt != null && ten != "") {
                sql.append(" AND LOWER(dgyk.sdt) LIKE :sdt");
            }

            email = listSearchParams.get("email");
            if (email != null && email != "") {
                sql.append(" AND LOWER(dgyk.email) LIKE :email");
            }

            diaChi = listSearchParams.get("diaChi");
            if (diaChi != null && diaChi != "") {
                sql.append(" AND LOWER(dgyk.diaChi) LIKE :diaChi");
            }

            tieuDe = listSearchParams.get("tieuDe");
            if (tieuDe != null && tieuDe != "") {
                sql.append(" AND LOWER(dgyk.tieuDe) LIKE :tieuDe");
            }

            noiDung = listSearchParams.get("noiDung");
            if (noiDung != null && noiDung != "") {
                sql.append(" AND LOWER(dgyk.noiDung) LIKE :noiDung");
            }
            daTraLoi = listSearchParams.get("daTraLoi");
            if (daTraLoi != null && daTraLoi != "") {
                sql.append(" AND LOWER(dgyk.daTraLoi) LIKE :daTraLoi");
            }
        }

        if (sortData != null) {
            String sortQuery = Util.convertSortDataWithAlias(sortData, "dgyk");
            sql.append(" ORDER BY " + sortQuery);
        }

        TypedQuery<DongGopYKien> query = entityManager.createQuery(sql.toString(), DongGopYKien.class);
        if (ten != null && ten != "") {
            query.setParameter("ten", "%" + ten.toString().toLowerCase() + "%");
        }

        if (email != null && email != "") {
            query.setParameter("email", "%" + email.toString().toLowerCase() + "%");
        }


        if (sdt != null && sdt != "") {
            query.setParameter("sdt", "%" + sdt.toString().toLowerCase() + "%");
        }

        if (diaChi != null && diaChi != "") {
            query.setParameter("diaChi", "%" + diaChi.toString().toLowerCase() + "%");
        }

        if (tieuDe != null && tieuDe != "") {
            query.setParameter("tieuDe", "%" + tieuDe.toString().toLowerCase() + "%");
        }

        if (noiDung != null && noiDung != "") {
            query.setParameter("noiDung", "%" + noiDung.toString().toLowerCase() + "%");
        }

        if (daTraLoi != null && daTraLoi != "") {
            query.setParameter("daTraLoi", "%" + daTraLoi.toString().toLowerCase() + "%");
        }


        if (pageable != null) {
            return query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer countDGYK(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object email = null;
        Object ten = null;
        Object sdt = null;
        Object diaChi = null;
        Object tieuDe = null;
        Object noiDung = null;
        Object daTraLoi = null;

        sql.append("select");
        sql.append(" count(dgyk)");
        sql.append(" from DongGopYKien dgyk");
        sql.append(" where");
        sql.append(" dgyk.id is not null and ");
        sql.append(" dgyk.flag = true ");

        if (searchString != null & searchString != "") {
            Map<String, String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            ten = listSearchParams.get("ten");
            if (ten != null && ten != "") {
                sql.append(" AND LOWER(dgyk.ten) LIKE :ten");
            }

            sdt = listSearchParams.get("sdt");
            if (sdt != null && ten != "") {
                sql.append(" AND LOWER(dgyk.sdt) LIKE :sdt");
            }

            email = listSearchParams.get("email");
            if (email != null && email != "") {
                sql.append(" AND LOWER(dgyk.email) LIKE :email");
            }
            diaChi = listSearchParams.get("diaChi");
            if (diaChi != null && diaChi != "") {
                sql.append(" AND LOWER(dgyk.diaChi) LIKE :diaChi");
            }

            tieuDe = listSearchParams.get("tieuDe");
            if (tieuDe != null && tieuDe != "") {
                sql.append(" AND LOWER(dgyk.tieuDe) LIKE :tieuDe");
            }

            noiDung = listSearchParams.get("noiDung");
            if (noiDung != null && noiDung != "") {
                sql.append(" AND LOWER(dgyk.noiDung) LIKE :noiDung");
            }

            daTraLoi = listSearchParams.get("daTraLoi");
            if (daTraLoi != null && daTraLoi != "") {
                sql.append(" AND LOWER(dgyk.daTraLoi) LIKE :daTraLoi");
            }
        }


        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);
        if (ten != null && ten != "") {
            query.setParameter("ten", "%" + ten.toString().toLowerCase() + "%");
        }

        if (email != null && email != "") {
            query.setParameter("email", "%" + email.toString().toLowerCase() + "%");
        }


        if (sdt != null && sdt != "") {
            query.setParameter("sdt", "%" + sdt.toString().toLowerCase() + "%");
        }

        if (diaChi != null && diaChi != "") {
            query.setParameter("diaChi", "%" + diaChi.toString().toLowerCase() + "%");
        }

        if (tieuDe != null && tieuDe != "") {
            query.setParameter("tieuDe", "%" + tieuDe.toString().toLowerCase() + "%");
        }

        if (noiDung != null && noiDung != "") {
            query.setParameter("noiDung", "%" + noiDung.toString().toLowerCase() + "%");
        }

        if (daTraLoi != null && daTraLoi != "") {
            query.setParameter("daTraLoi", "%" + daTraLoi.toString().toLowerCase() + "%");
        }

        return ((Number) query.getSingleResult()).intValue();
    }
}
