package com.example.webbao.services.quanlytaikhoan;


import com.example.webbao.common.PaginationDto;
import com.example.webbao.models.danhmuc.quyen.Quyen;
import com.example.webbao.models.quanlycmnd.QuanLyCMND;
import com.example.webbao.models.quanlytaikhoan.QuanLyTaiKhoan;
import com.example.webbao.models.quanlytaikhoan.QuanLyTaiKhoanDTO;
import com.example.webbao.repositorys.quanlycmnd.QuanLyCmndRepository;
import com.example.webbao.repositorys.quanlytaikhoan.QuanLyTaiKhoanRepository;
import com.example.webbao.repositorys.danhmuc.quyen.QuyenRepository;
import com.example.webbao.services.danhmuc.quyen.QuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuanLyTaiKhoanServiceImpl implements QuanLyTaiKhoanService {

    @Autowired
    QuanLyTaiKhoanRepository quanLyTaiKhoanRepository;

    @Autowired
    QuyenRepository quyenRepository;

    @Autowired
    QuyenService quyenService;

    @Autowired
    QuanLyTaiKhoanDao quanLyTaiKhoanDao;

    @Autowired
    QuanLyCmndRepository quanLyCmndRepository;


    @Override
    public Map<String, Object> create(QuanLyTaiKhoanDTO quanLyTaiKhoanDTO) {
        Map<String, Object> result = new HashMap<>();
        QuanLyTaiKhoanDTO resultUpdate = new QuanLyTaiKhoanDTO();

        try {
            QuanLyTaiKhoan quanLyTaiKhoan = new QuanLyTaiKhoan();
            quanLyTaiKhoan.setTenNguoiDung(quanLyTaiKhoanDTO.getTenNguoiDung());
            quanLyTaiKhoan.setTenDangNhap(quanLyTaiKhoanDTO.getTenDangNhap());
            quanLyTaiKhoan.setMatKhau(quanLyTaiKhoanDTO.getMatKhau());
            quanLyTaiKhoan.setXacNhanMatKhau(quanLyTaiKhoanDTO.getXacNhanMatKhau());
            quanLyTaiKhoan.setMatKhauGoc(quanLyTaiKhoanDTO.getMatKhauGoc());
            quanLyTaiKhoan.setNgaySinh(quanLyTaiKhoanDTO.getNgaySinh());
            quanLyTaiKhoan.setGioiTinh(quanLyTaiKhoanDTO.getGioiTinh());
            quanLyTaiKhoan.setFacebook(quanLyTaiKhoanDTO.getFacebook());
            quanLyTaiKhoan.setSoDienThoai(quanLyTaiKhoanDTO.getSoDienThoai());
            quanLyTaiKhoan.setCmnd(quanLyTaiKhoanDTO.getCmnd());
            quanLyTaiKhoan.setFlag(quanLyTaiKhoanDTO.getFlag());
            quanLyTaiKhoan.setLockUser(false);
            quanLyTaiKhoan.setImg(quanLyTaiKhoanDTO.getImg());
            quanLyTaiKhoan.setFlag(true);
            quanLyTaiKhoan.setNgayTaoBanGhi(quanLyTaiKhoanDTO.getNgayTaoBanGhi());
            quanLyTaiKhoan.setNgayChinhSua(quanLyTaiKhoanDTO.getNgayChinhSua());
            if(quanLyTaiKhoanDTO.getQuyenId() != null){
                quanLyTaiKhoan.setQuyen(quyenRepository.getById(quanLyTaiKhoanDTO.getQuyenId()));
            }else{
                for (Quyen quyen : quyenRepository.findAll()) {
                    if (quyen.getMa().equals("USER")) {
                        quanLyTaiKhoan.setQuyen(quyenRepository.getById(quyen.getId()));
                    }
                }
            }

            QuanLyTaiKhoan taiKhoan = quanLyTaiKhoanRepository.getAccoutByTenDangNhap(quanLyTaiKhoanDTO.getTenDangNhap());
            if (taiKhoan != null && taiKhoan.getTenDangNhap().equals(quanLyTaiKhoanDTO.getTenDangNhap())) {
                result.put("msg", "Tài khoản đã tồn tại!");
                result.put("status", false);
            } else {
                quanLyTaiKhoanRepository.save(quanLyTaiKhoan);

                QuanLyCMND quanLyCMND = new QuanLyCMND();
                quanLyCMND.setCmnd(quanLyTaiKhoanDTO.getCmnd());
                quanLyCMND.setNgayTaoBanGhi(quanLyTaiKhoanDTO.getNgayTaoBanGhi());
                quanLyCMND.setFlag(true);
                quanLyCMND.setIdUser(quanLyTaiKhoan.getId());
                quanLyCmndRepository.save(quanLyCMND);

                resultUpdate.setId(quanLyTaiKhoan.getId());
                resultUpdate.setTenNguoiDung(quanLyTaiKhoanDTO.getTenNguoiDung());
                resultUpdate.setTenDangNhap(quanLyTaiKhoanDTO.getTenDangNhap());
                resultUpdate.setNgaySinh(quanLyTaiKhoanDTO.getNgaySinh());
                resultUpdate.setGioiTinh(quanLyTaiKhoanDTO.getGioiTinh());
                resultUpdate.setFacebook(quanLyTaiKhoanDTO.getFacebook());
                resultUpdate.setSoDienThoai(quanLyTaiKhoanDTO.getSoDienThoai());
                resultUpdate.setCmnd(quanLyTaiKhoanDTO.getCmnd());
                resultUpdate.setLockUser(quanLyTaiKhoanDTO.getLockUser());
                resultUpdate.setImg(quanLyTaiKhoanDTO.getImg());
                resultUpdate.setNgayTaoBanGhi(quanLyTaiKhoanDTO.getNgayTaoBanGhi());
                resultUpdate.setNgayChinhSua(quanLyTaiKhoanDTO.getNgayChinhSua());
                resultUpdate.setFlag(quanLyTaiKhoanDTO.getFlag());

                resultUpdate.setQuyenId(quyenService.findById(quanLyTaiKhoan.getQuyen().getId()).getId());
                resultUpdate.setMaQuyen(quyenService.findById(quanLyTaiKhoan.getQuyen().getId()).getMa());
                resultUpdate.setTenQuyen(quyenService.findById(quanLyTaiKhoan.getQuyen().getId()).getTen());

                result.put("result", resultUpdate);
                result.put("msg", "Tạo tài khoản thành công!");
                result.put("status", true);
            }
        } catch (Exception e) {
            result.put("msg", "Tạo tài khoản thành công!");
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> update(Long id, QuanLyTaiKhoanDTO quanLyTaiKhoanDTO) {
        Map<String, Object> result = new HashMap<>();
        QuanLyTaiKhoanDTO resultUpdate = new QuanLyTaiKhoanDTO();
        try {
            QuanLyTaiKhoan object = quanLyTaiKhoanRepository.findById(id).get();

            object.setId(quanLyTaiKhoanDTO.getId() != null ? quanLyTaiKhoanDTO.getId() : object.getId());
            object.setTenNguoiDung(quanLyTaiKhoanDTO.getTenNguoiDung() != null ? quanLyTaiKhoanDTO.getTenNguoiDung() : object.getTenNguoiDung());
            object.setTenDangNhap(quanLyTaiKhoanDTO.getTenDangNhap() != null ? quanLyTaiKhoanDTO.getTenDangNhap() : object.getTenDangNhap());
            object.setMatKhau(quanLyTaiKhoanDTO.getMatKhau() != null ? quanLyTaiKhoanDTO.getMatKhau() : object.getMatKhau());
            object.setXacNhanMatKhau(quanLyTaiKhoanDTO.getXacNhanMatKhau() != null ? quanLyTaiKhoanDTO.getXacNhanMatKhau() : object.getXacNhanMatKhau());
            object.setMatKhauGoc(quanLyTaiKhoanDTO.getMatKhauGoc() != null ? quanLyTaiKhoanDTO.getMatKhauGoc() : object.getMatKhauGoc());
            object.setNgaySinh(quanLyTaiKhoanDTO.getNgaySinh() != null ? quanLyTaiKhoanDTO.getNgaySinh() : object.getNgaySinh());
            object.setGioiTinh(quanLyTaiKhoanDTO.getGioiTinh() != null ? quanLyTaiKhoanDTO.getGioiTinh() : object.getGioiTinh());
            object.setFacebook(quanLyTaiKhoanDTO.getFacebook() != null ? quanLyTaiKhoanDTO.getFacebook() : object.getFacebook());
            object.setSoDienThoai(quanLyTaiKhoanDTO.getSoDienThoai() != null ? quanLyTaiKhoanDTO.getSoDienThoai() : object.getSoDienThoai());
            object.setCmnd(quanLyTaiKhoanDTO.getCmnd() != null ? quanLyTaiKhoanDTO.getCmnd() : object.getCmnd());
            object.setFlag(quanLyTaiKhoanDTO.getFlag() != null ? quanLyTaiKhoanDTO.getFlag() : object.getFlag());
            object.setLockUser(quanLyTaiKhoanDTO.getLockUser() != null ? quanLyTaiKhoanDTO.getLockUser() : object.getLockUser());
            object.setImg(quanLyTaiKhoanDTO.getImg() != null ? quanLyTaiKhoanDTO.getImg() : object.getImg());
            object.setNgayTaoBanGhi(quanLyTaiKhoanDTO.getNgayTaoBanGhi() != null ? quanLyTaiKhoanDTO.getNgayTaoBanGhi() : object.getNgayTaoBanGhi());
            object.setNgayChinhSua(quanLyTaiKhoanDTO.getNgayChinhSua() != null ? quanLyTaiKhoanDTO.getNgayChinhSua() : object.getNgayChinhSua());

            object.setQuyen(quanLyTaiKhoanDTO.getQuyenId() != null ? quyenRepository.getById(quanLyTaiKhoanDTO.getQuyenId()) : quyenRepository.getById(object.getQuyen().getId()));


            resultUpdate.setId(id);
            resultUpdate.setTenNguoiDung(quanLyTaiKhoanDTO.getTenNguoiDung());
            resultUpdate.setTenDangNhap(quanLyTaiKhoanDTO.getTenDangNhap());
            resultUpdate.setNgaySinh(quanLyTaiKhoanDTO.getNgaySinh());
            resultUpdate.setGioiTinh(quanLyTaiKhoanDTO.getGioiTinh());
            resultUpdate.setFacebook(quanLyTaiKhoanDTO.getFacebook());
            resultUpdate.setSoDienThoai(quanLyTaiKhoanDTO.getSoDienThoai());
            resultUpdate.setCmnd(quanLyTaiKhoanDTO.getCmnd());
            resultUpdate.setFlag(quanLyTaiKhoanDTO.getFlag());
            resultUpdate.setLockUser(quanLyTaiKhoanDTO.getLockUser());
            resultUpdate.setImg(quanLyTaiKhoanDTO.getImg());
            resultUpdate.setNgayTaoBanGhi(quanLyTaiKhoanDTO.getNgayTaoBanGhi());
            resultUpdate.setNgayChinhSua(quanLyTaiKhoanDTO.getNgayChinhSua());
            resultUpdate.setQuyenId(quyenService.findById(object.getQuyen().getId()).getId());
            resultUpdate.setMaQuyen(quyenService.findById(object.getQuyen().getId()).getMa());
            resultUpdate.setTenQuyen(quyenService.findById(object.getQuyen().getId()).getTen());

            quanLyTaiKhoanRepository.save(object);
            result.put("result", resultUpdate);
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
        QuanLyTaiKhoan quanLyTaiKhoan = quanLyTaiKhoanRepository.findById(id).orElse(null);
        QuanLyTaiKhoanDTO quanLyTaiKhoanDTO = new QuanLyTaiKhoanDTO();
        try {
            if (quanLyTaiKhoan != null) {
                quanLyTaiKhoanDTO.setId(quanLyTaiKhoan.getId());
                quanLyTaiKhoanDTO.setTenDangNhap(quanLyTaiKhoan.getTenDangNhap());
                quanLyTaiKhoanDTO.setTenNguoiDung(quanLyTaiKhoan.getTenNguoiDung());
                quanLyTaiKhoanDTO.setMatKhau(quanLyTaiKhoan.getMatKhau());
                quanLyTaiKhoanDTO.setXacNhanMatKhau(quanLyTaiKhoan.getXacNhanMatKhau());
                quanLyTaiKhoanDTO.setMatKhauGoc(quanLyTaiKhoan.getMatKhauGoc());
                quanLyTaiKhoanDTO.setNgaySinh(quanLyTaiKhoan.getNgaySinh());
                quanLyTaiKhoanDTO.setGioiTinh(quanLyTaiKhoan.getGioiTinh());
                quanLyTaiKhoanDTO.setFacebook(quanLyTaiKhoan.getFacebook());
                quanLyTaiKhoanDTO.setSoDienThoai(quanLyTaiKhoan.getSoDienThoai());
                quanLyTaiKhoanDTO.setCmnd(quanLyTaiKhoan.getCmnd());
                quanLyTaiKhoanDTO.setImg(quanLyTaiKhoan.getImg());
                quanLyTaiKhoanDTO.setQuyenId(quyenService.findById(quanLyTaiKhoan.getQuyen().getId()).getId());
                quanLyTaiKhoanDTO.setMaQuyen(quyenService.findById(quanLyTaiKhoan.getQuyen().getId()).getMa());
                quanLyTaiKhoanDTO.setTenQuyen(quyenService.findById(quanLyTaiKhoan.getQuyen().getId()).getTen());
                quanLyTaiKhoanDTO.setNgayTaoBanGhi(quanLyTaiKhoan.getNgayTaoBanGhi());
                quanLyTaiKhoanDTO.setNgayChinhSua(quanLyTaiKhoan.getNgayChinhSua());
                quanLyTaiKhoanDTO.setFlag(quanLyTaiKhoan.getFlag());
                quanLyTaiKhoanDTO.setLockUser(quanLyTaiKhoan.getLockUser());
                quanLyTaiKhoanDTO.setDangNhapThanhCong(true);
                result.put("result", quanLyTaiKhoanDTO);
                result.put("status", true);
            } else {
                result.put("result", null);
                result.put("status", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("result", null);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAllTaiKhoan() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<QuanLyTaiKhoan> quanLyTaiKhoanList = quanLyTaiKhoanRepository.findAll();
            List<QuanLyTaiKhoanDTO> quanLyTaiKhoanDTOs = new ArrayList<>();
            for (QuanLyTaiKhoan quanLyTaiKhoan : quanLyTaiKhoanList) {
                QuanLyTaiKhoanDTO quanLyTaiKhoanDTO = new QuanLyTaiKhoanDTO();
                quanLyTaiKhoanDTO.setId(quanLyTaiKhoan.getId());
                quanLyTaiKhoanDTO.setTenDangNhap(quanLyTaiKhoan.getTenDangNhap());
                quanLyTaiKhoanDTO.setTenNguoiDung(quanLyTaiKhoan.getTenNguoiDung());
                quanLyTaiKhoanDTO.setMatKhau(quanLyTaiKhoan.getMatKhau());
                quanLyTaiKhoanDTO.setXacNhanMatKhau(quanLyTaiKhoan.getXacNhanMatKhau());
                quanLyTaiKhoanDTO.setMatKhauGoc(quanLyTaiKhoan.getMatKhauGoc());
                quanLyTaiKhoanDTO.setNgaySinh(quanLyTaiKhoan.getNgaySinh());
                quanLyTaiKhoanDTO.setGioiTinh(quanLyTaiKhoan.getGioiTinh());
                quanLyTaiKhoanDTO.setFacebook(quanLyTaiKhoan.getFacebook());
                quanLyTaiKhoanDTO.setSoDienThoai(quanLyTaiKhoan.getSoDienThoai());
                quanLyTaiKhoanDTO.setCmnd(quanLyTaiKhoan.getCmnd());
                quanLyTaiKhoanDTO.setFlag(quanLyTaiKhoan.getFlag());
                quanLyTaiKhoanDTO.setLockUser(quanLyTaiKhoan.getLockUser());
                quanLyTaiKhoanDTO.setImg(quanLyTaiKhoan.getImg());
                quanLyTaiKhoanDTO.setNgayTaoBanGhi(quanLyTaiKhoan.getNgayTaoBanGhi());
                quanLyTaiKhoanDTO.setNgayChinhSua(quanLyTaiKhoan.getNgayChinhSua());
                quanLyTaiKhoanDTO.setMaQuyen(quyenService.findById(quanLyTaiKhoan.getQuyen().getId()).getMa());
                quanLyTaiKhoanDTO.setTenQuyen(quyenService.findById(quanLyTaiKhoan.getQuyen().getId()).getTen());
                quanLyTaiKhoanDTO.setQuyenId(quyenService.findById(quanLyTaiKhoan.getQuyen().getId()).getId());
                if (quanLyTaiKhoan.getFlag()) {
                    quanLyTaiKhoanDTOs.add(quanLyTaiKhoanDTO);
                }
            }
            result.put("result", quanLyTaiKhoanDTOs);
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
        try {
            for (int i = 0; i < listIds.length; i++) {
                QuanLyTaiKhoan quanLyTaiKhoan = quanLyTaiKhoanRepository.findById(listIds[i]).orElse(null);
                if (quanLyTaiKhoan.getTenDangNhap().equals("admin@gmail.com")) {
                    result.put("msg", "Không được quyền xóa tài khoản này !");
                    result.put("status", false);
                } else {
                    quanLyTaiKhoan.setFlag(false);
                    quanLyTaiKhoanRepository.save(quanLyTaiKhoan);
                    result.put("listId", listIds);
                    result.put("msg", "Xoá thành công !");
                    result.put("status", true);
                }

            }
        } catch (Exception e) {
            result.put("msg", "Xoá thất bại !");
            result.put("status", false);
        }

        return result;
    }

    @Override
    public QuanLyTaiKhoan findById(Long id) {
        return quanLyTaiKhoanRepository.findById(id).orElse(null);
    }

    @Override
    public Map<String, Object> loginUser(String account, String password) {
        Map<String, Object> result = new HashMap<>();
        QuanLyTaiKhoan quanLyTaiKhoan = quanLyTaiKhoanRepository.loginUser(account, password);
        QuanLyTaiKhoanDTO quanLyTaiKhoanDTO = new QuanLyTaiKhoanDTO();
        try {
            if (quanLyTaiKhoan != null) {
                quanLyTaiKhoanDTO.setId(quanLyTaiKhoan.getId());
                quanLyTaiKhoanDTO.setTenDangNhap(quanLyTaiKhoan.getTenDangNhap());
                quanLyTaiKhoanDTO.setTenNguoiDung(quanLyTaiKhoan.getTenNguoiDung());
                quanLyTaiKhoanDTO.setXacNhanMatKhau(quanLyTaiKhoan.getXacNhanMatKhau());
                quanLyTaiKhoanDTO.setNgaySinh(quanLyTaiKhoan.getNgaySinh());
                quanLyTaiKhoanDTO.setGioiTinh(quanLyTaiKhoan.getGioiTinh());
                quanLyTaiKhoanDTO.setFacebook(quanLyTaiKhoan.getFacebook());
                quanLyTaiKhoanDTO.setSoDienThoai(quanLyTaiKhoan.getSoDienThoai());
                quanLyTaiKhoanDTO.setCmnd(quanLyTaiKhoan.getCmnd());
                quanLyTaiKhoanDTO.setImg(quanLyTaiKhoan.getImg());
                quanLyTaiKhoanDTO.setQuyenId(quyenService.findById(quanLyTaiKhoan.getQuyen().getId()).getId());
                quanLyTaiKhoanDTO.setMaQuyen(quyenService.findById(quanLyTaiKhoan.getQuyen().getId()).getMa());
                quanLyTaiKhoanDTO.setTenQuyen(quyenService.findById(quanLyTaiKhoan.getQuyen().getId()).getTen());
                quanLyTaiKhoanDTO.setNgayTaoBanGhi(quanLyTaiKhoan.getNgayTaoBanGhi());
                quanLyTaiKhoanDTO.setNgayChinhSua(quanLyTaiKhoan.getNgayChinhSua());
                quanLyTaiKhoanDTO.setFlag(quanLyTaiKhoan.getFlag());
                quanLyTaiKhoanDTO.setLockUser(quanLyTaiKhoan.getLockUser());
                quanLyTaiKhoanDTO.setDangNhapThanhCong(true);

                result.put("result", quanLyTaiKhoanDTO);
                result.put("status", true);
            } else {
                QuanLyTaiKhoan taiKhoanDangNhapSai = new QuanLyTaiKhoan();
                quanLyTaiKhoanDTO.setDangNhapThanhCong(false);
                quanLyTaiKhoanDTO.setTenDangNhap(account);
                result.put("result", quanLyTaiKhoanDTO);
                result.put("status", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("result", null);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> resetPass(String account, String cmnd, String sdt) {
        Map<String, Object> result = new HashMap<>();
        QuanLyTaiKhoan quanLyTaiKhoan = quanLyTaiKhoanRepository.resetPass(account, cmnd, sdt);
        QuanLyTaiKhoanDTO quanLyTaiKhoanDTO = new QuanLyTaiKhoanDTO();
        try {
            if (quanLyTaiKhoan != null) {
                quanLyTaiKhoanDTO.setMatKhauGoc(quanLyTaiKhoan.getMatKhauGoc());
                result.put("result", quanLyTaiKhoanDTO);
                result.put("status", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("result", null);
            result.put("status", false);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAccoutByTenDangNhap(String account) {
        Map<String, Object> result = new HashMap<>();
        QuanLyTaiKhoan quanLyTaiKhoan = quanLyTaiKhoanRepository.getAccoutByTenDangNhap(account);
        try {
            if (quanLyTaiKhoan != null) {
                result.put("result", true);
            } else {
                result.put("result", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.put("result", null);
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
                mapResult.put("pagination", new PaginationDto(page, pageSize, quanLyTaiKhoanDao.countTaiKhoan(searchString)));
            }

            List<QuanLyTaiKhoan> quanLyTaiKhoanList = quanLyTaiKhoanDao.getListTaiKhoan(searchString, pageable, sortData);
            List<QuanLyTaiKhoanDTO> quanLyTaiKhoanDTOS = new ArrayList<QuanLyTaiKhoanDTO>();
            for (QuanLyTaiKhoan quanLyTaiKhoan : quanLyTaiKhoanList) {
                QuanLyTaiKhoanDTO quanLyTaiKhoanDTO = new QuanLyTaiKhoanDTO();
                quanLyTaiKhoanDTO.setId(quanLyTaiKhoan.getId());
                quanLyTaiKhoanDTO.setTenNguoiDung(quanLyTaiKhoan.getTenNguoiDung());
                quanLyTaiKhoanDTO.setTenDangNhap(quanLyTaiKhoan.getTenDangNhap());
                quanLyTaiKhoanDTO.setMatKhau(quanLyTaiKhoan.getMatKhau());
                quanLyTaiKhoanDTO.setXacNhanMatKhau(quanLyTaiKhoan.getXacNhanMatKhau());
                quanLyTaiKhoanDTO.setMatKhauGoc(quanLyTaiKhoan.getMatKhauGoc());
                quanLyTaiKhoanDTO.setNgaySinh(quanLyTaiKhoan.getNgaySinh());
                quanLyTaiKhoanDTO.setGioiTinh(quanLyTaiKhoan.getGioiTinh());
                quanLyTaiKhoanDTO.setFacebook(quanLyTaiKhoan.getFacebook());
                quanLyTaiKhoanDTO.setSoDienThoai(quanLyTaiKhoan.getSoDienThoai());
                quanLyTaiKhoanDTO.setCmnd(quanLyTaiKhoan.getCmnd());
                quanLyTaiKhoanDTO.setImg(quanLyTaiKhoan.getImg());
                quanLyTaiKhoanDTO.setLockUser(quanLyTaiKhoan.getLockUser());
                quanLyTaiKhoanDTO.setSoLanDangNhapSai(quanLyTaiKhoan.getSoLanDangNhapSai());
                quanLyTaiKhoanDTO.setQuyenId(quanLyTaiKhoan.getQuyen().getId());
                quanLyTaiKhoanDTO.setMaQuyen(quanLyTaiKhoan.getQuyen().getMa());
                quanLyTaiKhoanDTO.setTenQuyen(quanLyTaiKhoan.getQuyen().getTen());
                quanLyTaiKhoanDTOS.add(quanLyTaiKhoanDTO);
            }
            mapResult.put("result", quanLyTaiKhoanDTOS);
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
