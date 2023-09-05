package com.example.webbao.controllers.configForm;

import com.example.webbao.models.configForm.DataConfigFormDto;
import com.example.webbao.services.configForm.DataConfigFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/dataconfigform")
public class DataConfigFormController {

    @Autowired
    private DataConfigFormService dataConfigFormService;


    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return dataConfigFormService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody DataConfigFormDto dataConfigFormDto) {
        return dataConfigFormService.create(dataConfigFormDto);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody DataConfigFormDto dataConfigFormDto) {
        return dataConfigFormService.update(id, dataConfigFormDto);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return dataConfigFormService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return dataConfigFormService.fetchById(id);
    }


    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return dataConfigFormService.findAll(searchString,pageSize,page,sortData);
    }
}
