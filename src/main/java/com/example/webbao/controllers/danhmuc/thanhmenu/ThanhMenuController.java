package com.example.webbao.controllers.danhmuc.thanhmenu;

import com.example.webbao.models.danhmuc.thanhmenu.ThanhMenuDto;
import com.example.webbao.services.danhmuc.thanhMenu.ThanhMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlymenutintuc")
public class ThanhMenuController {

    @Autowired
    private ThanhMenuService thanhMenuService;

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return thanhMenuService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody ThanhMenuDto thanhMenuDto) {
        return thanhMenuService.create(thanhMenuDto);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody ThanhMenuDto thanhMenuDto) {
        return thanhMenuService.update(id, thanhMenuDto);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return thanhMenuService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return thanhMenuService.fetchById(id);
    }

    @GetMapping("/getAllSelect")
    public Map<String, Object> getAllSelect() {
        return thanhMenuService.getAllSelect();
    }

    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return thanhMenuService.findAll(searchString,pageSize,page,sortData);
    }
}
