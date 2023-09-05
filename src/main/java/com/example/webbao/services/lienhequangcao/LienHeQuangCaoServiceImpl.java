package com.example.webbao.services.lienhequangcao;

import com.example.webbao.common.PaginationDto;
import com.example.webbao.models.danhmuc.tag.Tag;
import com.example.webbao.models.danhmuc.tag.TagDto;
import com.example.webbao.models.danhmuc.tag.TagSelect;
import com.example.webbao.models.lienhequangcao.LienHeQuangCao;
import com.example.webbao.models.lienhequangcao.LienHeQuangCaoDto;
import com.example.webbao.repositorys.danhmuc.tag.TagRepository;
import com.example.webbao.repositorys.lienhequangcao.LienHeQuangCaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LienHeQuangCaoServiceImpl implements LienHeQuangCaoService {

    @Autowired
    LienHeQuangCaoRepository lienHeQuangCaoRepository;

    @Autowired
    LienHeQuangCaoDao lienHeQuangCaoDao;

    @Override
    public LienHeQuangCao findById(Long lhqcId) {
        return lienHeQuangCaoRepository.findById(lhqcId).orElse(null);
    }

    @Override
    public Map<String, Object> create(LienHeQuangCaoDto lienHeQuangCaoDto) {
        Map<String, Object> result = new HashMap<>();
        LienHeQuangCaoDto resultCreate = new LienHeQuangCaoDto();
        try {
            LienHeQuangCao lienHeQuangCao = new LienHeQuangCao();
            lienHeQuangCao.setEmail(lienHeQuangCaoDto.getEmail());
            lienHeQuangCao.setSdt(lienHeQuangCaoDto.getSdt());
            lienHeQuangCao.setTen(lienHeQuangCaoDto.getTen());

            lienHeQuangCao.setNgayTaoBanGhi(lienHeQuangCaoDto.getNgayTaoBanGhi());
            lienHeQuangCao.setFlag(true);
            lienHeQuangCaoRepository.save(lienHeQuangCao);


            resultCreate.setEmail(lienHeQuangCaoDto.getEmail());
            resultCreate.setId(lienHeQuangCao.getId());
            resultCreate.setSdt(lienHeQuangCaoDto.getSdt());
            resultCreate.setTen(lienHeQuangCaoDto.getTen());

            result.put("result", resultCreate);
            result.put("msg", "Đã gửi thông tin thành công");
            result.put("status", true);

        } catch (Exception e) {
            result.put("msg", "Thêm mới thất bại !");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, LienHeQuangCaoDto lienHeQuangCaoDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            LienHeQuangCao object = lienHeQuangCaoRepository.findById(id).get();
            object.setId(lienHeQuangCaoDto.getId() != null ? lienHeQuangCaoDto.getId() : object.getId());
            object.setTen(lienHeQuangCaoDto.getTen() != null ? lienHeQuangCaoDto.getTen() : object.getTen());
            object.setSdt(lienHeQuangCaoDto.getSdt() != null ? lienHeQuangCaoDto.getSdt() : object.getSdt());
            object.setEmail(lienHeQuangCaoDto.getEmail() != null ? lienHeQuangCaoDto.getEmail() : object.getEmail());
            object.setNgayChinhSua(lienHeQuangCaoDto.getNgayChinhSua());
            lienHeQuangCaoRepository.save(object);
            result.put("result", object);
            result.put("msg", "Sửa thành công !");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Sửa thất bại !");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> fetchById(Long id) {
        Map<String, Object> result = new HashMap<>();
        LienHeQuangCao lienHeQuangCao = lienHeQuangCaoRepository.findById(id).orElse(null);
        LienHeQuangCaoDto lienHeQuangCaoDto = new LienHeQuangCaoDto();
        try {
            if (lienHeQuangCao != null) {
                lienHeQuangCaoDto.setId(lienHeQuangCao.getId());
                lienHeQuangCaoDto.setEmail(lienHeQuangCao.getEmail());
                lienHeQuangCaoDto.setTen(lienHeQuangCao.getTen());
                lienHeQuangCaoDto.setSdt(lienHeQuangCao.getSdt());
                result.put("result", lienHeQuangCaoDto);
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
            List<LienHeQuangCao> lienHeQuangCaoList = lienHeQuangCaoRepository.findAll();
            List<LienHeQuangCaoDto> lienHeQuangCaoDtoList = new ArrayList<>();
            for (LienHeQuangCao lienHeQuangCao : lienHeQuangCaoList) {
                LienHeQuangCaoDto lienHeQuangCaoDto = new LienHeQuangCaoDto();
                lienHeQuangCaoDto.setId(lienHeQuangCao.getId());
                lienHeQuangCaoDto.setTen(lienHeQuangCao.getTen());
                lienHeQuangCaoDto.setSdt(lienHeQuangCao.getSdt());
                lienHeQuangCaoDto.setEmail(lienHeQuangCao.getEmail());

                if (lienHeQuangCao.getFlag()) {
                    lienHeQuangCaoDtoList.add(lienHeQuangCaoDto);
                }
            }
            result.put("result", lienHeQuangCaoDtoList);
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Lấy danh sách thất bại !");
            result.put("status", false);
        }
        return result;
    }


    @Override
    public Map<String, Object> delete(Long[] listIds) {
        Map<String, Object> result = new HashMap<>();

        for (int i = 0; i < listIds.length; i++) {
            LienHeQuangCao lienHeQuangCao = lienHeQuangCaoRepository.findById(listIds[i]).orElse(null);
            lienHeQuangCao.setFlag(false);
            lienHeQuangCaoRepository.save(lienHeQuangCao);
            result.put("listId", listIds);
            result.put("msg", "Xoá thành công !");
            result.put("status", true);
        }
        return result;
    }


    @Override
    public Map<String, Object> deleteVinhVien(Long[] listIds) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<LienHeQuangCao> listIdLienHeQuangCao = new ArrayList<>();
            for (Long id : listIds) {
                Optional<LienHeQuangCao> lhqcOptional = lienHeQuangCaoRepository.findById(id);
                if (lhqcOptional.isPresent()) {
                    listIdLienHeQuangCao.add(lhqcOptional.get());
                }
            }
            result.put("msg", "Xóa thành công !");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Xóa thất bại !");
            result.put("status", false);
        }
        return result;
    }
    @Override
    public Map<String, Object> findAll(String searchString, Integer pageSize, Integer page, String sortData) {
        Map<String, Object> mapResult = new HashMap<>();
        try {
            if (sortData == null) {
                sortData = "id DESC";
            }
            Pageable pageable = null;

            if (pageSize != null && page != null) {
                pageable = PageRequest.of(page - 1, pageSize);
                mapResult.put("pagination", new PaginationDto(page, pageSize, lienHeQuangCaoDao.countLHQC(searchString)));
            }

            List<LienHeQuangCao> lienHeQuangCaoList = lienHeQuangCaoDao.getListLhqc(searchString, pageable, sortData);
            List<LienHeQuangCaoDto> lienHeQuangCaoDtos = new ArrayList<LienHeQuangCaoDto>();
            for (LienHeQuangCao lienHeQuangCao : lienHeQuangCaoList) {
                LienHeQuangCaoDto lienHeQuangCaoDto = new LienHeQuangCaoDto();
                lienHeQuangCaoDto.setId(lienHeQuangCao.getId());
                lienHeQuangCaoDto.setTen(lienHeQuangCao.getTen());
                lienHeQuangCaoDto.setEmail(lienHeQuangCao.getEmail());
                lienHeQuangCaoDto.setSdt(lienHeQuangCao.getSdt());

                lienHeQuangCaoDtos.add(lienHeQuangCaoDto);
            }
            mapResult.put("result", lienHeQuangCaoDtos);
            mapResult.put("status", true);
            mapResult.put("msg", "Lấy danh sách thành công !");

        } catch (Exception e) {
            e.printStackTrace();
            mapResult.put("result", null);
            mapResult.put("status", false);
            mapResult.put("msg", "Lấy danh sách thất bại");
        }
        return mapResult;
    }
}
