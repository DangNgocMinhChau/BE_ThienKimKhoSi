package com.example.webbao.services.danhmuc.thanhMenu;

import com.example.webbao.common.PaginationDto;
import com.example.webbao.models.danhmuc.quyen.QuyenDto;
import com.example.webbao.models.danhmuc.tag.Tag;
import com.example.webbao.models.danhmuc.tag.TagDto;
import com.example.webbao.models.danhmuc.tag.TagSelect;
import com.example.webbao.models.danhmuc.thanhmenu.ThanhMenu;
import com.example.webbao.models.danhmuc.thanhmenu.ThanhMenuDto;
import com.example.webbao.models.danhmuc.thanhmenu.ThanhMenuSelect;
import com.example.webbao.repositorys.danhmuc.tag.TagRepository;
import com.example.webbao.repositorys.danhmuc.thanhmenu.ThanhMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ThanhMenuServiceImpl implements ThanhMenuService {

    @Autowired
    ThanhMenuRepository thanhMenuRepository;

    @Autowired
    ThanhMenuDao thanhMenuDao;

    @Override
    public ThanhMenu findById(Long thanhmenuId) {
        return thanhMenuRepository.findById(thanhmenuId).orElse(null);
    }

    @Override
    public Map<String, Object> create(ThanhMenuDto thanhMenuDto) {
        Map<String, Object> result = new HashMap<>();
        ThanhMenuDto resultCreate = new ThanhMenuDto();
        try {
            ThanhMenu thanhMenu = new ThanhMenu();
            thanhMenu.setMa(thanhMenuDto.getMa());
            thanhMenu.setTen(thanhMenuDto.getTen());
            thanhMenu.setStt(thanhMenuDto.getStt());
            thanhMenu.setPhanLoai(thanhMenuDto.getPhanLoai());
            thanhMenu.setNgayTaoBanGhi(thanhMenuDto.getNgayTaoBanGhi());
            thanhMenu.setFlag(true);
            thanhMenuRepository.save(thanhMenu);

            resultCreate.setId(thanhMenu.getId());
            resultCreate.setMa(thanhMenuDto.getMa());
            resultCreate.setTen(thanhMenuDto.getTen());
            resultCreate.setPhanLoai(thanhMenuDto.getPhanLoai());
            resultCreate.setStt(thanhMenuDto.getStt());
            result.put("result", resultCreate);
            result.put("msg", "Thêm mới " + thanhMenuDto.getTen() + " thành công");
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Thêm mới thất bại");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, ThanhMenuDto thanhMenuDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            ThanhMenu object = thanhMenuRepository.findById(id).get();
            object.setId(thanhMenuDto.getId() != null ? thanhMenuDto.getId() : object.getId());
            object.setMa(thanhMenuDto.getMa() != null ? thanhMenuDto.getMa() : object.getMa());
            object.setStt(thanhMenuDto.getStt() != null ? thanhMenuDto.getStt() : object.getStt());
            object.setPhanLoai(thanhMenuDto.getPhanLoai() != null ? thanhMenuDto.getPhanLoai() : object.getPhanLoai());
            object.setTen(thanhMenuDto.getTen() != null ? thanhMenuDto.getTen() : object.getTen());
            object.setNgayChinhSua(thanhMenuDto.getNgayChinhSua());

            thanhMenuRepository.save(object);
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
        ThanhMenu thanhMenu = thanhMenuRepository.findById(id).orElse(null);
        ThanhMenuDto thanhMenuDto = new ThanhMenuDto();
        try {
            if (thanhMenu != null) {
                thanhMenuDto.setId(thanhMenu.getId());
                thanhMenuDto.setMa(thanhMenu.getMa());
                thanhMenuDto.setStt(thanhMenu.getStt());
                thanhMenuDto.setPhanLoai(thanhMenu.getPhanLoai());
                thanhMenuDto.setTen(thanhMenu.getTen());
                result.put("result", thanhMenuDto);
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
            List<ThanhMenu> thanhMenuList = thanhMenuRepository.findAll();
            List<ThanhMenuDto> thanhMenuDtoList = new ArrayList<>();
            for (ThanhMenu thanhMenu : thanhMenuList) {
                ThanhMenuDto thanhMenuDto = new ThanhMenuDto();
                thanhMenuDto.setId(thanhMenu.getId());
                thanhMenuDto.setMa(thanhMenu.getMa());
                thanhMenuDto.setStt(thanhMenu.getStt());
                thanhMenuDto.setPhanLoai(thanhMenu.getPhanLoai());
                thanhMenuDto.setTen(thanhMenu.getTen());
                if (thanhMenu.getFlag()) {
                    thanhMenuDtoList.add(thanhMenuDto);
                }
            }
            result.put("result", thanhMenuDtoList);
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", "Lấy danh sách thất bại !");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAllSelect() {
        Map<String, Object> result = new HashMap<>();

        try {
            List<ThanhMenu> thanhMenuList = thanhMenuRepository.findAll();
            List<ThanhMenuSelect> thanhMenuSelects = new ArrayList<>();
            for (ThanhMenu thanhMenu : thanhMenuList) {
                ThanhMenuSelect thanhMenuSelect = new ThanhMenuSelect();
                thanhMenuSelect.setId(thanhMenu.getId());
                thanhMenuSelect.setValue(thanhMenu.getMa());
                thanhMenuSelect.setTen(thanhMenu.getTen());
                if (thanhMenu.getFlag()) {
                    thanhMenuSelects.add(thanhMenuSelect);
                }
            }
            result.put("result", thanhMenuSelects);
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
            ThanhMenu thanhMenu = thanhMenuRepository.findById(listIds[i]).orElse(null);
            thanhMenu.setFlag(false);

            thanhMenuRepository.save(thanhMenu);
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
            List<ThanhMenu> listIdThanhMenu = new ArrayList<>();
            for (Long id : listIds) {
                Optional<ThanhMenu> thanhMenuOptional = thanhMenuRepository.findById(id);
                if (thanhMenuOptional.isPresent()) {
                    listIdThanhMenu.add(thanhMenuOptional.get());
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
        Map<String,Object> mapResult = new HashMap<>();
        try{
            if(sortData == null){
                sortData ="id DESC";
            }
            Pageable pageable = null;

            if (pageSize != null && page != null){
                pageable = PageRequest.of(page - 1, pageSize);
                mapResult.put("pagination", new PaginationDto(page,pageSize,thanhMenuDao.countThanhMenu(searchString)));
            }

            List<ThanhMenu> thanhMenuList = thanhMenuDao.getListThanhMenu(searchString,pageable,sortData);
            List<ThanhMenuDto> thanhMenuDtos = new ArrayList<ThanhMenuDto>();
            for(ThanhMenu thanhMenu : thanhMenuList){
                ThanhMenuDto thanhMenuDto = new ThanhMenuDto();
                thanhMenuDto.setId(thanhMenu.getId());
                thanhMenuDto.setMa(thanhMenu.getMa());
                thanhMenuDto.setStt(thanhMenu.getStt());
                thanhMenuDto.setPhanLoai(thanhMenu.getPhanLoai());
                thanhMenuDto.setTen(thanhMenu.getTen());
                thanhMenuDtos.add(thanhMenuDto);
            }
            mapResult.put("result",thanhMenuDtos);
            mapResult.put("status",true);
        }catch (Exception e){
            e.printStackTrace();
            mapResult.put("result",null);
            mapResult.put("status",false);
            mapResult.put("msg","Lấy danh sách thất bại");
        }
        return mapResult;
    }
}
