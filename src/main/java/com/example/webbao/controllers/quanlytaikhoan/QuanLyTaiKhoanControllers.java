package com.example.webbao.controllers.quanlytaikhoan;

import com.example.webbao.models.quanlytaikhoan.QuanLyTaiKhoanDTO;
import com.example.webbao.services.quanlytaikhoan.QuanLyTaiKhoanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlytaikhoan")
public class QuanLyTaiKhoanControllers {

    @Autowired
    private QuanLyTaiKhoanServiceImpl quanLyTaiKhoanService;

    @PostMapping()
    public Map<String, Object> create(@RequestBody QuanLyTaiKhoanDTO quanLyTaiKhoanDTO) {
        return quanLyTaiKhoanService.create(quanLyTaiKhoanDTO);
    }

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return quanLyTaiKhoanService.getAllTaiKhoan();
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return quanLyTaiKhoanService.delete(ids);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody QuanLyTaiKhoanDTO quanLyTaiKhoanDTO) {
        return quanLyTaiKhoanService.update(id, quanLyTaiKhoanDTO);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getQuanLyTaiKhoanById(@PathVariable Long id) {
        return quanLyTaiKhoanService.fetchById(id);
    }

    @GetMapping(value = "login")
    public Map<String, Object> loginUser(@RequestParam String account, String password) {
        return quanLyTaiKhoanService.loginUser(account, password);
    }

    @GetMapping(value = "resetpass")
    public Map<String, Object> resetPass(@RequestParam String account, String cmnd,String sdt) {
        return quanLyTaiKhoanService.resetPass(account, cmnd ,sdt);
    }

    @GetMapping(value = "findAccountByUser")
    public Map<String, Object> getAccoutByTenDangNhap(@RequestParam String account) {
        return quanLyTaiKhoanService.getAccoutByTenDangNhap(account);
    }

    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return quanLyTaiKhoanService.findAll(searchString,pageSize,page,sortData);
    }
}
