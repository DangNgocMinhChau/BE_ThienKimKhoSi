package com.example.webbao.controllers.danhmuc.url;

import com.example.webbao.models.danhmuc.url.UrlDto;
import com.example.webbao.services.danhmuc.url.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlyurl")
public class UrlController {

    @Autowired
    private UrlService urlService;

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return urlService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody UrlDto urlDto) {
        return urlService.create(urlDto);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody UrlDto urlDto) {
        return urlService.update(id, urlDto);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return urlService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return urlService.fetchById(id);
    }

    @GetMapping("/getAllSelect")
    public Map<String, Object> getAllSelect() {
        return urlService.getAllSelect();
    }

    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return urlService.findAll(searchString,pageSize,page,sortData);
    }
}
