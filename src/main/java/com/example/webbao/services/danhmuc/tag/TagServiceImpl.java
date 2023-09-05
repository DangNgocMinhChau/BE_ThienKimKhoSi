package com.example.webbao.services.danhmuc.tag;

import com.example.webbao.common.PaginationDto;
import com.example.webbao.models.danhmuc.quyen.QuyenDto;
import com.example.webbao.models.danhmuc.tag.Tag;
import com.example.webbao.models.danhmuc.tag.TagDto;
import com.example.webbao.models.danhmuc.tag.TagSelect;
import com.example.webbao.repositorys.danhmuc.tag.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    @Autowired
    TagDao tagDao;

    @Override
    public Tag findById(Long tagId) {
        return tagRepository.findById(tagId).orElse(null);
    }

    @Override
    public Map<String, Object> create(TagDto tagDto) {
        Map<String, Object> result = new HashMap<>();
        TagDto resultCreate = new TagDto();
        Tag checkTag = tagRepository.checkMaTrungNhau(tagDto.getMa());
        try {
            if(checkTag == null){
                Tag tag = new Tag();
                tag.setMa(tagDto.getMa());
                tag.setTen(tagDto.getTen());
                tag.setNhomMenu(tagDto.getNhomMenu());
                tag.setPhanLoai(tagDto.getPhanLoai());
                tag.setNgayTaoBanGhi(tagDto.getNgayTaoBanGhi());
                tag.setFlag(true);
                tagRepository.save(tag);

                resultCreate.setId(tag.getId());
                resultCreate.setMa(tagDto.getMa());
                resultCreate.setTen(tagDto.getTen());
                resultCreate.setNhomMenu(tagDto.getNhomMenu());
                resultCreate.setPhanLoai(tagDto.getPhanLoai());
                result.put("result", resultCreate);
                result.put("msg", "Thêm mới " + tagDto.getTen() + " thành công !");
                result.put("status", true);
            }else {
                result.put("msg", "Mã này đã tồn tại !");
                result.put("status", false);
            }
        } catch (Exception e) {
            result.put("msg", "Thêm mới thất bại !");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, TagDto tagDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            Tag object = tagRepository.findById(id).get();
            object.setId(tagDto.getId() != null ? tagDto.getId() : object.getId());
            object.setMa(tagDto.getMa() != null ? tagDto.getMa() : object.getMa());
            object.setTen(tagDto.getTen() != null ? tagDto.getTen() : object.getTen());
            object.setPhanLoai(tagDto.getPhanLoai() != null ? tagDto.getPhanLoai() : object.getPhanLoai());
            object.setNhomMenu(tagDto.getNhomMenu() != null ? tagDto.getNhomMenu() : object.getNhomMenu());
            object.setNgayChinhSua(tagDto.getNgayChinhSua());

            tagRepository.save(object);
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
        Tag tag = tagRepository.findById(id).orElse(null);
        TagDto tagDto = new TagDto();
        try {
            if (tag != null) {
                tagDto.setId(tag.getId());
                tagDto.setMa(tag.getMa());
                tagDto.setTen(tag.getTen());
                tagDto.setPhanLoai(tag.getPhanLoai());
                tagDto.setNhomMenu(tag.getNhomMenu());
                result.put("result", tagDto);
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
            List<Tag> tagList = tagRepository.findAll();
            List<TagDto> tagDtoList = new ArrayList<>();
            for (Tag tag : tagList) {
                TagDto tagDto = new TagDto();
                tagDto.setId(tag.getId());
                tagDto.setMa(tag.getMa());
                tagDto.setNhomMenu(tag.getNhomMenu());
                tagDto.setPhanLoai(tag.getPhanLoai());
                tagDto.setTen(tag.getTen());
                if (tag.getFlag()) {
                    tagDtoList.add(tagDto);
                }
            }
            result.put("result", tagDtoList);
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
            List<Tag> tagList = tagRepository.findAll();
            List<TagSelect> tagSelects = new ArrayList<>();
            for (Tag tag : tagList) {
                TagSelect tagSelect = new TagSelect();
                tagSelect.setId(tag.getId());
                tagSelect.setValue(tag.getMa());
                tagSelect.setTen(tag.getTen());
                if (tag.getFlag()) {
                    tagSelects.add(tagSelect);
                }
            }
            result.put("result", tagSelects);
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
            Tag tag = tagRepository.findById(listIds[i]).orElse(null);
            tag.setFlag(false);

            tagRepository.save(tag);
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
            List<Tag> listIdTag = new ArrayList<>();
            for (Long id : listIds) {
                Optional<Tag> tagOptional = tagRepository.findById(id);
                if (tagOptional.isPresent()) {
                    listIdTag.add(tagOptional.get());
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
                mapResult.put("pagination", new PaginationDto(page, pageSize, tagDao.countTag(searchString)));
            }

            List<Tag> tagList = tagDao.getListTag(searchString, pageable, sortData);
            List<TagDto> tagDtos = new ArrayList<TagDto>();
            for (Tag tag : tagList) {
                TagDto tagDto = new TagDto();
                tagDto.setId(tag.getId());
                tagDto.setMa(tag.getMa());
                tagDto.setTen(tag.getTen());
                tagDto.setNhomMenu(tag.getNhomMenu());
                tagDto.setPhanLoai(tag.getPhanLoai());
                tagDtos.add(tagDto);
            }
            mapResult.put("result", tagDtos);
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
