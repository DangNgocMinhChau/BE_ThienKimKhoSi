package com.example.webbao.services.danhmuc.menu_manager;

import com.example.webbao.common.PaginationDto;
import com.example.webbao.models.danhmuc.menu_manager.MenuManager;
import com.example.webbao.models.danhmuc.menu_manager.MenuManagerDto;
import com.example.webbao.models.danhmuc.menu_manager.MenuManagerSelect;
import com.example.webbao.repositorys.danhmuc.menu_manager.MenuManagerRepository;
import com.example.webbao.utils.mail.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MenuManagerServiceImpl implements MenuManagerService {

    @Autowired
    MenuManagerRepository menuManagerRepository;

    @Autowired
    MenuManagerDao menuManagerDao;

    @Override
    public MenuManager findById(Long menuId) {
        return menuManagerRepository.findById(menuId).orElse(null);
    }

    @Override
    public Map<String, Object> create(MenuManagerDto menuManagerDto) {
        Map<String, Object> result = new HashMap<>();
        MenuManagerDto resultCreate = new MenuManagerDto();
        try {
            MenuManager menuManager = new MenuManager();
            menuManager.setMa(menuManagerDto.getMa());
            menuManager.setTen(menuManagerDto.getTen());
            menuManager.setStt(menuManagerDto.getStt());
            menuManager.setUrl(menuManagerDto.getUrl());
            menuManager.setNhomMenu(menuManagerDto.getNhomMenu());
            menuManager.setNgayTaoBanGhi(menuManagerDto.getNgayTaoBanGhi());
            menuManager.setFlag(true);
            menuManagerRepository.save(menuManager);

            resultCreate.setId(menuManager.getId());
            resultCreate.setMa(menuManagerDto.getMa());
            resultCreate.setTen(menuManagerDto.getTen());
            resultCreate.setStt(menuManagerDto.getStt());
            resultCreate.setUrl(menuManagerDto.getUrl());

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
    public Map<String, Object> update(Long id, MenuManagerDto menuManagerDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            MenuManager object = menuManagerRepository.findById(id).get();
            object.setId(menuManagerDto.getId() != null ? menuManagerDto.getId() : object.getId());
            object.setMa(menuManagerDto.getMa() != null ? menuManagerDto.getMa() : object.getMa());
            object.setStt(menuManagerDto.getStt() != null ? menuManagerDto.getStt() : object.getStt());
            object.setUrl(menuManagerDto.getUrl() != null ? menuManagerDto.getUrl() : object.getUrl());
            object.setNhomMenu(menuManagerDto.getNhomMenu() != null ? menuManagerDto.getNhomMenu() : object.getNhomMenu());
            object.setTen(menuManagerDto.getTen() != null ? menuManagerDto.getTen() : object.getTen());
            object.setNgayChinhSua(menuManagerDto.getNgayChinhSua());

            menuManagerRepository.save(object);

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
        MenuManager menuManager = menuManagerRepository.findById(id).orElse(null);
        MenuManagerDto menuManagerDto = new MenuManagerDto();
        try {
            if (menuManager != null) {
                menuManagerDto.setId(menuManager.getId());
                menuManagerDto.setMa(menuManager.getMa());
                menuManagerDto.setStt(menuManager.getStt());
                menuManagerDto.setUrl(menuManager.getUrl());
                menuManagerDto.setNhomMenu(menuManager.getNhomMenu());
                menuManagerDto.setTen(menuManager.getTen());

                result.put("result", menuManagerDto);
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
            List<MenuManager> menuManagerList = menuManagerRepository.findAll();
            List<MenuManagerDto> menuManagerDtoList = new ArrayList<>();
            for (MenuManager menuManager : menuManagerList) {
                MenuManagerDto menuManagerDto = new MenuManagerDto();
                menuManagerDto.setId(menuManager.getId());
                menuManagerDto.setMa(menuManager.getMa());
                menuManagerDto.setStt(menuManager.getStt());
                menuManagerDto.setUrl(menuManager.getUrl());
                menuManagerDto.setNhomMenu(menuManager.getNhomMenu());
                menuManagerDto.setTen(menuManager.getTen());
                if (menuManager.getFlag()) {
                    menuManagerDtoList.add(menuManagerDto);
                }
            }
            result.put("result", menuManagerDtoList);
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
            List<MenuManager> menuManagerList = menuManagerRepository.findAll();
            List<MenuManagerSelect> menuManagerSelects = new ArrayList<>();
            for (MenuManager menuManager : menuManagerList) {
                MenuManagerSelect menuManagerSelect = new MenuManagerSelect();
                menuManagerSelect.setId(menuManager.getId());
                menuManagerSelect.setValue(menuManager.getMa());
                menuManagerSelect.setTen(menuManager.getTen());
                if (menuManager.getFlag()) {
                    menuManagerSelects.add(menuManagerSelect);
                }
            }
            result.put("result", menuManagerSelects);
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
            MenuManager menuManager = menuManagerRepository.findById(listIds[i]).orElse(null);
            menuManager.setFlag(false);

            menuManagerRepository.save(menuManager);
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
            List<MenuManager> listIdMenuManager = new ArrayList<>();
            for (Long id : listIds) {
                Optional<MenuManager> menuManagerOptional = menuManagerRepository.findById(id);
                if (menuManagerOptional.isPresent()) {
                    listIdMenuManager.add(menuManagerOptional.get());
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
                mapResult.put("pagination", new PaginationDto(page, pageSize, menuManagerDao.countMenuManager(searchString)));
            }

            List<MenuManager> menuManagerList = menuManagerDao.getListMenuManager(searchString, pageable, sortData);
            List<MenuManagerDto> menuManagerDtos = new ArrayList<MenuManagerDto>();
            for (MenuManager menuManager : menuManagerList) {
                MenuManagerDto menuManagerDto = new MenuManagerDto();
                menuManagerDto.setId(menuManager.getId());
                menuManagerDto.setMa(menuManager.getMa());
                menuManagerDto.setStt(menuManager.getStt());
                menuManagerDto.setUrl(menuManager.getUrl());
                menuManagerDto.setNhomMenu(menuManager.getNhomMenu());
                menuManagerDto.setTen(menuManager.getTen());
                menuManagerDtos.add(menuManagerDto);
            }
            mapResult.put("result", menuManagerDtos);
            mapResult.put("status", true);
        } catch (Exception e) {
            e.printStackTrace();
            mapResult.put("result", null);
            mapResult.put("status", false);
            mapResult.put("msg", "Lấy danh sách thất bại");
        }
        return mapResult;
    }
}
