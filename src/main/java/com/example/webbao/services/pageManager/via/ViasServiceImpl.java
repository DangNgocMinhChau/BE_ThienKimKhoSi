package com.example.webbao.services.pageManager.via;

import com.example.webbao.common.PaginationDto;

import com.example.webbao.models.pageManager.via.Vias;
import com.example.webbao.models.pageManager.via.ViasDto;
import com.example.webbao.models.pageManager.via.ViasSelectDto;
import com.example.webbao.repositorys.pageManager.devices.DevicesRepository;
import com.example.webbao.repositorys.pageManager.sim.SimRepository;
import com.example.webbao.repositorys.pageManager.via.ViasRepository;
import com.example.webbao.utils.mail.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ViasServiceImpl implements ViasService {

    @Autowired
    ViasRepository objRepository;

    @Autowired
    ViasDao objectDao;

    @Autowired
    DevicesRepository devicesRepository;

    @Autowired
    SimRepository simRepository;

    @Override
    public Map<String, Object> create(ViasDto objDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            Vias obj = new Vias();
            obj.setTypeApps(objDto.getTypeApps());
            obj.setNumberPhone(objDto.getNumberPhone());
            obj.setDevice(objDto.getDevice());
            obj.setNameVia(objDto.getNameVia());
            obj.setPassword(objDto.getPassword());
            obj.setDateCreate(objDto.getDateCreate());
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
    public Map<String, Object> update(Long id, ViasDto objDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            Vias object = objRepository.findById(id).get();
            object.setId(objDto.getId() != null ? objDto.getId() : object.getId());
            object.setTypeApps(objDto.getTypeApps() != null ? objDto.getTypeApps() : object.getTypeApps());
            object.setNumberPhone(objDto.getNumberPhone() != null ? objDto.getNumberPhone() : object.getNumberPhone());
            object.setDevice(objDto.getDevice() != null ? objDto.getDevice() : object.getDevice());
            object.setNameVia(objDto.getNameVia() != null ? objDto.getNameVia() : object.getNameVia());
            object.setPassword(objDto.getPassword() != null ? objDto.getPassword() : object.getPassword());
            object.setDateCreate(objDto.getDateCreate() != null ? objDto.getDateCreate() : object.getDateCreate());

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
        Vias obj = objRepository.findById(id).orElse(null);
        ViasDto objDto = new ViasDto();
        try {
            if (obj != null) {
                objDto.setTypeApps(obj.getTypeApps());
                objDto.setNumberPhone(obj.getNumberPhone());
                objDto.setDevice(obj.getDevice());
                objDto.setNameVia(obj.getNameVia());
                objDto.setPassword(obj.getPassword());
                objDto.setDateCreate(obj.getDateCreate());
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
            List<Vias> list = objRepository.findAll();
            List<ViasDto> listDto = new ArrayList<>();
            for (Vias obj : list){
                ViasDto objDto = new ViasDto();
                objDto.setId(obj.getId());
                objDto.setTypeApps(obj.getTypeApps());
                objDto.setNumberPhone(obj.getNumberPhone());
                objDto.setDevice(obj.getDevice());
                objDto.setNameVia(obj.getNameVia());
                objDto.setPassword(obj.getPassword());
                objDto.setDateCreate(obj.getDateCreate());
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
            List<Vias> list = objRepository.findAll();
            List<ViasDto> listDto = new ArrayList<>();
            for (Vias obj : list){
                ViasDto objDto = new ViasDto();

                objDto.setId(obj.getId());
                objDto.setTypeApps(obj.getTypeApps());
                objDto.setNumberPhone(obj.getNumberPhone());
                objDto.setDevice(obj.getDevice());
                objDto.setNameVia(obj.getNameVia());
                objDto.setPassword(obj.getPassword());
                objDto.setDateCreate(obj.getDateCreate());
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
            List<Vias> list = objRepository.findAll();
            List<ViasSelectDto> listDto = new ArrayList<>();
            for (Vias obj : list){
                ViasSelectDto item = new ViasSelectDto();
                item.setId(obj.getId());
                item.setTitle(obj.getNameVia());
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
            Vias obj = objRepository.findById(listIds[i]).orElse(null);
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

            List<Vias> list = objectDao.getList(searchString, pageable, sortData);
            List<ViasDto> listDtos = new ArrayList<ViasDto>();
            for (Vias obj : list) {
                System.out.println(obj.getNumberPhone());
                System.out.println(obj.getDevice());
                ViasDto objDto = new ViasDto();
                objDto.setId(obj.getId());
                objDto.setTypeApps(obj.getTypeApps());
                objDto.setDevice(devicesRepository.findById(Long.parseLong(obj.getDevice())).get().getDevices());
                objDto.setNumberPhone(simRepository.findById(Long.parseLong(obj.getNumberPhone())).get().getNumberPhone());
                objDto.setNameVia(obj.getNameVia());
                objDto.setPassword(obj.getPassword());
                objDto.setDateCreate(obj.getDateCreate());
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
            List<Vias> listId = new ArrayList<>();
            for (Long id : listIds) {
                Optional<Vias> objOptional = objRepository.findById(id);
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
