package com.example.webbao.services.configForm;

import com.example.webbao.common.PaginationDto;
import com.example.webbao.models.configForm.ConfigForm;
import com.example.webbao.models.configForm.ConfigFormDto;
import com.example.webbao.models.orderform.OrderForm;
import com.example.webbao.models.orderform.OrderFormDto;
import com.example.webbao.repositorys.configForm.ConfigFormRepository;
import com.example.webbao.repositorys.orderform.OrderFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ConfigFormServiceImpl implements ConfigFormService {

    @Autowired
    ConfigFormRepository configFormRepository;

    @Autowired
    ConfigFormDao configFormDao;

    @Override
    public ConfigForm findById(Long id) {
        return configFormRepository.findById(id).orElse(null);
    }

    @Override
    public Map<String, Object> create(ConfigFormDto configFormDto) {
        Map<String, Object> result = new HashMap<>();
        ConfigFormDto resultCreate = new ConfigFormDto();
        try {
            ConfigForm configForm = new ConfigForm();
            configForm.setCodeForm(configFormDto.getCodeForm());
            configForm.setMenuMapping(configFormDto.getMenuMapping());
            configForm.setNameForm(configFormDto.getNameForm());
            configForm.setTypeForm(configFormDto.getTypeForm());
            configForm.setFieldMapform(configFormDto.getFieldMapform());


            configForm.setNgayTaoBanGhi(configFormDto.getNgayTaoBanGhi());
            configForm.setFlag(true);
            configFormRepository.save(configForm);

            resultCreate.setCodeForm(configFormDto.getCodeForm());
            resultCreate.setMenuMapping(configFormDto.getMenuMapping());
            resultCreate.setNameForm(configFormDto.getNameForm());
            resultCreate.setTypeForm(configFormDto.getTypeForm());
            resultCreate.setFieldMapform(configFormDto.getFieldMapform());

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
    public Map<String, Object> update(Long id, ConfigFormDto configFormDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            ConfigForm object = configFormRepository.findById(id).get();
            object.setId(configFormDto.getId() != null ? configFormDto.getId() : object.getId());
            object.setCodeForm(configFormDto.getCodeForm() != null ? configFormDto.getCodeForm() : object.getCodeForm());
            object.setMenuMapping(configFormDto.getMenuMapping() != null ? configFormDto.getMenuMapping() : object.getMenuMapping());
            object.setNameForm(configFormDto.getNameForm() != null ? configFormDto.getNameForm() : object.getNameForm());
            object.setTypeForm(configFormDto.getTypeForm() != null ? configFormDto.getTypeForm() : object.getCodeForm());
            object.setFieldMapform(configFormDto.getFieldMapform() != null ? configFormDto.getFieldMapform() : object.getFieldMapform());

            object.setNgayChinhSua(configFormDto.getNgayChinhSua());
            configFormRepository.save(object);
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
        ConfigForm configForm = configFormRepository.findById(id).orElse(null);
        ConfigFormDto configFormDto = new ConfigFormDto();
        try {
            if (configForm != null) {
                configFormDto.setId(configForm.getId());
                configFormDto.setCodeForm(configForm.getCodeForm());
                configFormDto.setMenuMapping(configForm.getMenuMapping());
                configFormDto.setTypeForm(configForm.getTypeForm());
                configFormDto.setNameForm(configForm.getNameForm());
                configFormDto.setFieldMapform(configForm.getFieldMapform());

                result.put("result", configFormDto);
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
            List<ConfigForm> list = configFormRepository.findAll();
            List<ConfigFormDto> listDto = new ArrayList<>();
            for (ConfigForm configForm : list) {
                ConfigFormDto configFormDto = new ConfigFormDto();
                configFormDto.setId(configForm.getId());
                configFormDto.setCodeForm(configForm.getCodeForm());
                configFormDto.setMenuMapping(configForm.getMenuMapping());
                configFormDto.setNameForm(configForm.getNameForm());
                configFormDto.setTypeForm(configForm.getTypeForm());
                configFormDto.setFieldMapform(configForm.getFieldMapform());

                if (configForm.getFlag()) {
                    listDto.add(configFormDto);
                }
            }
            result.put("result", listDto);
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
            ConfigForm configForm = configFormRepository.findById(listIds[i]).orElse(null);
            configForm.setFlag(false);
            configFormRepository.save(configForm);
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
            List<ConfigForm> listId= new ArrayList<>();
            for (Long id : listIds) {
                Optional<ConfigForm> listOptional = configFormRepository.findById(id);
                if (listOptional.isPresent()) {
                    listId.add(listOptional.get());
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
                mapResult.put("pagination", new PaginationDto(page, pageSize, configFormDao.count(searchString)));
            }

            List<ConfigForm> list = configFormDao.getList(searchString, pageable, sortData);
            List<ConfigFormDto> listDto = new ArrayList<ConfigFormDto>();
            for (ConfigForm configForm : list) {
                ConfigFormDto configFormDto = new ConfigFormDto();
                configFormDto.setId(configForm.getId());
                configFormDto.setCodeForm(configForm.getCodeForm());
                configFormDto.setNameForm(configForm.getNameForm());
                configFormDto.setMenuMapping(configForm.getMenuMapping());
                configFormDto.setTypeForm(configForm.getTypeForm());
                configFormDto.setFieldMapform(configForm.getFieldMapform());

                listDto.add(configFormDto);
            }
            mapResult.put("result", listDto);
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
