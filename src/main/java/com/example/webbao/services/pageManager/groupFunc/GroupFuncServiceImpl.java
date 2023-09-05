package com.example.webbao.services.pageManager.groupFunc;

import com.example.webbao.common.PaginationDto;

import com.example.webbao.models.pageManager.groupFunc.GroupFunc;
import com.example.webbao.models.pageManager.groupFunc.GroupFuncDto;
import com.example.webbao.repositorys.pageManager.groupFunc.GroupFuncRepository;
import com.example.webbao.utils.mail.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroupFuncServiceImpl implements GroupFuncService {

    @Autowired
    GroupFuncRepository groupFuncRepository;

    @Autowired
    GroupFuncDao groupFuncDao;

    @Override
    public GroupFunc findById(Long id) {
        return groupFuncRepository.findById(id).orElse(null);
    }

    @Override
    public Map<String, Object> create(GroupFuncDto groupFuncDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            GroupFunc item = new GroupFunc();
            item.setGroupFunc(groupFuncDto.getGroupFunc());
            item.setCodeGroupFunc(groupFuncDto.getCodeGroupFunc());
            item.setNameGroupFunc(groupFuncDto.getNameGroupFunc());
            item.setNgayTaoBanGhi(groupFuncDto.getNgayTaoBanGhi());
            item.setFlag(true);
            groupFuncRepository.save(item);

            result.put("result", item);
            result.put("msg", Const.THEM_MOI_THANH_CONG);
            result.put("status", true);

        } catch (Exception e) {
            result.put("msg", Const.THEM_MOI_THAT_BAI);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, GroupFuncDto item) {
        Map<String, Object> result = new HashMap<>();
        try {
            GroupFunc object = groupFuncRepository.findById(id).get();
            object.setId(item.getId() != null ? item.getId() : object.getId());
            object.setNameGroupFunc(item.getNameGroupFunc() != null ? item.getNameGroupFunc() : object.getGroupFunc());
            object.setCodeGroupFunc(item.getCodeGroupFunc() != null ? item.getCodeGroupFunc() : object.getCodeGroupFunc());
            object.setGroupFunc(item.getGroupFunc() != null ? item.getGroupFunc() : object.getGroupFunc());
            object.setNgayChinhSua(item.getNgayChinhSua());
            groupFuncRepository.save(object);
            result.put("result", object);
            result.put("msg", Const.SUA_THANH_CONG);
            result.put("status", true);
        } catch (Exception e) {
            result.put("msg", Const.SUA_THAT_BAI);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> fetchById(Long id) {
        Map<String, Object> result = new HashMap<>();
        GroupFunc item = groupFuncRepository.findById(id).orElse(null);
        GroupFuncDto itemDto = new GroupFuncDto();
        try {
            if (item != null) {
                itemDto.setId(item.getId());
                itemDto.setGroupFunc(item.getGroupFunc());
                itemDto.setCodeGroupFunc(item.getCodeGroupFunc());
                itemDto.setNameGroupFunc(item.getNameGroupFunc());
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
            List<GroupFunc> list = groupFuncRepository.findAll();
            List<GroupFuncDto> listDto = new ArrayList<>();
            for (GroupFunc item : list) {
                GroupFuncDto itemDto = new GroupFuncDto();
                itemDto.setId(item.getId());
                itemDto.setNameGroupFunc(item.getNameGroupFunc());
                itemDto.setGroupFunc(item.getGroupFunc());
                itemDto.setCodeGroupFunc(item.getCodeGroupFunc());
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
            GroupFunc item = groupFuncRepository.findById(listIds[i]).orElse(null);
            item.setFlag(false);
            groupFuncRepository.save(item);
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
            List<GroupFunc> listId= new ArrayList<>();
            for (Long id : listIds) {
                Optional<GroupFunc> listOptional = groupFuncRepository.findById(id);
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
                mapResult.put("pagination", new PaginationDto(page, pageSize, groupFuncDao.count(searchString)));
            }

            List<GroupFunc> list = groupFuncDao.getList(searchString, pageable, sortData);
            List<GroupFuncDto> listDto = new ArrayList<GroupFuncDto>();
            for (GroupFunc item : list) {
                GroupFuncDto itemDto = new GroupFuncDto();
                itemDto.setId(item.getId());
                itemDto.setCodeGroupFunc(item.getCodeGroupFunc());
                itemDto.setGroupFunc(item.getGroupFunc());
                itemDto.setNameGroupFunc(item.getNameGroupFunc());
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
