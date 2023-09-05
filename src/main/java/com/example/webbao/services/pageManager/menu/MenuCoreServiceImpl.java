package com.example.webbao.services.pageManager.menu;

import com.example.webbao.common.PaginationDto;
import com.example.webbao.models.pageManager.menu.MenuCore;
import com.example.webbao.models.pageManager.menu.MenuCoreDto;
import com.example.webbao.models.pageManager.menu.MenuCoreSelectDto;
import com.example.webbao.repositorys.pageManager.menu.MenuCoreRepository;
import com.example.webbao.utils.mail.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MenuCoreServiceImpl implements MenuCoreService {

    @Autowired
    MenuCoreRepository menuCoreRepository;

    @Autowired
    MenuCoreDao menuCoreDao;

    @Override
    public Map<String, Object> create(MenuCoreDto menuCoreDto) {
        Map<String, Object> result = new HashMap<>();
        MenuCoreDto resultCreate = new MenuCoreDto();
        try {
            MenuCore menuCore = new MenuCore();
            menuCore.setNameMenu(menuCoreDto.getNameMenu());
            menuCore.setUrlMapping(menuCoreDto.getUrlMapping());
            menuCore.setTypeMenu(menuCoreDto.getTypeMenu());
            menuCore.setIconMenu(menuCoreDto.getIconMenu());
            menuCore.setPid(menuCoreDto.getPid());
            menuCore.setCheckUrlId(menuCoreDto.getCheckUrlId());
            menuCore.setNgayTaoBanGhi(menuCoreDto.getNgayTaoBanGhi());
            menuCore.setFlag(true);

            menuCoreRepository.save(menuCore);
            result.put("result", menuCore);
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
    public Map<String, Object> update(Long id, MenuCoreDto menuCoreDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            MenuCore object = menuCoreRepository.findById(id).get();
            object.setId(menuCoreDto.getId() != null ? menuCoreDto.getId() : object.getId());
            object.setNameMenu(menuCoreDto.getNameMenu() != null ? menuCoreDto.getNameMenu() : object.getNameMenu());
            object.setIconMenu(menuCoreDto.getIconMenu() != null ? menuCoreDto.getIconMenu() : object.getIconMenu());
            object.setTypeMenu(menuCoreDto.getTypeMenu() != null ? menuCoreDto.getTypeMenu() : object.getTypeMenu());
            object.setUrlMapping(menuCoreDto.getUrlMapping() != null ? menuCoreDto.getUrlMapping() : object.getUrlMapping());
            object.setPid(menuCoreDto.getPid() != null ? menuCoreDto.getPid() : object.getPid());
            object.setCheckUrlId(menuCoreDto.getCheckUrlId() != null ? menuCoreDto.getCheckUrlId() : object.getCheckUrlId());
            object.setNgayChinhSua(menuCoreDto.getNgayChinhSua());
            menuCoreRepository.save(object);

            result.put("result", object);
            result.put("msg", Const.SUA_THANH_CONG);
            result.put("status", true);
        } catch (Exception e) {
            result.put("result", null);
            result.put("msg", Const.SUA_THAT_BAI);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> fetchById(Long id) {
        Map<String, Object> result = new HashMap<>();
        MenuCore menuCore = menuCoreRepository.findById(id).orElse(null);
        MenuCoreDto menuCoreDto = new MenuCoreDto();
        try {
            if (menuCore != null) {
                menuCoreDto.setNameMenu(menuCore.getNameMenu());
                menuCoreDto.setUrlMapping(menuCore.getUrlMapping());
                menuCoreDto.setTypeMenu(menuCore.getTypeMenu());
                menuCoreDto.setIconMenu(menuCore.getIconMenu());
                menuCoreDto.setPid(menuCore.getPid());
                menuCoreDto.setCheckUrlId(menuCore.getCheckUrlId());
                menuCoreDto.setNgayTaoBanGhi(menuCore.getNgayTaoBanGhi());
                menuCoreDto.setId(menuCore.getId());

                result.put("result", menuCoreDto);
                result.put("msg", Const.LAY_ITEM_THANH_CONG);
                result.put("status", true);
            }
        } catch (Exception e) {
            result.put("result", null);
            result.put("msg", Const.LAY_ITEM_THAT_BAI);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAll() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<MenuCore> list = menuCoreRepository.findAll();
            List<MenuCoreDto> listDto = new ArrayList<>();
            for (MenuCore menuCore : list){
                MenuCoreDto menuCoreDto = new MenuCoreDto();
                menuCoreDto.setId(menuCore.getId());
                menuCoreDto.setNameMenu(menuCore.getNameMenu());
                menuCoreDto.setUrlMapping(menuCore.getUrlMapping());
                menuCoreDto.setTypeMenu(menuCore.getTypeMenu());
                menuCoreDto.setIconMenu(menuCore.getIconMenu());
                menuCoreDto.setPid(menuCore.getPid());
                menuCoreDto.setCheckUrlId(menuCore.getCheckUrlId());
                menuCoreDto.setNgayTaoBanGhi(menuCore.getNgayTaoBanGhi());
                if (menuCore.getFlag()) {
                    listDto.add(menuCoreDto);
                }
            }
            result.put("result", listDto);
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
    public Map<String, Object> getSelectById() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<MenuCore> list = menuCoreRepository.findAll();
            List<MenuCoreDto> listDto = new ArrayList<>();
            for (MenuCore menuCore : list){
                MenuCoreDto menuCoreDto = new MenuCoreDto();
                menuCoreDto.setId(menuCore.getId());
                menuCoreDto.setNameMenu(menuCore.getNameMenu());
                menuCoreDto.setUrlMapping(menuCore.getUrlMapping().replace(":id",menuCore.getId().toString()));
                menuCoreDto.setTypeMenu(menuCore.getTypeMenu());
                menuCoreDto.setIconMenu(menuCore.getIconMenu());
                menuCoreDto.setPid(menuCore.getPid());
                if (menuCore.getFlag()) {
                    listDto.add(menuCoreDto);
                }
            }
            result.put("result", listDto);
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
    public Map<String, Object> getSelect() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<MenuCore> list = menuCoreRepository.findAll();
            List<MenuCoreSelectDto> listDto = new ArrayList<>();
            for (MenuCore menuCore : list){
                MenuCoreSelectDto item = new MenuCoreSelectDto();
                item.setId(menuCore.getId());
                item.setTitle(menuCore.getNameMenu());
                item.setValue(menuCore.getId().toString());
                item.setPid(menuCore.getPid());
                if (menuCore.getFlag()) {
                    listDto.add(item);
                }
            }
            result.put("result", listDto);
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
            MenuCore menuCore = menuCoreRepository.findById(listIds[i]).orElse(null);
            menuCore.setFlag(false);
            menuCoreRepository.save(menuCore);
            result.put("listId", listIds);
            result.put("msg", Const.XOA_THANH_CONG);
            result.put("status", true);
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
                mapResult.put("pagination", new PaginationDto(page, pageSize, menuCoreDao.count(searchString)));
            }

            List<MenuCore> list = menuCoreDao.getList(searchString, pageable, sortData);
            List<MenuCoreDto> listDtos = new ArrayList<MenuCoreDto>();
            for (MenuCore menuCore : list) {
                MenuCoreDto menuCoreDto = new MenuCoreDto();
                menuCoreDto.setId(menuCore.getId());
                menuCoreDto.setNameMenu(menuCore.getNameMenu());
                menuCoreDto.setUrlMapping(menuCore.getUrlMapping());
                menuCoreDto.setTypeMenu(menuCore.getTypeMenu());
                menuCoreDto.setIconMenu(menuCore.getIconMenu());
                menuCoreDto.setPid(menuCore.getPid());
                menuCoreDto.setCheckUrlId(menuCore.getCheckUrlId());
                listDtos.add(menuCoreDto);
            }
            mapResult.put("result", listDtos);
            mapResult.put("status", true);
            mapResult.put("msg", Const.LAY_DANH_SACH_THANH_CONG);

        } catch (Exception e) {
            e.printStackTrace();
            mapResult.put("result", null);
            mapResult.put("status", false);
            mapResult.put("msg", Const.LAY_DANH_SACH_THAT_BAI);
        }
        return mapResult;
    }

    @Override
    public Map<String, Object> deletePermanently(Long[] listIds) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<MenuCore> listId = new ArrayList<>();
            for (Long id : listIds) {
                Optional<MenuCore> menuCoreOptional = menuCoreRepository.findById(id);
                if (menuCoreOptional.isPresent()) {
                    listId.add(menuCoreOptional.get());
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
}
