package com.example.webbao.services.pageManager.sim;

import com.example.webbao.common.PaginationDto;

import com.example.webbao.models.pageManager.sim.Sim;
import com.example.webbao.models.pageManager.sim.SimDto;
import com.example.webbao.models.pageManager.sim.SimSelectDto;
import com.example.webbao.repositorys.pageManager.sim.SimRepository;
import com.example.webbao.services.pageManager.menu.MenuCoreService;
import com.example.webbao.utils.mail.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SimServiceImpl implements SimService {

    @Autowired
    SimRepository objRepository;

    @Autowired
    SimDao objectDao;

    @Override
    public Map<String, Object> create(SimDto objDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            Sim obj = new Sim();
            obj.setNumberSeri(objDto.getNumberSeri());
            obj.setNumberPhone(objDto.getNumberPhone());
            obj.setTypeSim(objDto.getTypeSim());
            obj.setHsdsim(objDto.getHsdsim());
            obj.setNgayTaoBanGhi(objDto.getNgayTaoBanGhi());
            obj.setFlag(true);

            objRepository.save(obj);
            result.put("result", obj);
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
    public Map<String, Object> update(Long id, SimDto objDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            Sim object = objRepository.findById(id).get();
            object.setId(objDto.getId() != null ? objDto.getId() : object.getId());
            object.setNumberSeri(objDto.getNumberSeri() != null ? objDto.getNumberSeri() : object.getNumberSeri());
            object.setNumberPhone(objDto.getNumberPhone() != null ? objDto.getNumberPhone() : object.getNumberPhone());
            object.setTypeSim(objDto.getTypeSim() != null ? objDto.getTypeSim() : object.getTypeSim());
            object.setHsdsim(objDto.getHsdsim() != null ? objDto.getHsdsim() : object.getHsdsim());

            object.setNgayChinhSua(objDto.getNgayChinhSua());
            objRepository.save(object);
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
        Sim obj = objRepository.findById(id).orElse(null);
        SimDto objDto = new SimDto();
        try {
            if (obj != null) {
                objDto.setNumberSeri(obj.getNumberSeri());
                objDto.setNumberPhone(obj.getNumberPhone());
                objDto.setTypeSim(obj.getTypeSim());
                objDto.setHsdsim(obj.getHsdsim());
                objDto.setNgayTaoBanGhi(obj.getNgayTaoBanGhi());
                objDto.setId(obj.getId());

                result.put("result", objDto);
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
            List<Sim> list = objRepository.findAll();
            List<SimDto> listDto = new ArrayList<>();
            for (Sim obj : list){
                SimDto objDto = new SimDto();
                objDto.setId(obj.getId());
                objDto.setNumberSeri(obj.getNumberSeri());
                objDto.setNumberPhone(obj.getNumberPhone());
                objDto.setTypeSim(obj.getTypeSim());
                objDto.setHsdsim(obj.getHsdsim());
                objDto.setNgayTaoBanGhi(obj.getNgayTaoBanGhi());
                if (obj.getFlag()) {
                    listDto.add(objDto);
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
            List<Sim> list = objRepository.findAll();
            List<SimDto> listDto = new ArrayList<>();
            for (Sim obj : list){
                SimDto objDto = new SimDto();

                objDto.setId(obj.getId());
                objDto.setNumberSeri(obj.getNumberSeri());
                objDto.setNumberPhone(obj.getNumberPhone());
                objDto.setTypeSim(obj.getTypeSim());
                objDto.setHsdsim(obj.getHsdsim());
                objDto.setNgayTaoBanGhi(obj.getNgayTaoBanGhi());

                if (obj.getFlag()) {
                    listDto.add(objDto);
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
            List<Sim> list = objRepository.findAll();
            List<SimSelectDto> listDto = new ArrayList<>();
            for (Sim obj : list){
                SimSelectDto item = new SimSelectDto();
                item.setId(obj.getId());
                item.setTitle(obj.getNumberPhone());
                item.setValue(obj.getId().toString());
                if (obj.getFlag()) {
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
            Sim obj = objRepository.findById(listIds[i]).orElse(null);
            obj.setFlag(false);
            objRepository.save(obj);
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
                mapResult.put("pagination", new PaginationDto(page, pageSize, objectDao.count(searchString)));
            }

            List<Sim> list = objectDao.getList(searchString, pageable, sortData);
            List<SimDto> listDtos = new ArrayList<SimDto>();
            for (Sim obj : list) {
                SimDto objDto = new SimDto();
                objDto.setId(obj.getId());
                objDto.setNumberSeri(obj.getNumberSeri());
                objDto.setNumberPhone(obj.getNumberPhone());
                objDto.setTypeSim(obj.getTypeSim());
                objDto.setHsdsim(obj.getHsdsim());
                objDto.setNgayTaoBanGhi(obj.getNgayTaoBanGhi());
                listDtos.add(objDto);
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
            List<Sim> listId = new ArrayList<>();
            for (Long id : listIds) {
                Optional<Sim> objOptional = objRepository.findById(id);
                if (objOptional.isPresent()) {
                    listId.add(objOptional.get());
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
