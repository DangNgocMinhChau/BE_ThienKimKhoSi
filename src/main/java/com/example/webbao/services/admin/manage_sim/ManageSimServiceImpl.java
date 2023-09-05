package com.example.webbao.services.admin.manage_sim;

import com.example.webbao.common.PaginationDto;
import com.example.webbao.models.admin.manage_sim.ManageSim;
import com.example.webbao.models.admin.manage_sim.ManageSimDto;
import com.example.webbao.repositorys.admin.manage_sim.ManageSimRepository;
import com.example.webbao.utils.mail.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ManageSimServiceImpl implements ManageSimService {

    @Autowired
    ManageSimRepository manageSimRepository;

    @Autowired
    ManageSimDao manageSimDao;

    @Override
    public ManageSim findById(Long id) {
        return manageSimRepository.findById(id).orElse(null);
    }

    @Override
    public Map<String, Object> create(ManageSimDto itemDto) {
        Map<String, Object> result = new HashMap<>();
        ManageSimDto resultCreate = new ManageSimDto();
        try {
            ManageSim item = new ManageSim();
            item.setNumberSeri(itemDto.getNumberSeri());
            item.setNumberPhone(itemDto.getNumberPhone());
            item.setNameSim(itemDto.getNameSim());
            item.setTypeSim(itemDto.getTypeSim());
            item.setEmail(itemDto.getEmail());
            item.setSocial(itemDto.getSocial());
            item.setHSDSim(itemDto.getHSDSim());
            item.setPassword(itemDto.getPassword());


            item.setNgayTaoBanGhi(itemDto.getNgayTaoBanGhi());
            item.setFlag(true);
            manageSimRepository.save(item);

            resultCreate.setNumberSeri(itemDto.getNumberSeri());
            resultCreate.setNumberPhone(itemDto.getNumberPhone());
            resultCreate.setNameSim(itemDto.getNameSim());
            resultCreate.setTypeSim(itemDto.getTypeSim());
            resultCreate.setEmail(itemDto.getEmail());
            resultCreate.setSocial(itemDto.getSocial());
            resultCreate.setHSDSim(itemDto.getHSDSim());
            resultCreate.setPassword(itemDto.getPassword());

            result.put("result", resultCreate);
            result.put("msg", Const.LAY_DANH_SACH_THANH_CONG);
            result.put("status", true);

        } catch (Exception e) {
            result.put("msg", Const.LAY_DANH_SACH_THAT_BAI);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, ManageSimDto itemDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            ManageSim object = manageSimRepository.findById(id).get();
            object.setId(itemDto.getId() != null ? itemDto.getId() : object.getId());
            object.setNumberSeri(itemDto.getNumberSeri() != null ? itemDto.getNumberSeri() : object.getNumberSeri());
            object.setNumberPhone(itemDto.getNumberPhone() != null ? itemDto.getNumberPhone() : object.getNumberPhone());
            object.setNameSim(itemDto.getNameSim() != null ? itemDto.getNameSim() : object.getNameSim());
            object.setTypeSim(itemDto.getTypeSim() != null ? itemDto.getTypeSim() : object.getTypeSim());
            object.setEmail(itemDto.getEmail() != null ? itemDto.getEmail() : object.getEmail());
            object.setSocial(itemDto.getSocial() != null ? itemDto.getSocial() : object.getSocial());
            object.setNoteSim(itemDto.getNoteSim() != null ? itemDto.getNoteSim() : object.getNoteSim());
            object.setHSDSim(itemDto.getHSDSim() != null ? itemDto.getHSDSim() : object.getHSDSim());
            object.setPassword(itemDto.getPassword() != null ? itemDto.getPassword() : object.getPassword());

            object.setNgayChinhSua(itemDto.getNgayChinhSua());
            manageSimRepository.save(object);
            result.put("result", object);
            result.put("msg", Const.LAY_DANH_SACH_THANH_CONG);
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", Const.LAY_DANH_SACH_THAT_BAI);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> fetchById(Long id) {
        Map<String, Object> result = new HashMap<>();
        ManageSim item = manageSimRepository.findById(id).orElse(null);
        ManageSimDto itemDto = new ManageSimDto();
        try {
            if (item != null) {
                itemDto.setId(item.getId());
                itemDto.setNumberSeri(item.getNumberSeri());
                itemDto.setNumberPhone(item.getNumberPhone());
                itemDto.setNameSim(item.getNameSim());
                itemDto.setTypeSim(item.getTypeSim());
                itemDto.setEmail(item.getEmail());
                itemDto.setSocial(item.getSocial());
                itemDto.setNoteSim(item.getNoteSim());
                itemDto.setHSDSim(item.getHSDSim());
                itemDto.setPassword(item.getPassword());

                result.put("result", itemDto);
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
            List<ManageSim> list = manageSimRepository.findAll();
            List<ManageSimDto> listDto = new ArrayList<>();
            for (ManageSim item : list) {
                ManageSimDto itemDto = new ManageSimDto();
                itemDto.setId(item.getId());
                itemDto.setNumberSeri(item.getNumberSeri());
                itemDto.setNumberPhone(item.getNumberPhone());
                itemDto.setNameSim(item.getNameSim());
                itemDto.setTypeSim(item.getTypeSim());
                itemDto.setEmail(item.getEmail());
                itemDto.setSocial(item.getSocial());
                itemDto.setNoteSim(item.getNoteSim());
                itemDto.setHSDSim(item.getHSDSim());
                itemDto.setPassword(item.getPassword());
                if (item.getFlag()) {
                    listDto.add(itemDto);
                }
            }
            result.put("result", listDto);
            result.put("msg", Const.LAY_DANH_SACH_THANH_CONG);
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", Const.LAY_DANH_SACH_THAT_BAI);
            result.put("status", false);
        }
        return result;
    }


    @Override
    public Map<String, Object> delete(Long[] listIds) {
        Map<String, Object> result = new HashMap<>();

        for (int i = 0; i < listIds.length; i++) {
            ManageSim item = manageSimRepository.findById(listIds[i]).orElse(null);
            item.setFlag(false);
            manageSimRepository.save(item);
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
            List<ManageSim> listId= new ArrayList<>();
            for (Long id : listIds) {
                Optional<ManageSim> listOptional = manageSimRepository.findById(id);
                if (listOptional.isPresent()) {
                    listId.add(listOptional.get());
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
        Map<String, Object> mapResult = new HashMap<>();
        try {
            if (sortData == null) {
                sortData = "id DESC";
            }
            Pageable pageable = null;

            if (pageSize != null && page != null) {
                pageable = PageRequest.of(page - 1, pageSize);
                mapResult.put("pagination", new PaginationDto(page, pageSize, manageSimDao.count(searchString)));
            }

            List<ManageSim> list = manageSimDao.getList(searchString, pageable, sortData);
            List<ManageSimDto> listDto = new ArrayList<ManageSimDto>();
            for (ManageSim item : list) {
                ManageSimDto itemDto = new ManageSimDto();
                itemDto.setId(item.getId());
                itemDto.setNumberSeri(item.getNumberSeri());
                itemDto.setNumberPhone(item.getNumberPhone());
                itemDto.setNameSim(item.getNameSim());
                itemDto.setTypeSim(item.getTypeSim());
                itemDto.setEmail(item.getEmail());
                itemDto.setSocial(item.getSocial());
                itemDto.setNoteSim(item.getNoteSim());
                itemDto.setHSDSim(item.getHSDSim());
                itemDto.setPassword(item.getPassword());
                listDto.add(itemDto);
            }
            mapResult.put("result", listDto);
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
}
