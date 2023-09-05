package com.example.webbao.services.danhmuc.manager_banner;

import com.example.webbao.models.danhmuc.manage_banner.Banner;
import com.example.webbao.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class BannerDao {
    @Autowired
    private EntityManager entityManager;

    public List<Banner> getListBanner(String searchString, Pageable pageable, String sortData) {
        StringBuilder sql = new StringBuilder();
        Object src = null;
        Object height = null;
        Object width = null;
        Object tag = null;
        Object bannerNoiBat = null;
        Object stt = null;
        Object thuocNhom = null;


        sql.append("select");
        sql.append(" bn");
        sql.append(" from Banner bn");
        sql.append(" where");
        sql.append(" bn.id is not null ");
        sql.append(" and");
        sql.append(" bn.flag = true");

        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);

            src = listSearchParams.get("src");
            if(src != null && src != ""){
                sql.append(" AND LOWER(bn.src) LIKE :src");
            }

            height = listSearchParams.get("height");
            if(height != null && height != ""){
                sql.append(" AND LOWER(bn.height) LIKE :height");
            }

            width = listSearchParams.get("width");
            if(width != null && width != ""){
                sql.append(" AND LOWER(bn.width) LIKE :width");
            }

            tag = listSearchParams.get("tag");
            if(tag != null && tag != ""){
                sql.append(" AND LOWER(bn.tag) LIKE :tag");
            }
            bannerNoiBat = listSearchParams.get("bannerNoiBat");
            if(bannerNoiBat != null && bannerNoiBat != ""){
                sql.append(" AND LOWER(bn.bannerNoiBat) LIKE :bannerNoiBat");
            }
            stt = listSearchParams.get("stt");
            if(stt != null && stt != ""){
                sql.append(" AND LOWER(bn.stt) LIKE :stt");
            }

            thuocNhom = listSearchParams.get("thuocNhom");
            if(thuocNhom != null && thuocNhom != ""){
                sql.append(" AND LOWER(bn.thuocNhom) LIKE :thuocNhom");
            }
        }
        if(sortData!=null){
            String sortQuery = Util.convertSortDataWithAlias(sortData,"bn");
            sql.append(" ORDER BY " + sortQuery);
        }


        TypedQuery<Banner> query = entityManager.createQuery(sql.toString(), Banner.class);
        if(src != null && src !=""){
            query.setParameter("src","%" + src.toString().toLowerCase() + "%");
        }

        if(height != null && height !=""){
            query.setParameter("height","%" + height.toString().toLowerCase() + "%");
        }

        if(width != null && width !=""){
            query.setParameter("width","%" + width.toString().toLowerCase() + "%");
        }

        if(tag != null && tag !=""){
            query.setParameter("tag","%" + tag.toString().toLowerCase() + "%");
        }
        if(bannerNoiBat != null && bannerNoiBat !=""){
            query.setParameter("bannerNoiBat",  Boolean.parseBoolean((String) bannerNoiBat));
        }

        if(stt != null && stt !=""){
            query.setParameter("stt",  Long.parseLong((String) stt));
        }

        if(thuocNhom != null && thuocNhom !=""){
            query.setParameter("thuocNhom","%" + thuocNhom.toString().toLowerCase() + "%");
        }

        if(pageable != null){
            return query.setFirstResult((int) pageable.getOffset()).setMaxResults(pageable.getPageSize()).getResultList();
        }
        return query.getResultList();
    }

    public Integer countBaiViet(String searchString) {
        StringBuilder sql = new StringBuilder();
        Object src = null;
        Object height = null;
        Object width = null;
        Object tag = null;
        Object bannerNoiBat = null;
        Object stt = null;
        Object thuocNhom = null;

        sql.append("select");
        sql.append(" count(bn)");
        sql.append(" from Banner bn");
        sql.append(" where");
        sql.append(" bn.id is not null ");
        sql.append(" and");
        sql.append(" bn.flag = true");
        if(searchString != null & searchString != ""){
            Map<String,String> listSearchParams = Util.splitRequestParamsFromURL(searchString);
            src = listSearchParams.get("src");
            if(src != null && src != ""){
                sql.append(" AND LOWER(bn.src) LIKE :src");
            }

            height = listSearchParams.get("height");
            if(height != null && height != ""){
                sql.append(" AND LOWER(bn.height) LIKE :height");
            }

            width = listSearchParams.get("width");
            if(width != null && width != ""){
                sql.append(" AND LOWER(bn.width) LIKE :width");
            }
            tag = listSearchParams.get("tag");
            if(tag != null && tag != ""){
                sql.append(" AND LOWER(bn.tag) LIKE :tag");
            }

            bannerNoiBat = listSearchParams.get("bannerNoiBat");
            if(bannerNoiBat != null && bannerNoiBat != ""){
                sql.append(" AND LOWER(bn.bannerNoiBat) LIKE :bannerNoiBat");
            }

            stt = listSearchParams.get("stt");
            if(stt != null && stt != ""){
                sql.append(" AND LOWER(bn.stt) LIKE :stt");
            }
            thuocNhom = listSearchParams.get("thuocNhom");
            if(thuocNhom != null && thuocNhom != ""){
                sql.append(" AND LOWER(bn.thuocNhom) LIKE :thuocNhom");
            }

        }

        TypedQuery<Long> query = entityManager.createQuery(sql.toString(), Long.class);

        if(src != null && src !=""){
            query.setParameter("src","%" + src.toString().toLowerCase() + "%");
        }

        if(height != null && height !=""){
            query.setParameter("height","%" + height.toString().toLowerCase() + "%");
        }

        if(width != null && width !=""){
            query.setParameter("width","%" + width.toString().toLowerCase() + "%");
        }
        if(tag != null && tag !=""){
            query.setParameter("tag","%" + tag.toString().toLowerCase() + "%");
        }
        if(bannerNoiBat != null && bannerNoiBat !=""){
            query.setParameter("bannerNoiBat",  Boolean.parseBoolean((String) bannerNoiBat));
        }
        if(stt != null && stt !=""){
            query.setParameter("stt",  Long.parseLong((String) stt));
        }
        if(thuocNhom != null && thuocNhom !=""){
            query.setParameter("thuocNhom","%" + thuocNhom.toString().toLowerCase() + "%");
        }

        return ((Number) query.getSingleResult()).intValue();
    }
}
