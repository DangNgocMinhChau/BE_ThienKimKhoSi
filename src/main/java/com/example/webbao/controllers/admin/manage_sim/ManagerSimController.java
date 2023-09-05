package com.example.webbao.controllers.admin.manage_sim;

import com.example.webbao.models.admin.manage_sim.ManageSimDto;
import com.example.webbao.models.danhmuc.menu_manager.MenuManagerDto;
import com.example.webbao.services.admin.manage_sim.ManageSimService;
import com.example.webbao.services.danhmuc.menu_manager.MenuManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/managesim")
public class ManagerSimController {

    @Autowired
    private ManageSimService manageSimService;

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return manageSimService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody ManageSimDto manageSimDto) {
        return manageSimService.create(manageSimDto);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody ManageSimDto menuManagerDto) {
        return manageSimService.update(id, menuManagerDto);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return manageSimService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return manageSimService.fetchById(id);
    }


    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return manageSimService.findAll(searchString,pageSize,page,sortData);
    }
}
