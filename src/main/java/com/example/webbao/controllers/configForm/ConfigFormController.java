package com.example.webbao.controllers.configForm;

import com.example.webbao.models.configForm.ConfigFormDto;
import com.example.webbao.services.configForm.ConfigFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/configform")
public class ConfigFormController {

    @Autowired
    private ConfigFormService configFormService;


    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return configFormService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody ConfigFormDto configFormDto) {
        return configFormService.create(configFormDto);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody ConfigFormDto configFormDto) {
        return configFormService.update(id, configFormDto);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return configFormService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return configFormService.fetchById(id);
    }


    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return configFormService.findAll(searchString,pageSize,page,sortData);
    }
}
