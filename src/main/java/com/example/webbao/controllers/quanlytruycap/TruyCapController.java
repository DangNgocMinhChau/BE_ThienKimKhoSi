package com.example.webbao.controllers.quanlytruycap;

import com.example.webbao.models.quanlytruycap.TruyCapDto;
import com.example.webbao.services.quanlytruycap.TruyCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/quanlytruycap")
public class TruyCapController {

    @Autowired
    private TruyCapService truyCapService;

    @GetMapping("/find")
    public Map<String, Object> getAll() {
        return truyCapService.getAll();
    }

    @GetMapping("/tongluottruycap")
    public Map<String, Object> getAllViewTruyCap() {
        return truyCapService.tongView();
    }


    @GetMapping("/tongviewtruycaptrongngay")
    public Map<String, Object> getAllViewTrongNgay(@RequestParam String ngayTruyCap) {
        return truyCapService.allViewTrongNgay(ngayTruyCap);
    }

    @PostMapping()
    public Map<String, Object> create(@RequestBody TruyCapDto truyCapDto) {
        return truyCapService.create(truyCapDto);
    }


}
