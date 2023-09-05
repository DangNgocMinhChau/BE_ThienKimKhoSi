package com.example.webbao.controllers.danhmuc.tag;

import com.example.webbao.models.danhmuc.tag.TagDto;
import com.example.webbao.services.danhmuc.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlytag")
public class TagController {


    @Autowired
    private TagService tagService;

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return tagService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody TagDto tagDto) {
        return tagService.create(tagDto);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody TagDto tagDto) {
        return tagService.update(id, tagDto);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return tagService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return tagService.fetchById(id);
    }

    @GetMapping("/getAllSelect")
    public Map<String, Object> getAllSelect() {
        return tagService.getAllSelect();
    }

    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return tagService.findAll(searchString,pageSize,page,sortData);
    }
}
