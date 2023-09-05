package com.example.webbao.controllers.quanlybaiviet;

import com.example.webbao.models.quanlybaiviet.QuanLyBaiVietDto;
import com.example.webbao.services.quanlybaiviet.QuanLyBaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlybaiviet")
public class QuanLyBaiVietController {

    @Autowired
    private QuanLyBaiVietService quanLyBaiVietService;

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return quanLyBaiVietService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody QuanLyBaiVietDto quanLyBaiVietDto) {
        return quanLyBaiVietService.create(quanLyBaiVietDto);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody QuanLyBaiVietDto quanLyBaiVietDto) {
        return quanLyBaiVietService.update(id, quanLyBaiVietDto);
    }

    @PutMapping(value = "countView/{id}")
    public Map<String, Object> countView(@PathVariable Long id) {
        return quanLyBaiVietService.countView(id);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return quanLyBaiVietService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return quanLyBaiVietService.fetchById(id);
    }

    @GetMapping(value = "/baiviettheotag")
    public Map<String, Object> getTinTucTheoTag(@RequestParam String tag) {
        return quanLyBaiVietService.getTinTucTheoTag(tag);
    }

    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
        @RequestParam(required = false) Integer pageSize,
        @RequestParam(required = false) Integer page,
        @RequestParam(required = false) String sortData
    ) {
       return quanLyBaiVietService.findAll(searchString,pageSize,page,sortData);
    }


}
