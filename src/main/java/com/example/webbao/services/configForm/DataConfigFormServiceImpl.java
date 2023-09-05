package com.example.webbao.services.configForm;

import com.example.webbao.common.PaginationDto;
import com.example.webbao.models.configForm.DataConfigForm;
import com.example.webbao.models.configForm.DataConfigFormDto;
import com.example.webbao.repositorys.configForm.DataConfigFormRepository;
import com.example.webbao.utils.mail.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DataConfigFormServiceImpl implements DataConfigFormService {

    @Autowired
    DataConfigFormRepository dataConfigFormRepository;

    @Autowired
    DataConfigFormDao dataConfigFormDao;

    @Override
    public DataConfigForm findById(Long id) {
        return dataConfigFormRepository.findById(id).orElse(null);
    }

    @Override
    public Map<String, Object> create(DataConfigFormDto dataConfigFormDto) {
        Map<String, Object> result = new HashMap<>();
        DataConfigFormDto resultCreate = new DataConfigFormDto();
        try {
            DataConfigForm dataConfigForm = new DataConfigForm();
            dataConfigForm.setCodeForm(dataConfigFormDto.getCodeForm());
            dataConfigForm.setUrlMapping(dataConfigFormDto.getUrlMapping());
            dataConfigForm.setDataForm(dataConfigFormDto.getDataForm());
            dataConfigForm.setIdForm(dataConfigFormDto.getIdForm());

            dataConfigForm.setNgayTaoBanGhi(dataConfigFormDto.getNgayTaoBanGhi());
            dataConfigForm.setFlag(true);
            dataConfigFormRepository.save(dataConfigForm);

            resultCreate.setCodeForm(dataConfigFormDto.getCodeForm());
            resultCreate.setUrlMapping(dataConfigFormDto.getUrlMapping());
            resultCreate.setDataForm(dataConfigFormDto.getDataForm());
            resultCreate.setIdForm(dataConfigFormDto.getIdForm());

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
    public Map<String, Object> update(Long id, DataConfigFormDto dataConfigFormDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            DataConfigForm object = dataConfigFormRepository.findById(id).get();
            object.setId(dataConfigFormDto.getId() != null ? dataConfigFormDto.getId() : object.getId());
            object.setCodeForm(dataConfigFormDto.getCodeForm() != null ? dataConfigFormDto.getCodeForm() : object.getCodeForm());
            object.setUrlMapping(dataConfigFormDto.getUrlMapping() != null ? dataConfigFormDto.getUrlMapping() : object.getUrlMapping());
            object.setDataForm(dataConfigFormDto.getDataForm() != null ? dataConfigFormDto.getDataForm() : object.getDataForm());
            object.setIdForm(dataConfigFormDto.getIdForm() != null ? dataConfigFormDto.getIdForm() : object.getCodeForm());
            object.setNgayChinhSua(dataConfigFormDto.getNgayChinhSua());
            dataConfigFormRepository.save(object);
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
        DataConfigForm item = dataConfigFormRepository.findById(id).orElse(null);
        DataConfigFormDto itemDto = new DataConfigFormDto();
        try {
            if (item != null) {
                itemDto.setId(item.getId());
                itemDto.setCodeForm(item.getCodeForm());
                itemDto.setUrlMapping(item.getUrlMapping());
                itemDto.setDataForm(item.getDataForm());
                itemDto.setIdForm(item.getIdForm());

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
            List<DataConfigForm> list = dataConfigFormRepository.findAll();
            List<DataConfigFormDto> listDto = new ArrayList<>();
            for (DataConfigForm item : list) {
                DataConfigFormDto itemDto = new DataConfigFormDto();
                itemDto.setId(item.getId());
                itemDto.setCodeForm(item.getCodeForm());
                itemDto.setUrlMapping(item.getUrlMapping());
                itemDto.setDataForm(item.getDataForm());
                itemDto.setIdForm(item.getIdForm());
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
            DataConfigForm item = dataConfigFormRepository.findById(listIds[i]).orElse(null);
            item.setFlag(false);
            dataConfigFormRepository.save(item);
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
            List<DataConfigForm> listId= new ArrayList<>();
            for (Long id : listIds) {
                Optional<DataConfigForm> listOptional = dataConfigFormRepository.findById(id);
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
                mapResult.put("pagination", new PaginationDto(page, pageSize, dataConfigFormDao.count(searchString)));
            }

            List<DataConfigForm> list = dataConfigFormDao.getList(searchString, pageable, sortData);
            List<DataConfigFormDto> listDto = new ArrayList<DataConfigFormDto>();
            for (DataConfigForm item : list) {
                DataConfigFormDto itemDto = new DataConfigFormDto();
                itemDto.setId(item.getId());
                itemDto.setCodeForm(item.getCodeForm());
                itemDto.setUrlMapping(item.getUrlMapping());
                itemDto.setDataForm(item.getDataForm());
                itemDto.setIdForm(item.getIdForm());
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
