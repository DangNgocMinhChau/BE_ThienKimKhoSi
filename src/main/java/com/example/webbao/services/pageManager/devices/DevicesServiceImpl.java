package com.example.webbao.services.pageManager.devices;

import com.example.webbao.common.PaginationDto;
import com.example.webbao.models.pageManager.devices.Devices;
import com.example.webbao.models.pageManager.devices.DevicesDto;
import com.example.webbao.models.pageManager.devices.DevicesSelectDto;
import com.example.webbao.models.pageManager.sim.Sim;
import com.example.webbao.models.pageManager.sim.SimDto;
import com.example.webbao.models.pageManager.sim.SimSelectDto;
import com.example.webbao.repositorys.pageManager.devices.DevicesRepository;
import com.example.webbao.repositorys.pageManager.sim.SimRepository;
import com.example.webbao.repositorys.pageManager.via.ViasRepository;
import com.example.webbao.services.pageManager.sim.SimDao;
import com.example.webbao.services.pageManager.sim.SimService;
import com.example.webbao.utils.mail.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DevicesServiceImpl implements DevicesService {

    @Autowired
    DevicesRepository objRepository;

    @Autowired
    DevicesDao objectDao;

    @Autowired
    ViasRepository viasRepository;

    @Override
    public Map<String, Object> create(DevicesDto objDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            Devices obj = new Devices();
            obj.setEnvironment(objDto.getEnvironment());
            obj.setDevices(objDto.getDevices());
            obj.setProxy(objDto.getProxy());
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
    public Map<String, Object> update(Long id, DevicesDto objDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            Devices object = objRepository.findById(id).get();
            object.setId(objDto.getId() != null ? objDto.getId() : object.getId());
            object.setEnvironment(objDto.getEnvironment() != null ? objDto.getEnvironment() : object.getEnvironment());
            object.setDevices(objDto.getDevices() != null ? objDto.getDevices() : object.getDevices());
            object.setProxy(objDto.getProxy() != null ? objDto.getProxy() : object.getProxy());
            object.setApps(viasRepository.findAppByIdDevices(object.getId()).toString());
            object.setDateCreate(objDto.getDateCreate() != null ? objDto.getDateCreate() : object.getDateCreate());
            object.setNgayChinhSua(objDto.getNgayChinhSua());
            objRepository.save(object);

            DevicesDto objDtoResult = new DevicesDto();
            objDtoResult.setEnvironment(objDto.getEnvironment());
            objDtoResult.setDevices(objDto.getDevices());
            objDtoResult.setProxy(objDto.getProxy());
            objDtoResult.setApps(viasRepository.findAppByIdDevices(objDto.getId()));
            objDtoResult.setDateCreate(objDto.getDateCreate());
            objDtoResult.setNgayTaoBanGhi(objDto.getNgayTaoBanGhi());
            objDtoResult.setId(objDto.getId());


            result.put("result", objDtoResult);
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
        Devices obj = objRepository.findById(id).orElse(null);
        DevicesDto objDto = new DevicesDto();
        try {
            if (obj != null) {
                objDto.setEnvironment(obj.getEnvironment());
                objDto.setDevices(obj.getDevices());
                objDto.setProxy(obj.getProxy());
                objDto.setApps(viasRepository.findAppByIdDevices(obj.getId()));
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
            List<Devices> list = objRepository.findAll();
            List<DevicesDto> listDto = new ArrayList<>();
            for (Devices obj : list){
                DevicesDto objDto = new DevicesDto();
                objDto.setId(obj.getId());
                objDto.setEnvironment(obj.getEnvironment());
                objDto.setDevices(obj.getDevices());
                objDto.setProxy(obj.getProxy());
                objDto.setApps(viasRepository.findAppByIdDevices(obj.getId()));
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
            List<Devices> list = objRepository.findAll();
            List<DevicesDto> listDto = new ArrayList<>();
            for (Devices obj : list){
                DevicesDto objDto = new DevicesDto();

                objDto.setId(obj.getId());
                objDto.setEnvironment(obj.getEnvironment());
                objDto.setDevices(obj.getDevices());
                objDto.setProxy(obj.getProxy());
                objDto.setApps(viasRepository.findAppByIdDevices(obj.getId()));
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
            List<Devices> list = objRepository.findAll();
            List<DevicesSelectDto> listDto = new ArrayList<>();
            for (Devices obj : list){
                DevicesSelectDto item = new DevicesSelectDto();
                item.setId(obj.getId());
                item.setTitle(obj.getDevices());
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
            Devices obj = objRepository.findById(listIds[i]).orElse(null);
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

            List<Devices> list = objectDao.getList(searchString, pageable, sortData);
            List<DevicesDto> listDtos = new ArrayList<DevicesDto>();
            for (Devices obj : list) {
                DevicesDto objDto = new DevicesDto();
                objDto.setId(obj.getId());
                objDto.setEnvironment(obj.getEnvironment());
                objDto.setDevices(obj.getDevices());
                objDto.setProxy(obj.getProxy());
                objDto.setApps(viasRepository.findAppByIdDevices(obj.getId()));
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
            List<Devices> listId = new ArrayList<>();
            for (Long id : listIds) {
                Optional<Devices> objOptional = objRepository.findById(id);
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
