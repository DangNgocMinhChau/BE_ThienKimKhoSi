package com.example.webbao.services.danhmuc.url;


import com.example.webbao.common.PaginationDto;
import com.example.webbao.models.danhmuc.url.Url;
import com.example.webbao.models.danhmuc.url.UrlDto;
import com.example.webbao.models.danhmuc.url.UrlSelect;
import com.example.webbao.repositorys.danhmuc.url.UrlRepository;
import com.example.webbao.utils.mail.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    UrlRepository urlRepository;

    @Autowired
    UrlDao urlDao;

    @Override
    public Url findById(Long id) {
        return urlRepository.findById(id).orElse(null);
    }

    @Override
    public Map<String, Object> create(UrlDto urlDto) {
        Map<String, Object> result = new HashMap<>();
        UrlDto resultCreate = new UrlDto();
        try {
            Url url = new Url();
            url.setMa(urlDto.getMa());
            url.setTen(urlDto.getTen());
            url.setStt(urlDto.getStt());
            url.setpId(urlDto.getpId());
            url.setLevel(urlDto.getLevel());
            url.setNgayTaoBanGhi(urlDto.getNgayTaoBanGhi());
            url.setFlag(true);
            urlRepository.save(url);

            resultCreate.setId(url.getId());
            resultCreate.setMa(url.getMa());
            resultCreate.setTen(urlDto.getTen());
            resultCreate.setpId(urlDto.getpId());
            resultCreate.setLevel(urlDto.getLevel());
            resultCreate.setStt(urlDto.getStt());
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
    public Map<String, Object> update(Long id, UrlDto urlDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            Url object = urlRepository.findById(id).get();
            object.setId(urlDto.getId() != null ? urlDto.getId() : object.getId());
            object.setMa(urlDto.getMa() != null ? urlDto.getMa() : object.getMa());
            object.setStt(urlDto.getStt() != null ? urlDto.getStt() : object.getStt());
            object.setpId(urlDto.getpId() != null ? urlDto.getpId() : object.getpId());
            object.setLevel(urlDto.getLevel() != null ? urlDto.getLevel() : object.getLevel());
            object.setTen(urlDto.getTen() != null ? urlDto.getTen() : object.getTen());
            object.setNgayChinhSua(urlDto.getNgayChinhSua());

            urlRepository.save(object);
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
        Url url = urlRepository.findById(id).orElse(null);
        UrlDto urlDto = new UrlDto();
        try {
            if (url != null) {
                urlDto.setId(url.getId());
                urlDto.setMa(url.getMa());
                urlDto.setStt(url.getStt());
                urlDto.setLevel(url.getLevel());
                urlDto.setpId(url.getpId());
                urlDto.setTen(url.getTen());
                result.put("result", urlDto);
                result.put("status", true);
            }
        } catch (Exception e) {
            result.put("result", null);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAll() {
        Map<String, Object> result = new HashMap<>();

        try {
            List<Url> urlList = urlRepository.findAll();
            List<UrlDto> urlDtoList = new ArrayList<>();
            for (Url url : urlList) {
                UrlDto urlDto = new UrlDto();
                urlDto.setId(url.getId());
                urlDto.setMa(url.getMa());
                urlDto.setStt(url.getStt());
                urlDto.setpId(url.getpId());
                urlDto.setLevel(url.getLevel());
                urlDto.setTen(url.getTen());
                if (url.getFlag()) {
                    urlDtoList.add(urlDto);
                }
            }
            result.put("result", urlDtoList);
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
    public Map<String, Object> getAllSelect() {
        Map<String, Object> result = new HashMap<>();

        try {
            List<Url> urlList = urlRepository.findAll();
            List<UrlSelect> urlSelects = new ArrayList<>();
            for (Url url : urlList) {
                UrlSelect urlSelect = new UrlSelect();
                urlSelect.setId(url.getId());
                urlSelect.setValue(url.getMa());
                urlSelect.setTen(url.getTen());
                if (url.getFlag()) {
                    urlSelects.add(urlSelect);
                }
            }
            result.put("result", urlSelects);
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
    public Map<String, Object> delete(Long[] listIds) {
        Map<String, Object> result = new HashMap<>();

        for (int i = 0; i < listIds.length; i++) {
            Url url = urlRepository.findById(listIds[i]).orElse(null);
            url.setFlag(false);

            urlRepository.save(url);
            result.put("listId", listIds);
            result.put("msg", Const.XOA_THANH_CONG);
            result.put("status", true);
        }
        return result;
    }


    @Override
    public Map<String, Object> deleteVinhVien(Long[] listIds) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Url> listIdUrl = new ArrayList<>();
            for (Long id : listIds) {
                Optional<Url> urlOptional = urlRepository.findById(id);
                if (urlOptional.isPresent()) {
                    listIdUrl.add(urlOptional.get());
                }
            }
            result.put("msg", Const.XOA_THANH_CONG);
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", Const.XOA_THAT_BAI);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData) {
        Map<String,Object> mapResult = new HashMap<>();
        try{
            if(sortData == null){
                sortData ="id DESC";
            }
            Pageable pageable = null;

            if (pageSize != null && page != null){
                pageable = PageRequest.of(page - 1, pageSize);
                mapResult.put("pagination", new PaginationDto(page,pageSize,urlDao.countUrl(searchString)));
            }

            List<Url> urlList = urlDao.getListUrl(searchString,pageable,sortData);
            List<UrlDto> urlDtos = new ArrayList<UrlDto>();
            for(Url url : urlList){
                UrlDto urlDto = new UrlDto();
                urlDto.setId(url.getId());
                urlDto.setMa(url.getMa());
                urlDto.setStt(url.getStt());
                urlDto.setTen(url.getTen());
                urlDto.setLevel(url.getLevel());
                urlDto.setpId(url.getpId());
                urlDtos.add(urlDto);
            }
            mapResult.put("result",urlDtos);
            mapResult.put("status",true);
            mapResult.put("msg",Const.LAY_DANH_SACH_THANH_CONG);

        }catch (Exception e){
            e.printStackTrace();
            mapResult.put("result",null);
            mapResult.put("status",false);
            mapResult.put("msg",Const.LAY_DANH_SACH_THAT_BAI);
        }
        return mapResult;
    }
}
