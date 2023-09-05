package com.example.webbao.services.tuongtac.thichbaiviet;

import com.example.webbao.models.tuongtac.thichbaiviet.ThichBaiViet;
import com.example.webbao.models.tuongtac.thichbaiviet.ThichBaiVietDto;
import com.example.webbao.repositorys.tuongtac.thichbaiviet.ThichBaiVietRepository;
import com.example.webbao.utils.mail.Const;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ThichBaiVietServiceImpl implements ThichBaiVietService {

    @Autowired
    ThichBaiVietRepository thichBaiVietRepository;

    @Override
    public ThichBaiViet findById(Long id) {
        return thichBaiVietRepository.findById(id).orElse(null);
    }

    @Override
    public Map<String, Object> create(ThichBaiVietDto thichBaiVietDto) {
        Map<String, Object> result = new HashMap<>();
        ThichBaiVietDto resultCreate = new ThichBaiVietDto();
        try {
            ThichBaiViet thichBaiViet = new ThichBaiViet();
            thichBaiViet.setIdBaiViet(thichBaiVietDto.getIdBaiViet());
            thichBaiViet.setIdUser(thichBaiVietDto.getIdUser());
            thichBaiViet.setDaLike(thichBaiVietDto.getDaLike());
            thichBaiViet.setNgayTaoBanGhi(thichBaiVietDto.getNgayTaoBanGhi());
            thichBaiViet.setFlag(true);
            thichBaiVietRepository.save(thichBaiViet);

            resultCreate.setId(thichBaiViet.getId());
            resultCreate.setIdBaiViet(thichBaiViet.getIdBaiViet());
            resultCreate.setIdUser(thichBaiViet.getIdUser());
            resultCreate.setDaLike(thichBaiViet.getDaLike());
            result.put("result", resultCreate);
            result.put("msg", Const.THEM_MOI_THANH_CONG);
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", Const.THEM_MOI_THAT_BAI);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, ThichBaiVietDto thichBaiVietDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            ThichBaiViet object = thichBaiVietRepository.findById(id).get();
            object.setId(thichBaiVietDto.getId() != null ? thichBaiVietDto.getId() : object.getId());
            object.setIdBaiViet(thichBaiVietDto.getIdBaiViet() != null ? thichBaiVietDto.getIdBaiViet() : object.getIdBaiViet());
            object.setIdUser(thichBaiVietDto.getIdUser() != null ? thichBaiVietDto.getIdUser() : object.getIdUser());
            object.setDaLike(thichBaiVietDto.getDaLike() != null ? thichBaiVietDto.getDaLike() : object.getNgayChinhSua());
            object.setNgayChinhSua(thichBaiVietDto.getNgayChinhSua());

            thichBaiVietRepository.save(object);
            result.put("result", object);
            result.put("msg", Const.SUA_THANH_CONG);
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", Const.SUA_THAT_BAI);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> fetchById(Long id) {
        Map<String, Object> result = new HashMap<>();
        ThichBaiViet thichBaiViet = thichBaiVietRepository.findById(id).orElse(null);
        ThichBaiVietDto thichBaiVietDto = new ThichBaiVietDto();
        try {
            if (thichBaiViet != null) {
                thichBaiVietDto.setId(thichBaiViet.getId());
                thichBaiVietDto.setIdUser(thichBaiViet.getIdUser());
                thichBaiVietDto.setIdBaiViet(thichBaiViet.getIdBaiViet());
                thichBaiVietDto.setDaLike(thichBaiViet.getDaLike());
                thichBaiVietDto.setId(thichBaiViet.getId());
                result.put("result", thichBaiVietDto);
                result.put("status", true);
            }
        } catch (Exception e) {
            result.put("result", null);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> countBaiViet(Long id) {
        Map<String, Object> result = new HashMap<>();
        System.out.println(id);
        Long a = thichBaiVietRepository.countBaiViet(id);
        result.put("soLuotThich", a);
        return result;
    }
}
