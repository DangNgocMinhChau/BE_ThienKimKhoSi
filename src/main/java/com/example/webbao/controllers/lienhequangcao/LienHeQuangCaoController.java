package com.example.webbao.controllers.lienhequangcao;

import com.example.webbao.models.danhmuc.thanhmenu.ThanhMenuDto;
import com.example.webbao.models.lienhequangcao.LienHeQuangCaoDto;
import com.example.webbao.services.danhmuc.thanhMenu.ThanhMenuService;
import com.example.webbao.services.lienhequangcao.LienHeQuangCaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlylienhequangcao")
public class LienHeQuangCaoController {

    @Autowired
    private LienHeQuangCaoService lienHeQuangCaoService;

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return lienHeQuangCaoService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody LienHeQuangCaoDto lienHeQuangCaoDto) {
        return lienHeQuangCaoService.create(lienHeQuangCaoDto);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody LienHeQuangCaoDto lienHeQuangCaoDto) {
        return lienHeQuangCaoService.update(id, lienHeQuangCaoDto);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return lienHeQuangCaoService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return lienHeQuangCaoService.fetchById(id);
    }


    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return lienHeQuangCaoService.findAll(searchString,pageSize,page,sortData);
    }
}
