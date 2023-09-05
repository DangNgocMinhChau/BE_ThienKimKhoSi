package com.example.webbao.controllers.pageManager.menu;

import com.example.webbao.models.donggopykien.DongGopYKienDto;
import com.example.webbao.models.pageManager.menu.MenuCoreDto;
import com.example.webbao.services.pageManager.menu.MenuCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/menucore")
public class MenuCoreController {

    @Autowired
    private MenuCoreService menuCoreService;

    @PostMapping()
    public Map<String, Object> create(@RequestBody MenuCoreDto menuCoreDto) {
        return menuCoreService.create(menuCoreDto);
    }

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return menuCoreService.getAll();
    }
    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody MenuCoreDto menuCoreDto) {
        return menuCoreService.update(id, menuCoreDto);
    }

    @GetMapping("/getselectbyid")
    public Map<String, Object> getSelectById() {
        return menuCoreService.getSelectById();
    }


    @GetMapping("/getselect")
    public Map<String, Object> getSelect() {
        return menuCoreService.getSelect();
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return menuCoreService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return menuCoreService.fetchById(id);
    }


    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return menuCoreService.findAll(searchString,pageSize,page,sortData);
    }

}
