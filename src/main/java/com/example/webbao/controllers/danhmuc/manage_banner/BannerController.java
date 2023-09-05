package com.example.webbao.controllers.danhmuc.manage_banner;

import com.example.webbao.models.danhmuc.manage_banner.BannerDto;
import com.example.webbao.models.danhmuc.tag.TagDto;
import com.example.webbao.services.danhmuc.manager_banner.BannerService;
import com.example.webbao.services.danhmuc.tag.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlybanner")
public class BannerController {


    @Autowired
    private BannerService bannerService;

    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return bannerService.getAll();
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody BannerDto bannerDto) {
        return bannerService.create(bannerDto);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody BannerDto bannerDto) {
        return bannerService.update(id, bannerDto);
    }

    @DeleteMapping()
    public Map<String, Object> delete(@RequestBody Long[] ids) {
        return bannerService.delete(ids);
    }

    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return bannerService.fetchById(id);
    }



    @GetMapping("/find/page")
    public Map<String, Object> getAllPage( @RequestParam(required = false) String searchString,
                                           @RequestParam(required = false) Integer pageSize,
                                           @RequestParam(required = false) Integer page,
                                           @RequestParam(required = false) String sortData
    ) {
        return bannerService.findAll(searchString,pageSize,page,sortData);
    }
}
