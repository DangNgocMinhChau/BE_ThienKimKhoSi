package com.example.webbao.controllers.danhmuc.menu_manager;

import com.example.webbao.models.danhmuc.menu_manager.MenuManagerDto;
import com.example.webbao.services.danhmuc.menu_manager.MenuManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlymenu")
public class Menu_ManagerController {

    @Autowired
    private MenuManagerService menuManagerService;

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return menuManagerService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody MenuManagerDto menuManagerDto) {
        return menuManagerService.create(menuManagerDto);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody MenuManagerDto menuManagerDto) {
        return menuManagerService.update(id, menuManagerDto);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return menuManagerService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return menuManagerService.fetchById(id);
    }

    @GetMapping("/getAllSelect")
    public Map<String, Object> getAllSelect() {
        return menuManagerService.getAllSelect();
    }

    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return menuManagerService.findAll(searchString,pageSize,page,sortData);
    }
}
