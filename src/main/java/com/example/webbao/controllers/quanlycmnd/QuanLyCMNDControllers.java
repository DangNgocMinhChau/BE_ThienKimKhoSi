package com.example.webbao.controllers.quanlycmnd;

import com.example.webbao.models.quanlycmnd.QuanLyCMND;
import com.example.webbao.services.quanlycmnd.QuanLyCmndService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlycmnd")
public class QuanLyCMNDControllers {

    @Autowired
    private QuanLyCmndService quanLyCmndService;

    @PostMapping()
    public Map<String, Object> create(@RequestBody QuanLyCMND quanLyCMND) {
        return quanLyCmndService.create(quanLyCMND);
    }

    @GetMapping()
    public Map<String, Object> getDanhSachThuoc() {
        return quanLyCmndService.getAllCMND();
    }

//    @DeleteMapping()
//    public Map<String,Object> delete (@RequestBody Long[] ids) {
//           return quanLyCmndService.delete(ids);
//    }

    @DeleteMapping(value = "/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        return quanLyCmndService.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody QuanLyCMND quanLyCMND) {
        return quanLyCmndService.update(id, quanLyCMND);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getById(@PathVariable Long id) {
        return quanLyCmndService.fetchById(id);
    }
}
