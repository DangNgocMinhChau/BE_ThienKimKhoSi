package com.example.webbao.services.quanlytruycap;

import com.example.webbao.models.quanlytruycap.TruyCap;
import com.example.webbao.models.quanlytruycap.TruyCapDto;
import com.example.webbao.repositorys.quanlytruycap.TruyCapRepository;
import com.example.webbao.utils.mail.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TruyCapServiceImpl implements TruyCapService {

    @Autowired
    TruyCapRepository truyCapRepository;

    @Override
    public Map<String, Object> create(TruyCapDto truyCapDto) {
        Map<String, Object> result = new HashMap<>();
        TruyCapDto resultCreate = new TruyCapDto();
        try {
            TruyCap truyCap = new TruyCap();
            truyCap.setNgayTruyCap(truyCapDto.getNgayTruyCap());
            truyCapRepository.save(truyCap);

            resultCreate.setId(truyCap.getId());
            resultCreate.setNgayTruyCap(truyCap.getNgayTruyCap());

            result.put("result", resultCreate);
            result.put("msg", Const.THEM_MOI_THANH_CONG);
            result.put("status", true);

        } catch (Exception e) {
            result.put("result", null);
            result.put("msg", Const.THEM_MOI_THAT_BAI);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAll() {
        Map<String, Object> result = new HashMap<>();

        try {
            List<TruyCap> truyCapList = truyCapRepository.findAll();
            List<TruyCapDto> truyCapDtoArrayList = new ArrayList<>();
            for (TruyCap truyCap : truyCapList) {
                TruyCapDto truyCapDto = new TruyCapDto();
                truyCapDto.setId(truyCap.getId());
                truyCapDto.setNgayTruyCap(truyCap.getNgayTruyCap());
                truyCapDtoArrayList.add(truyCapDto);
            }
            result.put("result", truyCapDtoArrayList);
            result.put("msg", Const.LAY_DANH_SACH_THANH_CONG);
            result.put("status", true);
        } catch (Exception e) {
            result.put("result", null);
            result.put("msg", Const.LAY_DANH_SACH_THAT_BAI);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> tongView() {
        Map<String, Object> result = new HashMap<>();
        List<TruyCap> truyCapList = truyCapRepository.findAll();
        result.put("tongLuotTruyCap",truyCapList.size());
        return result;
    }

    @Override
    public Map<String, Object> allViewTrongNgay(String ngayTruyCap) {
        Map<String, Object> result = new HashMap<>();
        Long view = truyCapRepository.view(ngayTruyCap);
        result.put("tongLuotTruyCap",view);
        return result;
    }


}
