package com.example.webbao.services.danhmuc.manager_banner;

import com.example.webbao.common.PaginationDto;
import com.example.webbao.models.danhmuc.manage_banner.Banner;
import com.example.webbao.models.danhmuc.manage_banner.BannerDto;

import com.example.webbao.repositorys.danhmuc.manager_banner.BannerRepository;
import com.example.webbao.repositorys.quanlytaikhoan.QuanLyTaiKhoanRepository;
import com.example.webbao.utils.mail.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerRepository bannerRepository;

    @Override
    public Banner findById(Long bannerid) {
        return bannerRepository.findById(bannerid).orElse(null);
    }

    @Autowired
    private BannerDao bannerDao;

    @Autowired
    private QuanLyTaiKhoanRepository quanLyTaiKhoanRepository;

    @Override
    public Map<String, Object> create(BannerDto bannerDto) {
        Map<String, Object> result = new HashMap<>();
        BannerDto resultCreate = new BannerDto();
        try {
            Banner banner = new Banner();
            banner.setWidth(bannerDto.getWidth());
            banner.setHeight(bannerDto.getHeight());
            banner.setSrc(bannerDto.getSrc());
            banner.setTag(bannerDto.getTag());
            banner.setBannerNoiBat(bannerDto.getBannerNoiBat());
            banner.setNguoiTaoId(bannerDto.getNguoiTaoId());
            banner.setStt(bannerDto.getStt());
            banner.setThuocNhom(bannerDto.getThuocNhom());
            banner.setNgayTaoBanGhi(bannerDto.getNgayTaoBanGhi());
            banner.setFlag(true);
            bannerRepository.save(banner);

            resultCreate.setId(banner.getId());
            resultCreate.setHeight(banner.getHeight());
            resultCreate.setWidth(banner.getWidth());
            resultCreate.setSrc(banner.getSrc());
            resultCreate.setTag(banner.getTag());
            resultCreate.setStt(banner.getStt());
            resultCreate.setThuocNhom(banner.getThuocNhom());
            resultCreate.setBannerNoiBat(banner.getBannerNoiBat());
            resultCreate.setNguoiTaoId(banner.getNguoiTaoId());
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
    public Map<String, Object> update(Long id, BannerDto bannerDto) {
        Map<String, Object> result = new HashMap<>();
        try {
            Banner object = bannerRepository.findById(id).get();
            object.setId(bannerDto.getId() != null ? bannerDto.getId() : object.getId());
            object.setSrc(bannerDto.getSrc() != null ? bannerDto.getSrc() : object.getSrc());
            object.setHeight(bannerDto.getHeight() != null ? bannerDto.getHeight() : object.getHeight());
            object.setWidth(bannerDto.getWidth() != null ? bannerDto.getWidth() : object.getWidth());
            object.setTag(bannerDto.getTag() != null ? bannerDto.getTag() : object.getTag());
            object.setStt(bannerDto.getStt() != null ? bannerDto.getStt() : object.getStt());
            object.setThuocNhom(bannerDto.getThuocNhom() != null ? bannerDto.getThuocNhom() : object.getThuocNhom());
            object.setBannerNoiBat(bannerDto.getBannerNoiBat() != null ? bannerDto.getBannerNoiBat() : object.getBannerNoiBat());
            object.setNguoiTaoId(bannerDto.getNguoiTaoId() != null ? bannerDto.getNguoiTaoId() : object.getNguoiTaoId());
            object.setNgayChinhSua(bannerDto.getNgayChinhSua());

            bannerRepository.save(object);

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
        Banner banner = bannerRepository.findById(id).orElse(null);
        BannerDto bannerDto = new BannerDto();
        try {
            if (banner != null) {
                bannerDto.setId(banner.getId());
                bannerDto.setSrc(banner.getSrc());
                bannerDto.setWidth(banner.getWidth());
                bannerDto.setHeight(banner.getHeight());
                bannerDto.setThuocNhom(banner.getThuocNhom());
                bannerDto.setTag(banner.getTag());
                bannerDto.setStt(banner.getStt());
                bannerDto.setBannerNoiBat(banner.getBannerNoiBat());

                bannerDto.setNgayTaoBanGhi(banner.getNgayTaoBanGhi());
                bannerDto.setNguoiTaoId(banner.getNguoiTaoId());
                bannerDto.setTenNguoiTao(quanLyTaiKhoanRepository.findById(banner.getNguoiTaoId()).get().getTenNguoiDung());

                result.put("result", bannerDto);
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
            List<Banner> bannerList = bannerRepository.findAll();
            List<BannerDto> bannerDtoArrayList = new ArrayList<>();
            for (Banner banner : bannerList) {
                BannerDto bannerDto = new BannerDto();
                bannerDto.setId(banner.getId());
                bannerDto.setHeight(banner.getHeight());
                bannerDto.setWidth(banner.getWidth());
                bannerDto.setSrc(banner.getSrc());
                bannerDto.setThuocNhom(banner.getThuocNhom());
                bannerDto.setTag(banner.getTag());
                bannerDto.setStt(banner.getStt());
                bannerDto.setBannerNoiBat(banner.getBannerNoiBat());

                bannerDto.setNguoiTaoId(banner.getNguoiTaoId());
                bannerDto.setNgayTaoBanGhi(banner.getNgayTaoBanGhi());
                if (banner.getFlag()) {
                    bannerDtoArrayList.add(bannerDto);
                }
            }
            result.put("result", bannerDtoArrayList);
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
        try {
            for (int i = 0; i < listIds.length; i++) {
                Banner banner = bannerRepository.findById(listIds[i]).orElse(null);
                banner.setFlag(false);
                bannerRepository.save(banner);
                result.put("listId", listIds);
                result.put("msg", Const.XOA_THANH_CONG);
                result.put("status", true);
            }
        } catch (Exception e) {
            result.put("listId", null);
            result.put("msg", Const.XOA_THAT_BAI);
            result.put("status", false);
        }
        return result;
    }


    @Override
    public Map<String, Object> deleteVinhVien(Long[] listIds) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<Banner> listIdQuyen = new ArrayList<>();
            for (Long id : listIds) {
                Optional<Banner> bannerOptional = bannerRepository.findById(id);
                if (bannerOptional.isPresent()) {
                    listIdQuyen.add(bannerOptional.get());
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
                mapResult.put("pagination", new PaginationDto(page, pageSize, bannerDao.countBaiViet(searchString)));
            }
            List<Banner> bnList = bannerDao.getListBanner(searchString, pageable, sortData);
            List<BannerDto> baiVietDtos = new ArrayList<BannerDto>();
            for (Banner banner : bnList) {
                BannerDto bannerDto = new BannerDto();
                bannerDto.setId(banner.getId());
                bannerDto.setSrc(banner.getSrc());
                bannerDto.setWidth(banner.getWidth());
                bannerDto.setThuocNhom(banner.getThuocNhom());
                bannerDto.setHeight(banner.getHeight());
                bannerDto.setTag(banner.getTag());
                bannerDto.setStt(banner.getStt());
                bannerDto.setBannerNoiBat(banner.getBannerNoiBat());
                bannerDto.setNguoiTaoId(banner.getNguoiTaoId());
                bannerDto.setTenNguoiTao(quanLyTaiKhoanRepository.findById(banner.getNguoiTaoId()).get().getTenNguoiDung());
                bannerDto.setNgayTaoBanGhi(banner.getNgayTaoBanGhi());
                baiVietDtos.add(bannerDto);
            }
            mapResult.put("result", baiVietDtos);
            mapResult.put("msg", Const.LAY_DANH_SACH_THANH_CONG);
            mapResult.put("status", true);

        } catch (Exception e) {
            e.printStackTrace();
            mapResult.put("result", null);
            mapResult.put("msg", Const.LAY_DANH_SACH_THAT_BAI);
            mapResult.put("status", false);
        }
        return mapResult;
    }


}
