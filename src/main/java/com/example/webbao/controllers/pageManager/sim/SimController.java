package com.example.webbao.controllers.pageManager.sim;

import com.example.webbao.models.pageManager.menu.MenuCoreDto;
import com.example.webbao.models.pageManager.sim.SimDto;
import com.example.webbao.services.pageManager.menu.MenuCoreService;
import com.example.webbao.services.pageManager.sim.SimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/sim")
public class SimController {

    @Autowired
    private SimService objService;

    @PostMapping()
    public Map<String, Object> create(@RequestBody SimDto objDto) {
        return objService.create(objDto);
    }

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return objService.getAll();
    }
    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody SimDto objDto) {
        return objService.update(id, objDto);
    }

    @GetMapping("/getselectbyid")
    public Map<String, Object> getSelectById() {
        return objService.getSelectById();
    }


    @GetMapping("/getselect")
    public Map<String, Object> getSelect() {
        return objService.getSelect();
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return objService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return objService.fetchById(id);
    }


    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return objService.findAll(searchString,pageSize,page,sortData);
    }

}
