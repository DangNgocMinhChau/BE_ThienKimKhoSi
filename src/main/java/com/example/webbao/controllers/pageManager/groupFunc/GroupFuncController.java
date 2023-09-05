package com.example.webbao.controllers.pageManager.groupFunc;

import com.example.webbao.models.pageManager.groupFunc.GroupFuncDto;
import com.example.webbao.services.pageManager.groupFunc.GroupFuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/groupfunc")
public class GroupFuncController {

    @Autowired
    private GroupFuncService service;

    @PostMapping()
    public Map<String, Object> create(@RequestBody GroupFuncDto itemDto) {
        return service.create(itemDto);
    }

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return service.getAll();
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody GroupFuncDto itemDto) {
        return service.update(id, itemDto);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return service.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return service.fetchById(id);
    }


    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return service.findAll(searchString,pageSize,page,sortData);
    }

}
