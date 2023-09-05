package com.example.webbao.controllers.danhmuc.quyen;

import com.example.webbao.models.danhmuc.quyen.QuyenDto;
import com.example.webbao.services.danhmuc.quyen.QuyenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlyquyen")
public class QuyenController {

    @Autowired
    private QuyenService quyenService;

    @GetMapping("/find")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Map<String, Object> getAll() {
        return quyenService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody QuyenDto quyenDto) {
        return quyenService.create(quyenDto);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody QuyenDto quyenDto) {
        return quyenService.update(id, quyenDto);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return quyenService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return quyenService.fetchById(id);
    }

    @GetMapping("/getAllSelect")
    public Map<String, Object> getAllSelect() {
        return quyenService.getAllSelect();
    }

    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return quyenService.findAll(searchString,pageSize,page,sortData);
    }
}
