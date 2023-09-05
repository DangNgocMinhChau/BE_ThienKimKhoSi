package com.example.webbao.controllers.pageManager.via;

import com.example.webbao.models.pageManager.via.ViasDto;
import com.example.webbao.services.pageManager.via.ViasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/vias")
public class ViasController {

    @Autowired
    private ViasService objService;

    @PostMapping()
    public Map<String, Object> create(@RequestBody ViasDto objDto) {
        return objService.create(objDto);
    }

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return objService.getAll();
    }
    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody ViasDto objDto) {
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
