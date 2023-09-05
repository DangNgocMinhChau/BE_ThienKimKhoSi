package com.example.webbao.controllers.tuongtac.thichbaiviet;

import com.example.webbao.models.tuongtac.thichbaiviet.ThichBaiVietDto;
import com.example.webbao.services.tuongtac.thichbaiviet.ThichBaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/thichbaiviet")
public class ThichBaiVietController {

    @Autowired
    private ThichBaiVietService thichBaiVietService;

    @PostMapping()
    public Map<String, Object> create(@RequestBody ThichBaiVietDto thichBaiVietDto) {
        return thichBaiVietService.create(thichBaiVietDto);
    }

    @PutMapping(value = "/{id}")
    public Map<String, Object> update(@PathVariable Long id, @RequestBody ThichBaiVietDto thichBaiVietDto) {
        return thichBaiVietService.update(id, thichBaiVietDto);
    }


    @GetMapping(value = "/{id}")
    public Map<String, Object> getByID(@PathVariable Long id) {
        return thichBaiVietService.fetchById(id);
    }

    @GetMapping(value = "/countThichBaiViet")
    public Map<String, Object> countBaiViet(@RequestParam Long id) {
        return thichBaiVietService.countBaiViet(id);
    }


}
