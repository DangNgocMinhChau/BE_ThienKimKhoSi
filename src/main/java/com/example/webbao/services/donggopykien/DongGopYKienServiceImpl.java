package com.example.webbao.services.donggopykien;

import com.example.webbao.common.PaginationDto;
import com.example.webbao.controllers.mail.MailController;
import com.example.webbao.models.donggopykien.DongGopYKien;
import com.example.webbao.models.donggopykien.DongGopYKienDto;
import com.example.webbao.repositorys.donggopykien.DongGopYKienRepository;
import com.example.webbao.utils.mail.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.*;

@Service
public class DongGopYKienServiceImpl implements DongGopYKienService {

    @Autowired
    DongGopYKienRepository dongGopYKienRepository;

    @Autowired
    DongGopYKienDao dongGopYKienDao;

    @Override
    public DongGopYKien findById(Long id) {
        return dongGopYKienRepository.findById(id).orElse(null);
    }

    @Autowired
    MailController mailController;
    @Override
    public Map<String, Object> create(DongGopYKienDto dongGopYKienDto) {
        Map<String, Object> result = new HashMap<>();
        DongGopYKienDto resultCreate = new DongGopYKienDto();
        try {
            DongGopYKien dongGopYKien = new DongGopYKien();
            dongGopYKien.setEmail(dongGopYKienDto.getEmail());
            dongGopYKien.setSdt(dongGopYKienDto.getSdt());
            dongGopYKien.setTen(dongGopYKienDto.getTen());
            dongGopYKien.setDiaChi(dongGopYKienDto.getDiaChi());
            dongGopYKien.setTieuDe(dongGopYKienDto.getTieuDe());
            dongGopYKien.setNoiDung(dongGopYKienDto.getNoiDung());
            dongGopYKien.setDaTraLoi(false);

            dongGopYKien.setNgayTaoBanGhi(dongGopYKienDto.getNgayTaoBanGhi());
            dongGopYKien.setFlag(true);

            dongGopYKienRepository.save(dongGopYKien);

            resultCreate.setEmail(dongGopYKienDto.getEmail());
            resultCreate.setId(dongGopYKienDto.getId());
            resultCreate.setSdt(dongGopYKienDto.getSdt());
            resultCreate.setTen(dongGopYKienDto.getTen());
            resultCreate.setTieuDe(dongGopYKienDto.getTieuDe());
            resultCreate.setDiaChi(dongGopYKienDto.getDiaChi());
            resultCreate.setNoiDung(dongGopYKienDto.getNoiDung());
            resultCreate.setDaTraLoi(false);

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
    public Map<String, Object> update(Long id, DongGopYKienDto dongGopYKienDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            DongGopYKien object = dongGopYKienRepository.findById(id).get();
            object.setId(dongGopYKienDto.getId() != null ? dongGopYKienDto.getId() : object.getId());
            object.setTen(dongGopYKienDto.getTen() != null ? dongGopYKienDto.getTen() : object.getTen());
            object.setSdt(dongGopYKienDto.getSdt() != null ? dongGopYKienDto.getSdt() : object.getSdt());
            object.setEmail(dongGopYKienDto.getEmail() != null ? dongGopYKienDto.getEmail() : object.getEmail());
            object.setDiaChi(dongGopYKienDto.getDiaChi() != null ? dongGopYKienDto.getDiaChi() : object.getDiaChi());
            object.setTieuDe(dongGopYKienDto.getTieuDe() != null ? dongGopYKienDto.getTieuDe() : object.getTieuDe());
            object.setNoiDung(dongGopYKienDto.getNoiDung() != null ? dongGopYKienDto.getNoiDung() : object.getNoiDung());
            object.setNgayChinhSua(dongGopYKienDto.getNgayChinhSua());
            dongGopYKienRepository.save(object);

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
        DongGopYKien dongGopYKien = dongGopYKienRepository.findById(id).orElse(null);
        DongGopYKienDto dongGopYKienDto = new DongGopYKienDto();
        try {
            if (dongGopYKien != null) {
                dongGopYKienDto.setId(dongGopYKien.getId());
                dongGopYKienDto.setEmail(dongGopYKien.getEmail());
                dongGopYKienDto.setTen(dongGopYKien.getTen());
                dongGopYKienDto.setSdt(dongGopYKien.getSdt());
                dongGopYKienDto.setDiaChi(dongGopYKien.getDiaChi());
                dongGopYKienDto.setTieuDe(dongGopYKien.getTieuDe());
                dongGopYKienDto.setNoiDung(dongGopYKien.getNoiDung());
                dongGopYKienDto.setDaTraLoi(dongGopYKien.getDaTraLoi());

                result.put("result", dongGopYKienDto);
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
            List<DongGopYKien> dongGopYKienList = dongGopYKienRepository.findAll();
            List<DongGopYKienDto> dongGopYKienDtoList = new ArrayList<>();
            for (DongGopYKien dongGopYKien : dongGopYKienList) {
                DongGopYKienDto dongGopYKienDto = new DongGopYKienDto();
                dongGopYKienDto.setId(dongGopYKien.getId());
                dongGopYKienDto.setTen(dongGopYKien.getTen());
                dongGopYKienDto.setSdt(dongGopYKien.getSdt());
                dongGopYKienDto.setEmail(dongGopYKien.getEmail());
                dongGopYKienDto.setDiaChi(dongGopYKien.getDiaChi());
                dongGopYKienDto.setTieuDe(dongGopYKien.getTieuDe());
                dongGopYKienDto.setNoiDung(dongGopYKien.getNoiDung());
                dongGopYKienDto.setDaTraLoi(dongGopYKien.getDaTraLoi());

                if (dongGopYKien.getFlag()) {
                    dongGopYKienDtoList.add(dongGopYKienDto);
                }
            }
            result.put("result", dongGopYKienDtoList);
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
            DongGopYKien dongGopYKien = dongGopYKienRepository.findById(listIds[i]).orElse(null);
            dongGopYKien.setFlag(false);
            dongGopYKienRepository.save(dongGopYKien);
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
            List<DongGopYKien> listIdDongGopYKien = new ArrayList<>();
            for (Long id : listIds) {
                Optional<DongGopYKien> dgykOptional = dongGopYKienRepository.findById(id);
                if (dgykOptional.isPresent()) {
                    listIdDongGopYKien.add(dgykOptional.get());
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
                mapResult.put("pagination", new PaginationDto(page, pageSize, dongGopYKienDao.countDGYK(searchString)));
            }

            List<DongGopYKien> dongGopYKienList = dongGopYKienDao.getListdgyk(searchString, pageable, sortData);
            List<DongGopYKienDto> dongGopYKienDtos = new ArrayList<DongGopYKienDto>();
            for (DongGopYKien dongGopYKien : dongGopYKienList) {
                DongGopYKienDto dongGopYKienDto = new DongGopYKienDto();
                dongGopYKienDto.setId(dongGopYKien.getId());
                dongGopYKienDto.setTen(dongGopYKien.getTen());
                dongGopYKienDto.setEmail(dongGopYKien.getEmail());
                dongGopYKienDto.setSdt(dongGopYKien.getSdt());
                dongGopYKienDto.setDiaChi(dongGopYKien.getDiaChi());
                dongGopYKienDto.setTieuDe(dongGopYKien.getTieuDe());
                dongGopYKienDto.setNoiDung(dongGopYKien.getNoiDung());
                dongGopYKienDto.setDaTraLoi(dongGopYKien.getDaTraLoi());

                dongGopYKienDtos.add(dongGopYKienDto);
            }
            mapResult.put("result", dongGopYKienDtos);
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
    public Map<String, Object> sendMail(Long id,String cauTraLoi ) throws MessagingException {
        Map<String, Object> mapResult = new HashMap<>();
        try {
            DongGopYKien dongGopYKien  = dongGopYKienRepository.findById(id).orElse(null);
            mailController.sendMailDongGopYKien(dongGopYKien.getEmail(), dongGopYKien.getTieuDe(), cauTraLoi, dongGopYKien.getTen());
            dongGopYKien.setDaTraLoi(true);
            dongGopYKien.setNoiDung(cauTraLoi);
            dongGopYKienRepository.save(dongGopYKien);
            mapResult.put("msg",Const.GUI_MAI_THANH_CONG);
        }catch (Exception e){
            mapResult.put("msg",Const.GUI_MAI_THAT_BAI);

        }
        return mapResult;
    }
}
